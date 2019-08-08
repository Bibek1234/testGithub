package com.exercise.apiexample.apiexample.config;

import com.exercise.apiexample.apiexample.Hello;
import com.exercise.apiexample.apiexample.model.Book;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@EnableKafka
@Configuration
public class SpringConfig {

@Bean
    public RestTemplate restTemplate(){
    return new RestTemplate(getOKHttp());
}
//Added after httpmessage parse exception
@Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
    MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
    ObjectMapper objectMapper=new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    jsonConverter.setObjectMapper(objectMapper);
    return jsonConverter;
}
//This uses HTTP 2 as a protocol to transport data between web services

    private OkHttp3ClientHttpRequestFactory getOKHttp(){
        OkHttpClient okHttpClient=
                new OkHttpClient.Builder().
                        connectionPool(new ConnectionPool(10,20, TimeUnit.SECONDS)).build();
        int timeout=2000;
        OkHttp3ClientHttpRequestFactory clientHttpRequestFactory=new OkHttp3ClientHttpRequestFactory(okHttpClient);
        clientHttpRequestFactory.setConnectTimeout(timeout);
        clientHttpRequestFactory.setReadTimeout(timeout);
        clientHttpRequestFactory.setWriteTimeout(timeout);
        return clientHttpRequestFactory;
    }

@Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource(){
    return DataSourceBuilder.create().build();

    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
    return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean
    public ProducerFactory<String,Object> producerFactory(){

        Map<String,Object> con =new HashMap<>();
        con.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        con.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        con.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory(con);
}

@Bean
    public KafkaTemplate<String, Object>kafkaTemplate(){
    return new KafkaTemplate<>(producerFactory());
}


@Bean
    public ConsumerFactory<String,String> consumerFactory(){
    Map<String,Object> con=new HashMap<>();
    con.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
    con.put(ConsumerConfig.GROUP_ID_CONFIG,"group_id");
    con.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
    con.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

    return new  DefaultKafkaConsumerFactory<>(con);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,String> kafkaListenerContainerFactory(){
    ConcurrentKafkaListenerContainerFactory<String,String> factory=new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    return factory;
    }

    @Bean
    public Hello hello(){
    return new Hello();
    }

}
