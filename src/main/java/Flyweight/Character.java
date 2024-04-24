package Flyweight;

public class Character {
    private final char character;
    private final CharacterProperties properties;

    public Character(char character, CharacterProperties properties) {
        this.character = character;
        this.properties = properties;
    }

    public char getCharacter() {
        return character;
    }

    public CharacterProperties getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return String.valueOf(character) +
                " (" + properties.getFont() + ", " +
                properties.getColor() + ", " +
                properties.getSize() + ")";
    }
}
