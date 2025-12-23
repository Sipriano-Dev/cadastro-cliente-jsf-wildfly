package br.com.sipriano.bean;

import br.com.sipriano.domain.Cliente;
import br.com.sipriano.repository.ClienteDAO;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named //visível pro jsv em clientes.xhtml
@ViewScoped //existe enquanto a tela existir
public class ClienteBean implements Serializable {

    @Inject
    private ClienteDAO clienteDAO;

    private Cliente cliente = new Cliente();

    public void salvar() {
        clienteDAO.salvar(cliente);
        cliente = new Cliente(); // limpa o formulário
    }

    public List<Cliente> getClientes() {
        return clienteDAO.listarTodos();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}