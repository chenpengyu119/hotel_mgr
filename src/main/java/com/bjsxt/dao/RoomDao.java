package com.bjsxt.dao;

import com.bjsxt.dto.RoomDto;
import com.bjsxt.pojo.Room;
import org.hibernate.validator.constraints.EAN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author pengyu
 * @date 2019/10/18 10:29.
 */
public interface RoomDao extends JpaRepository<Room,Integer> {


    /**
     * 联合查询room
     * @param hotelName
     * @return
     */
    @Query(value = "select new com.bjsxt.dto.RoomDto(r.id,r.type,r.price,r.info,h.hid,h.name,h.address,h.mobile" +
            ") from com.bjsxt.pojo.Room r inner join r.hotel h where h.name like :hotelName")
    List<RoomDto> findRoomByHotelName(@Param("hotelName") String hotelName);
}
