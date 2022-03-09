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
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnOk.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        //Listar la tabla al momento de correr/iniciar el programa
        listar(vista.tabla);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Si dan click al boton Listar se manda a llamar al metodo Listar
        if(e.getSource()==vista.btnListar){
            limpiarTabla();
            listar(vista.tabla);
        }
        //Si dan click al boton Guardar se manda a llamar al metodo Guardar
        if(e.getSource() == vista.btnGuardar){
            agregar();
            limpiarTabla();
            listar(vista.tabla);
        }
        //Si dan click al boton Editar se manda a llamar al metodo Editar y se podra seleccionar una fila
        if(e.getSource() == vista.btnEditar){
            int fila = vista.tabla.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(vista, "Debe seleccionar una Fila");
            }
            else{
                int id = Integer.parseInt((String)vista.tabla.getValueAt(fila, 0).toString());
                String nom = (String)vista.tabla.getValueAt(fila, 1);
                String correo = (String)vista.tabla.getValueAt(fila, 2);
                String tel = (String)vista.tabla.getValueAt(fila, 3);
                vista.txtId.setText(""+id);
                vista.txtNombre.setText(nom);
                vista.txtCorreo.setText(correo);
                vista.txtTelefono.setText(tel);
            }
        }
        //Accion al dar click de Ok (Actualizar)
        if(e.getSource() == vista.btnOk){
            Actualizar();
            limpiarTabla();
            listar(vista.tabla);
        }
        //Accion al dar click de Eliminar
        if(e.getSource() == vista.btnEliminar){
            delete();
            limpiarTabla();
            listar(vista.tabla);
        }
    }

    //Metodo Delete
    public void delete(){
        int fila = vista.tabla.getSelectedRow();
        if(fila == -1){
                JOptionPane.showMessageDialog(vista, "Debes seleccionar un Usuario de la tabla");
        }else{
            int id = Integer.parseInt((String) vista.tabla.getValueAt(fila, 0).toString());
            dao.delete(id);
            JOptionPane.showMessageDialog(vista, "Usuario Eliminado");
        }
    }

    //Metodo Actualizar
    void limpiarTabla(){
        for(int i = 0; i < vista.tabla.getRowCount(); i++){
            modelo.removeRow(i);
            i = i-1;
        }
    }

    //Metodo Actualizar
    public void Actualizar(){
        int id = Integer.parseInt(vista.txtId.getText());
        String nom = vista.txtNombre.getText();
        String correo = vista.txtCorreo.getText();
        String tel = vista.txtTelefono.getText();
        p.setId(id);
        p.setNom(nom);
        p.setCorreo(correo);
        p.setTel(tel);
        int r = dao.Actualizar(p);
        if(r == 1){
            JOptionPane.showMessageDialog(vista, "Usuario actualizado con exito");
        }else {
            JOptionPane.showMessageDialog(vista, "Error");
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
