package cn.llynsyw.spring.configuration.metadata.pojo;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("my")
public class MyProperties {

	private Map<String, Integer> contexts;

	public Map<String, Integer> getContexts() {
		return this.contexts;
	}

	public void setContexts(Map<String, Integer> contexts) {
		this.contexts = contexts;
	}

}

