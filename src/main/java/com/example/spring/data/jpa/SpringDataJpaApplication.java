package com.example.spring.data.jpa;

import com.example.spring.data.jpa.entities.Order;
import com.example.spring.data.jpa.services.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
		OrderService service = (OrderService) context.getBean("orderService");
		Order order1 = new Order();
		//order1.setId(1L);
		order1.setTotalPrice(BigDecimal.TEN);
		order1.setTotalQuantity(2);
		order1.setEmail("abc123@abc.com");
		order1.setStatus(true);
		// The order object should be added in the db table - Insert query
		service.saveOrder(order1);

		Order order2 = new Order();
		//order2.setId(2L);
		order2.setTotalPrice(new BigDecimal(200));
		order2.setTotalQuantity(3);
		order2.setEmail("abc1234@abc.com");
		order2.setStatus(true);
		// The order object should be added in the db table - Insert query
		service.saveOrder(order2);

		Order order3 = new Order();
		//order3.setId(3L);
		order3.setTotalPrice(new BigDecimal(150));
		order3.setTotalQuantity(4);
		order3.setEmail("abc12345@abc.com");
		order3.setStatus(true);
		// The order object should be added in the db table - Insert query
		service.saveOrder(order3);

		Order order4 = new Order();
		//order4.setId(4L);
		order4.setTotalPrice(new BigDecimal(180));
		order4.setTotalQuantity(5);
		order4.setEmail("abc123456@abc.com");
		order4.setStatus(false);
		// The order object should be added in the db table - Insert query
		service.saveOrder(order4);

		Order order5 = new Order();
		//	order5.setId(5L);
		order5.setTotalPrice(new BigDecimal(250));
		order5.setTotalQuantity(7);
		order5.setEmail("abc1234567@abc.com");
		order5.setStatus(true);
		// The order object should be added in the db table - Insert query
		service.saveOrder(order5);


	}
}