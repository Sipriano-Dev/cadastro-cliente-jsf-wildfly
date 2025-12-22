package br.com.sipriano.repository;

import br.com.sipriano.domain.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class ClienteDAO {

    @PersistenceContext
    private EntityManager em;

    public void salvar(Cliente cliente) {
        em.persist(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return em.find(Cliente.class, id);
    }

    public List<Cliente> listarTodos() {
        return em.createQuery(
                "select c from Cliente c", Cliente.class
        ).getResultList();
    }

    public void remover(Cliente cliente) {
        Cliente gerenciado = em.merge(cliente);
        em.remove(gerenciado);
    }

}
