package ui.views;

import backend.models.GroupChat;
import backend.models.Message;
import backend.service.messageService.MessageService;
import backend.service.messageService.MessageServiceImp;
import ui.utills.MenuUtils;
import ui.utills.ScanUtil;

public class GroupMessageView {
    private static GroupChat curGroupChat;
    private static MessageService messageService = MessageServiceImp.getInstance();

    public static void groupMessageMenu(GroupChat chat) {
        curGroupChat = chat;
        if (curGroupChat != null) {
            while (true) {
                int menu = MenuUtils.menu(MenuUtils.MESSAGE);
                switch (menu) {
                    case 1 -> {
                        sendMessage();
                    }
                    case 2 -> {
                        readMessages();
                    }
                    case 0 -> {
                        curGroupChat = null;
                        return;
                    }
                    default -> {
                        System.out.println("Wrong number!");
                    }
                }
            }
        } else {
            System.out.println("Chat not found!");
        }
    }

    private static void sendMessage() {
        String message = ScanUtil.strScanner("Enter the message: ");
        messageService.sendMessage(new Message(message, curGroupChat.getId(), curGroupChat.getId()));
        System.out.println("Sent!");
    }

    private static void readMessages() {
        messageService.readMessages();
    }
}

