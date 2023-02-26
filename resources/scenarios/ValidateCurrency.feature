Feature: Validating the Paypal APM Supported Currency

@positive @regression @currency @smoke
Scenario Outline: Verify the supported currency codes in the request.
Given Build the resource url with "sale"
When Call post method with the currency "<currency>" code
And validate the sale response has valid parameters and data
And call paymentQuery get method
And call partial refund post method with the currency "<currency>" code
Then verify the status code "202" for REFUND and message of the response
Examples:
| currency |
| AUD      |
| BRL      |
| CAD      |
| CZK      |
| DKK      |
| EUR      |
| HKD      |
| HUF      |
| INR      |
| ILS      |
| JPY      |
| MYR      |
| MXN      |
| TWD      |
| NZD      |
| NOK      |
| PHP      |
| PLN      |
| GBP      |
| RUB      |
| SGD      |
| SEK      |
| CHF      |
| THB      |
| USD      |
