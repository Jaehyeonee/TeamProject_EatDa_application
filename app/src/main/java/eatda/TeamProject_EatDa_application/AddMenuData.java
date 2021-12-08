package eatda.TeamProject_EatDa_application;

public class AddMenuData {
    String addMenuName;        //등록할 메뉴 이름
    String addMenuIngredient;   //등록할 메뉴 재료
    String addMenuOrder;        //등록할 메뉴 요리순서


    public AddMenuData(){}

    public String getMenuName(){
        return addMenuName;
    }
    public void setMenuName(String name){
        this.addMenuName = name;
    }
    public String getIngredient(){
        return addMenuIngredient;
    }
    public void setIngredient(String ingredient){
        this.addMenuIngredient = ingredient;
    }

    public String getOrder(){
        return addMenuOrder;
    }
    public void setOrder(String order){
        this.addMenuOrder = order;
    }

    public AddMenuData(String name, String ingredient, String order ){
        this.addMenuName = name;
        this.addMenuIngredient = ingredient;
        this.addMenuOrder = order;

    }

}
