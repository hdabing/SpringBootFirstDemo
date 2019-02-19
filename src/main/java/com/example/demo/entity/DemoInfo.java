package com.example.demo.entity;

import javax.persistence.*;

@Table(name = "demo_info")
public class DemoInfo {
    /**
     * id
     */
    @Id
    private String id;

    /**
     * 名字
     */
    private String name;

    /**
     * 获取id
     *
     * @return id - id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取名字
     *
     * @return name - 名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名字
     *
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}