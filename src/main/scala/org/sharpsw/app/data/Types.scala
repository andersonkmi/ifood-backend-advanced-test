package org.sharpsw.app.data

case class Playlist (
  genre: String,
  tracks: Option[List[String]] = None
)