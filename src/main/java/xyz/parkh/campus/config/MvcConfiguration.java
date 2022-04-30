package xyz.parkh.campus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("file:src/main/resources/static/", "file:src/main/resources/templates/"); // 파일 갱신 시 적용 O
//                .addResourceLocations("classpath:static/", "classpath:templates/"); // 파일 갱신 시 적용 X
    }
}
