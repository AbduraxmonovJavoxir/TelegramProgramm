package backend.models;

public class Message extends BaseModel {
    private String content;
    private String userId;
    private String chatId;

    public Message(String content, String userId, String chatId) {
        this.content = content;
        this.userId = userId;
        this.chatId = chatId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    @Override
    public String toString() {
        return  userId + " ---> " + content;
    }
}

