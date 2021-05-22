package com.craw_data.utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        } catch (HibernateException e) {
            System.err.println(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
