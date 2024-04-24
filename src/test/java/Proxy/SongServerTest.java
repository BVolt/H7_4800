package Proxy;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class SongServerTest {
    private SongServer songServer;

    @BeforeEach
    public void setUp() {
        songServer = new SongServer();

        songServer.addSong(1, new Song("Come As You Are", "Nirvana", "Nevermind", 219));
        songServer.addSong(2, new Song("Bohemian Rhapsody", "Queen", "A Night at the Opera", 354));
        songServer.addSong(3, new Song("Smells Like Teen Spirit", "Nirvana", "Nevermind", 301));
        songServer.addSong(4, new Song("Yellow", "Coldplay", "Parachutes", 269));
        songServer.addSong(5, new Song("Yellow", "Amarillo", "Greatest Hits", 252));
    }

    @Test
    public void testSearchById() {
        Song song = songServer.searchById(1);
        assertNotNull(song);
        assertEquals("Come As You Are", song.getTitle());

        Song cachedSong = songServer.searchById(1);
        assertSame(song, cachedSong);
    }

    @Test
    public void testSearchByTitle() {
        List<Song> songs = songServer.searchByTitle("Yellow");
        assertFalse(songs.isEmpty());
        assertTrue(songs.stream().anyMatch(song -> song.getTitle().equals("Yellow")));

        List<Song> noSongs = songServer.searchByTitle("Nonexistent");
        assertTrue(noSongs.isEmpty());
    }

    @Test
    public void testAddSong() {
        Song newSong = new Song("Sweet Child O' Mine", "Guns N' Roses", "Appetite for Destruction", 356);
        songServer.addSong(6, newSong);

        Song retrievedSong = songServer.searchById(6);
        assertNotNull(retrievedSong);
        assertEquals("Sweet Child O' Mine", retrievedSong.getTitle());
    }
}