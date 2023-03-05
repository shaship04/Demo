package com.worldpay.apm.paypal.performance

import com.worldpay.apm.paypal.performance.Sale.{partialrefundCheckout, refundCheckout, saleCheckout, saleQuery}
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder

import scala.concurrent.duration._ // scalastyle:ignore

trait AuthorizationScenario extends Simulation with GatlingTestSuite with SaleAssertions {

  def setup(scenarioName: String, chainBuilder: ChainBuilder*): SetUp = {

   /* setUp(
      scenario(scenarioName)
        .exec(chainBuilder)
        .inject(constantUsersPerSec(requestsPerSec) during testDurationInSeconds.seconds)
    ).protocols(httpConf).assertions(globalAssertions(requestsPerSec))*/
    setUp(
      scenario(scenarioName)
        .exec(chainBuilder)
        .inject(rampUsersPerSec(1) to 2 during testDurationInSeconds.seconds)
    ).protocols(httpConf)
  }
}

abstract class AuthorizationSimulation(scenarioName: String, chainBuilder: ChainBuilder*)
    extends AuthorizationScenario {
  setup(scenarioName, chainBuilder: _*)
}

  class SaleCheckoutSimulation extends AuthorizationSimulation("Sale checkout", saleCheckout)

  class QueryCheckoutSimulation extends AuthorizationSimulation("Query checkout", saleQuery)

  class RefundCheckoutSimulation extends AuthorizationSimulation("Refund checkout", refundCheckout)

  class PartialCheckoutSimulation extends AuthorizationSimulation("Partial checkout", partialrefundCheckout)

/* class AuthorizationScenariosSimulation extends AuthorizationScenario {
   private val scenariosToRunMap = Map(
     "SaleCheckoutSimulation" ->  saleCheckout,
     "QueryCheckoutSimulation" -> saleQuery,
     "RefundCheckoutSimulation" -> refundCheckout
   )
   private val scenarioName = s"${scenarios.mkString(", ")}"
   private val chainBuilder = scenarios.flatMap(scenariosToRunMap.get)

   setup(scenarioName, chainBuilder: _*)
 }*/
