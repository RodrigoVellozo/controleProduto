package persistence;

import java.util.List;

import javax.persistence.EntityManager;

import entity.Produto;

public class ProdutoDao {
	EntityManager em;

	public void persist(Produto p) throws Exception {
		em = HibernateUtil.getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
		HibernateUtil.close();
	}
	
	public void merge(Produto p)throws Exception{
		em = HibernateUtil.getEmf().createEntityManager();
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		em.close();
		HibernateUtil.close();
	}
	
	public void remove(Produto p)throws Exception{
		em=HibernateUtil.getEmf().createEntityManager();
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		em.close();
		HibernateUtil.close();
	}
	
	public Produto findById(Integer id)throws Exception{
		em=HibernateUtil.getEmf().createEntityManager();
		em.getTransaction().begin();
		Produto p = em.find(Produto.class, id);
		em.close();
		HibernateUtil.close();
		return p;
	}
	
	public List<Produto> findAll()throws Exception{
		em = HibernateUtil.getEmf().createEntityManager();
		em.getTransaction().begin();
		List<Produto> lista = em.createNamedQuery("produto.findAll").getResultList();  
		em.close();
		HibernateUtil.close();
		return lista;
	}
	
	
}
