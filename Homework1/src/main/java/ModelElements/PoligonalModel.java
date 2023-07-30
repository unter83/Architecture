package ModelElements;

public class PoligonalModel {
    public Poligon Poligons;
    public Texture Texture;

    public PoligonalModel(Point3D points) {
       this.Poligons = new Poligon(points);
    }
}
