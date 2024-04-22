package ui.views;

import backend.models.Message;
import backend.models.PrivateChat;
import backend.service.messageService.MessageService;
import backend.service.messageService.MessageServiceImp;
import ui.utills.MenuUtils;
import ui.utills.ScanUtil;

public class ChatMessageView {
    private static PrivateChat curChat;
    private static MessageService messageService = MessageServiceImp.getInstance();

    public static void chatMessageMenu(PrivateChat chat) {
        curChat = chat;
        if (curChat != null) {
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
                        curChat = null;
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

    private static void readMessages() {
        messageService.readMessages();
    }

    private static void sendMessage() {
        String message = ScanUtil.strScanner("Enter the message: ");
        messageService.sendMessage(new Message(message, curChat.getUserId(), curChat.getId()));
        System.out.println("Sent!");
    }
}


