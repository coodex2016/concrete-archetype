package org.coodex.example;

import org.coodex.concrete.apitools.API;
import org.coodex.concrete.apitools.rx.ReactiveStreamsRender;

import java.io.IOException;

public class RXGenerator {

    public static void main(String [] args) throws IOException {
        String projectPath = "path/to/your/project/root";
        API.generate(ReactiveStreamsRender.RENDER_NAME,
                projectPath + "/src/test/java",
                ExampleApi.class.getPackage().getName());
    }
}
