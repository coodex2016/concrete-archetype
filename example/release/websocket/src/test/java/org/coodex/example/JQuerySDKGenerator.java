package org.coodex.example;

import org.coodex.concrete.apitools.API;
import org.coodex.concrete.apitools.jaxrs.jquery.JQueryPromisesCodeRender;
import org.coodex.concrete.apitools.websocket.jquery.JQueryWebSocketCodeRender;

import java.io.IOException;

public class JQuerySDKGenerator {

    public static void main(String [] args) throws IOException {
        String projectPath = "path/to/your/project/root";
        API.generate(JQueryWebSocketCodeRender.RENDER_NAME,
                projectPath + "/src/main/resources/static/jquery",
                ExampleApi.class.getPackage().getName());
    }
}
