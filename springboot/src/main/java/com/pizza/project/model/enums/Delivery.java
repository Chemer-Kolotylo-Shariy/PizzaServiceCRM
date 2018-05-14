package com.pizza.project.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum Delivery {
    DELIVERY_MYSELF(1, "DELIVERY_MYSELF"),
    DELIVERY_COURIER(2, "DELIVERY_COURIER");

    public int id;
    public String delivery;

    private static Map<Integer, Delivery> map = new HashMap<>();

    static {

        for (Delivery legEnum : Delivery.values()) {
            if (map.put(legEnum.getId(), legEnum) != null) {
                throw new IllegalArgumentException("duplicate id: " + legEnum.getId());
            }
        }
    }

    Delivery(int i, String delivery_myself) {}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

//    public static Delivery valueOf(Integer id) {
//        map.put(1, DELIVERY_MYSELF);
//        map.put(2, DELIVERY_COURIER);
//        return map.get(id);
//    }
    public static Delivery getById(Long id) {
        return map.get(id);
    }
}
