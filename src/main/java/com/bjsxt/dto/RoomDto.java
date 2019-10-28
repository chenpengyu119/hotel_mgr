package com.bjsxt.dto;

import com.bjsxt.pojo.Room;

import javax.persistence.Column;

/**
 * @author pengyu
 * @date 2019/10/18 15:03.
 */
public class RoomDto{

    private Integer id;

    private int type;

    private Double price;

    private String info;


    /**
     * 下面是hotel的属性
     */
    private Integer hid;

    private String name;

    private String address;

    private String mobile;

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

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public RoomDto(Integer id, int type, Double price, String info, Integer hid, String name, String address, String mobile) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.info = info;
        this.hid = hid;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
    }
}
