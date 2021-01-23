package com.javaworld.application.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaworld.application.model.AuditInfo;
import com.javaworld.application.service.AuditInfoService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class AuditInfoController {

	@Autowired
	AuditInfoService auditInfoService;

	@Autowired
	HttpServletResponse httpServletResponse;

	/*
	@GetMapping("/audit/all")
	public List<AuditInfo> getAllAudits() {
		return auditInfoService.getAllAudits();
	}
	*/

	@GetMapping("/audit/{auditId}")
	public AuditInfo getAuditDetailsByAuditId(@PathVariable long auditId) {
		return auditInfoService.getAuditDetailsByAuditId(auditId);
	}

	@GetMapping("/audit/logs/{transactionId}/{requestDate}")
	public List<String> getAuditLogs(@PathVariable String transactionId, @PathVariable String requestDate)
			throws IOException {
		return auditInfoService.getAuditLogs(transactionId, requestDate);
	}

	@GetMapping("/audits")
	public List<AuditInfo> getAudits(@RequestParam String userName, @RequestParam int pageNumber) {
		System.out.println("userName: " + userName);
		System.out.println("username len: " + userName.length());
		System.out.println("pageNumber: " + pageNumber);
		return auditInfoService.getAudits(userName, pageNumber);
	}

}
