package com.example.shawn.bubblenote;

public class FileName {
    private String name;
    private String shorttext;

    public FileName(String Wesley, String BNote) {
        this.name = Wesley;
        this.shorttext = BNote;
    }

    public void setName(String Wesley){
        this.name = Wesley;
    }

    public String getName(){
        return this.name;
    }

    public void setShorttext(String BNote){
        this.shorttext = BNote;
    }

    public String getShorttext(){
        return this.shorttext;
    }

}
