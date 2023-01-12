//package ClientApplication;
//
//import Core.Customer;
//import Interfaces.ICustomer;
//import Models.Ticket;
package homework4.ClientApplication;

import homework4.Core.Customer;
import homework4.Interfaces.ICustomer;
import homework4.Models.Ticket;

import java.util.Date;
import java.util.List;

/**
 * Основной класс клиентского приложения.
 */
public class Start extends EnterData {
    // Частая строка при выводе при взаимодействии с сервисом
    private final String DEFAULT_HELLO_MESSAGE = "This is a test version. The data base is not available in full mode.";

    // Установка цвета для вывода ошибок в консоль красным цветом
    public static final String ERROR_COLOR = "\u001B[31m"; // This color is Red

    // Возврат к стандартному цвету вывода в консоль
    public static final String ANSI_RESET = "\u001B[0m";

    // Связь с основной логикой осуществляется через интерфейс ICustomer.
    private ICustomer customer;
    private int ticketRouteNumber;
    private Date ticketDate;

    /**
     * Стартовый метод запуска меню входа и регистрации
     */
    public void runLoginRegisterMenu() {
        boolean run = true;
        while (run) {
            printMessageLine("Application for buying bus tickets");
            printMessageLine(DEFAULT_HELLO_MESSAGE);
            printMessageLine("To login\t\t\tenter 1\nTo register\t\t\tenter 2\nTo exit\t\t\t\tenter 0");
            System.out.print("Enter your choice > ");
            int choice = 0;
            try {
                choice = inputInt(0, 2);
            } catch (RuntimeException ex) {
                printMessageError(ex.getMessage());
                continue;
            }
            printDelimiterLine();
            run = runLoginRegisterMenuChoiceLogic(choice);
        }
    }

    /**
     * Логика ветвления запуска программы
     *
     * @param choice выбор пользователя для действия
     * @return
     */
    private boolean runLoginRegisterMenuChoiceLogic(int choice) {
        switch (choice) {
            case 1:
                login();
                if (customer == null) {
                    break;
                } else {
                    runBuyingMenu();
                    break;
                }
            case 2:
                register();
                if (customer == null) {
                    break;
                } else {
                    runBuyingMenu();
                    break;
                }
            default:
                printMessageLine("Goodbye! We will be glad to see you again");
                return false;
        }
        return true;
    }

    /**
     * Меню входа зарегестрированного пользователя
     */
    private void login() {
        printMessageLine(DEFAULT_HELLO_MESSAGE);
        printMessageLine("Login");
        System.out.print("User name: ");
        String userName = inputString();
        System.out.print("Password: ");
        int passwordHash = inputString().hashCode();
        printDelimiterLine();
        System.out.print("Enter the system... ");
        customer = new Customer();
        try {
            customer.setUser(Authentication.authentication(customer.getUserProvider(), userName, passwordHash));
        } catch (RuntimeException ex) {
            customer = null;
            printMessageError("FAIL");
            printMessageError(ex.getMessage());
            printDelimiterLine();
            return;
        }
        printMessageLine("OK");
    }

    /**
     * Меню регистрации нового пользователя
     */
    private void register() {
        printMessageLine(DEFAULT_HELLO_MESSAGE);
        printMessageLine("Register");
        System.out.print("Enter user name: ");
        String userName = inputString();
        System.out.print("Enter password: ");
        int passwordHash = inputString().hashCode();
        System.out.print("Repeat password: ");
        int passwordHash2 = inputString().hashCode();
        if (passwordHash != passwordHash2) {
            printDelimiterLine();
            printMessageError("Passwords do not match. Exit register.");
            return;
        }
        System.out.print("Enter card number: ");
        long cardNumber;
        try {
            cardNumber = inputLong(1L, 9999_9999_9999_9999L);
        } catch (RuntimeException ex) {
            printMessageError(ex.getMessage());
            printDelimiterLine();
            return;
        }
        printDelimiterLine();
        System.out.print("Register the system... ");
        customer = new Customer();
        int id;
        try {
            id = customer.getUserProvider().createClient(userName, passwordHash, cardNumber);
            customer.setUser(Authentication.authentication(customer.getUserProvider(), userName, passwordHash));
        } catch (RuntimeException ex) {
            customer = null;
            printMessageError("FAIL");
            printMessageError(ex.getMessage());
            printDelimiterLine();
            return;
        }
        printMessageLine("OK. User " + "\u001B[32m" + customer.getUser().getUserName() + ANSI_RESET + " with ID " + id + " added to base.");
    }

