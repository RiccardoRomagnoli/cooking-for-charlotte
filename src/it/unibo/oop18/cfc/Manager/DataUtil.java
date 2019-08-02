// Global helper class.
// Records finish time upon game completion.

package it.unibo.oop18.cfc.Manager;

public final class DataUtil {

    public static long time;

    private DataUtil() {

    }

    public static void setTime(long l) {
        time = l;
    }

    public static long getTime() {
        return time;
    }

}