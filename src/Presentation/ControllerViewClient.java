package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerViewClient {
    private ViewClient vc;
    private MainView mv;
    public ControllerViewClient(ViewClient vc, MainView mv)
    {
        this.vc = vc;
        this.mv = mv;
        vc.Back(new Back());
        //.....
    }

    class Add implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(vc.getButonAdd() == e.getSource())
            {
                int id = Integer.parseInt(vc.getTextId().getText());
                //ClientBLL clientBLL = new ClientBLL();
                //Client client = clientBLL.findClientById(id);
                //t2.setText(client.getName());
                //t3.setText(client.getAddress());
                //t4.setText(client.getEmail());
                //t5.setText(Integer.toString(client.getAge()));
            }
        }
    }

    class Edit implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(vc.getButonEdit() == e.getSource())
            {

            }
        }
    }

    class Delete implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(vc.getButonDelete() == e.getSource())
            {

            }
        }
    }

    class Back implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(vc.getButonBack() == e.getSource())
            {
                //MainView mv = new MainView();
                mv.getFrame().setVisible(true);
                vc.getFrame().setVisible(false);
            }
        }
    }

}