    /**
     * Меню покупки билетов
     */
    private void runBuyingMenu() {
        boolean run = true;
        while (run) {
            printMessageLine("Application for buying bus tickets. | User " + customer.getUser().getUserName() + " |");
            printMessageLine("To select route number and print all tickets\tenter 1\n" +
                    "To logout\t\t\t\t\t\t\t\t\t\tenter 0");
            System.out.print("Enter your choice > ");
            int choice = 0;
            try {
                choice = inputInt(0, 1);
            } catch (RuntimeException ex) {
                printDelimiterLine();
                printMessageError(ex.getMessage());
                continue;
            }
            printDelimiterLine();
            run = runBuyingMenuChoiceLogic(choice);
        }
        customer = null;
    }

    /**
     * Логика ветвления меню покупки билетов
     *
     * @param choice выбор пользователя для действия
     * @return
     */
    private boolean runBuyingMenuChoiceLogic(int choice) {
        switch (choice) {
            case 1:
                ticketRouteNumber = runSelectRouteMenu();
                if (ticketRouteNumber > 0) {
                    ticketDate = runSelectDate();
                    System.out.println("\u001B[32m" + "TicketDate равно NULl?? -> " + (ticketDate == null) + ANSI_RESET);
                    if (ticketDate != null) {
                        try {
                            customer.setSelectedTickets(customer.searchTicket(ticketDate, ticketRouteNumber));
                        } catch (RuntimeException ex) {
                            printMessageError(ex.getMessage());
                            return true;
                        }
                        printAllTickets(customer.getSelectedTickets());
                        buyTicketMenu();
                    }
                }
                return true;
            default:
                return false;
        }
    }

    /**
     * Метод ввода номера маршрута
     *
     * @return номер маршрута
     */
    private int runSelectRouteMenu() {
        // Временная подсказка для тестирования
        System.out.println("HINT* Для тестирования доступны маршруты №1 и №2");
        printMessageLine("Input route number and date. | User " + customer.getUser().getUserName() + " |");
        System.out.print("Route number > ");
        //Здесь ограничиваем число маршрутов. У наc всего 2 маршрута.
        int numRoute;
        try {
            numRoute = inputInt(1, 2);
        } catch (RuntimeException ex) {
            printMessageError(ex.getMessage());
            printDelimiterLine();
            return -1;
        }
        printDelimiterLine();
        return numRoute;
    }

    /**
     * Метод ввода даты поездки
     *
     * @return дата поездки
     */
    private Date runSelectDate() {
        // Временная подсказка для тестирования
        System.out.println("HINT* Доступные даты для тестирования 2023-01-13, 2023-01-14");
        System.out.print("Date (format: YYYY-MM-DD) > ");
        Date date;
        try {
            date = inputDate();
        } catch (RuntimeException ex) {
            printMessageError(ex.getMessage());
            printDelimiterLine();
            return null;
        }
        printDelimiterLine();
        return date;
    }

    /**
     * Метод вывода в консоль списка подходящих по дате и маршоруту билетов
     *
     * @param tickets список билетов
     */
    private void printAllTickets(List<Ticket> tickets) {
        for (Ticket ticket : tickets) {
            System.out.println(ticket.toString());
        }
        printDelimiterLine();
    }

    /**
     * Метод покупки билета
     */
    private void buyTicketMenu() {
        printMessageLine("Confirm to buy. | User " + customer.getUser().getUserName() + " |");
        System.out.print("To buy a ticket for bus route " + ticketRouteNumber + " on the " + ticketDate + " enter" +
                " \"Yes\" > ");
        String answer = inputString();
        printDelimiterLine();
        buyTicketMenuConfirmLogic(answer);
    }

    /**
     * Логика ветвления меню подтверждения покупки
     *
     * @param answer
     */
    private void buyTicketMenuConfirmLogic(String answer) {
        if (answer.equalsIgnoreCase("YES")) {
            for (Ticket ticket : customer.getSelectedTickets()) {
                if (ticket.getDate().equals(ticketDate) && ticket.getRouteNumber() == ticketRouteNumber && ticket.getValid()) {
                    boolean flag;
                    try {
                        flag = customer.buyTicket(ticket);
                    } catch (RuntimeException ex) {
                        printMessageError(ex.getMessage());
                        return;
                    }
                    if (flag) {
                        System.out.println("You have purchased a ticket:");
                        printMessageLine(ticket.toPrint());
                        return;
                    }
                }
            }
        }
    }

    /**
     * Метод вывода в консоль элемента сообщения
     *
     * @param message
     */
    private void printMessageLine(String message) {
        System.out.println(message);
        printDelimiterLine();
    }
    private void printMessageError(String message) {
        System.out.println(ERROR_COLOR + message + ANSI_RESET);
    }
    private void printDelimiterLine() {
        System.out.println("=====================================================================================");
    }
}
