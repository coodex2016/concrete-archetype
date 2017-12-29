package org.coodex.example;

import org.coodex.concrete.apitools.API;
import org.coodex.concrete.apitools.jaxrs.angular.AngularCodeRender;

import java.io.IOException;

public class AngularSDKGenerator {

    public static void main(String [] args) throws IOException {

        String angularProject = "D:\\Projects\\IntelliJ\\concrete-archetype\\example\\release\\angular-jaxrs";
        API.generate(AngularCodeRender.RENDER_NAME,
                angularProject + "/src",
                ExampleApi.class.getPackage().getName());
    }
}
