import org.openqa.selenium.By;

public class Locators {
    //Main Page
    public static final By LINK_ALL_TOP_BAR_TABS = By.xpath("//div[@class='collapse navbar-collapse']//ul//li");
    //HOW_IT_WORK page
    public static final By LINK_HOW_WORK = By.xpath("//a[@href='https://romanceabroad.com/content/view/how-it-works']");
    public static final By LINK_CONTENT_PAGE_TITLES = By.xpath("//ul[@class='nav nav-pills nav-stacked content-pages-tree']//li");
    public static final By LINK_CONTENT_PAGE_TITLES_AFTER_PAGE_RELOAD = By.xpath("//div[@class='inside account_menu']");
    //Search (Pretty Women) page
    public static final By LINK_SEARCH = By.xpath("//a[@href='https://romanceabroad.com/users/search']");
    public static final By LINK_SEARCH_FIRST_IMAGE_TITLE = By.xpath("//*[@title='Tanua']");
    public static final By DROP_DOWN_LIST_SORT_BY_AGE_MIN = By.xpath("//select[@name='age_min']");
    public static final By DROP_DOWN_LIST_SORT_BY_AGE_MAX = By.xpath("//select[@name='age_max']");
    public static final By DROP_DOWN_LIST_SORT_BY = By.xpath("//div[@class='form-inline']//select");
    //Media (Photos) page
    public static final By LINK_PHOTOS = By.xpath("//a[@href='https://romanceabroad.com/media/index']");
    public static final By LINK_PHOTOS_ALL = By.xpath("//ul[@class='b-tabs']//li");
    public static final By BUTTON_ADD_PHOTO = By.cssSelector(".caret");
    public static final By BUTTON_SORTING_PHOTOS = By.cssSelector(".hidden-xs.fa.fa-arrow-down.pointer.plr5");
    public static final By BUTTON_ADD_PHOTOS = By.cssSelector("//button[@data-media='add_photo']");
    //Gifts page
    public static final By LINK_GIFTS = By.xpath("//a[@href='https://romanceabroad.com/store/category-sweets']");
    public static final By LINK_BESTSELLERS = By.xpath("//div[@data-title='Bestsellers']");
    public static final By TEXT_FIELD_GIFTS_SEARCH = By.cssSelector("#search_product");
    public static final By BUTTON_GIFTS_SEARCH = By.cssSelector("button#search_friend");
    public static final By SELECTED_GIFT = By.cssSelector("div.title-block.pt5");
    public static final By LINK_TO_BESTSELLER_PURCHASE = By.xpath("//a[@href='https://romanceabroad.com/store/sweets/12-flower_basket']");
    public static final By BESTSELLER_TITLE  = By.tagName("h1");
    //TOUR_TO_UKRAINE page
    public static final By LINK_TOUR = By.xpath("//a[@href='https://romanceabroad.com/store/sweets/20-tour_to_ukraine'][text()='TOUR TO UKRAINE']");
    public static final By HEADER_TOURS_TO_UKRAINE = By.xpath("//div[@class='search-header']/h1");
    public static final By BUTTON_PAY_PAL = By.xpath("//a[@class='btn btn-primary btn-block']");
    public static final By TOURS_TO_UKRAINE_TITLE = By.xpath("//h1");
    //Blog page
    public static final By BLOG_TITLE = By.xpath("//h1");
    public static final By LINK_BLOG = By.xpath("//a[@href='https://romanceabroad.com/content/view/blog']");
    public static final By LINK_ALL = By.xpath("//h1//following::ul//li");
    //SIGN_IN page
    public static final By LINK_SIGH_IN = By.cssSelector("#ajax_login_link");
    public static final By EMAIL_TEXT_FIELD = By.xpath(" //input[@name='email']");
    public static final By PASSWORD_TEXT_FIELD = By.xpath(" //input[@name='password']");
    public static final By BUTTON_SIGN_IN = By.xpath("//button[@name='logbtn']");
    public static final By ERROR_POP_UP = By.xpath("//div[@class='error alert-danger alert-warning_pop_']");
    public static final By SIGH_IN_TITLE = By.xpath("//h1");
    //BOOK_NOW page
    public static final By LINK_BOOK_NOW = By.xpath("//a[@href='https://romanceabroad.com/store/sweets/20-tour_to_ukraine']");
    //Main page
    public static final By BUTTON_REQUEST_TOUR_INFO = By.xpath("//a[text()='REQUEST TOUR INFO']");
    public static final By BUTTON_JOIN_FOR_FREE = By.xpath("//button[@id='show-registration-block']");
    public static final By BUTTON_FACEBOOK_REDIRECTION = By.xpath("//a[@href='https://m.facebook.com/RomanceAbroad/?ref=bookmarks']");
    public static final By PAGE_TITLE = By.xpath("//h1");
    public static final By NAVBAR_LINKS = By.xpath("//ul[@class='navbar-nav']//li");
    //Registration
    public static final By BUTTON_NEXT = By.xpath("//button[@data-action='next-page'][text()='Next']");
    public static final By TEXT_FIELD_EMAIL = By.xpath("//input[@id='email']");
    public static final By TEXT_FIELD_PASSWORD = By.cssSelector("#password");
    public static final By TEXT_FIELD_USER_NAME = By.xpath("//input[@id='nickname']");
    public static final By DROP_DOWN_DATE_FIELD = By.cssSelector("#daySelect");
    public static final By DROP_DOWN_DATE_SELECTED = By.xpath("//li[@data-handler='selectDay']//a[text()='3']");
    public static final By DROP_DOWN_MONTH_FIELD = By.cssSelector("#monthSelect");
    public static final By DROP_DOWN_MONTH_SELECTED = By.xpath("//li[@data-handler='selectMonth']//a[text()='Feb']");
    public static final By DROP_DOWN_YEAR_FIELD = By.cssSelector("#yearSelect");
    public static final By DROP_DOWN_YEAR_SELECTED = By.xpath("//div[@id='yearSelect']//a[text()='2002']");
    public static final By TEXT_FIELD_USER_PHONE = By.xpath("//input[@name='data[phone]']");
    public static final By TEXT_FIELD_USER_LOCATION = By.xpath("//input[@name='region_name']");
    public static final By CHECK_BOX_CONFIRMATION = By.xpath("//input[@name='data[confirmation]']");
    //IFRAMES_LOCATORS
    public static final By IFRAME_YOUTUBE_VIDEO = By.xpath("//iframe[contains(@src, 'https://www.youtube.com/embed/RRECuJzm3IY?start=85')]");
    public static final By BUTTON_PLAY_YOUTUBE = By.xpath("//button[@aria-label='Play']");
    //FOOTER
    public static final By LINKS_TITLES_FOOTER = By.xpath("//div[@class='footer-menu-list-group-item-text']");
}
