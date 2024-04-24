package Flyweight;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterPropertiesTest {
    private CharacterProperties props;

    @BeforeEach
    public void setup() {
        props = new CharacterProperties("Arial", "Red", 12);  // Example initialization
    }

    @Test
    public void testInitialization() {
        assertNotNull(props);  // Ensure object is created
        assertEquals("Arial", props.getFont());
        assertEquals("Red", props.getColor());
        assertEquals(12, props.getSize());
    }

    @Test
    public void testEquality() {
        CharacterProperties sameProps = new CharacterProperties("Arial", "Red", 12);
        assertEquals(props, sameProps);
    }

    @Test
    public void testHashCode() {
        CharacterProperties sameProps = new CharacterProperties("Arial", "Red", 12);
        assertEquals(props.hashCode(), sameProps.hashCode());
    }

    @Test
    public void testNotEqualWithDifferentProperties() {
        CharacterProperties differentProps = new CharacterProperties("Calibri", "Blue", 14);
        assertNotEquals(props, differentProps);
    }
}
