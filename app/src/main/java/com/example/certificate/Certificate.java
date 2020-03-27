package com.example.certificate;

public class Certificate {

    private int id;
    private String name;
    private String regno;
    private byte[] image;

    public Certificate(int id, String name, String regno, byte[] image) {
        this.id = id;
        this.name = name;
        this.regno = regno;
        this.image = image;
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

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
