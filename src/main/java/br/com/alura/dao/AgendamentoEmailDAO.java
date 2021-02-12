package br.com.alura.dao;

import br.com.alura.entidade.AgendamentoEmail;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AgendamentoEmailDAO {

    /*
    SEM O EBJ, A IMPLEMENTAÇÃO DO EntityManager FICARIA CONFORME ABAIXO
    private EntityManager entityManager;
    public AgendamentoEmailDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendamentoEmailDS");
        this.entityManager = emf.createEntityManager();
    }
    public List<AgendamentoEmail> listar() {
        entityManager.getTransaction().begin();
        List<AgendamentoEmail> resultado = entityManager
                .createQuery("select ae from AgendamentoEmail ae", AgendamentoEmail.class)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultado;
    }
    */

    @PersistenceContext
    private EntityManager entityManager;

    public List<AgendamentoEmail> listar() {
        return entityManager.createQuery("select ae from AgendamentoEmail ae", AgendamentoEmail.class)
                .getResultList();
    }

    public void inserir(AgendamentoEmail agendamentoEmail) {
        entityManager.persist(agendamentoEmail);
    }

    /*
    Adicionamos @Stateless na Classe e @PersistenceContext no atributo
     */

    public List<AgendamentoEmail> listarPorNaoAgendado() {
        return entityManager
                .createQuery("SELECT ae FROM AgendamentoEmail ae WHERE ae.agendado = false",
                        AgendamentoEmail.class).getResultList();
    }

    public void alterar(AgendamentoEmail agendamentoEmail) {
        entityManager.merge(agendamentoEmail);
        //merge é quem fará o UPDATE
    }
}