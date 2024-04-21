package br.com.kumulus.crud.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import br.com.kumulus.crud.model.Endereco;
import br.com.kumulus.crud.model.Pessoa;
import br.com.kumulus.crud.service.CadastroPessoaService;

@Named
@ViewScoped
public class PessoaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroPessoaService pessoaService;
	
	private Pessoa pessoa;
	
	private List<Pessoa> pessoas;
	
	private List<Endereco> enderecos;
	
	private Endereco endereco;
	
	private List<Endereco> enderecosSelecionados;
	
	public List<Pessoa> getPessoas(){
		pessoas =  pessoaService.listarTodos();
//		pessoas.forEach(pessoa -> {
//			System.out.println(pessoa.getNome());
//			System.out.println(pessoa.getEnderecos());
//		});
		return pessoas;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
		this.enderecos = this.pessoa.getEnderecos();
		System.out.println("Endereços Set: " + enderecos);
	}
	
	public List<Endereco> getEnderecos() {
		System.out.println("Endereços Get: " + enderecos);
		return enderecos;
	}
	
	public void salvarPessoa() {

		if(this.pessoa.getId() == null) {
			pessoaService.salvar(this.pessoa);
			FacesContext.getCurrentInstance().addMessage("Pessoa Incluída", new FacesMessage("Cadastro incluído com sucesso."));
		} else {
			pessoaService.alterar(this.pessoa);
			FacesContext.getCurrentInstance().addMessage("Pessoa Alterada", new FacesMessage("Cadastro alterado com sucesso."));
		}
		this.pessoas =  pessoaService.listarTodos();
		
    }
	
	public void excluirPessoa(Pessoa pessoa) {
		System.out.println(pessoa);
		pessoaService.excluir(pessoa);
		this.pessoas =  pessoaService.listarTodos();
		FacesContext.getCurrentInstance().addMessage("Pessoa Excluída", new FacesMessage("Exclusão realizada com sucesso."));
	}
	
	public void pessoaSelecionada(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public void prepararNovaPessoa() {
		System.out.println(this.pessoa);
		this.pessoa = new Pessoa();
		List<Endereco> enderecos = new ArrayList<Endereco>();
		this.pessoa.setEnderecos(enderecos);
		System.out.println(this.pessoa);
	}
	
	public void carregaPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public void adicionarEndereco() {
		Endereco endereco = new Endereco();
		this.pessoa.getEnderecos().add(endereco);
	}
	
	public void editarLinhaEndereco(RowEditEvent event) {
		endereco = (Endereco) event.getObject();
		endereco.setCep(endereco.getCep().replaceAll("[^0-9]+", ""));
		pessoa.getEnderecos()
			.forEach(end -> {
				if(endereco.getId() == endereco.getId()) {
					end = endereco;
				}
			});
		System.out.println(this.pessoa);
        FacesMessage msg = new FacesMessage("Endereco alterado.", "Alteração realizada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void excluirEndereco(Endereco endereco) {
		this.pessoa.getEnderecos().remove(endereco);
		if(endereco.getId() != null) {
			pessoaService.excluirEndereco(endereco);
		}
	}
	
	public List<Endereco> getEnderecosSelecionados() {
        return enderecosSelecionados;
    }
	
	public void setEnderecosSelecionados(List<Endereco> enderecosSelecionados) {
        this.enderecosSelecionados = enderecosSelecionados;
    }
}
