package com.itgo.restapi.login.beans;

public class AuthResponse
{
   private String token;
   private long userId;

   public String getToken()
   {
      return token;
   }

   public void setToken(String token)
   {
      this.token = token;
   }

   public long getUserId()
   {
      return userId;
   }

   public void setUserId(long userId)
   {
      this.userId = userId;
   }

   @Override
   public String toString()
   {
      return "AuthResponse [token=" + token + ", userId=" + userId + "]";
   }
}
