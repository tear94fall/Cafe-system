package com.example.moducafe.Adapter;

public class ItemDto {
    private Long id;
    private String image;
    private String name;
    private String englishName;
    private int price;

    public ItemDto() {
    }

    public ItemDto(Long id, String image, String name, String englishName, int price) {
        setId(id);
        setImage(image);
        setName(name);
        setEnglishName(englishName);
        setPrice(price);
    }

    public Long getId() { return this.id; }
    public String getImage() { return this.image; }
    public String getName() { return this.name; }
    public String getEnglishName() { return this.englishName; }
    public int getPrice() { return this.price; }

    public void setId(Long id) { this.id = id; }
    public void setImage(String image) { this.image = image; }
    public void setName(String name) { this.name = name; }
    public void setEnglishName(String englishName) { this.englishName = englishName; }
    public void setPrice(int price) { this.price = price; }
}
