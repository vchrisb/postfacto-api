package net.banck.postfacto.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;
import java.util.Date;

@JsonRootName(value = "archive")
public class Archive implements Serializable {
    private int id;
    private Date created_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
