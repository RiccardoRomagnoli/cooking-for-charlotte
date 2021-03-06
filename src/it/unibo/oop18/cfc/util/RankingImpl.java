package it.unibo.oop18.cfc.util;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Ranking class manage a CSV file.
 */
public class RankingImpl implements Ranking {

    private static final int MAXROW = 5;
    private static final int POSXRANK = 220;
    private static final int POSYRANK = 310;
    private static final int OFFSET = 50;
    private static Map<String, Integer> ranked = new HashMap<String, Integer>();
    private String path = "rank.txt";
    private String row;
    private String key;
    private Integer value;

    /**
     * {@inheritDoc}
     */
    public void addPlacement(final String player, final int points) {
        loadRanking();
        if (!ranked.containsKey(player)) {
            ranked.put(player, points);
        }
        saveRanking();
    }

    /**
     * {@inheritDoc}
     */
    public void printOnScreen(final Graphics2D g) {
        loadRanking();
        orderRank(ranked);
        int count = 1;
        for (final HashMap.Entry<String, Integer> entry : ranked.entrySet()) {
            key = entry.getKey();
            value = entry.getValue();
            ContentUtil.drawStringFont(g, POSXRANK, POSYRANK + OFFSET * count,
                    String.format("#%d  -  Name: %s  -  Points: %d ", count, key.toUpperCase(Locale.ENGLISH), value));
            count++;
            if (count > MAXROW) {
                return;
            }
        }

    }

    /**
     * {@inheritDoc}
     */
    public void saveRanking() {
        orderRank(ranked);
        try (BufferedWriter b = new BufferedWriter(new FileWriter(path));) {
            for (final HashMap.Entry<String, Integer> entry : ranked.entrySet()) {
                key = entry.getKey();
                value = entry.getValue();
                row = String.format("%s;%d\n", key, value);
                b.write(row);
            }
            b.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    public final void loadRanking() {
        String[] data;
        try (BufferedReader csvReader = new BufferedReader(new FileReader(path))) {
            for (row = csvReader.readLine(); row != null; row = csvReader.readLine()) {
                data = row.split(";");
                try {
                    ranked.put(data[0], Integer.parseInt(data[1]));
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("The ranking is empty");
                }
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Order the map.
     * 
     * @return the ordered map
     * @param map to be ordered
     */
    private void orderRank(final Map<String, Integer> map) {
        final Map<String, Integer> result = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        RankingImpl.ranked = result;
    }

    /**
     * {@inheritDoc}
     */
    public  void setPath(final String path) {
        this.path = path;
    }

    /**
     * {@inheritDoc}
     */
    public Map<String, Integer> getRanked() {
        return ranked;
    }

}
