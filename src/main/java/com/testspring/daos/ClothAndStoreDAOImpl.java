package com.testspring.daos;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.testspring.models.ClothAndStore;
import com.testspring.models.ajaxRequest.SaleForm;

@Repository
public class ClothAndStoreDAOImpl implements ClothAndStoreDAO {

	private static final Logger logger = LoggerFactory.getLogger(ClothDAOImpl.class);
	
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void saveOrUpdate(int clothId, int storeId, int amount) {
		System.out.println("#S saveOrUpdate");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ClothAndStore.class);
		criteria.add(Restrictions.eq("clothId", clothId));
		criteria.add(Restrictions.eq("storeId", storeId));
		List<ClothAndStore> clothAndStoreList = criteria.list();
		
		System.out.println("#S clothAndStoreList.size(): " + clothAndStoreList.size());
		// Insert
		if(clothAndStoreList.size() == 0) {
			System.out.println("#S clothAndStoreList.size() == 0");
			ClothAndStore clothAndStore = new ClothAndStore();
			clothAndStore.setClothId(clothId);
			clothAndStore.setStoreId(storeId);
			clothAndStore.setAmount(amount);
			clothAndStore.setAvailableAmount(amount);
			clothAndStore.setUpdatedBy("Admin");
			clothAndStore.setUpdatedDate(new Date());
			session.save(clothAndStore);
		}
		else {
			System.out.println("#S else22 clothAndStoreList.size() == 0");
			ClothAndStore clothAndStore = clothAndStoreList.get(0);
			clothAndStore.setAmount(clothAndStore.getAmount() + amount);
			clothAndStore.setAvailableAmount(clothAndStore.getAvailableAmount() + amount);
			clothAndStore.setUpdatedBy("Admin");
			clothAndStore.setUpdatedDate(new Date());
			session.save(clothAndStore);
		}

	}

	public void updateAvailableAmountInClothANDStore(SaleForm saleForm) {
		Session session = this.sessionFactory.getCurrentSession();
		int clothId = saleForm.getClothId();
		int storeId = saleForm.getStoreId();
		int sellAmount = saleForm.getSaleAmount();
		
		Criteria criteria = session.createCriteria(ClothAndStore.class);
		criteria.add(Restrictions.eq("clothId", clothId));
		criteria.add(Restrictions.eq("storeId", storeId));
		List<ClothAndStore> clothAndStoreList = criteria.list();
		ClothAndStore clothAndStore = clothAndStoreList.get(0);
		clothAndStore.setAvailableAmount(clothAndStore.getAvailableAmount() - sellAmount);
		clothAndStore.setUpdatedDate(new Date());
		session.save(clothAndStore);
	}

}
