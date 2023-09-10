package pages.jira.enums;

public enum Bug {
    TITLE("User can't create new forum post successfully"),
    DESCRIPTION("Preconditions:\n" +
            "\n" +
            "    Staging forum: \n" +
            "\n" +
            "    An existing user that is successfully registered and logged in.\n" +
            "\n" +
            "    I populate valid content and create new forum topic.\n" +
            "\n" +
            " \n" +
            "\n" +
            "Test Steps:\n" +
            "\n" +
            "Log in to the forum with valid credentials.\n" +
            "\n" +
            "Navigate to a topic that you have previously created.\n" +
            "\n" +
            "Click on the “+New Topic” button.\n" +
            "\n" +
            "Enter a valid title in the “Topic Title” field\n" +
            "\n" +
            "Click on “Alphe Preperation” category\n" +
            "\n" +
            "Create “alpha” and “preperation” tags\n" +
            "\n" +
            "Enter valid content in the “Topic Content” field\n" +
            "\n" +
            "Click on “+Create Topic” button\n" +
            "\n" +
            "Expected result:\n" +
            "\n" +
            "A new topic should be successfully created with the given title and content. \n" +
            "\n" +
            "The user should be redirected to the topic view.\n" +
            "\n" +
            "Actual result:\n" +
            "\n" +
            "Upon clicking the \"Submit\" button, the page reloads but no new forum topic is created. No confirmation message is displayed.\n" +
            "\n" +
            "Severity: High");

    private String text;
    Bug(String title) {
        this.text = title;
    }
    public String getString(){
        return text;
    }
}
