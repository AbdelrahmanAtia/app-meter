package com.javaworld.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaworld.application.dao.AuditInfoDao;
import com.javaworld.application.model.AuditInfo;

@Service
public class AuditInfoService {

	@Autowired
	AuditInfoDao auditInfoDao;

	public List<AuditInfo> getAllAudits() {	
		System.out.println("starting the service");
		return auditInfoDao.getAllAudits();
	}
}
