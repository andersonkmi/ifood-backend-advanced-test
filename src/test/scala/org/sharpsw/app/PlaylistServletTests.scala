package org.sharpsw.app

import org.scalatest.FunSuiteLike
import org.scalatra.test.scalatest._

class PlaylistServletTests extends ScalatraSuite with FunSuiteLike {

  addServlet(classOf[PlaylistServlet], "/*")

  test("GET /v1/playlist/city on PlaylistServlet should return status 200"){
    get("/v1/playlist/city") {
      status should equal (200)
    }
  }

}
