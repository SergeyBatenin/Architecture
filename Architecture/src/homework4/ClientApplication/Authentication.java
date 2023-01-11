package homework4.ClientApplication;

import homework4.Core.UserProvider;
import homework4.Models.User;

/**
 * Класс аутентификации пользователя
 */
public class Authentication {
    /**
     * Метод производит аутентификацию
     *
     * @param userProvider
     * @param login
     * @param passHash
     * @return
     */
    public static User authentication(UserProvider userProvider, String login, int passHash) {
        User client = userProvider.getClientByName(login);
        if (client.getHashPassword() == passHash) {
            return client;
        } else {
            throw new RuntimeException("Authentication failed");
        }
    }
}
