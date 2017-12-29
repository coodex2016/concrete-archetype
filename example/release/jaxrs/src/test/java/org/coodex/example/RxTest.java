package org.coodex.example;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.coodex.concrete.rx.RXClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.org.coodex.example.ExampleApi_RX;

public class RxTest {

    private final static Logger log = LoggerFactory.getLogger(RxTest.class);

    public static void main(String[] args) {
        ExampleApi_RX example = RXClient.getInstance(ExampleApi_RX.class, "http://localhost:8080/jaxrs");
        example.add(1, 2).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                log.debug("1 + 2 = {}", integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
