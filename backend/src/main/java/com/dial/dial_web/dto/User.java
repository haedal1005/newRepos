package com.dial.dial_web.dto;

public class User {

    private int b_id;
    private String b_name;
    private String b_title;
    private String b_content;
    private int b_pw;

    public User(int b_id, String b_name, String b_title, String b_content, int b_pw) {
        super();
        this.b_id = b_id;
        this.b_name = b_name;
        this.b_title = b_title;
        this.b_content = b_content;
        this.b_pw = b_pw;
    }

    public User() {
        super();
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public String getB_title() {
        return b_title;
    }

    public void setB_title(String b_title) {
        this.b_title = b_title;
    }

    public String getB_content() {
        return b_content;
    }

    public void setB_content(String b_content) {
        this.b_content = b_content;
    }

    public int getB_pw() {
        return b_pw;
    }

    public void setB_pw(int b_pw) {
        this.b_pw = b_pw;
    }

    @Override
    public String toString() {
        return "board{" +
                "b_id=" + b_id +
                ", b_name='" + b_name + '\'' +
                ", b_title='" + b_title + '\'' +
                ", b_content='" + b_content + '\'' +
                ", b_pw=" + b_pw +
                '}';
    }
}
