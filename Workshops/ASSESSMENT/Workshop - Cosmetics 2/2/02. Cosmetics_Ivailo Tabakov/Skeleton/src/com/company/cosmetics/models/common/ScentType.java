package com.company.cosmetics.models.common;

public enum ScentType {
    LAVENDER,
    VANILLA,
    ROSE;

    public static final String SCENTTYPE_ERROR = "Scent type can be \"Lavender\", \"Vanilla\" or \"Rose\".";
    
    @Override
    public String toString() {
        switch (this) {
            case ROSE:
                return "Rose";
            case VANILLA:
                return "Vanilla";
            case LAVENDER:
                return "Lavender";
            default:
                throw new IllegalArgumentException(SCENTTYPE_ERROR);
        }
    }
}
