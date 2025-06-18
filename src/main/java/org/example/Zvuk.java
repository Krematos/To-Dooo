package org.example;

import javax.sound.sampled.*;
import java.io.IOException;

public class Zvuk {
    public static void prehratZvukSplneni(){
        try{
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(
                    Zvuk.class.getClassLoader().getResource("zvuk/423990__amishrob__car-horn-beep-beep-two-beeps-honk-honk.wav")
            );
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start(); // přehraje zvuk
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            e.printStackTrace();
        }
    }

    public static void prehratZvukPridaniUkolu(){
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(
                    Zvuk.class.getClassLoader().getResource("zvuk/479351__grasopt__car-engine-starting.wav")    // cesta ke zvuku
            );
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start(); // přehraje zvuk
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            e.printStackTrace();
        }
        }
    }

