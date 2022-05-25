package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CalculateTicketsUtil {
    public void averageTimeFly(List<Tickets> tickets) {
        var result = getListTimeOfFly(tickets).stream().mapToLong(s -> s).average().orElse(0);
        long avg = (long) result/1000/60;

        System.out.println("Среднее время полета между Владивостоком и Тель-Авивом составляет " + avg/60 + " часов " + avg%60 + " минут");
    }

    public void calcPercentile(List<Tickets> tickets) {
        List<Long> timeFlyOfTickets = getListTimeOfFly(tickets).stream().sorted().collect(Collectors.toList());
        var index =  (int) Math.ceil(90.0/100.0*timeFlyOfTickets.size());
        var timeFly90Percentile = timeFlyOfTickets.get(index-1)/60000;
        System.out.println("90-й процентиль составляет " + timeFly90Percentile/60 + " часов и " + timeFly90Percentile%60 + " минут");
    }

    protected List<Long> getListTimeOfFly(List<Tickets> tickets) {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyHH:mm");
        return tickets.stream().mapToLong(ticket ->{
                    long timeOfFlyInMillisecond = 0L;
                    try {
                        Date arrivalTime = formatDate.parse(ticket.getArrivalDate() + ticket.getArrivalTime());
                        Date destinationTime = formatDate.parse(ticket.getDepartureDate() + ticket.getDepartureTime());
                        timeOfFlyInMillisecond = arrivalTime.getTime() - destinationTime.getTime();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return timeOfFlyInMillisecond;
                }).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
}
