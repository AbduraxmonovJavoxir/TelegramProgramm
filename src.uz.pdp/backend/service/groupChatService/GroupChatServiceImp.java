package backend.service.groupChatService;

import backend.models.GroupChat;
import backend.models.User;
import backend.service.userService.UserService;
import backend.service.userService.UserServiceImp;
import ui.utills.ScanUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupChatServiceImp implements GroupChatService {
    private List<GroupChat> groupChats;
    private List<User> usersInGroup;
    private static GroupChatServiceImp groupChatServiceImp;
    private UserServiceImp userServiceImp = UserServiceImp.getInstance();
    private UserService userService = UserServiceImp.getInstance();

    private GroupChatServiceImp() {
        this.groupChats = new ArrayList<>();
        this.usersInGroup = new ArrayList<>();
    }

    public static GroupChatServiceImp getInstance() {
        if (groupChatServiceImp == null) {
            groupChatServiceImp = new GroupChatServiceImp();
        }

        return groupChatServiceImp;
    }

    @Override
    public void create(GroupChat groupChat) {

    }

    @Override
    public GroupChat get(String id) {
        for (int i = 0; i < groupChats.size(); i++) {
            if (groupChats.get(i).getId().equals(id)) {
                return groupChats.get(i);
            }
        }
        return null;
    }

    @Override
    public void getList() {
        for (GroupChat groupChat : groupChats) {
            if (!groupChat.getDeleted()) {
                System.out.println(groupChat);
            }
        }
    }

    @Override
    public void update(GroupChat newM) {

    }

    @Override
    public GroupChat delete(String id) {
        for (int i = 0; i < groupChats.size(); i++) {
            if (groupChats.get(i).getId().equals(id)) {
                GroupChat temp = groupChats.get(i);
                groupChats.get(i).setDeleted(true);
                return temp;
            }
        }
        return null;
    }

    @Override
/*
    public void createGroup(String title, int numberOfUsers) {
        userService.showUsers();
        for (int i = 0; i < numberOfUsers; i++) {
            String temp = ScanUtil.strScanner("Enter the ID of the user you want to add: ");
            for (int j = 0; j < userServiceImp.getUserList().size(); j++) {
                if (userServiceImp.getUserList().get(j).getId().equals(temp)) {
                    usersInGroup.add(userServiceImp.getUserList().get(j));
                    System.out.println("User added!");
                    break;
                }
            }
        }
        groupChats.add(new GroupChat(title,(ArrayList<User>) usersInGroup,numberOfUsers));
        System.out.println("Group was created!");
    }
*/

    public void createGroup(String title, int numberOfUsers) {
        userService.showUsers();
        Set<String> addedUserIds = new HashSet<>();
        for (int i = 0; i < numberOfUsers; i++) {
            String temp = ScanUtil.strScanner("Enter the ID of the user you want to add: ");
            boolean userAdded = false;
            for (int j = 0; j < userServiceImp.getUserList().size(); j++) {
                if (userServiceImp.getUserList().get(j).getId().equals(temp)) {
                    if (addedUserIds.contains(temp)) {
                        System.out.println("User with ID " + temp + " is already added to the group.");
                        userAdded = true;
                        i--;
                        break;
                    }
                    usersInGroup.add(userServiceImp.getUserList().get(j));
                    addedUserIds.add(temp);
                    System.out.println("User added!");
                    userAdded = true;
                    break;
                }
            }
            if (!userAdded) {
                System.out.println("User with ID " + temp + " not found.");
            }
        }
        groupChats.add(new GroupChat(title, new ArrayList<>(usersInGroup), numberOfUsers)); // Grubu oluştururken kopya oluşturuyoruz
        System.out.println("Group was created!");
    }
    @Override
    public User addUser(String id) {
        for (int i = 0; i < userServiceImp.getUserList().size(); i++) {
            if (userServiceImp.getUserList().get(i).getId().equals(id)) {
                usersInGroup.add(userServiceImp.getUserList().get(i));
                return userServiceImp.getUserList().get(i);
            }
        }

        return null;
    }

    @Override
    public User deleteUser(String id) {
        for (int i = 0; i < usersInGroup.size(); i++) {
            if (usersInGroup.get(i).getId().equals(id)) {
                User temp = usersInGroup.get(i);
                usersInGroup.remove(i);
                return temp;
            }
        }

        return null;
    }
}

