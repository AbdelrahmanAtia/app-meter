package com.javaworld.application.dao;

import java.util.List;

import com.javaworld.application.model.AuditInfo;

public interface AuditInfoDao {
	
	List<AuditInfo> getAllAudits();
	
	AuditInfo getAuditDetailsByAuditId(long auditId);
	
	List<AuditInfo> getAuditsByUserName(String userName, int pageNumber);

	
}
