package com.pizza.project.RestController;

import com.pizza.project.model.Order;
import com.pizza.project.model.OrderProduct;
import com.pizza.project.model.json.OrderJson;
import com.pizza.project.model.json.OrderStatus;
import com.pizza.project.service.OrderProductService;
import com.pizza.project.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.FileHandler;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OrderRestController {

    private OrderService orderService;
    private OrderProductService orderProductService;
    FileHandler fh;
    public static final Logger logger1 = LoggerFactory.getLogger(OrderRestController.class);

    @Autowired
    public OrderRestController(OrderService orderService, OrderProductService orderProductService) {
        this.orderService = orderService;
        this.orderProductService = orderProductService;
    }


    @PostMapping
    @RequestMapping(value = "/order", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long createOrder(@RequestBody OrderJson order){
        System.out.println(order.toString());
        logger1.info(order.toString());
        return orderService.create(order);
    }

    @RequestMapping(value = "/order/status/{status}", method = RequestMethod.GET)
    public List<Order> showOrderByStatus(@PathVariable("status")String status){
         return orderService.getOrdersByStatus(status);
    }

    @RequestMapping(value = "/orderproduct/status/{status}", method = RequestMethod.GET)
    public List<OrderProduct> showOrderProductByStatus(@PathVariable("status")String status){
        return orderProductService.getAllByOrderStatus(status);
    }

    @RequestMapping(value = "/order/put/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long updateStatus(@RequestBody OrderStatus order){
        return orderService.changeStatus(order.getId(), order.getStatusId());
    }
}
