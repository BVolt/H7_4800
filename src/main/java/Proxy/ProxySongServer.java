package Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProxySongServer implements SongService {
    private SongServer songServer;
    private Map<Integer, Song> songCache;
    private Map<String, List<Song>> titleCache;
    private Map<String, List<Song>> albumCache;

    public ProxySongServer(SongServer songServer) {
        this.songServer = songServer;
        songCache = new HashMap<>();
        titleCache = new HashMap<>();
        albumCache = new HashMap<>();
    }

    @Override
    public Song searchById(Integer songID) {
        if (songCache.containsKey(songID)) {
            return songCache.get(songID);
        }
        Song song = songServer.searchById(songID);
        songCache.put(songID, song);
        return song;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        if (titleCache.containsKey(title)) {
            return titleCache.get(title);
        }
        List<Song> songs = songServer.searchByTitle(title);
        titleCache.put(title, songs);
        return songs;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        if (albumCache.containsKey(album)) {
            return albumCache.get(album);
        }
        List<Song> songs = songServer.searchByAlbum(album);
        albumCache.put(album, songs);
        return songs;
    }
}


