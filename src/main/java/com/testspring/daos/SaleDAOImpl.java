package com.testspring.daos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.testspring.models.Sale;
import com.testspring.models.ajaxRequest.SaleForm;

@Repository
public class SaleDAOImpl implements SaleDAO {

	private static final Logger logger = LoggerFactory.getLogger(SaleDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Sale getSaleById(int saleId) {
		return null;
	}

	public List<Sale> getSaleList() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Sale.class);
		List<Sale> saleList = criteria.list();
		return saleList;
	}

	public void insertSale(SaleForm saleForm) {		
		Session session = this.sessionFactory.getCurrentSession();
		
		int clothId = saleForm.getClothId();
		int storeId = saleForm.getStoreId();
		int saleAmounts = saleForm.getSaleAmount();
		BigDecimal totalSale = saleForm.getTotalSale();
		
		Sale sale = new Sale();
		sale.setClothId(clothId);
		sale.setStoreId(storeId);
		sale.setSaleAmounts(saleAmounts);
		sale.setTotalSale(totalSale);
		sale.setSaleDateTime(new Date());
		session.save(sale);
	}

}
