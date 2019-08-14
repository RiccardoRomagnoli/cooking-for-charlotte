package it.unibo.oop18.cfc.util;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import it.unibo.oop18.cfc.gamestate.InfoState;

/**
 * Ranking class manage a CSV file.
 */
public class RankingImpl implements Ranking {

    private static Map<String, Integer> ranked = new HashMap<>();
    private static String path = "rank.txt";

    private final int rowNumber;

    /**
     * Constructor.
     */
    public RankingImpl() {
        this.rowNumber = ranked.size();
        loadRanking(); // Loads the ranking, so now the HashMap is filled
        ranked = orderRank(ranked);
    }

    /**
     * {@inheritDoc}
     * 
     * @param player player that scored @param points
     */
    public void addPlacement(final String player, final int points) {
        if (!ranked.containsKey(player)) {
            ranked.put(player, points);
        }
    }

    /**
     * Print point on screen.
     * 
     * @param g graphics
     */
    public static void printOnScreen(final Graphics2D g) {
        int count = 1;
        Font myFont;
        try {
            myFont = Font.createFont(Font.TRUETYPE_FONT, InfoState.class.getResourceAsStream("/HUD/comicsans.ttf"));
            myFont = myFont.deriveFont(30f);
            g.setFont(myFont);
            g.setColor(Color.green);
            for (final HashMap.Entry<String, Integer> entry : ranked.entrySet()) {
                final String key = entry.getKey();
                final Integer value = entry.getValue();
                g.drawString(String.format("#%d  -  Name: %s  -  Points: %d ", count, key.toUpperCase(Locale.ENGLISH),
                        value), 220, 310 + 50 * count);
                count++;
            }
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    public void saveRanking() {
        FileWriter w;
        BufferedWriter b;
        try {
            w = new FileWriter(path);
            b = new BufferedWriter(w);
            for (final HashMap.Entry<String, Integer> entry : ranked.entrySet()) {
                final String key = entry.getKey();
                final Integer value = entry.getValue();
                final String row = String.format("%s;%d\n", key, value);
                b.write(row);
            }
            b.close();
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        orderRank(ranked);
    }

    /**
     * Read the ranking from the CSV file.
     * 
     */
    public final void loadRanking() {
        try {
            final BufferedReader csvReader = new BufferedReader(new FileReader(path));
            String row;
            while ((row = csvReader.readLine()) != null) {
                final String[] data = row.split(";");
                try {
                    ranked.put(data[0], Integer.parseInt(data[1]));
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("The loaded ranking, is empty");
                }
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        orderRank(ranked);
    }

    /**
     * Returns the map ordered.
     * 
     * @return the ordered map
     * @param map to be ordered
     */
    // TODO mettere in ordine decrescente
    public static Map<String, Integer> orderRank(final Map<String, Integer> map) {
        return map.entrySet().stream().sorted(comparingByValue())
                .collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
    }

    /**
     * Return number of ranked.
     * 
     * @return the number of row in the map (dimension of the map)
     */
    public int getRowNumber() {
        return rowNumber;
    }

    /**
     * Get the map of classified player.
     * 
     * @return map of <player,points>
     */
    public static Map<String, Integer> getRanked() {
        return ranked;
    }

    /**
     * Set the path of the rank.
     * 
     * @param path rank
     */
    public static void setPath(String path) {
        RankingImpl.path = path;
    }

}
