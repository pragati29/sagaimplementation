package org.example.event;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.PaymentRequestDto;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Data
public class PaymentEvent implements Event {

    private UUID eventId= UUID.randomUUID();

    private Date currentDate= new Date();

   private PaymentRequestDto paymentRequestDto;
   private PaymentStatus paymentStatus;

    @Override
    public UUID getEventId() {
        return eventId;
    }

    @Override
    public Date getDate() {
        return currentDate;
    }

    public PaymentEvent(PaymentRequestDto paymentRequestDto, PaymentStatus paymentStatus) {
        this.paymentRequestDto = paymentRequestDto;
        this.paymentStatus = paymentStatus;
    }
}
