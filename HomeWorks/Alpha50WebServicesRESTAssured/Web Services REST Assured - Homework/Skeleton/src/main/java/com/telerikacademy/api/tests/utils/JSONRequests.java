package com.telerikacademy.api.tests.utils;

public class JSONRequests {
    public static final String CREATE_STORY = "{\n" +
            "  \"fields\": {\n" +
            "    \"project\": {\n" +
            "      \"key\": \"PAH\"\n" +
            "    },\n" +
            "    \"summary\": \"Create a new forum topic successfully\",\n" +
            "    \"description\":  \"*Preconditions:*\n\n" +
            "*     Staging forum: [https://stage-forum.telerikacademy.com/|https://stage-forum.telerikacademy.com/|smart-link]\n" +
            "*     An existing user that is successfully registered and logged in.\n" +
            "*     I populate valid content and create new forum topic.\n" +
            " \n\n" +
            "*Test Steps:*\n\n" +
            "# Log in to the forum with valid credentials.\n" +
            "# Navigate to a topic that you have previously created.\n" +
            "# Click on the *“+New Topic”* button.\n" +
            "# Enter a valid title in the *“Topic Title”* field\n" +
            "# Click on *“Alphe Preperation”* category\n" +
            "# Create *“alpha”* and *“preperation”* tags\n" +
            "# Enter valid content in the *“Topic Content”* field\n" +
            "# Click on *“+Create Topic”* button\n" +
            "\n\n\n" +
            "*Expected result:*\n\n" +
            "# A new topic should be successfully created with the given title and content. \n" +
            "# The user should be redirected to the topic view.\n" +
            "\n\n\n" +
            "*Actual result:*\n\n" +
            "Upon clicking the \"Submit\" button, the page reloads but no new forum topic is created. No confirmation message is displayed.\n" +
            "\n\n\n" +
            "*Severity*: {color:#ff5630}High{color}\"" +
            "    \"issuetype\": {\n" +
            "      \"name\": \"Story\"\n" +
            "    },\n" +
            "    \"priority\": {\n" +
            "      \"name\": \"High\"\n" +
            "    }\n" +
            "  }\n" +
            "}";


    public static final String JSON_STRING = "{\n" +
            "    \"Description\": \"As a potential customer,\\n\\nI want to type in the website URL in a browser,\\n\\nAnd visit the website so that I can browse the content.\",\n" +
            "    \"Preconditions\": \"The following steps are done after opening Chrome, Firefox, and Edge browsers (latest versions):\",\n" +
            "    \"Steps to reproduce\": \"Navigate to the URL box of the browser\\nType in phptravels.net\\nPress Enter\",\n" +
            "    \"Expected results\": \"The website should be loaded and displayed.\",\n" +
            "    \"Actual results\": \"A message is displayed stating \\\"NO RESPONSE FROM API SERVER.\\\"\",\n" +
            "    \"Environment\": \"Chrome, Firefox, and Edge (latest versions)\"\n" +
            "}";

    public static final String CREATE_BUG = "{" +
            "    \"fields\": {" +
            "        \"project\": {" +
            "            \"key\": \"PAH\"" +
            "        }," +
            "        \"summary\": \"User can't create new forum post successfully\"," +
            "        \"description\": \"*Steps to reproduce:*\\n 1. Navigate to the main page - https://stage-forum.telerikacademy.com\\n *Expected result:* \\n The staging forum is loaded successfully \\n *Actual result:* \\n Staging forum is not available and return error: \\\"We can't connect to the server at \\\"stage-forum.telerikacademy.com.\\\" \\n *Severity:* Highest \\n *Prerequisites:* N/A \\n !https://upload.wikimedia.org/wikipedia/commons/f/f8/Science_2.0_model.png!\"," +
            "        \"issuetype\": {" +
            "            \"name\": \"Bug\"" +
            "        }" +
            "    }" +
            "}";

    public static final String CREATE_BUG_TWO =  "{\n" +
            "    \"fields\": {\n" +
            "        \"project\": {\n" +
            "            \"key\": \"PAH\"\n" +
            "        },\n" +
            "        \"summary\": \"The website cannot be reached through Chrome, Firefox, and Edge browsers\",\n" +
            "        \"description\": \"*Description:*\\n\\nAs a potential customer,\\n\\nI want to type in the website URL in a browser,\\n\\nAnd visit the website so that I can browse the content.\\n\\n*Preconditions:*\\n\\nThe following steps are done after opening Chrome, Firefox, and Edge browsers (latest versions):\\n\\n*Steps to reproduce:*\\n\\n# Navigate to the URL box of the browser\\n# Type in [phptravels.net|http://phptravels.net]\\n# Press Enter\\n\\n*Expected results:*\\n\\n# The website should be loaded and displayed.\\n\\n*Actual results:*\\n\\n# A message is displayed stating “NO RESPONSE FROM API SERVER.“\\n\",\n" +
            "        \"issuetype\": {\n" +
            "            \"name\": \"Bug\"\n" +
            "        },\n" +
            "        \"environment\": \"Chrome, Firefox, and Edge (latest versions)\",\n" +
            "        \"priority\": {\n" +
            "            \"name\": \"Highest\"\n" +
            "        },\n" +
            "        \"labels\": [\n" +
            "            \"Severity-1\"\n" +
            "        ]\n" +
            "    \n" +
            "    }\n" +
            "}";

    public static final String CREATE_ISSUE_LINK =
            "{\n" +
                    "    \"type\": {\n" +
                    "        \"name\": \"Blocks\"\n" +
                    "    },\n" +
                    "    \"inwardIssue\": {\n" +
                    "        \"key\": \"PAH-4\"\n" +
                    "    },\n" +
                    "    \"outwardIssue\": {\n" +
                    "        \"key\": \"PAH-3\"\n" +
                    "    }\n" +
                    "}";

    public static final String CREATE_ASSIGN =  "{\n" +
            "    \"accountId\":  \"557058:5dfb38de-07c5-4daa-9951-a80fdd626dab\",\n" +
            "}";

    public static final String ASSIGNEE_ACCOUNT_ID = "{\n" +
            "    \"fields\": {\n" +
            "        \"assignee\": {\n" +
            "            \"accountId\": \"557058:5dfb38de-07c5-4daa-9951-a80fdd626dab\"\n" +
            "        }\n" +
            "    }\n" +
            "}";

    public static final String SET_PRIORITY = "{\n" +
            "  \"fields\": {\n" +
            "    \"priority\": {\n" +
            "      \"name\": \"High\"\n" +
            "    }\n" +
            "  }\n" +
            "}";

    public static final String CHANGE_TRANSITION = "{\n" +
            "    \"transition\": {\n" +
            "        \"id\": \"21\"\n" +
            "    }\n" +
            "}";
}
