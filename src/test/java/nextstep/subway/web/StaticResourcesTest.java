package nextstep.subway.web;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.subway.support.WebVersion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.CacheControl;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StaticResourcesTest {

    private static final Logger logger = LoggerFactory.getLogger(StaticResourcesTest.class);

    @Autowired
    private WebTestClient client;

    @Autowired
    private WebVersion version;

    @ParameterizedTest
    @ValueSource(strings = {"/js/main.js", "/js/test.js"})
    void getJsFileTest(String uri) {
        EntityExchangeResult<String> response = client
                .get()
                .uri(uri)
                .exchange()
                .expectStatus()
                .isOk()
                .expectHeader()
                .cacheControl(
                        CacheControl.noCache()
                                .cachePrivate()
                )
                .expectBody(String.class)
                .returnResult();

        logger.debug("body : {}", response.getResponseBody());

        String etag = response.getResponseHeaders()
                .getETag();

        client.get()
                .uri(uri)
                .header("If-None-Match", etag)
                .exchange()
                .expectStatus()
                .isNotModified();
    }

    @Test
    void stations() {
        EntityExchangeResult<String> response = client
                .get()
                .uri("/stations")
                .exchange()
                .expectStatus()
                .isOk()
                .expectHeader()
                .cacheControl(CacheControl.empty())
                .expectBody(String.class)
                .returnResult();

        String etag = response
                .getResponseHeaders()
                .getETag();

        assertThat(etag).isNull();
    }
}
