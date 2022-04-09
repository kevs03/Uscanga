package controlador;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
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
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Si dan click al boton Listar se manda a llamar al metodo Listar
        if(e.getSource()==vista.btnListar){
            limpiarTabla();
            listar(vista.tabla);
            nuevo();
        }
        //Si dan click al boton Guardar se manda a llamar al metodo Guardar
        if(e.getSource() == vista.btnAgregar){
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
                int id = Integer.parseInt((String) vista.tabla.getValueAt(fila, 0).toString());
                String nom = (String) vista.tabla.getValueAt(fila, 1);
                String nom2 = (String) vista.tabla.getValueAt(fila, 2);
                String correo = (String) vista.tabla.getValueAt(fila, 3);
                String tel = (String) vista.tabla.getValueAt(fila, 4);
                String ubicacion = (String) vista.tabla.getValueAt(fila, 5);
                String fecha = (String) vista.tabla.getValueAt(fila, 6);
                vista.txtId.setText("" + id);
                vista.txtNom.setText(nom);
                vista.txtNom2.setText(nom2);
                vista.txtCorreo.setText(correo);
                vista.txtTel.setText(tel);
                vista.txtUbicacion.setText(ubicacion);
                vista.txtFecha.setText(fecha);
            }
        }
        //Accion al dar click de Ok (Actualizar)
        if(e.getSource() == vista.btnActualizar){
            Actualizar();
            listar(vista.tabla);
            nuevo();
        }
        //Accion al dar click de Eliminar
        if(e.getSource() == vista.btnEliminar){
            delete();
            listar(vista.tabla);
            nuevo();
        }
    }

    //Metodo Nuevo
    void nuevo() {
        vista.txtId.setText("");
        vista.txtNom.setText("");
        vista.txtNom2.setText("");
        vista.txtTel.setText("");
        vista.txtCorreo.setText("");
        vista.txtUbicacion.setText("");
        vista.txtFecha.setText("");
        vista.txtNom.requestFocus();
        vista.txtNom2.requestFocus();
    }

    //Metodo Delete
    public void delete(){
        int fila = vista.tabla.getSelectedRow();
        if(fila == -1){
                JOptionPane.showMessageDialog(vista, "Debes seleccionar un Usuario de la tabla");
        }else{
            int id = Integer.parseInt((String) vista.tabla.getValueAt(fila, 0).toString());
            dao.delete(id);
            System.out.println("El Resultado es " + id);
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
        if (vista.txtId.getText().equals("")) {
            JOptionPane.showMessageDialog(vista, "No se Identifica el Id debe selecionar la opcion Editar");
        } else {
            int id = Integer.parseInt(vista.txtId.getText());
            String nom = vista.txtNom.getText();
            String nom2 = vista.txtNom2.getText();
            String correo = vista.txtCorreo.getText();
            String tel = vista.txtTel.getText();
            String ubicacion = vista.txtUbicacion.getText();
            String fecha = vista.txtFecha.getText();
            p.setId(id);
            p.setNom(nom);
            p.setNom2(nom2);
            p.setCorreo(correo);
            p.setTelefono(tel);
            p.setUbicacion(ubicacion);
            p.setFecha(fecha);
            int r = dao.Actualizar(p);
            if (r == 1) {
                JOptionPane.showMessageDialog(vista, "Usuario Actualizado con Exito.");
            } else {
                JOptionPane.showMessageDialog(vista, "Error");
            }
        }
        limpiarTabla();
}


//Metodo Agregar
    public void agregar(){
        String nom = vista.txtNom.getText();
        String nom2 = vista.txtNom2.getText();
        String correo = vista.txtCorreo.getText();
        String tel = vista.txtTel.getText();
        String ubicacion = vista.txtUbicacion.getText();
        String fecha = vista.txtFecha.getText();
        p.setNom(nom);
        p.setNom2(nom2);
        p.setCorreo(correo);
        p.setTelefono(tel);
        p.setUbicacion(ubicacion);
        p.setFecha(fecha);
        int r = dao.agregar(p);
        if(r == 1){
            JOptionPane.showMessageDialog(vista, "Usuario agregado con exito");
        }else {
            JOptionPane.showMessageDialog(vista, "Error");
        }
        limpiarTabla();
}

//Metodo Listar
    public void listar(JTable tabla){
        centrarCeldas(tabla);
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Persona> lista = dao.listar();
        Object[] objeto = new Object[7];
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getNom();
            objeto[2] = lista.get(i).getNom2();
            objeto[3] = lista.get(i).getCorreo();
            objeto[4] = lista.get(i).getTelefono();
            objeto[5] = lista.get(i).getUbicacion();
            objeto[6] = lista.get(i).getFecha();
            modelo.addRow(objeto);
        }
        tabla.setRowHeight(35);
        tabla.setRowMargin(10);
    }

    void centrarCeldas(JTable tabla) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < vista.tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }

}
