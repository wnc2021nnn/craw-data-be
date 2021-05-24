package com.craw_data.models;

import com.craw_data.utils.MyRandom;

import java.util.Objects;
import java.util.Random;

public class Course {
    public static final String insertQuery = "INSERT INTO public.course(\n" +
            "\tcourse_id, title, description, topic_id, lecturers_id, rating, rating_total, avatar, price)\n" +
            "\tVALUES";

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
        this.courseId = "course_" + nextId++;
        this.rating = 0.0f;
        this.ratingTotal = 0;
        this.price = 0.0f;
        this.lecturersId = "user_" + MyRandom.randomUserNumber();
        this.topicId =  "topic_" + MyRandom.randomTopicNumber();
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

    public String toSQLString() {
        return String.format(
                "('%s', '%s', '%s', '%s', '%s', %f, %d, '%s', %f)",
                this.courseId,
                this.title,
                this.description,
                this.topicId,
                this.lecturersId,
                this.rating,
                this.ratingTotal,
                this.avatar,
                this.price
        );
    }

}
