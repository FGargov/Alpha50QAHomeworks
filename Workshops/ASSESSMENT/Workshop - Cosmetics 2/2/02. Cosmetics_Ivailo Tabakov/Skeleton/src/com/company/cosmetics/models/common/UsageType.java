package com.company.cosmetics.models.common;

public enum UsageType {
    EVERYDAY,
    MEDICAL;

    public static final String USAGETYPE_ERROR = "Usage type can be \"Everyday\" or \"Medical\".";

    @Override
    public String toString() {
        switch (this) {
            case EVERYDAY:
                return "EveryDay";
            case MEDICAL:
                return "Medical";
            default:
                throw new IllegalArgumentException(USAGETYPE_ERROR);
        }
    }
}
