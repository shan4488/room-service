package com.bits.scalable.api.hotel.room.controller;
import com.bits.scalable.api.hotel.room.dto.RoomRequestDTO;
import com.bits.scalable.api.hotel.room.entity.Room;
import com.bits.scalable.api.hotel.room.entity.RoomType;
import com.bits.scalable.api.hotel.room.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author I583856
 * @date 15/11/24
 */


@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/add")
    public Room addRoom(@RequestBody RoomRequestDTO roomRequestDTO) {
        return roomService.addRoom(roomRequestDTO.getHotelId(), roomRequestDTO.getRoomType());
    }

    // Update room types for a given hotel ID
    @PutMapping("/updateRoomTypes/{hotelId}")
    public Room updateRoomTypesByHotelId(
            @PathVariable String hotelId,
            @RequestBody List<RoomType> roomTypes) {
        return roomService.updateRoomTypesByHotelId(hotelId, roomTypes);
    }

    @GetMapping("/{hotelId}")
    public List<Room> getRoomsByHotelId(@PathVariable String hotelId) {
        return roomService.getRoomsByHotelId(hotelId);
    }

}

