package com.itgo.restapi.login.helper;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter
{
   private static final String REALM = "example";
   private static final String AUTHENTICATION_SCHEME = "Bearer";

   @Override
   public void filter(ContainerRequestContext context) throws IOException
   {
      String authHeader = context.getHeaderString(HttpHeaders.AUTHORIZATION);

      if (!isTokenBasedAuthentication(authHeader))
      {
         abortWithUnauthorized(context);
         return;
      }

      String token = authHeader.substring(AUTHENTICATION_SCHEME.length()).trim();

      try
      {
         validateToken(token);
      }
      catch (Exception exc)
      {
         abortWithUnauthorized(context);
      }
   }

   private void validateToken(String token)
   {
      // TODO Auto-generated method stub

   }

   private void abortWithUnauthorized(ContainerRequestContext context)
   {
      context.abortWith(Response.status(Status.UNAUTHORIZED)
            .header(HttpHeaders.WWW_AUTHENTICATE, AUTHENTICATION_SCHEME + " realm= \"" + REALM + "\"").build());
   }

   private boolean isTokenBasedAuthentication(String authHeader)
   {
      return authHeader != null && authHeader.toLowerCase().startsWith(AUTHENTICATION_SCHEME.toLowerCase() + " ");
   }

}
