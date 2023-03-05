package com.worldpay.apm.paypal.performance

import com.typesafe.config.{Config, ConfigFactory}
import io.gatling.core.Predef.Assertion
import io.gatling.core.assertion.AssertionSupport
import io.gatling.core.config.GatlingConfiguration

trait SaleAssertions extends AssertionSupport {
  private val config: Config = ConfigFactory.load("assertions.conf")

  private val p99ResponseTimeMillis: Int = config.getInt("global.p99-response-time-in-millis")
  private val successfulRequestPercentage: Int =
    config.getInt("global.successful-requests-percentage")
  private val targetRequestsPerSecPercentage: Int =
    config.getInt("global.target-requests-per-second-percentage")

  private def targetRequestsPerSecond(requestsPerSec: Int): Int =
    (requestsPerSec * (targetRequestsPerSecPercentage / 100.0)).toInt

  def globalAssertions(requestsPerSec: Int)(implicit
                                            gatlingConfig: GatlingConfiguration
  ): Seq[Assertion] = Seq(
    global.responseTime.percentile(99).lte(p99ResponseTimeMillis),
    global.successfulRequests.percent.gte(successfulRequestPercentage),
    global.requestsPerSec.gte(targetRequestsPerSecond(requestsPerSec))
  )

}
