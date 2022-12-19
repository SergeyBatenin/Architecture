package homework1.ModelElements;

import homework1.Entity.Type;

import java.util.List;

public class Scene {
    public int id;
    public List<PoligonalModel> models; // 1 .. * aggregation
    public List<Flash> flashes; // 0 .. * aggregation
    public List<Camera> cameras; // 1 .. * aggregation

    /**
     * Конструктор с Моделями и Камерами
     * @param models
     * @param cameras
     */
    public Scene(List<PoligonalModel> models, List<Camera> cameras) {
        this.models = models;
        this.cameras = cameras;
        // Так как агрегация правильно ли оставить flashes = null?
        // Или все равно передавать какой то пустой список?
        // Если указать что
        // flashes = new ArrayList<>();
        // то это будет уже все таки нарушением схемы, так как это
        // будет уже композиция, а не агрегация
    }

    /**
     * Констркутор с 3 списками(Моделей, Освещения, Камер)
     * @param models
     * @param flashes
     * @param cameras
     */
    public Scene(List<PoligonalModel> models, List<Flash> flashes, List<Camera> cameras) {
        this.models = models;
        this.flashes = flashes;
        this.cameras = cameras;
    }

    /**
     * Устанавливаем/изменяем освещение на сцене
     * @param flashes
     */
    public void setFlash(List<Flash> flashes) {
        this.flashes = flashes;
    }

    /**
     * Устанавливаем/изменяем модели на сцене
     * @param models
     */
    public void setModels(List<PoligonalModel> models) {
        this.models = models;
    }

    /**
     * Устанавливаем/изменяем камеры на сцене
     * @param cameras
     */
    public void setCameras(List<Camera> cameras) {
        this.cameras = cameras;
    }

    // Заглушка
    public Type method1(Type type) {
        return null;
    }
    // Заглушка
    public Type method2(Type type1, Type type2) {
        return null;
    }
}
