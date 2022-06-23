package main;

import main.GameObjects.CameraObject;
import main.GameObjects.Entity.PlayerObject;
import main.GameObjects.tile.Tile;
import main.GameObjects.tile.TileManager;
import main.Physics.PhysicalGameObject;

import javax.swing.*;
import java.awt.*;

public class SceneManager extends JPanel implements Runnable {
    // Class Attributes
    public static Scene currentScene;
    private static Thread panelThread;
    static SceneManager instance;

    static int FPS = 60;

    static double drawInterval = 1000000000/FPS;
    public static double delta = 0;
    public static long lastTime = System.nanoTime();
    public static long currentTime;
    static long timer = 0;
    static int drawCount = 0;

    private TileManager tileManager;

    private SceneManager(frame parent, Scene scene) {
        currentScene = scene;
        this.setPreferredSize(new Dimension(currentScene.screenWidth, currentScene.screenHeight));
        this.setDoubleBuffered(true);
        this.setBackground(Color.BLACK);
        parent.add(this);
        parent.addKeyListener(scene.keyHandler);
        this.addKeyListener(scene.keyHandler);
        this.tileManager = TileManager.getInstance(this);
    }

    public static SceneManager getInstance(frame parent, Scene scene) {
        if (instance == null) {
            instance = new SceneManager(parent, scene);
        }
        return instance;
    }

    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager(frame.getInstance(), new Scene());
        }
        return instance;
    }

    public static void setCurrentScene(Scene currentScene) {
        SceneManager.currentScene = currentScene;
    }

    public static void startPanelThread() {
        if (currentScene != null) {
            panelThread = new Thread(getInstance());
            panelThread.start();
        }
    }

    public static void stopPanelThread() {
        if (currentScene != null) {
            if (panelThread != null) {
                panelThread.interrupt();
                panelThread = new Thread(getInstance());
                panelThread.start();
            }
        }
    }

    @Override
    public void run() {
        while (panelThread != null) {
           currentTime = System.nanoTime();

           delta += (currentTime - lastTime) / drawInterval;
           timer += (currentTime - lastTime);

           lastTime = currentTime;

           if (delta >= 1) {
               // 1 Update information such as character position
               if (!currentScene.getPhysicalGameObjects().isEmpty()) {
//                   for (CameraObject object : currentScene.getCameraObjects()) {
//                       object.update();
//                   }

                   for (PhysicalGameObject object : currentScene.getPhysicalGameObjects()) {
                       object.update();
                   }
               }
               if (!currentScene.getPlayerObjects().isEmpty()) {
                   for (PlayerObject object : currentScene.getPlayerObjects()) {
                       object.update();
                   }
               }
               // 2 DRAW: draw the screen with the updated information
               repaint();

               // Reset delta time
               delta--;
               drawCount++;
           }

           if (timer >= 1000000000) {
               System.out.println("FPS: " + drawCount);
               drawCount = 0;
               timer = 0;
           }
        }
    }

    public TileManager getTileManager() {
        return tileManager;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        tileManager.draw(g2d);

        for (PlayerObject obj : currentScene.getPlayerObjects()) {
            obj.draw(g2d);
        }

        for (PhysicalGameObject obj : currentScene.getPhysicalGameObjects()) {
            obj.draw(g2d);
        }

        g2d.dispose();
    }

    public Scene getCurrentScene() {
        return currentScene;
    }
}
