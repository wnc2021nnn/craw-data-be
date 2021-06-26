package com.craw_data.domains.base;

public class SQLQuery {
    public static final String insertCourseQuery = "INSERT INTO public.course(\n" +
            "\tcourse_id, title, description, topic_id, lecturers_id, rating, rating_total, avatar, price)\n" +
            "\tVALUES";

    public static final String insertTopicQuery = "INSERT INTO public.topic(\n" +
            "\ttopic_id, category_id, title)\n" +
            "\tVALUES";

    public static final String insertChapterQuery = "INSERT INTO public.chapter(\n" +
            "\tchapter_id, title, course_id)\n" +
            "\tVALUES";

    public static final String insertLessonQuery = "INSERT INTO public.lesson(\n" +
            "\tcontent_id, title, index, video_link, chapter_id)\n" +
            "\tVALUES";
}
