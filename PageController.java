package com.company;

public class PageController {


    static PageController pageController = null;

    private PageController() {
    }

    static public PageController getInstance() {
        if (pageController == null) {
            pageController = new PageController();
        }
        return pageController;
    }

    public boolean makeUserAdminInPage() {

        return true;
    }

    public boolean removeAdminPrivelegesFromAdmin() {
        //write code here
        return true;
    }

}
