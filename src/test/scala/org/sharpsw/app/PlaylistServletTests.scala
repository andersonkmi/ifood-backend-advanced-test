package org.sharpsw.app

import org.scalatest.FunSuiteLike
import org.scalatra.test.scalatest._

class PlaylistServletTests extends ScalatraSuite with FunSuiteLike {

  addServlet(classOf[PlaylistServlet], "/playlist")

  test("GET /playlist/city on PlaylistServlet should return status 200"){
    get("/playlist/city") {
      status should equal (200)
    }
  }

}
