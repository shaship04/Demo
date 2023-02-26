package com.configuration;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

public class RandomUtils {

    Properties prop;
    Base64.Decoder decoder;
    PreemptiveBasicAuthScheme auth;
    BasicAuth basicAuth;

    public static final String PAYPAL_URL = "/payments/alternative/action/paypal/";
    public static final String PAYPAL_LOCALHOST_URL = "http://localhost:8082";
    public static final String PAYPAL_PREPROD_URL = "https://preprod.access.worldpay.com";
    public static final String PAYPAL_NPE_URL = "https://npe.access.worldpay.com";
    public static final String PAYPAL_TRY_URL = "https://try.access.worldpay.com";
    public static final String PAYPAL_GKOP_URL = "https://apm-paypal-apm-paypal.apps.eu-west-2-tb1gr.stage.msp.worldpay.io";

    public String npeURL() {
        return PAYPAL_NPE_URL;
    }

    public String localHostURL() {
        return PAYPAL_LOCALHOST_URL;
    }

    public String preprodURL() {
        return PAYPAL_PREPROD_URL;
    }

    public String gkopURL() {
        return PAYPAL_GKOP_URL;
    }

    public String payResource() {
        return PAYPAL_URL;
    }

    public String tryURL() {
        return PAYPAL_TRY_URL;
    }


    public String treeResource() {
        return "rels" + PAYPAL_URL;
    }

    public String paymentQueryResourceURI(String queryData) {
        return PAYPAL_URL + "events" + queryData;
    }

    public String refundResourceURI(String queryData) {
        return PAYPAL_URL + "refunds/full" + queryData;
    }

    public String partialrefundResourceURI(String queryData) {
        return PAYPAL_URL + "refunds/partials" + queryData;
    }


    public String execEnv() {
        if (System.getProperty("env") != null) {
            return System.getProperty("env");
        } else {
            return prop.getProperty("execution.environment");
        }
    }

    public RequestSpecification getRequestSpec() throws IOException {
        decoder = Base64.getMimeDecoder();
        prop = new Properties();
        auth = new PreemptiveBasicAuthScheme();
        basicAuth = new BasicAuth();
        FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "//configuration//config.properties");
        prop.load(objfile);
        RandomUtils util = new RandomUtils();
        String npeUsername = basicAuth.npeUsername();
        String npePassword = basicAuth.npePassword();
        String preprodUsername = basicAuth.preprodUsername();
        String preprodPassword = basicAuth.preprodPassword();
        String tryUsername = basicAuth.tryUsername();
        String tryPassword = basicAuth.tryPassword();

        if (execEnv().equalsIgnoreCase("localhost")) {
            return new RequestSpecBuilder().setBaseUri(localHostURL())
                    .addHeader("Authorization", authorizationHeaderValue())
                    .addHeader("wp-correlationid", "testingArun1")
                    .addHeader("Content-type", "application/vnd.worldpay.paypal-v1+json")
                    .addHeader("Accept", "application/vnd.worldpay.paypal-v1+json")
                    .build();
        } else if (execEnv().equalsIgnoreCase("npe")) {
            auth.setUserName(npeUsername);
            auth.setPassword(npePassword);
            return new RequestSpecBuilder().setBaseUri(npeURL())
                    .setProxy("proxy.worldpay.local", 8080)
                    .addHeader("Content-type", "application/vnd.worldpay.paypal-v1+json")
                    .addHeader("Accept", "application/vnd.worldpay.paypal-v1+json")
                    .setRelaxedHTTPSValidation()
                    .setAuth(auth).build();
        } else if (execEnv().equalsIgnoreCase("preprod")) {
            auth.setUserName(preprodUsername);
            auth.setPassword(preprodPassword);
            return new RequestSpecBuilder().setBaseUri(preprodURL())
                    .setProxy("proxy.worldpay.local", 8080)
                    .addHeader("Content-type", "application/vnd.worldpay.paypal-v1+json")
                    .addHeader("Accept", "application/vnd.worldpay.paypal-v1+json")
                    .setRelaxedHTTPSValidation()
                    .setAuth(auth).build();
        } else if (execEnv().equalsIgnoreCase("try")) {
            auth.setUserName(tryUsername);
            auth.setPassword(tryPassword);
            return new RequestSpecBuilder().setBaseUri(tryURL())
                    .setProxy("proxy.worldpay.local", 8080)
                    .addHeader("Content-type", "application/vnd.worldpay.paypal-v1+json")
                    .addHeader("Accept", "application/vnd.worldpay.paypal-v1+json")
                    .setRelaxedHTTPSValidation()
                    .setAuth(auth).build();
        }
        if (execEnv().equalsIgnoreCase("gkop")) {
            return new RequestSpecBuilder().setBaseUri(gkopURL())
                    .addHeader("Authorization", authorizationHeaderValue())
                    .addHeader("wp-correlationid", "testingArun1")
                    .addHeader("Content-type", "application/vnd.worldpay.paypal-v1+json")
                    .addHeader("Accept", "application/vnd.worldpay.paypal-v1+json")
                    .build();
        }

