package ui.views;

import backend.models.PrivateChat;
import backend.models.User;
import backend.service.privateChatService.PrivateChatService;
import backend.service.privateChatService.PrivateChatServiceImp;
import backend.service.userService.UserService;
import backend.service.userService.UserServiceImp;
import ui.utills.MenuUtils;
import ui.utills.ScanUtil;

public class ChatView {
    private static User curUser;
    private static PrivateChatService privateChatService = PrivateChatServiceImp.getInstance();
    private static UserService userService = UserServiceImp.getInstance();

    public static void chatMenu(User user) {
        curUser = user;
        while (true) {
            int menu = MenuUtils.menu(MenuUtils.CHAT);
            switch (menu) {
                case 1 -> {
                    createChat();
                }
                case 2 -> {
                    showChats();
                }
                case 3 -> {
                    openChat();
                }
                case 4 -> {
                    deleteChat();
                }
                case 0 -> {
                    curUser = null;
                    return;
                }
                default -> {
                    System.out.println("Wrong number!");
                }
            }
        }
    }

    private static void deleteChat() {
        showChats();
        String chat = ScanUtil.strScanner("Choose chat to delete by ID: ");
        PrivateChat delete = privateChatService.delete(chat);
        if (delete != null) {
            System.out.println("Deleted successfully!");
        } else {
            System.out.println("Not deleted, something went wrong!");
        }
    }

    private static void openChat() {
        showChats();
        String chat = ScanUtil.strScanner("Choose the chat by ID: ");
        PrivateChat privateChat = privateChatService.get(chat);
        ChatMessageView.chatMessageMenu(privateChat);
    }

    private static void showChats() {
        privateChatService.getList();
    }

    private static void createChat() {
        String title = ScanUtil.strScanner("Enter the name of the chat: ");
        userService.showUsers(curUser);
        String userId = ScanUtil.strScanner("Which user do you want to write? Enter ID: ");
        privateChatService.create(new PrivateChat(title, userId));
    }
}

