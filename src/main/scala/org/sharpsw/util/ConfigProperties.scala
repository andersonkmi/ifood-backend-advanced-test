package org.sharpsw.util

import java.io.FileInputStream

object ConfigProperties {
  private val PropertiesFileName = "application.properties"
  private val PropertiesFile = getEnvironment + PropertiesFileName
  private val InsideJarPropertiesFileName = "/" + PropertiesFileName

  val OpenWeatherMapUrl = "OpenWeatherMapUrl"
  val OpenWeatherMapApiKey = "OpenWeatherMapApiKey"
  val SpotifyClientId = "SpotifyClientId"
  val SpotifySecretKey = "SpotifySecretKey"

  val props = new java.util.Properties()

  def getProperty(key: String) : String = {
    val file = PropertiesFile
    if (file.equals(InsideJarPropertiesFileName)) {
      props.load(getClass.getResourceAsStream(PropertiesFile))
    } else {
      props.load(new FileInputStream(file))
    }
    props.getProperty(key)
  }

  def getEnvironment : String = {
    val env = Option(System.getProperty("mode"))
    env match {
      case Some(env) => if (env.equalsIgnoreCase("golive")) "/data/" else "/"
      case None => "/"
    }
  }

  def getPropertyFile : String = PropertiesFile
}
