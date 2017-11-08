package com.example.noushad.to_let_bd;

/**
 * Created by noushad on 10/25/17.
 */

class CategoriesItem {
    private int imageId;
    private String CategoriesName;
    private String description;


    public CategoriesItem(String categoriesName, int imageId, String description) {

        this.imageId = imageId;
        this.description = description;

        this.CategoriesName = categoriesName;
    }

    public int getImageId() {
        return imageId;
    }

    public String getCategoriesName() {
        return CategoriesName;
    }
    public String getDescription() {
        return description;
    }

}
