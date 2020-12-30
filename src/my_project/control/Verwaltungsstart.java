package my_project.control;

import KAGO_framework.control.ViewController;

public class Verwaltungsstart {

    private ViewControll vC;
    private ViewController viewController;
    private SQLControll sqlControll;

    public Verwaltungsstart(ViewController viewController){
        this.viewController = viewController;

        vC = new ViewControll(viewController);
        sqlControll = new SQLControll();
    }
}
