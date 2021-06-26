package com.craw_data.models;

import com.craw_data.models.base.BaseModel;

public class Lesson extends BaseModel {
    private String lessonId;
    private String title;
    private int index;
    private String videoUrl;
    private String chapterId;

    public String getLessonId() {
        return lessonId;
    }

    public String getTitle() {
        return title;
    }

    public int getIndex() {
        return index;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getChapterId() {
        return chapterId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    @Override
    public String toSQLString() {
        return String.format(
                "(%s, %s, %d, %s, %s)",
                lessonId,
                title,
                index,
                videoUrl,
                chapterId
        );
    }
}
