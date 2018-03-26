package com.pizza.project.RestController;

import com.pizza.project.model.json.OrderJson;
import com.pizza.project.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.logging.FileHandler;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OrderRestController {

    private OrderService orderService;
    FileHandler fh;
    public static final Logger logger1 = LoggerFactory.getLogger(OrderRestController.class);

    @Autowired
    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping
    @RequestMapping(value = "/order", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long createOrder(@RequestBody OrderJson order){
        System.out.println(order.toString());
        logger1.info(order.toString());
        return orderService.create(order);
    }
}
