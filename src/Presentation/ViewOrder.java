package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewOrder extends JFrame {
    private JFrame frame;
    private JLabel labelCantitate;
    private JLabel labelOrder;
    private JTextField textCantitate;
    private JButton addOrder;
    private JButton butonBack;

    public ViewOrder()
    {
        this.textCantitate = new JTextField();
        this.labelCantitate = new JLabel("QUANTITY");
        this.labelOrder = new JLabel("ORDER");
        this.addOrder = new JButton("ADD ORDER");
        this.butonBack = new JButton("BACK");

        initialize();
    }

    private void initialize()
    {
        frame = new JFrame();
        frame.setForeground(SystemColor.text);
        frame.setBounds(100, 100, 755, 540);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        labelOrder.setBounds(302, 55, 142, 34);
        labelCantitate.setBounds(78, 412, 112, 34);
        textCantitate.setBounds(192, 412, 47, 34);
        addOrder.setBounds(519, 423, 164, 41);
        butonBack.setBounds(10, 467, 87, 27);

        labelOrder.setFont(new Font("Times New Roman", Font.BOLD, 25));
        labelCantitate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        addOrder.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        butonBack.setFont(new Font("Times New Roman", Font.PLAIN, 18));

        labelOrder.setHorizontalAlignment(SwingConstants.CENTER);
        labelCantitate.setHorizontalAlignment(SwingConstants.CENTER);

        textCantitate.setColumns(10);

        frame.getContentPane().add(labelOrder);
        frame.getContentPane().add(labelCantitate);
        frame.getContentPane().add(textCantitate);
        frame.getContentPane().add(addOrder);
        frame.getContentPane().add(butonBack);
    }

    public JTextField getTextCantitate() {
        return textCantitate;
    }

    public JButton getAddOrder() {
        return addOrder;
    }

    public JButton getButonBack() {
        return butonBack;
    }
    public void Back(ActionListener butonBack)
    {
        this.butonBack.addActionListener(butonBack);
    }

    public JFrame getFrame() {
        return frame;
    }
}
