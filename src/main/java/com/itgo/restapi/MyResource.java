package com.itgo.restapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.itgo.db.contacts.entities.User;
import com.itgo.restapi.login.helper.Secured;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource
{

   /**
    * Method handling HTTP GET requests. The returned object will be sent to the
    * client as "text/plain" media type.
    *
    * @return String that will be returned as a text/plain response.
    */
   @Secured
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public User getIt()
   {
      System.out.println("aayo bhai");
      return new User();
   }
}
