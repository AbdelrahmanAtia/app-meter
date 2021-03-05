package com.javaworld.application.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.javaworld.application.model.AuditInfo;
import com.javaworld.application.util.HibernateUtil;

@Repository
public class HibernateHqlAuditInfoDaoImpl implements AuditInfoDao {

	private static final int PAGE_SIZE = 20;
	
	
	

	/*
	 * private SessionFactory sessionFactory;
	 * 
	 * public HibernateHqlAuditInfoDaoImpl(@Autowired EntityManagerFactory emf) {
	 * this.sessionFactory = emf.unwrap(SessionFactory.class); }
	 */

	public AuditInfo findById(long auditId) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		AuditInfo auditInfo = session.get(AuditInfo.class, auditId);
		System.out.println(auditInfo);
		tx.commit();
		session.close();
		return auditInfo;
	}

	@Override
	public List<AuditInfo> findBy(String searchTerm, String targetIp,int pageNumber) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		Query<AuditInfo> hqlQuery;
		if (searchTerm.trim().length() == 0) {
			hqlQuery = session.createQuery("from AuditInfo order by requestTime desc", AuditInfo.class);
		} else {
			hqlQuery = session
					.createQuery("from AuditInfo where username like :searchTerm or url like :searchTerm order by requestTime desc", AuditInfo.class)
					.setParameter("searchTerm", "%" + searchTerm + "%");
		}

		hqlQuery.setFirstResult(pageNumber - 1).setMaxResults(PAGE_SIZE); // enable pagination
		List<AuditInfo> audits = hqlQuery.list();
		
		tx.commit();
		session.close();

		return audits;
	}

}
