package com.craw_data.models;

import com.craw_data.models.base.BaseModel;

import java.util.Objects;

public class Topic extends BaseModel {
    public static int nextCategoryId = 0;
    private static int nextId = 1;

    private final String topicId;
    private final String categoryId;
    private String title;

    public Topic() {
        this.topicId = "topic_" + String.format("%03d", nextId++);
        this.categoryId = "category_" + String.format("%03d", nextCategoryId);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        return Objects.hash(topicId, title);
    }

    @Override
    public String toSQLString() {
        return String.format(
                "('%s', '%s', '%s')",
                topicId,
                categoryId,
                title
        );
    }

}
