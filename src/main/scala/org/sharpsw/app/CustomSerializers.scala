package org.sharpsw.app

import org.json4s.{JString, CustomSerializer, JNull}

import java.time._



case object LocalDateSerializer extends CustomSerializer[LocalDateTime](format => (
  {
    case JString(s) => LocalDateTime.parse(s)
    case JNull => null //TODO avaliar para usar option/optional
  },
  {
    case ld: LocalDateTime => { JString(ld.toString) }
  }
))
