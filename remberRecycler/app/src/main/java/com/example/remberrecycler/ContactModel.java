package com.example.remberrecycler;

public class ContactModel {
     int img;
     final String name;
    final String number;
    public ContactModel(int img,String name,String number){
      this.img=img;
      this.name=name;
      this.number=number;
    }

    public ContactModel(String name,String number){
        this.name=name;
        this.number=number;
    }
}
