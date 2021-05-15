/*
 * Copyright (c) 2021. This Program is sole property of Manish Kumar written on 15/05/21, 4:47 PM.
 */

package com.manish.reactivespring.fluxandmonoplaygroud;

import org.junit.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class MonoTest {

    @Test
    public void monoTest() {
        Mono<String> stringMono = Mono.just("Manish")
                .log();
        stringMono.subscribe(System.out::println);
    }

    @Test
    public void monoTest_value() {
        Mono<String> stringMono = Mono.just("Manish")
                .log();
        StepVerifier.create(stringMono)
                .expectNext("Manish")
                .verifyComplete();
    }

}
