package backend.models;

import java.util.UUID;

public abstract class BaseModel {
    private String id;
    private Boolean isDeleted;

    public BaseModel() {
        this.id = UUID.randomUUID().toString();
        this.isDeleted = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
