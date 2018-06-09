package manager;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entity.Produto;
import persistence.ProdutoDao;


@ManagedBean(name="mbProduto")
@RequestScoped
public class ManagedBeanProduto {
	private Produto produto;

	public ManagedBeanProduto() {
		produto = new Produto();
		
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
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
	
	
	

}
