package com.craw_data.models;

import com.craw_data.models.base.BaseModel;

public class Chapter extends BaseModel {
    private String chapterId;
    private String courseId;
    private String title;

    public String getChapterId() {
        return chapterId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toSQLString() {
        return String.format(
                "(%s, %s, %s)",
                chapterId,
                title,
                courseId);
    }
}
