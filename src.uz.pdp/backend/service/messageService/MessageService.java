package backend.service.messageService;

import backend.models.Message;
import backend.service.BaseService;

public interface MessageService extends BaseService<Message> {
    void sendMessage(Message message);
    void readMessages();
}
