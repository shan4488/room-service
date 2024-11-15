package com.bits.scalable.api.hotel.room.service;

import com.bits.scalable.api.hotel.room.entity.Room;
import com.bits.scalable.api.hotel.room.entity.RoomType;
import com.bits.scalable.api.hotel.room.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

/**
 * @author I583856
 * @date 15/11/24
 */

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    // Add room to the database (initial)
    // Add a new room
    public Room addRoom(String hotelId, List<RoomType> roomTypes) {
        // If roomTypes is null, initialize it as an empty list
        List<RoomType> types = roomTypes == null ? Collections.emptyList() : roomTypes;

        Room room = new Room(hotelId, types, LocalDate.now());
        return roomRepository.save(room);
    }

    public Room updateRoomTypesByHotelId(String hotelId, List<RoomType> roomTypes) {
        // Find the room linked to the given hotelId
        Room existingRoom = roomRepository.findByHotelId(hotelId)
                .stream()
                .findFirst() // Assuming one room entry per hotel
                .orElseThrow(() -> new RuntimeException("Room not found for hotelId: " + hotelId));

        // Update the room types
        existingRoom.setRoomType(roomTypes);
        return roomRepository.save(existingRoom);
    }

    public List<Room> getRoomsByHotelId(String hotelId) {
        return roomRepository.findByHotelId(hotelId);
    }
}

