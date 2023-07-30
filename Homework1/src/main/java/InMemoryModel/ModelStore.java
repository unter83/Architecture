package InMemoryModel;


import ModelElements.Camera;
import ModelElements.Flash;
import ModelElements.PoligonalModel;
import ModelElements.Scene;

public class ModelStore implements ImodelChanger {
    public PoligonalModel Models;
    public Scene Scenes;
    public Flash Flashes;
    public Camera Cameras;
    private IModelChangedObserver changeObservers;

    public ModelStore() {
        this.Scenes = new Scene();
        this.Flashes = new Flash();
        this.Cameras = new Camera();
        this.Models = new PoligonalModel();
    }

    public Scene GetScena(int value) {
        return Scenes;
    }

    public void NotifyChange(IModelChangedObserver varaible) {

    }

}