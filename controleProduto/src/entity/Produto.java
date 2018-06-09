package entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="produto")
@NamedQueries(
		@NamedQuery(name="produto.findAll", query="select p from Produto as p ")
)
public class Produto {
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private Integer quantidade;
	private String departamento;
	@Temporal(TemporalType.DATE)
	private Date dataFabricacao;

	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produto(Integer id, String nome,Integer quantidade, String departamento, Date dataFabricacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.departamento = departamento;
		this.dataFabricacao = dataFabricacao;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", quantidade=" + quantidade + ", departamento=" + departamento
				+ ", dataFabricacao=" + dataFabricacao + "]";
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public Date getDataFabricacao() {
		return dataFabricacao;
	}
	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

}
