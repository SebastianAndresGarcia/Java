/*
AMPPS para conectar a mysql
 */
package Controlador;

import Vista.JF_Menu;

/**
 *
 * @author hp
 */
public class Main {
    public static void main(String[] args) {
        
        JF_Menu menuPrincipal  = new JF_Menu();
        ControladorMenu controlMenu = new ControladorMenu(menuPrincipal);
        menuPrincipal.setVisible(true);
    }
}
