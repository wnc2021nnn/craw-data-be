package com.craw_data.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Topic {
    private String topicId;
    private String title;

    private Category category;
    private Set<Course> courses = new HashSet<>(0);

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return Objects.equals(topicId, topic.topicId) && Objects.equals(title, topic.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topicId, title);
    }
}
