package com.craw_data.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Category {
    private String categoryId;
    private String title;

    Set<Topic> topics = new HashSet<>(0);

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryId, category.categoryId) && Objects.equals(title, category.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, title);
    }
}
