package main.GameObjects.tile;

import main.GameObjects.AbstractGameObject;
import main.Physics.Vector2;
import main.Scene;

import java.awt.image.BufferedImage;

public class Tile {
    private final AbstractGameObject AbstractGameObejct;
    public String imageDir;
    private BufferedImage image;
    public boolean collision = false;

    public Vector2 Position;
    public Vector2 Size;

    public Tile(AbstractGameObject abstractGameObject, Vector2 Position, Vector2 Size, String imageDir) {
        this.AbstractGameObejct = abstractGameObject;
        this.Position = Position;
        this.Size = Size;
        this.imageDir = imageDir;
    }

    public Tile(String Name, String[] tags, Scene scene, Vector2 Position, Vector2 Size, String imageDir) {
        this.AbstractGameObejct = new AbstractGameObject("tiles", Name, tags, scene);
        this.Position = Position;
        this.Size = Size;
        this.imageDir = imageDir;
    }

    public Tile(String Name, Scene scene, Vector2 Position, Vector2 Size, String imageDir) {
        this.AbstractGameObejct = new AbstractGameObject("tiles", Name, scene);
        this.Position = Position;
        this.Size = Size;
        this.imageDir = imageDir;
    }

    public BufferedImage getImage() {
        return image;
    }

    public String getName() {
       return this.AbstractGameObejct.getName();
    }

    public int getTileSize() {
        return this.AbstractGameObejct.scene.getTileSize();
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
