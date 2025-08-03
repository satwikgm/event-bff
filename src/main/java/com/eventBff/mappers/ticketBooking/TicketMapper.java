package com.eventBff.mappers.ticketBooking;

import com.eventBff.dto.ticketBooking.BffTicketRequest;
import com.eventBff.dto.ticketBooking.BffTicketResponse;
import com.ticket.booking.model.ReserveTicketRequest;
import com.ticket.booking.model.TicketReserveResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "jsr330")
public interface TicketMapper {

//    @Mapping(target = "seatNumber", source = "seat")
//    @Mapping(target = "price", source = "amount")
    ReserveTicketRequest toReserveServiceRequest(BffTicketRequest request);

//    @Mapping(target = "bookingStatus", source = "status")
    BffTicketResponse toBffReserveServiceResponse(TicketReserveResponse reserveResponse);
}
