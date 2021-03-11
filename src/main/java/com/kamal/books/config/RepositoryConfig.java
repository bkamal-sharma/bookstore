package com.kamal.books.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Type;
import java.util.concurrent.TimeUnit;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer, WebMvcConfigurer {

    private final EntityManager entityManager;

    public RepositoryConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/")
                .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
//        config.exposeIdsFor(Book.class);
//        config.exposeIdsFor(Category.class);

        config.exposeIdsFor(this.entityManager.getMetamodel().getEntities()
                .stream()
                .map(Type::getJavaType)
                .toArray(Class[]::new)
        );
    }
}
