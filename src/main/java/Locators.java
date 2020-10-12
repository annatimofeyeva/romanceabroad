import org.openqa.selenium.By;

public class Locators {
    //BOOK_NOW page
    public static final By LINK_BOOK_NOW = By.xpath("//a[@href='https://romanceabroad.com/store/sweets/20-tour_to_ukraine']");
    //HOW_IT_WORK page
    public static final By LINK_HOW_WORK = By.xpath("//a[@href='https://romanceabroad.com/content/view/how-it-works']");
    //TOUR_TO_UKRAINE page
    public static final By LINK_TOUR = By.xpath("//a[@href='https://romanceabroad.com/store/sweets/20-tour_to_ukraine'][text()='TOUR TO UKRAINE']");
    public static final By HEADER_TOURS_TO_UKRAIN = By.xpath("//div[@class='search-header']/h1");
    //Blog page
    public static final By BLOG_TITLE = By.xpath("//h1");
    public static final By LINK_BLOG = By.xpath("//a[@href='https://romanceabroad.com/content/view/blog']");
    //Gifts page
    public static final By LINK_GIFTS = By.xpath("//a[@href='https://romanceabroad.com/store/category-sweets']");
    public static final By LIST_OF_BESTSELLERS = By.xpath("//div[@class='g-users-gallery__item col-xs-4 col-md-3 col-lg-2 bestseller']");
    public static final By TEXT_FIELD_GIFTS_SEARCH = By.cssSelector("#search_product");
    public static final By BUTTON_GIFTS_SEARCH = By.cssSelector("#search_friend");
    public static final By BUTTON_MAIN_NAV_BAR = By.cssSelector(".fa.fa-bars.fa-lg.item");
    //Search page
    public static final By LINK_SEARCH = By.xpath("//a[@href='https://romanceabroad.com/users/search']");
    public static final By AGE_DROP_DOWN = By.cssSelector("#age_max");
    //Media page
    public static final By LINK_PHOTOS = By.xpath("//a[@href='https://romanceabroad.com/media/index']");
    public static final By BUTTON_ADD_PHOTO = By.cssSelector(".caret");
    public static final By BUTTON_SORTING_PHOTOS = By.cssSelector(".hidden-xs.fa.fa-arrow-down.pointer.plr5");
    //SIGN_IN page
    public static final By LINK_SIGH_IN = By.cssSelector("#ajax_login_link");
    public static final By EMAIL_TEXT_FIELD = By.xpath(" //input[@name='email']");
    public static final By PASSWORD_TEXT_FIELD = By.xpath(" //input[@name='password']");
    public static final By BUTTON_SIGN_IN = By.xpath("//button[@name='logbtn']");
    public static final By ERROR_POP_UP = By.xpath("//div[@class='error alert-danger alert-warning_pop_']");
    //Registration(Main) page
    public static final By BUTTON_JOIN_FOR_FREE = By.xpath("//button[@id='show-registration-block']");
    public static final By BUTTON_NEXT = By.xpath("//button[@data-action='next-page'][text()='Next']");
    public static final By TEXT_FIELD_EMAIL = By.cssSelector("#email");
    public static final By TEXT_FIELD_PASSWORD = By.cssSelector("#password");
    public static final By TEXT_FIELD_USER_NAME = By.xpath("//input[@id='nickname']");
    public static final By TEXT_FIELD_USER_PHONE = By.xpath("//input[@name='data[phone]']");
    public static final By TEXT_FIELD_USER_LOCATION = By.xpath("//input[@name='region_name']");
    public static final By CHECK_BOX_CONFIRMATION = By.xpath("//input[@name='data[confirmation]']");
}
