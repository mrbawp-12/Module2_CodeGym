package menu;

import lib.Input;

public class MainMenu {
    private AuthMenu authMenu;

    public MainMenu() {
        this.authMenu = new AuthMenu();
    }

    public void showMain(){
        this.authMenu.showAuthMenu();
    }
}