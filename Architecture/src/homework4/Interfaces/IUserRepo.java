//package Interfaces;
//
//import Models.User;
package homework4.Interfaces;

import homework4.Models.User;

import java.util.List;

/**
 * Интерфейс взаимодействия с базой клиентов
 */
public interface IUserRepo {
    /**
     * Создать нового пользователя
     *
     * @param userName  nickname пользователя
     * @param passwordHash  hash пароля пользователя
     * @param cardNumber    номер карты
     * @return  id пользователя
     */
    int create(String userName, int passwordHash, long cardNumber);

    /**
     * получить пользователя по ID (для тестов, в приложении не используется)
     *
     * @param id
     * @return
     */
    User read(int id);

    /**
     * Получить пользователя по имени
     *
     * @param userName nickname пользователя
     * @return найденный пользователь
     */
    User read(String userName);

    /**
     * Получить список пользователей (для тестов, в приложении не используется)
     *
     * @return
     */
    List<User> readAll();

    /**
     * Обновить пользователя (для тестов, в приложении не используется)
     *
     * @param client
     * @return
     */
    boolean update(User client);

    /**
     * Удалить пользователя (для тестов, в приложении не используется)
     *
     * @param client
     * @return
     */
    boolean delete(User client);
}
