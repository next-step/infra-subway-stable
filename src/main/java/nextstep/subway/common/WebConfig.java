package nextstep.subway.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public static final int CACHE_MAX_AGE_DAYS = 365;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        CacheControl cacheControl = CacheControl.maxAge(CACHE_MAX_AGE_DAYS, TimeUnit.DAYS);

        registry.addResourceHandler("/resources/**")
            .addResourceLocations("classpath:/static/")
            .setCacheControl(cacheControl);
    }

}
