package com.example.shawn.bubblenote;

public class FileName {
    private String name;
    private String shorttext;

    public FileName(String _name, String _shorttext) {
        this.name = _name;
        this.shorttext = _shorttext;
    }

    public void setName(String _name){
        this.name = _name;
    }

    public String getName(){
        return this.name;
    }

    public void setShorttext(String _shorttext){
        this.shorttext = _shorttext;
    }

    public String getShorttext(){
        return this.shorttext;
    }

}
