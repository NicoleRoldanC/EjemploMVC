
package Vista;

import Control.MenuPrincipal_Control;
import javax.swing.JButton;
import javax.swing.JFrame;

//Nicole Roldan
//Codigo:2355039

//Aqui tendremos solo la parte de la GUI del MenuPrincipal
// porque hace parte de VISTA

public class MenuPrincipal extends JFrame {
    
    public JButton jbUser, jbSalir; //lo declaramos como public para poder usarlo en otras clases
    MenuPrincipal_Control mpc; //llamamos la otra clase
    
    public MenuPrincipal(){
        super("Menu principal");
        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null);
        
        mpc = new MenuPrincipal_Control(this); //instanciamos la clase MenuPrincipal_Control
        addWindowListener(mpc);
        
        crearGUI();
        
        setVisible(true);
    }
    
    public void crearGUI(){
        
        //Boton usuarios
        jbUser = new JButton("Usuarios");
        jbUser.setBounds(50,40,200,30);
        jbUser.addActionListener(mpc); 
        add(jbUser);
        
        //Boton salir
        jbSalir = new JButton("Salir");
        jbSalir.setBounds(50,90,200,30);
        jbSalir.addActionListener(mpc);
        add(jbSalir);
    }

    public static void main(String[] args) {
        MenuPrincipal obj = new MenuPrincipal();
    }
    
}
