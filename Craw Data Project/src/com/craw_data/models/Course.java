package com.craw_data.models;

import com.craw_data.models.base.BaseModel;
import com.craw_data.utils.MyRandom;

import java.util.Objects;

public class Course extends BaseModel {
    private static int nextId = 1;

    private String courseId;
    private String title;
    private String description;
    private Float rating;
    private Short ratingTotal;
    private String avatar;
    private Float price;
    private String topicId;
    private String lecturersId;

    public Course() {
        this.courseId = "course_" + String.format("%06d", nextId++);
        this.rating = 0.0f;
        this.ratingTotal = 0;
        this.price = 0.0f;
        this.lecturersId = "user_" + String.format("%06d", MyRandom.randomUserNumber());
        this.topicId = "topic_" + String.format("%03d", MyRandom.randomTopicNumber());
    }

    public String getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Float getRating() {
        return rating;
    }

    public Short getRatingTotal() {
        return ratingTotal;
    }

    public String getAvatar() {
        return avatar;
    }

    public Float getPrice() {
        return price;
    }

    public String getTopicId() {
        return topicId;
    }

    public String getLecturersId() {
        return lecturersId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public void setRatingTotal(Short ratingTotal) {
        this.ratingTotal = ratingTotal;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public void setLecturersId(String lecturersId) {
        this.lecturersId = lecturersId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, title, description, rating, ratingTotal, avatar, price);
    }

    @Override
    public String toSQLString() {
        final String titleString = title.replaceAll("'", "''");
        final String descriptionString = title.replaceAll("'", "''");
        return String.format(
                "('%s', '%s', '%s', '%s', '%s', %f, %d, '%s', %f)",
                this.courseId,
                titleString,
                descriptionString,
                this.topicId,
                this.lecturersId,
                this.rating,
                this.ratingTotal,
                this.avatar,
                this.price
        );
    }

}
