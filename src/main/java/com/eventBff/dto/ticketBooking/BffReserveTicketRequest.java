package com.eventBff.dto.ticketBooking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BffReserveTicketRequest {

    private String eventId;
    private String userId;
    private String seat;    // not seatNumber
    private String amount;  // not price and Double
    private String promotionCode;
}
