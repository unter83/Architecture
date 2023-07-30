package ModelElements;

import java.awt.*;

public class Poligon {
    public Point3D Points;

    public Poligon(Point3D Points) {
       this.Points = Points;
       PoligonalModel poligon = new PoligonalModel(Points);
    }
}
