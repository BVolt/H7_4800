package Flyweight;
import java.io.*;
import java.util.*;

public class Document {
    private final List<Character> characters = new ArrayList<>();

    public void addCharacter(char c, CharacterProperties properties) {
        characters.add(new Character(c, properties));
    }

    public void saveToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Character character : characters) {
                writer.write(character.getCharacter() + "," +
                        character.getProperties().getFont() + "," +
                        character.getProperties().getColor() + "," +
                        character.getProperties().getSize() + "\n");
            }
        }
    }

    public void loadFromFile(String filename) throws IOException {
        characters.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    char ch = parts[0].charAt(0);
                    String font = parts[1];
                    String color = parts[2];
                    int size = Integer.parseInt(parts[3]);
                    CharacterProperties props = new CharacterProperties(font, color, size);
                    characters.add(new Character(ch, props));
                }
            }
        }
    }

    public void editCharacter(int index, char c, CharacterProperties properties) {
        if (index >= 0 && index < characters.size()) {
            characters.set(index, new Character(c, properties));
        } else {
            throw new IndexOutOfBoundsException("Invalid character index.");
        }
    }

    public void printDocument() {
        for (Character c : characters) {
            System.out.println(c);
        }
    }

    public List<Character> getCharacters() {
        return Collections.unmodifiableList(characters);
    }

    public int getCharacterCount() {
        return characters.size();
    }

    public Character getCharacter(int index) {
        if (index >= 0 && index < characters.size()) {
            return characters.get(index);
        }
        throw new IndexOutOfBoundsException("Invalid character index.");
    }
}


