package org.learning.notes.configs.filters;

import org.learning.notes.filters.FilterCustom;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterControllerConfig {

    @Bean // componente que irã controlar o filtro especificado
    public FilterRegistrationBean<FilterCustom> filterRegistrationBean() {
        FilterRegistrationBean<FilterCustom> register =
                new FilterRegistrationBean<>();

        register.setFilter(new FilterCustom()); // colocando o filtro customizado que será utilizado
        register.addUrlPatterns("/somente_get"); // adicionando as rotas que passaram pelo filtro

        return register;
    }

}
