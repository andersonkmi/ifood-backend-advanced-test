package org.sharpsw.app

import org.scalatra._

class MainServlet extends ScalatraServlet {

  get("/") {
    views.html.hello()
  }

}
