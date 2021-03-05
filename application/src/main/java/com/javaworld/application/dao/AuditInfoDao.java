package com.javaworld.application.dao;

import java.util.List;

import com.javaworld.application.model.AuditInfo;

public interface AuditInfoDao {
	
	AuditInfo findById(long auditId);
	
	List<AuditInfo> findBy(String searchTerm, String targetIp, int pageNumber);

	
}
