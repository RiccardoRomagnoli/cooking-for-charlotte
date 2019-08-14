package it.unibo.oop18.cfc.util;

/**
 * The Enum CheckStatus.
 */
public enum CheckStatus {

    /** The not acceptable. */
    NOT_ACCEPTABLE(0),

    /** The acceptable with error. */
    ACCEPTABLE_WITH_ERROR(5),

    /** The acceptable without error. */
    ACCEPTABLE_WITHOUT_ERROR(20);

    private int points;

    CheckStatus(final int points) {
        this.points = points;
    }

    /**
     * Gets the points.
     *
     * @return the points
     */
    public int getPoints() {
        return this.points;
    }

}
