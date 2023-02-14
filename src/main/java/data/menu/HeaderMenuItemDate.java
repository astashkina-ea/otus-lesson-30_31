package data.menu;

public enum HeaderMenuItemDate {
    LEARNING("learning");

    private String name;

    HeaderMenuItemDate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

