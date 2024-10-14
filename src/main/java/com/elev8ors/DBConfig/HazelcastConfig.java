package com.elev8ors.DBConfig;


import com.hazelcast.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfig {

    @Bean(name = "customHazelcastConfig")
    public Config hazelcastConfig() {
        return new Config()
                .setInstanceName("hazelcast-instance")
                .addMapConfig(new MapConfig()
                        .setName("products-cache")
                        .setEvictionConfig(new EvictionConfig()
                                .setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_SIZE)
                                .setSize(200)
                                .setEvictionPolicy(EvictionPolicy.LRU))
                        .setTimeToLiveSeconds(3600));  // 1-hour TTL
    }
}
