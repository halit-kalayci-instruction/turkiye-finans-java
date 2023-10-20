package org.example;

public class UserForListingDto {
    private int id;
    private String name;

    public UserForListingDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserForListingDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
