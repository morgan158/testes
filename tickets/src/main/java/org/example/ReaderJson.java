package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.URL;
import java.util.List;

public class ReaderJson {

    protected List<Tickets> readJson(String path) throws IOException {
        try (BufferedInputStream inputStream = new BufferedInputStream(new URL(path).openStream());
             FileOutputStream fileOS = new FileOutputStream("tickets.json")) {
            byte data[] = new byte[1024];
            int byteContent;
            while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
                fileOS.write(data, 0, byteContent);
            }
        } catch (IOException e) {
            throw new FileNotFoundException("Файл перенесен или удален");
        }
        File json = new File("tickets.json");
        ObjectMapper objectMapper = new ObjectMapper();
        TicketList ticketList = objectMapper.readValue(json, TicketList.class);
        return ticketList.getTickets();
    }

}
