/*package com.worldpay.apm.paypal.performance.requests

import play.api.libs.json.Json

case class SaleRequest() {
  def toJsonString: String = {
    Json.stringify(
      Json.obj(
        "transactionReference" -> "${transactionReference}",
        "merchant" -> Json.obj(
          "entity" -> "default-FR"
        ),
        "instruction" -> Json.obj(
          "description" -> Json.obj(
            "line1" -> "trading name"
          ),
          "value" -> Json.obj(
            "currency" -> "GBP",
            "amount" -> 300
          ),
          "paymentInstrument" -> Json.obj(
            "type" -> "PAYPAL",
            "billingAddress" -> Json.obj(
              "firstName" -> "John",
              "lastName" -> "Johnson",
              "shopperEmailAddress" -> "email@email.com",
              "address1" -> "8500 Govenors Hill Drive",
              "address2" -> "Symmes Township",
              "address3" -> "Tamilnadu chennai",
              "postalCode" -> "45249",
              "city" -> "Arkansa",
              "state" -> "TEXAS",
              "countryCode" -> "US"
            ),
            "shippingAddress" -> Json.obj(
              "firstName" -> "John",
              "lastName" -> "Johnson",
              "street" -> "8500 Govenors Hill Drive",
              "postalCode" -> "45249",
              "city" -> "Arkansa",
              "state" -> "TEXAS",
              "countryCode" -> "US"
            )
          )
        )
      )
    )
  }
}*/