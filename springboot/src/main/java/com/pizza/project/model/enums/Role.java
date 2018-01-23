package com.pizza.project.model.enums;

public enum Role {
    ROLE_KLIENT(1, "ROLE_KLIENT"),
    ROLE_MANAGER(2, "ROLE_MANAGER"),
    ROLE_ADMIN(3, "ROLE_ADMIN"),
    ROLE_CHEF(4, "ROLE_CHEF"),
    ROLE_COURIER(5, "ROLE_COURIER");

    private Integer id;
    private String role;

    Role(Integer id, String name) {
        this.id = id;
        this.role = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return role;
    }

    public void setName(String name) {
        this.role = name;
    }
}
