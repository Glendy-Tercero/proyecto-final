package sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
    public static void playSound(String soundFileName) {
        try {
            File soundFile = new File(soundFileName);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
