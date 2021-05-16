/*
 * Copyright (c) 2021. This Program is sole property of Manish Kumar written on 16/05/21, 3:33 PM.
 */

package com.manish.reactivespring.fluxandmonoplaygroud;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

/**
 * @author Manish
 */
public class FluxAndMonoFilterTest {
    List<String> nameList = Arrays.asList("Pravin", "Manish", "Pratyush", "Rajiv");

    @Test
    public void filterTest() {
        Flux<String> stringFlux = Flux.fromIterable(nameList)
                .filter(name -> name.startsWith("M"))
                .log();
        StepVerifier.create(stringFlux)
                //.expectNext("Pravin")
                .expectNext("Manish")
                .verifyComplete();
    }

    @Test
    public void filterLengthTest() {
        Flux<String> stringFlux = Flux.fromIterable(nameList)
                .filter(name -> StringUtils.length(name) > 6)
                .log();
        StepVerifier.create(stringFlux)
                //.expectNext("Pravin")
                .expectNext("Pratyush")
                .verifyComplete();
    }


}
