package com.projectAthena.core.usecases;

import com.projectAthena.core.enums.ThemeType;
import lombok.val;

import java.util.EnumSet;

public class ThemeTypeEnumList {

    public static final EnumSet<ThemeType> allThemes = EnumSet.range(ThemeType.Mythos, ThemeType.Extra);


    public static ThemeType FindThemeTypeByKey(short id) {
        return  getFirstOrDefaultThemeTypeById(id);
    }

    public static ThemeType findThemeTypeByName(String name) {
        return  getFirstOrDefaultThemeTypeByName(name);
    }


    public static ThemeType GetThemeTypeByKey(short id) throws ThemeNotFoundException {
        val foundTheme = getFirstOrDefaultThemeTypeById(id);
        if (foundTheme == null) {
            throw new ThemeNotFoundException();
        }
        return  foundTheme;
    }

    public static ThemeType GetThemeTypeByName(String name) throws ThemeNotFoundException {
        val foundTheme = getFirstOrDefaultThemeTypeByName(name);
        if (foundTheme == null) {
            throw new ThemeNotFoundException();
        }
        return  foundTheme;
    }

    private static ThemeType getFirstOrDefaultThemeTypeByName(String name) {
        return allThemes.stream()
                .filter(tb -> tb.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    private static ThemeType getFirstOrDefaultThemeTypeById(short id) {
        return allThemes.stream()
                .filter(tb -> tb.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
