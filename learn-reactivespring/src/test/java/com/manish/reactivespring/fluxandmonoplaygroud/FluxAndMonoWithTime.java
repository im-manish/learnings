/*
 * Copyright (c) 2021. This Program is sole property of Manish Kumar written on 17/05/21, 4:22 PM.
 */

package com.manish.reactivespring.fluxandmonoplaygroud;

import lombok.SneakyThrows;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

/**
 * @author Manish
 */
public class FluxAndMonoWithTime {

    @SneakyThrows
    @Test
    public void infiniteFlux() {
        Flux<Long> interval = Flux.interval(Duration.ofMillis(200))
                .log();
        interval.subscribe(System.out::println);
        Thread.sleep(2000); // If we not put this we will not see any output because of asynchronous nature of Flux
    }

    @Test
    public void finiteFluxTest() {
        Flux<Long> interval = Flux.interval(Duration.ofMillis(100))
                .take(3) // it will take 3 elements from flux
                .log();
        StepVerifier.create(interval)
                .expectNext(0L, 1L, 2L)
                .verifyComplete();
    }

    @Test
    public void finiteFluxTest_withMap() {
        Flux<Integer> interval = Flux.interval(Duration.ofMillis(100))
                .map(Math::toIntExact)
                .take(3) // it will take 3 elements from flux
                .log();
        StepVerifier.create(interval)
                .expectNext(0, 1, 2)
                .verifyComplete();
    }
}
