package managedBean;

import entidade.Curso;
import facade.CursoFacade;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "cursoMB")
public class CursoMB implements Serializable {

    private Curso curso = new Curso();

    public List<Curso> getLista() {
        CursoFacade facade = new CursoFacade();
        return facade.getAll();
    }

    public String novoCurso() {
        curso = new Curso();
        return "editCurso.xhtml";
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String salvar() {
        CursoFacade facade = new CursoFacade();
        facade.salvar(curso);
        return "listCurso.xhtml";
    }

    public String editar() {
        return "editCurso.xhtml";
    }

    public String excluir() {
         CursoFacade facade = new CursoFacade();
         facade.excluir(curso);
        return "listCurso.xhtml";
    }

}
