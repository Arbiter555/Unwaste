package com.example.unwaste;

import com.google.gson.annotations.SerializedName;

public class Food {

    @SerializedName("food_name")
    private final String food_name;

    @SerializedName("food_category")
    private final String food_category;

    @SerializedName("food_quantity")
    private final String food_quantity;

    @SerializedName("package_size")
    private final String package_size;

    @SerializedName("expiration_date")
    private final String expiration_date;

    @SerializedName("food_description")
    private final String food_description;

    @SerializedName("dietary_restriction")
    private final String dietary_restriction;

    public Food(String food_name, String food_category, String food_description, String dietary_restriction, String food_quantity, String package_size, String expiration_date) {
        this.food_name = food_name;
        this.food_category = food_category;
        this.food_description = food_description;
        this.dietary_restriction = dietary_restriction;
        this.food_quantity = food_quantity;
        this.package_size = package_size;
        this.expiration_date = expiration_date;
    }

    public String getFood_name() {
        return food_name;
    }

    public String getFood_category() {
        return food_category;
    }

    public String getFood_description() {
        return food_description;
    }

    public String getDietary_restriction() {
        return dietary_restriction;
    }

    public String getFood_quantity() {
        return food_quantity;
    }

    public String getPackage_size() {
        return package_size;
    }

    public String getExpiration_date() {
        return expiration_date;
    }
}
