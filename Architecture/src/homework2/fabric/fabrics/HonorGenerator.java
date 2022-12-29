package homework2.fabric.fabrics;

import homework2.fabric.items.GameItem;
import homework2.fabric.items.Honor;

/**
 * класс для генерации очков чести
 */
public class HonorGenerator extends ItemGenerator{
    /**
     * генерируем награду в виде очков чести
     * @return
     */
    @Override
    public GameItem gameItemGenerate() {
        return new Honor();
    }
}
