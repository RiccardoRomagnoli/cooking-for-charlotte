package it.unibo.oop18.cfc.Physics;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Set;

import it.unibo.oop18.cfc.Main.GamePanel;
import it.unibo.oop18.cfc.Manager.Content;
import it.unibo.oop18.cfc.Objects.Blocks.Block;
import it.unibo.oop18.cfc.Objects.Entity.DynamicObject;
import it.unibo.oop18.cfc.TileMap.Tile;
import it.unibo.oop18.cfc.TileMap.TileMap;
import it.unibo.oop18.cfc.Util.Pair;
import it.unibo.oop18.cfc.Util.Position;
import it.unibo.oop18.cfc.Util.Velocity;
import it.unibo.oop18.cfc.Util.VelocityImpl;

public class DynamicPhysicsComponentImpl implements DynamicPhysicsComponent{
	
    private static final int POSITION_ADJUSTMENT = 10;
    private static final int HEIGHT_ADJUSTMENT = 5;
    private static final int WIDTH_ADJUSTMENT = 20;
    
    
    private final Velocity vector;
    private final DynamicObject entity;
    


    public DynamicPhysicsComponentImpl(TileMap tm, final DynamicObject entity) {
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
        if (previousPos.getX() + deltaX >= GamePanel.WIDTH) {
            deltaX = GamePanel.WIDTH - previousPos.getX();
        } else if (previousPos.getX() + deltaX <= Tile.SPRITE_SIZE) {
            deltaX = Tile.SPRITE_SIZE - previousPos.getX();
        }
        if (previousPos.getY() + deltaY >= GamePanel.HEIGHT) {
            deltaY = GamePanel.HEIGHT - previousPos.getY();
        } else if (previousPos.getY() + deltaY <= Tile.SPRITE_SIZE) {
            deltaY = Tile.SPRITE_SIZE - previousPos.getY();
        }
        return new Pair<>(deltaX, deltaY);
    }

	@Override
	public Velocity getVelocity() {
		return vector;
	}

	@Override
	public Rectangle2D getTopBound() {
        return new Rectangle2D.Double(this.entity.getPosition().getX() + POSITION_ADJUSTMENT,
                					  this.entity.getPosition().getY(),
                					  Tile.SPRITE_SIZE - WIDTH_ADJUSTMENT,
                					  HEIGHT_ADJUSTMENT);
	}

	@Override
	public Rectangle2D getLowerBound() {
        return new Rectangle2D.Double(this.entity.getPosition().getX() + POSITION_ADJUSTMENT,
                					  this.entity.getPosition().getY() + Tile.SPRITE_SIZE - HEIGHT_ADJUSTMENT,
                                      Tile.SPRITE_SIZE - WIDTH_ADJUSTMENT,
                                      HEIGHT_ADJUSTMENT);
	}

	@Override
	public Rectangle2D getLeftBound() {
        return new Rectangle2D.Double(this.entity.getPosition().getX(),
                					  this.entity.getPosition().getY() + POSITION_ADJUSTMENT,
                					  HEIGHT_ADJUSTMENT,
                					  Tile.SPRITE_SIZE - WIDTH_ADJUSTMENT);
	}

	@Override
	public Rectangle2D getRightBound() {
        return new Rectangle2D.Double(this.entity.getPosition().getX() + Tile.SPRITE_SIZE
                																	- HEIGHT_ADJUSTMENT,
                					  this.entity.getPosition().getY() + POSITION_ADJUSTMENT,
                					  HEIGHT_ADJUSTMENT,
                					  Tile.SPRITE_SIZE - WIDTH_ADJUSTMENT);
	}

	@Override
	public void checksCollisions(Set<Block> set) {
        set.forEach(wall -> {
            if (wall.getBounds().intersects(this.getTopBound())) {
                this.entity.getPosition().setY(wall.getPosition().getY() + Tile.SPRITE_SIZE);
            } else if (wall.getBounds().intersects(this.getLowerBound())) {
                this.entity.getPosition().setY(wall.getPosition().getY() - Tile.SPRITE_SIZE);
            } else if (wall.getBounds().intersects(this.getRightBound())) {
                this.entity.getPosition().setX(wall.getPosition().getX() - Tile.SPRITE_SIZE);
            } else if (wall.getBounds().intersects(this.getLeftBound())) {
                this.entity.getPosition().setX(wall.getPosition().getX() + Tile.SPRITE_SIZE);
            }
        });
	}
}
