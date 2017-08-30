package com.testspring.daos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.testspring.models.Cloth;
import com.testspring.models.ClothAndStore;
import com.testspring.models.Store;
import com.testspring.models.ajaxResponse.ClothDropDownList;

@Repository
public class ClothDAOImpl implements ClothDAO {

	private static final Logger logger = LoggerFactory.getLogger(ClothDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cloth> showClothes() {
		System.out.println("#S showClothes");
		Session session = this.sessionFactory.getCurrentSession();
		List<Cloth> clothList = session.createQuery("from Cloth").list();
		for(Cloth c : clothList) {
			logger.info("Cloth List::"+c);
		}
		System.out.println("#S clothList: " + clothList);
		return clothList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cloth> getClothesForDropDownList() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Cloth.class);
		criteria.setProjection( Projections.projectionList()
				.add(Projections.property("clothId"))
				.add(Projections.property("model")) );
		List<Cloth> clothList = criteria.list();
		System.out.println("#S clothList dropdown with criteria: " + clothList);
		return clothList;
	}

	public BigDecimal getPriceByClothId(int clothId) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Cloth.class);
		criteria.add(Restrictions.eq("clothId", clothId));
		criteria.setProjection( Projections.projectionList() 
				.add(Projections.property("price")) );
		List<Cloth> clothList = criteria.list();
		System.out.println("#S cloth is : " + clothList);
		BigDecimal price = null;
		Object obj = (Object) clothList.get(0);
		price = (BigDecimal) obj;
//		price = obj[0];
		return price;
	}

	public Cloth getClothById(int clothId) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Cloth.class);
		criteria.add(Restrictions.eq("clothId", clothId));
		List<Cloth> clothList = criteria.list();
		Cloth cloth = clothList.get(0);
		return cloth;
	}

	public void updateProductAmountInCloth(int clothId, String factoryName, int produceAmount) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Cloth.class);
		criteria.add(Restrictions.eq("clothId", clothId));
		List<Cloth> clothList = criteria.list();
		Cloth cloth = clothList.get(0);
		cloth.setFactoryName(factoryName);
		cloth.setMadeByYear(new Date());
		cloth.setProduceAmount(produceAmount + cloth.getProduceAmount());
		cloth.setAvailableAmount(produceAmount + cloth.getAvailableAmount()); 
		session.save(cloth);
	}

	public void updateAvailableAmountInCloth(int clothId, int sendAmount) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Cloth.class);
		criteria.add(Restrictions.eq("clothId", clothId));
		List<Cloth> clothList = criteria.list();
		
		if(clothList.size() > 0) {
			Cloth cloth = clothList.get(0);
			cloth.setAvailableAmount(cloth.getAvailableAmount() - sendAmount); 
			session.save(cloth);
		}
		
	}

	public List<ClothDropDownList> getClothByStoreId(int storeId) {
		List<ClothDropDownList> clothList = null;
		Session session = this.sessionFactory.getCurrentSession();
		String queryString = "select c.cloth_id as clothId, c.model as model " + 
							 "from Store s inner join cloth_store cs " +
							 "on s.store_id = cs.store_id inner join Cloth c " +
							 "on cs.cloth_id = c.cloth_id " +
							 "where s.store_id = :storeId";
		
		SQLQuery query = session.createSQLQuery(queryString);
		query.setParameter("storeId", storeId);
		query.addScalar("clothId", Hibernate.INTEGER);
		query.addScalar("model", Hibernate.STRING);
		query.setResultTransformer(Transformers.aliasToBean(ClothDropDownList.class));
		clothList = query.list();

		return clothList;
	}

}
