package com.romanceabroad.ui;

import org.openqa.selenium.By;

public class Locators {
    // h1
    public static final By H1_TITLE = By.xpath("//h1");
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
    public static final By BUTTON_SEARCH = By.xpath("//input[@name='main_search_button']");
    public static final By SEARCH_RESULT = By.xpath("//div[@class='lh30']");
    public static final By TEXT_USER_INFO = By.xpath("//div[@class='text-overflow']");
    //Media (Photos) page
    public static final By LINK_PHOTOS = By.xpath("//a[@href='https://romanceabroad.com/media/index']");
    public static final By LINK_PHOTOS_ALL = By.xpath("//ul[@id='gallery_filters']//a");
    public static final By BUTTON_ADD_PHOTO = By.cssSelector(".caret");
    public static final By BUTTON_SORTING_PHOTOS = By.cssSelector(".hidden-xs.fa.fa-arrow-down.pointer.plr5");
    public static final By BUTTON_ADD_PHOTOS = By.cssSelector("//button[@data-media='add_photo']");
    public static final By LINK_DROP_DOWN = By.xpath("//span[@id='gallery_media_sorter']//select[@class='form-control']");
    //Gifts page
    public static final By LINK_GIFTS = By.xpath("//a[@href='https://romanceabroad.com/store/category-sweets']");
    public static final By LINK_BESTSELLERS = By.xpath("//div[@data-title='Bestsellers']");
    public static final By TEXT_FIELD_GIFTS_SEARCH = By.cssSelector("#search_product");
    public static final By BUTTON_GIFTS_SEARCH = By.xpath("//button[@id='search_friend'][text()='Search']");
    public static final By SELECTED_GIFT = By.cssSelector("div.title-block.pt5");
    public static final By LINK_TO_BESTSELLER_PURCHASE = By.xpath("//a[@href='https://romanceabroad.com/store/sweets/12-flower_basket']");
    public static final By BESTSELLER_TITLE = By.tagName("h1");
    public static final By TITLES = By.xpath("//h1[@class='title']");
    public static final By TITLE_OF_GIFT = By.xpath("//div[@class='title-block pt5']");

