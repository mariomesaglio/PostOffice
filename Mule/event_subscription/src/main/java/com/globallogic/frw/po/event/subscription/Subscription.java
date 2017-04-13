package com.globallogic.frw.po.event.subscription;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class Subscription {

	private String subID;
	private String eventID;
	private String callbackURL;
	private String healthURL;

	public String getSubValue(){
		return subID + ":" + callbackURL + ":" + healthURL;
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
