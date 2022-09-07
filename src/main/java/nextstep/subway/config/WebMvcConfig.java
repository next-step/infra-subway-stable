package nextstep.subway.config;

import javax.servlet.Filter;
import nextstep.subway.support.WebVersion;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    public static final String PREFIX_STATIC_RESOURCES = "/resources";

    private final WebVersion webVersion;

    public WebMvcConfig(WebVersion webVersion) {
        this.webVersion = webVersion;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        CacheControl cacheControl = CacheControl.noCache()
                .cachePrivate();
        registry.addResourceHandler(PREFIX_STATIC_RESOURCES + "/" + webVersion.getVersion() + "/**")
                .addResourceLocations("classpath:/static/")
                .setCacheControl(cacheControl);
    }

}
