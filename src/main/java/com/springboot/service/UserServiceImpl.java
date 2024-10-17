package com.springboot.service;

import com.springboot.dto.TicketDto;
import com.springboot.entity.Payment;
import com.springboot.entity.User;
import com.springboot.repository.PaymentRepository;
import com.springboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final PaymentRepository paymentRepository;

    @Override
    public TicketDto purchaseTicket(TicketDto ticketDto) {

        User user = new User();
        user.setUsername(ticketDto.user().getUsername());
        user.setPassword(ticketDto.user().getPassword());
        user.setPhoneNumber(ticketDto.user().getPhoneNumber());

        User savedUser = userRepository.save(user);

        Payment payment = new Payment();
        payment.setAmount(ticketDto.payment().getAmount());
        payment.setPaid(true);
        payment.setUserId(savedUser.getUserId());

        Payment savedPayment = paymentRepository.save(payment);

        return new TicketDto(savedPayment, savedUser);

    }
}
