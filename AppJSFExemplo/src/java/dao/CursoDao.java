package dao;

import entidade.Curso;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class CursoDao {

    public Curso salvar(Curso curso) {
        Session session = null;
        HibernateUtility.beginTransaction();
        session = HibernateUtility.getSession();
        session.saveOrUpdate(curso);
        HibernateUtility.commitTransaction();
        HibernateUtility.closeSession();
        return curso;
    }

    public List<Curso> getAll() {
        List<Curso> lista = new ArrayList();
        Session session = null;
        HibernateUtility.beginTransaction();
        session = HibernateUtility.getSession();
        lista = session.createQuery("from Curso").list();
        HibernateUtility.commitTransaction();
        HibernateUtility.closeSession();
        return lista;
    }

    public void excluir(Curso curso) {
        Session session = null;
        HibernateUtility.beginTransaction();
        session = HibernateUtility.getSession();
        session.delete(curso);
        HibernateUtility.commitTransaction();
        HibernateUtility.closeSession();
    }
}
