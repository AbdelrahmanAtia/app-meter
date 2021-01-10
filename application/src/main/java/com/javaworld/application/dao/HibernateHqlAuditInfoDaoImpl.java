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

@Repository
public class HibernateHqlAuditInfoDaoImpl implements AuditInfoDao {

	private SessionFactory sessionFactory;

	public HibernateHqlAuditInfoDaoImpl(@Autowired EntityManagerFactory emf) {
		this.sessionFactory = emf.unwrap(SessionFactory.class);
	}

	public List<AuditInfo> getAllAudits() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query<AuditInfo> hqlQuery = session.createQuery("from AuditInfo", AuditInfo.class);
		List<AuditInfo> auditsList = hqlQuery.list();
		System.out.println("auditsList: " + auditsList);
		tx.commit();
		session.close();
		return auditsList;
	}

	public AuditInfo getAuditDetailsByAuditId(long auditId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query<AuditInfo> hqlQuery = session
				.createQuery("from AuditInfo where id = :id", AuditInfo.class)
				.setParameter("id", auditId);
		AuditInfo auditInfo = hqlQuery.getSingleResult();
		tx.commit();
		session.close();
		return auditInfo;
	}

}
