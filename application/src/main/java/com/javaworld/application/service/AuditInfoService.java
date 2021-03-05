package com.javaworld.application.service;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaworld.application.dao.HibernateHqlAuditInfoDaoImpl;
import com.javaworld.application.model.AuditInfo;
import com.javaworld.application.util.LogFilePathBuilder;


@Service
public class AuditInfoService {

	@Autowired
	HibernateHqlAuditInfoDaoImpl auditInfoDao;

	//@Lazy
	//@Autowired
	//AppMeterApplication appMain;
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	public List<AuditInfo> getAudits(String userName, int pageNumber) {		
		String targetIp = httpServletRequest.getLocalAddr();
		return auditInfoDao.findBy(userName, targetIp, pageNumber);
	}

	public AuditInfo getAuditEntryDetails(long auditId) throws IOException {
		AuditInfo auditInfo = auditInfoDao.findById(auditId);
		String transactionId = auditInfo.getAppTransaction();
		Date requestTime = auditInfo.getRequestTime();
		String url = auditInfo.getUrl();
		auditInfo.setLogs(getAuditLogs(transactionId, requestTime, url));
		return auditInfo;
	}

	public List<String> getAuditLogs(String transactionId, Date requestDateTime, String url) {

		
		List<String> logsList = new ArrayList<>();
		List<String> paths = getPathsList(requestDateTime, url);
		
		paths.forEach(logFilePath -> {
			System.out.println("logFilePath: " + logFilePath);
			Stream<String> linesStream = null;
			try {
				linesStream = Files.lines(Paths.get(logFilePath));
				List<String> tempLogsList = linesStream.filter(l -> l.contains(transactionId)).collect(Collectors.toList());
				logsList.addAll(tempLogsList);
			} catch (IOException ex) {
				System.out.println("error msg: " + ex.getMessage());
			} finally {
				if(linesStream != null) linesStream.close();
			}
		});
		
	
		return logsList;
	}
	
	
	private List<String> getPathsList(Date requestDateTime, String url){
		
		String[] basePaths = { "C:\\Users\\o-abdelrahman.attya\\cmab_configs\\wayyak\\logs_sec\\", 
                               "C:\\Users\\o-abdelrahman.attya\\app_configs\\cms\\logs",
                               "/app/home/oracle/cmab_configs/wayyak/logs_sec/"};
		
		List<String> paths = new ArrayList<>();

		for (String basePath : basePaths) {

			LogFilePathBuilder pathBuilder = new LogFilePathBuilder();
			String logsFilePath = pathBuilder.setBasePath(basePath).setNodeName().setBranchName(url)
					                         .setDatePrefix(requestDateTime).build();
			
			
			LogFilePathBuilder prevPathBuilder = new LogFilePathBuilder();
			String prevLogsFilePath = prevPathBuilder.setBasePath(basePath).setNodeName()
					                                 .setBranchName(url).setEmptyDatePrefix().build();
			
			paths.add(logsFilePath);
			paths.add(prevLogsFilePath);
		}
		
		return paths;
	}

}