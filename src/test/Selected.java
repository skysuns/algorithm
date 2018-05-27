package test;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Selected {
    public static void main(String args[]) {


    }

    public void test(){
        JFrame frame = new JFrame("请输入您的安装目录");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        JTextArea jta = new JTextArea(10, 15);
        jta.setTabSize(4);
        jta.setFont(new Font("标楷体", Font.BOLD, 16));
        jta.setLineWrap(true);
        jta.setWrapStyleWord(true);
        jta.setBackground(Color.pink);

        JScrollPane jscrollPane = new JScrollPane(jta);
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridLayout(1, 3));

        JButton jb1 = new JButton("复制");
        jb1.addActionListener((ActionListener)this);

        jpanel.add(jb1);

        contentPane.add(jscrollPane, BorderLayout.CENTER);
        contentPane.add(jpanel, BorderLayout.SOUTH);

        frame.setSize(400, 300);
        frame.setLocation(400, 200);
        frame.setVisible(true);
    }
}