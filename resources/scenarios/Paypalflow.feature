@functional
Feature: Validating the Paypal APM for positive and negative scenarios

  @regression @extent @report
  Scenario: validating the root url
    Given Build the resource url with ""
    When call get method to get the root response
    Then verify the status code of the root response is "200"
    And Verify the root response header has Timestamp
    And validate the root response has valid parameters and data

  @regression
  Scenario: validating the Curies Sale url
    Given Build the resourcetree url with "sale"
    When call get method to get the root response
    Then verify the status code of the root response is "200"
    And Verify the root response header has Timestamp
    And validate the root response with valid saledescription

  @regression
  Scenario: validating the relrefund url
    Given Build the resourcetree url with "refund"
    When call get method to get the root response
    Then verify the status code of the root response is "200"
    And Verify the root response header has Timestamp
    And validate the root response with valid refunddescription

  @regression
  Scenario: validating the relevents url
    Given Build the resourcetree url with "events"
    When call get method to get the root response
    Then verify the status code of the root response is "200"
    And Verify the root response header has Timestamp
    And validate the root response with valid eventdescription

  @regression
  Scenario: validating the resourceTree url
    Given Build the resourcetree url with "resourceTree"
    When call get method to get the root response
    Then verify the status code of the root response is "200"
    And Verify the root response header has Timestamp
    And validate the root response with valid data

  @negative @regression
  Scenario Outline: Verify the Error responses with invalid data for SALE flow
    Given Build the resource url with "sale"
    When Call post method with invalid first "<field>" and "<data>" value
    Then verify the errorName and errorMessage
    And verify the status code of the response is "400"
    And verify the "<validationerrorName>" , "<validationerrorMessage>" and "<validationjsonPath>"
    Examples:
      | field                | data                                                                               | validationerrorName    | validationerrorMessage                                                                                             | validationjsonPath                                                 |
      | transactionReference |                                                                                    | fieldIsEmptyORTooShort | The identified field is empty or too short. This field is a mandatory element of the request body.                 | $.transactionReference                                             |
      | transactionReference | ee&&*^%$#ERFdJ                                                                     | fieldHasInvalidValue   | The identified field does not contain an expected value. This field must contain one of the expected valid values. | $.transactionReference                                             |
      | transactionReference | ee$ERFdJ                                                                           | fieldIsEmptyORTooShort | The identified field is empty or too short. This field is a mandatory element of the request body.                 | $.transactionReference                                             |
      | transactionReference | 125abhg%$#2)(*7KHGf-+  (!@#$  :%$#@HFEdSSWAEHJKKKIUYECVBNJyedcbmmkiuyr321^4hgy[}]* | stringIsTooLong        | The identified field contains a string that is above the maximum allowed length                                    | $.transactionReference                                             |
      | entity               |                                                                                    | fieldIsEmpty           | The identified field is empty. This field is required to be non-empty.                                             | $.merchant.entity                                                  |
      | entity               | %$#&^HG-(*                                                                         | fieldHasInvalidValue   | The identified field does not contain an expected value. This field must contain one of the expected valid values. | $.merchant.entity                                                  |
      | entity               | abcdefghijklmnopqrstuvwxyzabcdefghijklmmmmmmnopqrstuvwxyzabcdefghijklmn            | stringIsTooLong        | The identified field contains a string that is above the maximum allowed length.                                   | $.merchant.entity                                                  |
      | line1                |                                                                                    | fieldIsEmpty           | The identified field is empty. This field is required to be non-empty.                                             | $.instruction.description.line1                                    |
      | line1                | &$#@)                                                                              | fieldHasInvalidValue   | The identified field does not contain an expected value. This field must contain one of the expected valid values. | $.instruction.description.line1                                    |
      | line1                | tTHhIiKkJj45678-. YyDSEMHIKL.---                                                   | stringIsTooLong        | The identified field contains a string that is above the maximum allowed length                                    | $.instruction.description.line1                                    |
      | currency             |                                                                                    | fieldHasInvalidValue   | The identified field does not contain an expected value. This field must contain one of the expectedvalid values.  | $.instruction.value.currency                                       |
      | currency             | EGP                                                                                | fieldHasInvalidValue   | The identified field does not contain an expected value. This field must contain one of the expectedvalid values.  | $.instruction.value.currency                                       |
      | amount               | 0                                                                                  | IntegerIsTooSmall      | The identified field contains an integer that is below the minimum allowed value.                                  | $.instruction.value.amount                                         |
      | amount               | 2147483647                                                                         | IntegerIsTooLong       | The identified field contains an integer that is above the maximum allowed value.                                  | $.instruction.value.amount                                         |
      | type                 |                                                                                    | fieldIsEmpty           | The identified field is empty. This field is required to be non-empty.                                             | $.instruction.paymentInstrument.type                               |
      | type                 | IDEAL                                                                              | fieldHasInvalidValue   | Payment type should be PAYPAL                                                                                      | $.instruction.paymentInstrument.type                               |
      | shopperEmailAddress  |                                                                                    | fieldHasInvalidValue   | Email must be a valid email address                                                                                | $.instruction.paymentInstrument.billingAddress.shopperEmailAddress |
      | shopperEmailAddress  | email.com                                                                          | fieldHasInvalidValue   | Email must be a valid email address                                                                                | $.instruction.paymentInstrument.billingAddress.shopperEmailAddress |
      | address1             |                                                                                    | fieldIsEmpty           | The identified field is empty. This field is required to be non-empty.                                             | $.instruction.paymentInstrument.billingAddress.address1            |
      | address1             | %$#%&                                                                              | fieldHasInvalidValue   | The identified field does not contain an expected value. This field must contain one of the expected valid values. | $.instruction.paymentInstrument.billingAddress.address1            |
      | address1             | 1 gmailcomMYwedhju765432lok0987ytredfghjkmnbvcdsazxzsqwertyu                       | stringIsTooLong        | The identified field contains a string that is above the maximum allowed length                                    | $.instruction.paymentInstrument.billingAddress.address1            |
      | address2             |                                                                                    | fieldIsEmpty           | The identified field is empty. This field is required to be non-empty.                                             | $.instruction.paymentInstrument.billingAddress.address2            |
      | address2             | %$#%&                                                                              | fieldHasInvalidValue   | The identified field does not contain an expected value. This field must contain one of the expected valid values. | $.instruction.paymentInstrument.billingAddress.address2            |
      | address2             | 1 gmailcomMYwedhju765432lok0987ytredfghjkmnbvcdsazxzsqwertyu                       | stringIsTooLong        | The identified field contains a string that is above the maximum allowed length                                    | $.instruction.paymentInstrument.billingAddress.address2            |
      | address3             |                                                                                    | fieldIsEmpty           | The identified field is empty. This field is required to be non-empty.                                             | $.instruction.paymentInstrument.billingAddress.address3            |
      | address3             | %$#%&                                                                              | fieldHasInvalidValue   | The identified field does not contain an expected value. This field must contain one of the expected valid values. | $.instruction.paymentInstrument.billingAddress.address3            |
      | address3             | 1 gmailcomMYwedhju765432lok0987ytredfghjkmnbvcdsazxzsqwertyu                       | stringIsTooLong        | The identified field contains a string that is above the maximum allowed length                                    | $.instruction.paymentInstrument.billingAddress.address3            |

  @negative @regression
  Scenario Outline: Verify the Error responses for postal,city,state and countryCode for SALE
    Given Build the resource url with "sale"
    When Call post method with invalid second "<field>" and "<data>" value
    Then verify the errorName and errorMessage
    And verify the status code of the response is "400"
    And verify the "<validationerrorName>" , "<validationerrorMessage>" and "<validationjsonPath>"
    Examples:
      | field       | data                                                                                               | validationerrorName     | validationerrorMessage                                                                                             | validationjsonPath                                         |
      | postalCode  |                                                                                                    | fieldIsEmpty            | The identified field is empty. This field is required to be non-empty.                                             | $.instruction.paymentInstrument.billingAddress.postalCode  |
      | postalCode  | *(&^%                                                                                              | Field has invalid value | The identified field does not contain an expected value. This field must contain one of the expected valid values. | $.instruction.paymentInstrument.billingAddress.postalCode  |
      | postalCode  | 4598765432098Ha HI                                                                                 | stringIsTooLong         | postal Code too long - must be between 1 & 15 characters                                                           | $.instruction.paymentInstrument.billingAddress.postalCode  |
      | city        |                                                                                                    | fieldIsEmpty            | The identified field is empty. This field is required to be non-empty.                                             | $.instruction.paymentInstrument.billingAddress.city        |
      | city        | oh-%$#@                                                                                            | fieldHasInvalidValue    | The identified field does not contain an expected value. This field must contain one of the expected valid values. | $.instruction.paymentInstrument.billingAddress.city        |
      | city        | hiuytrhjkomnjhjjkigfdewsvcxbnmkloiuhjytgfdewasrx123465789054ewqasdftyghuijkolpmnbvcxzzsdfghjikoplm | stringIsTooLong         | The identified field contains a string that is above the maximum allowed length                                    | $.instruction.paymentInstrument.billingAddress.city        |
      | state       |                                                                                                    | fieldIsEmpty            | The identified field is empty. This field is required to be non-empty.                                             | $.instruction.paymentInstrument.billingAddress.state       |
      | state       | *&%$)(                                                                                             | fieldHasInvalidValue    | The identified field does not contain an expected value. This field must contain one of the expected valid values. | $.instruction.paymentInstrument.billingAddress.state       |
      | state       | TEXAARKANSASINDIANASOHIOLKJHGREDSW                                                                 | stringIsTooLong         | The identified field contains a string that is above the maximum allowed length                                    | $.instruction.paymentInstrument.billingAddress.state       |
      | countryCode |                                                                                                    | fieldHasInvalidValue    | The identified field does not contain an expected value. This field must contain one of the expectedvalid values.  | $.instruction.paymentInstrument.billingAddress.countryCode |
      | countryCode | 67543                                                                                              | fieldHasInvalidValue    | The identified field does not contain an expected value. This field must contain one of the expectedvalid values.  | $.instruction.paymentInstrument.billingAddress.countryCode |

  @negative @regression
  Scenario Outline: Verify the error responses when the individual fields are missing for SALE
    Given Build the resource url with "sale"
    When Call post method with "<field>" field
    Then verify the error response with "<jsonPath>"
    And verify the status code of the response is "400"
    Examples:
      | field                | jsonPath                                                           |
      | transactionReference | $.transactionReference                                             |
      | entity               | $.merchant.entity                                                  |
      | line1                | $.instruction.description.line1                                    |
      | type                 | $.instruction.paymentInstrument.type                               |
   #   | shopperEmailAddress  | $.instruction.paymentInstrument.billingAddress.shopperEmailAddress |
      | address1             | $.instruction.paymentInstrument.billingAddress.address1            |
      | postalCode           | $.instruction.paymentInstrument.billingAddress.postalCode          |
      | city                 | $.instruction.paymentInstrument.billingAddress.city                |
   #   | state                | $.instruction.paymentInstrument.billingAddress.state               |

  @negative @regression
  Scenario Outline: Verify the error responses when the individual fields are missing - countryCode,currency and amount
    Given Build the resource url with "sale"
    When Call post method with second "<field>" field
    Then verify the error response with "<validationerror>" and "<jsonPath>"
    And verify the status code of the response is "400"
    Examples:
      | field       | validationerror               | jsonPath                                                   |
      | countryCode | Country code must be supplied | $.instruction.paymentInstrument.billingAddress.countryCode |
      | currency    | Currency must be supplied     | $.instruction.value.currency                               |
      | amount      | Amount must be supplied       | $.instruction.value.amount                                 |


  @positive @smoke @regression
  Scenario: Verify the entire SALE response
    Given Build the resource url with "sale"
    When Call post method with the required amount "250"
    And Verify the sale response header has Timestamp
    And validate the sale response has valid parameters and data
    And verify whether orderId is generated


  @positive @smoke @regression
  Scenario: Verify full flow from SALE to REFUND
    Given Build the resource url with "sale"
    When Call post method with the required amount "250"
    And Verify the sale response header has Timestamp
    And validate the sale response has valid parameters and data
    And call paymentQuery get method
    And Verify the query response header has Timestamp
    And validate the query response has valid parameters and data
    And call full refund post method
    Then verify the status code of the refundResponse is "202"
    And Verify the refund response header has Timestamp
    And validate the refund response has valid parameters and data
    And verify whether orderId is generated

  @positive @smoke @regression
  Scenario Outline: Validating the magic amounts for SALE
    Given Build the resource url with "sale"
    When Call post method with the required magic amount "<magicamount>"
    And call paymentQuery get method
    Then verify the status code of the response is "201"
    And verify whether proper "<errorName>" is displayed
    Examples:
      | magicamount | errorName     |
      | 500         | error         |
      | 600         | refused       |
      | 900         | captureFailed |

  Scenario: Verify the error message for SALE with wrong HTTP method
    Given Build the resource url with "sale"
    When Call get method with the required amount "250"
    Then verify whether proper errorname and message is displayed

  Scenario: Verify the error message for Events with wrong HTTP method
    Given Build the resource url with "sale"
    When Call post method with the required amount "250"
    And call paymentQuery post method
    And verify whether proper errorname and message is displayed for Query

  Scenario: Verify the error message for FULL REFUND with wrong HTTP method
    Given Build the resource url with "sale"
    When Call post method with the required amount "250"
    And call paymentQuery get method
    And call full refund get method
    And verify whether proper errorname and message is displayed for REFUND

  @positive @smoke @regression
  Scenario Outline: Verify error messages for invalid Accept Header
    Given Build the resource url with "sale"
    When Call SALE post method with headers "<Accept>"
    And verify whether proper header errorname and message is displayed
    Examples:
      | Accept        |
      | aasasd        |
      | refused       |
      | captureFailed |

  @positive @smoke @regression
  Scenario Outline: Validating the magic amounts for REFUND
    Given Build the resource url with "sale"
    When Call post method with the required magic amount "<magicamount>"
    And call paymentQuery get method and save queryData
    And call full refund post method
    Then verify the status code of the refundResponse is "202"
    And verify whether proper "<errorName>" is displayed
    Examples:
      | magicamount | errorName         |
      | 700         | sentForSettlement |
      | 1100        | sentForSettlement |

  @positive @smoke @regression
  Scenario: Verify the response code for SALE feature.
    Given Build the resource url with "sale"
    When Call post method with the required amount "250"
    Then verify the status code "201" and message of the response

  @positive @smoke
  Scenario: Verify the response code for REFUND feature.
    Given Build the resource url with "sale"
    When Call post method with the required amount "250"
    And call paymentQuery get method
    And call full refund post method
    Then verify the status code "202" for REFUND and message of the response


  @positive @smoke @regression @sellerprotect
  Scenario: Verify the entire SALE response with seller protect
    Given Build the resource url with "sale"
    When Call post method with seller protect and the required amount "250"
    And Verify the sale response header has Timestamp
    And validate the sale response has valid parameters and data
    And verify whether orderId is generated

  @negative @regression @sellerprotect
  Scenario Outline: Verify the error responses seller protect individual fields are missing - countryCode,street and postalCode
    Given Build the resource url with "sale"
    When Call post method with seller protect second "<field>" field
    Then verify the error response with "<validationerror>" and "<jsonPath>"
    And verify the status code of the response is "400"
    Examples:
      | field       | validationerror                                                                                              | jsonPath                                                    |
      | countryCode | Country code must be supplied                                                                                | $.instruction.paymentInstrument.shippingAddress.countryCode |
      | street      | The identified field is missing. This field is a mandatory element of the request body.                      | $.instruction.paymentInstrument.shippingAddress.street      |
      | postalCode  | The identified field is missing for shipping Address. This field is a mandatory element of the request body. | $.instruction.paymentInstrument.shippingAddress.postalCode  |

  @negative @regression @sellerprotect
  Scenario Outline: Verify the Error responses for seller protect postal,city,street and countryCode for SALE
    Given Build the resource url with "sale"
    When Call post method with seller protect invalid second "<field>" and "<data>" value
    Then verify the errorName and errorMessage
    And verify the status code of the response is "400"
    And verify the "<validationerrorName>" , "<validationerrorMessage>" and "<validationjsonPath>"
    Examples:
      | field       | data               | validationerrorName     | validationerrorMessage                                                                                             | validationjsonPath                                          |
      | postalCode  |                    | fieldIsEmpty            | The identified field is empty for shipping Address. This field is required to be non-empty.                        | $.instruction.paymentInstrument.shippingAddress.postalCode  |
      | postalCode  | *(&^%              | Field has invalid value | The identified field does not contain an expected value. This field must contain one of the expected valid values. | $.instruction.paymentInstrument.shippingAddress.postalCode  |
      | postalCode  | 4598765432098Ha HI | stringIsTooLong         | Shipping postal Code too long - must be between 1 & 15 characters                                                  | $.instruction.paymentInstrument.shippingAddress.postalCode  |
      | street      |                    | fieldIsEmpty            | Shipping street is empty,This field is required to be non-empty.                                                   | $.instruction.paymentInstrument.shippingAddress.street      |
      | street      | St-#*(&^%          | fieldHasInvalidValue    | The identified field does not contain an expected value. This field must contain one of the expected valid values. | $.instruction.paymentInstrument.shippingAddress.street      |
      | countryCode |                    | fieldHasInvalidValue    | The identified field does not contain an expected value. This field must contain one of the expectedvalid values.  | $.instruction.paymentInstrument.shippingAddress.countryCode |
      | countryCode | 12&$EUR            | fieldHasInvalidValue    | The identified field does not contain an expected value. This field must contain one of the expectedvalid values.  | $.instruction.paymentInstrument.shippingAddress.countryCode |
      | city        |                    | fieldIsEmpty            | Shipping City field is empty. This field is required to be non-empty.                                              | $.instruction.paymentInstrument.shippingAddress.city        |

  @regression @partialrefund @smoke
  Scenario: Verify the Partial Refund data in Events Response
    Given Build the resource url with "sale"
    When Call post method with the required amount "250"
    And Verify the sale response header has Timestamp
    And validate the sale response has valid parameters and data
    And call paymentQuery get method
    And Verify the query response header has Timestamp
    And validate the query response has valid parameters and data
    #And validate the partialRefund link in response

  @regression @partialrefund @smoke
  Scenario: Verify the Partial Refund in next action link
    Given Build the resource url with "sale"
    When Call post method with the required amount "250"
    And Verify the sale response header has Timestamp
    And validate the sale response has valid parameters and data
    And call paymentQuery get method
    And Verify the query response header has Timestamp
    And validate the query response has valid parameters and data
    And Verify the query reponse has partialRefund link

  @positive @partialrefund @smoke
  Scenario: Verify the response code for PARTIAL REFUND feature.
    Given Build the resource url with "sale"
    When Call post method with the required amount "250"
    And call paymentQuery get method
    And call partial refund post method
    Then verify the status code "202" for REFUND and message of the response
    And Verify partial refund response had valid parameters and data

  @positive @partialrefund @smoke
  Scenario: Verify the multiple PARTIAL REFUND Request for different amounts.
    Given Build the resource url with "sale"
    When Call post method with the required amount "2500"
    And call paymentQuery get method
    And call partial refund post method with amount "250"
    Then verify the status code "202" for REFUND and message of the response
    And call paymentQuery get method
    And call partial refund post method with amount "1000"
    Then verify the status code "202" for REFUND and message of the response
    And call paymentQuery get method
    And call partial refund post method with amount "1250"
    Then verify the status code "202" for REFUND and message of the response
    And call paymentQuery get method
    And Verify the query reponse has partialRefund link

  @regression @partialrefund @smoke
  Scenario: Verify the PARTIAL REFUND Request for amount more than the actual.
    Given Build the resource url with "sale"
    When Call post method with the required amount "250"
    And call paymentQuery get method
    And call partial refund post method with amount "1000"
    Then verify the status code "202" for REFUND and message of the response
    And call paymentQuery get method
    And Verify the query reponse has partialRefund link

  @regression @partialrefund @smoke
  Scenario: Verify the PARTIAL REFUND Request for amount equal to full refund.
    Given Build the resource url with "sale"
    When Call post method with the required amount "250"
    And call paymentQuery get method
    And call partial refund post method with amount "250"
    Then verify the status code "202" for REFUND and message of the response
    And call paymentQuery get method
    And Verify the query reponse has partialRefund link

  @negative @regression @partialrefund
  Scenario Outline: Verify the error responses when the individual fields are missing - reference,currency and amount
    Given Build the partial refund url with "refunds/partials/"
    When Call partial refund post method with second "<field>" field
    Then verify the error response with "<validationerror>" and "<jsonPath>"
    And verify the status code of the response is "400"
    Examples:
      | field     | validationerror                                                                         | jsonPath         |
      | reference | The identified field is missing. This field is a mandatory element of the request body. | $.reference      |
      | currency  | Currency must be supplied                                                               | $.value.currency |
      | amount    | Amount must be supplied                                                                 | $.value.amount   |

  @negative  @regression @partialrefund
  Scenario Outline: Verify the Error responses with invalid data for Partial Refund flow
    Given Build the partial refund url with "refunds/partials/"
    When Call post method with invalid partial refund "<field>" and "<data>" value
    Then verify the errorName and errorMessage
    And verify the status code of the response is "400"
    And verify the "<validationerrorName>" , "<validationerrorMessage>" and "<validationjsonPath>"
    Examples:
      | field     | data                                                                                                                                  | validationerrorName    | validationerrorMessage                                                                                             | validationjsonPath |
      | amount    | 0                                                                                                                                     | IntegerIsTooSmall      | The identified field contains an integer that is below the minimum allowed value.                                  | $.value.amount     |
      | amount    | 1278956784                                                                                                                            | IntegerIsTooLong       | The identified field contains an integer that is above the maximum allowed value.                                  | $.value.amount     |
      | currency  |                                                                                                                                       | fieldHasInvalidValue   | The identified field does not contain an expected value. This field must contain one of the expectedvalid values.  | $.value.currency   |
      | currency  | EGP                                                                                                                                   | fieldHasInvalidValue   | The identified field does not contain an expected value. This field must contain one of the expectedvalid values.  | $.value.currency   |
      | reference |                                                                                                                                       | fieldIsEmptyORTooShort | The identified field is empty or too short. This field is a mandatory element of the request body.                 | $.reference        |
      | reference | %*&!$?:(test)@Partial-#{[Refund/,.<>]}                                                                                                | fieldHasInvalidValue   | The identified field does not contain an expected value. This field must contain one of the expected valid values. | $.reference        |
      | reference | aklklnkldfnskl-23adma-38449595959-ewrhewihrieworn-993032932032-eenklnfkwelnfklwekl-83283282832832-dnqwndqwnnqwkwqnk-383848218921-aaaa | stringIsTooLong        | The identified field contains a string that is above the maximum allowed length                                    | $.reference        |

  @regression @positive @smoke
  Scenario: Verify the sale request without BillingAddress
    Given Build the resource url with "sale"
    When Call post method with no billing address
    And Verify the sale response header has Timestamp
    And validate the sale response has valid parameters and data


  @positive @smoke @regression @nobiilling
  Scenario: Verify the entire SALE response for hostname
    Given Build the resource url with "sale"
    When Call post method with no billing address
    And validate the hostname in response





