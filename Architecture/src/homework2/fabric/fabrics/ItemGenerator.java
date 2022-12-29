package homework2.fabric.fabrics;

import homework2.fabric.items.GameItem;

/**
 * Родоначальный класс для наших фабрик
 */
public abstract class ItemGenerator {
    /**
     * метод генерации наших игровых предметов
     * @return
     */
    public abstract GameItem gameItemGenerate();
    public void getReward() {
        /**
         * генерируем наш игровой предмет и получаем награду
         */
        GameItem gameItem = gameItemGenerate();
        gameItem.open();
    }

}
