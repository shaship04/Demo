package com.worldpay.apm.paypal.performance

//import com.worldpay.apm.paypal.performance.requests.SaleRequest
import io.gatling.core.Predef.{StringBody, feed}
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.check.HttpCheck
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import java.util.UUID
import scala.util.Random

object Sale {
  private val transactionReferenceFeeder =
    Iterator.continually(Map("transactionReference" -> Random.alphanumeric.take(20).mkString))

  //private val saleRequestBody = SaleRequest().toJsonString

  val saleCheckout: ChainBuilder =
    feed(transactionReferenceFeeder).exec(
      SaleRequest("PAYPAL",
        "/payments/alternative/action/paypal/sale",
        //saleRequestBody,
        "application/vnd.worldpay.paypal-v1+json",
        "application/vnd.worldpay.paypal-v1+json"

      )
    )
  val saleQuery: ChainBuilder =
    exec(getQueryurl("PAYPAL",
      "/payments/alternative/action/paypal/events/TVRBx6KLHxuMKiWY9AThRKkdQ_etWVGvpxL9VDEq_1y8Zsfa19LgFgjXKBkKSy1q",
      "application/vnd.worldpay.paypal-v1+json",
      "application/vnd.worldpay.paypal-v1+json"
    )
    )

  val refundCheckout: ChainBuilder =
    exec(FullRefund("PAYPAL",
        "/payments/alternative/action/paypal/refunds/full/TVRBx6KLHxuMKiWY9AThRKkdQ_etWVGvpxL9VDEq_1y8Zsfa19LgFgjXKBkKSy1q",
        "application/vnd.worldpay.paypal-v1+json",
        "application/vnd.worldpay.paypal-v1+json"

      )
    )

  val partialrefundCheckout: ChainBuilder =
    exec(PartialRefund("PAYPAL",
      "/payments/alternative/action/paypal/refunds/partials/TVRBx6KLHxuMKiWY9AThRKkdQ_etWVGvpxL9VDEq_1y8Zsfa19LgFgjXKBkKSy1q",
      "application/vnd.worldpay.paypal-v1+json",
      "application/vnd.worldpay.paypal-v1+json"

    )
    )

  private def SaleRequest(instrumentType: String,
                                uri: String,
                               // body: String,
                                contentType: String,
                                accept: String,
                                checks: HttpCheck*
                               ) = {
    http(s"$instrumentType Sale Request")
      .post(uri)
      .header("Content-Type", contentType)
      .header("Accept", accept)
      .header("WP-CorrelationId", "ORDER_SUCCESS")
      .proxy(Proxy("proxy.worldpay.local", 8080))
      //.body(StringBody(body))
      .body(RawFileBody("./src/test/scala/com/worldpay/apm/paypal/performance/requests/paypalsale.json"))
      .check(checks: _*)
    // .check(jsonPath("$._links.curies[0].name").is("paypal"))
  }
  private def FullRefund(instrumentType: String,
                                uri: String,
                                contentType: String,
                                accept: String,
                                checks: HttpCheck*
                               ) = {
    http(s"$instrumentType Refund Payment")
      .post(uri)
      .header("Content-Type", contentType)
      .header("Accept", accept)
      .header("WP-CorrelationId", "REFUND")
      .proxy(Proxy("proxy.worldpay.local", 8080))
      .check(checks: _*)
     // .check(jsonPath("$._links.paypal:events").find)

  }

  private def PartialRefund(instrumentType: String,
                         uri: String,
                         contentType: String,
                         accept: String,
                         checks: HttpCheck*
                        ) = {
    http(s"$instrumentType Partial Payment")
      .post(uri)
      .header("Content-Type", contentType)
      .header("Accept", accept)
      .header("WP-CorrelationId", "PARTIAL_REFUND")
      .proxy(Proxy("proxy.worldpay.local", 8080))
      .body(RawFileBody("./src/test/scala/com/worldpay/apm/paypal/performance/requests/partialrefund.json"))
      .check(checks: _*)
    // .check(jsonPath("$._links.paypal:events").find)

  }

  private def getQueryurl( instrumentType: String,
                           uri: String,
                           accept: String,
                           contentType: String,
                           checks: HttpCheck*
                         ) = {
    http(s"$instrumentType Event Query")
      .get(uri)
      .header("Accept", accept)
      .header("Content-Type", contentType)
      .header("WP-CorrelationId", "EVENTS")
      .proxy(Proxy("proxy.worldpay.local", 8080))
      //.body(RawFileBody("./src/test/scala/com/worldpay/gateway/payments/performance/requests/paypalsale.json")).asJson
      .check(checks: _*)
    //.check(jsonPath("$._links.paypal:refund").find)
  }
  private def randomCorrelationId: String = UUID.randomUUID.toString

}

