package br.com.kumulus.crud.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.kumulus.crud.model.Endereco;

public class EnderecoDAO implements Serializable {
	
	private static final long serialVersionUID = 2888691364798822825L;
	
	@Inject
	private EntityManager manager;
	
	public EnderecoDAO() {
		
	}
		
	public Endereco buscaPorId(Long Id) {
		return manager.find(Endereco.class, Id);
	}
	
	public Endereco salvar(Endereco endereco) {
		return manager.merge(endereco);
	}

	public void remover(Endereco endereco) {
		endereco = buscaPorId(endereco.getId());
		manager.remove(endereco);
	}

}
