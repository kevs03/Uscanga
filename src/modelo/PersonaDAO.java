package modelo;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public class PersonaDAO {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Persona p = new Persona();

    public List listar(){
        List<Persona> datos = new ArrayList<>();
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement("select * from persona");
            rs = ps.executeQuery();
            while (rs.next()) {
                Persona p = new Persona();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setNom2(rs.getString(3));
                p.setCorreo(rs.getString(4));
                p.setTelefono(rs.getString(5));
                p.setUbicacion(rs.getString(6));
                p.setFecha(rs.getString(7));
                datos.add(p);
            }
        } catch (Exception e) {
        }
        return datos;
    }
    //Metodo Agregar
    public int agregar(Persona p){
        int r = 0;
        String sql="insert into persona(NombreArrendador,NombreArrendatario,Correo,Telefono,Ubicacion,Fecha)values(?,?,?,?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1,p.getNom());
            ps.setString(2,p.getNom2());
            ps.setString(3,p.getCorreo());
            ps.setString(4,p.getTelefono());
            ps.setString(5,p.getUbicacion());
            ps.setString(6,p.getFecha());
            r = ps.executeUpdate();    
            if(r == 1){
                return 1;
            }
            else{
                return 0;
            }
        } catch (Exception e) {
        }  
        return r;
    }
    //Metodo Actualizar
    public int Actualizar(Persona p){
        int r = 0;
        String sql="update persona set NombreArrendador=?,NombreArrendatario=?,Correo=?,Telefono=?,Ubicacion=?,Fecha=? where Id=?";        
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1,p.getNom());
            ps.setString(2,p.getNom2());
            ps.setString(3,p.getCorreo());
            ps.setString(4,p.getTelefono());
            ps.setString(5,p.getUbicacion());
            ps.setString(6,p.getFecha());
            ps.setInt(7,p.getId());
            r = ps.executeUpdate();    
            if(r == 1){
                return 1;
            }
            else{
                return 0;
            }
        } catch (Exception e) {
        }  
        return r;
    }

    //Metodo Eliminar
    public int delete(int id){
        int r = 0;
        String sql = "delete from persona where Id="+id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (Exception e){
        }
        return r;
    }
}
