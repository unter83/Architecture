package InMemoryModel;


public class ModelStore implements ImodelChanger {
    public PolygonalModel Models;
    public Scene Scenes;
    public Flash Flashes;
    public Camera Cameras;
    private IModelChangeObserver changeObservers;

    public Scene GetScena(int value) {
        return Scenes;
    }

    public void NotifyChange(IModelChangeObserver varaible) {

    }

}