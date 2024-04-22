package backend.service;
import backend.models.BaseModel;

import java.util.List;

public interface BaseService<M extends BaseModel> {
    void create(M m);

    M get(String id);

    void getList();

    void update(M newM);

    M delete(String id);
}