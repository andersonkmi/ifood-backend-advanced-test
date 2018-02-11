package org.sharpsw.util

import org.json4s.DefaultFormats
import org.sharpsw.app.LocalDateSerializer
import org.sharpsw.app.data.AccessToken
import org.json4s.jackson.Serialization._

object JsonConverter {
  def convertAccessToken(json: String) = {
    implicit val formats = DefaultFormats + LocalDateSerializer
    read[AccessToken](json)
  }
}
