package net.banck.postfacto.model;



import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;
import java.util.Date;

@JsonRootName(value = "action_item")
public class ActionItem implements Serializable {

    private int id;
    private String description;
    private boolean done;
    private Date created_at;
    private Date archived_at;

    public ActionItem(int id, String description, String category, int vote_count, boolean done, Date created_at, Date archived_at) {
        this.setId(id);
        this.setDescription(description);
        this.setDone(done);
        this.setCreated_at(created_at);
        this.setArchived_at(archived_at);
    }

    public ActionItem(String description){
        this.setDescription(description);
    }

    public ActionItem(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getArchived_at() {
        return archived_at;
    }

    public void setArchived_at(Date archived_at) {
        this.archived_at = archived_at;
    }
}
