package com.testspring.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.testspring.models.Cloth;
import com.testspring.models.Store;

@Repository
public class StoreDAOImpl implements StoreDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Store> getStoreList() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Store.class);
		List<Store> storeList = criteria.list();
		return storeList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Store> getStoresForDropDownList() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Store.class);
		criteria.setProjection( Projections.projectionList()
				.add(Projections.property("storeId"))
				.add(Projections.property("storeName")) );
		List<Store> storeList = criteria.list();
		System.out.println("#S storeList dropdown with criteria: " + storeList);
		return storeList;
	}

}
