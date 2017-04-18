package com.globallogic.frw.po.event.subscription;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class SubscriptionStatus {

	private String status;

	public SubscriptionStatus(String status) {
		this.status=status;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
