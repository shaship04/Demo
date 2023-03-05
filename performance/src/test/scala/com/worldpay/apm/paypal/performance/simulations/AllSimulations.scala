package com.worldpay.apm.paypal.performance.simulations

import com.worldpay.apm.paypal.performance._ // scalastyle:ignore
import io.gatling.core.Predef._ // scalastyle:ignore
import io.gatling.core.scenario.Simulation

import scala.concurrent.duration.DurationInt


class AllSimulations extends Simulation with GatlingTestSuite with SaleAssertions {

  setUp(

    new PositiveScenarioSimulation()
      .saleRequestScenario
      .inject(constantUsersPerSec(requestsPerSec) during testDurationInSeconds.seconds)
      //.inject(rampUsersPerSec(1) to 30 during testDurationInSeconds.seconds)
      .protocols(new PositiveScenarioSimulation().saleRequestProtocols),

    new EventsSimulation()
      .eventScenario
      .inject(constantUsersPerSec(requestsPerSec) during testDurationInSeconds.seconds)
      //.inject(rampUsersPerSec(1) to 30 during testDurationInSeconds.seconds)
      .protocols(new EventsSimulation().eventProtocols),

    new RefundSimulation()
      .refundScenario
      .inject(constantUsersPerSec(requestsPerSec) during testDurationInSeconds.seconds)
      //.inject(rampUsersPerSec(1) to 30 during testDurationInSeconds.seconds)
      .protocols(new RefundSimulation().refundProtocols),

    new PartialRefundSimulation()
      .partialrefundScenario
      .inject(constantUsersPerSec(requestsPerSec) during testDurationInSeconds.seconds)
      .protocols(new PartialRefundSimulation().partialrefundProtocols)

  )
    .assertions(globalAssertions(requestsPerSec))
}

