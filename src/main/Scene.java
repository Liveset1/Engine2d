package main;

import main.GameObjects.CameraObject;
import main.GameObjects.Entity.PlayerObject;
import main.GameObjects.tile.Tile;
import main.GameObjects.tile.TileManager;
import main.Physics.PhysicalGameObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Scene {
    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize * scale; // 48x48 tile
    public final int maxScreenCol = 16; // Screen Columns
    public final int maxScreenRow = 12; // Screen Row
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    KeyHandler keyHandler = new KeyHandler();

    // GameObjects Attributes
    private List<PhysicalGameObject> physicalGameObjects = new ArrayList<>();
    private List<PlayerObject> playerObjects = new ArrayList<>();
    private List<CameraObject> cameraObjects = new ArrayList<>();

    private List<String> tileMaps = new ArrayList<>();
    private String currentTileMap;

    // Class Attributes
    public static List<Scene> scenes = new ArrayList<>();

    public Scene() {
        scenes.add(this);
    }

    public Scene(ArrayList<String> tileMaps) {
        this.tileMaps = tileMaps;
        this.currentTileMap = this.tileMaps.get(0);
        scenes.add(this);
    }

    public PhysicalGameObject getObject(String type, String Name) {
        for (PhysicalGameObject obj : physicalGameObjects) {
            if (obj.getType() == type) {
                if (obj.getName() == Name) {
                    return obj;
                }
            }
        }
        return null;
    }

    public List<PhysicalGameObject> getPhysicalGameObjects() {
        return physicalGameObjects;
    }

    public List<CameraObject> getCameraObjects() {
        return cameraObjects;
    }

    public List<PlayerObject> getPlayerObjects() {
        return playerObjects;
    }

    public void addPhysicalGameObject(PhysicalGameObject physicalGameObject) {
        this.physicalGameObjects.add(physicalGameObject);
    }

    public void addPlayerObject(PlayerObject player) {
        this.playerObjects.add(player);
    }

    public void addCameraObject(CameraObject cameraObject) {
        this.cameraObjects.add(cameraObject);
    }

    public void removePhysicalGameObject(PhysicalGameObject object) {
        this.physicalGameObjects.remove(object);
    }

    public void removePlayerObject(PlayerObject player) {
        this.playerObjects.remove(player);
    }

    public void removeCameraObject(CameraObject cameraObject) {
        this.cameraObjects.remove(cameraObject);
    }

    public int getTileSize() {
        return tileSize;
    }

    public String getCurrentTileMap() {
        return currentTileMap;
    }

    public void addTileMap(String tileDir) {
        this.tileMaps.add(tileDir);
    }

    public void setCurrentTileMap(String currentTileMap) {
        this.currentTileMap = currentTileMap;
    }

    public void setCurrentTileMap() {
        this.currentTileMap = null;
    }

    public void loadCurrentTileMap() {
        var tileManager = TileManager.getInstance();

        tileManager.loadTileMap(currentTileMap);
    }
}
