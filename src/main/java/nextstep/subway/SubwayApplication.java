package nextstep.subway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.CacheManager;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@EnableJpaAuditing
@SpringBootApplication
public class SubwayApplication {

    private final CacheManager cacheManager;

    public SubwayApplication(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public static void main(String[] args) {
        SpringApplication.run(SubwayApplication.class, args);
    }

    @EventListener
    public void onApplicationEvent(ApplicationReadyEvent event) {
        cacheManager.getCacheNames()
                .parallelStream()
                .forEach(n -> cacheManager.getCache(n).clear());
    }
}
