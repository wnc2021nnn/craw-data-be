package com.craw_data.domains.dao;

import com.craw_data.models.Course;
import com.craw_data.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class CourseDAO {
    public static List<Course> getAllCourse() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Course> rs = null;

       try {
           String hql = "select c from Course c";
           Query query = session.createQuery(hql);
           rs = query.list();
       } catch (HibernateException e) {
           System.err.println(e);
       }

        return rs;
    }
}
