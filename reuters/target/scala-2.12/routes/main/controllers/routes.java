// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/rivigo/Documents/workspace/open-source/reutersDataset/reuters/conf/routes
// @DATE:Wed Jan 09 19:47:39 IST 2019

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
