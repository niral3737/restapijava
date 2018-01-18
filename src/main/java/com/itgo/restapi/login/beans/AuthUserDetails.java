package com.itgo.restapi.login.beans;

import java.security.Principal;

// AUth user
public class AuthUserDetails implements Principal
{
   private String email;

   public AuthUserDetails(
         String email)
   {
      this.email = email;
   }

   @Override
   public String getName()
   {
      return email;
   }

}
