package com.projectAthena.core.enums;

public enum ThemeType {

    Mythos((short)1,"Mythos"),
    Logos((short)2,"Logos"),
    Mist((short)3,"Mist"),
    Crew((short)4,"Crew"),
    Extra((short)5,"Extra");


    private final short id;
    private final String name;

    ThemeType(short id, String name) {
        this.id = id;
        this.name = name;
    };


    public short getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
