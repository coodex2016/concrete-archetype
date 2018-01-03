package org.coodex.example;

import org.coodex.concrete.apitools.API;
import org.coodex.concrete.apitools.jaxrs.angular.AngularCodeRenderV2;

import java.io.IOException;

public class AngularSDKGenerator {

    public static void main(String [] args) throws IOException {

        String angularProject = "path/to/your/project/root";
        API.generate(AngularCodeRenderV2.RENDER_NAME,
                angularProject + "/src",
                ExampleApi.class.getPackage().getName());
    }
}
