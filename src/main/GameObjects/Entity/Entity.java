package main.GameObjects.Entity;

import main.GameObjects.AbstractGameObject;
import main.Physics.Vector2;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Entity {
    public AbstractGameObject AbstractGameObject;

    public Vector2 Position;
    public Vector2 Size;
    public Vector2 Speed;
    Rectangle hitBox;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    public String[] animations = new String[7];

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Entity(AbstractGameObject abstractGameObject, Vector2 Position, Vector2 Size, Vector2 Speed) {
        this.AbstractGameObject = abstractGameObject;
        this.Position = Position;
        this.Size = Size;
        this.Speed = Speed;
        this.hitBox = new Rectangle((int)Position.x, (int)Position.y, (int)Size.x, (int)Size.y);
    }

    public void addAnimations(String[] animations) {
        this.animations = animations;
        this.getImage();
    }
    
    private void getImage() {
        try {
            if (animations != null && animations.length > 0) {
            	System.out.println("started");
                up1 = ImageIO.read(getClass().getResourceAsStream(animations[0]));
                up2 = ImageIO.read(getClass().getResourceAsStream(animations[1]));
                down1 = ImageIO.read(getClass().getResourceAsStream(animations[2]));
                down2 = ImageIO.read(getClass().getResourceAsStream(animations[3]));
                left1 = ImageIO.read(getClass().getResourceAsStream(animations[4]));
                left2 = ImageIO.read(getClass().getResourceAsStream(animations[5]));
                right1 = ImageIO.read(getClass().getResourceAsStream(animations[6]));
                right2 = ImageIO.read(getClass().getResourceAsStream(animations[7]));
                System.out.println("ended");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
