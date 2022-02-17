package org.example;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfiguration {

    spring.datasource.url = jdbc:mysql://localhost:3306/jpa_jbd?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false
    spring.datasource.username=root
    spring.datasource.password=password
    spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
}
