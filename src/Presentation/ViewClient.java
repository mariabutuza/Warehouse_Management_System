package Presentation;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;


public class ViewClient extends JFrame {
    private JFrame frame;
    private JTextField textId;
    private JTextField textNume;
    private JTextField textAdresa;  //cantitate
    private JTextField textEmail;   //pret
    private JTextField textVarsta;
    private JLabel labelProdus;
    private JLabel labelId;
    private JLabel labelNume;
    private JLabel labelAdresa;
    private JLabel labelEmail;
    private JLabel labelVarsta;
    private JButton butonAdd;
    private JButton butonDelete;
    private JButton butonEdit;
    private JButton butonBack;
    private JTable productTable;

    //ControllerViewClient cvc = new ControllerViewClient(this);

    public ViewClient(){
        this.butonAdd = new JButton("ADD");
        this.butonDelete = new JButton("DELETE");
        this.butonEdit = new JButton("EDIT");
        this.butonBack = new JButton("BACK");

        this.labelId =  new JLabel("ID");
        this.labelNume = new JLabel("NAME");
        this.labelAdresa = new JLabel("ADRESS");
        this.labelEmail = new JLabel("EMAIL");
        this.labelVarsta = new JLabel("AGE");
        this.labelProdus = new JLabel("CLIENT");

        this.textId = new JTextField();
        this.textNume = new JTextField();
        this.textAdresa = new JTextField();
        this.textEmail = new JTextField();
        this.textVarsta = new JTextField();

        this.productTable = new JTable();

        //butonAdd.addActionListener((ActionListener) cvc);

        initialize();
    }

    public void initialize()
    {
        frame = new JFrame();
        frame.setForeground(SystemColor.text);
        frame.setBounds(100, 100, 755, 540);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        labelProdus.setBounds(302, 55, 142, 34);
        labelId.setBounds(45, 132, 45, 13);
        labelNume.setBounds(183, 123, 84, 30);
        labelAdresa.setBounds(332, 121, 84, 34);
        labelEmail.setBounds(481, 121, 84, 34);
        labelVarsta.setBounds(627, 123, 84, 30);

        textId.setBounds(10, 155, 125, 34);
        textNume.setBounds(155, 155, 132, 34);
        textAdresa.setBounds(312, 155, 132, 34);
        textEmail.setBounds(462, 155, 125, 34);
        textVarsta.setBounds(606, 155, 125, 34);

        butonAdd.setBounds(302, 239, 125, 50);
        butonDelete.setBounds(127, 243, 116, 43);
        butonEdit.setBounds(491, 243, 116, 43);
        butonBack.setBounds(10, 467, 87, 27);
        productTable.setBounds(73, 318, 605, 138);

        labelProdus.setFont(new Font("Times New Roman", Font.BOLD, 25));
        labelId.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        labelNume.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        labelAdresa.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        labelEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        labelVarsta.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        butonAdd.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        butonEdit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        butonDelete.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        butonBack.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        productTable.setFont(new Font("Times New Roman", Font.PLAIN, 18));


        labelProdus.setHorizontalAlignment(SwingConstants.CENTER);
        labelId.setHorizontalAlignment(SwingConstants.CENTER);
        labelNume.setHorizontalAlignment(SwingConstants.CENTER);
        labelAdresa.setHorizontalAlignment(SwingConstants.CENTER);
        labelEmail.setHorizontalAlignment(SwingConstants.CENTER);
        labelVarsta.setHorizontalAlignment(SwingConstants.CENTER);

        textAdresa.setColumns(10);
        textId.setColumns(10);
        textNume.setColumns(10);
        textEmail.setColumns(10);
        textVarsta.setColumns(10);

        frame.getContentPane().add(labelProdus);
        frame.getContentPane().add(labelId);
        frame.getContentPane().add(labelNume);
        frame.getContentPane().add(labelAdresa);
        frame.getContentPane().add(labelEmail);
        frame.getContentPane().add(labelVarsta);
        frame.getContentPane().add(textId);
        frame.getContentPane().add(textNume);
        frame.getContentPane().add(textAdresa);
        frame.getContentPane().add(textEmail);
        frame.getContentPane().add(textVarsta);
        frame.getContentPane().add(butonAdd);
        frame.getContentPane().add(butonDelete);
        frame.getContentPane().add(butonEdit);
        frame.getContentPane().add(butonBack);
        frame.getContentPane().add(productTable);
    }

    public JTextField getTextId() {
        return textId;
    }

    public JTextField getTextNume() {
        return textNume;
    }

    public JTextField getTextAdresa() {
        return textAdresa;
    }

    public JTextField getTextEmail() {
        return textEmail;
    }

    public JTextField getTextVarsta() {
        return textVarsta;
    }

    public JButton getButonAdd() {
        return butonAdd;
    }

    public JButton getButonDelete() {
        return butonDelete;
    }

    public JButton getButonEdit() {
        return butonEdit;
    }

    public JButton getButonBack() {
        return butonBack;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void Back(ActionListener butonBack)
    {
        this.butonBack.addActionListener(butonBack);
    }
}
