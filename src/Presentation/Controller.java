package Presentation;

import Model.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private MainView mv;
    //private ViewClient vc;
    //private ViewProduct vp;
    private ViewOrder vo;
    private ControllerViewOrder cvo;
    private ControllerViewClient cvc;
    private ControllerViewProduct cvp;

    public Controller(MainView mv)
    {
        this.mv = mv;
        mv.Produs(new Produs());
        mv.Client(new Client());
        mv.Comanda(new Comanda());

    }

    class Produs implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(mv.getButonProdus() == e.getSource())
            {
                ViewProduct vp = new ViewProduct();
                cvp = new ControllerViewProduct(vp,mv);
            }
        }
    }

    class Client implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(mv.getButonClient() == e.getSource())
            {
                ViewClient vc = new ViewClient();
                cvc = new ControllerViewClient(vc,mv);
            }
        }
    }

    class Comanda implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(mv.getButonComanda() == e.getSource())
            {
                ViewOrder vo = new ViewOrder();
                cvo = new ControllerViewOrder(vo,mv);
            }
        }
    }

}
