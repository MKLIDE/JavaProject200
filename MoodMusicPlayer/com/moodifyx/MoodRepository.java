package com.moodifyx;

import java.util.*;
import java.util.stream.Collectors;

public class MoodRepository {
    private final Map<String, List<Song>> moodPlaylists = new HashMap<>();
    private final Map<String, List<String>> moodSubcategories = new HashMap<>();
    private List<Song> currentPlaylist;
    private int currentTrackIndex = -1;
    
    public MoodRepository() {
        initializeMoodSongs();
    }
    
    private void initializeMoodSongs() {
        // Define sub-moods for the "Mood" category
        moodSubcategories.put("Mood", Arrays.asList(
            "Happy", "Angry", "Chill", "Misterious", 
            "Moody", "Practice", "Romantic", "Peaceful", "Positive"
        ));
        
        // Initialize all songs
        Map<String, String[][]> moodFiles = Map.of(
            "Mood", new String[][]{
                {"mood/happy/happygirl.wav", "mood/happy/happygirlie.wav"},
                {"mood/angry/angrygirl.wav", "mood/angry/angrygirlie.wav"},
                {"mood/chill/chillgirl.wav", "mood/chill/chillgirlie.wav"},
                {"mood/misterious/misteriousgirl.wav", "mood/misterious/misteriousgirlie.wav"},
                {"mood/moody/moodygirl.wav", "mood/moody/moodygirlie.wav"},
                {"mood/practice/practicegirl.wav", "mood/practice/practicegirlie.wav"},
                {"mood/romance/romanticgirl.wav", "mood/romance/romanticgirlie.wav"},
                {"mood/peace/peacefulgirl.wav", "mood/peace/peacefulgirlie.wav"},
                {"mood/positive/positivegirl.wav", "mood/positive/positivegirlie.wav"}
                , {"mood/Hustle/positivegirlie.wav"}
            },
            "Amapiano",new String[][]{{"02. Ngyozama (feat. Sykes, Young Stunna, Nkosazana Daughter, Tracy & Thatohatsi).mp3",
                                         "amapiano/12. Izimbali (feat. Thatohatsi & Murumba Pitch).mp3"}},
            "Hiphop",new String[][]{{"hiphop/13. New Sofas",
                                        "hiphop/18. Momma"}},
            "Dance",new String[][]{{"dance/07. SOS (feat. Aloe Blacc).mp3",
                                        "dance/11. Silhouettes.mp3"}},
            "Rnb",new String[][]{{"rnb/01. MUD.mp3",
                                     "rnb/02. RATHER BE.mp3"}},
            "Pop",new String[][]{{"pop/01. ALL I CAN TAKE.mp3",
                                     "pop/05. THINGS YOU DO.mp3"}}
        );
        
        for(Map.Entry<String, String[][]> entry : moodFiles.entrySet()) {
            addMood(entry.getKey(), entry.getValue());
        }
    }
    
    private void addMood(String mood, String[][] moodFiles) {
        List<Song> songs = new ArrayList<>();
        for(String[] moodFile : moodFiles) {
            for(String file : moodFile) {
                songs.add(new Song(formatTitle(file), "music/" + file));
            }
        }
        moodPlaylists.put(mood, songs);
    }
    
    private String formatTitle(String fileName) {
        String name = fileName.substring(fileName.lastIndexOf('/') + 1);
        name = name.replace(".wav", "").replace(".mp3", "");
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
    
    public List<String> getSubMoods(String mood) {
        return moodSubcategories.getOrDefault(mood, Collections.emptyList());
    }
    
    public boolean hasSubMoods(String mood) {
        return moodSubcategories.containsKey(mood);
    }
    
    public void createPlaylist(String mood, List<String> selectedSubMoods) {
        if (!hasSubMoods(mood)) {
            currentPlaylist = new ArrayList<>(moodPlaylists.getOrDefault(mood, Collections.emptyList()));
            return;
        }
        
        currentPlaylist = moodPlaylists.getOrDefault(mood, Collections.emptyList()).stream()
            .filter(song -> {
                String path = song.getFilePath().toLowerCase();
                return selectedSubMoods.stream()
                    .anyMatch(sub -> path.contains("/" + sub.toLowerCase() + "/"));
            })
            .collect(Collectors.toList());
        
        currentTrackIndex = -1;
    }
    
    public Song getNextTrack() {
        if (currentPlaylist == null || currentPlaylist.isEmpty()) {
            return null;
        }
        
        currentTrackIndex = (currentTrackIndex + 1) % currentPlaylist.size();
        return currentPlaylist.get(currentTrackIndex);
    }
    
    public Song getPreviousTrack() {
        if (currentPlaylist == null || currentPlaylist.isEmpty()) {
            return null;
        }
        
        currentTrackIndex = (currentTrackIndex - 1 + currentPlaylist.size()) % currentPlaylist.size();
        return currentPlaylist.get(currentTrackIndex);
    }
    
    public Song getCurrentTrack() {
        if (currentPlaylist == null || currentPlaylist.isEmpty() || currentTrackIndex < 0) {
            return null;
        }
        return currentPlaylist.get(currentTrackIndex);
    }

    public void shufflePlaylist() {
        if (currentPlaylist != null && !currentPlaylist.isEmpty()) {
            Collections.shuffle(currentPlaylist);
            currentTrackIndex = 0; // Reset to first track after shuffle
        }
    }
        // Add these new methods:
    public void shuffleCurrentMood() {
        if (currentPlaylist != null) {
            Collections.shuffle(currentPlaylist);
            currentTrackIndex = 0;
        }
    }

    public void shuffleAllMoods() {
        List<Song> allSongs = new ArrayList<>();
        for (List<Song> moodSongs : moodPlaylists.values()) {
            allSongs.addAll(moodSongs);
        }
        Collections.shuffle(allSongs);
        currentPlaylist = allSongs;
        currentTrackIndex = 0;
    }
    public Set<String> getAllMoods() {
        return moodPlaylists.keySet();
    }
}