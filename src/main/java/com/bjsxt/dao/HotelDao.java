package com.bjsxt.dao;

import com.bjsxt.pojo.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author pengyu
 * @date 2019/10/18 10:29.
 */
public interface HotelDao extends JpaRepository<Hotel,Integer> {
}
