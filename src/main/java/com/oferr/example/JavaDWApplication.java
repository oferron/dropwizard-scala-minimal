package com.oferr.example;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * Created with IntelliJ IDEA.
 * User: oferr
 * Date: 6/23/16
 * Time: 13:49
 */
public class JavaDWApplication extends Application<Configuration> {

    public static void main(String[] args) throws Exception {
        new JavaDWApplication().run(args);
    }

    public void run(Configuration configuration, Environment environment) throws Exception {
        environment.jersey().register(new TestQuery());
    }

    @Path("/test")
    public static class TestQuery {

        @GET
        @Produces("application/json")
        public String hello(@QueryParam("name") String name) {
            return String.format("Hello %s", name);
        }

    }
}
