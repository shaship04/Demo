package com.worldpay.apm.paypal.performance

import com.typesafe.config.{Config, ConfigFactory}
import io.gatling.core.Predef.configuration
import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import java.io.{File, FileInputStream}
import java.util.Properties
//import io.gatling.http.request.builder //scalastyle:ignore

trait GatlingTestSuite extends Simulation{
  lazy val cfg: Config = ConfigFactory.load()
  def paymentsBaseUrl: String = cfg.getString("base.url")
  def username: String = cfg.getString("base.username")
  def password: String = cfg.getString("base.password")
  def testDurationInSeconds: Int = cfg.getString("base.testDurationInSeconds").toInt
  def requestsPerSec: Int = cfg.getString("base.requestsPerSec").toInt
  def userAgent: String = cfg.getString("base.userAgent")
  def scenarios: List[String] = cfg.getString("base.runAuthorizationScenarios").split(',').toList
  //def bearerToken: String = cfg.getString("base.headerAuthorization")

    val authConfig = ConfigFactory.parseFile(new File("/opt/config.properties"))
    val gatlingConfFile= ConfigFactory.load(authConfig)
    //val bearerToken = gatlingConfFile.getString("perf.authorization")


    val bearerToken: String = System.getProperty("token")


  val httpConf: HttpProtocolBuilder = {
    val builder = http
      .baseUrl(paymentsBaseUrl)
    //.basicAuth(username, password)
    builder.header("Authorization", s"Bearer $bearerToken")
  }

}
