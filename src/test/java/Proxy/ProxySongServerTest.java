package Proxy;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ProxySongServerTest {
    private SongServer songServer;
    private ProxySongServer proxySongServer;

    @BeforeEach
    public void setUp() {
        songServer = new SongServer();
        proxySongServer = new ProxySongServer(songServer);

        songServer.addSong(1, new Song("Come As You Are", "Nirvana", "Nevermind", 219));
        songServer.addSong(2, new Song("Bohemian Rhapsody", "Queen", "A Night at the Opera", 354));
        songServer.addSong(3, new Song("Smells Like Teen Spirit", "Nirvana", "Nevermind", 301));
        songServer.addSong(4, new Song("Yellow", "Coldplay", "Parachutes", 269));
        songServer.addSong(5, new Song("Yellow", "Amarillo", "Greatest Hits", 252));
    }

    @Test
    public void testSearchById() {
        Song song = proxySongServer.searchById(1);
        assertNotNull(song);
        assertEquals("Come As You Are", song.getTitle());

        Song cachedSong = proxySongServer.searchById(1);
        assertSame(song, cachedSong);
    }

    @Test
    public void testSearchByTitle() {
        List<Song> songs = proxySongServer.searchByTitle("Yellow");
        assertFalse(songs.isEmpty());
        assertTrue(songs.stream().anyMatch(song -> song.getTitle().equals("Yellow")));

        List<Song> cachedSongs = proxySongServer.searchByTitle("Yellow");
        assertSame(songs, cachedSongs);
    }

    @Test
    public void testSearchByAlbum() {
        List<Song> songs = proxySongServer.searchByAlbum("Nevermind");
        assertFalse(songs.isEmpty());
        assertTrue(songs.stream().anyMatch(song -> song.getAlbum().equals("Nevermind")));

        List<Song> cachedSongs = proxySongServer.searchByAlbum("Nevermind");
        assertSame(songs, cachedSongs);
    }
}
