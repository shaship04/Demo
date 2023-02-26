package com.sale.generic;

import com.configuration.RandomUtils;
import com.sale.pojo.*;
import org.apache.commons.lang3.RandomStringUtils;

public class ConstantUtils extends RandomUtils {

    public static final String ENTITY = "default-FR";
    public static final String LOCAL_RESOURCETREE_URL = PAYPAL_LOCALHOST_URL + "/rels" + PAYPAL_URL + "resourceTree";
    public static final String PREPROD_RESOURCETREE_URL = PAYPAL_PREPROD_URL + "/rels" + PAYPAL_URL + "resourceTree";
    public static final String NPE_RESOURCETREE_URL = PAYPAL_NPE_URL + "/rels" + PAYPAL_URL + "resourceTree";
    public static final String LOCALSALE_URL = PAYPAL_LOCALHOST_URL + PAYPAL_URL + "sale";
    public static final String LOCALEVENTS_URL = PAYPAL_LOCALHOST_URL + PAYPAL_URL + "events";
    public static final String PREPRODSALE_URL = PAYPAL_PREPROD_URL + PAYPAL_URL + "sale";
    public static final String PREPRODEVENTS_URL = PAYPAL_PREPROD_URL + PAYPAL_URL + "events";
    public static final String LOCAL_CURIES = PAYPAL_LOCALHOST_URL + "/rels" + PAYPAL_URL + "{rel}";
    public static final String PREPROD_CURIES = PAYPAL_PREPROD_URL + "/rels" + PAYPAL_URL + "{rel}";
    public static final String NPE_CURIES = PAYPAL_NPE_URL + "/rels" + PAYPAL_URL + "{rel}";
    public static final String NPESALE_URL = PAYPAL_NPE_URL + PAYPAL_URL + "sale";
    public static final String NPE_EVENTS_URL = PAYPAL_NPE_URL + PAYPAL_URL + "events";
    public static final String LOCAL_SALEDOC = PAYPAL_LOCALHOST_URL + "/rels" + PAYPAL_URL + "sale";
    public static final String LOCAL_REFUNDDOC = PAYPAL_LOCALHOST_URL + "/rels" + PAYPAL_URL + "refund";
    public static final String LOCAL_EVENTDOC = PAYPAL_LOCALHOST_URL + "/rels" + PAYPAL_URL + "events";
    public static final String PREPROD_SALEDOC = PAYPAL_PREPROD_URL + "/rels" + PAYPAL_URL + "sale";
    public static final String PREPROD_REFUNDDOC = PAYPAL_PREPROD_URL + "/rels" + PAYPAL_URL + "refund";
    public static final String PREPROD_EVENTDOC = PAYPAL_PREPROD_URL + "/rels" + PAYPAL_URL + "events";
    public static final String NPE_SALEDOC = PAYPAL_NPE_URL + "/rels" + PAYPAL_URL + "sale";
    public static final String NPE_REFUNDDOC = PAYPAL_NPE_URL + "/rels" + PAYPAL_URL + "refund";
    public static final String NPE_EVENTDOC = PAYPAL_NPE_URL + "/rels" + PAYPAL_URL + "events";
    public static final String SALE_DESCRIPTION = "Perform a paypal sale request.";
    public static final String REFUND_DESCRIPTION = "Perform a paypal refund request for successful transaction";
    public static final String EVENT_DESCRIPTION = "Paypal event query.";
    public static final String TRY_RESOURCETREE_URL = PAYPAL_TRY_URL + "/rels" + PAYPAL_URL + "resourceTree";
    public static final String TRY_CURIES = PAYPAL_TRY_URL + "/rels" + PAYPAL_URL + "{rel}";
    public static final String TRYSALE_URL = PAYPAL_TRY_URL + PAYPAL_URL + "sale";
    public static final String TRY_EVENTS_URL = PAYPAL_TRY_URL + PAYPAL_URL + "events";
    public static final String TRY_SALEDOC = PAYPAL_TRY_URL + "/rels" + PAYPAL_URL + "sale";
    public static final String TRY_REFUNDDOC = PAYPAL_TRY_URL + "/rels" + PAYPAL_URL + "refund";
    public static final String TRY_EVENTDOC = PAYPAL_TRY_URL + "/rels" + PAYPAL_URL + "events";
    public static final String PARTIAL_REFUND_URL = PAYPAL_URL + "refunds/partials/";

    public String transactionReference;

