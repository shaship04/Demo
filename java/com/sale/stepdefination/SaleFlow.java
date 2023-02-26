package com.sale.stepdefination;

import com.sale.generic.ConstantUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SaleFlow extends ConstantUtils {
    private Response response;
    private Response rootResponse;
    private Response refundResponse;
    private Response queryResponse;
    private String resourceURI;
    private String queryData;
    private String queryEncryptData;


    @Given("Build the resource url with {string}")
    public void buildTheResourceUrlWith(String resource) {

        resourceURI = payResource() + resource;
    }


    @Then("verify the status")
    public void verifyTheStatusCodeOfTheResponse(String status) {
        assertEquals(Integer.parseInt(status), response.getStatusCode(), "Success Response");
    }


    @Then("verify the {string} and {string}")
    public void verify_The_errorname_And_errormsg(String errorName, String errorMessage) {
        String actErrorName = JsonPath.from(response.asString()).get("errorName");
        String actErrormsg = JsonPath.from(response.asString()).get("message");
        assertEquals(errorName, actErrorName);
        assertEquals(errorMessage, actErrormsg);
    }

    @Then("verify the {string} , {string} and {string}")
    public void verify_The_validationErrors(String validationErrorName, String validationErrorMsg, String validationJsonPath) {

        String actErrorName = JsonPath.from(response.asString()).get("validationErrors[0].errorName");
        String actErrormsg = JsonPath.from(response.asString()).get("validationErrors[0].message");
        String actJsonPath = JsonPath.from(response.asString()).get("validationErrors[0].jsonPath");
        assertEquals(validationErrorName, actErrorName);
        assertEquals(validationErrorMsg, actErrormsg);
        assertEquals(validationJsonPath, actJsonPath);


    }

    @When("Call post method with valid data")
    public void callPostMethodWith_valid_data() throws IOException {
        response = given()
                .spec(getRequestSpec())
                .body(setvalidReqBody())
                .post(resourceURI).then().extract().response();
    }


    @When("Call post method with {string} field")
    public void callPostMethodWith_missing_Field(String fieldName) throws IOException {
        if (fieldName.equalsIgnoreCase("transactionReference")) {
            response = given().spec(getRequestSpec()).body(setmissingtransrefReqBody())
                    .post(resourceURI).then().extract().response();
        } else if (fieldName.equalsIgnoreCase("entity")) {
            response = given().spec(getRequestSpec()).body(setmissingentityReqBody())
                    .post(resourceURI).then().extract().response();

        } else if (fieldName.equalsIgnoreCase("line1")) {
            response = given().spec(getRequestSpec()).body(setmissingline1ReqBody())
                    .post(resourceURI).then().extract().response();

        } else if (fieldName.equalsIgnoreCase("type")) {
            response = given().spec(getRequestSpec()).body(setmissingtypeReqBody())
                    .post(resourceURI).then().extract().response();

        } else if (fieldName.equalsIgnoreCase("shopperEmailAddress")) {
            response = given().spec(getRequestSpec()).body(setmissingMailReqBody())
                    .post(resourceURI).then().extract().response();

        } else if (fieldName.equalsIgnoreCase("address1")) {
            response = given().spec(getRequestSpec()).body(setmissingaddress1ReqBody())
                    .post(resourceURI).then().extract().response();

        } else if (fieldName.equalsIgnoreCase("postalCode")) {
            response = given().spec(getRequestSpec()).body(setmissingpostalCodeReqBody())
                    .post(resourceURI).then().extract().response();

        } else if (fieldName.equalsIgnoreCase("city")) {
            response = given().spec(getRequestSpec()).body(setmissingcityReqBody())
                    .post(resourceURI).then().extract().response();

        } else if (fieldName.equalsIgnoreCase("state")) {
            response = given().spec(getRequestSpec()).body(setmissingstateReqBody())
                    .post(resourceURI).then().extract().response();

        }
    }

    @Then("verify the error response with {string}")
    public void verifyTheErrorResponseWithactualData(String expjsonpath) {
        String expErrorName = "bodyDoesNotMatchSchema";
        String expErrormsg = "The json body provided does not match the expected schema";
        String expvalidationErorName = "fieldIsMissing";
        String expvalidationMessage = "The identified field is missing. This field is a mandatory element of the request body.";
        String actErrorName = JsonPath.from(response.asString()).get("errorName");
        String actErrormsg = JsonPath.from(response.asString()).get("message");
        String actvalidationErorName = JsonPath.from(response.asString()).get("validationErrors[0].errorName");
        String actvalidationMessage = JsonPath.from(response.asString()).get("validationErrors[0].message");
        String actJsonPath = JsonPath.from(response.asString()).get("validationErrors[0].jsonPath");
        assertEquals(expErrorName, actErrorName);
        assertEquals(expErrormsg, actErrormsg);
        assertEquals(expvalidationErorName, actvalidationErorName);
        assertEquals(expvalidationMessage, actvalidationMessage);
        assertEquals(expjsonpath, actJsonPath);
    }

    @Then("verify the error response with {string} and {string}")
    public void verifyTheErrorResponseWithAnd(String expvalidationMessage, String expjsonpath) {

        String expErrorName = "bodyDoesNotMatchSchema";
        String expErrormsg = "The json body provided does not match the expected schema";
        String expvalidationErorName = "fieldIsMissing";
        String actErrorName = JsonPath.from(response.asString()).get("errorName");
        String actErrormsg = JsonPath.from(response.asString()).get("message");
        String actvalidationErorName = JsonPath.from(response.asString()).get("validationErrors[0].errorName");
        String actvalidationMessage = JsonPath.from(response.asString()).get("validationErrors[0].message");
        String actJsonPath = JsonPath.from(response.asString()).get("validationErrors[0].jsonPath");
        assertEquals(expErrorName, actErrorName);
        assertEquals(expErrormsg, actErrormsg);
        assertEquals(expvalidationErorName, actvalidationErorName);
        assertEquals(expvalidationMessage, actvalidationMessage);
        assertEquals(expjsonpath, actJsonPath);


    }

    @Then("verify the errorName and errorMessage")
    public void verifyTheErrorNameAndErrorMessage() {

        String expErrorName = "bodyDoesNotMatchSchema";
        String expErrorMessage = "The json body provided does not match the expected schema";
        String actErrorName = JsonPath.from(response.asString()).get("errorName");
        String actErrormsg = JsonPath.from(response.asString()).get("message");
        assertEquals(expErrorName, actErrorName);
        assertEquals(expErrorMessage, actErrormsg);

    }

    @Then("verify whether orderId is generated")
    public void verifyWhetherTokenIdIsGenerated() {
        String positiveresponse = response.getBody().asString();
        assertTrue(positiveresponse.contains("orderId"));

    }

    @Then("verify the status code of the response is {string}")
    public void verifyTheStatusCodeOfTheResponseIs(String statuscode) {
        int status = Integer.parseInt(statuscode);
        assertEquals(status, response.getStatusCode(), "Success Response");
    }

    @Then("verify the status code of the root response is {string}")
    public void verifyTheStatusCodeOfTheRootResponseIs(String statuscode) {
        int status = Integer.parseInt(statuscode);
        assertEquals(status, rootResponse.getStatusCode(), "Success Response");
    }

    @Then("verify the status code of the refundResponse is {string}")
    public void verifyTheStatusCodeOfTheRefundResponseIs(String statuscode) {
        int status = Integer.parseInt(statuscode);

        assertEquals(status, refundResponse.getStatusCode(), "Success Response");
    }


    @When("Call post method with invalid first {string} and {string} value")
    public void callPostMethodWithInvalidFirstAndValue(String fieldName, String value) throws IOException {
        switch (fieldName) {
            case "transactionReference":
                response = given()
                        .spec(getRequestSpec())
                        .body(setTransRequestBody(value))
                        .post(resourceURI)
                        .then().extract().response();
                break;
            case "entity":
                response = given().spec(getRequestSpec()).body(setEntityRequestBody(value))
                        .post(resourceURI).then().extract().response();
                break;
            case "line1":
                response = given().spec(getRequestSpec()).body(setLine1TransRequestBody(value))
                        .post(resourceURI).then().extract().response();

                break;
            case "currency":
                response = given().spec(getRequestSpec()).body(setCurrencyRequestBody(value))
                        .post(resourceURI).then().extract().response();
                break;
            case "amount":
                response = given().spec(getRequestSpec()).body(setAmountRequestBody(value))
                        .post(resourceURI).then().extract().response();

                break;
            case "type":
                response = given().spec(getRequestSpec()).body(setTypeRequestBody(value))
                        .post(resourceURI).then().extract().response();

                break;

            case "firstName":
                response = given().spec(getRequestSpec()).body(setfirstNameRequestBody(value))
                        .post(resourceURI).then().extract().response();

                break;
            case "lastName":
                response = given().spec(getRequestSpec()).body(setlastNameRequestBody(value))
                        .post(resourceURI).then().extract().response();

                break;

            case "shopperEmailAddress":
                response = given().spec(getRequestSpec()).body(setshopperEmailAddressRequestBody(value))
                        .post(resourceURI).then().extract().response();
                break;
            case "address1":
                response = given().spec(getRequestSpec()).body(setaddress1RequestBody(value))
                        .post(resourceURI).then().extract().response();
                break;
            case "address2":
                response = given().spec(getRequestSpec()).body(setaddress2RequestBody(value))
                        .post(resourceURI).then().extract().response();
                break;
            case "address3":
                response = given().spec(getRequestSpec()).body(setaddress3RequestBody(value))
                        .post(resourceURI).then().extract().response();
                break;
            default:

        }
    }

    @When("Call post method with invalid second {string} and {string} value")
    public void callPostMethodWithInvalidSecondAndValue(String fieldName, String value) throws IOException {
        switch (fieldName) {
            case "postalCode":
                response = given().spec(getRequestSpec()).body(paymentBodypostalCode(value))
                        .post(resourceURI).then().extract().response();
                break;

            case "city":

                response = given().spec(getRequestSpec()).body(setcityRequestBody(value))
                        .post(resourceURI).then().extract().response();
                break;
            case "state":
                response = given().spec(getRequestSpec()).body(paymentBodyState(value))
                        .post(resourceURI).then().extract().response();
                break;
            case "countryCode":
                response = given().spec(getRequestSpec()).body(setcountryCodeRequestBody(value))
                        .post(resourceURI).then().extract().response();
                break;
            default:

        }
    }

    @When("Call post method with second {string} field")
    public void callPostMethodWithSecondField(String fieldName) throws IOException {

        if (fieldName.equalsIgnoreCase("countryCode")) {
            response = given().spec(getRequestSpec()).body(setmissingcountryCodeReqBody())
                    .post(resourceURI).then().extract().response();

        } else if (fieldName.equalsIgnoreCase("currency")) {
            response = given().spec(getRequestSpec()).body(setmissingcurrencyReqBody())
                    .post(resourceURI).then().extract().response();

        } else if (fieldName.equalsIgnoreCase("amount")) {
            response = given().spec(getRequestSpec()).body(missingAmountBody())
                    .post(resourceURI).then().extract().response();

        }
    }

    @When("Call post method with the required amount {string}")
    public void callPostMethodWithTheRequiredAmount(String amt) throws IOException {
        int amount = Integer.parseInt(amt);
        response = given()
                .spec(getRequestSpec())
                .body(setvalidReqBody(amount))
                .post(resourceURI).then().extract().response();
    }

    @When("Call SALE post method with headers {string}")
    public void callPostMethodWithTheRequiredAcceptValue(String accept) throws IOException {
        response = given()
                .spec(getRequestSpec(accept))
                .body(setvalidReqBody(250))
                .post(resourceURI).then().extract().response();

    }


    @When("Call get method with the required amount {string}")
    public void callGetMethodWithTheRequiredAmount(String amt) throws IOException {
        int amount = Integer.parseInt(amt);
        response = given()
                .spec(getRequestSpec())
                .body(setvalidReqBody(amount))
                .get(resourceURI).then().extract().response();

    }

    @And("call paymentQuery get method")
    public void callpaymentQueryGetMethod() throws IOException, InterruptedException, TimeoutException {

        queryData = JsonPath.from(response.asString()).get("_links[\"action:events\"].href").toString().split("events")[1];
        queryEncryptData = JsonPath.from(response.asString()).get("_links[\"action:events\"].href").toString().split("/payments/alternative/action/paypal/events/")[1];

        queryResponse = null;
        int timeout = 20;
        int i = 0;
        while (i < timeout) {
            queryResponse = given()
                    .spec(getQueryRequestSpec())
                    .get(paymentQueryResourceURI(queryData)).then().extract().response();
            if (queryResponse.asString().contains("lastEvent")) {
                break;
            } else {
                TimeUnit.SECONDS.sleep(i);
                ++i;
                if (i == timeout) {
                    throw new TimeoutException("Timedout After Waiting for " + i + " Seconds");
                }
            }
        }
    }

    @And("call paymentQuery post method")
    public void callpaymentQueryPostMethod() throws IOException, InterruptedException, TimeoutException {

        queryData = JsonPath.from(response.asString()).get("_links[\"action:events\"].href").toString().split("events")[1];
        queryResponse = given()
                .spec(getQueryRequestSpec())
                .post(paymentQueryResourceURI(queryData)).then().extract().response();


    }


    @And("call full refund post method")
    public void callFullRefundPostMethod() throws IOException {

        refundResponse = given()
                .spec(getQueryRequestSpec())
                .post(refundResourceURI(queryData)).then().extract().response();

    }

    @And("call full refund get method")
    public void callFullRefundGetMethod() throws IOException {

        refundResponse = given()
                .spec(getQueryRequestSpec())
                .get(refundResourceURI(queryData)).then().extract().response();

    }

    @And("verify whether proper {string} is displayed")
    public void verifyWhetherProperIsGenerated(String expErrorName) {
        String actErrorName = JsonPath.from(queryResponse.asString()).get("lastEvent");
        assertEquals(expErrorName, actErrorName);
    }

    @And("verify whether proper errorname and message is displayed")
    public void verifyWhetherProperErrorNameIsGenerated() {
        String expError = "methodNotAllowed";
        String expMessage = "Requested method is not allowed";
        String actError = JsonPath.from(response.asString()).get("errorName");
        String actMessage = JsonPath.from(response.asString()).get("message");
        Assert.assertEquals(expError, actError);
        Assertions.assertEquals(expMessage, actMessage);
    }

    @And("verify whether proper header errorname and message is displayed")
    public void verifyWhetherProperHeaderErrorNameIsGenerated() {
        String expError = "headerHasInvalidValue";
        String expMessage = "Accept header is missing or not supported";
        String actError = JsonPath.from(response.asString()).get("errorName");
        String actMessage = JsonPath.from(response.asString()).get("message");
        Assert.assertEquals(expMessage, actMessage);
        Assert.assertEquals(expError, actError);
    }

    @And("verify whether proper errorname and message is displayed for Query")
    public void verifyWhetherProperErrorNameIsGeneratedforQuery() {
        String expError = "methodNotAllowed";
        String expMessage = "Requested method is not allowed";
        String actError = JsonPath.from(queryResponse.asString()).get("errorName");
        String actMessage = JsonPath.from(queryResponse.asString()).get("message");
        Assert.assertEquals(expMessage, actMessage);
        Assert.assertEquals(expError, actError);
    }

    @And("verify whether proper errorname and message is displayed for REFUND")
    public void verifyWhetherProperErrorNameIsGeneratedforRefund() {
        String expError = "methodNotAllowed";
        String expMessage = "Requested method is not allowed";
        String actError = JsonPath.from(refundResponse.asString()).get("errorName");
        String actMessage = JsonPath.from(refundResponse.asString()).get("message");
        Assert.assertEquals(expMessage, actMessage);
        Assert.assertEquals(expError, actError);
    }


    @When("Call post method with the required magic amount {string}")
    public void callPostMethodWithTheRequiredMagicAmount(String magicAmount) throws IOException {
        int amount = Integer.parseInt(magicAmount);
        response = given()
                .spec(getRequestSpec())
                .body(setvalidReqBody(amount))
                .post(resourceURI).then().extract().response();

    }

    @And("call paymentQuery get method and save queryData")
    public void callPaymentQueryGetMethodAndSaveQueryData() throws IOException, InterruptedException, TimeoutException {
        queryData = JsonPath.from(response.asString()).get("_links[\"action:events\"].href").toString().split("events")[1];
        queryResponse = null;
        int timeout = 20;
        int i = 0;
        while (i < timeout) {
            queryResponse = given()
                    .spec(getQueryRequestSpec())
                    .get(paymentQueryResourceURI(queryData)).then().extract().response();
            if (queryResponse.asString().contains("lastEvent")) {
                break;
            } else {
                TimeUnit.SECONDS.sleep(i);
                ++i;
                if (i == timeout) {
                    throw new TimeoutException("Timedout After Waiting for " + i + " Seconds");
                }
            }
        }
    }

    @Then("verify the status code {string} and message of the response")
    public void verifyTheStatusCodeAndMessageOfTheResponse(String statuscode) {
        int status = Integer.parseInt(statuscode);

        assertEquals(status, response.getStatusCode(), "Created");

    }


    @Then("verify the status code {string} for REFUND and message of the response")
    public void verifyTheStatusCodeForRefundAndMessageOfTheResponse(String statuscode) throws IOException, InterruptedException, TimeoutException {
        int status = Integer.parseInt(statuscode);

        assertEquals(status, refundResponse.getStatusCode(), "Accepted");

    }

    @And("Verify the sale response header has Timestamp")
    public void verifyTheSaleResponseHeaderHasTimestamp() {
        Headers allheaders = response.headers();
        boolean headerpresent = false;
        for (Header header : allheaders) {
            if (header.getName().equalsIgnoreCase("Time-Stamp")) {
                headerpresent = true;
                break;
            }

        }
        assertTrue(headerpresent);
    }

    @And("Verify the query response header has Timestamp")
    public void verifyTheQueryResponseHeaderHasTimestamp() {
        Headers allheaders = queryResponse.headers();
        boolean headerpresent = false;
        for (Header header : allheaders) {
            if (header.getName().equalsIgnoreCase("Time-Stamp")) {
                headerpresent = true;
                break;
            }

        }
        assertTrue(headerpresent);


    }

    @And("Verify the refund response header has Timestamp")
    public void verifyTheRefundResponseHeaderHasTimestamp() {
        Headers allheaders = refundResponse.headers();
        boolean headerpresent = false;
        for (Header header : allheaders) {
            if (header.getName().equalsIgnoreCase("Time-Stamp")) {
                headerpresent = true;
                break;
            }

        }
        assertTrue(headerpresent);
    }

    @And("Verify the root response header has Timestamp")
    public void verifyTheRootResponseHeaderHasTimestamp() {
        Headers allheaders = rootResponse.headers();
        boolean headerpresent = false;
        for (Header header : allheaders) {
            if (header.getName().equalsIgnoreCase("Time-Stamp")) {
                headerpresent = true;
                break;
            }

        }
        assertTrue(headerpresent);
    }

    @When("call get method to get the root response")
    public void callGetMethodToGetTheRootResponse() throws IOException {
        rootResponse = given()
                .spec(getRequestSpec())
                .get(resourceURI)
                .then().extract().response();

    }

    @And("validate the root response has valid parameters and data")
    public void validateTheRootResponseHasValidParametersAndData() {
        String positiveresponse = rootResponse.getBody().asString();
        assertTrue(positiveresponse.contains("_links"));
        assertTrue(positiveresponse.contains("resourceTree"));
        assertTrue(positiveresponse.contains("action:sale"));
        assertTrue(positiveresponse.contains("action:event"));

        assertTrue(positiveresponse.contains("curies"));

        assertEquals(true, JsonPath.from(rootResponse.asString()).get("_links[\"curies\"][0].templated"));
        assertEquals("action", JsonPath.from(rootResponse.asString()).get("_links[\"curies\"][0].name"));

        if (execEnv().equalsIgnoreCase("localhost")) {
            assertEquals(LOCAL_CURIES, JsonPath.from(rootResponse.asString()).get("_links[\"curies\"][0].href"));
            assertEquals(LOCAL_RESOURCETREE_URL, JsonPath.from(rootResponse.asString()).get("_links[\"resourceTree\"].href"));
            assertEquals(LOCALSALE_URL, JsonPath.from(rootResponse.asString()).get("_links[\"action:sale\"].href"));
            assertEquals(LOCALEVENTS_URL, JsonPath.from(rootResponse.asString()).get("_links[\"action:event\"].href"));
        } else if (execEnv().equalsIgnoreCase("preprod")) {
            assertEquals(PREPROD_CURIES, JsonPath.from(rootResponse.asString()).get("_links[\"curies\"][0].href"));
            assertEquals(PREPROD_RESOURCETREE_URL, JsonPath.from(rootResponse.asString()).get("_links[\"resourceTree\"].href"));
            assertEquals(PREPRODSALE_URL, JsonPath.from(rootResponse.asString()).get("_links[\"action:sale\"].href"));
            assertEquals(PREPRODEVENTS_URL, JsonPath.from(rootResponse.asString()).get("_links[\"action:event\"].href"));
        } else if (execEnv().equalsIgnoreCase("npe")) {
            assertEquals(NPE_CURIES, JsonPath.from(rootResponse.asString()).get("_links[\"curies\"][0].href"));
            assertEquals(NPE_RESOURCETREE_URL, JsonPath.from(rootResponse.asString()).get("_links[\"resourceTree\"].href"));
            assertEquals(NPESALE_URL, JsonPath.from(rootResponse.asString()).get("_links[\"action:sale\"].href"));
            assertEquals(NPE_EVENTS_URL, JsonPath.from(rootResponse.asString()).get("_links[\"action:event\"].href"));
        } else if (execEnv().equalsIgnoreCase("try")) {
            assertEquals(TRY_CURIES, JsonPath.from(rootResponse.asString()).get("_links[\"curies\"][0].href"));
            assertEquals(TRY_RESOURCETREE_URL, JsonPath.from(rootResponse.asString()).get("_links[\"resourceTree\"].href"));
            assertEquals(TRYSALE_URL, JsonPath.from(rootResponse.asString()).get("_links[\"action:sale\"].href"));
            assertEquals(TRY_EVENTS_URL, JsonPath.from(rootResponse.asString()).get("_links[\"action:event\"].href"));
        }
    }

    @Given("Build the resourcetree url with {string}")
    public void buildTheResourcetreeUrlWith(String resource) {
        resourceURI = treeResource() + resource;
    }

    @And("validate the sale response has valid parameters and data")
    public void validateTheSaleResponseHasValidParametersAndData() {
        String positiveresponse = response.getBody().asString();
        System.out.println(positiveresponse);
        assertTrue(positiveresponse.contains("orderId"));
        assertTrue(positiveresponse.contains("outcome"));
        assertTrue(positiveresponse.contains("_links"));
        assertTrue(positiveresponse.contains("action:events"));
        assertTrue(positiveresponse.contains("curies"));
        assertEquals("action", JsonPath.from(response.asString()).get("_links[\"curies\"][0].name"));
        assertEquals(true, JsonPath.from(response.asString()).get("_links[\"curies\"][0].templated"));
        if (execEnv().equalsIgnoreCase("localhost")) {
            assertEquals(LOCAL_CURIES, JsonPath.from(response.asString()).get("_links[\"curies\"][0].href"));
        } else if (execEnv().equalsIgnoreCase("preprod")) {
            assertEquals(PREPROD_CURIES, JsonPath.from(response.asString()).get("_links[\"curies\"][0].href"));
        }

    }


    @And("validate the root response with valid data")
    public void validateTheRootResponseWithValidData() {
        String positiveresponse = rootResponse.getBody().asString();
        assertTrue(positiveresponse.contains("resources"));
        assertEquals("Sale", JsonPath.from(rootResponse.asString()).get("resources[0].name"));
        assertEquals("Full-Refund", JsonPath.from(rootResponse.asString()).get("resources[0][\"children\"][0].name"));
        assertEquals("Events", JsonPath.from(rootResponse.asString()).get("resources[1].name"));

        if (execEnv().equalsIgnoreCase("localhost")) {
            assertEquals(LOCAL_SALEDOC, JsonPath.from(rootResponse.asString()).get("resources[0].href"));
            assertEquals(LOCAL_REFUNDDOC, JsonPath.from(rootResponse.asString()).get("resources[0][\"children\"][0].href"));
            assertEquals(LOCAL_EVENTDOC, JsonPath.from(rootResponse.asString()).get("resources[1].href"));
        } else if (execEnv().equalsIgnoreCase("preprod")) {
            assertEquals(PREPROD_SALEDOC, JsonPath.from(rootResponse.asString()).get("resources[0].href"));
            assertEquals(PREPROD_REFUNDDOC, JsonPath.from(rootResponse.asString()).get("resources[0][\"children\"][0].href"));
            assertEquals(PREPROD_EVENTDOC, JsonPath.from(rootResponse.asString()).get("resources[1].href"));
        } else if (execEnv().equalsIgnoreCase("npe")) {
            assertEquals(NPE_SALEDOC, JsonPath.from(rootResponse.asString()).get("resources[0].href"));
            assertEquals(NPE_REFUNDDOC, JsonPath.from(rootResponse.asString()).get("resources[0][\"children\"][0].href"));
            assertEquals(NPE_EVENTDOC, JsonPath.from(rootResponse.asString()).get("resources[1].href"));
        }


    }

    @And("validate the query response has valid parameters and data")
    public void validateTheQueryResponseHasValidParametersAndData() {

        if (execEnv().equalsIgnoreCase("localhost")) {
            assertEquals(LOCAL_CURIES, JsonPath.from(queryResponse.asString()).get("_links[\"curies\"][0].href"));
        } else if (execEnv().equalsIgnoreCase("preprod")) {
            assertEquals(PREPROD_CURIES, JsonPath.from(queryResponse.asString()).get("_links[\"curies\"][0].href"));
        }
    }

    @And("validate the refund response has valid parameters and data")
    public void validateTheRefundResponseHasValidParametersAndData() {

        if (execEnv().equalsIgnoreCase("localhost")) {
            assertEquals(LOCAL_CURIES, JsonPath.from(refundResponse.asString()).get("_links[\"curies\"][0].href"));
        } else if (execEnv().equalsIgnoreCase("preprod")) {
            assertEquals(PREPROD_CURIES, JsonPath.from(refundResponse.asString()).get("_links[\"curies\"][0].href"));
        }
    }


    @And("validate the root response with valid saledescription")
    public void validateTheRootResponseWithValidSaledescription() {
        String positiveresponse = rootResponse.getBody().asString();
        assertEquals(SALE_DESCRIPTION, JsonPath.from(rootResponse.asString()).get("description"));

    }


    @And("validate the root response with valid refunddescription")
    public void validateTheRootResponseWithValidRefunddescription() {
        String positiveresponse = rootResponse.getBody().asString();

        assertEquals(REFUND_DESCRIPTION, JsonPath.from(rootResponse.asString()).get("description"));

    }


    @And("validate the root response with valid eventdescription")
    public void validateTheRootResponseWithValidEventdescription() {
        String positiveresponse = rootResponse.getBody().asString();

        assertEquals(EVENT_DESCRIPTION, JsonPath.from(rootResponse.asString()).get("description"));

    }

    @When("Call post method with seller protect and the required amount {string}")
    public void callPostMethodWithSellerProtectAndTheRequiredAmount(String amt) throws IOException {
        int amount = Integer.parseInt(amt);
        response = given()
                .spec(getRequestSpec())
                .body(setvalidSellerProtectReqBody(amount))
                .post(resourceURI).then().extract().response();

    }


    @When("Call post method with seller protect second {string} field")
    public void callPostMethodWithSellerProtectSecondField(String fieldName) throws IOException {
        if (fieldName.equalsIgnoreCase("countryCode")) {
            response = given().spec(getRequestSpec()).body(setmissingspcountrycodeReqBody())
                    .post(resourceURI).then().extract().response();

        } else if (fieldName.equalsIgnoreCase("street")) {
            response = given().spec(getRequestSpec()).body(setmissingspstreetReqBody())
                    .post(resourceURI).then().extract().response();

        } else if (fieldName.equalsIgnoreCase("postalCode")) {
            response = given().spec(getRequestSpec()).body(setmissingsppostalcodeReqBody())
                    .post(resourceURI).then().extract().response();

        }
    }

    @When("Call post method with seller protect invalid second {string} and {string} value")
    public void callPostMethodWithSellerProtectInvalidSecondAndValue(String fieldName, String value) throws IOException {
        switch (fieldName) {
            case "postalCode":
                response = given().spec(getRequestSpec()).body(setsppostalcodeReqBody(value))
                        .post(resourceURI).then().extract().response();
                break;
            case "city":
                response = given().spec(getRequestSpec()).body(setspcityReqBody(value))
                        .post(resourceURI).then().extract().response();
                break;
            case "street":
                response = given().spec(getRequestSpec()).body(setspstreetReqBody(value))
                        .post(resourceURI).then().extract().response();
                break;
            case "countryCode":
                response = given().spec(getRequestSpec()).body(setspcountrycodeReqBody(value))
                        .post(resourceURI).then().extract().response();
                break;
            default:

        }
    }


    @And("validate the partialRefund link in response")
    public void validateThePartialRefundLinkInResponse() {
        assertEquals(PARTIAL_REFUND_URL + queryEncryptData, JsonPath.from(queryResponse.asString()).get("_links[\"action:partialRefund\"].href"));

    }

    @And("Verify the query reponse has partialRefund link")
    public void VerifyTheQueryReponseHasPartialRefundLink() {
        String partialrefund = queryResponse.getBody().asString();
        assertTrue(partialrefund.contains("action:partialRefund"));
    }

    @And("call partial refund post method")
    public void callPartialRefundPostMethod() throws IOException {

        refundResponse = given()
                .spec(getQueryRequestSpec())
                .body(setvalidPartialReqestbody())
                .post(partialrefundResourceURI(queryData)).then().extract().response();
    }

    @And("Verify partial refund response had valid parameters and data")
    public void verifyPartialRefundResponseHadValidParametersAndData() {
        String partialrefundresponse = refundResponse.getBody().asString();
        assertTrue(partialrefundresponse.contains("_links"));
        assertEquals("action", JsonPath.from(response.asString()).get("_links[\"curies\"][0].name"));
        assertEquals(true, JsonPath.from(response.asString()).get("_links[\"curies\"][0].templated"));
        if (execEnv().equalsIgnoreCase("localhost")) {
            assertEquals(LOCAL_CURIES, JsonPath.from(response.asString()).get("_links[\"curies\"][0].href"));
        } else if (execEnv().equalsIgnoreCase("preprod")) {
            assertEquals(PREPROD_CURIES, JsonPath.from(response.asString()).get("_links[\"curies\"][0].href"));
        }
    }

    @And("call partial refund post method with amount {string}")
    public void callPartialRefundPostMethodWithamount(String amount) throws IOException {
        int amt = Integer.parseInt(amount);
        refundResponse = given()
                .spec(getQueryRequestSpec())
                .body(setamountPartialRefundbody(amt))
                .post(partialrefundResourceURI(queryData)).then().extract().response();
    }

    @Given("Build the partial refund url with {string}")
    public void buildThePartialRefundUrlWith(String resource) {

        String token = "TVRBx6KLHxuMKiWY9AThRGqtYpertEyjf5MGw526BmyJfRE0dmU1GSutpRiPoR-g";

        resourceURI = payResource() + resource + token;
        //System.out.println(resourceURI);

    }

    @When("Call partial refund post method with second {string} field")
    public void callPartialRefundPostMethodWithSecondField(String fieldName) throws IOException {

            if (fieldName.equalsIgnoreCase("reference")) {
                response = given().spec(getRequestSpec()).body(referencemissingRefundbody())
                        .post(resourceURI).then().extract().response();

            } else if (fieldName.equalsIgnoreCase("currency")) {
                response = given().spec(getRequestSpec()).body(currencymissingRefundbody())
                        .post(resourceURI).then().extract().response();

            } else if (fieldName.equalsIgnoreCase("amount")) {
                response = given().spec(getRequestSpec()).body(amountmissingRefundbody())
                        .post(resourceURI).then().extract().response();

            }
        }

    @When("Call post method with invalid partial refund {string} and {string} value")
    public void callPostMethodWithInvalidPartialRefundAndValue(String fieldName, String value) throws IOException {
        switch (fieldName) {
            case "amount":
                int amt = Integer.parseInt(value);
                response = given().spec(getRequestSpec()).body(setamountPartialRefundbody(amt))
                        .post(resourceURI).then().extract().response();
                break;

            case "currency":

                response = given().spec(getRequestSpec()).body(setCurrencyinRefundbody(value))
                        .post(resourceURI).then().extract().response();
                break;
            case "reference":
                response = given().spec(getRequestSpec()).body(setReferenceinRefundbody(value))
                        .post(resourceURI).then().extract().response();
                break;
            default:

    }

    }

    @When("Call post method with the currency {string} code")
    public void callPostMethodWithTheCurrencyCode(String value) throws IOException {

        response = given().spec(getRequestSpec()).body(setSupportedCurrencyRequestbody(value))
                .post(resourceURI).then().extract().response();
    }

    @And("call partial refund post method with the currency {string} code")
    public void callPartialRefundPostMethodWithTheCurrencyCode(String value) throws IOException {

        refundResponse = given().spec(getRequestSpec()).body(setCurrencyinRefundbody(value))
                .post(partialrefundResourceURI(queryData)).then().extract().response();
    }

    @When("Call post method with no billing address")
    public void callPostMethodWithNoBillingAddress() throws IOException {
         response = given()
                    .spec(getRequestSpec())
                    .body(setReqBodywithNoBillingAddress())
                    .post(resourceURI).then().extract().response();
        }

    @And("validate the hostname in response")
    public void validateTheHostnameInResponse() {
        String positiveresponse = response.getBody().asString();
        assertTrue(positiveresponse.contains("action:events"));
        assertTrue(positiveresponse.contains("curies"));
        queryData = JsonPath.from(response.asString()).get("_links[\"action:events\"].href").toString().split("events")[1];

        if (execEnv().equalsIgnoreCase("localhost")) {
            assertEquals(LOCALEVENTS_URL + queryData, JsonPath.from(response.asString()).get("_links[\"action:events\"].href"));
       } else if (execEnv().equalsIgnoreCase("preprod")) {
            assertEquals(PREPRODEVENTS_URL + queryData, JsonPath.from(response.asString()).get("_links[\"action:events\"].href"));
        }

    }
}



