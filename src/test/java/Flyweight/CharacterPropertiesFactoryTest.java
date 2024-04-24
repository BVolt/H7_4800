package Flyweight;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterPropertiesFactoryTest {
    private CharacterPropertiesFactory factory;

    @BeforeEach
    public void setup() {
        factory = new CharacterPropertiesFactory();
    }

    @Test
    public void testUniqueProperties() {
        CharacterProperties props1 = factory.getProperties("Arial", "Red", 12);
        CharacterProperties props2 = factory.getProperties("Calibri", "Blue", 14);

        assertNotNull(props1);
        assertNotNull(props2);
        assertNotEquals(props1, props2);
    }

    @Test
    public void testReusedProperties() {
        CharacterProperties props1 = factory.getProperties("Arial", "Red", 12);
        CharacterProperties props1Again = factory.getProperties("Arial", "Red", 12);

        assertSame(props1, props1Again);
    }
}
