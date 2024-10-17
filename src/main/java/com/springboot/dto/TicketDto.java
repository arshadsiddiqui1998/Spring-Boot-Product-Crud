package com.springboot.dto;

import com.springboot.entity.Payment;
import com.springboot.entity.User;
import lombok.Builder;

@Builder
public record TicketDto(Payment payment, User user) {
}
