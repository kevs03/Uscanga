package controlador;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import modelo.Persona;
import modelo.PersonaDAO;
import vista.Vista;

/**
 *
 * @author kevin
 */
public class Controlador implements ActionListener{
    

    PersonaDAO dao = new PersonaDAO();
    Persona p = new Persona();
    Vista vista = new Vista();
    DefaultTableModel modelo = new DefaultTableModel();

    public Controlador(Vista v){
        this.vista = v;
        this.vista.btnListar.addActionListener(this);
        this.vista.btnGuardar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Si dan click al boton Listar se manda a llamar al metodo Listar
        if(e.getSource()==vista.btnListar){
            listar(vista.tabla);
        }
        //Si dan click al boton Guardar se manda a llamar al metodo Guardar
        if(e.getSource() == vista.btnGuardar){
            agregar();
        }
    }
//Metodo Agregar
    public void agregar(){
    String nom = vista.txtNombre.getText();
    String correo = vista.txtCorreo.getText();
    String tel = vista.txtTelefono.getText();
    p.setNom(nom);
    p.setCorreo(correo);
    p.setTel(tel);
    int r = dao.agregar(p);
    if(r == 1){
        JOptionPane.showMessageDialog(vista, "Usuario agregado con exito");
    }else {
        JOptionPane.showMessageDialog(vista, "Error");
    }
}

//Metodo Listar
    public void listar(JTable tabla){
        modelo = (DefaultTableModel)tabla.getModel();
        List<Persona>lista=dao.listar();
        Object[]object = new Object[4];
        for (int i = 0; i < lista.size(); i++){
            object[0]=lista.get(i).getId();
            object[1]=lista.get(i).getNom();
            object[2]=lista.get(i).getCorreo();
            object[3]=lista.get(i).getTel();
            modelo.addRow(object);
        }
        vista.tabla.setModel(modelo);
    }

}
