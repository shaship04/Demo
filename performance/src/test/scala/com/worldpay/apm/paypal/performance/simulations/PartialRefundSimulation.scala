package com.worldpay.apm.paypal.performance.simulations

import com.worldpay.apm.paypal.performance.{GatlingTestSuite, Sale}
import io.gatling.core.Predef.scenario
import io.gatling.core.scenario.Simulation

class PartialRefundSimulation extends Simulation with GatlingTestSuite{

  val partialrefundScenario= scenario("Partial checkout")
    .exec(Sale.partialrefundCheckout)

  val partialrefundProtocols = httpConf

}
