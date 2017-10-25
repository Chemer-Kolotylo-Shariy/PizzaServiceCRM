package com.pizza.project.model.enums;

public enum Size {

    SIZE_L(1, "SIZE_L"),
    SIZE_M(2, "SIZE_M"),
    SIZE_S(3, "SIZE_S"),
    SIZE_UNIVERSAL(4, "SIZE_UNIVERSAL"),
    SIZE_1_L(5, "SIZE_1_L"),
    SIZE_05_L(6, "SIZE_05_L");

    private Integer id;
    private String name;

    Size(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
