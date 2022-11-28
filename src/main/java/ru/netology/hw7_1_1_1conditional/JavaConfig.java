package ru.netology.hw7_1_1_1conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @ConditionalOnProperty(prefix = "netology.profile", name = "dev", value = "true")
    @Bean
    public SystemProfile devProfile(){
        return new DevProfile();
    }
    @ConditionalOnProperty(prefix = "netology.profile", name = "dev", value = "false")
    @Bean
    public SystemProfile productionProfile(){
        return new ProductionProfile();
    }
}