    public String paymentBodyState(String value) {

        return "{\n"
                + "    \"transactionReference\": \"jkhyldf54yttjg\",\n"
                + "    \"merchant\": {\n"
                + "        \"entity\": \"an-entity\"\n"
                + "    },\n"
                + "    \"instruction\": {\n"
                + "        \"description\": {\n"
                + "            \"line1\": \"trading name\"\n"
                + "        },\n"
                + "        \"paymentInstrument\": {\n"
                + "            \"type\": \"PAYPAL\",\n"
                + "            \"billingAddress\": {\n"
                + "                \"firstName\": \"John\",\n"
                + "                \"lastName\": \"Johnson\",\n"
                + "                \"shopperEmailAddress\":\"email@email.com\",\n"
                + "                \"address1\": \"8500 Govenors Hill Drive\",\n"
                + "                \"address2\": \"Symmes Township\",\n"
                + "                \"address3\": \"Tamilnadu\",\n"
                + "                \"postalCode\": \"45249\",\n"
                + "                \"city\": \"Ohio\",\n"
                + "                \"state\": \"" + value + "\",\n"
                + "                \"countryCode\": \"US\"\n"
                + "            }\n"
                + "        },\n"
                + "        \"value\": {\n"
                + "            \"currency\": \"GBP\",\n"
                + "            \"amount\": 250\n"
                + "        }\n"
                + "    }\n"
                + "}";

    }

    public String paymentBodypostalCode(String value) {

        return "{\n"
                + "    \"transactionReference\": \"jkhyldf54yttjg\",\n"
                + "    \"merchant\": {\n"
                + "        \"entity\": \"an-entity\"\n"
                + "    },\n"
                + "    \"instruction\": {\n"
                + "        \"description\": {\n"
                + "            \"line1\": \"trading name\"\n"
                + "        },\n"
                + "        \"paymentInstrument\": {\n"
                + "            \"type\": \"PAYPAL\",\n"
                + "            \"billingAddress\": {\n"
                + "                \"firstName\": \"John\",\n"
                + "                \"lastName\": \"Johnson\",\n"
                + "                \"shopperEmailAddress\":\"email@email.com\",\n"
                + "                \"address1\": \"8500 Govenors Hill Drive\",\n"
                + "                \"address2\": \"Symmes Township\",\n"
                + "                \"address3\": \"Tamilnadu\",\n"
                + "                \"postalCode\": \"" + value + "\",\n"
                + "                \"city\": \"Ohio\",\n"
                + "                \"state\": \"TEXAS\",\n"
                + "                \"countryCode\": \"US\"\n"
                + "            }\n"
                + "        },\n"
                + "        \"value\": {\n"
                + "            \"currency\": \"GBP\",\n"
                + "            \"amount\": 250\n"
                + "        }\n"
                + "    }\n"
                + "}";

    }

    public String missingAmountBody() {
        return "{\n"
                + "    \"transactionReference\": \"testingzbcdges6754\",\n"
                + "    \"merchant\": {\n"
                + "        \"entity\": \"an-entity\"\n"
                + "    },\n"
                + "    \"instruction\": {\n"
                + "        \"description\": {\n"
                + "            \"line1\": \"trading name\"\n"
                + "        },\n"
                + "        \"paymentInstrument\": {\n"
                + "            \"type\": \"PAYPAL\",\n"
                + "            \"billingAddress\": {\n"
                + "                \"firstName\": \"John\",\n"
                + "                \"lastName\": \"Johnson\",\n"
                + "                \"shopperEmailAddress\":\"email@email.com\",\n"
                + "                \"address1\": \"8500 Govenors Hill Drive\",\n"
                + "                \"address2\": \"Symmes Township\",\n"
                + "                \"address3\": \"Tamilnadu\",\n"
                + "                \"postalCode\": \"45249\",\n"
                + "                \"city\": \"Ohio\",\n"
                + "                \"state\": \"TEXAS\",\n"
                + "                \"countryCode\": \"US\"\n"
                + "            }\n"
                + "        },\n"
                + "        \"value\": {\n"
                + "            \"currency\": \"GBP\"\n"
                + "        }\n"
                + "    }\n"
                + "}";
    }

    public String amountmissingRefundbody() {
        return "{\n"
                + "\"value\": {\n"
                + "\"currency\": \"GBP\"\n"
                + "\n"
                + "},\n"
                + "\"reference\": \"partial-refund-reference\"\n"
                + "}";
    }


