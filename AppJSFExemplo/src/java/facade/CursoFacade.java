package facade;

import dao.CursoDao;
import entidade.Curso;
import java.util.List;

public class CursoFacade {

    public Curso salvar(Curso curso) {
        CursoDao dao = new CursoDao();
        return dao.salvar(curso);
    }

    public List<Curso> getAll() {
        CursoDao dao = new CursoDao();
        return dao.getAll();
    }

    public void excluir(Curso curso) {
        CursoDao dao = new CursoDao();
        dao.excluir(curso);
    }
}
