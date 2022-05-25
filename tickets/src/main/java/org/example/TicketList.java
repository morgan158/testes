package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class TicketList implements Serializable{
    @JsonProperty("tickets")
    private List<Tickets> tickets;

    public List<Tickets> getTickets() {
        return tickets;
    }
}
