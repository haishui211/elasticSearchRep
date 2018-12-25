package com.navy.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfig {
	
	@Bean
    public TransportClient transportClient() throws UnknownHostException{

        TransportAddress node = new TransportAddress(InetAddress.getByName("47.107.189.213"),9300);
        
        Settings settings = Settings.builder()
                .put("cluster.name","elasticSearchCluster")
                .build();

        PreBuiltTransportClient preBuiltTransportClient = new PreBuiltTransportClient(settings);

        preBuiltTransportClient.addTransportAddress(node);

        return preBuiltTransportClient;
    }
	
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
	}
}
