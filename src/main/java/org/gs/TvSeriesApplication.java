package org.gs;

import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.security.SecuritySchemes;

import javax.ws.rs.core.Application;

@SecuritySchemes(
    @SecurityScheme(
        securitySchemeName = "bearerAuth",
        bearerFormat = "JWT",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer"))
public class TvSeriesApplication extends Application {}
