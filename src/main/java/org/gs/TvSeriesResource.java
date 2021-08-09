package org.gs;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/tvseries")
@Tag(name = "TvSeriesResource", description = "REST TvSeriesResource")
@SecurityRequirement(name = "bearerAuth")
public class TvSeriesResource {

  @Inject @RestClient TvMazeClient client;

  @Inject TvSeries tvSeriesConfig;

  @GET
  @Path("{title}")
  @RolesAllowed({"Admin", "User"})
  @Produces(MediaType.APPLICATION_JSON)
  @Fallback(fallbackMethod = "getTvSeriesFallback")
  @Retry(maxRetries = 5)
  @Operation(summary = "getTvSeries", description = "Get a specific tv series by title")
  @APIResponse(
      responseCode = "200",
      description = "TvSeries object",
      content =
          @Content(
              mediaType = "application/json",
              schema = @Schema(implementation = TvSeries.class)))
  public Response getTvSeries(
      @Parameter(
              description = "Title of tv series",
              required = true,
              example = "Lupin",
              schema = @Schema(implementation = String.class))
          @PathParam("title")
          String title) {
    TvSeries shows = client.shows(title);
    return Response.ok(shows).build();
  }

  private Response getTvSeriesFallback(String title) {
    return Response.ok(tvSeriesConfig).build();
  }
}
