package homework1.ModelElements;

import java.util.ArrayList;
import java.util.List;

public class PoligonalModel {
    public List<Poligon> poligons; // 1..* composition
    public List<Texture> textures; // 0..* aggregation

    /**
     * Конструктор
     * @param textures
     */
    public PoligonalModel(List<Texture> textures) {
        this.textures = textures;
        poligons = new ArrayList<>();
    }
}
