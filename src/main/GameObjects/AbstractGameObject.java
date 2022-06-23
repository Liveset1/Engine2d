package main.GameObjects;

import main.Physics.PhysicalGameObject;
import main.Scene;

public class AbstractGameObject {
    public String Name;
    public String[] tags;
    public Scene scene;

    public AbstractGameObject(String classType, String Name, Scene scene) {
        this.Name = Name;
        this.scene = scene;
    }

    public AbstractGameObject(String classType, String Name, String[] tags, Scene scene) {
        this.Name = Name;
        this.tags = tags;
        this.scene = scene;
    }

    public String getName() {
        return Name;
    }
}
