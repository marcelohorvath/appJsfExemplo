package dao;

import entidade.Curso;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class CursoDao {

    public Curso salvar(Curso curso) {
        HibernateUtility.beginTransaction();
        HibernateUtility.getSession().saveOrUpdate(curso);
        HibernateUtility.commitTransaction();
        return curso;
    }

    public List<Curso> getAll() {
        List<Curso> lista = new ArrayList();
        lista = HibernateUtility.getSession().createQuery("from Curso").list();
        return lista;
    }

    public void excluir(Curso curso) {
        HibernateUtility.beginTransaction();
        HibernateUtility.getSession().delete(curso);
        HibernateUtility.commitTransaction();
    }
}
