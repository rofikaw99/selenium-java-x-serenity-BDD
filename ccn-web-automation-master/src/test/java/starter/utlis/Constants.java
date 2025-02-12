package starter.utlis;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;

public class Constants {

    public static final String CHROME = "Chrome";
    public static final String FIREFOX = "Firefox";
    public static final String BROWSER = "browser";
    public static final String URL_MAIN_WEB = "https://sandbox.cubeforall.com/";
    public static final String URL_SUPPORT_APP_WEB = "http://cubehelp.sandbox.ccn/supportforall/login";
    public static final String URL_DIRECT_SIGNIN = "https://ccnssodev.b2clogin.com/ccnssodev.onmicrosoft.com/b2c_1a_signup_signinnewusersyn/oauth2/v2.0/authorize?client_id=d367c646-2e75-4029-b858-14111160eaa8&scope=openid%20profile%20offline_access&redirect_uri=https%3A%2F%2Fdev.cubeforall.com%2F&client-request-id=e75d25b1-1597-4b4d-89dd-af2f4c6af22f&response_mode=fragment&response_type=code&x-client-SKU=msal.js.browser&x-client-VER=2.33.0&client_info=1&code_challenge=MhbcP8plsgcs5PuMvgwqAXlwiG8PA3-wefN8R8oD8nM&code_challenge_method=S256&nonce=966da67f-0f5a-4740-bf34-4be89cfea759&state=eyJpZCI6ImMzYTI5YWQ5LWZjOTQtNGU4Ni04MDk5LTI1MmZmYmRmZjA2ZSIsIm1ldGEiOnsiaW50ZXJhY3Rpb25UeXBlIjoicG9wdXAifX0%3D";
//	public static final String URL_MAIN_WEB = "https://dev.cubeforall.com/";
//	public static final String URL_MAIN_WEB = "https://cubeforall.com";
//	https://www.orangehrm.com


    //constant mas wisnu
    public static final String DIR = System.getProperty("user.dir");
    public static String GENERATED_NUM = RandomStringUtils.randomNumeric(8);
    public static String GENERATED_CHAR = RandomStringUtils.randomAlphanumeric(8);
    public static String FOUR_DIGIT = RandomStringUtils.randomNumeric(4);
    public static String EMAIL = "";
    public static String MAIL_SERVICE = "";
    public static String MAIL_SERVICE_URL = "https://www.mailinator.com/";
    public static String YOPMAIL_SERVICE_URL = "https://yopmail.com/en/";
    public static String DISPLAY_NAME = "QA CCN "+ GENERATED_NUM;
    public static String COMPANY_NAME = "QA Company "+ GENERATED_NUM;
    //    public static String COMPANY_PATH_URL = "https://dev.cubeforall.com/portal/manage-company/";
//    public static String COMPANY_PATH_URL = "https://sandbox.cubeforall.com/portal/manage-company/";
    public static String COMPANY_PATH_URL = "https://cubeforall.com/portal/manage-company/";
    public static String SQPP_PATH_URL = "https://coolman:iamcool@ppd-siacargo.ccnexchange.com";
//  public static String SQPP_PATH_URL = "https://ppd-siacargo.ccnexchange.com/";


    public static String FULL_MAIL = "qa-ccn-"+ GENERATED_CHAR +"@yopmail.com"; //todo
    public static String FULL_EMAIL = "sgqa-ccn-"+ GENERATED_NUM +"@mailinator.com"; //todo
    public static String FULL_EMAIL_SG = "sgqa-ccn-"+ GENERATED_NUM +"@mailinator.com"; //todo
    public static String FULL_EMAIL_CH = "chqa-ccn-"+ GENERATED_NUM +"@mailinator.com"; //todo
    public static String FULL_EMAIL_MY = "myqa-ccn-"+ GENERATED_NUM +"@yopmail.com"; //todo
    public static String FULL_EMAIL_UAE = "uaeqa-ccn-"+ GENERATED_NUM +"@yopmail.com"; //todo
    public static String FULL_EMAIL_INDO = "indoqa-ccn-"+ GENERATED_NUM +"@yopmail.com";
    public static String FULL_EMAIL_NZ = "nz-ccn-"+ GENERATED_NUM +"@yopmail.com";

    public static String FULL_EMAIL_SQPP = "sqppqa-ccn-"+ GENERATED_NUM +"@mailinator.com"; //todo
    public static String PASSWORD = "CCNPegasus123";
    public static String VERIFICATION_CODE = "";
    public static String VERIFICATION_CODE_SQPP = "";
    public static String FULL_EMAIL_AFTER_LOGIN = ""; //todo

