package org.sharpsw.app

import org.json4s.{DefaultFormats, Formats}
import org.scalatra._
import org.scalatra.json.JacksonJsonSupport
import org.sharpsw.app.data.{Playlist, PlaylistFactory}
import org.slf4j.{Logger, LoggerFactory}

class PlaylistServlet extends ScalatraServlet with JacksonJsonSupport with CorsSupport {

  val logger: Logger = LoggerFactory.getLogger(getClass)

  get ("/city") {
    logger.info("City informed: " + params.get("name").get)
    PlaylistFactory.createFakePlaylist()
  }

  get ("/coords") {
    logger.info("Latitude: " + params.get("latitude").get)
    logger.info("Latitude: " + params.get("longitude").get)
    PlaylistFactory.createFakePlaylist()
  }

  options("/*"){
    response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"))
    response.setHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET,PUT,DELETE")
    response.setHeader("Access-Control-Allow-Origin", "*")
  }

  override protected implicit def jsonFormats: Formats = DefaultFormats + LocalDateSerializer

  before() {
    contentType = formats("json")
  }
}
