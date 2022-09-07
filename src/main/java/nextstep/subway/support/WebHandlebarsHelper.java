package nextstep.subway.support;

import com.github.jknack.handlebars.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.allegro.tech.boot.autoconfigure.handlebars.HandlebarsHelper;

@HandlebarsHelper
public class WebHandlebarsHelper {

    private static final Logger logger = LoggerFactory.getLogger(WebHandlebarsHelper.class);

    private final WebVersion webVersion;

    public WebHandlebarsHelper(WebVersion webVersion) {
        this.webVersion = webVersion;
    }

    public String staticUrls(String path, Options options) {
        logger.debug("static url : {}", path);
        return String.format("/resources/%s%s", webVersion.getVersion(), path);
    }
}
