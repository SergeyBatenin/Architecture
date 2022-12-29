package homework2.fabric.fabrics;

import homework2.fabric.items.GameItem;
import homework2.fabric.items.Gold;

/**
 * класс для генерации золота
 */
public class GoldGenerator extends ItemGenerator{
    /**
     * генерируем награду в виде золота
     * @return
     */
    @Override
    public GameItem gameItemGenerate() {
        return new Gold();
    }
}
