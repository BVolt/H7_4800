package Flyweight;

import java.io.*;

public class TextEditor {
    public static void main(String[] args) throws IOException {
        CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
        CharacterProperties editorSettings = factory.getProperties("Arial", "Red", 12);
        Document doc = new Document();

        doc.addCharacter('H', editorSettings);
        doc.addCharacter('e', editorSettings);
        doc.addCharacter('l', editorSettings);

        editorSettings = factory.getProperties("Calibri", "Blue", 14);
        doc.addCharacter('l', editorSettings);
        doc.addCharacter('o', editorSettings);
        doc.addCharacter('W', editorSettings);

        editorSettings = factory.getProperties("Verdana", "Black", 16);
        doc.addCharacter('o', editorSettings);
        doc.addCharacter('r', editorSettings);

        editorSettings = factory.getProperties("Courier New", "Green", 13);
        doc.addCharacter('l', editorSettings);
        doc.addCharacter('d', editorSettings);
        doc.addCharacter('C', editorSettings);

        // 4th change
        editorSettings = factory.getProperties("Georgia", "Orange", 15);
        doc.addCharacter('S', editorSettings);
        doc.addCharacter('5', editorSettings);
        doc.addCharacter('8', editorSettings);
        doc.addCharacter('0', editorSettings);
        doc.addCharacter('0', editorSettings);

        System.out.println("Document content with properties:");
        doc.printDocument();
        doc.editCharacter(3, 'L', editorSettings);

        doc.saveToFile("document.txt");

        Document loadedDoc = new Document();
        loadedDoc.loadFromFile("document.txt");

        System.out.println("\nLoaded saved document with single edit:");
        loadedDoc.printDocument();
    }
}
