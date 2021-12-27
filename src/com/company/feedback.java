package com.company;

import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class feedback extends Applet implements ActionListener {
    TextField name = new TextField();
    TextField reg = new TextField();
    TextField email = new TextField();

    TextField factname1 = new TextField();
    TextField score1 = new TextField();

    TextField factname2 = new TextField();
    TextField score2 = new TextField();

    TextField factname3 = new TextField();
    TextField score3 = new TextField();

    TextField factname4 = new TextField();
    TextField score4 = new TextField();

    TextField factname5 = new TextField();
    TextField score5 = new TextField();

    Choice sem = new Choice();
    Choice section = new Choice();

    CheckboxGroup cbg = new CheckboxGroup();
    Checkbox cb11 = new Checkbox("", cbg, false);

    TextField sub1 = new TextField();
    TextField sub2 = new TextField();
    TextField sub3 = new TextField();
    TextField prac1 = new TextField();
    TextField prac2 = new TextField();

    Button b = new Button("Submit");
    int x = 0, y = 30;


    public void init() {
        try {
            //Sem choices
            sem.add("1");
            sem.add("2");
            sem.add("3");
            sem.add("4");
            sem.add("5");
            sem.add("6");
            sem.add("7");
            sem.add("8");

            //Section choices
            section.add("A");
            section.add("B");
            section.add("C");
            section.add("D");

            setLayout(null);
            name.setBounds(210, 165, 100, 25);
            reg.setBounds(480, 165, 100, 25);
            sem.setBounds(210, 215, 70, 20);
            section.setBounds(390, 215, 60, 20);
            email.setBounds(550, 215, 220, 25);

            factname1.setBounds(270, 315, 100, 25);
            sub1.setBounds(460, 315, 120, 25);
            score1.setBounds(660, 315, 25, 25);

            factname2.setBounds(270, 365, 100, 25);
            sub2.setBounds(460, 365, 120, 25);
            score2.setBounds(660, 365, 25, 25);

            factname3.setBounds(270, 415, 100, 25);
            sub3.setBounds(460, 415, 120, 25);
            score3.setBounds(660, 415, 25, 25);

            factname4.setBounds(270, 515, 100, 25);
            prac1.setBounds(460, 515, 120, 25);
            score4.setBounds(660, 515, 25, 25);

            factname5.setBounds(270, 565, 100, 25);
            prac2.setBounds(460, 565, 120, 25);
            score5.setBounds(660, 565, 25, 25);

            b.setBounds(300, 620, 100, 30);

            //ADDING fields to applet
            add(name);
            add(reg);
            add(email);
            add(sem);
            add(section);

            add(factname1);
            add(sub1);
            add(score1);

            add(factname2);
            add(sub2);
            add(score2);

            add(factname3);
            add(sub3);
            add(score3);

            add(factname4);
            add(prac1);
            add(score4);

            add(factname5);
            add(prac2);
            add(score5);

            add(b);
            b.addActionListener(this);

            //JDBC Connection
            System.out.println("in Try");
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("Jdbc:Odbc:feedbacks"); //dsn name
            Statement st = con.createStatement();

            String sql = "Select * from feedbacks";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Name : " + rs.getString(2) + "\t" + "Registration No. " + rs.getString(3) + "\t"
                        + "Sem : " + rs.getString(4) + "\t" + "Section : " + rs.getString(5) + "\t" + "Email : " + rs.getString(6) +
                        "\n" + "Faculty Name : " + rs.getString(7) + "\t" + "Subject Name : " + rs.getString(8) + "\t" + "Score : " + rs.getString(9) +
                        "\n" + "Faculty Name : " + rs.getString(10) + "\t" + "Subject Name : " + rs.getString(11) + "\t" + "Score : " + rs.getString(12) +
                        "\n" + "Faculty Name : " + rs.getString(13) + "\t" + "Subject Name : " + rs.getString(14) + "\t" + "Score : " + rs.getString(15) +
                        "\n" + "Faculty Name : " + rs.getString(16) + "\t" + "Practical Name : " + rs.getString(17) + "\t" + "Score : " + rs.getString(18) +
                        "\n" + "Faculty Name : " + rs.getString(19) + "\t" + "Practical Name : " + rs.getString(20) + "\t" + "Score : " + rs.getString(21) +"" +
                        "\n");
            }

        }
        catch (Exception e) {
            System.out.println(e);
        }
    }


    public void actionPerformed(ActionEvent e) {
        //l1.setText(email.getText());
    }

    public void paint(Graphics g) {
        Font font25B = new Font("Monospaced", Font.BOLD, 25);
        g.setFont(font25B);
        g.drawString("Faculty Feedback Form", 260, 30);

        Font font15 = new Font("SansSerif", Font.PLAIN, 15);
        g.setFont(font15);
        g.drawString("On a score of 1 to 5, please evaluate your Faculty:", 180, 70 + y);
        g.setColor(Color.RED);
        Font font15B = new Font("SansSerif", Font.BOLD, 15);
        g.setFont(font15B);
        g.drawString("1-Strongly disagree  2-Disagree  3-Sometimes  4-Agree  5-Strongly Agree  ", 180, 90 + y);

        Font font17 = new Font("SansSerif", Font.PLAIN, 17);
        g.setFont(font17);
        g.setColor(Color.BLACK);
        g.drawString("Name : ", 150, 150 + y);
        g.drawString("Registration No : ", 350, 150 + y);
        g.drawString("Sem :", 150, 200 + y);
        g.drawString("Section :", 310, 200 + y);
        g.drawString("Email :", 490, 200 + y);


        g.drawString("Faculty Name :", 150, 300 + y);
        g.drawString("Subject :", 390, 300 + y);
        g.drawString("Score :", 600, 300 + y);

        g.drawString("Faculty Name :", 150, 350 + y);
        g.drawString("Subject :", 390, 350 + y);
        g.drawString("Score :", 600, 350 + y);

        g.drawString("Faculty Name :", 150, 400 + y);
        g.drawString("Subject :", 390, 400 + y);
        g.drawString("Score :", 600, 400 + y);

        g.drawString("Faculty Name :", 150, 500 + y);
        g.drawString("Subject :", 390, 500 + y);
        g.drawString("Score :", 600, 500 + y);

        g.drawString("Faculty Name :", 150, 550 + y);
        g.drawString("Subject :", 390, 550 + y);
        g.drawString("Score :", 600, 550 + y);


        Font font18 = new Font("SansSerif", Font.PLAIN, 18);
        g.setFont(font18);
        g.drawString("Theory Subject ", 180, 250 + y);
        g.drawString("Practical Subject ", 180, 450 + y);

    }

}