    //TOUR_TO_UKRAINE page
    public static final By LINK_TOUR = By.xpath("//a[@href='https://romanceabroad.com/store/sweets/20-tour_to_ukraine'][text()='TOUR TO UKRAINE']");
    public static final By HEADER_TOURS_TO_UKRAINE = By.xpath("//div[@class='search-header']/h1");
    public static final By BUTTON_PAY_PAL = By.xpath("//a[@class='btn btn-primary btn-block']");
    public static final By TOURS_TO_UKRAINE_TITLE = By.xpath("//h1");
    //Blog page
    public static final By BLOG_TITLE = By.xpath("//h1");
    public static final By LINK_BLOG = By.xpath("//a[@href='https://romanceabroad.com/content/view/blog']");
    public static final By LINK_ALL = By.xpath("//h1//following::ul//li");
    public static final By LINK_OF_ARTICLES = By.xpath("//ul[@class='nav nav-pills nav-stacked content-pages-tree']//li");

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
    public static final By LINK_JOIN_US = By.xpath("//div[@class='col-lg-12 text-center']//a[@href='#']");
    public static final By CHECKBOX_CONFIRMATION = By.cssSelector("input#confirmation");
    //Registration
    public static final By BUTTON_NEXT = By.xpath("//button[@data-action='next-page'][text()='Next']");
    public static final By TEXT_FIELD_EMAIL = By.xpath("//input[@id='email']");
    public static final By TEXT_FIELD_PASSWORD = By.cssSelector("#password");
    public static final By TEXT_FIELD_USER_NAME = By.xpath("//input[@id='nickname']");
    public static final By DROP_DOWN_DATE_FIELD = By.cssSelector("#daySelect");
    public static final By DROP_DOWN_DATE_SELECTED = By.xpath("//li[@data-handler='selectDay']");
    public static final By DROP_DOWN_MONTH_FIELD = By.cssSelector("#monthSelect");
    public static final By DROP_DOWN_MONTH_SELECTED = By.xpath("//li[@data-handler='selectMonth']");
    public static final By DROP_DOWN_YEAR_FIELD = By.cssSelector("#yearSelect");
    public static final By DROP_DOWN_YEAR_SELECTED = By.xpath("//li[@data-handler='selectYear']");
    public static final By TEXT_FIELD_USER_PHONE = By.xpath("//input[@name='data[phone]']");
    public static final By TEXT_FIELD_USER_LOCATION = By.xpath("//div[@class='dropdown dropdown_location']//ul//li[@class='active']");
    public static final By LIST_VALUE_LOCATION = By.xpath("//div[@id='locationAutocompleteBg']/following-sibling::div/ul/li");
    public static final By CHECK_BOX_CONFIRMATION = By.xpath("//input[@name='data[confirmation]']");
    public static final By AUTOFILE_FORM = By.xpath("//input[@name='region_name']");
    public static final By TOOLTIP_ERROR = By.xpath("//div[@class='tooltip']");
    //IFRAMES_LOCATORS
    public static final By IFRAME_YOUTUBE_VIDEO = By.xpath("//iframe[contains(@src, 'https://www.youtube.com/embed/RRECuJzm3IY?start=85')]");
    public static final By BUTTON_PLAY_YOUTUBE = By.xpath("//button[@aria-label='Play']");
    //FOOTER
    public static final By LINKS_TITLES_FOOTER = By.xpath("//div[@class='footer-menu-list-group-item-text']");
    //Contact US
    public static final By DROP_DOWN_REASONS = By.xpath("//select[@name='id_reason']");
    public static final By TEXT_FIELD_USER_NAME_CONTACT_US = By.xpath("//input[@name='user_name']");
    public static final By TEXT_FIELD_USER_EMAIL_CONTACT_US = By.xpath("//input[@name='user_email']");
    public static final By TEXT_FIELD_SUBJECT = By.xpath("//input[@name='subject']");
    public static final By TEXT_AREA_MESSAGE = By.xpath("//textarea[@name='message']");
    public static final By BUTTON_SUBMIT = By.xpath("//input[@type='submit']");
    // 20 Advanced locators:
    // 10 locators with different attributes:
    public static final By LINK_TOP = By.xpath("//a[@href='https://romanceabroad.com/']");
    public static final By HR_DIVIDED_BAR = By.xpath("//hr[@class='light my-4']");
    public static final By MIDDLE_PAGE_TEXT = By.xpath("//p[text()='FIND YOUR LOVE, YOUR WIFE, YOUR DREAM!']");
    public static final By BUTTON_TOUR = By.xpath("//a[text()='REQUEST TOUR INFO']");
    public static final By LINK_LOGIN = By.xpath("//a[@id='ajax_login_link']");
    public static final By BUTTON_LOGIN_FORM_CLOSE = By.xpath("//div[@class='load_content_close clearfix']");
    public static final By LINK_PAGINATION_TAB1 = By.xpath("//a[@data-page='2']");
    public static final By LINK_PAGINATION_TAB2 = By.xpath("//a[@href='https://romanceabroad.com/users/search/default/DESC/1']");

    // 10 locators with parents:
    public static final By TOP_LOGO_IMAGE = By.xpath("//div[@class='top']//img[@src='/img/logo.jpg']");
    public static final By IFRAME = By.xpath("//div[@class='col-lg-6 text-center']//div[@class='video']//iframe[@src='https://www.youtube.com/embed/RRECuJzm3IY?start=85']");
    public static final By LINK_GET_IN_TOUCH = By.xpath("//div[@class='col-lg-5']//h2");
    public static final By LINK_SUPPORT = By.cssSelector("span>a[href='mailto:support@romanceabroad.com']");
    public static final By LINK_LANGUAGE_ACTIVE_FOR_SELECTION = By.xpath("//li//a[@class='active']");
    public static final By LINKS_FOOTER_LANGUAGES = By.xpath("//ul[@class='footer-languages']//li");
    public static final By LINK_WEST_WEB_ART = By.xpath("//div[@class='wwa']//a[@rel='nofollow']");
    public static final By LINK_PRESENTS = By.xpath("//a/following-sibling::a");
    public static final By SORTING_ARROW = By.xpath("//a/preceding-sibling::i");
    public static final By CURRENT_PAGE_NAME = By.xpath("//a/following-sibling::span");
    public static final By CURRENT_PAGE_NUMBER = By.xpath("//div//ins[@class='current']");
    public static final By ADVANCED_SEARCH9 = By.xpath("//div[@class='lh30']");

    //com.romanceabroad.ui.Algos.Locators with 2 attributes for the same WebElement
    public static final By LINK_GIFTS_NEW = By.xpath("//a[@class='nav-link'][@href='https://romanceabroad.com/store/category-sweets']");
    public static final By BUTTON_JOIN_FOR_FREE_NEW = By.xpath("//button[@data-action][@id='show-registration-block']");
    public static final By SEARCH_PAGE_HEADER = By.xpath("//div[@class='header-container-outer'][@id='slidemenu-outer']");

}



