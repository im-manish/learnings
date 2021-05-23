/*
 * Copyright (c) 2021. This Program is sole property of Manish Kumar written on 23/05/21, 4:33 PM.
 */

package com.manish.reactivespring.fluxandmonoplaygroud;

import org.junit.Test;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

/**
 * @author Manish
 */
public class FluxAndMonoBackpressureTest {

    @Test
    public void backPressureTest() {
        Flux<Integer> range = Flux.range(1, 10);
        StepVerifier.create(range.log())
                .expectSubscription()
                .thenRequest(1)
                .expectNext(1)
                .thenRequest(1)
                .expectNext(2)
                .thenCancel()
                .verify();
    }

    @Test
    public void backPressure() {
        Flux<Integer> range = Flux.range(1, 10).log();
        range.subscribe(integer -> System.out.println(integer),
                throwable -> System.err.println(throwable),
                () -> System.out.println("Done"),
                subscription -> subscription.request(3));
    }

    @Test
    public void backPressure_cancel() {
        Flux<Integer> range = Flux.range(1, 10).log();
        range.subscribe(integer -> System.out.println(integer),
                throwable -> System.err.println(throwable),
                () -> System.out.println("Done"),
                subscription -> subscription.cancel());
    }

    @Test
    public void backPressure_custom() {
        Flux<Integer> range = Flux.range(1, 10).log();
        range.subscribe(new BaseSubscriber<Integer>() {
            @Override
            protected void hookOnNext(Integer value) {
                request(1);
                System.out.println("value received is :" + value);
                if (value == 4) {
                    cancel();
                }
            }
        });
    }
}
