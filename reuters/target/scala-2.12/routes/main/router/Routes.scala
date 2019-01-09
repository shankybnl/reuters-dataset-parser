// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/rivigo/Documents/workspace/open-source/reutersDataset/reuters/conf/routes
// @DATE:Wed Jan 09 19:47:39 IST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_0: controllers.HomeController,
  // @LINE:7
  ReutersController_2: controllers.ReutersController,
  // @LINE:13
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:7
    ReutersController_2: controllers.ReutersController,
    // @LINE:13
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_0, ReutersController_2, Assets_1, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, ReutersController_2, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getContent""", """controllers.ReutersController.getContent"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """search""", """controllers.ReutersController.searchContent(match:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getTopic""", """controllers.ReutersController.getTopic(topic:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_ReutersController_getContent1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getContent")))
  )
  private[this] lazy val controllers_ReutersController_getContent1_invoker = createInvoker(
    ReutersController_2.getContent,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ReutersController",
      "getContent",
      Nil,
      "GET",
      this.prefix + """getContent""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_ReutersController_searchContent2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("search")))
  )
  private[this] lazy val controllers_ReutersController_searchContent2_invoker = createInvoker(
    ReutersController_2.searchContent(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ReutersController",
      "searchContent",
      Seq(classOf[String]),
      "GET",
      this.prefix + """search""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_ReutersController_getTopic3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getTopic")))
  )
  private[this] lazy val controllers_ReutersController_getTopic3_invoker = createInvoker(
    ReutersController_2.getTopic(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ReutersController",
      "getTopic",
      Seq(classOf[String]),
      "GET",
      this.prefix + """getTopic""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Assets_versioned4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned4_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:7
    case controllers_ReutersController_getContent1_route(params@_) =>
      call { 
        controllers_ReutersController_getContent1_invoker.call(ReutersController_2.getContent)
      }
  
    // @LINE:8
    case controllers_ReutersController_searchContent2_route(params@_) =>
      call(params.fromQuery[String]("match", None)) { (_pf_escape_match) =>
        controllers_ReutersController_searchContent2_invoker.call(ReutersController_2.searchContent(_pf_escape_match))
      }
  
    // @LINE:9
    case controllers_ReutersController_getTopic3_route(params@_) =>
      call(params.fromQuery[String]("topic", None)) { (topic) =>
        controllers_ReutersController_getTopic3_invoker.call(ReutersController_2.getTopic(topic))
      }
  
    // @LINE:13
    case controllers_Assets_versioned4_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned4_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
