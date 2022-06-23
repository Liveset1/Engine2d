package main;

import javax.swing.*;
import java.awt.*;

public class frame extends JFrame {
    public int x;
    public int y;
    public int width;
    public int height;
    public String title;

    public static frame instance;

    private frame() {
        setTitle("Engine2D");
        setSize(800, 700);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int)((screenSize.getWidth() / 2) - (getSize().getWidth() / 2)), (int)(screenSize.getHeight()/2 - getSize().getHeight()/2));

        setResizable(false);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private frame(String title, int x, int y, int width, int height) {
        setTitle(title);
        setSize(width, height);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int)((screenSize.getWidth() / 2) - (getSize().getWidth() / 2)), (int)(screenSize.getHeight()/2 - getSize().getHeight()/2));;

        setResizable(false);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static frame getInstance() {
        if (instance == null) {
            instance = new frame();
        }
        return instance;
    }

    public static frame getInstance(String title, int x, int y, int width, int height) {
        if (instance == null) {
            instance = new frame(title, x, y, width, height);
        }
        return instance;
    }
}
