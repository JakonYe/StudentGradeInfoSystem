package com.jakon;

// 实现Serializable接口, 标记该类的对象可以被序列化, 启用其序列化功能
public class Student implements java.io.Serializable {
    private String id;
    private String name;
    private int Chinese;
    private int Math;
    private int English;

    public Student() {
    }

    public Student(String id, String name, int chinese, int math, int english) {
        this.id = id;
        this.name = name;
        Chinese = chinese;
        Math = math;
        English = english;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChinese() {
        return Chinese;
    }

    public void setChinese(int chinese) {
        Chinese = chinese;
    }

    public int getMath() {
        return Math;
    }

    public void setMath(int math) {
        Math = math;
    }

    public int getEnglish() {
        return English;
    }

    public void setEnglish(int english) {
        English = english;
    }

    @Override
    public String toString() {
        return "学号:" + id + " 姓名:" + name +
                " 语文:" + Chinese + " 数学:" + Math + " 英语:" + English;
    }

}
