package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerViewProduct {
    private ViewProduct vp;
    private MainView mv;

    public ControllerViewProduct(ViewProduct vp, MainView mv)
    {
        this.vp = vp;
        this.mv = mv;
        vp.Back(new Back());
        //....
    }

    class Add implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(vp.getButonAdd() == e.getSource())
            {

            }
        }
    }

    class Edit implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(vp.getButonEdit() == e.getSource())
            {

            }
        }
    }

    class Delete implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(vp.getButonDelete() == e.getSource())
            {

            }
        }
    }

    class Back implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(vp.getButonBack() == e.getSource())
            {
                //MainView mv = new MainView();
                mv.getFrame().setVisible(true);
                vp.getFrame().setVisible(false);
            }
        }
    }
}
