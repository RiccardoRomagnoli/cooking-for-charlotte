package it.unibo.oop18.cfc.Util;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 * Global audio player class. Call init() as soon as possible to instantiate the
 * clips HashMap.
 */
public final class JukeBoxUtil {

    private static Map<String, Clip> clips;
    private static int gap;
    private static FloatControl vol;

    private JukeBoxUtil() {

    }

    // Creates new clips HashMap.
    public static void init() {
        clips = new HashMap<String, Clip>();
        gap = 0;
    }

    // Loads up audio located at path "s" and stores
    // it in the HashMap with key "n".
    public static void load(final String s, final String n) {
        if (clips.get(n) != null) {
            return;
        }
        Clip clip;
        try {
            final InputStream in = JukeBoxUtil.class.getResourceAsStream(s);
            final InputStream bin = new BufferedInputStream(in);
            final AudioInputStream ais = AudioSystem.getAudioInputStream(bin);
            final AudioFormat baseFormat = ais.getFormat();
            final AudioFormat decodeFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(), 16, baseFormat.getChannels(), baseFormat.getChannels() * 2,
                    baseFormat.getSampleRate(), false);
            final AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
            clip = AudioSystem.getClip();
            clip.open(dais);
            clips.put(n, clip);
            clip.close();
            in.close();
            bin.close();
            ais.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * TODO.
     * 
     * @param s ..
     */
    public static void play(final String s) {
        play(s, gap);
    }

    /**
     * TODO.
     * 
     * @param s ..
     * @param i ..
     */
    public static void play(final String s, final int i) {
        final Clip c = clips.get(s);
        if (c == null) {
            return;
        }
        if (c.isRunning()) {
            c.stop();
        }
        c.setFramePosition(i);
        while (!c.isRunning()) {
            c.start();
        }
        c.close();
    }

    public static void stop(final String s) {
        if (clips.get(s) == null) {
            return;
        }
        if (clips.get(s).isRunning()) {
            clips.get(s).stop();
        }
    }

    public static void resume(final String s) {
        if (clips.get(s).isRunning()) {
            return;
        }
        clips.get(s).start();
    }

    public static void resumeLoop(final String s) {
        final Clip c = clips.get(s);
        if (c == null) {
            return;
        }
        c.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void loop(final String s) {
        loop(s, gap, gap, clips.get(s).getFrameLength() - 1);
    }

    public static void loop(final String s, final int frame) {
        loop(s, frame, gap, clips.get(s).getFrameLength() - 1);
    }

    public static void loop(final String s, final int start, final int end) {
        loop(s, gap, start, end);
    }

    public static void loop(final String s, final int frame, final int start, final int end) {
        final Clip c = clips.get(s);
        if (c == null) {
            return;
        }
        if (c.isRunning()) {
            c.stop();
        }
        c.setLoopPoints(start, end);
        c.setFramePosition(frame);
        c.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void setPosition(final String s, final int frame) {
        clips.get(s).setFramePosition(frame);
    }

    public static int getFrames(final String s) {
        return clips.get(s).getFrameLength();
    }

    public static int getPosition(final String s) {
        return clips.get(s).getFramePosition();
    }

    public static void close(final String s) {
        stop(s);
        clips.get(s).close();
    }

    public static void setVolume(final String s, final float f) {
        Clip c = clips.get(s);
        if (c == null) {
            return;
        }
        vol = (FloatControl) c.getControl(FloatControl.Type.MASTER_GAIN);
        vol.setValue(f);
    }

    public static boolean isPlaying(final String s) {
        Clip c = clips.get(s);
        if (c == null) {
            return false;
        }
        return c.isRunning();
    }
}
