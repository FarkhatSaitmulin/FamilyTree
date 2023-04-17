import FamilyTrees.FamilyTree;
import Humans.Human;
import Services.Service;
import Sex.Sex;
import pesenter.Presenter;
import ui.Console;
import ui.View;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        View view = new Console();
        Service service = new Service();
        Presenter presenter = new Presenter(view, service);
        view.start();
    }
}


