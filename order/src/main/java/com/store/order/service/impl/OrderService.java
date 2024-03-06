package com.store.order.service.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.store.order.domain.Order;
import com.store.order.domain.OrderItem;
import com.store.order.repository.IOrdemItemRepository;
import com.store.order.repository.IOrderRepository;
import com.store.order.service.IOrderService;

@Service
public class OrderService extends GenericService<Order, Long, IOrderRepository> implements IOrderService {

	@Autowired
	private WebClient webClient; 
	
	@Autowired
	private IOrdemItemRepository ordemItemRepository;
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${exchange.name}")
    private String exchange;

    @Value("${routing.key}")
    private String routingKey;
	
	public OrderService(IOrderRepository repository) {
		super(repository);
	}
	
	@Override
	public void save(Order order) {
		
		this.webClient.get()
        .uri("/user/" + order.getUser_id())
        .accept(MediaType.APPLICATION_JSON)
        .exchangeToMono(response -> {
            if (response.statusCode().equals(HttpStatus.OK)) {
                
            	Order ord = repository.save(order);
            	
                for(OrderItem item: ord.getOrderItems()){
                    OrderItem orderItem = new OrderItem();

                    orderItem.setOrder(ord);
                    orderItem.setProduct_id(item.getProduct_id());

                    ordemItemRepository.save(orderItem);
                }

                this.sendNotification(ord);
                
                return response.toEntity(String.class);
            }
            else if(response.statusCode().equals(HttpStatus.NOT_FOUND)) {
                System.out.println("Não há usuário com esse ID");
                return response.toEntity(String.class);
            }else {
                return response.createError();
            }
        }).block();
	}

	private void sendNotification(Order order) {
		try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());

            String json = mapper.writeValueAsString(order);

            rabbitTemplate.convertAndSend(exchange, routingKey, json);
            
        }catch(JsonProcessingException e){}
		
	}
}