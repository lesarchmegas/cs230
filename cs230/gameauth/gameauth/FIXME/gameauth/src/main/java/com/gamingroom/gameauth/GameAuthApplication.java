package com.gamingroom.gameauth;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import javax.ws.rs.client.Client;

import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gamingroom.gameauth.auth.GameAuthenticator;
import com.gamingroom.gameauth.auth.GameAuthorizer;
import com.gamingroom.gameauth.auth.GameUser;

import com.gamingroom.gameauth.controller.GameUserRESTController;
import com.gamingroom.gameauth.controller.RESTClientController;

import com.gamingroom.gameauth.healthcheck.AppHealthCheck;
import com.gamingroom.gameauth.healthcheck.HealthCheckController;

public class GameAuthApplication extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameAuthApplication.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
        // No special initialization required for now
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");

        // Register GameUserRESTController with Validator for validation support
        e.jersey().register(new GameUserRESTController(e.getValidator()));

        // Create Jersey client for making REST API calls
        Client client = new JerseyClientBuilder(e).build("DemoRESTClient");

        // Register RESTClientController and provide it the Jersey client
        e.jersey().register(new RESTClientController(client));

        // Register application health check(s)
        e.healthChecks().register("APIHealthCheck", new AppHealthCheck(client));
        e.jersey().register(new HealthCheckController(e.healthChecks()));

        // Setup Basic Authentication and Role-based Authorization
        e.jersey().register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<GameUser>()
            .setAuthenticator(new GameAuthenticator())
            .setAuthorizer(new GameAuthorizer())
            .setRealm("App Security")
            .buildAuthFilter()));

        // Support injecting authenticated GameUser instances into resource methods
        e.jersey().register(new AuthValueFactoryProvider.Binder<>(GameUser.class));

        // Enable support for @RolesAllowed annotations
        e.jersey().register(RolesAllowedDynamicFeature.class);
    }

    public static void main(String[] args) throws Exception {
        new GameAuthApplication().run(args);
    }
}
