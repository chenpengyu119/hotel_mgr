package com.bjsxt.service.impl;

import com.bjsxt.dao.HotelDao;
import com.bjsxt.dao.RoomDao;
import com.bjsxt.dto.RoomDto;
import com.bjsxt.pojo.Hotel;
import com.bjsxt.pojo.HotelResult;
import com.bjsxt.pojo.Room;
import com.bjsxt.service.HotelService;
import com.bjsxt.service.RoomService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengyu
 * @date 2019/10/18 10:31.
 */
@Service
public class RoomServiceImpl implements RoomService {


    @Autowired
    private RoomDao roomDao;
    @Autowired
    private HotelDao hotelDao;

    @Autowired
    private HotelService hotelService;

    @Override
    public List<Room> showRoomList() {
       return roomDao.findAll();
    }

    @Override
    public List<Hotel> showRoomAdd() {
        return hotelService.findAll();
    }

    @Override
    public HotelResult deleteRoomById(int id) {
        System.out.println("删除");
         roomDao.deleteById(id);
         return HotelResult.ok();
    }

    @Override
    public HotelResult findByName(String name) {

        name = "%"+name+"%";

        List<Room> roomList = new ArrayList<>();
        List<RoomDto> roomDtoList = roomDao.findRoomByHotelName(name);
        for (RoomDto dto:roomDtoList){
            Room room = new Room();
            BeanUtils.copyProperties(dto,room);
            Hotel hotel = new Hotel();
            BeanUtils.copyProperties(dto, hotel);
            room.setHotel(hotel);
            roomList.add(room);
        }

        return HotelResult.ok(roomList);
    }

    @Override
    public int addRoom(RoomDto roomDto) {

        Room room = new Room();
        BeanUtils.copyProperties(roomDto, room);
        Hotel hotel = new Hotel();
        hotel.setHid(roomDto.getHid());
        room.setHotel(hotel);
        roomDao.save(room);
        return 1;
    }
}
