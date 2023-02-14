package pages;

import elements.Header;

/** Элементы общие для системы */
public class SwagLabsBasePage extends AbstractPage {

    /** Доступ к элементам главного меню */
    public Header header() {
        return new Header(driver);
    }
}
