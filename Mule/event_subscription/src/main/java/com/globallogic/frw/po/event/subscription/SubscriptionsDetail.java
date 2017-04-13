package com.globallogic.frw.po.event.subscription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class SubscriptionsDetail {

		private ArrayList<Subscription> subscriptions;
		
		public SubscriptionsDetail(HashMap<byte[],byte[]> subMap) {
			this.subscriptions = new ArrayList<Subscription>();
			parseSet(subMap);
		}

		public ArrayList<Subscription> getSubscriptions() {
			return subscriptions;
		}

		public void setSubscriptions(ArrayList<Subscription> subscriptions) {
			this.subscriptions = subscriptions;
		}
		
		public void parseSet(HashMap<byte[],byte[]> subMap){
			
			List<byte[]> keys = new ArrayList<byte[]>(subMap.keySet());
			byte[] key;
			byte[] value;
			String valueAsString;
			String eventID;
			Subscription subAux;
			
			for (int i = 0; i < keys.size(); i++) {
				
				key = keys.get(i);
				eventID=new String(key);
				
				value=(byte[])subMap.get(key);
				valueAsString = new String(value);
				
				subAux = new Subscription();
				subAux.setSubID(valueAsString.split(":")[0]);
				subAux.setCallbackURL(valueAsString.split(":")[1]);
				subAux.setHealthURL(valueAsString.split(":")[2]);
				subAux.setEventID(eventID);
				
				subscriptions.add(subAux);
				
			}
		}
		
	
}
