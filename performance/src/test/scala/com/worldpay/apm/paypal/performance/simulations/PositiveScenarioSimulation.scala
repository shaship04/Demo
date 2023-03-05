package com.worldpay.apm.paypal.performance.simulations

import com.worldpay.apm.paypal.performance.{GatlingTestSuite, Sale}
import io.gatling.core.Predef.scenario
import io.gatling.core.scenario.Simulation

class PositiveScenarioSimulation extends Simulation with GatlingTestSuite{


  val saleRequestScenario= scenario("Sale Request")
    .exec(Sale.saleCheckout)

  val saleRequestProtocols = httpConf


}
