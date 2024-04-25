package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;

public class GamePanel extends JPanel implements Runnable{
    // Screen settings
    final int originalTileSize = 16; // 16x16 tile
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;

    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;    // 16*3*16 = 768px
    final int screenHeight = tileSize * maxScreenRow;   // 16*3*12 = 576px

    int FPS = 30;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    Player player = new Player(this, keyH);

    // Set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        /**
        * Enables double buffering for smoother rendering.
        */
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        /**
        * Sets the focusability of this component.
        * 
        * @param focusable true if this component can receive the focus, false otherwise
        */
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    // @Override
    // public void run() {
    //     // The game Loop based on drawInterval

    //     // Check for time to update 60fps
    //     double drawInterval = 1000000000 / FPS;
    //     double nextDrawTime = System.nanoTime() + drawInterval;

    //     while (gameThread != null) {

    //         // UPDATE : Update sprites position...
    //         update();
    //         // DRAW : Draw the screen with updated informations
    //         repaint();

    //         try {
    //             double remainingTime = nextDrawTime - System.nanoTime();
    //             remainingTime = remainingTime / 1000000;

    //             if(remainingTime < 0) {
    //                 remainingTime = 0;
    //             }

    //             Thread.sleep((long) remainingTime);

    //             nextDrawTime += drawInterval;

    //         } catch (InterruptedException e) {
    //             e.printStackTrace();
    //         }
    //     }
    // }

    /**
    * Runs the game loop to update and repaint the game at a fixed frame rate.
    */
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta > 1) {
                update();
                repaint();
                // Decrease delta by 1 to account for the frame that was drawn
                delta--;
                drawCount++;
            }
            if(timer >=1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        player.update();
        // if(keyH.upPressed == true) {
        //     playerY -= playerSpeed;
        // }
        // else if(keyH.downPressed == true) {
        //     playerY += playerSpeed;
        // }
        // else if(keyH.rightPressed == true) {
        //     playerX += playerSpeed;
        // }
        // else if(keyH.leftPressed == true) {
        //     playerX -= playerSpeed;
        // }
    }
    /**
    * Overrides the paintComponent method to provide custom painting behavior.
    * 
    * @param g the Graphics object used for painting
    */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // g2.setColor(Color.WHITE);
        // g2.fillRect(playerX, playerY, tileSize, tileSize);
        player.draw(g2);
        g2.dispose();
    }
}