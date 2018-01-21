package org.sharpsw.service

import org.sharpsw.app.data.{Playlist, PlaylistFactory}

object SpotifyService {
  def getTracks(temperature: Double) : Playlist = {
    PlaylistFactory.createFakePlaylist()
  }
}
