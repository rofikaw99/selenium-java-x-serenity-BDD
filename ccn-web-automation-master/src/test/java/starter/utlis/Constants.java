package starter.utlis;

import org.apache.commons.lang3.RandomStringUtils;

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
    public static String EMAIL_WITH_COMPANY = "co2-autoqa-ccn-001@yopmail.com";
    public static String EMAIL_DIFFERENT_COMPANY = "sg-auto-001@yopmail.com";
    public static String EMAIL_CARD_OWNER_WITH_COMPANY = "co2-autoqa-ccn-001@yopmail.com";//co3
    public static String EMAIL_AUTHORIZED_USER = "au7-autoqa-ccn-001@yopmail.com";//au
    public static String EMAIL_TRANSFER_SI = "au6-autoqa-ccn-001@yopmail.com";//au
    public static String EMAIL_AU_WITHOUT_SI = "au-without-si-autoqa@yopmail.com";

    public static String EMAIL_HAVE_PAYMENT_REQUEST = "sgpcn2@yopmail.com";
    public static String EMAIL_USER_BACKUP = "sgpcn2@yopmail.com";
    public static String EMAIL_USER = "uu-autoqa-ccn-001@yopmail.com";
    public static String EMAIL_CARD_OWNER_DELETED = "co4-autoqa-ccn-001@yopmail.com";
    public static String EMAIL_AU_DELETED = "au-deleted-001@yopmail.com";

    //CARD NUMBER FOR PAYMENT
    public static String CARD_NON_VISA_SINGAPORE = "4000005540000008";
    public static String CARD_DUPLICATE = "4000007020000003";
    public static String CARD_VISA_SINGAPORE = "4000002920000005"; //for this
    public static String CARD_TO_BE_DELETED = "4000000560000004"; //DENMARK
    public static String CARD_CVC = "123";
    public static String CARD_EXP_DATE = Common.createExpDate(3);
}

