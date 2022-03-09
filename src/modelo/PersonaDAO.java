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
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List listar(){
        List<Persona>datos=new ArrayList<>();
        String sql = "select * from persona";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Persona p = new Persona();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setCorreo(rs.getString(3));
                p.setTel(rs.getString(4));
                datos.add(p);
            }
        } catch (Exception e){
        }
        return datos;
    }
    //Metodo Agregar
    public int agregar(Persona p){
        String sql = "insert into persona (Nombre, Correo, Telefono) values (?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getCorreo());
            ps.setString(3, p.getTel());
            ps.executeUpdate();
        } catch (Exception e){

        }
        return 1;
    }
    //Metodo Actualizar
    public int Actualizar(Persona p){
        int r = 0;
        String sql = "update persona set Nombre=?, Correo=?, Telefono=? where Id=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getCorreo());
            ps.setString(3, p.getTel());
            ps.setInt(4, p.getId());
            r = ps.executeUpdate();
            if(r == 1){
                return 1;
            }else{
                return 0;
            }
        } catch (Exception e){

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
