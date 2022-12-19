package homework1.InMemoryModel;

import homework1.ModelElements.Camera;
import homework1.ModelElements.Flash;
import homework1.ModelElements.PoligonalModel;
import homework1.ModelElements.Scene;

import java.util.ArrayList;
import java.util.List;

public class ModelStore implements IModelChanger{
    public List<PoligonalModel> models;
    public List<Scene> scenes;
    public List<Flash> fleshes;
    public List<Camera> cameras;
    private List<IModelChangedObserver> changeObservers;

    /**
     * Конструктор
     */
    public ModelStore() {
        models = new ArrayList<>();
        scenes = new ArrayList<>();
        fleshes = new ArrayList<>();
        cameras = new ArrayList<>();
        changeObservers = new ArrayList<>();
    }

    /**
     * Метод получения сцены по ее номеру(индексу)
     * @param index
     * @return
     */
    public Scene getScene(int index) {
        return scenes.get(index);
    }

    /**
     * Реализация интерфейса
     * @param sender
     */
    @Override
    public void notifyChange(IModelChanger sender) {

    }
}
