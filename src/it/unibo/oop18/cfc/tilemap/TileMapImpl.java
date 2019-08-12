package it.unibo.oop18.cfc.tilemap;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import it.unibo.oop18.cfc.main.GameEngine;
import it.unibo.oop18.cfc.tile.TileSheet;
import it.unibo.oop18.cfc.util.Pair;
import it.unibo.oop18.cfc.util.Position;

/**
 * This class create and edit the tilemap.
 */
public class TileMapImpl implements TileMap {

    private List<Pair<Integer, Position>> maps;
    private final String bitMap;

    /**
     * Instantiates a new {@link TileMapImpl}.
     *
     * @param bitMap the path of the bit map
     */
    public TileMapImpl(final String bitMap) {
        this.bitMap = bitMap;
        loadMap();
    }

    /**
     * {@inheritDoc}
     */
    public Set<Position> getChoppingStationPosition() {
        return maps.stream().filter(p -> p.getFirst() == TileType.CHOPPINGSTATION.getPosY()).map(o -> o.getSecond())
                .collect(Collectors.toSet());
    }

    /**
     * {@inheritDoc}
     */
    public Set<Position> getCookerPosition() {
        return maps.stream().filter(p -> p.getFirst() == TileType.COOKER.getPosY()).map(o -> o.getSecond())
                .collect(Collectors.toSet());
    }

    /**
     * {@inheritDoc}
     */
    public Set<Position> getCounterPosition() {
        return maps.stream().filter(p -> p.getFirst() == TileType.COUNTER.getPosY()).map(o -> o.getSecond())
                .collect(Collectors.toSet());
    }

    /**
     * {@inheritDoc}
     */
    public Set<Position> getDeliveryStationPosition() {
        return maps.stream().filter(p -> p.getFirst() == TileType.DELIVERYSTATION.getPosY()).map(o -> o.getSecond())
                .collect(Collectors.toSet());
    }

    /**
     * {@inheritDoc}
     */
    public Set<Position> getBreadStationPosition() {
        return maps.stream().filter(p -> p.getFirst() == TileType.BREADSTATION.getPosY()).map(o -> o.getSecond())
                .collect(Collectors.toSet());
    }

    /**
     * {@inheritDoc}
     */
    public Set<Position> getMeatStationPosition() {
        return maps.stream().filter(p -> p.getFirst() == TileType.MEATSTATION.getPosY()).map(o -> o.getSecond())
                .collect(Collectors.toSet());
    }

    /**
     * {@inheritDoc}
     */
    public Set<Position> getTomatoStationPosition() {
        return maps.stream().filter(p -> p.getFirst() == TileType.TOMATOSTATION.getPosY()).map(o -> o.getSecond())
                .collect(Collectors.toSet());
    }

    /**
     * {@inheritDoc}
     */
    public Set<Position> getLettuceStationPosition() {
        return maps.stream().filter(p -> p.getFirst() == TileType.LETTUCESTATION.getPosY()).map(o -> o.getSecond())
                .collect(Collectors.toSet());
    }

    /**
     * {@inheritDoc}
     */
    public Set<Position> getPlateStationPosition() {
        return maps.stream().filter(p -> p.getFirst() == TileType.PLATESTATION.getPosY()).map(o -> o.getSecond())
                .collect(Collectors.toSet());
    }

    /**
     * {@inheritDoc}
     */
    public Set<Position> getTrashcanPosition() {
        return maps.stream().filter(p -> p.getFirst() == TileType.TRASHCAN.getPosY()).map(o -> o.getSecond())
                .collect(Collectors.toSet());
    }

    /**
     * {@inheritDoc}
     */
    public Set<Position> getWashbasinPosition() {
        return maps.stream().filter(p -> p.getFirst() == TileType.WASHBASIN.getPosY()).map(o -> o.getSecond())
                .collect(Collectors.toSet());
    }

    /**
     * {@inheritDoc}
     */
    public Set<Position> getParquetFloorPosition() {
        return maps.stream().filter(p -> p.getFirst() == TileType.PARQUETLEFTFLOOR.getPosY()).map(o -> o.getSecond())
                .collect(Collectors.toSet());
    }

    private void loadMap() {
        try {
            final InputStream in = getClass().getResourceAsStream(bitMap);
            final BufferedReader br = new BufferedReader(new InputStreamReader(in));
            maps = new ArrayList<Pair<Integer, Position>>();
            final int numCols = Integer.parseInt(br.readLine());
            final int numRows = Integer.parseInt(br.readLine());

            final String delims = "\\s+";
            for (int row = 0; row < numRows; row++) {
                final String line = br.readLine();
                if (line != null) {
                    final String[] tokens = line.split(delims);
                    for (int col = 0; col < numCols; col++) {
                        maps.add(new Pair<Integer, Position>(Integer.parseInt(tokens[col]),
                                new Position(col * TileSheet.TILE_SIZE_IN_GAME,
                                        GameEngine.HUDHEIGHT + row * TileSheet.TILE_SIZE_IN_GAME)));
                    }
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
