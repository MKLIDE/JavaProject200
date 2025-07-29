package com.moodifyx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class MoodSelectorUI extends JFrame {
    private final MoodRepository repository = new MoodRepository();
    private JComboBox<String> moodDropdown;
    private JPanel subMoodPanel;
    private List<JCheckBox> subMoodCheckboxes = new ArrayList<>();

    public MoodSelectorUI() {
        setTitle("Moodifyx - Select Your Mood");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setupUI();
    }

    private void setupUI() {
        JPanel panel = new JPanel(new BorderLayout());
        
        // Mood selection
        JPanel selectionPanel = new JPanel(new GridLayout(2, 1));
        moodDropdown = new JComboBox<>(repository.getAllMoods().toArray(new String[0]));
        moodDropdown.addActionListener(this::updateSubMoodSelection);

        JPanel moodPanel = new JPanel();
        moodPanel.add(new JLabel("Select Mood:"));
        moodPanel.add(moodDropdown);

        // Sub-mood selection
        subMoodPanel = new JPanel();
        subMoodPanel.setVisible(false);

        selectionPanel.add(moodPanel);
        selectionPanel.add(subMoodPanel);

        // Launch button
        JButton launchBtn = new JButton("Start Player");
        launchBtn.addActionListener(e -> launchPlayer());

        panel.add(selectionPanel, BorderLayout.CENTER);
        panel.add(launchBtn, BorderLayout.SOUTH);
        add(panel);
        updateSubMoodSelection(null);
    }

    private void updateSubMoodSelection(ActionEvent e) {
        String mood = (String) moodDropdown.getSelectedItem();
        subMoodPanel.removeAll();
        subMoodCheckboxes.clear();

        if (repository.hasSubMoods(mood)) {
            subMoodPanel.setVisible(true);
            subMoodPanel.add(new JLabel("Select Sub-Moods:"));
            
            for (String subMood : repository.getSubMoods(mood)) {
                JCheckBox checkBox = new JCheckBox(subMood);
                subMoodCheckboxes.add(checkBox);
                subMoodPanel.add(checkBox);
            }
        } else {
            subMoodPanel.setVisible(false);
        }
        revalidate();
    }

    private List<String> getSelectedSubMoods() {
        return subMoodCheckboxes.stream()
            .filter(JCheckBox::isSelected)
            .map(JCheckBox::getText)
            .collect(Collectors.toList());
    }

    private void launchPlayer() {
        String mood = (String) moodDropdown.getSelectedItem();
        List<String> subMoods = getSelectedSubMoods();
        repository.createPlaylist(mood, subMoods);
        
        new MusicPlayerUI(repository).setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MoodSelectorUI().setVisible(true));
    }
}