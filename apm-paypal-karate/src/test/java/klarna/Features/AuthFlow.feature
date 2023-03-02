Feature: validating the klarna auth flow

  Background: define url
    Given url apiUrl
    * header Authorization = call read("classpath:klarna/helpers/basic-auth.js") { username: '#(username)', password: '#(password)' }
#    * def fakerObj = new faker()
#    * def reference = fakerObj.regexify("([A-Z0-9a-z]){12,15}")
    * def datagenerator = Java.type('klarna.helpers.DataGenerator')
    * def reference = datagenerator.getRandomreference()
    * def body = read ("classpath:klarna/helpers/paypalSale.json")

     # * def token = function() { return 'Bearer eyJraWQiOiJmYWtlLWVkZ2UtYXV0aCIsIng1YyI6WyJMUzB0TFMxQ1JVZEpUaUJEUlZKVVNVWkpRMEZVUlMwdExTMHRDazFKU1VOeWVrTkRRVnBqUTBGb1FVSk5RVEJIUTFOeFIxTkpZak5FVVVWQ1EzZFZRVTFEVVhoSmFrRm5RbWRPVmtKQlRVMUhWMVpyV2pKVmRGbFlWakFLWVVNeGNHSnVVbXhqYlRGc1drZHNhR1JIVlhSWk1rVjNTVUpqVGsxcVFYZE9ha1UwVFZSRmQwMVVUWGhYYUdkUVRYcEJlRTlVUlhkTmFrRjRUVlJCZUFwTmVrWmhUVUpSZUVWcVFWRkNaMDVXUWtGTlRVTlhWbXRhTWxWMFdWaFdNR0ZFUTBOQlUwbDNSRkZaU2t0dldrbG9kbU5PUVZGRlFrSlJRVVJuWjBWUUNrRkVRME5CVVc5RFoyZEZRa0ZQY1VKUE9XbHdkRk5KYjFGVFpYUlFiakV3UWxGbU0zZG5UVVZ1VlN0dFExQlNSRGxCU0ZJeFJVUjNhV050VDNSclMyd0thVUV2UVM4NFUyMDVhamd4VkdKaWNUbDBkMW8zTUhGSGFEYzVUa3gzVUZaNU0yMVRSamcwU0V0dllWcFFOazFPY0hKSVR6QkZhWGx1Vm5wTWIwZGtXUXBCZGxjeEsyTlZUVk00YTAxb1JqVXZkV3A1Tm1oSk5HOUpjVzgzZEhkNmVWWnRjRWx6Tm10UGJsUTJhU3R1VVZORFZVdGlMMFV2TjFwNFMwMVBZa3h5Q2pOTUt6Uk5Na3RZZUhwTWFIUnhOSEJSZWpWeVJGSTNXamd4VGtsT2VUWnFiMUI2VGxwbmVXeElWMUZRVGpGT1YxVnZjelU0ZVc1QllXeFhVbGMxV1hVS2JVOHpiMUpITjBWVVYwTkxiMVJyYkdWRldEaGFWelJ2UlZrd1owVlViMGsyWVdOMlJuZG5XVXRQY2tWRFNsTkhabXRFWmxGV1ZuQjFVelp3WnpsRWFncG1VRzFFTWsxaVoxVm5UUzlPYkhwWVdGTTNkMHhRUjJSNlRYWXplazF5Tm5kT1kwTkJkMFZCUVZSQlRrSm5hM0ZvYTJsSE9YY3dRa0ZSYzBaQlFVOURDa0ZSUlVGdFJtVmhkVlJtUW0xcFJXTnVUM2R3ZDBOWGMwdHZkM0puWVdWNWJGaFBkbkJVUnpCcGNWTkVTM0l2Vmt0d1MxRlhLMlJNYkRGM2NTOXZXVFVLY0dKRFJsZHJhbGxCTm10Q1pGaDVXSGhEUjJ3eGNEY3ZLMmwyUldzdlZrY3pNWE15YTA5SGVIUktTSEZCWmxkaFJtZEtibE5CY1d4bldtTTFhMk12VVFvME0ycEZaMEpRUld3M1MwMTZhSEIxVFZBMVJucEtkRFZFVW1wdWRrZDRhVUpRVW10WldGaHZjVmN2VGxwSlpUTlZObGN5UlV0TGVFcE5XV2xqZVN0QkNrcE5MMWM1VFVacVpXdGxVRFZDZUdsb2FEZG5hMWxwVG0xeWMwUkVVMFJ1VEV0dVRrOVJWemR5VVVaRVQxRlRVVmR6YkVOYWFVMWFUMjkzWlZaUWRHY0tRM2RFUm10eWEyWmxiMmxhTUV3MlVXZ3hLM1ZLU25SUGIyMTFkeTlrYkZwcU5XOUphMlUwVlhKVFVrNXFNRlpuVFVGcWQwOHllREpLWTNsSlVXVnRTUXBGUlhobGFVTTNNSHA0YW5jck56ZERibkJ6TDNacVRVeFBVVDA5Q2kwdExTMHRSVTVFSUVORlVsUkpSa2xEUVZSRkxTMHRMUzBLIiwiTFMwdExTMUNSVWRKVGlCRFJWSlVTVVpKUTBGVVJTMHRMUzB0Q2sxSlNVTXdWRU5EUVdKdFowRjNTVUpCWjBsRFJVRkJkMFJSV1VwTGIxcEphSFpqVGtGUlJVeENVVUYzU0VSRllVMUNaMGRCTVZWRlFYZDNVbHBYVW00S1dsTXhhR1JZVW05TVdFcDJZak5SZEZreVJYZEpRbU5PVFdwQmQwNXFSVFJOVkVWM1RWUk5lRmRvWjFCTmVrRjRUMVJGZDAxcVFYaE5WRUY0VFhwR1lRcE5RMUY0U1dwQlowSm5UbFpDUVUxTlIxZFdhMW95VlhSWldGWXdZVU14Y0dKdVVteGpiVEZzV2tkc2FHUkhWWFJaTWtWM1oyZEZhVTFCTUVkRFUzRkhDbE5KWWpORVVVVkNRVkZWUVVFMFNVSkVkMEYzWjJkRlMwRnZTVUpCVVVSWVFrOU9iME5uVEVOSVIwVjBaWE4yVjBsdE1GZGhORGhVTm5vclYydGpVSGdLUlRkcU4wWlJjbXc0UW1GRVREZHhRa0pDZDFWWVdqTkVSMWR3VkRoeVFtVlFUVXA0UXpCWFNGZDViRzAyTW5kelRrMXhOVXhZUlhwc2FUTlhaVVoxVXdwRlJrRk5ZVVJyZG5aellqRkhTM2xIVkV0bmNHbFlPR1JXYjJob09VNXplR04zYTJSclRFSmFhamRFVjNKUVpIVlpiVTFWU0V4SVpreHVjVFJJU1ZBeENrSTJWWGRYWW5aMlUybFlUVlZGVDFkMlpGZzBSM2h4SzJWYVptaExjbkZCTlZGdlpYSlpVbE14U2sxR2JDOHlSMmxqUW1sVGR5dE1NREIxWkV4Sk5rRUtZVFJIVG1aSFJYcDFhMUEzTldwemIzQkpjRWxNUm1sSFdFdFRXU3RwWldSRGNsZENha1JEVVVGR2NUWjNXRkJuWlVVdlFVVldNMUZhSzB4S1FVRjZOd3BFUzFSSE0waDRSMGR6YlhBNFpVbHpXalk0VFhsM1Z6UklkREZuTkhKSVIzUjViR3hTVW5kME5GRmtMMGh0Y1hSaVptTm1RV2ROUWtGQlIycEZla0ZTQ2sxQk9FZEJNVlZrUlhkRlFpOTNVVVpOUVUxQ1FXWTRkMFJSV1VwTGIxcEphSFpqVGtGUlJVeENVVUZFWjJkRlFrRkhXRlZxVUVKV2NTOTNMMnN2VmtjS1FWWm5ZM2g1VUdOQlVERllhbkJQVkU1NE9IUkJMemxEYlZCYVlrRnhMemhDY0dGSk5FVTFVMU5WU2xwQ1ptbG9WR1pGWmpjelowMVdVM2t6YmxWclZRcHhjMmRuWkZvMllrMUhNRlZIWkZOU1ZuTXlORUZ2TDBnMlIzUklXWGhIV2twdlJGUkliSFpHYTNobEwySjVNVFZYVW1aQ2VIRkpRaTlZUmxSWVZVTjJDbmwzYkU1NmIwMVdWek5sV2tOVE5FVXpWRzUyUTBOYVdsWm9kRVJSVlZReGJYbGpiR2h2VXpNeWFVUkVTU3RyVUdGTFJVRXhTVE5DVUc1SlZXMURSMklLZDBWeFYwVlRUV3R1T0RFMGJXSlVWV0YyYlRWc01HeFBRVUZ1Y0RJMk9WRnRUMjVRZFRCVlVsYzRiMVJuZG5kcFV6Tm9hbXBxVlVvNGFUa3ZhRklyU2dwa2EwNVFPVms0TW5wV2ExQjVOMjVoVjBsakswVnRiMmhvZDBVemFEQnBTMjR4TkZKR2VraEhNVE56ZEc5dlZXdDNibkJrT1hFeWNrOVhXbU5NUW5GcUNsZG1kVmMwV0ZrOUNpMHRMUzB0UlU1RUlFTkZVbFJKUmtsRFFWUkZMUzB0TFMwSyJdLCJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJub24tcGF5ZmFjIn0.KpMAJBUYIZ6ZLkEbsHmKiPqQ-HZDQxTKg0Tw9D_wqhjMztZryUPVje4HCWlqksqkNDfGzrSrjtcC7KgA_E3TBh8knfkxKG57NsSoaIn0HAWoSKQ-T6jAK9lt6i4tCtvG3EVmiQn0ynb1SGQH9Z7_d918TVLP8Gf28tHGzLvvoJ6mvc3Bt9HKT73WQmNPND5bhWBd29HuMtuRx1piZbX0MEpkRSed1uWs3tlXrfHoKXQHymuXzhGo7VM2nFj-Kd43YfQ5Q4NBHpPri66v79GfPXMl4BPWykAuYkOYx-Ft01sldDotUBL4lLuV-0tObi95rBvVhybzaD81IX5XCoen_w'}
     # * def auth = call token
     # * header Authorization = auth

    # * header Authorization = call read("classpath:klarna/helpers/token.js")
  @sale
  Scenario: Validate the payapal resorceTree url
    Given path 'rels/payments/alternative/action/paypal/resourceTree'
    When method Get
    Then status 200

