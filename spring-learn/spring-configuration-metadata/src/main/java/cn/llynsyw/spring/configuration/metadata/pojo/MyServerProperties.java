package cn.llynsyw.spring.configuration.metadata.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.StringJoiner;

@Component
@Data
@ConfigurationProperties(prefix = "my.server")
public class MyServerProperties {

	/**
	 * Name of the server.
	 */
	private String name;

	/**
	 * server listen host
	 */
	private Host host;

	@Data
	public static class Host {
		/**
		 * IP address to listen to.
		 */
		private String ip;


		/**
		 * Port to listener to.
		 */
		private int port;
	}

	public static void main(String[] args) {
		StringJoiner joiner = new StringJoiner(",");
		joiner.add("hello");
		joiner.add("world");
		System.out.println(joiner);
	}
}
