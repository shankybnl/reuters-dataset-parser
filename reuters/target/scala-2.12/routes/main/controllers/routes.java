// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/rivigo/Documents/workspace/open-source/reuters/conf/routes
// @DATE:Sat Dec 22 00:52:05 IST 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseReutersController ReutersController = new controllers.ReverseReutersController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseReutersController ReutersController = new controllers.javascript.ReverseReutersController(RoutesPrefix.byNamePrefix());
  }

}
