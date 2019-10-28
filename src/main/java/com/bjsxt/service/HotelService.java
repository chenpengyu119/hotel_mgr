package com.bjsxt.service;

import com.bjsxt.pojo.Hotel;

import java.util.List;

/**
 * @author pengyu
 * @date 2019/10/18 10:30.
 */
public interface HotelService {

    /**
     * 查询所有酒店信息
     * @return
     */
    List<Hotel> findAll();

}
