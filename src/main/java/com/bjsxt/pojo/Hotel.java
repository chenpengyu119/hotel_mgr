package com.bjsxt.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pengyu
 * @date 2019/10/18 10:21.
 */
@Entity(name = "hotel")
public class Hotel {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hid;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String mobile;

    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms = new ArrayList<>();

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

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
