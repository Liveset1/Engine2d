package main;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class KeyHandler implements KeyListener {
    private static List<keyEvent> listeners = new ArrayList<keyEvent>();

    public interface keyEvent {
        void onKeyPressed(KeyEvent key);
        void onKeyReleased(KeyEvent key);
    }

    public void addListener(keyEvent toAdd) {
        listeners.add(toAdd);
    }

    private static void triggerEvent1(KeyEvent e) {
        for (keyEvent listener : listeners) {
            listener.onKeyPressed(e);
        }
    }

    private static void triggerEvent2(KeyEvent e) {
        for (keyEvent listener : listeners) {
            listener.onKeyReleased(e);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        triggerEvent1(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        triggerEvent2(e);
    }
}
