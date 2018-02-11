package org.sharpsw.app.data

object PlaylistFactory {
  def createFakePlaylist(): Option[Playlist] = {
    val tracks = Some(List("track1", "track2"))
    val fakeResult = Playlist("rock", tracks)
    Some(fakeResult)
  }
}
