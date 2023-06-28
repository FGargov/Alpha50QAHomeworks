package com.company.cosmetics.models.products;
import com.company.cosmetics.models.contracts.Toothpaste;
import com.company.cosmetics.models.common.GenderType;
import java.util.ArrayList;
import java.util.List;
public class ToothpasteImpl extends ProductBase implements Toothpaste {
    private  List<String>ingredients=new ArrayList<>();
    public ToothpasteImpl(String name, String brand, double price, GenderType gender, List<String >ingredients) {
        super(name,brand,price,gender);
        this.ingredients=ingredients;
        if(ingredients==null){
            throw new IllegalArgumentException("ingredients cannot be null");
        }
    }

    @Override
    public GenderType getGender() {
        return  super.gender;
    }
    @Override
    public List<String> getIngredients() {
        return  new ArrayList<String>();
    }
    @Override
    public String print() {
        StringBuilder builder=new StringBuilder();
        for (String ingredients:ingredients) {
            builder.append(ingredients).append(",");
        }
        if(builder.charAt(builder.length()-1)==','){
            builder.deleteCharAt(builder.length()-1);
        }
        return String.format("%s\n #Ingredients: [%s]\n ====",super.print(),builder.toString());
    }
}
