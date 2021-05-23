/*
 * Copyright (c) 2021. This Program is sole property of Manish Kumar written on 17/05/21, 3:02 PM.
 */

package com.manish.reactivespring.fluxandmonoplaygroud;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.util.retry.Retry;

import java.time.Duration;

/**
 * @author Manish
 */
@Slf4j
public class FluxAndMonoErrorTest {

    @Test
    public void fluxErrorHandling() {
        Flux<String> stringFlux = Flux.just("Manish", "Kumar", "Pawan")
                .concatWith(Flux.error(new RuntimeException("Error Occurs")))

                .onErrorResume(throwable -> { // this block execute whenever there is an error and you want to resume it
                    log.error(throwable.getMessage());
                    return Flux.just("On Error resume");
                })
                .concatWith(Flux.just("After Error"))
                .log();
        StepVerifier.create(stringFlux)
                .expectNext("Manish", "Kumar", "Pawan")
                .expectNext("On Error resume")
                .expectNext("After Error")
                //.expectError(RuntimeException.class)
                //.verify();
                .verifyComplete();


    }

    @Test
    public void fluxErrorHandling_onErrorReturn() {
        Flux<String> stringFlux = Flux.just("Manish", "Kumar", "Pawan")
                .concatWith(Flux.error(new RuntimeException("Error Occurs")))
                .onErrorReturn("After Error return this value")
                .log();
        StepVerifier.create(stringFlux)
                .expectNext("Manish", "Kumar", "Pawan")
                .expectNext("After Error return this value")
                //.expectError(RuntimeException.class)
                //.verify();
                .verifyComplete();
    }

    @Test
    public void fluxErrorHandling_onErrorMap() {
        Flux<String> stringFlux = Flux.just("Manish", "Kumar", "Pawan")
                .concatWith(Flux.error(new RuntimeException("Error Occurs")))
                .onErrorMap(throwable -> new CustomException(throwable))
                .log();
        StepVerifier.create(stringFlux)
                .expectNext("Manish", "Kumar", "Pawan")
                .expectError(CustomException.class)
                .verify();
        //.verifyComplete();
    }

    @Test
    public void fluxErrorHandling_onErrorMap_withRetry() {
        Flux<String> stringFlux = Flux.just("Manish", "Kumar", "Pawan")
                .concatWith(Flux.error(new RuntimeException("Error Occurs")))
                .onErrorMap(throwable -> new CustomException(throwable))
                .retry(1) // in can of error it will retry number of times
                .log();
        StepVerifier.create(stringFlux)
                .expectNext("Manish", "Kumar", "Pawan")
                .expectNext("Manish", "Kumar", "Pawan")
                .expectError(CustomException.class)
                .verify();
        //.verifyComplete();
    }

    @Test
    public void fluxErrorHandling_onErrorMap_withRetryBackoff() {
        Flux<String> stringFlux = Flux.just("Manish", "Kumar", "Pawan")
                .concatWith(Flux.error(new RuntimeException("Error Occurs")))
                .onErrorMap(throwable -> new CustomException(throwable))
                .retryWhen(Retry.backoff(1, Duration.ofSeconds(5)))
                .log();
        StepVerifier.create(stringFlux)
                .expectNext("Manish", "Kumar", "Pawan")
                .expectNext("Manish", "Kumar", "Pawan")
                .expectError(IllegalStateException.class)
                .verify();
        //.verifyComplete();
    }
}
