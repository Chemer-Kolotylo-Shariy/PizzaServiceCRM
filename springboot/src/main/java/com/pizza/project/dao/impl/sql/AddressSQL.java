package com.pizza.project.dao.impl.sql;

public class AddressSQL {
    public static final String PARAM_TABLE = "address";
    public static final String PARAM_ID = "id";
    public static final String PARAM_LABLE = "lable";
    public static final String PARAM_STREET = "street";
    public static final String PARAM_HOUSE = "house";
    public static final String PARAM_APARTAMENT = "apartament";

    public static final String QUERY_GET_BY_ID = "SELECT id, lable, street, house, apartament " +
            "FROM address " +
            "WHERE id = :id;";

}
