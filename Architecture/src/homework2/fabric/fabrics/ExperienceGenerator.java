package homework2.fabric.fabrics;

import homework2.fabric.items.Experience;
import homework2.fabric.items.GameItem;

/**
 * класс для генерации опыта
 */
public class ExperienceGenerator extends ItemGenerator{
    /**
     * генерируем награду в виде игрового опыта
     * @return
     */
    @Override
    public GameItem gameItemGenerate() {
        return new Experience();
    }
}
