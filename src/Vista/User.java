
package Vista;

import Control.User_Control;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//En vista solo debe estar la creacion de la ventana y la parte visual
public class User extends JFrame {
    
    public JTextField jtID, jtApe, jtNom;   //todo lo de aca es lo que vamos a usar
    public JRadioButton jrActivo, jrInactivo, jrOculto;
    public JButton jbGuardar, jbVolver;
    public MenuPrincipal mp; //Declaramos un obj del menuprincipal para poder acceder a el desde user
    public User_Control user_control;
    
    //Esta es la parte de la creacion de la ventana user
    public User(MenuPrincipal mp){ //el formulario de usuario debe recibir el obj que declaremos antes del menu principal (MenuPrincipal mp)
        super("Menu usuarios");
        this.mp=mp; //usamos this para distinguir entre el obj que declaramos con el que recibe. ya con esto podemos acceder al menu principal desde usuario
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null);
        crearGUI();
        
        setVisible(true);
        
        
    }
    
    //Interfaz grafica de esa ventana
    private void crearGUI() {
        
        //Creacion y diseño de la ventana
        
        JLabel jl = new JLabel(" Gestion de usuarios");
        jl.setBounds(0,0,400,50);
        jl.setOpaque(true);
        jl.setBackground(Color.WHITE);
        jl.setForeground(Color.red);
        jl.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(jl);
        
        //Num ID
        JLabel jlID = new JLabel("Numero de ID:");
        jlID.setBounds(30,70,120,25);
        add(jlID);
        
        jtID = new JTextField();
        jtID.setBounds(150,70,150,25);
        add(jtID);
        
        //Apellido
        JLabel jlApe = new JLabel("Apellido:");
        jlApe.setBounds(30,105,120,25);
        add(jlApe);
        
        jtApe = new JTextField();
        jtApe.setBounds(150,105,150,25);
        add(jtApe);
        
        //Nombre
        JLabel jlNom = new JLabel("Nombre:");
        jlNom.setBounds(30,140,120,25);
        add(jlNom);
        
        jtNom = new JTextField();
        jtNom.setBounds(150,140,150,25);
        add(jtNom);
        
        //Estado
        JLabel jlEstado = new JLabel("Estado:");
        jlEstado.setBounds(30,175,120,25);
        add(jlEstado);
        
        jrActivo = new JRadioButton("Activo");
        jrActivo.setBounds(150,175,120,25);
        add(jrActivo);
        
        jrInactivo = new JRadioButton("Inactivo");
        jrInactivo.setBounds(270,175,120,25);
        add(jrInactivo);
        
        jrOculto = new JRadioButton(); //Para que el JRadioButton de activo e inactivo no quede seleccionado por siempre
        add(jrActivo);
        add(jrInactivo);
        add(jrOculto);
        
        
        ButtonGroup bg = new ButtonGroup(); //esto es para que quede seleccionado uno a la vez
        bg.add(jrActivo);
        bg.add(jrInactivo);
        
        
        user_control = new User_Control(this); //creamos un obj para user
        
        //Boton Guardar
        jbGuardar = new JButton("Guardar");
        jbGuardar.setBounds(30,220,100,25);
        jbGuardar.addActionListener(user_control);
        add(jbGuardar);
        
        //Boton volver
        jbVolver = new JButton("Volver");
        jbVolver.setBounds(140,220,100,25);
        jbVolver.addActionListener(user_control);
        add(jbVolver);
           
    }
    
}
