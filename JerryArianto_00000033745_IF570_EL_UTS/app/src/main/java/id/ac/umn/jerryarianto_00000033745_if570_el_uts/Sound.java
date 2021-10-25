package id.ac.umn.jerryarianto_00000033745_if570_el_uts;

public class Sound {

    private String title;
    private String description;
    private String soundUri;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSoundUri() {
        return soundUri;
    }

    public void setSoundUri(String soundUri) {
        this.soundUri = soundUri;
    }
    public Sound(String title, String description, String soundUri) {
        this.title = title;
        this.description = description;
        this.soundUri = soundUri;
    }
}
