package univs.edu.usuario;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import univs.edu.util.HibernateUtil;

public class UsuarioDAO {

    private Session sessao;
    private Transaction trasacao;

    public void salvar(Usuario usuario) {
        sessao = HibernateUtil.getSessionFactory().openSession();

        trasacao = sessao.beginTransaction();
        if(usuario.getIdUsuario()== 0){
        sessao.save(usuario);
        }else{
            editar(usuario);
        }
        
        trasacao.commit();
        sessao.clear();
    }

    public void excluir(Usuario usuario) {
        sessao = HibernateUtil.getSessionFactory().openSession();

        trasacao = sessao.beginTransaction();
        sessao.delete(usuario);
        trasacao.commit();
        sessao.clear();
    }

    public void editar(Usuario usuario) {
        sessao = HibernateUtil.getSessionFactory().openSession();

        trasacao = sessao.beginTransaction();
        sessao.update(usuario);
        trasacao.commit();
        sessao.clear();
    }
    
        public Usuario pesquisar(int id) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trasacao = sessao.beginTransaction();
        Usuario usuario = (Usuario) sessao.createCriteria(Usuario.class).add(Restrictions.eq("idUsuario", id)).uniqueResult();
        sessao.close();
        return usuario;
    }
        
                public List<Usuario> listarUsuarios () {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trasacao = sessao.beginTransaction(); List<Usuario> usuario = sessao.createCriteria(Usuario.class).list();
        sessao.close();
        return usuario;
    }
}
