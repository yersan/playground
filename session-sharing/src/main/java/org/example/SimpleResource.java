package org.example;

import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * @author <a href="mailto:yborgess@redhat.com">Yeray Borges</a>
 */
@Path("/sessions")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
public class SimpleResource {
    private static final JsonBuilderFactory bf = Json.createBuilderFactory(null);

    @GET
    @Path("/init")
    public JsonObject initSession(@Context HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.setAttribute("TEST", 0);
        String hostname = System.getenv("HOSTNAME") != null ?  System.getenv("HOSTNAME") : "UNKNOWN";

        return bf.createObjectBuilder()
                    .add("hostname", hostname)
                    .add("session-id", session.getId())
                    .add("value", 0)
                .build();
    }

    @GET
    @Path("/info")
    public JsonObject info(@Context HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        String hostname = System.getenv("HOSTNAME") != null ?  System.getenv("HOSTNAME") : "UNKNOWN";
        Integer value = session.getAttribute("TEST") != null ? (Integer) session.getAttribute("TEST") : 0 ;


        return bf.createObjectBuilder()
                .add("hostname", hostname)
                .add("session-id", session.getId())
                .add("value", value)
                .build();
    }

    @GET
    @Path("/increment")
    public JsonObject increment(@Context HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        String hostname = System.getenv("HOSTNAME") != null ?  System.getenv("HOSTNAME") : "UNKNOWN";
        Integer value = (Integer) session.getAttribute("TEST");
        session.setAttribute("TEST", ++value);

        return bf.createObjectBuilder()
                .add("hostname", hostname)
                .add("session-id", session.getId())
                .add("value", value)
                .build();
    }
}
