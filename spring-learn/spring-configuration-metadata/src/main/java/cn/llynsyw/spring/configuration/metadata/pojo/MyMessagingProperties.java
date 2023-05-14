package cn.llynsyw.spring.configuration.metadata.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "my.messaging")
public class MyMessagingProperties {

	private List<String> addresses = new ArrayList<>(Arrays.asList("a", "b"));

	private ContainerType containerType = ContainerType.SIMPLE;

	public enum ContainerType {
		SIMPLE, DIRECT
	}

}

