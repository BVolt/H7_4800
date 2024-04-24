package Flyweight;
import java.util.*;

public class CharacterProperties {
    private final String font;
    private final String color;
    private final int size;

    public CharacterProperties(String font, String color, int size) {
        this.font = font;
        this.color = color;
        this.size = size;
    }

    public String getFont() {
        return font;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CharacterProperties)) return false;
        CharacterProperties that = (CharacterProperties) o;
        return size == that.size &&
                font.equals(that.font) &&
                color.equals(that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(font, color, size);
    }
}
