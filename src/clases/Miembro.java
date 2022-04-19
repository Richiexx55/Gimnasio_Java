/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
/**
 *
 * @author Richie
 */
public class Miembro {
    
    int idSocio, idEstado, idUsuarioCreo;
    String  fechaCreacion, nombre, paterno, materno, tel;
    
     //constructor
    public Miembro() {
    }

    public Miembro(int idSocio, int idEstado, String fechaCreacion, String nombre, String paterno, String materno, String tel, int idUsuarioCreo) {
        this.idSocio = idSocio;
        this.idEstado = idEstado;
        this.fechaCreacion = fechaCreacion;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.tel = tel;
        this.idUsuarioCreo = idUsuarioCreo;
      
          
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdUsuarioCreo() {
        return idUsuarioCreo;
    }

    public void setIdUsuarioCreo(int idUsuarioCreo) {
        this.idUsuarioCreo = idUsuarioCreo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
    
    
    
}
