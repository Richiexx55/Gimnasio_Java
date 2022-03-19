/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Richie
 */
public class Socio {
    int id, id_estado, id_usuarioCreo;
    String fecha_creacion, nombre, paterno, materno, tel;

    public Socio() {
    }

    public Socio(int id, int id_estado, int id_usuarioCreo, String fecha_creacion, String nombre, String paterno, String materno, String tel ) {
        this.id = id;
        this.id_estado = id_estado;
        this.id_usuarioCreo = id_usuarioCreo;
        this.fecha_creacion = fecha_creacion;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public int getId_usuarioCreo() {
        return id_usuarioCreo;
    }

    public void setId_usuarioCreo(int id_usuarioCreo) {
        this.id_usuarioCreo = id_usuarioCreo;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
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




