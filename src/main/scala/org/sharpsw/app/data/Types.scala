package org.sharpsw.app.data

case class Playlist (
  genre: String,
  tracks: Option[List[String]] = None
)

case class OpenWeatherInfo(
  id: Integer,
  name: String,
  cod: Integer,
  coord: Coord,
  main: Main
)

case class Coord (
                 lon: Double,
                 lat: Double
)

case class Main(
  temp: Double
)
