package org.sharpsw.util

import java.nio.charset.StandardCharsets
import java.util.Base64

import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.{HttpGet, HttpPost}
import org.apache.http.impl.client.{DefaultHttpClient, HttpClients}
import org.apache.http.message.BasicNameValuePair
import org.slf4j.LoggerFactory

import collection.JavaConverters._
import scala.collection.mutable.ListBuffer
import scala.io.Source

object SimpleRestClient {
  private val logger = LoggerFactory.getLogger(getClass)

  def getRestContent(url:String): String = {
    val httpClient = new DefaultHttpClient()
    val httpResponse = httpClient.execute(new HttpGet(url))
    val entity = httpResponse.getEntity()
    var content = ""
    if (entity != null) {
      val inputStream = entity.getContent()
      content = io.Source.fromInputStream(inputStream).getLines.mkString
      inputStream.close
    }
    httpClient.getConnectionManager().shutdown()
    return content
  }

  def sendPostRequest(url: String, clientId: String, secretKey: String): Option[String] = {
    val client = HttpClients.createDefault()
    val httpPost = new HttpPost(url)

    val params = ListBuffer[BasicNameValuePair]()
    params += new BasicNameValuePair("grant_type", "client_credentials")
    httpPost.setEntity(new UrlEncodedFormEntity(params.asJavaCollection))
    httpPost.setHeader("Authorization", "Basic " + Base64.getEncoder.encodeToString(s"$clientId:$secretKey".getBytes(StandardCharsets.UTF_8)))

    val response = client.execute(httpPost)
    var responseValue: Option[String] = None
    logger.info("Status code: " + response.getStatusLine.getStatusCode)
    if (response.getStatusLine.getStatusCode == 200) responseValue = Some(Source.fromInputStream(response.getEntity.getContent).getLines.mkString)
    client.close()
    logger.info("Response from service: " + responseValue.get)
    responseValue
  }

  def sendPostRequest(url: String, access: String): Option[String] = {
    val client = HttpClients.createDefault()
    val httpGet = new HttpGet(url)

    httpGet.setHeader("Authorization", "Bearer " + access)

    val response = client.execute(httpGet)
    var responseValue: Option[String] = None
    logger.info("Status code: " + response.getStatusLine.getStatusCode)
    if (response.getStatusLine.getStatusCode == 200) {
      responseValue = Some(Source.fromInputStream(response.getEntity.getContent).getLines.mkString)
    }
    else {
      logger.error("Error: " + Source.fromInputStream(response.getEntity.getContent))
    }
    client.close()
    logger.info("Response from service: " + (if(responseValue.isDefined) responseValue.get else "None"))
    responseValue
  }
}
