package com.javaworld.application.model;

public class GetAuditLogsRequest {

	private String transactionId;
	private String requestDate;

	public GetAuditLogsRequest() {

	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	@Override
	public String toString() {
		return "GetAuditLogsRequest [transactionId=" + transactionId + ", requestDate=" + requestDate + "]";
	}

}