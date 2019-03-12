package com.example.authserver;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class AuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}

	@Bean
	@ConditionalOnProperty(prefix="redisson",name="singleServer",havingValue = "true")
	public Redisson redissonSingle(){
		Config config = new Config();
		//此示例是单库的，可以是主从、sentinel、集群等模式
		config.useSingleServer().setAddress("redis://localhost:6379");
		return (Redisson) Redisson.create(config);
	}

	@Bean
	@ConditionalOnProperty(prefix="redisson",name = "clusterServer",havingValue = "true")
	public Redisson redissonCluster(){
		Config config = new Config();
		//此示例是单库的，可以是主从、sentinel、集群等模式
		config.useClusterServers().addNodeAddress("redis://localhost:6379");
		return (Redisson) Redisson.create(config);
	}


}
