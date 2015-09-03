package br.com.elo7.probe.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * The type Application.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
@SpringBootApplication
@EnableSpringConfigured
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "br.com.elo7.probe")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
