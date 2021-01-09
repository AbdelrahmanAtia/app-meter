package com.javaworld.application.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AUDIT_INFO")
public class AuditInfo {

	@Id
	private long id;
	private String username;
	private Date requestTime;
	private Date responseTime;
	private String appTransaction;
	private String url;
	private String srcIp;
	private String targetIp;
	private String responseStatus;
	private String responseDesc;

	public AuditInfo() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public Date getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Date responseTime) {
		this.responseTime = responseTime;
	}

	public String getAppTransaction() {
		return appTransaction;
	}

	public void setAppTransaction(String appTransaction) {
		this.appTransaction = appTransaction;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSrcIp() {
		return srcIp;
	}

	public void setSrcIp(String srcIp) {
		this.srcIp = srcIp;
	}

	public String getTargetIp() {
		return targetIp;
	}

	public void setTargetIp(String targetIp) {
		this.targetIp = targetIp;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getResponseDesc() {
		return responseDesc;
	}

	public void setResponseDesc(String responseDesc) {
		this.responseDesc = responseDesc;
	}

	@Override
	public String toString() {
		return "AuditInfo [id=" + id + ", username=" + username + ", requestTime=" + requestTime + ", responseTime="
				+ responseTime + ", appTransaction=" + appTransaction + ", url=" + url + ", srcIp=" + srcIp
				+ ", targetIp=" + targetIp + ", responseStatus=" + responseStatus + ", responseDesc=" + responseDesc
				+ "]";
	}

}
