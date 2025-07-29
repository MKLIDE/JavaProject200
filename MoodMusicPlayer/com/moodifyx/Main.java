package com.moodifyx;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Ensures GUI runs on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            MoodSelectorUI moodSelector = new MoodSelectorUI();
            moodSelector.setVisible(true);
        });
    }
}
