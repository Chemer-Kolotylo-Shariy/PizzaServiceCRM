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

    public static final String QUERY_GET_ADDRESS_BY_CLIENT_ID_AND_LABLE_NOT_NULL = "" +
            "SELECT a.id, street, house, apartament, lable " +
            "FROM address a " +
            "INNER JOIN client_address c " +
            "ON a.id = c.id_address " +
            "WHERE lable IS NOT NULL AND c.id_client = :id_client";

}
