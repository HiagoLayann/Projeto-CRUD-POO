
package univs.edu.usuario;

import org.hibernate.Session;
import org.hibernate.Transaction;
import univs.edu.util.HibernateUtil;


public class UsuarioDAO {
    
   private Session sessao;
   private Transaction trasacao;
   
   
   public void salvar(Usuario usuario){
       sessao = HibernateUtil.getSessionFactory().openSession();
       
       trasacao = sessao.beginTransaction();
       
       sessao.save(usuario);
       trasacao.commit();
       sessao.clear();
   }
   
    
    
}
