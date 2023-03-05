package com.worldpay.apm.paypal.performance.simulations

import com.worldpay.apm.paypal.performance.{GatlingTestSuite, Sale}
import io.gatling.core.Predef.scenario
import io.gatling.core.scenario.Simulation

class EventsSimulation extends Simulation with GatlingTestSuite{


  val eventScenario= scenario("Query Event")
    .exec(Sale.saleQuery)

  val eventProtocols = httpConf

}
