package ir.maktab.java32.hibernate.projects.hibercateStart;

import ir.maktab.java32.hibernate.projects.hibercateStart.confighibernate.HibernateUtil;
import org.hibernate.SessionFactory;

public class HobernateStartApplication {
    public static void main(String[] args) {
        SessionFactory session = HibernateUtil.getSessionFactory();
    }
}
