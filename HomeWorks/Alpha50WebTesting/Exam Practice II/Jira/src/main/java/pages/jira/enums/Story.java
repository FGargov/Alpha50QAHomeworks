package pages.jira.enums;

public enum Story {
    TITLE("Create a new forum topic successfully"),
    DESCRIPTION("As a registered user\n" + "I want to be able to create a new forum topic\n"
    + "I want to share information, ask questions, or initiate discussions with the community.\n"
    + "I populate valid content and submit the form.");

    private String text;
    Story(String title) {
        this.text = title;
    }
    public String getString(){
        return text;
    }
}
