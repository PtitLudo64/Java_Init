package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import object.OBJ_Key;

public class UI {
    GamePanel gp;
    Font arial_40, arial_60B;
    // Font dejaVu_40;
    BufferedImage keyImage;
    public boolean messageON = false;
    public String message = "";
    int messageCounter = 0;
    public Boolean gameFinished = false;
    double playTime = 0;
    DecimalFormatSymbols symbols;
    DecimalFormat dFormat;

    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_60B = new Font("Arial", Font.BOLD, 60);
        // dejaVu_40 = new Font("DejaVu Sans", Font.PLAIN, 40);
        OBJ_Key key = new OBJ_Key();
        keyImage = key.image;

        symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        dFormat = new DecimalFormat("#0.00", symbols);

    }

    public void showMessage(String text) {
        message = text;
        messageON = true;
    }

    public void draw(Graphics2D g2) {

        if(gameFinished == true) {
            g2.setFont(arial_40);
            g2.setColor(Color.WHITE);

            String text;
            int textLength;
            int x;
            int y;

            text = "You found the treasure !";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 - (gp.tileSize * 3);
            g2.drawString(text, x, y);

            text = "Your time is : " + dFormat.format(playTime) + " !";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 + (gp.tileSize * 4);
            g2.drawString(text, x, y);

            g2.setFont(arial_60B);
            g2.setColor(Color.YELLOW);
            
            text = "Congratulations!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 + (gp.tileSize * 2);
            g2.drawString(text, x, y);

            gp.gameThread = null;
        }
        else {
            g2.setFont(arial_40);
            // g2.setFont(dejaVu_40);
            g2.setColor(Color.WHITE);
            g2.drawImage(keyImage, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize, gp.tileSize, null);
            g2.drawString("x " + gp.player.hasKey, 74, 65);

            // Timer
            playTime += (double)1/gp.FPS;
            g2.drawString("Time : " + dFormat.format(playTime), gp.tileSize * 10, 65);
    
            // Message
            if (messageON == true) {
                
                g2.setFont(g2.getFont().deriveFont(25F));
                g2.drawString(message, gp.tileSize / 2, gp.tileSize * 5);
                messageCounter++;
                if (messageCounter > gp.FPS * 2) {
                    messageCounter = 0;
                    // message = "";
                    // g2.drawString(message, gp.tileSize / 2, gp.tileSize * 5);
                    messageON = false;
                }
            }
        }
    }
}
