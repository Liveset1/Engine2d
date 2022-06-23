package main.GameObjects.Entity;

import main.GameObjects.AbstractGameObject;
import main.GameObjects.CameraObject;
import main.Physics.Vector2;
import main.Scene;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PlayerObject extends Entity {
    // Player inputs
    public boolean inputKeyUp;
    public boolean inputKeyDown;
    public boolean inputKeyRight;
    public boolean inputKeyLeft;

    public CameraObject camera;

    public PlayerObject(String Name, String[] tags, Scene scene, Vector2 position) {
        super(new AbstractGameObject("PlayerObject", Name, tags, scene), position, new Vector2(50f, 100f), new Vector2(5,5));
        this.camera = new CameraObject(new AbstractGameObject("CameraObject", "PlayerCamera", scene), new Vector2(400f,400f));
        setDefaultValues();
        this.AbstractGameObject.scene.addPlayerObject(this);
    }

    public PlayerObject(String Name, Scene scene, Vector2 position) {
        super(new AbstractGameObject("PlayerObject", Name, scene), position, new Vector2(50f, 100f), new Vector2(5,5));
        this.camera = new CameraObject(new AbstractGameObject("CameraObject","PlayerCamera", scene), new Vector2(400f, 300f));
        setDefaultValues();
        this.AbstractGameObject.scene.addPlayerObject(this);
    }

    public PlayerObject(String Name, String[] tags, Vector2 position, Vector2 size, Vector2 speed, CameraObject camera, Scene scene) {
        super(new AbstractGameObject("PlayerObject",Name, tags, scene), position, size, speed);
        this.camera = camera;
        setDefaultValues();
        this.AbstractGameObject.scene.addPlayerObject(this);
    }

    private void setDefaultValues() {
        direction = "down";
    }

    public void update() {
        if (inputKeyUp || inputKeyDown || inputKeyLeft || inputKeyRight) {
            spriteCounter++;
        }

        if (inputKeyUp) {
            direction = "up";
            Position.y -= Speed.y;
        } else if (inputKeyDown) {
            direction = "down";
            Position.y += Speed.y;
        } else if (inputKeyLeft) {
            direction = "left";
            Position.x -= Speed.x;
        } else if (inputKeyRight) {
            direction = "right";
            Position.x += Speed.x;
        }

        hitBox.x = (int) Position.x;
        hitBox.y = (int) Position.y;

        if (spriteCounter > 12) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }

    public void draw(Graphics2D gtd) {
        if (animations != null && animations.length > 0) {
            BufferedImage image = null;
            switch (direction) {
                case "up":
                    if (spriteNum == 1) {
                        image = up1;
                    } else if (spriteNum == 2){
                        image = up2;
                    }
                    break;
                case "down":
                    if (spriteNum == 1) {
                        image = down1;
                    } else if (spriteNum == 2){
                        image = down2;
                    }
                    break;
                case "left":
                    if (spriteNum == 1) {
                        image = left1;
                    } else if (spriteNum == 2) {
                        image = left2;
                    }
                    break;
                case "right":
                    if (spriteNum == 1) {
                        image = right1;
                    } else if (spriteNum == 2) {
                        image = right2;
                    }
                    break;
            }
            gtd.drawImage(image, (int)Position.x, (int)Position.y, this.AbstractGameObject.scene.getTileSize(), this.AbstractGameObject.scene.getTileSize(), null);
        } else {
            gtd.setColor(Color.WHITE);
            gtd.fillRect((int) Position.x, (int) Position.y, (int) Size.x, (int) Size.y);
        }
    }

    public String getName() {
        return this.AbstractGameObject.getName();
    }
}