@sale
  Scenario: Validate the payapal sale
    Given path '/payments/alternative/action/paypal/sale'
    And request body
    When method Post
    Then status 201

  Scenario: Validate the response when currency field missing
    Given path '/payments/alternative/action/paypal/sale'
    * remove body.instruction.value.currency
    And request body
    When method  Post
    Then status 400

  Scenario: Validate the response when currency field set to null
    Given path '/payments/alternative/action/paypal/sale'
    * set body.instruction.value.currency = null
    And request body
    When method  Post
    Then status 400

  Scenario: Validate the response when Acept Header is missing
    Given path '/payments/alternative/action/paypal/sale'
    * configure headers = null
    * def accept = { Accept: 'application/json', Content-Type: 'application/vnd.worldpay.paypal-v1+json','wp-correlationId': 'karate' }
    And headers accept
    And request body
    When method  Post
    Then status 400

  Scenario Outline: Validate the response for postal, city and state
    Given path '/payments/alternative/action/paypal/sale'
    * set body.instruction.paymentInstrument.billingAddress.city = "<city>"
    * set body.instruction.paymentInstrument.billingAddress.state = "<state>"
    * set body.instruction.paymentInstrument.billingAddress.postalCode = "<postalCode>"
    And request body
    When method  Post
    Then status 400
    Then response.validationErrors[0].errorName = "<errorName>"
    Then response.validationErrors[0].messsage = "<errorMessage>"
    Then response.validationErrors[0].jsonPath = "<jsonPath>"

    Examples:
      | city | state | postalCode | errorName    | errorMessage                                                           | jsonPath                                                   |
      |      | TEXAS | 45249      | fieldIsEmpty | The identified field is empty. This field is required to be non-empty. | $.instruction.paymentInstrument.billingAddress.city        |
      | Ohio |       | 45249      | fieldIsEmpty | The identified field is empty. This field is required to be non-empty. | $.instruction.paymentInstrument.billingAddress.state       |
      | Ohio | TEXAS |            | fieldIsEmpty | The identified field is empty. This field is required to be non-empty. | $.instruction.paymentInstrument.billingAddress.postalCode |

  Scenario: Validate the event query ands settlement status
    Given path '/payments/alternative/action/paypal/sale'
    And request body
    When method  Post
    * def actionLink = $._links.paypal:events.href
    * print actionLink
    Then status 201
    And response.outcome == 'pendingSale'
    Given url apiUrl + actionLink
    * header Authorization = call read('basic-auth.js') { username: '#(username)', password: '#(password)' }
    * retry until response.lastEvent == 'sentForSettlement'
    When method Get
    Then status 200
    And match response._links["paypal:refund"].href == '#present'
    And match response._links.curies[0].name == 'paypal'






