package com.itgo.restapi.login.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.itgo.restapi.login.beans.AuthResponse;
import com.itgo.restapi.login.beans.Credentials;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LoginResource
{

   @POST
   public Response authenticateUser(Credentials creds)
   {
      try
      {
         long userId = authenticate(creds.getEmail(), creds.getPassword());

         String token = issueToken(creds.getEmail());
         AuthResponse response = new AuthResponse();
         response.setToken(token);
         response.setUserId(userId);

         return Response.ok(response).build();
      }
      catch (Exception exc)
      {
         return Response.status(Response.Status.FORBIDDEN).build();
      }
   }

   private String issueToken(String email)
   {
      return "token";
   }

   private long authenticate(String email, String password)
   {
      //TODO implement this
      return 0;
   }
}
