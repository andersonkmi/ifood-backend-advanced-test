package org.sharpsw.service

import org.json4s.{DefaultFormats, Formats}
import org.sharpsw.app.LocalDateSerializer
import org.sharpsw.util.{ConfigProperties, SimpleRestClient}
import org.slf4j.LoggerFactory
import org.json4s.jackson.Serialization.read
import org.sharpsw.app.data.OpenWeatherInfo

object OpenWeatherMapService {
  protected implicit lazy val jsonFormats: Formats = DefaultFormats + LocalDateSerializer

  private val logger = LoggerFactory.getLogger(getClass)

  def retrieveTempByCity(city: String) : OpenWeatherInfo = {
    val apiKey = ConfigProperties.getProperty(ConfigProperties.OpenWeatherMapApiKey)
    val url = ConfigProperties.getProperty(ConfigProperties.OpenWeatherMapUrl) + "q=" + city + "&appid=" + apiKey
    logger.info("URL: " + url)
    val result = SimpleRestClient.getRestContent(url)
    val jsonResult = read[OpenWeatherInfo](result)
    logger.info("Result: " + jsonResult.name)
    jsonResult
  }
}
