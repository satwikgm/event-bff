package com.eventBff.controller.ticketBooking;

import com.eventBff.dto.ticketBooking.BffReserveTicketRequest;
import com.eventBff.dto.ticketBooking.BffReserveTicketResponse;
import com.eventBff.service.ticketBooking.TicketBookingService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Controller("/api/tickets")
@RequiredArgsConstructor
public class TicketBookingBffController {

    private final TicketBookingService ticketBookingService;

    @Post("/reserve")
    public Mono<BffReserveTicketResponse> reserveTicket(@Body BffReserveTicketRequest request) {
        return ticketBookingService.reserveTicket(request);
    }
}
