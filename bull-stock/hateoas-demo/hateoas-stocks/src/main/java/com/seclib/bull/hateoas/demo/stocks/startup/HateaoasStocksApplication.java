package com.seclib.bull.hateoas.demo.stocks.startup;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.seclib.bull.hateoas.demo.stocks.entity.StocksEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * <p>Description: </p>
 *
 * @author
 * @version 1.0
 * @date
 * @name <p>Copyright:Copyright(c)2020</p>
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.seclib"})
@EntityScan(basePackages = {"com.seclib"})
@EnableJpaRepositories(basePackages = {"com.seclib"})
public class HateaoasStocksApplication {

    public static void main(String[] args) {
        SpringApplication.run(HateaoasStocksApplication.class, args);
    }

    /**
     * Hibernate的初始化
     * @return
     */
    @Bean
    public Hibernate5Module hibernate5Module() {
        return new Hibernate5Module();
    }

    /**
     * 用于json数据的封装处理
     * @return
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {

        return builder -> {
            builder.indentOutput(true);
        };
    }
}
