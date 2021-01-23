package com.javaworld.application.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;

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

	public List<AuditInfo> getAllAudits() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Query<AuditInfo> hqlQuery = session
				.createQuery("from AuditInfo order by requestTime desc", AuditInfo.class)
				.setFirstResult(0)
				.setMaxResults(PAGE_SIZE);
		List<AuditInfo> auditsList = hqlQuery.list();
		System.out.println("auditsList: " + auditsList);
		tx.commit();
		session.close();
		return auditsList;
	}

	public AuditInfo getAuditDetailsByAuditId(long auditId) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		AuditInfo auditInfo = session.get(AuditInfo.class, auditId);
		System.out.println(auditInfo);
		tx.commit();
		session.close();
		return auditInfo;
	}

	@Override
	public List<AuditInfo> getAuditsByUserName(String userName, int pageNumber) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		Query<AuditInfo> hqlQuery;
		if (userName.trim().length() == 0) {
			hqlQuery = session.createQuery("from AuditInfo order by requestTime desc", AuditInfo.class);
		} else {
			hqlQuery = session
					.createQuery("from AuditInfo where username like :username order by requestTime desc", AuditInfo.class)
					.setParameter("username", "%" + userName + "%");
		}

		hqlQuery.setFirstResult(0).setMaxResults(PAGE_SIZE);  //enable pagination
		List<AuditInfo> audits = hqlQuery.list();
		
		tx.commit();
		session.close();

		return audits;
	}

}
