package br.com.alura.comex.service;

import br.com.alura.comex.dao.ClienteDao;
import br.com.alura.comex.dao.PedidoDao;
import br.com.alura.comex.dominio.Cliente;

public class ClienteService {

    private ClienteDao clienteDao;
    private PedidoDao pedidoDao;

    public ClienteService(ClienteDao clienteDao, PedidoDao pedidoDao) {
        this.clienteDao = clienteDao;
        this.pedidoDao = pedidoDao;
    }

    public boolean excluiCliente(Cliente clienteParaExcluir) {
        clienteDao.abreTransacao();

        if (pedidoDao.temPedidoDoCliente(clienteParaExcluir)) {
            return false;
        }

        clienteDao.exclui(clienteParaExcluir);
        clienteDao.efetivaTransacao();

        return true;
    }

    public void insere(Cliente cliente) {
        clienteDao.insere(cliente);
    }

    public Cliente buscaPorId(long id) {
        return clienteDao.buscaPorId(id);
    }
}
