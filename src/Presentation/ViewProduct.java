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


public class ViewProduct extends JFrame {
    private JFrame frame;
    private JTextField textId;
    private JTextField textNume;
    private JTextField textCantitate;
    private JTextField textPret;
    private JLabel labelProdus;
    private JLabel labelId;
    private JLabel labelNume;
    private JLabel labelPret;
    private JLabel labelCantitate;
    private JButton butonAdd;
    private JButton butonDelete;
    private JButton butonEdit;
    private JButton butonBack;
    private JTable productTable;


    public ViewProduct(){
        this.butonAdd = new JButton("ADD");
        this.butonDelete = new JButton("DELETE");
        this.butonEdit = new JButton("EDIT");
        this.butonBack = new JButton("BACK");

        this.labelId =  new JLabel("ID");
        this.labelNume = new JLabel("NAME");
        this.labelCantitate = new JLabel("QUANTITY");
        this.labelPret = new JLabel("PRICE");
        this.labelProdus = new JLabel("PRODUCT");

        this.textId = new JTextField();
        this.textNume = new JTextField();
        this.textCantitate = new JTextField();
        this.textPret = new JTextField();

        this.productTable = new JTable();

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
        labelId.setBounds(73, 132, 45, 13);
        labelNume.setBounds(232, 123, 84, 30);
        labelCantitate.setBounds(400, 123, 107, 30);
        labelPret.setBounds(598, 121, 73, 34);

        textId.setBounds(40, 155, 125, 34);
        textNume.setBounds(209, 155, 137, 34);
        textCantitate.setBounds(390, 155, 130, 34);
        textPret.setBounds(576, 155, 125, 34);

        butonAdd.setBounds(302, 239, 125, 50);
        butonDelete.setBounds(127, 243, 116, 43);
        butonEdit.setBounds(491, 243, 116, 43);
        butonBack.setBounds(10, 467, 87, 27);
        productTable.setBounds(73, 318, 605, 138);

        labelProdus.setFont(new Font("Times New Roman", Font.BOLD, 25));
        labelId.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        labelNume.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        labelCantitate.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        labelPret.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        butonAdd.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        butonEdit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        butonDelete.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        butonBack.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        productTable.setFont(new Font("Times New Roman", Font.PLAIN, 18));

        labelProdus.setHorizontalAlignment(SwingConstants.CENTER);
        labelId.setHorizontalAlignment(SwingConstants.CENTER);
        labelNume.setHorizontalAlignment(SwingConstants.CENTER);
        labelCantitate.setHorizontalAlignment(SwingConstants.CENTER);
        labelPret.setHorizontalAlignment(SwingConstants.CENTER);

        textCantitate.setColumns(10);
        textId.setColumns(10);
        textNume.setColumns(10);
        textPret.setColumns(10);

        frame.getContentPane().add(labelProdus);
        frame.getContentPane().add(labelId);
        frame.getContentPane().add(labelNume);
        frame.getContentPane().add(labelCantitate);
        frame.getContentPane().add(labelPret);
        frame.getContentPane().add(textId);
        frame.getContentPane().add(textNume);
        frame.getContentPane().add(textCantitate);
        frame.getContentPane().add(textPret);
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

    public JTextField getTextCantitate() {
        return textCantitate;
    }

    public JTextField getTextPret() {
        return textPret;
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
