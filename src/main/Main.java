package main;

import main.GameObjects.AbstractGameObject;
import main.GameObjects.Entity.PlayerObject;
import main.GameObjects.tile.Tile;
import main.Physics.PhysicalGameObject;
import main.Physics.Vector2;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        frame mainWindow = frame.getInstance();
        Scene mainScene = new Scene();
        SceneManager sceneManager = SceneManager.getInstance(mainWindow, mainScene);

        PlayerObject player = new PlayerObject("Player1", mainScene, new Vector2(400f, 300f));
        // Animations
        player.addAnimations(new String[]{"/PlayerObject/boy_up_1.png", "/PlayerObject/boy_up_2.png", "/PlayerObject/boy_down_1.png", "/PlayerObject/boy_down_2.png", "/PlayerObject/boy_left_1.png", "/PlayerObject/boy_left_2.png", "/PlayerObject/boy_right_1.png", "/PlayerObject/boy_right_2.png"});
        mainWindow.pack();

        mainScene.keyHandler.addListener(new KeyHandler.keyEvent() {
            @Override
            public void onKeyPressed(KeyEvent key) {
                if (key.getKeyCode() == KeyEvent.VK_W) player.inputKeyUp = true;
                if (key.getKeyChar() == 's') player.inputKeyDown = true;
                if (key.getKeyChar() == 'a') player.inputKeyLeft = true;
                if (key.getKeyChar() == 'd') player.inputKeyRight = true;
            }

            @Override
            public void onKeyReleased(KeyEvent key) {
                if (key.getKeyCode() == KeyEvent.VK_W) player.inputKeyUp = false;
                if (key.getKeyChar() == 's') player.inputKeyDown = false;
                if (key.getKeyChar() == 'a') player.inputKeyLeft = false;
                if (key.getKeyChar() == 'd') player.inputKeyRight = false;
            }
        });

        PhysicalGameObject ground = new PhysicalGameObject("Ground", "rect", mainScene, new Vector2(400f,100f), new Vector2(50f, 100f), Color.blue, true, true, true);

        sceneManager.startPanelThread();
    }
}