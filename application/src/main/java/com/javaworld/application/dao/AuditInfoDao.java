package com.javaworld.application.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaworld.application.model.AuditInfo;


@Repository
public class AuditInfoDao {

	private SessionFactory sessionFactory;

	public AuditInfoDao(@Autowired EntityManagerFactory emf) {
		this.sessionFactory = emf.unwrap(SessionFactory.class);
	}

	/*
	public List<AuditInfo> getAllAudits() {
		Session session = sessionFactory.openSession();
		NativeQuery<AuditInfo> nativeQuery = session.createNativeQuery("select * from AUDIT_INFO", AuditInfo.class);
		List<AuditInfo> auditsList = nativeQuery.list();
		System.out.println("auditsList: " + auditsList);
		session.close();
		return auditsList;
	}
	*/
	
	
	//using HQL
	public List<AuditInfo> getAllAudits() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query<AuditInfo> query = session.createQuery("from AuditInfo", AuditInfo.class);
		List<AuditInfo> auditsList = query.list();
		System.out.println("auditsList: " + auditsList);
		tx.commit();
		session.close();
		return auditsList;
	}
	
	//using jpa api
	//using named queries
	//using named native queries
	//using jpql
	
	
	
	
	
}
