import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class HQL {
    public static void main(String[] args){
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        //atraves do nome da classe obter os dados no Bd sql server da tabela emp
        Query query = session.createQuery("from Emp");
        List list = query.list();


        //atualizando dado com hql
        Transaction t = session.beginTransaction();
        Query query2 = session.createQuery("update User set neme=:n where id=:i");
        query2.setParameter("n", "Bryan Christopher");
        query2.setParameter("i", 11);

        int status = query2.executeUpdate();
        System.out.println(status);

        t.commit();

        //delete query with hql

        Query query3 = session.createQuery("delete from Emp where id=100");
        query3.executeUpdate();
    }
}
