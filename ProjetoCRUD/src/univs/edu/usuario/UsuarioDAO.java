package univs.edu.usuario;

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
        sessao.save(usuario);
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
}
