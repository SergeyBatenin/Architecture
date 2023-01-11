package homework4.Core;

import homework4.Interfaces.ICustomer;
import homework4.Models.Ticket;
import homework4.Models.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Класс, содержащий основную логику покупки билетов
 */
public class Customer implements ICustomer {
    private TicketProvider ticketProvider;
    private CashProvider cashProvider;
    private UserProvider userProvider;
    private User client;
    private List<Ticket> selectedTickets;

    /**
     * Конструктор класса
     */
    public Customer() {
        //Здесь создаются экземпляры классов работы с базами данных
        //Так как при уничтожении класса Customer нам больше не нужны экземпляры классов - провайдеров,
        //было решено организовать композицию с классами - провайдерами.
        this.ticketProvider = new TicketProvider();
        this.cashProvider = new CashProvider();
        this.userProvider = new UserProvider();
    }

    @Override
    public List<Ticket> getSelectedTickets() {
        return selectedTickets;
    }

    @Override
    public void setSelectedTickets(List<Ticket> selectedTickets) {
        this.selectedTickets = selectedTickets;
    }

    @Override
    public UserProvider getUserProvider() {
        return userProvider;
    }

    @Override
    public User getUser() {
        return client;
    }

    @Override
    public void setUser(User client) {
        this.client = client;
    }

    /**
     * Метод покупки билета
     *
     * @param ticket билет
     * @return
     * @throws RuntimeException
     */
    @Override
    public boolean buyTicket(Ticket ticket) throws RuntimeException {
        boolean flag;
        cashProvider.authorization(client);
        flag = cashProvider.buy(ticket);
        if (flag) {
            flag = ticketProvider.updateTicketStatus(ticket);
        }
        return flag;
    }

    /**
     * Метод поиска билета на конкретную дату и маршрут
     *
     * @param date  дата
     * @param route номер маршрута
     * @return  список доступных билетов
     * @throws RuntimeException
     */
    @Override
    public List<Ticket> searchTicket(Date date, int route) throws RuntimeException {
        List<Ticket> result = new ArrayList<>();
        List<Ticket> list = ticketProvider.getTickets(route);
        for (Ticket ticket : list) {
            if (ticket.getDate().equals(date)) {
                result.add(ticket);
            }
        }
        if (result.isEmpty()) {
            throw new RuntimeException("There are no tickets for this date");
        }
        return result;
    }
}
