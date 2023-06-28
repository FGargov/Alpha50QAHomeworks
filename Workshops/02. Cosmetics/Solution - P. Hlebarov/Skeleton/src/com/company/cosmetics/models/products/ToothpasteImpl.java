package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Toothpaste;
import com.company.cosmetics.models.common.GenderType;


import java.util.ArrayList;
import java.util.List;

public class ToothpasteImpl extends ProductBase implements Toothpaste {

    private final List<String> ingredients;

//    private String ingredient;

//        public ToothpasteImpl(String name, String brand, double price, GenderType gender, String... ingredient) {
//        super(name, brand,price,gender);
//        ingredients.addAll(Arrays.asList(ingredient));
//    }
    public ToothpasteImpl(String name, String brand, double price, GenderType gender, List<String> ingredients) {
        super(name, brand,price,gender);
        if (ingredients == null) {
            throw new IllegalArgumentException("Ingredients cannot be null");
        }
        this.ingredients = ingredients;
    }

    @Override
    public List<String> getIngredients() {
        return new ArrayList<>(ingredients);
    }


    @Override
    public String print() {
        return String.format("%s\n#Ingredients: %s\n", super.print(), getIngredients());
    }


}
