/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import clases.Miembro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Richie
 */
public class MiembroDAO {
     
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    Connection con;
    Date fecha = new Date();
    
    public void insertar(Miembro mi){
        
        try{
            String sql = "INSERT INTO Socio(idEstado, fechaCreacion, Nombre, Paterno, Materno, Tel)"
                    + "VALUES (?,?,?,?,?,?)";
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, 1);
            ps.setObject(2, fecha);
            ps.setObject(3, mi.getNombre());
            ps.setObject(4, mi.getPaterno());
            ps.setObject(5, mi.getMaterno());
            ps.setObject(6, mi.getTel());
            ps.executeUpdate();
            
        } catch (Exception e){            
        }
    }
    
    
    public ArrayList<Miembro> consulta() {
        ArrayList<Miembro> ListaMiembros = new ArrayList<>();
        
        try{
            
            String sql = "SELECT * FROM Socio";
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Miembro mi = new Miembro();
                mi.setIdSocio(rs.getInt(1));
                mi.setIdEstado(rs.getInt(2));
                mi.setFechaCreacion(rs.getString(3));
                mi.setNombre(rs.getString(4));
                mi.setPaterno(rs.getString(5));
                mi.setMaterno(rs.getString(6));
                mi.setTel(rs.getString(7));
                ListaMiembros.add(mi);  
            }
          
        } catch (Exception e){            
        }
        return ListaMiembros;    
    }
    
  
    public void actualizar(Miembro mi) {
        String sql = "UPDATE Socio set Nombre=?, Paterno=?, Materno=?, Tel=? where idSocio=?";
        
        try{
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, mi.getNombre());
            ps.setObject(2, mi.getPaterno());
            ps.setObject(3, mi.getMaterno());
            ps.setObject(4, mi.getTel());
            ps.executeUpdate();
        }catch (Exception e){           
        }     
    }
    
  public void eliminar(int id) {
        String sql = "DELETE FROM Usuario WHERE idSocio = ?";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            ps.executeUpdate();
            System.out.println("Miembro eliminado");
        } catch (Exception e) {
            System.out.println("Error al eliminar Miembro " + e);
        }
    }
 
 
     
}
