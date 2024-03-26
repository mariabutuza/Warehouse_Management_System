package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    private JFrame frame;
    private JButton butonProdus;
    private JButton butonClient;
    private JButton butonComanda;

    public MainView()
    {
        this.butonProdus = new JButton("PRODUCT");
        this.butonClient = new JButton("CLIENT");
        this.butonComanda = new JButton("ORDER");

        initialize();
    }

    void initialize()
    {
        frame = new JFrame();
        frame.setForeground(SystemColor.text);
        frame.setBounds(100, 100, 705, 485);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        butonProdus.setBounds(184, 76, 307, 77);
        butonClient.setBounds(184, 176, 307, 77);
        butonComanda.setBounds(184, 280, 307, 77);

        butonProdus.setBackground(UIManager.getColor("Button.shadow"));
        butonClient.setBackground(UIManager.getColor("Button.shadow"));
        butonComanda.setBackground(UIManager.getColor("Button.shadow"));

        butonProdus.setFont(new Font("Times New Roman", Font.BOLD, 26));
        butonClient.setFont(new Font("Times New Roman", Font.BOLD, 26));
        butonComanda.setFont(new Font("Times New Roman", Font.BOLD, 26));

        frame.getContentPane().add(butonProdus);
        frame.getContentPane().add(butonClient);
        frame.getContentPane().add(butonComanda);
    }

    public JButton getButonProdus() {
        return butonProdus;
    }

    public JButton getButonClient() {
        return butonClient;
    }

    public JButton getButonComanda() {
        return butonComanda;
    }

    public void Produs(ActionListener butonProdus)
    {
        this.butonProdus.addActionListener(butonProdus);
    }

    public void Client(ActionListener butonClient)
    {
        this.butonClient.addActionListener(butonClient);
    }

    public void Comanda(ActionListener butonComanda)
    {
        this.butonComanda.addActionListener(butonComanda);
    }

    public JFrame getFrame() {
        return frame;
    }
}