        return new RequestSpecBuilder().build();
    }

    public RequestSpecification getRequestSpec(String accept) throws IOException {
        decoder = Base64.getMimeDecoder();
        prop = new Properties();
        auth = new PreemptiveBasicAuthScheme();
        basicAuth = new BasicAuth();
        FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "//configuration//config.properties");
        prop.load(objfile);
        RandomUtils util = new RandomUtils();
        String npeUsername = basicAuth.npeUsername();
        String npePassword = basicAuth.npePassword();
        String preprodUsername = basicAuth.preprodUsername();
        String preprodPassword = basicAuth.preprodPassword();
        String tryUsername = basicAuth.tryUsername();
        String tryPassword = basicAuth.tryPassword();

        if (execEnv().equalsIgnoreCase("localhost")) {
            return new RequestSpecBuilder().setBaseUri(localHostURL())
                    .addHeader("Authorization", authorizationHeaderValue())
                    .addHeader("wp-correlationid", "testingArun1")
                    .addHeader("Content-type", "application/vnd.worldpay.paypal-v1+json")
                    .addHeader("Accept", accept)
                    .build();
        } else if (execEnv().equalsIgnoreCase("npe")) {
            auth.setUserName(npeUsername);
            auth.setPassword(npePassword);
            return new RequestSpecBuilder().setBaseUri(npeURL())
                    .setProxy("proxy.worldpay.local", 8080)
                    .addHeader("Content-type", "application/vnd.worldpay.paypal-v1+json")
                    .addHeader("Accept", accept)
                    .setRelaxedHTTPSValidation()
                    .setAuth(auth).build();
        } else if (execEnv().equalsIgnoreCase("preprod")) {
            auth.setUserName(preprodUsername);
            auth.setPassword(preprodPassword);
            return new RequestSpecBuilder().setBaseUri(preprodURL())
                    .setProxy("proxy.worldpay.local", 8080)
                    .addHeader("Content-type", "application/vnd.worldpay.paypal-v1+json")
                    .addHeader("Accept", accept)
                    .setRelaxedHTTPSValidation()
                    .setAuth(auth).build();
        } else if (execEnv().equalsIgnoreCase("try")) {
            auth.setUserName(tryUsername);
            auth.setPassword(tryPassword);
            return new RequestSpecBuilder().setBaseUri(tryURL())
                    .setProxy("proxy.worldpay.local", 8080)
                    .addHeader("Content-type", "application/vnd.worldpay.paypal-v1+json")
                    .addHeader("Accept", accept)
                    .setRelaxedHTTPSValidation()
                    .setAuth(auth).build();
        }
        if (execEnv().equalsIgnoreCase("gkop")) {
            return new RequestSpecBuilder().setBaseUri(gkopURL())
                    .addHeader("Authorization", authorizationHeaderValue())
                    .addHeader("wp-correlationid", "testingArun1")
                    .addHeader("Content-type", "application/vnd.worldpay.paypal-v1+json")
                    .addHeader("Accept", accept)
                    .build();
        }

            return new RequestSpecBuilder().build();
    }


    public RequestSpecification getQueryRequestSpec() throws IOException {
        decoder = Base64.getMimeDecoder();
        prop = new Properties();
        auth = new PreemptiveBasicAuthScheme();
        basicAuth = new BasicAuth();
        FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "//configuration//config.properties");
        prop.load(objfile);
        RandomUtils util = new RandomUtils();
        String npeUsername = basicAuth.npeUsername();
        String npePassword = basicAuth.npePassword();
        String preprodUsername = basicAuth.preprodUsername();
        String preprodPassword = basicAuth.preprodPassword();
        String tryUsername = basicAuth.tryUsername();
        String tryPassword = basicAuth.tryPassword();

        if (execEnv().equalsIgnoreCase("localhost")) {
            return new RequestSpecBuilder().setBaseUri(localHostURL())
                    .addHeader("Authorization", authorizationHeaderValue())
                    .addHeader("wp-correlationid", "testing123")
                    .addHeader("Content-type", "application/vnd.worldpay.paypal-v1+json")
                    .addHeader("Accept", "application/vnd.worldpay.paypal-v1+json")
                    .build();

        } else if (execEnv().equalsIgnoreCase("npe")) {
            auth.setUserName(npeUsername);
            auth.setPassword(npePassword);
            return new RequestSpecBuilder().setBaseUri(npeURL())
                    .setProxy("proxy.worldpay.local", 8080)
                    .addHeader("Content-type", "application/vnd.worldpay.paypal-v1+json")
                    .addHeader("Accept", "application/vnd.worldpay.paypal-v1+json")
                    .setRelaxedHTTPSValidation()
                    .setAuth(auth).build();

        } else if (execEnv().equalsIgnoreCase("preprod")) {
            auth.setUserName(preprodUsername);
            auth.setPassword(preprodPassword);
            return new RequestSpecBuilder().setBaseUri(preprodURL())
                    .setProxy("proxy.worldpay.local", 8080)
                    .addHeader("Content-type", "application/vnd.worldpay.paypal-v1+json")
                    .addHeader("Accept", "application/vnd.worldpay.paypal-v1+json")
                    .setRelaxedHTTPSValidation()
                    .setAuth(auth).build();
        } else if (execEnv().equalsIgnoreCase("try")) {
            auth.setUserName(tryUsername);
            auth.setPassword(tryPassword);
            return new RequestSpecBuilder().setBaseUri(tryURL())
                    .setProxy("proxy.worldpay.local", 8080)
                    .addHeader("Content-type", "application/vnd.worldpay.paypal-v1+json")
                    .addHeader("Accept", "application/vnd.worldpay.paypal-v1+json")
                    .setRelaxedHTTPSValidation()
                    .setAuth(auth).build();
        }
        if (execEnv().equalsIgnoreCase("gkop")) {
            return new RequestSpecBuilder().setBaseUri(gkopURL())
                    .addHeader("Authorization", authorizationHeaderValue())
                    .addHeader("wp-correlationid", "testingArun1")
                    .addHeader("Content-type", "application/vnd.worldpay.paypal-v1+json")
                    .addHeader("Accept", "application/vnd.worldpay.paypal-v1+json")
                    .build();
        }
            return new RequestSpecBuilder().build();

    }


    public String authorizationHeaderValue() {
        return "Bearer eyJraWQiOiJmYWtlLWVkZ2UtYXV0aCIsIng1YyI6WyJMUzB0TFMxQ1JVZEpUaUJEUlZKVVNVWkpRMEZVUlMwdEx"
                + "TMHRDazFKU1VOeWVrTkRRVnBqUTBGb1FVSk5RVEJIUTFOeFIxTkpZak5FVVVWQ1EzZFZRVTFEVVhoSmFrRm5RbWRPVmtKQ"
                + "lRVMUhWMVpyV2pKVmRGbFlWakFLWVVNeGNHSnVVbXhqYlRGc1drZHNhR1JIVlhSWk1rVjNTVUpqVGsxcVFYZE9ha1UwVFZS"
                + "RmQwMVVUWGhYYUdkUVRYcEJlRTlVUlhkTmFrRjRUVlJCZUFwTmVrWmhUVUpSZUVWcVFWRkNaMDVXUWtGTlRVTlhWbXRhTWxW"
                + "MFdWaFdNR0ZFUTBOQlUwbDNSRkZaU2t0dldrbG9kbU5PUVZGRlFrSlJRVVJuWjBWUUNrRkVRME5CVVc5RFoyZEZRa0ZQY1VKU"
                + "E9XbHdkRk5KYjFGVFpYUlFiakV3UWxGbU0zZG5UVVZ1VlN0dFExQlNSRGxCU0ZJeFJVUjNhV050VDNSclMyd0thVUV2UVM4NFU"
                + "yMDVhamd4VkdKaWNUbDBkMW8zTUhGSGFEYzVUa3gzVUZaNU0yMVRSamcwU0V0dllWcFFOazFPY0hKSVR6QkZhWGx1Vm5wTWIwZG"
                + "tXUXBCZGxjeEsyTlZUVk00YTAxb1JqVXZkV3A1Tm1oSk5HOUpjVzgzZEhkNmVWWnRjRWx6Tm10UGJsUTJhU3R1VVZORFZVdGlMMF"
                + "V2TjFwNFMwMVBZa3h5Q2pOTUt6Uk5Na3RZZUhwTWFIUnhOSEJSZWpWeVJGSTNXamd4VGtsT2VUWnFiMUI2VGxwbmVXeElWMUZR"
                + "VGpGT1YxVnZjelU0ZVc1QllXeFhVbGMxV1hVS2JVOHpiMUpITjBWVVYwTkxiMVJyYkdWRldEaGFWelJ2UlZrd1owVlViMGsyWVd"
                + "OMlJuZG5XVXRQY2tWRFNsTkhabXRFWmxGV1ZuQjFVelp3WnpsRWFncG1VRzFFTWsxaVoxVm5UUzlPYkhwWVdGTTNkMHhRUjJSNlRY"
                + "WXplazF5Tm5kT1kwTkJkMFZCUVZSQlRrSm5hM0ZvYTJsSE9YY3dRa0ZSYzBaQlFVOURDa0ZSUlVGdFJtVmhkVlJtUW0xcFJXTnVUM2"
                + "R3ZDBOWGMwdHZkM0puWVdWNWJGaFBkbkJVUnpCcGNWTkVTM0l2Vmt0d1MxRlhLMlJNYkRGM2NTOXZXVFVLY0dKRFJsZHJhbGxCTm10"
                + "Q1pGaDVXSGhEUjJ3eGNEY3ZLMmwyUldzdlZrY3pNWE15YTA5SGVIUktTSEZCWmxkaFJtZEtibE5CY1d4bldtTTFhMk12VVFvME0yc"
                + "EZaMEpRUld3M1MwMTZhSEIxVFZBMVJucEtkRFZFVW1wdWRrZDRhVUpRVW10WldGaHZjVmN2VGxwSlpUTlZObGN5UlV0TGVFcE5XV2"
                + "xqZVN0QkNrcE5MMWM1VFVacVpXdGxVRFZDZUdsb2FEZG5hMWxwVG0xeWMwUkVVMFJ1VEV0dVRrOVJWemR5VVVaRVQxRlRVVmR6Yk"
                + "VOYWFVMWFUMjkzWlZaUWRHY0tRM2RFUm10eWEyWmxiMmxhTUV3MlVXZ3hLM1ZLU25SUGIyMTFkeTlrYkZwcU5XOUphMlUwVlhKVF"
                + "VrNXFNRlpuVFVGcWQwOHllREpLWTNsSlVXVnRTUXBGUlhobGFVTTNNSHA0YW5jck56ZERibkJ6TDNacVRVeFBVVDA5Q2kwdExTMHR"
                + "SVTVFSUVORlVsUkpSa2xEUVZSRkxTMHRMUzBLIiwiTFMwdExTMUNSVWRKVGlCRFJWSlVTVVpKUTBGVVJTMHRMUzB0Q2sxSlNVTXdWR"
                + "U5EUVdKdFowRjNTVUpCWjBsRFJVRkJkMFJSV1VwTGIxcEphSFpqVGtGUlJVeENVVUYzU0VSRllVMUNaMGRCTVZWR"
                + "lFYZDNVbHBYVW00S1dsTXhhR1JZVW05TVdFcDJZak5SZEZreVJYZEpRbU5PVFdwQmQwNXFSVFJOVkVWM1RWUk5lRmRvWjFCTmVrRjR"
                + "UMVJGZDAxcVFYaE5WRUY0VFhwR1lRcE5RMUY0U1dwQlowSm5UbFpDUVUxTlIxZFdhMW95VlhSWldGWXdZVU14Y0dKdVVteGpiVEZzV"
                + "2tkc2FHUkhWWFJaTWtWM1oyZEZhVTFCTUVkRFUzRkhDbE5KWWpORVVVVkNRVkZWUVVFMFNVSkVkMEYzWjJkRlMwRnZTVUpCVVVSWVF"
                + "rOU9iME5uVEVOSVIwVjBaWE4yVjBsdE1GZGhORGhVTm5vclYydGpVSGdLUlRkcU4wWlJjbXc0UW1GRVREZHhRa0pDZDFWWVdqTkVS"
                + "MWR3VkRoeVFtVlFUVXA0UXpCWFNGZDViRzAyTW5kelRrMXhOVXhZUlhwc2FUTlhaVVoxVXdwRlJrRk5ZVVJyZG5aellqRkhTM2xIVk"
                + "V0bmNHbFlPR1JXYjJob09VNXplR04zYTJSclRFSmFhamRFVjNKUVpIVlpiVTFWU0V4SVpreHVjVFJJU1ZBeENrSTJWWGRYWW5aMlU"
                + "ybFlUVlZGVDFkMlpGZzBSM2h4SzJWYVptaExjbkZCTlZGdlpYSlpVbE14U2sxR2JDOHlSMmxqUW1sVGR5dE1NREIxWkV4Sk5rRUtZV"
                + "FJIVG1aSFJYcDFhMUEzTldwemIzQkpjRWxNUm1sSFdFdFRXU3RwWldSRGNsZENha1JEVVVGR2NUWjNXRkJuWlVVdlFVVldNMUZhSz"
                + "B4S1FVRjZOd3BFUzFSSE0waDRSMGR6YlhBNFpVbHpXalk0VFhsM1Z6UklkREZuTkhKSVIzUjViR3hTVW5kME5GRmtMMGh0Y1hSaVp"
                + "tTm1RV2ROUWtGQlIycEZla0ZTQ2sxQk9FZEJNVlZrUlhkRlFpOTNVVVpOUVUxQ1FXWTRkMFJSV1VwTGIxcEphSFpqVGtGUlJVeENV"
                + "VUZFWjJkRlFrRkhXRlZxVUVKV2NTOTNMMnN2VmtjS1FWWm5ZM2g1VUdOQlVERllhbkJQVkU1NE9IUkJMemxEYlZCYVlrRnhMemhD"
                + "Y0dGSk5FVTFVMU5WU2xwQ1ptbG9WR1pGWmpjelowMVdVM2t6YmxWclZRcHhjMmRuWkZvMllrMUhNRlZIWkZOU1ZuTXlORUZ2TDBn"
                + "MlIzUklXWGhIV2twdlJGUkliSFpHYTNobEwySjVNVFZYVW1aQ2VIRkpRaTlZUmxSWVZVTjJDbmwzYkU1NmIwMVdWek5sV2tOVE5FV"
                + "XpWRzUyUTBOYVdsWm9kRVJSVlZReGJYbGpiR2h2VXpNeWFVUkVTU3RyVUdGTFJVRXhTVE5DVUc1SlZXMURSMklLZDBWeFYwVlRUV3"
                + "R1T0RFMGJXSlVWV0YyYlRWc01HeFBRVUZ1Y0RJMk9WRnRUMjVRZFRCVlVsYzRiMVJuZG5kcFV6Tm9hbXBxVlVvNGFUa3ZhRklyU2d"
                + "wa2EwNVFPVms0TW5wV2ExQjVOMjVoVjBsakswVnRiMmhvZDBVemFEQnBTMjR4TkZKR2VraEhNVE56ZEc5dlZXdDNibkJrT1hFeWNr"
                + "OVhXbU5NUW5GcUNsZG1kVmMwV0ZrOUNpMHRMUzB0UlU1RUlFTkZVbFJKUmtsRFFWUkZMUzB0TFMwSyJdLCJ0eXAiOiJKV1QiLCJhb"
                + "GciOiJSUzI1NiJ9.eyJzdWIiOiJub24tcGF5ZmFjIn0.KpMAJBUYIZ6ZLkEbsHmKiPqQ-HZDQxTKg0Tw9D_wqhjMztZryUPVje4HC"
                + "WlqksqkNDfGzrSrjtcC7KgA_E3TBh8knfkxKG57NsSoaIn0HAWoSKQ-T6jAK9lt6i4tCtvG3EVmiQn0ynb1SGQH9Z7_d918TVLP8G"
                + "f28tHGzLvvoJ6mvc3Bt9HKT73WQmNPND5bhWBd29HuMtuRx1piZbX0MEpkRSed1uWs3tlXrfHoKXQHymuXzhGo7VM2nFj-Kd43Yf"
                + "Q5Q4NBHpPri66v79GfPXMl4BPWykAuYkOYx-Ft01sldDotUBL4lLuV-0tObi95rBvVhybzaD81IX5XCoen_w";

    }

}
