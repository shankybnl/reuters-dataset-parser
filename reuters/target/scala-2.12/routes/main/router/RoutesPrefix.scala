// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/rivigo/Documents/workspace/open-source/reutersDataset/reuters/conf/routes
// @DATE:Wed Jan 09 19:47:39 IST 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
