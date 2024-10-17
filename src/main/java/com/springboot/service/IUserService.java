package com.springboot.service;

import com.springboot.dto.TicketDto;

public interface IUserService {
    TicketDto purchaseTicket(TicketDto ticketDto);
}
