package nextstep.subway.support;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class WebVersion {

    private static final String DEFAULT_DATE_TIME_FORMAT = "yyyyMMddHHmmss";
    private String version;

    @PostConstruct
    public void init() {
        version = nowVersion();
    }

    public String getVersion() {
        return version;
    }

    private static String nowVersion() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT);
        return LocalDateTime.now().format(formatter);
    }
}
