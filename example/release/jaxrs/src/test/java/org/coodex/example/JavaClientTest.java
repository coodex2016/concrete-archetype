package org.coodex.example;

import org.coodex.concrete.jaxrs.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaClientTest {

    private final static Logger log = LoggerFactory.getLogger(JavaClientTest.class);


    public static void main(String [] args){
        ExampleApi example = Client.getInstance(ExampleApi.class, "http://localhost:8080/jaxrs");
        log.debug("{} + {} = {}", 1, 2, example.add(1,2));
        try{
            log.debug("{} + {} = {}", 13, 2, example.add(13,2));
        }catch (Throwable th){
            log.error(th.getLocalizedMessage(), th);
        }
    }
}
