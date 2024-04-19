package br.com.kumulus.crud.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
		pessoaService.salvar(this.pessoa);
		this.pessoas =  pessoaService.listarTodos();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastro atualizado com sucesso."));
    }
	
	public void excluirPessoa(Pessoa pessoa) {
		System.out.println(pessoa);
		pessoaService.excluir(pessoa);
		this.pessoas =  pessoaService.listarTodos();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exclusão realizada com sucesso."));
	}
	
	public void pessoaSelecionada(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public void prepararNovaPessoa() {
		System.out.println(this.pessoa);
		this.pessoa = new Pessoa();
		System.out.println(this.pessoa);
	}
	
	public void carregaPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public void adicionarEndereco() {
		Endereco endereco = new Endereco();
		this.pessoa.getEnderecos().add(endereco);
	}
}
