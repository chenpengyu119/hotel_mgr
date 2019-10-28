package com.bjsxt.service.impl;

import com.bjsxt.dao.HotelDao;
import com.bjsxt.pojo.Hotel;
import com.bjsxt.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pengyu
 * @date 2019/10/18 10:31.
 */
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelDao hotelDao;

    @Override
    public List<Hotel> findAll() {
        return hotelDao.findAll();
    }
}
