package Controllers;

import Dichvu.DichvuGame;
import Login.MenuMainView;

public class ControllerMenu {
    public MenuMainView menuMainView;
    public DichvuGame dichvuGame;

    public ControllerMenu() {
        menuMainView = new MenuMainView();
        dichvuGame = new DichvuGame();
    }
}
