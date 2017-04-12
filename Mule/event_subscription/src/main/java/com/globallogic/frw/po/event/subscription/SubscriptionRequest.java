package com.globallogic.frw.po.event.subscription;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class SubscriptionRequest {

	private String subID;
	private String eventID;
	private String eventLabel;
	private String callbackURL;
	private String healthURL;
	
	public String getSubKey(){
		
		if (eventLabel==null || eventLabel=="") 
			return subID + "_" + eventID;
		else
			return subID + "_" + eventID + "_" + eventLabel;
		
	}
	
	public String getSubValue(){
		
		return callbackURL + "_" + healthURL;
		
	}

	public String getSubID() {
		return subID;
	}

	public void setSubID(String subID) {
		this.subID = subID;
	}

	public String getEventID() {
		return eventID;
	}

	public void setEventID(String eventID) {
		this.eventID = eventID;
	}

	public String getEventLabel() {
		return eventLabel;
	}

	public void setEventLabel(String eventLabel) {
		this.eventLabel = eventLabel;
	}

	public String getCallbackURL() {
		return callbackURL;
	}

	public void setCallbackURL(String callbackURL) {
		this.callbackURL = callbackURL;
	}

	public String getHealthURL() {
		return healthURL;
	}

	public void setHealthURL(String healthURL) {
		this.healthURL = healthURL;
	}

	
}
