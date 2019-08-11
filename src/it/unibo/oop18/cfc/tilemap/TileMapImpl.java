package it.unibo.oop18.cfc.tilemap;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

import it.unibo.oop18.cfc.main.GameEngine;
import it.unibo.oop18.cfc.tile.TileSheet;
import it.unibo.oop18.cfc.util.Pair;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.WorldImpl;
/**
 * This class create and edit the tilemap.
 */
public class TileMapImpl implements TileMap {

    // map
    private ArrayList<Pair<Integer, Position>> maps;
    private int numRows;
    private int numCols;
    private String bitMap;
    /**
     * Constructor of the class. Set the tilesize, the speed and calculate the rows
     * and cols of the tilemap
     * 
     * @param bitMap name of the bitMap
     */
    public TileMapImpl(final String bitMap) {
        this.bitMap = bitMap;
        loadMap();
    }

    /**
     * Load the map of the game based of the bitmap.
     */
    public final void loadMap() {

        try {
            final InputStream in = getClass().getResourceAsStream(bitMap);
            final BufferedReader br = new BufferedReader(new InputStreamReader(in));
            maps = new ArrayList<Pair<Integer, Position>>();
            numCols = Integer.parseInt(br.readLine());
            numRows = Integer.parseInt(br.readLine());

            final String delims = "\\s+";
            for (int row = 0; row < numRows; row++) {
                final String line = br.readLine();
                final String[] tokens = line.split(delims);
                for (int col = 0; col < numCols; col++) {
                    maps.add(new Pair<Integer, Position>(Integer.parseInt(tokens[col]), new Position(col * TileSheet.TILE_SIZE_IN_GAME, GameEngine.HUDHEIGHT + row * TileSheet.TILE_SIZE_IN_GAME)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return numRows
     */
    public int getNumRows() {
        return numRows;
    }

    /**
     * @return numCols
     */
    public int getNumCols() {
        return numCols;
    }

    @Override
    public Set<Position> getChoppingStationPosition() {
        return maps.stream()
                .filter(p -> p.getFirst() == TileType.CHOPPINGSTATION.getPos())
                .map(o -> o.getSecond())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Position> getCookerPosition() {
        return maps.stream()
                .filter(p -> p.getFirst() == TileType.COOKER.getPos())
                .map(o -> o.getSecond())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Position> getCounterPosition() {
        return maps.stream()
                .filter(p -> p.getFirst() == TileType.COUNTER.getPos())
                .map(o -> o.getSecond())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Position> getDeliveryStationPosition() {
        return maps.stream()
                .filter(p -> p.getFirst() == TileType.DELIVERYSTATION.getPos())
                .map(o -> o.getSecond())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Position> getBreadStationPosition() {
        return maps.stream()
                .filter(p -> p.getFirst() == TileType.BREADSTATION.getPos())
                .map(o -> o.getSecond())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Position> getMeatStationPosition() {
        return maps.stream()
                .filter(p -> p.getFirst() == TileType.MEATSTATION.getPos())
                .map(o -> o.getSecond())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Position> getTomatoStationPosition() {
        return maps.stream()
                .filter(p -> p.getFirst() == TileType.TOMATOSTATION.getPos())
                .map(o -> o.getSecond())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Position> getLettuceStationPosition() {
        return maps.stream()
                .filter(p -> p.getFirst() == TileType.LETTUCESTATION.getPos())
                .map(o -> o.getSecond())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Position> getPlateStationPosition() {
        return maps.stream()
                .filter(p -> p.getFirst() == TileType.PLATESTATION.getPos())
                .map(o -> o.getSecond())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Position> getTrashcanPosition() {
        return maps.stream()
                .filter(p -> p.getFirst() == TileType.TRASHCAN.getPos())
                .map(o -> o.getSecond())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Position> getWashbasinPosition() {
        return maps.stream()
                .filter(p -> p.getFirst() == TileType.WASHBASIN.getPos())
                .map(o -> o.getSecond())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Position> getParquetFloorPosition() {
        return maps.stream()
                .filter(p -> p.getFirst() == TileType.PARQUETFLOOR.getPos())
                .map(o -> o.getSecond())
                .collect(Collectors.toSet());
    }

}