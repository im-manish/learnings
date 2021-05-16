/*
 * Copyright (c) 2021. This Program is sole property of Manish Kumar written on 16/05/21, 3:14 PM.
 */

package com.manish.reactivespring.fluxandmonoplaygroud;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class FluxAndMonoFactoryTest {

    List<String> nameList = Arrays.asList("Manish", "Pravin", "Pratyus", "Rajiv");

    @Test
    public void fluxUsingIterable() {
        Flux<String> stringFlux = Flux.fromIterable(nameList).log();
        StepVerifier.create(stringFlux)
                .expectNext("Manish", "Pravin", "Pratyus", "Rajiv")
                .verifyComplete();
    }

    @Test
    public void fluxUsingArray() {
        String[] nameArray = nameList.toArray(String[]::new);
        Flux<String> stringFlux = Flux.fromArray(nameArray).log();
        StepVerifier.create(stringFlux)
                .expectNext("Manish", "Pravin", "Pratyus", "Rajiv")
                .verifyComplete();
    }

    @Test
    public void fluxUsingStream() {
        Flux<String> stringFlux = Flux.fromStream(nameList.stream()).log();
        StepVerifier.create(stringFlux)
                .expectNext("Manish", "Pravin", "Pratyus", "Rajiv")
                .verifyComplete();
    }

    @Test
    public void fluxUsingRange() {
        Flux<Integer> integerFlux = Flux.range(1, 5).log();
        StepVerifier.create(integerFlux)
                .expectNext(1, 2, 3, 4, 5)
                .verifyComplete();

    }


    @Test
    public void monoUsingJustOrEmpty() {
        Mono<String> objectMono = Mono.justOrEmpty(null);
        StepVerifier.create(objectMono).verifyComplete();
    }

    @Test
    public void monoUsingSupplier() {
        Supplier<String> stringSupplier = () -> "Manish";
        Mono<String> stringMono = Mono.fromSupplier(stringSupplier);
        StepVerifier.create(stringMono)
                .expectNext("Manish")
                .verifyComplete();
    }
}
