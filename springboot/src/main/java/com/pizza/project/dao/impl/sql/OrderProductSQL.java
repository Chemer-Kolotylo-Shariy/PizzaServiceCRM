package com.pizza.project.dao.impl.sql;

public class OrderProductSQL {
    public static final String PARAM_TABLE = "order_product";
    public static final String PARAM_ID_ORDER = "id_order";
    public static final String PARAM_ID_PRODUCT = "id_product";
    public static final String PARAM_COUNT_PRODUCT = "count_product";
    public static final String PARAM_STATUS_ORDER = "status";

//    public static final String QUERY_GET_ALL = "SELECT id_order, id_product, count_product " +
//            "FROM order_product z " +
//            "INNER JOIN \"order\" o " +
//            "ON o.id = z.id_order " +
//            "INNER JOIN product p " +
//            "ON p.id = z.id_product " +
//            "INNER JOIN order_status s " +
//            "ON s.id = o.id_order_status" +
//            "WHERE z.id_order ";

    public static final String QUERY_GET_ALL_BY_ID_ORDER = "SELECT id_order, id_product, count_product " +
        "FROM order_product " +
        "WHERE id_order = :id_order;";

    public static final String QUERY_GET_ALL_BY_STATUS = "SELECT id_order, id_product, count_product " +
            "FROM order_product i " +
            "INNER JOIN \"order\" o " +
            "ON i.id_order = o.id " +
            "INNER JOIN order_status s " +
            "ON o.id_order_status = s.id " +
            "WHERE s.status = :status;";

    public static final String QUERY_BY_ID_ORDER_AND_ID_PRODUCT = "SELECT id_order, id_product, count_product " +
            "FROM order_product " +
            "WHERE id_order = :id_order, id_product = :id_product;";

        //public static final String QUERY_UPDATE = "UPDATE order_product  ";

        public static final String QUERY_DELETE_BY_ORDER_ID = "DELETE FROM order_product WHERE id_order = :id_order;";

        public static final String QUERY_INSERT_INTO = "INSERT INTO order_product (id_order, id_product, count_product)"  +
                " VALUES (:id_order, :id_product, :count_product);";

}
