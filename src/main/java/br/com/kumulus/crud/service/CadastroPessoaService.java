package br.com.kumulus.crud.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.kumulus.crud.config.Transacional;
import br.com.kumulus.crud.dao.PessoaDAO;
import br.com.kumulus.crud.model.Pessoa;

public class CadastroPessoaService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PessoaDAO pessoaDao;
	
	@Transacional
	public void salvar(Pessoa pessoa) {
		pessoaDao.salvar(pessoa);
	}
	
	@Transacional
	public void excluir(Pessoa pessoa) {
		pessoaDao.remover(pessoa);
	}
	
	public List<Pessoa> listarTodos() {
		return pessoaDao.buscarTodas();
	}

}
