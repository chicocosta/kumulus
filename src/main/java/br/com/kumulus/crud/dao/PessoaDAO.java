package br.com.kumulus.crud.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.kumulus.crud.model.Pessoa;

public class PessoaDAO implements Serializable {
	
	private static final long serialVersionUID = 3468431083745749985L;
	
	@Inject
	private EntityManager manager;
	
	public PessoaDAO() {
		
	}
	
	public Pessoa buscaPorId(Long Id) {
		return manager.find(Pessoa.class, Id);
	}
	
	public List<Pessoa> buscarPorNome(String nome) {
		String jpql = "from Pessoa where nome like :nome";
		TypedQuery<Pessoa> query = manager
				.createQuery(jpql, Pessoa.class);
		query.setParameter("nome", nome + "%");
		return query.getResultList();
	}
	
	public List<Pessoa> buscarTodas() {
		String jpql = "from Pessoa";
		TypedQuery<Pessoa> query = manager
				.createQuery(jpql, Pessoa.class);
		return query.getResultList();
	}
	
	public Pessoa salvar(Pessoa pessoa) {
		return manager.merge(pessoa);
	}

	public void remover(Pessoa pessoa) {
		pessoa = buscaPorId(pessoa.getId());
		manager.remove(pessoa);
	}

}
