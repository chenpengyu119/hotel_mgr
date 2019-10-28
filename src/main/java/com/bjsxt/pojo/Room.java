package com.bjsxt.pojo;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author pengyu
 * @date 2019/10/18 10:24.
 */
@Entity(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private int type;

    @Column
    private Double price;

    @Column
    private String info;


    @ManyToOne()
    @JoinColumn(name = "hid")
    private Hotel hotel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
