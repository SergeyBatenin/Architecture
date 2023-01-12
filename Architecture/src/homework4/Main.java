package homework4;

import homework4.ClientApplication.Start;
import homework4.Services.CashRepository;

// ВАЖНО!!! При запуске в новом проекте раскомментировать импорты и пакеты в классах
public class Main {
    public static void main(String[] args) {
        Start start = new Start();
        start.runLoginRegisterMenu();
    }
}