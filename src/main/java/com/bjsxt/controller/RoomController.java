package com.bjsxt.controller;

import com.bjsxt.dto.RoomDto;
import com.bjsxt.pojo.HotelResult;
import com.bjsxt.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author pengyu
 * @date 2019/10/18 10:48.
 */
@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    /**
     * 显示所有房间
     * @param model
     * @return
     */
    @RequestMapping("/show")
    public String showRoomList(Model model){
        model.addAttribute("rooms", roomService.showRoomList());
        return "index";
    }

    /**
     * 获取酒店信息
     * @param model
     * @return
     */
    @RequestMapping("/showAdd")
    public String showAddRoom(Model model){

        model.addAttribute("hotels", roomService.showRoomAdd());
        return "add_room";
    }

    /**
     * 根据id删除房间
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public HotelResult delRoom(@PathVariable("id") int id){
        try {
            return roomService.deleteRoomById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return HotelResult.error(e.getMessage());
        }
    }

    /**
     * 条件查询房间和酒店信息
     * @param name
     * @return
     */

    @PostMapping("/find/{name}")
    @ResponseBody
    public HotelResult findByName(@PathVariable("name") String name){
        System.out.println("name:"+name);
        return roomService.findByName(name);
    }


    @RequestMapping("/doAdd")
    public String doAdd(RoomDto roomDto){

        try {
            roomService.addRoom(roomDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/room/show";
    }

}
