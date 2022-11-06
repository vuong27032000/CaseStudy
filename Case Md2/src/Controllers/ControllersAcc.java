package Controllers;

import Dichvu.DichvuAcc;
import Login.AccountView;

public class ControllersAcc {
    public DichvuAcc dichvuAcc;
    public AccountView accountView;
    public ControllersAcc(){
        dichvuAcc = new DichvuAcc();
        accountView = new AccountView();
    }
    public void choiceAcc(){
        int choice = -1;
        while (choice != 5){
            choice = accountView.menuAccount();
            switch (choice){
                case 1 ->dichvuAcc.addAcc(dichvuAcc.createAcc());
                case 2 ->dichvuAcc.editAcc(dichvuAcc.searchAcc());
                case 3 ->dichvuAcc.deleteAcc(dichvuAcc.searchAcc());
                case 4 ->dichvuAcc.displayAcc();
                case 0 ->{
                    System.out.println("Back menu!");
                    return;
                }
            }
        }
    }
}
