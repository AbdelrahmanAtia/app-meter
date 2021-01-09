package com.javaworld.application.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaworld.application.model.AuditInfo;
import com.javaworld.application.service.AuditInfoService;



@RestController
@RequestMapping("/audits")
public class AuditInfoController {

	@Autowired
	AuditInfoService auditInfoService;
	
	@Autowired
	HttpServletResponse httpServletResponse;

	@GetMapping("/all")
	public List<AuditInfo> getAllAudits() {
		System.out.println("starting the controller");
		httpServletResponse.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		return auditInfoService.getAllAudits();
	}

}
