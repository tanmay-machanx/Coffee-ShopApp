package com.CoffeeApp.CoffeeApp.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CoffeeAppEntity {

    @Id
    private String id;
    private String Title;
    private String Description;
    private int Priority; //Low Priority (-1), Medium (0),
    private int Amount;

    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }

    public int getPriority() {
        return Priority;
    }

    public void setPriority(int priority) {
        Priority = priority;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String createDate) {
        CreateDate = createDate;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    private String CreateDate;
    private String CreateTime;
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
