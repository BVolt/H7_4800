package Flyweight;

import java.util.*;

public class CharacterPropertiesFactory {
    private final Map<CharacterProperties, CharacterProperties> propertiesMap = new HashMap<>();

    public CharacterProperties getProperties(String font, String color, int size) {
        CharacterProperties newProps = new CharacterProperties(font, color, size);
        propertiesMap.putIfAbsent(newProps, newProps);
        return propertiesMap.get(newProps);
    }
}