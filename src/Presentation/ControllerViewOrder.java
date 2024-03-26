package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerViewOrder {
    private ViewOrder vo;
    private MainView mv;
    public ControllerViewOrder(ViewOrder vo, MainView mv)
    {

        this.vo = vo;
        this.mv = mv;
        //....
        vo.Back(new Back());
    }
    class Add implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(vo.getAddOrder() == e.getSource())
            {

            }
        }
    }

    class Back implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(vo.getButonBack() == e.getSource())
            {
                //MainView mv = new MainView();
                mv.getFrame().setVisible(true);
                vo.getFrame().setVisible(false);
            }
        }
    }
}
