package Controllers;

import Dichvu.DichvuAcc;
import Login.LoginView;

public class ControllerLogin {
    public DichvuAcc dichvuAcc;
    public LoginView loginView;

    public ControllerLogin() {
        dichvuAcc = new DichvuAcc();
        loginView = new LoginView();
    }
    public void choiceRegister(){
        dichvuAcc.addAcc(dichvuAcc.createAcc());
    }
}
