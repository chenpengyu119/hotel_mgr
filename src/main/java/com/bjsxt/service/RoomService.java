package com.bjsxt.service;

import com.bjsxt.dto.RoomDto;
import com.bjsxt.pojo.Hotel;
import com.bjsxt.pojo.HotelResult;
import com.bjsxt.pojo.Room;
import org.hibernate.validator.constraints.EAN;

import java.util.List;

/**
 * @author pengyu
 * @date 2019/10/18 10:31.
 */
public interface RoomService {

    /**
     * 获取所有room集合
     * @return
     */
    List<Room> showRoomList();

    /**
     * 显示room添加页面
     * @return
     */
    List<Hotel> showRoomAdd();

    /**
     * 根据id删除房间
     * @param id
     * @return
     */
    HotelResult deleteRoomById(int id);

    /**
     * 根据酒店名称模糊查询
     * @param name
     * @return
     */
    HotelResult findByName(String name);

    /**
     * 添加房间信息
     * @param roomDto
     * @return
     */
    int addRoom(RoomDto roomDto);
}
