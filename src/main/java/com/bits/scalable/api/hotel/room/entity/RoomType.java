package com.bits.scalable.api.hotel.room.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author I583856
 * @date 15/11/24
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
public class RoomType {
    private String name;
    private double price;
    private int availabilityCount;
}
