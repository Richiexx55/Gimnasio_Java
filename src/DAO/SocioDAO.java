
package DAO;

import clases.Socio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Richie
 */
public class SocioDAO implements CRUD{
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    Conexion cn = new Conexion();
    
    public Socio listarSocioID(){
        Socio so = new Socio();
        String sql = "SELECT * FROM socio";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            while (rs.next()) {
                so.setId(rs.getInt(1));
                so.setNombre(rs.getString(2));
                so.setPaterno(rs.getString(3));
                so.setMaterno(rs.getString(4));
                so.setTel(rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println("Error al listar ID de las Socios: " + e);
        }
        return so;
    }
    
    public Socio validarSocio(String id, String nombre){
        Socio so = new Socio();
        String sql = "SELECT * FROM socio WHERE dni = ? AND user = ?";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, nombre);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                so.setId(rs.getInt(1));
                so.setNombre(rs.getString(2));
                so.setPaterno(rs.getString(3));
                so.setMaterno(rs.getString(4));
                so.setTel(rs.getString(4));
               
            }
        } catch (Exception e) {
            System.out.println("Error to validate Socio");
        }
        return so;
    }
    
    @Override
    public List listar() {
        List<Socio> lista = new ArrayList<>();
        String sql = "SELECT * FROM Socio";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Socio so = new Socio();              
                so.setId(rs.getInt(1));
                so.setNombre(rs.getString(2));
                so.setPaterno(rs.getString(3));
                so.setMaterno(rs.getString(4));
                so.setTel(rs.getString(4));
                
                lista.add(so);
                System.out.println("Socios  mostrados");
            }
            
        } catch (Exception e) {
            System.out.println("Error al mostrar socios " + e);
        }
        
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "INSERT INTO Socio (Nombre, Paterno, Materno, Tel) values (?, ?, ?, ?)";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            r = ps.executeUpdate();
            System.out.println("Socio insertado");
        } catch (Exception e) {
            System.out.println("Error al insertar socio" + e);
        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "UPDATE Socio SET Nombre = ?, Paterno = ?, Materno = ?, Tel = ? WHERE id = ?";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            r = ps.executeUpdate();
            System.out.println("Socio Modificado");
        } catch (Exception e) {
            System.out.println("Error al modificar socio" + e);
        }
        
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM Socio WHERE id = ?";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            ps.executeUpdate();
            System.out.println("Socio eliminado");
            
        } catch (Exception e) {
            System.out.println("Error al eliminar socio" + e);
        }
    }

    
    
}