package com.craw_data.models;

import java.util.Objects;

public class CourseContent {
    private String contentId;
    private String title;
    private short index;
    private String videoLink;

    private Course course;

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public short getIndex() {
        return index;
    }

    public void setIndex(short index) {
        this.index = index;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseContent that = (CourseContent) o;
        return index == that.index && Objects.equals(contentId, that.contentId) && Objects.equals(title, that.title) && Objects.equals(videoLink, that.videoLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contentId, title, index, videoLink);
    }
}
