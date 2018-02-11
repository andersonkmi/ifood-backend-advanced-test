package org.sharpsw.service

import org.sharpsw.app.data.{Playlist, PlaylistFactory}
import org.sharpsw.util.ConfigProperties._
import org.sharpsw.util.JsonConverter
import org.sharpsw.util.SimpleRestClient.sendPostRequest
import org.slf4j.LoggerFactory

object SpotifyService {
  private val logger = LoggerFactory.getLogger(SpotifyService.getClass)

  def getTracks(temperature: Double) : Option[Playlist] = {
    authenticate(getProperty(SpotifyClientId), getProperty(SpotifySecretKey)) match {
      case Some(token) => retrievePlaylists(JsonConverter.convertAccessToken(token).access_token)
      case None => None
    }
  }

  private def authenticate(client: String, secret: String): Option[String] = {
    logger.info("Performing authentication against Spotify service")
    sendPostRequest("https://accounts.spotify.com/api/token", client, secret)
  }

  private def retrievePlaylists(access: String): Option[Playlist] = {
    logger.info("Retrieving all playlists:" + access)
    val response = sendPostRequest("https://api.spotify.com/v1/tracks/2TpxZ7JUBn3uw46aR7qd6V", access)
    PlaylistFactory.createFakePlaylist
  }

  private def retrievePlaylist(accessToken: String, temp: Double): Option[Playlist] = {
    PlaylistFactory.createFakePlaylist
  }
}
