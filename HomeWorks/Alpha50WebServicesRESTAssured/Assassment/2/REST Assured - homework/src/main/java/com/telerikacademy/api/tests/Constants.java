package com.telerikacademy.api.tests;

public class Constants {

    //set your host! (it will go in the url)
    public static String host = "https://fgargov.atlassian.net";
    //set your username!
    public static String username = "fgargov@gmail.com";

    //set your password!
    public static String password = "ATATT3xFfGF0fywuTcwWSSn6cALoYgoYTlwogczyb2jPL34J4yuwBnUO69E3EnLRhKEr7EP_pMEKKSLPhXsnCxsrwJobsn28Cfw7TMQm2Qn9iw8w9fNaENgiemn_OLNipIJCBhiNQk_xYZxBLKtETQIZxilkIMAbRddmTsrAq57WcDvKmvuivOg=37758451";

    //you don't have to do anything else apart from running the tests!
    public static String requestBodyForStory = "{\n" +
            "    \"fields\": {\n" +
            "        \"project\": {\n" +
            "            \"key\": \"%s\"\n" +
            "        },\n" +
            "        \"issuetype\": {\n" +
            "            \"name\": \"Story\"\n" +
            "        },\n" +
            "        \"summary\": \"Logged in user wants to create a new topic\",\n" +
            "        \"description\": \"Preconditions: User has logged in and has navigated to the category of desire\\n\\nClick “New Topic”\\n\\nType in title\\n\\nChoose a tag\\n\\nType in Content\\n\\nClick “Create Topic”\",\n" +
            "        \"priority\": {\n" +
            "            \"name\": \"High\"\n" +
            "        }\n" +
            "    }\n" +
            "}";

    public static String requestBodyForBug = "{\n" +
            "    \"fields\": {\n" +
            "        \"project\": {\n" +
            "            \"key\": \"%s\"\n" +
            "        },\n" +
            "        \"issuetype\": {\n" +
            "            \"name\": \"Bug\"\n" +
            "        },\n" +
            "        \"summary\": \"Title doesn't display the maximum symbols\",\n" +
            "        \"description\": \"Preconditions: User has logged in and navigated to the category of desire\\n\\n\\nSteps:\\n\\nClick “New Topic”\\n\\nTry to type in Title larger than 255 symbols\\n\\n\\nExpected Results:\\n\\nTooltip that shows how long the Title should be from the minimum value of 5 to the maximum value of 255 symbols\\n\\n\\nActual Result:\\n\\nThe field does not allow more than the maximum value of symbols and it cuts the text without displaying the maximum value of symbols\",\n" +
            "        \"priority\": {\n" +
            "            \"name\": \"Low\"\n" +
            "        }\n" +
            "    }\n" +
            "}";

    public static String requestBodyForLink = "{\n" +
            "    \"type\": {\n" +
            "        \"name\": \"Blocks\"\n" +
            "    },\n" +
            "    \"inwardIssue\": {\n" +
            "        \"key\": \"%s\"\n" +
            "    },\n" +
            "    \"outwardIssue\": {\n" +
            "        \"key\": \"%s\"\n" +
            "    }\n" +
            "}";


}
