package homework2.fabric.fabrics;

import homework2.fabric.items.GameItem;
import homework2.fabric.items.Gem;

/**
 * класс для генерации алмазов
 */
public class GemGenerator extends ItemGenerator{
    /**
     * генерируем награду в виде алмазов
     * @return
     */
    @Override
    public GameItem gameItemGenerate() {
        return new Gem();
    }
}
