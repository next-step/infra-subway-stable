package nextstep.subway.config;

import javax.servlet.Filter;
import nextstep.subway.support.WebVersion;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    public static final String PREFIX_STATIC_RESOURCES = "/resources";
    private static final int TOTAL_SECONDS_OF_ONE_YEAR = 60 * 60 * 24 * 365;

    private final WebVersion webVersion;

    public WebMvcConfig(WebVersion webVersion) {
        this.webVersion = webVersion;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(PREFIX_STATIC_RESOURCES + "/" + webVersion.getVersion() + "/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(TOTAL_SECONDS_OF_ONE_YEAR);
    }

}
