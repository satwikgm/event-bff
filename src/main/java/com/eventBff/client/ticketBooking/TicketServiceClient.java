package com.eventBff.client.ticketBooking;

import com.ticket.booking.model.*;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import reactor.core.publisher.Mono;

@Client(id = "ticket-client")
public interface TicketServiceClient {

    @Get("tickets/event/{eventId}/seat/{seatNumber}/availability")
    Mono<SeatAvailabilityResponse> getSeatAvailability(@PathVariable String eventId, @PathVariable String seatNumber);

    @Post("tickets/reserve")
    Mono<TicketReserveResponse> reserveTicket(@Body ReserveTicketRequest reserveTicketRequest);

    @Post("tickets/confirm")
    Mono<TicketConfirmResponse> confirmTicket(@Body ConfirmTicketReq confirmTicketReq);
}
