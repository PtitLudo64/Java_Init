package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyPressed(KeyEvent e) {
        // throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_Z:
                upPressed = true;
                break;
            case KeyEvent.VK_Q:
                leftPressed = true;
                break;
            case KeyEvent.VK_S:
                downPressed = true;
                break;
            case KeyEvent.VK_D:
                rightPressed = true;
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_Z:
                upPressed = false;
                break;
            case KeyEvent.VK_Q:
                leftPressed = false;
                break;
            case KeyEvent.VK_S:
                downPressed = false;
                break;
            case KeyEvent.VK_D:
                rightPressed = false;
                break;
            default:
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
        // throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

}
