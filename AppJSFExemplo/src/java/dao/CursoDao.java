package dao;

import entidade.Curso;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class CursoDao {

    public Curso salvar(Curso curso) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(curso);
        session.getTransaction().commit();
        session.close();
        return curso;
    }

    public List<Curso> getAll() {
        List<Curso> lista = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        lista = session.createQuery("from Curso").list();
        return lista;
    }

    public void excluir(Curso curso) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(curso);
        session.getTransaction().commit();
        session.close();
    }
}
