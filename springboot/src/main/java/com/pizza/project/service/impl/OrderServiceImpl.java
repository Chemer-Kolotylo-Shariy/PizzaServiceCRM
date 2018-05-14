package com.pizza.project.service.impl;

import com.pizza.project.dao.*;
import com.pizza.project.model.*;
import com.pizza.project.model.enums.Delivery;
import com.pizza.project.model.enums.OrderStatus;
import com.pizza.project.model.enums.Role;
import com.pizza.project.model.json.OrderJson;
import com.pizza.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    private PaymentDao paymentDao;
    private OrderDao orderDao;
    private ClientDao clientDao;
    private AddressDao addressDao;
    private OrderProductDao orderProduct;


    private DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private DateFormat timeFormat = new SimpleDateFormat("HH:mm");
    private Calendar date;
    private Client client;
    private Address address;

//    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//    Calendar cal = Calendar.getInstance();
//System.out.println(dateFormat.format(cal)); //2016/11/16 12:08:43

    @Autowired
    public OrderServiceImpl(OrderDao orderDao, ClientDao clientDao, AddressDao addressDao, PaymentDao paymentDao, OrderProductDao orderProduct) {
        this.orderDao = orderDao;
        this.clientDao = clientDao;
        this.addressDao = addressDao;
        this.paymentDao = paymentDao;
        this.orderProduct = orderProduct;
    }

    @Transactional
    @Override
    public Long create(OrderJson order) {
        Order o = new Order();
        o.setPrice(order.getPrice());
        o.setPayment(paymentDao.get(order.getPayment()));
        o.setDelivery(order.getDelivery());
        o.setDate(dateFormat.format(new Date()));
        o.setTime(timeFormat.format(new Date()));
        o.setOrderStatus(OrderStatus.CLIENT_CONFIR);
//        Long id = orderService.create(new Order(null, null, null, 34.00, null, paymentDao.get(1), Delivery.DELIVERY_MYSELF, new Client("Andrii", null, null, Long.parseLong("537778445"), null, null), new Address("dob", "213", 23, null)));
        Long idUser;
        Long idAddress;

        try{
            client = clientDao.getByPhone(Long.parseLong(order.getPhone()));
            if (client != null){
                o.getClient().setId(client.getId());
            } else{
                throw new Exception("User does not exist!");
            }
        }catch (Exception ex){
            Client newClient = new Client();
            newClient.setName(order.getName());
            newClient.setPhone(Long.parseLong(order.getPhone()));
            newClient.setRole(Role.ROLE_KLIENT);

            idUser = clientDao.create(newClient);
            System.out.println(idUser);
            newClient.setId(idUser);
            o.setClient(newClient);

            o.getClient().setId(idUser);
            ex.printStackTrace();
        } finally {
            try{
                address = addressDao.get(order.getStreet(), order.getHouse().toString(), Integer.parseInt(order.getFlat()));
                if (address != null){
                    o.setAddress(address);
                } else{
                    throw new Exception("Address does not exist!");
                }
            }catch (Exception ex){
                Address a = new Address(order.getStreet(), order.getHouse().toString(), Integer.parseInt(order.getFlat()), null);
                idAddress = addressDao.create(a);
                a.setId(idAddress);
                o.setAddress(a);
                ex.printStackTrace();
            } finally {
                Long id = orderDao.create(o);

                for (int i = 0; i < order.getProducts().size(); i++) {
                    OrderProduct op = new OrderProduct(new Order(id), new Product(order.getProducts().get(i).getId()), order.getProducts().get(i).getQuantity());
                    orderProduct.create(op);
                }
                return id;
            }
        }
    }

    @Transactional
    @Override
    public Long changeStatus(Integer id, Integer status) {
        return orderDao.changeStatus(id, status);
    }

    @Transactional
    @Override
    public List<Order> getOrdersByStatus(String status) {
        return orderDao.getByStatus(status);
    }
}
