package com.anchtun.caching.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class RedisConfig {

	@Value("${spring.redis.host}")
	private String redisHost;

	@Value("${spring.redis.port}")
	private int redisPort;

	@Value("${spring.redis.username}")
	private String redisUserName;

	@Value("${spring.redis.password}")
	private String redisPassword;

	@Value("${spring.redis.withouttls}")
	private Boolean redisWithoutTls;

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(redisHost, redisPort);
		if (redisUserName != null && !redisUserName.isEmpty()) {
			configuration.setUsername(redisUserName);
		}
		if (redisPassword != null && !redisPassword.isEmpty()) {
			configuration.setPassword(redisPassword);
		}
		JedisClientConfiguration jedisClientConfiguration;
		if (Boolean.TRUE.equals(redisWithoutTls)) {
			jedisClientConfiguration = JedisClientConfiguration.builder().build();
		} else {
			jedisClientConfiguration = JedisClientConfiguration.builder().useSsl().build();
		}

		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(configuration, jedisClientConfiguration);
		jedisConnectionFactory.afterPropertiesSet();
		return jedisConnectionFactory;
	}

	@Bean
	@Primary
	public RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}
}