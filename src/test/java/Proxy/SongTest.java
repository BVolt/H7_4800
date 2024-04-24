package Proxy;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SongTest {
    private Song song;

    @BeforeEach
    public void setUp() {
        song = new Song("Smells Like Teen Spirit", "Nirvana", "Nevermind", 301);
    }

    @Test
    public void testSongCreation() {
        assertNotNull(song);
        assertEquals("Smells Like Teen Spirit", song.getTitle());
        assertEquals("Nirvana", song.getArtist());
        assertEquals("Nevermind", song.getAlbum());
        assertEquals(301, song.getDuration());
    }

    @Test
    public void testToString() {
        String expectedString = "{Smells Like Teen Spirit, Nirvana, Nevermind, 301}";
        assertEquals(expectedString, song.toString());
    }
}