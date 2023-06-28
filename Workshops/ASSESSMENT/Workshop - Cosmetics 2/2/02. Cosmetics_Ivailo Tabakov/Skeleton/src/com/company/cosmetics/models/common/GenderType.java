package com.company.cosmetics.models.common;

public enum GenderType {
    MEN,
    WOMEN,
    UNISEX;

    public static final String GENDERTYPE_ERROR = "Gender type can be \"Men\", \"Women\" or \"Unisex\".";

    @Override
    public String toString() {
        switch (this) {
            case MEN:
                return "Men";
            case WOMEN:
                return "Women";
            case UNISEX:
                return "Unisex";
            default:
                throw new IllegalArgumentException(GENDERTYPE_ERROR);
        }
    }
}
