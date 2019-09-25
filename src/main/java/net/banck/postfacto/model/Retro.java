package net.banck.postfacto.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonRootName(value = "retro")
public class Retro implements Serializable {
    private int id;
    private String slug;
    private String name;
    private Boolean is_private;
    private int highlighted_item_id;
    private Date retro_item_end_time;
    private Date created_at;
    private String video_link;
    private Boolean send_archive_email;
    private List<Item> items;
    private List <ActionItem> action_items;
    private List <Archive> archives;

    public Retro() {
    }

    public List<Archive> getArchives() {
        return archives;
    }

    public void setArchives(List<Archive> archives) {
        this.archives = archives;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIs_private() {
        return is_private;
    }

    public void setIs_private(Boolean is_private) {
        this.is_private = is_private;
    }

    public int getHighlighted_item_id() {
        return highlighted_item_id;
    }

    public void setHighlighted_item_id(int highlighted_item_id) {
        this.highlighted_item_id = highlighted_item_id;
    }

    public Date getRetro_item_end_time() {
        return retro_item_end_time;
    }

    public void setRetro_item_end_time(Date retro_item_end_time) {
        this.retro_item_end_time = retro_item_end_time;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getVideo_link() {
        return video_link;
    }

    public void setVideo_link(String video_link) {
        this.video_link = video_link;
    }

    public Boolean getSend_archive_email() {
        return send_archive_email;
    }

    public void setSend_archive_email(Boolean send_archive_email) {
        this.send_archive_email = send_archive_email;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<ActionItem> getAction_items() {
        return action_items;
    }

    public void setAction_items(List<ActionItem> action_items) {
        this.action_items = action_items;
    }
}
