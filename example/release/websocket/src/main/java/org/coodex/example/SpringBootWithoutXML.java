package org.coodex.example;

import org.coodex.concrete.core.intercept.ConcreteInterceptor;
import org.coodex.concrete.core.intercept.RBACInterceptor;
import org.coodex.concrete.core.token.TokenManager;
import org.coodex.concrete.core.token.local.LocalTokenManager;
import org.coodex.concrete.spring.ConcreteSpringConfiguration;
import org.coodex.concrete.spring.aspects.ConcreteAOPChain;
import org.coodex.concrete.support.websocket.CallerHackConfigurator;
import org.coodex.concrete.support.websocket.ConcreteWebSocketEndPoint;
import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.websocket.DeploymentException;
import javax.websocket.server.ServerContainer;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication //声明一个spring boot application，也就是说，这是一个spring boot框架定义中的微服务
@Configuration
@EnableAspectJAutoProxy //同 <aop:aspectj-autoproxy/>
@Import(ConcreteSpringConfiguration.class)// 同<bean class="org.coodex.concrete.spring.ConcreteSpringConfiguration"/>
@ImportResource("classpath:spring-data-env.xml")
public class SpringBootWithoutXML
        extends SpringBootServletInitializer {

    private List<ConcreteInterceptor> interceptors() {
        List<ConcreteInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new RBACInterceptor());//rbac 切片
        return interceptors;
    }


    // 同切片链的定义方式，参见 https://book.concrete.coodex.org/%E5%B7%A5%E5%85%B7%E9%93%BE/Aspects.html#切片链方式
    @Bean
    public ConcreteAOPChain aspects() {
        return new ConcreteAOPChain(interceptors());
    }


    // 同  <bean class="org.coodex.concrete.core.token.local.LocalTokenManager"/>
    @Bean
    public TokenManager getTokenManger() {
        return new LocalTokenManager();
    }

    @ServerEndpoint(value = "/WebSocket", configurator = CallerHackConfigurator.class)
    public static class ExampleWebSocketEndPoint extends ConcreteWebSocketEndPoint {

        public ExampleWebSocketEndPoint() {
            super();
            registerClasses(ExampleApi.class);
        }
    }

    @Bean
    public ServletRegistrationBean testServlet() {
        ServletContainer container = new ServletContainer();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(
                container, "/WebSocket"){
            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                servletContext.addListener(new ServletContextListener() {

                    @Override
                    public void contextInitialized(ServletContextEvent sce) {
                        final ServerContainer serverContainer = (ServerContainer) sce.getServletContext()
                                .getAttribute("javax.websocket.server.ServerContainer");

                        try {
                            serverContainer.addEndpoint(ExampleWebSocketEndPoint.class);
                        } catch (DeploymentException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void contextDestroyed(ServletContextEvent sce) {

                    }
                });
            }
        };
        registrationBean.setName("demo");
        registrationBean.setAsyncSupported(true);
        return registrationBean;
    }

    @Bean
    public ExampleApi getExampleApi() {
        return new ExampleImpl();
    }


    public static void main(String[] args) {
        // 设为前后端分离开发模式
//        System.setProperty("org.coodex.concrete.websocket.devMode", "true");
        SpringApplication.run(SpringBootWithoutXML.class, args);
    }

}
