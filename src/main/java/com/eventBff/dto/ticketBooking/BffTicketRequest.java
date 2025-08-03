package com.eventBff.dto.ticketBooking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BffTicketRequest {
    private String eventId;
    private String userId;
    private String seatNumber;    // not seatNumber
    private Double price;  // not price and Double
    private String promotionCode;
}
