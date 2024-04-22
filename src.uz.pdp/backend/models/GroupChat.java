package backend.models;

import java.util.ArrayList;
import java.util.List;

public class GroupChat extends BaseModel{
    private String title;
    private List<User> userList;
    private Integer userNumber;

    public GroupChat(String title, ArrayList<User> userList, Integer userNumber) {
        this.title = title;
        this.userList = userList;
        this.userNumber = userNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<User> getUsers() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

    @Override
    public String toString() {
        return title + " " + getId();
    }
}
