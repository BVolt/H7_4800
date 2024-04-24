package Flyweight;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {
    private CharacterProperties props;

    @BeforeEach
    public void setup() {
        props = new CharacterProperties("Arial", "Red", 12);
    }

    @Test
    public void testCharacterProperties() {
        Character ch = new Character('A', props);

        assertEquals('A', ch.getCharacter());
        assertSame(props, ch.getProperties());
    }

    @Test
    public void testToString() {
        Character ch = new Character('A', props);
        String expected = "A (Arial, Red, 12)";

        assertEquals(expected, ch.toString());  // Check the string representation
    }
}
