package backend.service.groupChatService;

import backend.models.GroupChat;
import backend.models.User;
import backend.service.BaseService;

public interface GroupChatService extends BaseService<GroupChat> {
    void createGroup(String title, int numberOfUsers);

    User addUser(String id);

    User deleteUser(String id);
}
