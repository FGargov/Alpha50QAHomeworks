package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Toothpaste;
import com.company.cosmetics.models.common.GenderType;

import java.util.ArrayList;
import java.util.List;

public class ToothpasteImpl extends ProductBase implements Toothpaste {
    private List<String> ingredients;
    public ToothpasteImpl(String name, String brand, double price, GenderType gender, List<String> ingredients) {
        super(name, brand, price, gender);
        setIngredients(ingredients);
    }

    @Override
    public List<String> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    public void setIngredients(List<String> ingredients) {
        if (ingredients == null){
            throw new IllegalArgumentException("Ingredients list cannot be null.");
        }
        this.ingredients = ingredients;
    }

    @Override
    public String print() {
        StringBuilder builder = new StringBuilder();
        for (String ingredients: ingredients) {
            builder.append(ingredients).append(",");
        }
        if(builder.charAt(builder.length() -1) == ',') {
            builder.deleteCharAt(builder.length() -1);
        }
        return String.format("%s\n #Ingredients: [%s]\n ====",super.print(),builder.toString());
    }
   /* @Override
    public String print() {
        return String.format("#Category: Toothpastes\n"+"%s"+" #Ingredients: %s\n"+" ===",super.print(),List.of(ingredients));
    }*/
}
