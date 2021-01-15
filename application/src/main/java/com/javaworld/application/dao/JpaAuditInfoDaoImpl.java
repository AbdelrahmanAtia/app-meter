/*
 * package com.javaworld.application.dao;
 * 
 * import java.util.List;
 * 
 * import javax.persistence.EntityManager; import
 * javax.persistence.EntityManagerFactory;
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * 
 * import com.javaworld.application.model.AuditInfo;
 * 
 * public class JpaAuditInfoDaoImpl implements AuditInfoDao{
 * 
 * 
 * @Autowired EntityManagerFactory emf;
 * 
 * 
 * @Override public List<AuditInfo> getAllAudits() { EntityManager entityManager
 * = emf.createEntityManager(); List<AuditInfo> auditsList = entityManager
 * .createQuery("select * from AuditInfo", AuditInfo.class) .getResultList();
 * 
 * return auditsList; }
 * 
 * @Override public AuditInfo getAuditDetailsByAuditId(long auditId) { // TODO
 * Auto-generated method stub return null; }
 * 
 * 
 * 
 * 
 * }
 */