    //URL Product
    public static String URL_PRODUCTS = "/freight-forwarder/forwarders-shipper";
    public static String URL_REWARDS = "/rewards/";
    public static String URL_PAYMENT_METHODS = "/payment-methods/";
    public static String URLJOIN_PARTNER = "/resources/logistics-technology-provider/";
    public static String URL_IATA = "/products/freight-operations-management/test-iata-tact-rate-premium-multicurrencysandbox/";
    public static String URL_AWB_BC = "/products/freight-operations-management/bundle-awb-bc/";
    public static String URL_AWB_CONCIERGE_PREMIUM = "/products/freight-operations-management/test-awbconcierge-premium-multicurrencysandbox/";
    public static String URL_PATH_COMPANY = "/portal/manage-company/";

    //EMAIL ACCOUNT
    public static String NEW_EMAIL_MY = "";
    public static String EMAIL_WITHOUT_COMPANY = "myqa-ccn-001@yopmail.com";
    public static String EMAIL_DIFFERENT_COMPANY = "sg-auto-001@yopmail.com";
    public static String EMAIL_CARD_OWNER_WITH_COMPANY = "co-auto-001@yopmail.com";//co3
    public static String EMAIL_CARD_OWNER_SG = "sgpcn2@yopmail.com";//co3
    public static String EMAIL_AUTHORIZED_USER = "au-auto-001@yopmail.com";//au
    public static String EMAIL_AUTHORIZED_USER_SG = "sgpcn3@yopmail.com";//au
    public static String EMAIL_USER = "uu-auto-001@yopmail.com";
    public static String EMAIL_HAVE_PAYMENT_REQUEST = "sgpcn2@yopmail.com";
    public static String EMAIL_AUTHORIZED_HAVE_PAYMENT_REQUEST = "sgpcn3@yopmail.com";
    public static String USER_OVERVIEW = "qa-ccn-kpxsyhyy@yopmail.com";
    public static String EMAIL_USER_BACKUP = "malaypcn@yopmail.com";
    public static String EMAIL_CARD_OWNER_DELETED = "co-sg-001@yopmail.com";
//    public static String EMAIL_CARD_OWNER_DELETED = "co-my-001@yopmail.com";
    public static String EMAIL_AU_DELETED = "co-sg-004@yopmail.com";
    public static String EPOUCH_BUNDLE_USER = "koreacity@yopmail.com";
    public static String PUBLIC_SERVICE_GATEWAY = "https://cubesandbox.ccnexchange.com";
    public static String PRIVATE_SERVICE_GATEWAY = "http://cube.sandbox.ccn";
    public static String DELEGATED_COMPANY = "SG Auto QA";
    public static String SYSTEM_COMPANY_ADDRESS = "system.csgagt99kiex637nu459et1po_aae@ccnexchange.com";
    public static String COMPANY_PIMA = "csgagt99KIEX637nU459et1Po/AAE";
    public static String CUBE_ID = "559cdc3d065b434baa0fd5f6e3ab8f76";
    public static String COMPANY_NAME_SEARCH = "EDEN";
    public static String COMPANY_DOMAIN = "ccnexchange.com";

    public static String HQ = "headquarter_sq@yopmail.com";


    //CARD NUMBER FOR PAYMENT
    public static String CARD_NON_VISA_SINGAPORE = "4000002180000000"; //ECUADOR
    public static String CARD_DUPLICATE = "4000007020000003";
    public static String CARD_VISA_SINGAPORE = "4000002920000005"; //for this
    public static String CARD_TO_BE_DELETED = "4000007020000003"; //ECUADOR
    public static String CARD_CVC = "123";
    public static String CARD_EXP_DATE = Common.createExpDate(3);
    public static List<String> VALID_AWB_NO = List.of(
            "618-24708552",
            "618-61898200",
            "176-45677892",
            "618-62787454",
            "618-27108605",
            "618-76230851",
            "176-12312311",
            "938-81129882",
            "618-45449994",
            "176-81129882",
            "618-41258884",
            "618-63640566",
            "157-90260155",
            "618-64882801",
            "618-23163276"
    );

    public static String PUBLIC_DEV_URL = "https://cubedev.ccnexchange.com";
    public static String SUBSCRIPTION_DEV_URL = "http://subscription.dev.ccn";
    public static String LOKALDIMAS = "https://66bf-182-5-199-154.ngrok-free.app";
    public static String PUBLIC_PPD_URL = "https://cubesandbox.ccnexchange.com";

    public static String SUPPORT_DEV_URL = "http://cubehelp.dev.ccn/support/database/find-all";
    public static String SUPPORT_PPD_URL = "http://cubehelp.sandbox.ccn/support/database/find-all";

}

