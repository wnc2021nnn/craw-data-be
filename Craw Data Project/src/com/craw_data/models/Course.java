package com.craw_data.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Course {
    private String courseId;
    private String title;
    private String description;
    private Float rating;
    private Short ratingTotal;
    private String avatar;
    private Float price;

    private Topic topic;
    private User lecturers;
    private Set<CourseContent> courseContents = new HashSet<>(0);

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Short getRatingTotal() {
        return ratingTotal;
    }

    public void setRatingTotal(Short ratingTotal) {
        this.ratingTotal = ratingTotal;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getLecturers() {
        return lecturers;
    }

    public void setLecturers(User lecturers) {
        this.lecturers = lecturers;
    }

    public Set<CourseContent> getCourseContents() {
        return courseContents;
    }

    public void setCourseContents(Set<CourseContent> courseContents) {
        this.courseContents = courseContents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseId, course.courseId) && Objects.equals(title, course.title) && Objects.equals(description, course.description) && Objects.equals(rating, course.rating) && Objects.equals(ratingTotal, course.ratingTotal) && Objects.equals(avatar, course.avatar) && Objects.equals(price, course.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, title, description, rating, ratingTotal, avatar, price);
    }
}
