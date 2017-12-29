package org.coodex.example;

import org.coodex.concrete.apitools.API;
import org.coodex.concrete.apitools.jaxrs.angular.AngularCodeRender;
import org.coodex.concrete.apitools.websocket.angular.AngularWebSocketCodeRender;

import java.io.IOException;

public class AngularSDKGenerator {

    public static void main(String [] args) throws IOException {

        String angularProject = "D:\\Projects\\IntelliJ\\concrete-archetype\\example\\release\\angular-jaxrs";
        API.generate(AngularWebSocketCodeRender.RENDER_NAME+".websocket",
                angularProject + "/src",
                ExampleApi.class.getPackage().getName());
    }
}
