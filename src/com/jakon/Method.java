package com.jakon;

import java.io.*;
import java.util.ArrayList;

public class Method {
    public static final ArrayList<Student> studentArrayList = new ArrayList<>();   // 存储学生对象的数组

    /**
     * 从文件中读取学生对象信息, 初始化学生对象数组
     *
     * @throws IOException            IO异常
     * @throws ClassNotFoundException 无法找到指定类异常
     */
    public static void initStudentInfo() throws IOException, ClassNotFoundException {
        String filePath = "studentInfo.dat";
        File file = new File(filePath);
        if (file.exists()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
            int count = ois.readInt();
            for (int i = 0; i < count; i++) {
                Student student = (Student) ois.readObject();
                studentArrayList.add(student);
            }
            ois.close();
        }
    }

    /**
     * 保存学生对象信息到文件中
     *
     * @throws IOException IO异常
     */
    public static void saveStudentInfo() throws IOException {
        String filePath = "studentInfo.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeInt(studentArrayList.size());
        for (Student stu : studentArrayList) {
            oos.writeObject(stu);
        }
        oos.close();
    }

    /**
     * @param id 查找的学生学号
     * @return 指定学号在数组中的索引
     */
    public static int getIdIndex(String id) {
        for (int i = 0; i < studentArrayList.size(); i++) {
            Student stu = studentArrayList.get(i);
            if (stu.getId().equals(id)) return i;
        }
        return -1;   // 返回-1索引, 表示不存在该id的学生对象
    }

    /**
     * @param name 查找的学生姓名
     * @return 指定姓名在数组中的索引
     */
    public static int getNameIndex(String name) {
        for (int i = 0; i < studentArrayList.size(); i++) {
            Student stu = studentArrayList.get(i);
            if (stu.getName().equals(name)) return i;
        }
        return -1;   // 返回-1索引，表示不存在该id的学生对象
    }

    /**
     * 增加一个学生对象信息
     */
    public static String addStudentInfo(String id, String name, String chineseStr, String mathStr, String englishStr) throws IOException {
        Student stu = new Student();

        if (getIdIndex(id) != -1) {
            return "添加失败：学号已存在.";
        }
        stu.setId(id);

        if (getNameIndex(name) != -1) {
            return "添加失败：姓名已存在.";
        }
        stu.setName(name);

        try {
            int chinese = Integer.parseInt(chineseStr);
            stu.setChinese(chinese);
            int math = Integer.parseInt(mathStr);
            stu.setMath(math);
            int english = Integer.parseInt(englishStr);
            stu.setEnglish(english);
        } catch (NumberFormatException e) {
            return "添加失败：成绩不合法.";
        }

        studentArrayList.add(stu);
        saveStudentInfo();
        return "添加成功.";
    }

    /**
     * 删除一个学生对象信息
     */
    public static String deleteStudentInfo(String id, String name) throws IOException {
        int index = getIdIndex(id);
        if (index == -1) {
            return "删除失败：学号不存在.";
        }

        Student stu = studentArrayList.get(index);
        if (!stu.getName().equals(name)) {
            return "删除失败：姓名与学号不匹配.";
        }

        studentArrayList.remove(index);
        saveStudentInfo();
        return "删除成功.";
    }

    /**
     * 修改一个学生对象信息
     */
    public static String updateStudentInfo(String id, String name, String chineseStr, String mathStr, String englishStr) throws IOException {
        int index = getIdIndex(id);
        if (index == -1) {
            return "修改失败：学号不存在.";
        }

        Student stu = studentArrayList.get(index);
        if (!stu.getName().equals(name)) {
            return "修改失败：姓名与学号不匹配.";
        }

        try {
            int chinese = Integer.parseInt(chineseStr);
            stu.setChinese(chinese);
            int math = Integer.parseInt(mathStr);
            stu.setMath(math);
            int english = Integer.parseInt(englishStr);
            stu.setEnglish(english);
        } catch (NumberFormatException e) {
            return "修改失败：成绩不合法.";
        }

        studentArrayList.set(index, stu);
        saveStudentInfo();
        return "修改成功.";
    }

    /**
     * 根据学号或者姓名查找一个学生对象信息
     */
    public static String queryIdStudentInfo(String id, String name, int type) {
        switch (type) {
            case 1 -> {
                int index = getIdIndex(id);
                if (index == -1) {
                    return "查找失败：学号不存在.";
                }
                return studentArrayList.get(index).toString();
            }
            case 2 -> {
                int index = getNameIndex(name);
                if (index == -1) {
                    return "查找失败：姓名不存在.";
                }
                return studentArrayList.get(index).toString();
            }
            default -> {
                return "查找失败：不合法的输入.";
            }
        }
    }

}