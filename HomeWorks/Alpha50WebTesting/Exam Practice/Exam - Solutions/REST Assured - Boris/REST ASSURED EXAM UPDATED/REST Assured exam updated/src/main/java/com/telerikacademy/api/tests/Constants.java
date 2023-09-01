package com.telerikacademy.api.tests;

import static java.lang.String.format;

public class Constants {

  public static final String baseURL="https://api.trello.com/1";
  public static final String  accountKey="";
  public static final String accountToken="";

  public static final String accountSecret="";

  public static final String API_KEY_AND_TOKEN = format("key=%s&token=%s",accountKey,accountToken);
  public static final String email="";

  public static final String userName="";

  public static final int MAX_BOARD_NAME_LENGTH = 16384;
  public static final int MIN_BOARD_NAME_LENGHT = 1;

  public static String  boardId;
  public static String listId;
  public static String  cardId;

}
