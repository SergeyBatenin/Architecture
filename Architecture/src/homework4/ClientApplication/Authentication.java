//package ClientApplication;
//
//import Core.UserProvider;
//import Models.User;
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
     * @param login     nickname пользователя
     * @param passHash  hash пароля
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
