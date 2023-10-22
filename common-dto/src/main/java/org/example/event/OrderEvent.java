package org.example.event;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.OrderRequestDto;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Data
public class OrderEvent implements Event{

    private UUID eventId= UUID.randomUUID();

    private Date currentDate= new Date();
    OrderRequestDto orderRequestDto;

    OrderStatus orderStatus;


    @Override
    public UUID getEventId() {
        return eventId;
    }

    @Override
    public Date getDate() {
        return currentDate;
    }

    public OrderEvent(OrderRequestDto orderRequestDto, OrderStatus orderStatus) {
        this.orderRequestDto = orderRequestDto;
        this.orderStatus = orderStatus;
    }
}
