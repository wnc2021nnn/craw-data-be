package com.craw_data.models;

import com.craw_data.models.base.BaseModel;

public class Chapter extends BaseModel {
    public static int nextId = 1;

    private String chapterId;
    private String courseId;
    private String title;

    public Chapter() {
        this.chapterId = String.format("chapter_%06d", nextId++);
    }

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
        final String titleString = title.replaceAll("'", "''");
        return String.format(
                "('%s', '%s', '%s')",
                chapterId,
                titleString,
                courseId);
    }
}
