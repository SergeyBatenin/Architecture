//package Services;
//
//import Interfaces.ITicketRepo;
//import Models.Ticket;
package homework4.Services;

import homework4.Interfaces.ITicketRepo;
import homework4.Models.Ticket;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Класс репозиторий для имитации работы с базой данных
 */
public class TicketRepository implements ITicketRepo {
    private static TicketRepository ticketRepository;
    private List<Ticket> tickets;

    private TicketRepository() {
        //здесь симуляция работы с БД
        tickets = new ArrayList<>();
        String strDate1 = "2023-01-13";
        String strDate2 = "2023-01-14";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1;
        Date date2;
        try {
            date1 = sdf.parse(strDate1);
            date2 = sdf.parse(strDate2);
        } catch (Exception ex) {
            date1 = new Date();
            date2 = new Date();
        }
        // Генерация билетов для маршрутов №1, №2 на одну дату
        generateTickets(1, 6, 10, date1);
        generateTickets(2, 4, 15, date1);
        // Генерация билетов для маршрутов №1, №2 на другую дату
        generateTickets(1, 6, 10, date2);
        generateTickets(2, 4, 15, date2);
    }

    public static TicketRepository getTicketRepository() {
        if (ticketRepository == null) {
            ticketRepository = new TicketRepository();
        }
        return ticketRepository;
    }

    @Override
    public boolean create(Ticket ticket) {
        //функционал не используется
        tickets.add(ticket);
        return true;
    }

    /**
     * Метод получения списка билетов по номеру маршрута
     * @param routeNumber   номер маршрута
     * @return  список доступных билетов
     * @throws RuntimeException если билетов не найдено
     */
    @Override
    public List<Ticket> readAll(int routeNumber) throws RuntimeException {
        List<Ticket> routeTickets = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getRouteNumber() == routeNumber && ticket.getValid()) {
                routeTickets.add(ticket);
            }
        }
        if (routeTickets.isEmpty()) {   // ??? Нужна ли эта проверка? На текущий момент данной ситуации быть не может
            throw new RuntimeException("There are no tickets for this bus.");
        }
        return routeTickets;
    }

    @Override
    public boolean update(Ticket ticket) {
        for (Ticket tick : tickets) {
            if (tick.equals(ticket)) {
                tickets.remove(tick);
                ticket.setValid(false);
                tickets.add(ticket);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Ticket ticket) {
        //функционал не используется
        if (tickets.contains(ticket)) {
            tickets.remove(ticket);
            return true;
        }
        return false;
    }

    private void generateTickets(int routeNumber, int countPlaces, int price, Date date) {
        for (int i = 1; i <= countPlaces; i++) {
            tickets.add(new Ticket(routeNumber, i, price, date, true));
        }
    }
}
