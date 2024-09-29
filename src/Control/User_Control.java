
package Control;

import Modelo.User_Modelo;
import Vista.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//En control obtenemos datos
public class User_Control implements ActionListener{
    
    public User objUser;
    public User_Modelo user_modelo; //para poder ser usado desde User_Modelo
    
    public User_Control(User obj){
        objUser = obj;     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(objUser.jbGuardar)){  //si la fuente del evento es jbGuardar   
            
            //TODA ESTA PARTE LO HACEMOS PRIMERO PARA PROBAR QUE ESTA FUNCIONANDO LA CAPTURA DE DATOS
            /*System.out.println(objUser.jtID.getText());
            System.out.println(objUser.jtApe.getText());
            System.out.println(objUser.jtNom.getText());
            if(objUser.jrActivo.isSelected()) System.out.print("Activo");
            else System.out.print("Inactivo");*/
             
            //Aqui ya toma los datos capturados y los pasa al modelo
            ArrayList<String> datos = new ArrayList<>(); //Creo una lista para enviar los datos a la otra capa (modelo) 
            datos.add(objUser.jtID.getText()); //en todas estas esta guardando la info en el array (info como objID)
            datos.add(objUser.jtApe.getText());
            datos.add(objUser.jtNom.getText());
            if(objUser.jrActivo.isSelected()) datos.add("Activo");
            else datos.add("Inactivo");
            
            user_modelo = new User_Modelo(this); //instanciamos user modelo
            user_modelo.guardar(datos); //ya con esto user_modelo puede guardar la info en datos
            
        //Si el boton seleccionado es... 
        }
        if(e.getSource().equals(objUser.jbVolver)){  //si la fuente del evento es jbVolver
            evento_volver();
        } 
        if(e.getSource().equals(objUser.jbConsultar)){  //si la fuente del evento es jbConsultar
            String id_buscar = objUser.jtID.getText(); //definimos un nombre para la accion de buscar que estamos haciendo. En este caso buscamos por ID, info que sacamos de user.java
            
            user_modelo = new User_Modelo(this);
            user_modelo.consultar(id_buscar);              
        }
                     
    }

    private void evento_volver() {
        objUser.setVisible(false); //el evento es que si le da en volver, ocultamos la ventana del formulario user
        objUser.dispose();
        objUser.mp.setVisible(true); //objUser.mp para acceder al menu principal. Lo que sigue a continuacion es el evento como tal, en este caso mostrar el menu principal desde user        
    }
        
}
