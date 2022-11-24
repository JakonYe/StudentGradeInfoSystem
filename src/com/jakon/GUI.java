package com.jakon;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.Comparator;

public class GUI {
    /**
     * 创建并显示GUI。出于线程安全的考虑，
     * 这个方法在事件调用线程中调用。
     */
    public static void createAndShowGUI() {
        // 创建及设置窗口
        JFrame frame = new JFrame("学生成绩管理系统");
        frame.setBounds(300, 250, 500, 300);
        frame.setResizable(false);
        frame.setFont(new Font("SimSong", Font.PLAIN, 28));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 增加面板1 作为添加功能
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        {
            JLabel label11 = new JLabel("学号");
            label11.setBounds(20, 20, 50, 30);
            panel1.add(label11);

            JTextField text11 = new JTextField();
            text11.setBounds(60, 20, 150, 30);
            panel1.add(text11);

            JLabel label12 = new JLabel("姓名");
            label12.setBounds(20, 60, 50, 30);
            panel1.add(label12);

            JTextField text12 = new JTextField();
            text12.setBounds(60, 60, 150, 30);
            panel1.add(text12);

            JLabel label13 = new JLabel("语文");
            label13.setBounds(20, 100, 50, 30);
            panel1.add(label13);

            JTextField text13 = new JTextField();
            text13.setBounds(60, 100, 150, 30);
            panel1.add(text13);

            JLabel label14 = new JLabel("数学");
            label14.setBounds(20, 140, 50, 30);
            panel1.add(label14);

            JTextField text14 = new JTextField();
            text14.setBounds(60, 140, 150, 30);
            panel1.add(text14);

            JLabel label15 = new JLabel("英语");
            label15.setBounds(20, 180, 50, 30);
            panel1.add(label15);

            JTextField text15 = new JTextField();
            text15.setBounds(60, 180, 150, 30);
            panel1.add(text15);

            JButton button1 = new JButton("添加");
            button1.setBounds(300, 70, 120, 40);
            button1.addActionListener(e -> {
                String id = text11.getText();
                text11.setText("");
                String name = text12.getText();
                text12.setText("");
                String chineseStr = text13.getText();
                text13.setText("");
                String mathStr = text14.getText();
                text14.setText("");
                String englishStr = text15.getText();
                text15.setText("");
                String result;
                try {
                    result = Method.addStudentInfo(id, name, chineseStr, mathStr, englishStr);
                } catch (IOException ex) {
                    result = "IO异常.";
                }
                JDialog dialog = new JDialog(frame, "结果", true);
                dialog.setBounds(400, 400, 250, 80);
                dialog.setFont(new Font("Times New Roman", Font.PLAIN, 16));
                dialog.add(new JLabel(result));
                dialog.setVisible(true);
            });
            panel1.add(button1);
        }

        // 增加面板2 作为删除功能
        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        {
            JLabel label21 = new JLabel("学号");
            label21.setBounds(20, 20, 50, 30);
            panel2.add(label21);

            JTextField text21 = new JTextField();
            text21.setBounds(60, 20, 150, 30);
            panel2.add(text21);

            JLabel label22 = new JLabel("姓名");
            label22.setBounds(20, 60, 50, 30);
            panel2.add(label22);

            JTextField text22 = new JTextField();
            text22.setBounds(60, 60, 150, 30);
            panel2.add(text22);

            JButton button2 = new JButton("删除");
            button2.setBounds(300, 40, 120, 40);
            button2.addActionListener(e -> {
                String id = text21.getText();
                text21.setText("");
                String name = text22.getText();
                text22.setText("");
                String result;
                try {
                    result = Method.deleteStudentInfo(id, name);
                } catch (IOException ex) {
                    result = "IO异常.";
                }
                JDialog dialog = new JDialog(frame, "结果", true);
                dialog.setBounds(400, 400, 250, 80);
                dialog.setFont(new Font("Times New Roman", Font.PLAIN, 16));
                dialog.add(new JLabel(result));
                dialog.setVisible(true);
            });
            panel2.add(button2);
        }

        // 增加面板3 作为修改功能
        JPanel panel3 = new JPanel();
        panel3.setLayout(null);
        {
            JLabel label31 = new JLabel("学号");
            label31.setBounds(20, 20, 50, 30);
            panel3.add(label31);

            JTextField text31 = new JTextField();
            text31.setBounds(60, 20, 150, 30);
            panel3.add(text31);

            JLabel label32 = new JLabel("姓名");
            label32.setBounds(20, 60, 50, 30);
            panel3.add(label32);

            JTextField text32 = new JTextField();
            text32.setBounds(60, 60, 150, 30);
            panel3.add(text32);

            JLabel label33 = new JLabel("语文");
            label33.setBounds(20, 100, 50, 30);
            panel3.add(label33);

            JTextField text33 = new JTextField();
            text33.setBounds(60, 100, 150, 30);
            panel3.add(text33);

            JLabel label34 = new JLabel("数学");
            label34.setBounds(20, 140, 50, 30);
            panel3.add(label34);

            JTextField text34 = new JTextField();
            text34.setBounds(60, 140, 150, 30);
            panel3.add(text34);

            JLabel label35 = new JLabel("英语");
            label35.setBounds(20, 180, 50, 30);
            panel3.add(label35);

            JTextField text35 = new JTextField();
            text35.setBounds(60, 180, 150, 30);
            panel3.add(text35);

            JButton button3 = new JButton("修改");
            button3.setBounds(300, 70, 120, 40);
            button3.addActionListener(e -> {
                String id = text31.getText();
                text31.setText("");
                String name = text32.getText();
                text32.setText("");
                String chineseStr = text33.getText();
                text33.setText("");
                String mathStr = text34.getText();
                text34.setText("");
                String englishStr = text35.getText();
                text35.setText("");
                String result;
                try {
                    result = Method.updateStudentInfo(id, name, chineseStr, mathStr, englishStr);
                } catch (IOException ex) {
                    result = "IO异常.";
                }
                JDialog dialog = new JDialog(frame, "结果", true);
                dialog.setBounds(400, 400, 250, 80);
                dialog.setFont(new Font("Times New Roman", Font.PLAIN, 16));
                dialog.add(new JLabel(result));
                dialog.setVisible(true);
            });
            panel3.add(button3);
        }

        // 增加面板4 作为查找功能
        JPanel panel4 = new JPanel();
        panel4.setLayout(null);
        {
            JLabel label41 = new JLabel("学号");
            label41.setBounds(20, 20, 50, 30);
            panel4.add(label41);

            JTextField text41 = new JTextField();
            text41.setBounds(60, 20, 150, 30);
            panel4.add(text41);

            JLabel label42 = new JLabel("姓名");
            label42.setBounds(20, 60, 50, 30);
            panel4.add(label42);

            JTextField text42 = new JTextField();
            text42.setBounds(60, 60, 150, 30);
            panel4.add(text42);

            JButton button1 = new JButton("学号查找");
            button1.setBounds(230, 20, 100, 30);
            button1.addActionListener(e -> {
                String id = text41.getText();
                text41.setText("");
                String name = text42.getText();
                text42.setText("");
                String result = Method.queryIdStudentInfo(id, name, 1);
                JDialog dialog = new JDialog(frame, "结果", true);
                dialog.setBounds(400, 400, 340, 80);
                dialog.setFont(new Font("Times New Roman", Font.PLAIN, 16));
                dialog.add(new JLabel(result));
                dialog.setVisible(true);
            });
            panel4.add(button1);

            JButton button2 = new JButton("姓名查找");
            button2.setBounds(230, 60, 100, 30);
            button2.addActionListener(e -> {
                String id = text41.getText();
                text41.setText("");
                String name = text42.getText();
                text42.setText("");
                String result = Method.queryIdStudentInfo(id, name, 2);
                JDialog dialog = new JDialog(frame, "结果", true);
                dialog.setBounds(400, 400, 340, 80);
                dialog.setFont(new Font("Times New Roman", Font.PLAIN, 16));
                dialog.add(new JLabel(result));
                dialog.setVisible(true);
            });
            panel4.add(button2);
        }

        // 增加面板5 作为展示功能
        JPanel panel5 = new JPanel();
        panel5.setLayout(new BorderLayout());
        Method.studentArrayList.sort(Comparator.comparing(Student::getId));
        String[] columnNames = {"学号", "姓名", "语文", "数学", "英语"};
        String[][] tableValues = new String[Method.studentArrayList.size()][5];
        for (int i = 0; i < Method.studentArrayList.size(); i++) {
            Student stu = Method.studentArrayList.get(i);
            tableValues[i][0] = stu.getId();
            tableValues[i][1] = stu.getName();
            tableValues[i][2] = String.valueOf(stu.getChinese());
            tableValues[i][3] = String.valueOf(stu.getMath());
            tableValues[i][4] = String.valueOf(stu.getEnglish());
        }
        final JTable[] table = {new JTable(tableValues, columnNames)};
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
        table[0].setDefaultRenderer(Object.class, tcr);
        JScrollPane scrollPane = new JScrollPane(table[0]);
        panel5.add(scrollPane, BorderLayout.CENTER);

        // 将这些面板添加到多面板中, 再将多面板添加到窗口中
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("添加", panel1);
        tabbedPane.add("删除", panel2);
        tabbedPane.add("修改", panel3);
        tabbedPane.add("查找", panel4);
        tabbedPane.add("展示", panel5);
        frame.add(tabbedPane);

        // 添加多面板的监听, 当选择面板5时, 刷新一次学生成绩信息的表格
        tabbedPane.addChangeListener(e -> {
            if (tabbedPane.getSelectedIndex() == 4) {
                Method.studentArrayList.sort(Comparator.comparing(Student::getId));
                String[] columnNames1 = {"学号", "姓名", "语文", "数学", "英语"};
                String[][] tableValues1 = new String[Method.studentArrayList.size()][5];
                for (int i = 0; i < Method.studentArrayList.size(); i++) {
                    Student stu = Method.studentArrayList.get(i);
                    tableValues1[i][0] = stu.getId();
                    tableValues1[i][1] = stu.getName();
                    tableValues1[i][2] = String.valueOf(stu.getChinese());
                    tableValues1[i][3] = String.valueOf(stu.getMath());
                    tableValues1[i][4] = String.valueOf(stu.getEnglish());
                }
                table[0].setModel(new DefaultTableModel(tableValues1, columnNames1));
            }
        });

        // 显示窗口
        frame.setVisible(true);
    }

}