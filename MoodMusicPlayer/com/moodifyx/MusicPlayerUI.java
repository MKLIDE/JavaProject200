package com.moodifyx;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionEvent;

public class MusicPlayerUI extends JFrame {
    private final MoodRepository repository;
    private JLabel trackLabel;

    public MusicPlayerUI(MoodRepository repository) {
        this.repository = repository;
        setTitle("Moodifyx - Now Playing");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setupPlayerUI();
    }

    private void setupPlayerUI() {
        JPanel panel = new JPanel(new BorderLayout());
        
        // Track info
        trackLabel = new JLabel("Select a track", SwingConstants.CENTER);
        trackLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(trackLabel, BorderLayout.NORTH);

        // Player controls
        JPanel controls = new JPanel();
        JButton prevBtn = new JButton("⏮");
        JButton playBtn = new JButton("▶");
        JButton pauseBtn = new JButton("⏸");
        JButton stopBtn = new JButton("⏹");
        JButton nextBtn = new JButton("⏭");
        JButton moodShuffleBtn = new JButton("🔀 Current Mood");
        JButton globalShuffleBtn = new JButton("🌍 Global Shuffle");
        JButton exitBtn = new JButton("Exit");

        prevBtn.addActionListener(e -> playPrevious());
        playBtn.addActionListener(e -> playCurrent());
        pauseBtn.addActionListener(e -> SongPlayer.pause());
        stopBtn.addActionListener(e -> stopPlayback());
        nextBtn.addActionListener(e -> playNext());
        exitBtn.addActionListener(e -> dispose());
        moodShuffleBtn.addActionListener(e -> {
            repository.shuffleCurrentMood();
            playCurrent();
            showShuffleNotification("Shuffled current mood");
        });

        globalShuffleBtn.addActionListener(e -> {
            repository.shuffleAllMoods();
            playCurrent();
            showShuffleNotification("Shuffled all moods");
        });

        controls.add(prevBtn);
        controls.add(playBtn);
        controls.add(pauseBtn);
        controls.add(stopBtn);
        controls.add(nextBtn);
        controls.add(moodShuffleBtn);
        controls.add(globalShuffleBtn);
        controls.add(exitBtn);

        panel.add(controls, BorderLayout.CENTER);
        add(panel);

        // Auto-play first track
        playNext();
    }

    private void playCurrent() {
        Song song = repository.getCurrentTrack();
        if (song != null) {
            updateTrackInfo(song);
            SongPlayer.play(song.getFilePath());
        }
    }

    private void playNext() {
        Song song = repository.getNextTrack();
        if (song != null) {
            updateTrackInfo(song);
            SongPlayer.play(song.getFilePath());
        }
    }

    private void playPrevious() {
        Song song = repository.getPreviousTrack();
        if (song != null) {
            updateTrackInfo(song);
            SongPlayer.play(song.getFilePath());
        }
    }

    private void stopPlayback() {
        SongPlayer.stop();
        trackLabel.setText("Playback stopped");
    }

    private void updateTrackInfo(Song song) {
        String[] pathParts = song.getFilePath().split("/");
        String mood = pathParts.length > 2 ? pathParts[1] : "General";
        trackLabel.setText(String.format(
            "<html>Now Playing: <b>%s</b><br>Mood: %s</html>",
            song.getTitle(),
            mood
        ));
    }
    private void showShuffleNotification(String message) {
        JOptionPane.showMessageDialog(this, message, 
            "Shuffle Complete", JOptionPane.INFORMATION_MESSAGE);
    }
}
