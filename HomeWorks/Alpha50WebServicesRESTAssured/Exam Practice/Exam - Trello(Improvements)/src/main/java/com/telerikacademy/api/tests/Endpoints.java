package com.telerikacademy.api.tests;

import static java.lang.String.format;

public class Endpoints {
    public static final String API_VERSION = "/1";
    public static final String BOARDS_ENDPOINT = format("%s%s", API_VERSION, "/boards");

    public static final String MEMBERS_ENDPOINT = format("%s%s", API_VERSION, "/members/me");

    public static final String LISTS_ENDPOINT = format("%s%s", API_VERSION, "/lists");

    public static final String CARDS_ENDPOINT = format("%s%s", API_VERSION, "/cards");
}
