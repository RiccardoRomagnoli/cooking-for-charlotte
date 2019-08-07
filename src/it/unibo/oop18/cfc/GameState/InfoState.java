package it.unibo.oop18.cfc.GameState;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import it.unibo.oop18.cfc.Manager.Content;
import it.unibo.oop18.cfc.Manager.GameStateManager;

/**
 * Info.
 */
public class InfoState extends GameState {

    private BufferedImage bg;

    /**
     * Class constructor.
     * 
     * @param gsm game state
     */
    public InfoState(final GameStateManager gsm) {
        super(gsm, GameStates.INFO);
    }

    /**
     * {@inheritDoc}.
     */
    public void init() {
        bg = Content.MENUBG[0][0];
    }

    /**
     * {@inheritDoc}.
     */
    public void update() {
    }

    /**
     * {@inheritDoc}.
     * @param g basic graphics
     */
    public void draw(final Graphics2D g) {
        g.drawImage(bg, 0, 0, null);
        Content.drawString(g, "INFO", 400, 300);
        Content.drawString(g, "arrow keys : move", 100, 370);
        Content.drawString(g, "space : action", 200, 440);
        Content.drawString(g, "F1: return to menu", 100, 510);

        Font myfont = null;
        try {
            myfont = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("/HUD/comicsans.ttf"));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            System.out.println("Error, not supported font type!..");
        }
        //myfont.deriveFont(12F);
        g.setFont(myfont);
        System.out.println(g.getFont());
        g.drawString("Fai attenzione a comporre il piatto con gli ingredienti giusti "
                + "altrimenti dovrai buttare tutto nel cestino e ricominciare da capo!!", 200, 200);
        //System.out.println("Printed");
    }

}
