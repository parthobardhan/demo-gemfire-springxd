package com.pivotal.demo.transformer;

import java.util.Set;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class CSVToJson {
	public Message<?> translate(Message<?> message) {
		Message<?> result = message;
		String payload = (String) message.getPayload();
		String[] info = payload.split("\\|");
		if (info != null && info.length != 0) {
			Person person = new Person();
			person.setId(info[0]);
			person.setName(info[1]);
			person.setEmail(info[2]);

			System.out.println("FILE_NAME " + message.getHeaders().get("file_name"));
			
			Set keySet = message.getHeaders().keySet();
			for(Object key : keySet){
				// display the key:
				Object value = message.getHeaders().get(key);
				// display the value
				System.out.println("LOGGING HEADER:: key: " + key + "; value: " + value.toString());
			}
			
			result = MessageBuilder.withPayload(person).copyHeadersIfAbsent(message.getHeaders())
					.setHeaderIfAbsent("gemfireKey", info[0]).build();
		} else {
			throw new RuntimeException("can not process payload");
		}
		return result;
	}
}
