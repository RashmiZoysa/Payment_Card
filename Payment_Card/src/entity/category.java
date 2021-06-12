package entity;

public class category implements SuperEntity {
    private String categoryID;
    private String categoryType;
    private String description;

    public category() {
    }

    public category(String categoryID, String categoryType, String description) {
        this.categoryID = categoryID;
        this.categoryType = categoryType;
        this.description = description;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
