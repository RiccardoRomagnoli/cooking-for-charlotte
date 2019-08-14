package it.unibo.oop18.cfc.util;

/**
 * Global helper class. Records finish time upon game completion
 */
public final class DataUtil {

    private static long time;

    private DataUtil() {

    }

    /**
     * Time setter.
     * 
     * @param l time to be setted
     */
    public static void setTime(final long l) {
        time = l;
    }

    /**
     * Get the actual time.
     * 
     * @return the time
     */
    public static long getTime() {
        return time;
    }

}
