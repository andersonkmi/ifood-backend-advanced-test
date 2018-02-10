package org.sharpsw.service

import org.sharpsw.app.data.{Playlist, PlaylistFactory}
import org.sharpsw.util.SimpleRestClient.sendPostRequest

object SpotifyService {
  def getTracks(temperature: Double) : Playlist = {
    PlaylistFactory.createFakePlaylist()
  }

  private def authenticate(client: String, secret: String): String = {
    sendPostRequest("https://accounts.spotify.com/api/token", client, secret)
  }
}
