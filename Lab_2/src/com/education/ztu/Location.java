package com.education.ztu;

public enum Location {
    KIEV,
    ZHYTOMYR,
    VINNYTSYA,
    RIVNE;

    Location() {}

    public Location valueOfLocation(String name) {
        return Enum.valueOf(Location.class, name);
    }

    public static Location[] valuesLocatio() {
        return new Location[]{KIEV, ZHYTOMYR, VINNYTSYA, RIVNE};
    }
}
