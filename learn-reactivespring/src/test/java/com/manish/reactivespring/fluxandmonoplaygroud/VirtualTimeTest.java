/*
 * Copyright (c) 2021. This Program is sole property of Manish Kumar written on 23/05/21, 5:30 PM.
 */

package com.manish.reactivespring.fluxandmonoplaygroud;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.scheduler.VirtualTimeScheduler;

import java.time.Duration;

/**
 * \
 *
 * @author Manish
 */
public class VirtualTimeTest {

    @Test
    public void testWithoutVirtualTest() {
        Flux<Long> log = Flux.interval(Duration.ofSeconds(1))
                .take(3)
                .log();
        StepVerifier.create(log)
                .expectSubscription()
                .expectNext(0l, 1l, 2l)
                .verifyComplete();


    }

    @Test
    public void testWithVirtualTest() {

        VirtualTimeScheduler.getOrSet();

        Flux<Long> log = Flux.interval(Duration.ofSeconds(1))
                .take(3)
                .log();
        StepVerifier.withVirtualTime(() -> log)
                .expectSubscription()
                .thenAwait(Duration.ofSeconds(3))
                .expectNext(0l, 1l, 2l)
                .verifyComplete();


    }

    @Test
    public void combineUsingZipWithVirtualTime() {
        VirtualTimeScheduler.getOrSet();
        Flux<String> stringFlux = Flux.just("A", "B", "C")
                .delayElements(Duration.ofSeconds(1));
        ;
        Flux<String> stringFlux2 = Flux.just("D", "E", "F")
                .delayElements(Duration.ofSeconds(1));
        ;
        Flux<String> zip = Flux
                .zip(stringFlux, stringFlux2, this::combinedElement);// it maintain order but takes more time
        StepVerifier.withVirtualTime(() -> zip.log())
                .expectSubscription()
                .thenAwait(Duration.ofSeconds(3))
                .expectNext("AD", "BE", "CF")
                .verifyComplete();

    }

    private String combinedElement(String t1, String t2) {
        return StringUtils.join(t1, t2);
    }

}
