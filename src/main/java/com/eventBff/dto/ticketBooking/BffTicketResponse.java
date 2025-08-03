package com.eventBff.dto.ticketBooking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BffTicketResponse {
    private String ticketId;
    private String status; // not status
    private String message;
    private String eventId;
}
