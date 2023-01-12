//package Services;
//
//import Interfaces.IUserRepo;
//import Models.User;
package homework4.Services;

import homework4.Interfaces.IUserRepo;
import homework4.Models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс репозиторий для имитации работы с базой данных
 */
public class UserRepository implements IUserRepo {
    private static UserRepository clientRepository;
    private List<User> clients;

    private UserRepository() {
        //имитация работы базы клиентов
        clients = new ArrayList<>();
        clients.add(new User(1, "Ivan", "1111".hashCode(), 1111));
        clients.add(new User(2, "Vasiliy", "2222".hashCode(), 2222));
        clients.add(new User(3, "Fedor", "3333".hashCode(), 3333));
        clients.add(new User(4, "Grigoriy", "4444".hashCode(), 4444));
    }

    public static UserRepository getClientRepository() {
        if (clientRepository == null) {
            clientRepository = new UserRepository();
        }
        return clientRepository;
    }

    @Override
    public int create(String userName, int passwordHash, long cardNumber) throws RuntimeException {
        int id = clients.size() + 1;
        User client = new User(id, userName, passwordHash, cardNumber);
        for (User currentClient : clients) {
            if (currentClient.getUserName().equals(client.getUserName())) {
                throw new RuntimeException("A client already exists");
            }
        }
        clients.add(client);
        return client.getId();
    }

    @Override
    public User read(int id) throws RuntimeException {
        for (User client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        throw new RuntimeException("User with this ID was not found");
    }

    @Override
    public User read(String userName) throws RuntimeException {
        for (User client : clients) {
            String clientName = client.getUserName();
            if (clientName.equals(userName)) {
                return client;
            }
        }
        throw new RuntimeException("User with this LOGIN was not found");
    }

    @Override
    public List<User> readAll() throws RuntimeException {
        if (clients.isEmpty()) {
            throw new RuntimeException("List of clients is empty");
        }
        return clients;
    }

    @Override
    public boolean update(User client) {
        User tempClient = null;
        for (User currentClient : clients) {
            if (currentClient.getId() == client.getId()) {
                clients.remove(currentClient);
                clients.add(client);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(User client) {
        for (User currentClient : clients) {
            if (currentClient.equals(client)) {
                clients.remove(currentClient);
                return true;
            }
        }
        return false;
    }
}
