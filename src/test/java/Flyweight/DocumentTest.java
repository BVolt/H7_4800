package Flyweight;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class DocumentTest {
    private Document doc;

    @BeforeEach
    public void setup() {
        doc = new Document();
    }

    @Test
    public void testAddCharacter() {
        CharacterProperties arialRed12 = new CharacterProperties("Arial", "Red", 12);
        doc.addCharacter('H', arialRed12);

        assertEquals(1, doc.getCharacterCount());

        Character firstChar = doc.getCharacter(0);
        assertEquals('H', firstChar.getCharacter());
        assertEquals("Arial", firstChar.getProperties().getFont());
        assertEquals("Red", firstChar.getProperties().getColor());
        assertEquals(12, firstChar.getProperties().getSize());
    }

    @Test
    public void testSaveLoad() throws IOException {
        CharacterProperties arialRed12 = new CharacterProperties("Arial", "Red", 12);
        CharacterProperties calibriBlue14 = new CharacterProperties("Calibri", "Blue", 14);

        doc.addCharacter('H', arialRed12);
        doc.addCharacter('e', calibriBlue14);

        String filename = "test_document.txt";

        doc.saveToFile(filename);

        Document loadedDoc = new Document();
        loadedDoc.loadFromFile(filename);

        assertEquals(2, loadedDoc.getCharacterCount());

        Character firstChar = loadedDoc.getCharacter(0);
        assertEquals('H', firstChar.getCharacter());
        assertEquals("Arial", firstChar.getProperties().getFont());
        assertEquals("Red", firstChar.getProperties().getColor());
        assertEquals(12, firstChar.getProperties().getSize());

        Character secondChar = loadedDoc.getCharacter(1);
        assertEquals('e', secondChar.getCharacter());
        assertEquals("Calibri", secondChar.getProperties().getFont());
        assertEquals("Blue", secondChar.getProperties().getColor());
        assertEquals(14, secondChar.getProperties().getSize());

        File file = new File(filename);
        if (file.exists()) {
            file.delete();
        }
    }
}


