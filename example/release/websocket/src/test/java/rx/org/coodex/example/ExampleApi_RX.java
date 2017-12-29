package rx.org.coodex.example;

import org.coodex.concrete.rx.ReactiveExtensionFor;

import io.reactivex.Observable;

import org.coodex.example.ExampleApi;

/**
 * Create by concrete-api-tools.
 */
@ReactiveExtensionFor(ExampleApi.class)
public interface ExampleApi_RX {

    Observable<String> getRandomVeh(String id);

    Observable<Integer> add(int x1, int x2);

    Observable<String> aclTest();


}