package it.unibo.oop18.cfc.Physics;

import java.awt.geom.Rectangle2D;
import java.util.Set;

//import javax.xml.bind.ParseConversionEvent;

import it.unibo.oop18.cfc.Main.GameEngine;
import it.unibo.oop18.cfc.Objects.Entity.DynamicObject;
import it.unibo.oop18.cfc.Objects.Items.Item;
import it.unibo.oop18.cfc.Tile.TileSheet;
import it.unibo.oop18.cfc.Util.Pair;
import it.unibo.oop18.cfc.Util.Position;
import it.unibo.oop18.cfc.Util.Velocity;
import it.unibo.oop18.cfc.Util.VelocityImpl;

public class DynamicPhysicsComponentImpl implements DynamicPhysicsComponent {

    private static final int POSITION_ADJUSTMENT = 10;
    private static final int HEIGHT_ADJUSTMENT = 5;
    private static final int WIDTH_ADJUSTMENT = 20;

    private final Velocity vector;
    private final DynamicObject entity;

    public DynamicPhysicsComponentImpl(final DynamicObject entity) {
        this.vector = new VelocityImpl();
        this.entity = entity;
    }

    public void stop() {

    }

    public void move() {
        final Position previousPos = this.entity.getPosition();
        double velX = this.vector.getSpaceX();
        double velY = this.vector.getSpaceY();

        final Pair<Double, Double> deltas = this.getDeltas(new Pair<>(velX, velY), previousPos);
        this.entity.getPosition().setX(this.entity.getPosition().getX() + deltas.getFirst());
        this.entity.getPosition().setY(this.entity.getPosition().getY() + deltas.getSecond());
    }

    private Pair<Double, Double> getDeltas(final Pair<Double, Double> velocity, final Position previousPos) {
        double deltaX = velocity.getFirst();
        double deltaY = velocity.getSecond();
        if (previousPos.getX() + deltaX >= GameEngine.RIGHT_BOUND_IN_PIXEL) {
            deltaX = GameEngine.RIGHT_BOUND_IN_PIXEL - previousPos.getX();
        } else if (previousPos.getX() + deltaX <= GameEngine.LEFT_BOUND_IN_PIXEL) {
            deltaX = GameEngine.LEFT_BOUND_IN_PIXEL - previousPos.getX();
        }

        if (previousPos.getY() + deltaY >= GameEngine.DOWN_BOUND_IN_PIXEL) {
            deltaY = GameEngine.DOWN_BOUND_IN_PIXEL - previousPos.getY();
        } else if (previousPos.getY() + deltaY <= GameEngine.TOP_BOUND_IN_PIXEL) {
            deltaY = GameEngine.TOP_BOUND_IN_PIXEL - previousPos.getY();
        }
        return new Pair<>(deltaX, deltaY);
    }

//    public TileType getNextTile() {        
//        int x = (int) this.entity.getPosition().getX() / Tile.SPRITE_SIZE;
//        int y = (int) this.entity.getPosition().getY() / Tile.SPRITE_SIZE - 2;
//
//        if (this.getVelocity().getDirection() == Direction.DOWN || this.getVelocity().getOldDirection() == Direction.DOWN) {
//            y++;
//        } else if (this.getVelocity().getDirection() == Direction.LEFT || this.getVelocity().getOldDirection() == Direction.LEFT) {
//            x--;
//        } else if (this.getVelocity().getDirection() == Direction.RIGHT || this.getVelocity().getOldDirection() == Direction.RIGHT) {
//            x++;
//        } else if (this.getVelocity().getDirection() == Direction.UP || this.getVelocity().getOldDirection() == Direction.UP) {
//            y--;
//        }
//        return tm.getType(y, x); 
//    }

    @Override
    public Velocity getVelocity() {
        return vector;
    }

    @Override
    public Rectangle2D getTopBound() {
        return new Rectangle2D.Double(this.entity.getPosition().getX() + POSITION_ADJUSTMENT,
                this.entity.getPosition().getY(), TileSheet.TILE_SIZE_IN_GAME - WIDTH_ADJUSTMENT, HEIGHT_ADJUSTMENT);
    }

    @Override
    public Rectangle2D getLowerBound() {
        return new Rectangle2D.Double(this.entity.getPosition().getX() + POSITION_ADJUSTMENT,
                this.entity.getPosition().getY() + TileSheet.TILE_SIZE_IN_GAME - HEIGHT_ADJUSTMENT,
                TileSheet.TILE_SIZE_IN_GAME - WIDTH_ADJUSTMENT, HEIGHT_ADJUSTMENT);
    }

    @Override
    public Rectangle2D getLeftBound() {
        return new Rectangle2D.Double(this.entity.getPosition().getX(),
                this.entity.getPosition().getY() + POSITION_ADJUSTMENT, HEIGHT_ADJUSTMENT,
                TileSheet.TILE_SIZE_IN_GAME - WIDTH_ADJUSTMENT);
    }

    @Override
    public Rectangle2D getRightBound() {
        return new Rectangle2D.Double(this.entity.getPosition().getX() + TileSheet.TILE_SIZE_IN_GAME - HEIGHT_ADJUSTMENT,
                this.entity.getPosition().getY() + POSITION_ADJUSTMENT, HEIGHT_ADJUSTMENT,
                TileSheet.TILE_SIZE_IN_GAME - WIDTH_ADJUSTMENT);
    }

    @Override
    public void checksCollisions(Set<Item> set) {
        set.forEach(wall -> {
            if (wall.getBounds().intersects(this.getTopBound())) {
                this.entity.getPosition().setY(wall.getPosition().getY() + TileSheet.TILE_SIZE_IN_GAME);
            } else if (wall.getBounds().intersects(this.getLowerBound())) {
                this.entity.getPosition().setY(wall.getPosition().getY() - TileSheet.TILE_SIZE_IN_GAME);
            } else if (wall.getBounds().intersects(this.getRightBound())) {
                this.entity.getPosition().setX(wall.getPosition().getX() - TileSheet.TILE_SIZE_IN_GAME);
            } else if (wall.getBounds().intersects(this.getLeftBound())) {
                this.entity.getPosition().setX(wall.getPosition().getX() + TileSheet.TILE_SIZE_IN_GAME);
            }
        });
    }
}
