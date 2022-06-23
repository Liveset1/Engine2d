package main.GameObjects;

import main.Physics.PhysicalGameObject;
import main.Physics.Vector2;
import main.Scene;

public class CameraObject {

    private final AbstractGameObject AbstractGameObject;
    public Vector2 Position;
    private PhysicalGameObject subject;

    public CameraObject(AbstractGameObject abstractGameObject, Vector2 originPos) {
        this.AbstractGameObject = abstractGameObject;
        this.Position = originPos;
        this.AbstractGameObject.scene.addCameraObject(this);
    }

    public CameraObject(String Name, String[] tags, Scene scene, Vector2 originPos) {
        this.AbstractGameObject = new AbstractGameObject("CameraObject", Name, tags, scene);
        this.Position = originPos;
        this.AbstractGameObject.scene.addCameraObject(this);
    }

    public CameraObject(String Name, Scene scene, Vector2 originPos) {
        this.AbstractGameObject = new AbstractGameObject("CameraObject", Name, scene);
        this.Position = originPos;
        this.AbstractGameObject.scene.addCameraObject(this);
    }

//    public void setSubject(PhysicalGameObject object) {
//        this.subject = object;
//    }
//
//    public void setSubject() {
//        this.subject = this.AbstractGameObject.scene.getPlayerObjects().get(0);
//    }
//
//    public void update() {
//        if (this.subject != null) {
//            Position.x = subject.Position.x;
//            Position.y = subject.Position.y;
//        }
//    }
}
