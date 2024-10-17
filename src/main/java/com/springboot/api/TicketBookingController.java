package com.springboot.api;

import com.springboot.dto.TicketDto;
import com.springboot.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
@RequiredArgsConstructor
public class TicketBookingController {

    private final IUserService userService;

    @PostMapping
    public TicketDto purchaseTicket(@RequestBody TicketDto ticketDto){
        return userService.purchaseTicket(ticketDto);
    }
}
