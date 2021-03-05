package com.javaworld.application.util;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

public class LogFilePathBuilder {

	private String basePath;
	private String nodeName;
	private String branchName;
	private String datePrefix;

	public LogFilePathBuilder setBasePath(String basePath) {
		this.basePath = basePath;
		return this;
	}

	public LogFilePathBuilder setNodeName() {
		String nodeName = System.getProperty("weblogic.Name");
		this.nodeName = "_" + (nodeName != null ? nodeName : "local");
		return this;
	}

	public LogFilePathBuilder setBranchName(String url) {
		int restIndex = url.indexOf("rest");
		String subUrl = url.substring(0 ,restIndex - 1);
		int dashIndex = subUrl.indexOf("-");
		this.branchName = (dashIndex == -1)? "": "_" + subUrl.substring(dashIndex + 1);
		return this;
	}

	public LogFilePathBuilder setDatePrefix(Date requestDateTime) {
		if (DateUtils.isSameDay(requestDateTime, new Date())) {
			this.datePrefix = "";
		} else {
			// remove the time part from the string date
			String datePrefix = requestDateTime.toString();
			datePrefix = datePrefix.substring(0, datePrefix.indexOf(' ')); // yyyy-MM-dd
			this.datePrefix = "." + datePrefix;
		}
		return this;
	}
	
	public LogFilePathBuilder setEmptyDatePrefix() {
		this.datePrefix = "";
		return this;
	}	
	
	public String build() {
		return this.basePath 
				+ "project" 
				+ this.nodeName 
	            + this.branchName 
	            + ".log"
	            + this.datePrefix;
	}

}
