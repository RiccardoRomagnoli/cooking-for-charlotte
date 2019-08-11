package it.unibo.oop18.cfc.input;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.IntStream;

import it.unibo.oop18.cfc.object.entity.DynamicObject;
import it.unibo.oop18.cfc.physics.Direction;

/**
 * This class models the {@link InputComponent} of {@link DynamicObject}. It
 * manages the command queue, adding and removing command according to the
 * supplied input and GameEngine work.
 */
public abstract class AbstractInputComponent implements InputComponent {

    private static final int QUEUE_LIMIT = 1000;

    private final Queue<Command> commandQueue;
    private final DynamicObject entity;

    /**
     * Creates {@code AbstractInputComponent}.
     *
     * @param entity that receives the new generated command
     */
    public AbstractInputComponent(final DynamicObject entity) {
        this.entity = entity;
        this.commandQueue = new ArrayBlockingQueue<Command>(QUEUE_LIMIT);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void createDirectionCommand(final Direction direction, final double distance) {
        switch (direction) {
        case UP:
            this.commandQueue.add(() -> {
                entity.getPhysics().getVelocity().setSpaceX(0);
                entity.getPhysics().getVelocity().setSpaceY(-distance);
            });
            break;
        case DOWN:
            this.commandQueue.add(() -> {
                entity.getPhysics().getVelocity().setSpaceX(0);
                entity.getPhysics().getVelocity().setSpaceY(+distance);
            });
            break;
        case LEFT:
            this.commandQueue.add(() -> {
                entity.getPhysics().getVelocity().setSpaceX(-distance);
                entity.getPhysics().getVelocity().setSpaceY(0);
            });
            break;
        case RIGHT:
            this.commandQueue.add(() -> {
                entity.getPhysics().getVelocity().setSpaceX(+distance);
                entity.getPhysics().getVelocity().setSpaceY(0);
            });
            break;
        default:
            this.commandQueue.add(() -> {
                entity.getPhysics().getVelocity().setSpaceX(0);
                entity.getPhysics().getVelocity().setSpaceY(0);
            });
            break;
        }
        this.setDirection(direction);

    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void createGenericCommand(final Command command) {
        this.commandQueue.add(command);
    }

    public void resetCommands() {
        this.commandQueue.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processInput() {
        IntStream.range(0, this.commandQueue.size()).mapToObj(c -> this.commandQueue.poll())
                .forEach(command -> command.execute());
    }

    private void setDirection(final Direction dir) {
        this.entity.getPhysics().getVelocity().setDirection(dir);
    }
}
