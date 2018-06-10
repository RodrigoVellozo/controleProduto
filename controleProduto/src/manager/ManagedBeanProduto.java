package manager;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import entity.Produto;
import persistence.ProdutoDao;


@ManagedBean(name="mbProduto")
@RequestScoped
public class ManagedBeanProduto {
	private Produto produto;
	
	private DataModel<Produto> listagemProdutos;

	public ManagedBeanProduto() {
		produto = new Produto();
		
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public DataModel<Produto> getListagemProdutos() {
		try {
			
			listagemProdutos= new ListDataModel<Produto>(new ProdutoDao().findAll());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listagemProdutos;
	}

	public void setListagemProdutos(DataModel<Produto> listagemProdutos) {
		this.listagemProdutos = listagemProdutos;
	}

	public void cadastrar() {
		String mensagem = null;
		
		try {
			
			new ProdutoDao().persist(produto);
			
			produto = new Produto();
			
			mensagem = "Venda Cadastrada com sucesso!";
			
		} catch (Exception e) {
			mensagem="Erro >>> "+ e.getMessage();
			e.printStackTrace();
		}
		
		FacesMessage msg =  new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage("formcadastro", msg);
		
	}
	
	public void excluir() {
		String mensagem= null;
		try {
			
			Produto produto = (Produto) listagemProdutos.getRowData();
			new ProdutoDao().remove(produto);
			mensagem="Produto excluido!";
			
		} catch (Exception e) {
			mensagem="Error >>>"+e.getMessage();
			e.printStackTrace();
		}
		
		FacesMessage msg = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage("formcadastro", msg);
		
	}
	
	
	

}
