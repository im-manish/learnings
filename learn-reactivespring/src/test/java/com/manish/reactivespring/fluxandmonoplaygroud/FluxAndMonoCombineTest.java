/*
 * Copyright (c) 2021. This Program is sole property of Manish Kumar written on 16/05/21, 7:06 PM.
 */

package com.manish.reactivespring.fluxandmonoplaygroud;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

/**
 * @author Manish
 */
public class FluxAndMonoCombineTest {

    @Test
    public void combineUsingMerge() {
        Flux<String> stringFlux = Flux.just("A", "B", "C");
        Flux<String> stringFlux2 = Flux.just("D", "E", "F");
        Flux<String> flux = Flux.merge(stringFlux, stringFlux2);
        StepVerifier.create(flux.log())
                .expectSubscription()
                .expectNext("A", "B", "C", "D", "E", "F")
                .verifyComplete();

    }

    @Test
    public void combineUsingMerge_withDelay() {
        Flux<String> stringFlux = Flux.just("A", "B", "C")
                .delayElements(Duration.ofSeconds(1));
        Flux<String> stringFlux2 = Flux.just("D", "E", "F")
                .delayElements(Duration.ofSeconds(1));
        Flux<String> merge = Flux.merge(stringFlux, stringFlux2);
        StepVerifier.create(merge.log())
                .expectSubscription()
                //.expectNext("A", "B", "C", "D", "E", "F") // because of duration order is not maintain
                .expectNextCount(6)
                .verifyComplete();

    }

    @Test
    public void combineUsingConcat() {
        Flux<String> stringFlux = Flux.just("A", "B", "C");
        Flux<String> stringFlux2 = Flux.just("D", "E", "F");
        Flux<String> merge = Flux.concat(stringFlux, stringFlux2);
        StepVerifier.create(merge.log())
                .expectSubscription()
                .expectNext("A", "B", "C", "D", "E", "F")
                .verifyComplete();

    }

    @Test
    public void combineUsingConcat_withDelay() {
        Flux<String> stringFlux = Flux.just("A", "B", "C")
                .delayElements(Duration.ofSeconds(1));
        Flux<String> stringFlux2 = Flux.just("D", "E", "F")
                .delayElements(Duration.ofSeconds(1));
        ;
        Flux<String> merge = Flux
                .concat(stringFlux, stringFlux2); // it maintain order but takes more time
        StepVerifier.create(merge.log())
                .expectSubscription()
                .expectNext("A", "B", "C", "D", "E", "F")
                .verifyComplete();

    }

    @Test
    public void combineUsingZip() {
        Flux<String> stringFlux = Flux.just("A", "B", "C");
        Flux<String> stringFlux2 = Flux.just("D", "E", "F");
        Flux<String> zip = Flux
                .zip(stringFlux, stringFlux2, this::combinedElement);// it maintain order but takes more time
        StepVerifier.create(zip.log())
                .expectSubscription()
                .expectNext("AD", "BE", "CF")
                .verifyComplete();

    }

    private String combinedElement(String t1, String t2) {
        return StringUtils.join(t1, t2);
    }

    @Test
    public void combineMonoUsingZipTest() {
        Mono<String> stringMono = Mono.just("Manish");
        Mono<String> stringMono1 = Mono.just("Kumar");
        Mono<String> zip = Mono.zip(stringMono, stringMono1, this::combinedElement);
        StepVerifier.create(zip.log())
                .expectSubscription()
                .expectNext("ManishKumar")
                .expectComplete();
    }

}
