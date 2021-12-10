package eatda.TeamProject_EatDa_application;

public class Dictionary_MyMenu {

    private String strTitle;
    private int imageResId;


    public Dictionary_MyMenu(int a_resId, String a_strTittle){
        strTitle = a_strTittle;
        imageResId = a_resId;
    }


    public void setImageResId(int a_ResId){
        imageResId = a_ResId;
    }

    public int getImageResId(){return imageResId;}

    public void setTitle(String a_strTitle) {
        strTitle = a_strTitle;
    }

    public String getTitle() {
        return strTitle;
    }





/*
    private String menu_item_title;
    private ImageView menu_item_img;

    public String getMenu_item_title() {
        return menu_item_title;
    }

    public void setMenu_item_title(String menu_item_title) {
        this.menu_item_title = menu_item_title;
    }

    public int getMenu_item_img() {
        return menu_item_img;
    }

    public void setMenu_item_img(ImageView menu_item_img) {
        this.menu_item_img = menu_item_img;
    }

    public Dictionary_MyMenu(String menu_item_id, String menu_item_title, ImageView menu_item_img) {
        //this.menu_item_id = menu_item_id;
        this.menu_item_title = menu_item_title;
        this.menu_item_img = menu_item_img;
    }*/
}
