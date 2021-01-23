package com.javaworld.application.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaworld.application.dao.HibernateHqlAuditInfoDaoImpl;
import com.javaworld.application.model.AuditInfo;
import com.javaworld.application.util.DateUtil;

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
	
	public List<AuditInfo> getAudits(String userName, int pageNumber) {
		return auditInfoDao.getAuditsByUserName(userName, pageNumber);
	}

	public List<String> getAuditLogs(String transactionId, String requestDate) throws IOException {
		// String logsFilePath = cmsBackEndApplication.getLogsFilesPath() + File.separator + "project.log";
		requestDate = requestDate.substring(0, requestDate.indexOf('T'));
		if (DateUtil.stringToDate(requestDate).isEqual(LocalDate.now())) {
			requestDate = "";
		} else {
			requestDate = "." + requestDate;
		}
		
		String logsFilePath = "C:\\Users\\o-abdelrahman.attya\\app_configs\\cms\\logs\\project.log" + requestDate;
		
		Path path = Paths.get(logsFilePath);
		List<String> logsList = null;
		try (Stream<String> lines = Files.lines(path)) {
			logsList =  lines
					     .filter(l -> l.contains(transactionId))
					     .collect(Collectors.toList());
			//.collect(Collectors.joining(System.lineSeparator()));
		}
		
		return logsList;
	}

}
