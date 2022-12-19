package homework1.ModelElements;

import homework1.Entity.Point3D;

import java.util.ArrayList;
import java.util.List;

public class Poligon {
    public List<Point3D> points;

    /**
     * конструктор по умолчанию
     */
    public Poligon() {
        this.points = new ArrayList<>();
    }
    /**
     * Конструктор с списком точек
     * @param points
     */
    public Poligon(List<Point3D> points) {
        this.points = points;
    }
}
