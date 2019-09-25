package net.banck.postfacto.model;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "item")
public class Item extends ActionItem {
    private String category;
    private int vote_count;

    public Item(String description, String category){
        super(description);
        this.setCategory(category);
    }

    public Item() {
        super ();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }
}
