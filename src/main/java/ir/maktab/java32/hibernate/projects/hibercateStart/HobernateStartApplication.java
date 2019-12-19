package ir.maktab.java32.hibernate.projects.hibercateStart;

import ir.maktab.java32.hibernate.projects.hibercateStart.confighibernate.HibernateUtil;
import ir.maktab.java32.hibernate.projects.hibercateStart.entities.Incident;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class HobernateStartApplication {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        //get session
        Session session = sessionFactory.openSession();
        //transaction start
        session.beginTransaction();
        //====================================

        //save
        Incident incident = new Incident("Problem 1", "Some details", new Date());
        Long id = (Long) session.save(incident);
        System.out.println("Incident saved and its id is " + id);
        System.out.println(incident);

        //find by id
        Incident incident2 = session.load(Incident.class, 2L);
        System.out.println(incident2);

        //find all
        Query query = session.createQuery("from Incident ");
        List<Incident> incidentList = query.list();
        incidentList.forEach(System.out::println);

        System.out.println(
                incidentList
                        .stream()
                        .filter(incident1 -> incident1.getId() > 2)
                        .count());

        // remove
//        Query query_remove = session.createQuery("delete from Incident  where id = :id");
//        query_remove.setLong("id", 3L);

//        Incident incident3 = session.load(Incident.class,3L);
//        session.remove(incident3);

        //update
        Incident incident5 = session.load(Incident.class, 5L);
        incident5.setTitle("my new updated title");
        session.update(incident5);
        //====================================
        //transaction commit
        session.getTransaction().commit();
        session.close();

    }
}
