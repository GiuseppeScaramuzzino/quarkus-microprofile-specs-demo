package org.gs;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/singlesearch")
@RegisterRestClient
public interface TvMazeClient {

    @GET
    @Path("/shows")
    @Produces(MediaType.APPLICATION_JSON)
    TvSeries shows(@QueryParam("q") String title);
}

