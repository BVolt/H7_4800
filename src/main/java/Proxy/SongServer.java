package Proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongServer implements SongService {
    private Map<Integer, Song> songDatabase;

    public SongServer() {
        songDatabase = new HashMap<>();
    }

    public void addSong(Integer id, Song song) {
        songDatabase.put(id, song);
    }

    @Override
    public Song searchById(Integer songID) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        return songDatabase.get(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        List<Song> result = new ArrayList<>();
        for (Song song : songDatabase.values()) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                result.add(song);
            }
        }
        return result;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        try {
            Thread.sleep(1000);
        }catch (Exception e) {}
            List<Song> result = new ArrayList<>();
            for (Song song : songDatabase.values()) {
                if (song.getAlbum().equalsIgnoreCase(album)) {
                    result.add(song);
                }
            }
            return result;
        }
    }
