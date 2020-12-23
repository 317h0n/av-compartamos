package com.avantica.compartamos;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.avantica.compartamos.service.BancoResource;

public class Parte02  extends Application {
	 
	   private Set<Object> singletons = new HashSet<Object>();
	   private Set<Class<?>> empty = new HashSet<Class<?>>();
	 
	   public Parte02() {
	      singletons.add(new BancoResource());
	   }
	 
	   @Override
	   public Set<Class<?>> getClasses() {
	      return empty;
	   }
	 
	   @Override
	   public Set<Object> getSingletons() {
	      return singletons;
	   }

}
