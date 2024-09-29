
package Modelo;

import Control.User_Control;
import java.io.BufferedReader;
import java.io.FileReader;
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
    
    public void consultar(String id_buscar){
        FileReader fr = null;
        boolean error = false; //Declaramos un booleano en caso de que algo salga mal, se inicializa en false      
        try {
            fr = new FileReader("usuarios.csv");           
        } catch (Exception e) {
            error = true;
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo usuarios.csv");
        }
        
        //Si no hay error entonces...
        if (!error){
            BufferedReader br = new BufferedReader(fr);
            String registro = "";
            boolean existe = false;
            try{
                while((registro = br.readLine()) != null){
                    //System.out.println(registro); //esto mostraria toda la informacion que hemos guardado
                    String tokens[] = registro.split(";"); //Aqui dividimos el registro por ;
                    if(tokens[0].equals(id_buscar)){ //si lo que aparece en la primera columna (0), es igual al ID que busco..
                        existe = true;
                        //System.out.print(registro); //en ese caso imprime el registro //PARA PROBAR
                        user_control.objUser.jtID.setText(tokens[0]);
                        user_control.objUser.jtApe.setText(tokens[1]);
                        user_control.objUser.jtNom.setText(tokens[2]);
                        if(tokens[3].equals("Activo"))
                            user_control.objUser.jrActivo.setSelected(true);
                        else
                            user_control.objUser.jrInactivo.setSelected(true);
     
                    }
                }
                if(!existe){
                    JOptionPane.showMessageDialog(null, "El usuario co ID = " + id_buscar + 
                            " no existe en el archivo usuarios.csv");
                    
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error al leer el archivo usuarios.csv");            
            }
            
            try {                //Cerrar el doc
                fr.close(); //Hay que cerrar o se puede perder info
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el archivo usuarios.csv");
            }

        }
    }
}
