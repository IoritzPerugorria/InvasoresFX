package com.aetxabao.invasoresfx.game;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

import static com.aetxabao.invasoresfx.game.AppConsts.shotSFX;


public class AudioManager {
    static Clip clip;
    public static void reproducirSonido(File audio){
       try{
        AudioInputStream sfx = AudioSystem.getAudioInputStream(audio);
        clip = AudioSystem.getClip();
        clip.open(sfx);
        clip.start();
       }
       catch (Exception e){
           e.printStackTrace();
       }
    }
}
