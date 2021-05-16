/*
 * Copyright (c) 2021. This Program is sole property of Manish Kumar written on 16/05/21, 3:41 PM.
 */

package com.manish.reactivespring.fluxandmonoplaygroud;

import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

import static reactor.core.scheduler.Schedulers.parallel;

/**
 * @author Manish
 */
public class FluxAndMonoTransformTest {

    List<String> nameList = Arrays.asList("Manish", "Pravin", "Pratyus", "Rajiv");

    @Test
    public void transformUsingMap() {
        Flux<String> stringFlux = Flux.fromIterable(nameList)
                .map(name -> StringUtils.upperCase(name))
                .log();
        StepVerifier.create(stringFlux)
                .expectNext("MANISH", "PRAVIN", "PRATYUS", "RAJIV")
                .verifyComplete();
    }

    @Test
    public void transformUsingMap_filter() {
        Flux<String> stringFlux = Flux.fromIterable(nameList)
                .filter(name -> name.startsWith("M"))
                .map(name -> StringUtils.upperCase(name))
                .log();
        StepVerifier.create(stringFlux)
                .expectNext("MANISH")
                .verifyComplete();
    }

    @Test
    public void transformUsingFlatMap() {
        Flux<String> stringFlux = Flux.fromIterable(Arrays.asList("A", "B", "C"))
                .flatMap(this::getFluxWithNewValue) // db or eexternal service that return a flux -> Flux<String>
                .log();
        StepVerifier.create(stringFlux)
                .expectNextCount(6) // each value in stringFlux return with new value added in
                .verifyComplete();
    }

    private Flux<String> getFluxWithNewValue(String string) {
        return Flux.fromIterable(convertToList(string));
    }

    @SneakyThrows
    private List<String> convertToList(String string) {
        Thread.sleep(1000);
        return Arrays.asList(string, "New Value");
    }

    @Test
    public void transformUsingFlatMap_parallel() {
        Flux<String> stringFlux = Flux
                .fromIterable(Arrays.asList("A", "B", "C", "D", "E", "F"))
                .window(2) // Flux<Flux<String> -> (A,B), (C,D), (E,F)
                .flatMap((flux) -> flux.map(this::convertToList).subscribeOn(parallel()))
                .flatMap(s -> Flux.fromIterable(s))
                .log();
        StepVerifier.create(stringFlux)
                .expectNextCount(12) // each value in stringFlux return with new value added in
                .verifyComplete();
    }

    @Test
    public void transformUsingFlatMap_parallel_maintain_order() {
        Flux<String> stringFlux = Flux
                .fromIterable(Arrays.asList("A", "B", "C", "D", "E", "F"))
                .window(2) // Flux<Flux<String> -> (A,B), (C,D), (E,F)
                .flatMapSequential((flux) -> flux.map(this::convertToList)
                        .subscribeOn(parallel()))
                .flatMap(s -> Flux.fromIterable(s))
                .log();
        StepVerifier.create(stringFlux)
                .expectNextCount(12) // each value in stringFlux return with new value added in
                .verifyComplete();
    }

}
