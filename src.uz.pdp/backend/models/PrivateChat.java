package backend.models;

public class PrivateChat extends BaseModel {
    private String title;
    private String userId;
    private final Integer userNumber = 2;

    public PrivateChat(String title, String userId) {
        this.title = title;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getUserNumber() {
        return userNumber;
    }

    @Override
    public String toString() {
        return title + " " + getId();
    }
}
