package it.unibo.oop18.cfc.input;


import it.unibo.oop18.cfc.object.entity.PlayerImpl;
import it.unibo.oop18.cfc.object.items.IngredientImpl;
import it.unibo.oop18.cfc.object.items.PlateImpl;
import it.unibo.oop18.cfc.physics.Direction;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.World;

/**
 * Input component for the player. It implements {@link PlayerInputComponent}.
 */
public class PlayerInputComponentImpl extends AbstractInputComponent implements PlayerInputComponent {

    private static final int PIXEL_PER_SECOND = 4;

    private final PlayerImpl player;
    /**
     * Creates {@code PlayerInputComponentImpl}.
     *
     * @param player reference
     */
    public PlayerInputComponentImpl(final PlayerImpl player) {
        super(player);
        this.player = player;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void move(final Direction way) {
        super.createDirectionCommand(way, PIXEL_PER_SECOND);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stop() {
        super.createDirectionCommand(Direction.STOP, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doAction() {
        super.createGenericCommand(() -> {
            this.player.doAction();
        });
    }

    @Override
    public void cutIngredient() {
        super.createGenericCommand(() -> {
            this.player.cutIngredient();
        });
    }
}
