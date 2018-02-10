package org.sharpsw.service

import org.sharpsw.app.data.{Playlist, PlaylistFactory}
import org.sharpsw.util.SimpleRestClient.sendPostRequest

object SpotifyService {
  def getTracks(temperature: Double) : Playlist = {
    authenticate("", "") match {
      case Some(token) => retrievePlaylist(token, temperature)
      case None => PlaylistFactory.createFakePlaylist()
    }
    PlaylistFactory.createFakePlaylist()
  }

  private def authenticate(client: String, secret: String): Option[String] = {
    sendPostRequest("https://accounts.spotify.com/api/token", client, secret)
  }

  private def retrievePlaylist(accessToken: String, temp: Double): Playlist = {
    PlaylistFactory.createFakePlaylist()
  }
}
