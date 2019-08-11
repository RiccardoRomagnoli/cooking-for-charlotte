package it.unibo.oop18.cfc.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;
import static java.util.Map.Entry.comparingByValue;

/**
 * 
 * Ranking class manage a CSV file.
 * 
 *
 */
public class RankingImpl implements Ranking {

    private Map<String, Integer> ranked = new HashMap<>();
    final private int rowNumber;

    /**
     * Constructor.
     * 
     * @throws IOException generic exception
     * 
     */
    public RankingImpl() throws IOException {
        this.rowNumber = ranked.size();
        loadRanking(); // Loads the ranking, so now the HashMap is filled
        ranked = orderRank(ranked);
    }

    /**
     * @param player player that scored @param points
     */
    @Override
    public void addPlacement(final String player, final int points) {
        if (!ranked.containsKey(player)) {
            ranked.put(player, points);
        }
    }

    /**
     * Print point on screen.
     */
    @Override
    public void printOnScreen() {
        int count = 1;
        for (final HashMap.Entry<String, Integer> entry : ranked.entrySet()) {
            final String key = entry.getKey();
            final Integer value = entry.getValue();
            System.out.printf("#%d  -  Name: %s  -  Points: %d ", count, key, value);
            count++;
        }
    }

    /**
     * Write the rank to a CSV file.
     */
    @Override
    public void saveRanking() {
        FileWriter w;
        BufferedWriter b;
        try {
            w = new FileWriter("prova.txt");
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
    }

    /**
     * Read the ranking from the CSV file.
     * 
     * @throws IOException
     *
     */
    @Override
    public final void loadRanking() throws IOException {
        final BufferedReader csvReader;
        try {
            csvReader = new BufferedReader(new FileReader("prova.txt"));
            String row;
            while ((row = csvReader.readLine()) != null) {
                final String[] data = row.split(";");
                ranked.put(data[0], Integer.parseInt(data[1]));
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the map ordered.
     * 
     * @return the ordered map
     * @param map to be ordered
     */
    public final Map<String, Integer> orderRank(final Map<String, Integer> map) {
        return map.entrySet().stream().sorted(comparingByValue())
                .collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
    }

    /**
     * 
     * @return the number of row in the map (dimension of the map)
     */
    public int getRowNumber() {
        return rowNumber;
    }
}
