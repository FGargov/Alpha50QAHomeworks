package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Toothpaste;
import com.company.cosmetics.models.common.GenderType;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ToothpasteImpl extends ProductBase implements Toothpaste {

    public static final String INGREDIENTS_ERROR = "Ingredients cannot be empty";
    private List<String> ingredients;

    public ToothpasteImpl(String name, String brand, double price, GenderType gender, List<String> ingredients) {
        super(name, brand, price, gender);
        setIngredients(ingredients);
    }

    public void setIngredients(List<String> ingredients) {
        if (ingredients == null) {
            throw new IllegalArgumentException(INGREDIENTS_ERROR);
        }
        this.ingredients = new ArrayList<>(ingredients);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getBrand() {
        return super.getBrand();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public GenderType getGender() {
        return super.getGender();
    }

    @Override
    public String print() {
        return String.format(Locale.US, """
                        #%s %s
                         #Price: $%.2f
                         #Gender: %s
                         #Ingredients: %s
                         ===
                         """,
                this.getName(), this.getBrand(), this.getPrice(), this.getGender(), this.ingredients);
    }

    @Override
    public List<String> getIngredients() {
        return this.ingredients;
    }
}
