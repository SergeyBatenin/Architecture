package homework2.fabric.fabrics;

import homework2.fabric.items.GameItem;
import homework2.fabric.items.SkillPoint;

/**
 * класс для генерации очков навыков
 */
public class SkillPointGenerator extends ItemGenerator{
    /**
     * генерируем награду в виде очков навыков
     * @return
     */
    @Override
    public GameItem gameItemGenerate() {
        return new SkillPoint();
    }
}
