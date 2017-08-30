package com.testspring.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.testspring.models.Factory;

@Repository
public class FactoryDAOImpl implements FactoryDAO {

	private SessionFactory sessionFactory;
	private static final Logger logger = LoggerFactory.getLogger(FactoryDAOImpl.class);
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Factory> showFactories() {
		System.out.println("#S show Factories in Factory Impl");
		Session session = this.sessionFactory.getCurrentSession();
		List<Factory> factoryList = session.createQuery("from Factory").list();
		System.out.println("#S factoryList: " + factoryList);
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Factory> getFactoriesForDropDownList() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Factory.class);
		criteria.setProjection( Projections.projectionList()
				.add(Projections.property("factoryId"))
				.add(Projections.property("factoryName")) );
		List<Factory> factoryList = criteria.list();
		System.out.println("#S factoryList dropdown with criteria: " + factoryList);
		return factoryList;
	}

	public Factory getFactoryById(int factoryId) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Factory.class);
		criteria.add(Restrictions.eq("factoryId", factoryId));
		List<Factory> factoryList = criteria.list();
		return factoryList.get(0);
	}

}
