package org.sharpsw.app.data

object PlaylistFactory {
  def createFakePlaylist() = {
    val tracks = Some(List("track1", "track2"))
    val fakeResult = Playlist("rock", tracks)
    fakeResult
  }
}
