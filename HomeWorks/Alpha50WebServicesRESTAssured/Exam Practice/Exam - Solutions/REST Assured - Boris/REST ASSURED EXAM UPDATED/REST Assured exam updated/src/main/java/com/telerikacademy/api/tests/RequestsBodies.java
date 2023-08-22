package com.telerikacademy.api.tests;

import static com.telerikacademy.api.tests.NamesAndDescriptions.*;
import static com.telerikacademy.api.tests.Constants.*;
import static java.lang.String.format;

public class RequestsBodies {

   public static final String createBoardBody = format("{\n" +
                    "    \"name\":\"%s\",\n" +
                    "    \"desc\" : \"%s\"\n" +
                    "}", boardName
                       , boardDescription);


   public static final String createNewList = format("{\n" +
                    "    \"idBoard\":\"%s\",\n" +
                    "    \"name\":\"%s\"\n" +
                    "}", boardId,
                    boardName);


    public static final String createNewCard = format("{\n" +
                    "     \"desc\":\"%s\",\n" +
                    "    \"name\" : \"%s\"\n" +
                    "}", cardDescription,
                         cardName);

   public static final String updateCard=format("{\n" +
                   "   \"desc\":\"%s\",\n" +
                   "   \"name\":\"%s\",\n" +
                   "   \"cover\":{\n" +
                   "      \"color\":\"red\"\n" +
                   "   }\n" +
                   "}"
           ,cardNewDescription,cardNewName);
    public  static final String updateBoardName=format("{\n" +
            "    \"name\": \"%s\"     \n" +
            "}",boardNewName);
}





