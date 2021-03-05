package com.javaworld.application.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaworld.application.model.AuditInfo;
import com.javaworld.application.model.GetAuditLogsRequest;
import com.javaworld.application.service.AuditInfoService;
import org.hibernate.type.BigIntegerType;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class AuditInfoController {

	@Autowired
	AuditInfoService auditInfoService;

	@GetMapping("/audits")
	public List<AuditInfo> getAudits(@RequestParam String userName, @RequestParam int pageNumber) {
		System.out.println("userName: " + userName);
		System.out.println("username len: " + userName.length());
		System.out.println("pageNumber: " + pageNumber);
		return auditInfoService.getAudits(userName, pageNumber);
	}
	
	@GetMapping("/audits/{auditId}")
	public AuditInfo getAuditEntryDetails(@PathVariable long auditId) throws IOException {
		return auditInfoService.getAuditEntryDetails(auditId);
	}

}
