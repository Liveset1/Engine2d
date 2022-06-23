package main.GameObjects.tile;

import main.SceneManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TileManager {
    SceneManager sceneManager;
    List<Tile> tiles = new ArrayList<>();

    public static TileManager instance;

    private TileManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
        this.getTileImages();
    }

    public static TileManager getInstance(SceneManager sceneManager) {
        if (instance == null) {
            instance = new TileManager(sceneManager);
        }
        return instance;
    }

    public static TileManager getInstance() {
        if (instance != null) {
            return instance;
        }
        return  null;
    }

    public void getTileImages() {
        System.out.println(20);
        for (Tile t : tiles) {
            if (t.getImage() == null) {
                try {
                    t.setImage(ImageIO.read(getClass().getResourceAsStream(t.imageDir)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(10);
    }


    public void addTileToManager(Tile tile) {
        this.tiles.add(tile);
        this.getTileImages();
    }

    public void removeTileFromManager(Tile tile) {
        this.tiles.remove(tile);
        this.getTileImages();
    }

    public void draw(Graphics2D gtd) {
        if (this.sceneManager.getCurrentScene().getCurrentTileMap() != null) {
            int col = 0;
            int row = 0;
            int x = 0;
            int y = 0;

            while (col < sceneManager.getCurrentScene().maxScreenCol && row < sceneManager.getCurrentScene().maxScreenRow) {
                gtd.drawImage(this.tiles.get(0).getImage(), (int)this.tiles.get(0).Position.x, (int)this.tiles.get(0).Position.y, sceneManager.getCurrentScene().getTileSize(), sceneManager.getCurrentScene().getTileSize(), null);
                col++;
                x += sceneManager.getCurrentScene().getTileSize();

                if (col == sceneManager.getCurrentScene().maxScreenCol) {
                    col = 0;
                    x = 0;
                    row++;
                    y += sceneManager.getCurrentScene().getTileSize();
                }
            }
        } else {
            for (Tile t : tiles) {
                gtd.drawImage(t.getImage(), (int)t.Position.x, (int)t.Position.y, t.getTileSize(), t.getTileSize(), null);
            }
        }
    }

    public void loadTileMap(String tileDir) {
        try  {
            InputStream is = getClass().getResourceAsStream(tileDir);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
