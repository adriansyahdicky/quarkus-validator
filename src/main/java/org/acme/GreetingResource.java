package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.service.EbpValidatorService;
import org.acme.service.TObjectService;

import java.io.IOException;
import java.net.URISyntaxException;

@Path("/hello")
public class GreetingResource {

    @Inject
    TObjectService tObjectService;

    @Inject
    EbpValidatorService ebpValidatorService;

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response hello() throws URISyntaxException, IOException {
//        return Response.status(200).entity(tObjectService.getAllObject()).build();
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() throws URISyntaxException, IOException {
        return Response.status(200).entity(ebpValidatorService.validate()).build();
    }
}
