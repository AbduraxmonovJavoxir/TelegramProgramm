package backend.service.privateChatService;

import backend.models.PrivateChat;

import java.util.ArrayList;
import java.util.List;

public class PrivateChatServiceImp implements PrivateChatService {
    private List<PrivateChat> privateChats;
    private static PrivateChatServiceImp privateChatServiceImp;

    private PrivateChatServiceImp() {
        this.privateChats = new ArrayList<>();
    }

    public static PrivateChatServiceImp getInstance() {
        if (privateChatServiceImp == null) {
            privateChatServiceImp = new PrivateChatServiceImp();
        }

        return privateChatServiceImp;
    }

    @Override
    public void create(PrivateChat privateChat) {
        privateChats.add(privateChat);
    }

    @Override
    public PrivateChat get(String id) {
        for (int i = 0; i < privateChats.size(); i++) {
            if (privateChats.get(i).getId().equals(id)) {
                return privateChats.get(i);
            }
        }

        return null;
    }

    @Override
    public void getList() {
        for (PrivateChat privateChat : privateChats) {
            if (!privateChat.getDeleted()) {
                System.out.println(privateChat);
            }
        }
    }

    @Override
    public void update(PrivateChat newM) {

    }

    @Override
    public PrivateChat delete(String id) {
        for (int i = 0; i < privateChats.size(); i++) {
            if (privateChats.get(i).getId().equals(id)) {
                PrivateChat temp = privateChats.get(i);
                privateChats.get(i).setDeleted(true);
                return temp;
            }
        }
        return null;
    }
}

