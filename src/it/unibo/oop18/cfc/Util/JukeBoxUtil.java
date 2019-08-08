package it.unibo.oop18.cfc.Util;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.BooleanControl;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 * Global audio player class. Call init() as soon as possible to instantiate the
 * clips HashMap.
 */
public final class JukeBoxUtil {

    private static Map<String, Clip> clips;
    private static int gap;
    private static int volume = 15;

    private JukeBoxUtil() {

    }

    /**
     * Creates new clips HashMap.
     */
    public static void init() {
        clips = new HashMap<String, Clip>();
        gap = 0;
    }

    /**
     * Loads up audio located at path "s" and stores it in the HashMap with key "n".
     * 
     * @param s path
     * @param n key
     */
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
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Play the clip.
     * 
     * @param s clip name
     */
    public static void play(final String s) {
        play(s, gap);
    }

    /**
     * Play the clip.
     * 
     * @param s clip name
     * @param i TODO
     */
    public static void play(final String s, final int i) {
        final Clip c = clips.get(s);
        float f;
        f = (float) (getVolume() * 0.06);
        setVolume(s, f);
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
    }

    /**
     * Stop clip.
     * 
     * @param s clip name
     */
    public static void stop(final String s) {
        if (clips.get(s) == null) {
            return;
        }
        if (clips.get(s).isRunning()) {
            clips.get(s).stop();
        }
    }

    /**
     * Resume clip playing.
     * 
     * @param s clip name
     */
    public static void resume(final String s) {
        if (clips.get(s).isRunning()) {
            return;
        }
        clips.get(s).start();
    }

    /**
     * Restart loop.
     * 
     * @param s clip name
     */
    public static void resumeLoop(final String s) {
        final Clip c = clips.get(s);
        if (c == null) {
            return;
        }
        c.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * Loop the clips.
     * 
     * @param s clip name
     */
    public static void loop(final String s) {
        loop(s, gap, gap, clips.get(s).getFrameLength() - 1);
    }

    /**
     * Loop the clips.
     * 
     * @param s     clip name
     * @param frame number
     */
    public static void loop(final String s, final int frame) {
        loop(s, frame, gap, clips.get(s).getFrameLength() - 1);
    }

    /**
     * Loop the clips.
     * 
     * @param s     clip name
     * @param start position
     * @param end   position
     */
    public static void loop(final String s, final int start, final int end) {
        loop(s, gap, start, end);
    }

    /**
     * Loop the clips.
     * 
     * @param s     clip name
     * @param frame number
     * @param start position
     * @param end   position
     */
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

    /**
     * Set position clip
     * 
     * @param s     clip name
     * @param frame frame to be setted
     */
    public static void setPosition(final String s, final int frame) {
        clips.get(s).setFramePosition(frame);
    }

    /**
     * Return frames.
     * 
     * @param s clip name
     * @return frames length
     */
    public static int getFrames(final String s) {
        return clips.get(s).getFrameLength();
    }

    /**
     * Return clip position.
     * 
     * @param s clip name
     * @return position int
     */
    public static int getPosition(final String s) {
        return clips.get(s).getFramePosition();
    }

    /**
     * Close clips
     * 
     * @param s clip name
     */
    public static void close(final String s) {
        stop(s);
        clips.get(s).close();
    }

    /**
     * Set volume.
     * 
     * @param s name clip
     * @param f value volume
     */
    public static void setVolume(final String s, final float f) {
        final Clip c = clips.get(s);
        if (c == null) {
            return;
        }
        final BooleanControl muteControl = (BooleanControl) c.getControl(BooleanControl.Type.MUTE);
        if (f == 0) {
            muteControl.setValue(true);
        } else {
            muteControl.setValue(false);
        }
        final FloatControl gainControl = (FloatControl) c.getControl(FloatControl.Type.MASTER_GAIN);
        final double gain = f / 3; // number between 0 and 2 (loudest)
        final float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
        gainControl.setValue(dB);

        // System.out.println(dB);
    }

    /**
     * Return clip status.
     * 
     * @param s clip name
     * @return boolean status
     */
    public static boolean isPlaying(final String s) {
        final Clip c = clips.get(s);
        if (c == null) {
            return false;
        }
        return c.isRunning();
    }

    /**
     * Volume getter.
     * 
     * @return actual volume
     */
    public static int getVolume() {
        return volume;
    }

    /**
     * Volume setter
     * 
     * @param volume to be setted
     */
    public static void setVolume(int volume) {
        JukeBoxUtil.volume = volume;
    }

}
