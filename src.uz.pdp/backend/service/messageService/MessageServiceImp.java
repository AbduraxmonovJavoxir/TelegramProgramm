package backend.service.messageService;

import backend.models.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageServiceImp implements MessageService {
    private List<Message> messageList;
    private static MessageServiceImp messageServiceImp;

    private MessageServiceImp() {
        this.messageList = new ArrayList<>();
    }

    public static MessageServiceImp getInstance() {
        if (messageServiceImp == null) {
            messageServiceImp = new MessageServiceImp();
        }

        return messageServiceImp;
    }

    @Override
    public void sendMessage(Message message) {
        messageList.add(message);
    }

    @Override
    public void readMessages() {
        for (Message message : messageList) {
            System.out.println(message);
        }
    }

    @Override
    public void create(Message message) {

    }

    @Override
    public Message get(String id) {
        return null;
    }

    @Override
    public void getList() {
        for (Message message : messageList) {
            if (!message.getDeleted()) {
                System.out.println(message);
            }
        }
    }

    @Override
    public void update(Message newM) {

    }

    @Override
    public Message delete(String id) {
        for (int i = 0; i < messageList.size(); i++) {
            if (messageList.get(i).getId().equals(id)) {
                Message temp = messageList.get(i);
                messageList.get(i).setDeleted(true);
                return temp;
            }
        }
        return null;
    }
}
