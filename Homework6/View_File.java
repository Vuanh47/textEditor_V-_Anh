package Homework6;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View_File {
    public JFrame window;
    public JTextArea textArea;
    public JMenuBar menuBar;
    public Control_File file;

    public View_File() {
        // Tạo cửa sổ
        window = new JFrame("Text Editor");
        window.setSize(600, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo vùng chứa văn bản
        textArea = new JTextArea();
        textArea.setBorder(new EmptyBorder(5, 5, 5, 5));
        JScrollPane scrollPane = new JScrollPane(textArea);
        window.add(scrollPane, BorderLayout.CENTER);

        // Tạo thanh menu
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        // Tạo menu File và các mục trong menu
        JMenu menuFile = new JMenu("File");
        menuBar.add(menuFile);

        String[] fileMenuItems = {"New", "Open", "Save", "Save As", "Exit"};
        for (String item : fileMenuItems) {
            JMenuItem menuItem = new JMenuItem(item);
            menuItem.addActionListener(e -> menuItemClick(e.getActionCommand()));
            menuFile.add(menuItem);
        }

        // Khởi tạo đối tượng Control_File
        file = new Control_File(this);

        // Hiển thị cửa sổ
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }

    private void menuItemClick(String command) {
        switch (command) {
            case "New":
                file.newFile();
                break;
            case "Open":
                file.open();
                break;
            case "Save":
                file.save();
                break;
            case "Save As":
                file.saveAs();
                break;
            case "Exit":
                file.exit();
                break;
        }
    }

    public static void main(String[] args) {
        new View_File();
    }
}
