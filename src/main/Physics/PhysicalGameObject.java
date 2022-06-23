package main.Physics;

import main.GameObjects.AbstractGameObject;
import main.Scene;

import java.awt.*;

public class PhysicalGameObject {
    private final AbstractGameObject AbstractGameObject;
    public String type;
    public Vector2 Position;
    public Vector2 Size;
    public Color color;
    public boolean fill;
    public boolean Anchored;
    public boolean canCollide = true;
    public Rectangle hitBox;
    public boolean visible;

    public PhysicalGameObject(AbstractGameObject abstractGameObject) {
        this.AbstractGameObject = abstractGameObject;
        this.type = "rect";
        this.Position = new Vector2();
        this.Size = new Vector2(50, 50);
        this.color = Color.white;
        this.fill = true;
        this.Anchored = false;
        this.visible = true;

        this.hitBox = new Rectangle((int)Position.x, (int)Position.y, (int)Size.x, (int)Size.y);
        this.AbstractGameObject.scene.addPhysicalGameObject(this);
    }

    public PhysicalGameObject(AbstractGameObject abstractGameObject, Vector2 Position, Vector2 Size) {
        this.AbstractGameObject = abstractGameObject;
        this.type = "rect";
        this.Position = Position;
        this.Size = Size;
        this.color = Color.white;
        this.fill = true;
        this.Anchored = false;
        this.visible = true;

        this.hitBox = new Rectangle((int)Position.x, (int)Position.y, (int)Size.x, (int)Size.y);
        this.AbstractGameObject.scene.addPhysicalGameObject(this);
    }

    public PhysicalGameObject(AbstractGameObject abstractGameObject, String type, Vector2 originPos, Vector2 size, Color color, boolean fill, boolean Anchored, boolean visible) {
        this.AbstractGameObject = abstractGameObject;
        this.type = type;
        this.Position = originPos;
        this.Size = size;
        this.color = color;
        this.fill = fill;
        this.Anchored = Anchored;
        this.visible = visible;

        this.hitBox = new Rectangle((int)Position.x, (int)Position.y , (int) Size.x, (int) Size.y);
        this.AbstractGameObject.scene.addPhysicalGameObject(this);
    }

    public PhysicalGameObject(String Name, String[] tags, String type, Scene scene, Vector2 originPos, Vector2 size, Color color, boolean fill, boolean Anchored, boolean visible) {
        this.AbstractGameObject = new AbstractGameObject("PhysicalGameObject", "Name", tags, scene);
        this.type = type;
        this.Position = originPos;
        this.Size = size;
        this.color = color;
        this.fill = fill;
        this.Anchored = Anchored;
        this.visible = visible;

        this.hitBox = new Rectangle((int)Position.x, (int)Position.y , (int) Size.x, (int) Size.y);
        this.AbstractGameObject.scene.addPhysicalGameObject(this);
    }

    public PhysicalGameObject(String Name, String type, Scene scene, Vector2 originPos, Vector2 size, Color color, boolean fill, boolean Anchored, boolean visible) {
        this.AbstractGameObject = new AbstractGameObject("PhysicalGameObject", Name, scene);
        this.type = type;
        this.Position = originPos;
        this.Size = size;
        this.color = color;
        this.fill = fill;
        this.Anchored = Anchored;
        this.visible = visible;

        this.hitBox = new Rectangle((int)Position.x, (int)Position.y , (int) Size.x, (int) Size.y);
        this.AbstractGameObject.scene.addPhysicalGameObject(this);
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.AbstractGameObject.Name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return this.AbstractGameObject.Name;
    }

    public void setScene(Scene scene) {
        this.AbstractGameObject.scene.removePhysicalGameObject(this);
        scene.addPhysicalGameObject(this);
    }

    public void draw(Graphics2D gtd) {
        if (visible == false) return;
        gtd.setColor(color);

        if (fill) {
            switch (type) {
                case "rect":
                    gtd.fillRect((int)Position.x, (int)Position.y, (int)Size.x, (int)Size.y);
                    break;
                case "circle":
                    gtd.fillOval((int)Position.x, (int)Position.y, (int)Size.x, (int)Size.y);
                    break;
                case "roundRect":
                    gtd.fillRoundRect((int)Position.x, (int)Position.y, (int)Size.x, (int)Size.y, 20, 20);
                    break;
            }
        } else {
            switch (type) {
                case "rect":
                    gtd.drawRect((int)Position.x, (int)Position.y, (int)Size.x, (int)Size.y);
                    break;
                case "circle":
                    gtd.drawOval((int)Position.x, (int)Position.y, (int)Size.x, (int)Size.y);
                    break;
                case "roundRect":
                    gtd.drawRoundRect((int)Position.x, (int)Position.y, (int)Size.x, (int)Size.y, 20, 20);
                    break;
            }
        }
    }

    public void update() {

    }

}
