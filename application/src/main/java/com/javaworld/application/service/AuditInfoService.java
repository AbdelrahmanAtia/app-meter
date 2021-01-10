package com.javaworld.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaworld.application.dao.HibernateHqlAuditInfoDaoImpl;
import com.javaworld.application.model.AuditInfo;

@Service
public class AuditInfoService {

	@Autowired
	HibernateHqlAuditInfoDaoImpl auditInfoDao;

	public List<AuditInfo> getAllAudits() {	
		return auditInfoDao.getAllAudits();
	}

	public AuditInfo getAuditDetailsByAuditId(long auditId) {
		return auditInfoDao.getAuditDetailsByAuditId(auditId);
	}
}
