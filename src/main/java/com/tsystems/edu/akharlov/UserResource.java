package com.tsystems.edu.akharlov;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;

@Path("/users/")
public class UserResource {
    private ArrayList<User> users;
    private StringWriter stringWriter = new StringWriter();

    @GET
    @Path("format/xml/user_id/{userId}")
    @Produces(MediaType.APPLICATION_XML)
    public String getUsersXml(@PathParam("userId") int userId){
        //return "TO-DO";

        SessionFactory factory = new Configuration()
                .configure("com/tsystems/edu/akharlov/hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserConfig.class)
                .addAnnotatedClass(UserGroupConfig.class)
                .addAnnotatedClass(GroupConfig.class)
                .addAnnotatedClass(Filter.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            String hql = "from User u WHERE u.id = :user_id";
            Query query = session.createQuery(hql);
            //userIds: 1000115, 1000068
            //http://localhost:8080/webapi/users/format/xml/user_id/1000115
            query.setParameter("user_id", userId);
            this.users = (ArrayList<User>) query.getResultList();

            for (User user : users) {
                //System.out.println(user);
                JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
                Marshaller marshaller = jaxbContext.createMarshaller();

                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                //marshaller.marshal(user, new File("C:\\andy\\Development\\Projects\\HibernateJAXBProject\\xmlData\\searchResults.xml"));
                marshaller.marshal(user, stringWriter);

                System.out.println(this.getStringWriter());
            }

            session.getTransaction().commit();
        } catch (JAXBException e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }

        return stringWriter.toString();
    }

    @GET
    @Path("format/json/user_id/{userId}")
    //@Produces(MediaType.APPLICATION_JSON)
    public String getUsersJson(@PathParam("userId") int userId){
        //return "TO-DO";

        SessionFactory factory = new Configuration()
                .configure("com/tsystems/edu/akharlov/hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserConfig.class)
                .addAnnotatedClass(UserGroupConfig.class)
                .addAnnotatedClass(GroupConfig.class)
                .addAnnotatedClass(Filter.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            String hql = "from User u WHERE u.id = :user_id";
            Query query = session.createQuery(hql);
            //userIds: 1000115, 1000068
            //http://localhost:8080/webapi/users/format/json/user_id/1000115
            query.setParameter("user_id", userId);
            this.users = (ArrayList<User>) query.getResultList();

            for(User user : users) {
                //System.out.println(user);
                /*
                JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
                Marshaller marshaller = jaxbContext.createMarshaller();

                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                //marshaller.marshal(user, new File("C:\\andy\\Development\\Projects\\HibernateJAXBProject\\xmlData\\searchResults.xml"));
                marshaller.marshal(user, stringWriter);

                System.out.println(this.getStringWriter());
                */
                ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
                //objectMapper.writeValue(stringWriter, user);
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(stringWriter, user);
                //System.out.println(this.getStringWriter());
            }

            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }

        return stringWriter.toString();
    }

    public String getStringWriter() {
        return stringWriter.toString();
    }
}
