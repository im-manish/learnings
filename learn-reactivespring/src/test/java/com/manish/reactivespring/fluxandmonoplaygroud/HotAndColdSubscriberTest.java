/*
 * Copyright (c) 2021. This Program is sole property of Manish Kumar written on 23/05/21, 5:09 PM.
 */

package com.manish.reactivespring.fluxandmonoplaygroud;

import lombok.SneakyThrows;
import org.junit.Test;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @author Manish
 */
public class HotAndColdSubscriberTest {

    @SneakyThrows
    @Test
    public void coldSubscriberTest() {
        Flux<String> stringFlux = Flux.just("A", "B", "C", "D", "E", "F")
                .delayElements(Duration.ofSeconds(1));
        stringFlux.subscribe(s -> System.out
                .println("Subscriber 1 :" + s)); // when new subscriber attached it emit value from beginning
        Thread.sleep(2000);
        stringFlux.subscribe(s -> System.out
                .println("Subscriber 2 :" + s)); // when new subscriber attached it emit value from beginning
        Thread.sleep(4000);

    }

    @SneakyThrows
    @Test
    public void hotSubscriberTest() {
        Flux<String> stringFlux = Flux.just("A", "B", "C", "D", "E", "F")
                .delayElements(Duration.ofSeconds(1));

        ConnectableFlux<String> connectableFlux = stringFlux.publish();
        connectableFlux.connect();

        connectableFlux.subscribe(s -> System.out.println("Subscriber 1 :" + s));
        Thread.sleep(2000);
        connectableFlux.subscribe(s -> System.out
                .println("Subscriber 2 :" + s)); // when new subscriber attached with connectable flux it emit value from where it start not from beginning
        Thread.sleep(4000);

    }

}