    public MerchantRequest setvalidReqBody() {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(8));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setvalidReqBody(int amt) {
        transactionReference = RandomStringUtils.randomAlphanumeric(11);
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(amt);
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(ENTITY);
        rbody.setTransactionReference(transactionReference);
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setTransRequestBody(String transValue) {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(6));
        rbody.setTransactionReference(transValue);
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setEntityRequestBody(String entityValue) {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(entityValue);
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setLine1TransRequestBody(String line1Value) {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(line1Value);
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(6));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }


    public MerchantRequest setCurrencyRequestBody(String currencyValue) {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency(currencyValue);
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(6));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setAmountRequestBody(String amountValue) {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(amountValue));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(6));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setTypeRequestBody(String type) {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType(type);
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(6));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setfirstNameRequestBody(String firstName) {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(firstName);
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(6));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setlastNameRequestBody(String lastName) {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(lastName);
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(6));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setshopperEmailAddressRequestBody(String shopperEmailAddress) {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(shopperEmailAddress);
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(6));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setaddress1RequestBody(String address1) {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setAddress1(address1);
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(6));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setaddress2RequestBody(String address2) {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(address2);
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(6));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setaddress3RequestBody(String address3) {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(address3);
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(6));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setpostalCodeRequestBody(String postalCode) {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setpostalCode(postalCode);
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(6));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setcityRequestBody(String city) {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity(city);
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(6));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setstateRequestBody(String state) {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState(state);
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(6));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setcountryCodeRequestBody(String countryCode) {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode(countryCode);
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(6));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setmissingtransrefReqBody() {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(8));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setmissingentityReqBody() {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setmissingline1ReqBody() {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(8));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setmissingtypeReqBody() {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(8));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setmissingMailReqBody() {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(8));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setmissingaddress1ReqBody() {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(8));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setmissingpostalCodeReqBody() {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(8));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setmissingcityReqBody() {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(8));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setmissingstateReqBody() {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(8));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setmissingcountryCodeReqBody() {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(8));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setmissingcurrencyReqBody() {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(8));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setmissingamountReqBody() {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(8));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setvalidSellerProtectReqBody(int amt) {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        shippingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        shippingAddress.setPostalCode(RandomStringUtils.randomNumeric(5));
        shippingAddress.setStreet(RandomStringUtils.randomAlphanumeric(10));
        shippingAddress.setState("OHIO");
        shippingAddress.setCity("Texas");
        shippingAddress.setCountryCode("US");
        value.setAmount(amt);
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        paymentInstrument.setShippingAddress(shippingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(ENTITY);
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setmissingspcountrycodeReqBody() {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        shippingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        shippingAddress.setPostalCode(RandomStringUtils.randomNumeric(5));
        shippingAddress.setStreet(RandomStringUtils.randomAlphanumeric(10));
        shippingAddress.setState("OHIO");
        shippingAddress.setCity("Texas");
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        paymentInstrument.setShippingAddress(shippingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(6));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setmissingspstreetReqBody() {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        shippingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        shippingAddress.setPostalCode(RandomStringUtils.randomNumeric(5));
        shippingAddress.setState("OHIO");
        shippingAddress.setCity("Texas");
        shippingAddress.setCountryCode("US");
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        paymentInstrument.setShippingAddress(shippingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(6));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setmissingsppostalcodeReqBody() {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        shippingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        shippingAddress.setStreet(RandomStringUtils.randomAlphanumeric(10));
        shippingAddress.setState("OHIO");
        shippingAddress.setCity("Texas");
        shippingAddress.setCountryCode("US");
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        paymentInstrument.setShippingAddress(shippingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(6));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setsppostalcodeReqBody(String postalCode) {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        shippingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        shippingAddress.setStreet(RandomStringUtils.randomAlphanumeric(10));
        shippingAddress.setState("OHIO");
        shippingAddress.setPostalCode(postalCode);
        shippingAddress.setCity("Texas");
        shippingAddress.setCountryCode("US");
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        paymentInstrument.setShippingAddress(shippingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(6));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setspstreetReqBody(String street) {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        shippingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        shippingAddress.setStreet(street);
        shippingAddress.setState("OHIO");
        shippingAddress.setPostalCode(RandomStringUtils.randomNumeric(5));
        shippingAddress.setCity("Texas");
        shippingAddress.setCountryCode("US");
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        paymentInstrument.setShippingAddress(shippingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(6));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setspcountrycodeReqBody(String countryCode) {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        shippingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        shippingAddress.setStreet(RandomStringUtils.randomAlphanumeric(10));
        shippingAddress.setState("OHIO");
        shippingAddress.setPostalCode(RandomStringUtils.randomNumeric(5));
        shippingAddress.setCity("Texas");
        shippingAddress.setCountryCode(countryCode);
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        paymentInstrument.setShippingAddress(shippingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(6));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setspcityReqBody(String city) {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        shippingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        shippingAddress.setStreet(RandomStringUtils.randomAlphanumeric(10));
        shippingAddress.setState("OHIO");
        shippingAddress.setPostalCode(RandomStringUtils.randomNumeric(5));
        shippingAddress.setCity(city);
        shippingAddress.setCountryCode("US");
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        paymentInstrument.setShippingAddress(shippingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(RandomStringUtils.randomAlphabetic(6));
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public MerchantRequest setSupportedCurrencyRequestbody(String currencyValue) {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        BillingAddress billingAddress = new BillingAddress();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(1000);
        value.setCurrency(currencyValue);
        billingAddress.setFirstName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setLastName(RandomStringUtils.randomAlphabetic(5));
        billingAddress.setShopperEmailAddress(RandomStringUtils.randomAlphanumeric(6) + "@email.com");
        billingAddress.setAddress1(RandomStringUtils.randomAlphanumeric(10));
        billingAddress.setAddress2(RandomStringUtils.randomAlphanumeric(11));
        billingAddress.setAddress3(RandomStringUtils.randomAlphanumeric(14));
        billingAddress.setpostalCode(RandomStringUtils.randomNumeric(5));
        billingAddress.setCity("Texas");
        billingAddress.setState("OHIO");
        billingAddress.setCountryCode("US");
        paymentInstrument.setType("PAYPAL");
        paymentInstrument.setBillingAddress(billingAddress);
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(ENTITY);
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }

    public PartialRefundRequest setvalidPartialReqestbody() {
        PartialRefundRequest prbody = new PartialRefundRequest();
        Value value = new Value();
        value.setAmount(200);
        value.setCurrency("GBP");
        prbody.setReference("partial-refund-reference");
        prbody.setValue(value);
        return prbody;
    }

    public PartialRefundRequest setamountPartialRefundbody(int amount) {
        PartialRefundRequest prbody = new PartialRefundRequest();
        Value value = new Value();
        value.setAmount(amount);
        value.setCurrency("GBP");
        prbody.setReference("partial-refund-reference");
        prbody.setValue(value);
        return prbody;
    }

    public PartialRefundRequest currencymissingRefundbody() {
        PartialRefundRequest prbody = new PartialRefundRequest();
        Value value = new Value();
        value.setAmount(200);
        prbody.setReference("partial-refund-reference");
        prbody.setValue(value);
        return prbody;
    }

    public PartialRefundRequest setCurrencyinRefundbody(String currency) {
        PartialRefundRequest prbody = new PartialRefundRequest();
        Value value = new Value();
        value.setAmount(200);
        value.setCurrency(currency);
        prbody.setReference("partial-refund-reference");
        prbody.setValue(value);
        return prbody;
    }

    public PartialRefundRequest referencemissingRefundbody() {
        PartialRefundRequest prbody = new PartialRefundRequest();
        Value value = new Value();
        value.setAmount(200);
        value.setCurrency("GBP");
        prbody.setValue(value);
        return prbody;
    }

    public PartialRefundRequest setReferenceinRefundbody(String reference) {
        PartialRefundRequest prbody = new PartialRefundRequest();
        Value value = new Value();
        value.setAmount(200);
        value.setCurrency("GBP");
        prbody.setReference(reference);
        prbody.setValue(value);
        return prbody;
    }

    public MerchantRequest setReqBodywithNoBillingAddress() {
        MerchantRequest rbody = new MerchantRequest();
        Merchant merchant = new Merchant();
        Instruction instruction = new Instruction();
        Description description = new Description();
        Payment payment = new Payment();
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        Value value = new Value();
        value.setAmount(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        value.setCurrency("GBP");
        paymentInstrument.setType("PAYPAL");
        description.setLine1(RandomStringUtils.randomAlphanumeric(8));
        instruction.setDescription(description);
        instruction.setPaymentInstrument(paymentInstrument);
        instruction.setValue(value);
        merchant.setEntity(ENTITY);
        rbody.setTransactionReference(RandomStringUtils.randomAlphanumeric(11));
        rbody.setMerchant(merchant);
        rbody.setInstruction(instruction);
        return rbody;
    }


}
