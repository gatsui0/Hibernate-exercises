package org.example;
  
import org.hibernate.Session;  
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
  
public class FetchTest {

    public static void main(String[] args) {

        StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();

        Session session1=factory.openSession();
        Employee emp1=(Employee)session1.load(Employee.class,121);
        System.out.println(emp1.getId()+" "+emp1.getName()+" "+emp1.getSalary());
        session1.close();

        Session session2=factory.openSession();
        Employee emp2=(Employee)session2.load(Employee.class,150);
        System.out.println(emp2.getId()+" "+emp2.getName()+" "+emp2.getSalary());
        session2.close();

        Session session22=factory.openSession();
        Employee emp3=(Employee)session22.load(Employee.class,121);
        System.out.println(emp3.getId()+" "+emp3.getName()+" "+emp3.getSalary());
        session22.close();

    }
}  