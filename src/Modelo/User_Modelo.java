
package Modelo;

import Control.User_Control;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class User_Modelo {
    
    public User_Control user_control; //crea User_Control porque es quien lo llama
    
    public User_Modelo(User_Control user_control){ //declaramos construcutor. nuestra clase User_Modelo recibe un obj que es User_Control. Lo del ()es lo que recibe
        this.user_control = user_control;       
    }
    
    public void guardar(ArrayList<String> datos){
        /*for(String item: datos){ //recorrer cada uno de los datos y a guardar en item (dato)
            System.out.println(item);
        }*/ //Este pequeño bucle es para probar que esta capturando bien la info
        
        FileWriter fw = null; //creamos un arhico de texto con extension csv
        boolean error = false;
        try {
            fw = new FileWriter("Usuarios.csv", true);
        } catch (Exception e) {
            error = true;
            JOptionPane.showMessageDialog(null, "Error al crear el archivo usuarios.csv");           
        }
        if (!error){ //si no hay error entonces..-
            try{
                fw.write(datos.get(0) + ";" + datos.get(1) + ";" + datos.get(2) + ";" +  //para que escriba la info de esa forma exactamente
                        datos.get(3) + "\r\n" );   
                
                //Una vez los guarde de manera correcta..
                JOptionPane.showMessageDialog(null, "Se guardo con exito el usuario");    
                limpiar(); //creamos un nuevo metodo para poder actualizar la info
                
                
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error al guardar en el archivo usuarios.csv");               
            }
            try {
                fw.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el archivo usuarios.csv");
            }
        }
    }

    private void limpiar() { 
        user_control.objUser.jtID.setText("");
        user_control.objUser.jtApe.setText("");
        user_control.objUser.jtNom.setText("");
        user_control.objUser.jrOculto.setSelected(true); //para limpiar el JRadioButton
        
    }
}
