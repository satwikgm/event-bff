package com.eventBff.service.ticketBooking;

import com.eventBff.client.ticketBooking.TicketServiceClient;
import com.eventBff.dto.ticketBooking.BffReserveTicketRequest;
import com.eventBff.dto.ticketBooking.BffReserveTicketResponse;
import com.eventBff.mappers.ticketBooking.TicketMapper;
import com.ticket.booking.model.ReserveTicketRequest;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Singleton
@RequiredArgsConstructor
public class TicketBookingService {

    private final TicketServiceClient ticketServiceClient;
    private final TicketMapper ticketMapper;

    public Mono<BffReserveTicketResponse> reserveTicket(BffReserveTicketRequest bffRequest) {
        ReserveTicketRequest reserveTicketRequest = ticketMapper.toReserveServiceRequest(bffRequest);
        return ticketServiceClient.reserveTicket(reserveTicketRequest)
                .map(ticketMapper::toBffReserveServiceResponse);
    }
}
