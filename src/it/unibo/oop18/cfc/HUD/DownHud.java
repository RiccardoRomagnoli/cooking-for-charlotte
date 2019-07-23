//Contains a reference to the Player.
//Draws all relevant information at the
//bottom of the screen.

package it.unibo.oop18.cfc.HUD;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import it.unibo.oop18.cfc.Entity.Player;
import it.unibo.oop18.cfc.Main.GamePanel;
import it.unibo.oop18.cfc.Manager.Content;

public class DownHud {
     
     private int yoffset;
     
     private BufferedImage bar;
  
     private Player player;
     
     
     public DownHud(Player p, int points) {

             player = p;
             yoffset = GamePanel.HEIGHT2;
             
             bar = Content.DOWNBAR[0][0];             
     }
     
     public void draw(Graphics2D g) {
             
             // draw hud
             g.drawImage(bar, 0, yoffset, null);
             
             // draw time
             int minutes = (int) (player.getTicks() / 1800);
             int seconds = (int) ((player.getTicks() / 30) % 60);
             if(minutes < 10) {
                     if(seconds < 10) Content.drawString(g, "0" + minutes + ":0" + seconds, 17, 704);
                     else Content.drawString(g, "0" + minutes + ":" + seconds, 17, 704);
             }
             else {
                     if(seconds < 10) Content.drawString(g, minutes + ":0" + seconds, 17, 704);
                     else Content.drawString(g, minutes + ":" + seconds, 17, 704);
             }
             
             
             
     }
     
}

