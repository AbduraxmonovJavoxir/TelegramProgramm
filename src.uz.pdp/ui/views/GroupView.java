package ui.views;

import backend.models.GroupChat;
import backend.models.User;
import backend.service.groupChatService.GroupChatService;
import backend.service.groupChatService.GroupChatServiceImp;
import backend.service.userService.UserService;
import backend.service.userService.UserServiceImp;
import ui.utills.MenuUtils;
import ui.utills.ScanUtil;

public class GroupView {
    private static User curUser;
    private static GroupChatService groupChatService = GroupChatServiceImp.getInstance();
    private static UserService userService = UserServiceImp.getInstance();

    public static void groupMenu(User user) {
        curUser = user;
        while (true) {
            int menu = MenuUtils.menu(MenuUtils.GROUP);
            switch (menu) {
                case  1 ->{
                    createGroup();
                }
                case  2 ->{
                    showGroups();
                }
                case  3 ->{
                    openGroup();
                }
                case  4 ->{
                    changeGroup();
                }
                case  5 ->{
                    deleteGroup();
                }
                case  0 ->{
                    curUser = null;
                    return;
                }
                default ->{
                    System.out.println("Wrong number!");
                }
            }
        }
    }

    private static void changeGroup() {
        ChangeGroupView.changeGroupMenu(curUser);
    }

    private static void deleteGroup() {
        showGroups();
        String id = ScanUtil.strScanner("Enter the ID of the group you want to delete: ");
        GroupChat delete = groupChatService.delete(id);
        if (delete != null) {
            System.out.println("Deleted successfully!");
        } else {
            System.out.println("Not deleted, something went wrong!");
        }
    }

    private static void openGroup() {
        showGroups();
        String id = ScanUtil.strScanner("Enter the ID of the group: ");
        GroupChat groupChat = groupChatService.get(id);
        GroupMessageView.groupMessageMenu(groupChat);
    }

    private static void showGroups() {
        groupChatService.getList();
    }

    private static void createGroup() {

        String title = ScanUtil.strScanner("Enter the title of the group: ");
        int number = ScanUtil.intScanner(" Enter children numbers in group : ");
        groupChatService.createGroup(title,number);
    }
}

