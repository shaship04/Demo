package com.worldpay.apm.paypal.performance.simulations

import com.worldpay.apm.paypal.performance.{GatlingTestSuite, Sale}
import io.gatling.core.Predef.scenario
import io.gatling.core.scenario.Simulation

class RefundSimulation extends Simulation with GatlingTestSuite{


  val refundScenario= scenario("Payment Refund")
    .exec(Sale.refundCheckout)

  val refundProtocols = httpConf

}
