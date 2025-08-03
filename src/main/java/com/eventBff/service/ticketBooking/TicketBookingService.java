package com.eventBff.service.ticketBooking;

import com.eventBff.client.ticketBooking.TicketServiceClient;
import com.eventBff.dto.ticketBooking.BffTicketRequest;
import com.eventBff.dto.ticketBooking.BffTicketResponse;
import com.ticket.booking.model.ConfirmTicketReq;
import com.ticket.booking.model.ReserveTicketRequest;
import com.ticket.booking.model.TicketReserveResponse;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Singleton
@RequiredArgsConstructor
public class TicketBookingService {

    private final TicketServiceClient ticketClient;

    public Mono<BffTicketResponse> reserveAndConfirm(BffTicketRequest request) {
        ReserveTicketRequest reserveRequest = new ReserveTicketRequest()
                .eventId(request.getEventId())
                .userId(request.getUserId())
                .seatNumber(request.getSeatNumber())
                .price(request.getPrice())
                .promotionCode(request.getPromotionCode());

        return ticketClient.reserveTicket(reserveRequest)
                .onErrorResume(reserveError ->
                        Mono.just(new TicketReserveResponse()
                                .status("FAILED")
                                .message("Reservation Failed: " + reserveError.getMessage())
                                ))
                .flatMap(reserveResponse -> {
                    // Proceed to confirm only if reserve succeeded
                    ConfirmTicketReq confirmRequest = new ConfirmTicketReq()
                            .eventId(request.getEventId())
                            .seatNumber(request.getSeatNumber())
                            .userId(request.getUserId())
                            .price(request.getPrice())
                            .promotionCode(request.getPromotionCode());

                    return ticketClient.confirmTicket(confirmRequest)
                            .map(confirmResponse -> BffTicketResponse.builder()
                                    .ticketId(confirmResponse.getTicketId())
                                    .status(confirmResponse.getStatus())
                                    .message("Booking Confirmed")
                                    .build());
                })
                .onErrorResume(e ->
                        Mono.just(BffTicketResponse.builder()
                                .status("FAILED")
                                .message("Confirmation failed: " + e.getMessage())
                                .build())
                );
    }
}
