package com.example.bookmyshow.services;

import com.example.bookmyshow.exceptions.ShowSeatNotAvailableException;
import com.example.bookmyshow.models.*;
import com.example.bookmyshow.repositories.ShowRepository;
import com.example.bookmyshow.repositories.ShowSeatRepository;
import com.example.bookmyshow.repositories.TicketRepository;
import com.example.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private ShowSeatRepository showSeatRepository;
    private TicketRepository ticketRepository;
    private UserRepository userRepository;
    private ShowRepository showRepository;

    @Autowired
    public TicketService(ShowSeatRepository showSeatRepository,TicketRepository ticketRepository,UserRepository userRepository)
    {
        this.showSeatRepository = showSeatRepository;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Long> showSeatIds,Long userId,Long showId) throws ShowSeatNotAvailableException
    {
        List<ShowSeat> showSeats = showSeatRepository.findAllByIdIn(showSeatIds);

        for(ShowSeat showSeat: showSeats)
        {
            if(!showSeat.getState().equals(ShowSeatState.AVAILABLE))
            {
                throw new ShowSeatNotAvailableException(showSeat.getId());
            }
        }

        for(ShowSeat showSeat: showSeats)
        {
            showSeat.setState(ShowSeatState.LOCKED);
            showSeatRepository.save(showSeat);
        }

        Ticket ticket = new Ticket();

        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty())
        {
            //throw error - user not found
        }
        ticket.setTicketStatus(TicketStatus.PENDING);
        ticket.setBookBy(userOptional.get());
        ticket.setShow(showRepository.findById(showId).get());
        ticket.setShowSeats(showSeats);
        ticket.setTimeOfBooking(new Date());

        return ticketRepository.save(ticket);
    }
}
