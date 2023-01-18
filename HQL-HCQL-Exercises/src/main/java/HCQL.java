import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class HCQL {
    public static void main(String[] args){

        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        Criteria c = session.createCriteria(Emp.class);
        List list = c.list();

        //obtem do 10¿ até o 20¿ dado
        c.setFirstResult(10);
        c.setMaxResults(20);

        //exemplo de salarios maior de 10 mil

        c.add(Restrictions.gt("salary", 10000));
        List list = c.list();

        //exemplo de listagem ondenada

        c.addOrder(Order.asc("salary"));
        List list = c.list();


        //busca por projeção

        c.setProjection(Projections.property("Name"));
        List list = c.list();
    }
}
