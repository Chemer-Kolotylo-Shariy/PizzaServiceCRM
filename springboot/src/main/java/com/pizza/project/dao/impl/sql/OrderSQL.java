package com.pizza.project.dao.impl.sql;

public class OrderSQL {
    public static final String PARAM_TABLE = "\"order\"";
    public static final String PARAM_ID = "id";
    public static final String PARAM_DATE = "date";
    public static final String PARAM_TIME = "time";
    public static final String PARAM_PRICE = "price";
    public static final String PARAM_ID_ORDER_STATUS = "id_order_status";
    public static final String PARAM_ID_PAYMENT = "id_payment";
    public static final String PARAM_ID_DELIVERY = "id_delivery";
    public static final String PARAM_ID_CLIENT = "id_client";
    public static final String PARAM_ID_ADDRESS = "id_address";
    public static final String PARAM_ORDER_STATUS = "status";
    public static final String PARAM_DELIVERY = "delivery";

    public static final String QUERY_GET_BY_ID = "SELECT o.id, o.price, s.status, " +
            "o.id_payment, d.delivery, o.id_client, o.id_address, o.date, o.time, o.id_delivery " +
            "FROM \"order\" o " +
            "INNER JOIN order_status s " +
            "ON o.id_order_status = s.id " +
            "INNER JOIN payment p " +
            "ON o.id_payment = p.id " +
            "INNER JOIN delivery d " +
            "ON o.id_delivery = d.id " +
            "INNER JOIN client c " +
            "ON o.id_client = c.id " +
            "INNER JOIN address a " +
            "ON o.id_address = a.id " +
            "WHERE o.id = :id;";

    public static final String QUERY_GET_ALL_BY_STATUS = "SELECT o.id, o.price, s.status, " +
            "o.id_payment, d.delivery, o.id_client, o.id_address, o.date, o.time, o.id_delivery " +
            "FROM \"order\" o " +
            "INNER JOIN order_status s " +
            "ON o.id_order_status = s.id " +
            "INNER JOIN payment p " +
            "ON o.id_payment = p.id " +
            "INNER JOIN delivery d " +
            "ON o.id_delivery = d.id " +
            "INNER JOIN client c " +
            "ON o.id_client = c.id " +
            "INNER JOIN address a " +
            "ON o.id_address = a.id " +
            "WHERE s.status = :status;";

    public static final String QUERY_UPDATE_BY_ID = "UPDATE \"order\" SET id_order_status = :id_order_status WHERE id = :id";


    public static final String QUERY_UPDATE = "UPDATE \"order\" " +
            "price = :price, " +
            "id_order_status = :id_order_status, " +
            "id_payment = :id_payment, " +
            "id_delivery = :id_delivery, " +
            "id_client = :id_client, " +
            "id_address = :id_address, " +
            "date = :date, " +
            "time = :time " +
            "WHERE id = :id;";

    public static final String QUERY_INSERT_INTO = "INSERT INTO \"order\" " +
            "(id ,price, id_order_status, id_payment, id_delivery,  id_client, id_address, date, time) VALUES " +
            "(nextval(pg_get_serial_sequence('\"order\"','id')), :price, :id_order_status, :id_payment, :id_delivery, :id_client, :id_address, :date, :time);";


    public static final String QUERY_DELETE_BY_ID_AND_STATUS_CLIENT = "DELETE FROM \"order\" WHERE id_order_status = 5 AND id = :id;";

    public static final String QUERY_DELETE_BY_ID_AND_STATUS_ADMIN = "DELETE FROM \"order\" WHERE id_order_status = 1 AND id = :id;";

}
