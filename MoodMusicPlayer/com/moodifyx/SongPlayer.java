package com.moodifyx;

import javax.sound.sampled.*;
import java.io.File;
import javazoom.jl.player.Player;
import java.io.FileInputStream;

public class SongPlayer {
    private static Clip clip;
    private static Player mp3Player;
    private static long clipPosition;
    private static boolean isPaused;
    
    public static void play(String filePath) {
        try {
            stop(); // Stop any currently playing track
            
            if (filePath.endsWith(".mp3")) {
                playMP3(filePath);
            } else {
                playWav(filePath);
            }
            isPaused = false;
        } catch (Exception ex) {
            System.err.println("Error playing sound: " + ex.getMessage());
        }
    }
    
    public static void pause() {
        if (clip != null && clip.isRunning()) {
            clipPosition = clip.getMicrosecondPosition();
            clip.stop();
            isPaused = true;
        }
        if (mp3Player != null) {
            try {
                mp3Player.close();
            } catch (Exception e) {
                System.err.println("Error pausing MP3: " + e.getMessage());
            }
            isPaused = true;
        }
    }
    
    public static void resume() {
        if (clip != null && isPaused) {
            clip.setMicrosecondPosition(clipPosition);
            clip.start();
            isPaused = false;
        }
        if (mp3Player != null && isPaused) {
            // For MP3, we need to restart from beginning
            play(clip != null ? clip.toString() : "");
        }
    }
    
    public static void stop() {
        if (clip != null) {
            clip.stop();
            clip.close();
            clip = null;
        }
        if (mp3Player != null) {
            mp3Player.close();
            mp3Player = null;
        }
        isPaused = false;
    }
    
    public static void togglePlayPause() {
        if (isPaused) {
            resume();
        } else {
            pause();
        }
    }
    
    private static void playMP3(String filePath) throws Exception {
        mp3Player = new Player(new FileInputStream(filePath));
        new Thread(() -> {
            try {
                mp3Player.play();
            } catch (Exception e) {
                System.err.println("MP3 playback error: " + e.getMessage());
            }
        }).start();
    }
    
    private static void playWav(String filePath) throws Exception {
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(filePath));
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }
    
    public static boolean isPlaying() {
        return (clip != null && clip.isRunning()) || (mp3Player != null && !isPaused);
    }
    public static void stopAndExit() {
        if (clip != null) {
            clip.stop();
            clip.close();
            clip = null;
        }
        if (mp3Player != null) {
            mp3Player.close();
            mp3Player = null;
        }
        isPaused = false;
        clipPosition = 0;
    }
}