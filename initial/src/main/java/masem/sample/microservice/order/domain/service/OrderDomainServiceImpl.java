package masem.sample.microservice.order.domain.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import masem.sample.microservice.order.dto.CustomerRequest;
import masem.sample.microservice.order.entity.Order;
import masem.sample.microservice.order.exception.SystemException;
import masem.sample.microservice.order.repository.OrderRepository;

@Service
public class OrderDomainServiceImpl implements OrderDomainService{
	
	@Autowired
	OrderRepository orderRepository;
	
	@Override
	@Transactional
	public Order create(OrderCreateCmd input) {
				
		Order order = new Order();
		order.createOrder();
		BeanUtils.copyProperties(input, order);
		
		Order entity = orderRepository.save(order);
		
		return entity;
	}

	@Override
	public Order statusUpdate(OrderUpdateCmd input) {
		
		Order order = getOrderOne(input.getOrderId());
		
		if(input.getResult().equals("true")) {
			order.progressStatus();
		}else {
			order.failStatus();
		}
		
		orderRepository.save(order);
		
		return order;
	}
	
	public Order getOrderOne(String orderId) {
		Optional<Order> record = Optional.ofNullable(orderRepository.findById(orderId)
				.orElseThrow(() -> new SystemException()));
		Order order = record.get();
		
		return order;
	}

}
