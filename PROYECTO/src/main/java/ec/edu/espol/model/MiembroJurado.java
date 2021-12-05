/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import ec.edu.espol.model.Persona;

/**
 *
 * @author Eduardo Vasquez
 */
public class MiembroJurado extends Persona {
    private String perfil;
//    private ArrayList<Evaluacion> evaluaciones;
    

    public MiembroJurado(int id, String nombres, String apellidos, String telefono, String email, String perfil) {
        super(id,nombres,apellidos,telefono,email);
        this.perfil = perfil;
//        this.evaluaciones=evaluaciones;
    }

    public int getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getPerfil() {
        return perfil;
    }

//    public ArrayList<Evaluacion> getEvaluaciones() {
//        return evaluaciones;
//    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

//    public void setEvaluaciones(ArrayList<Evaluacion> evaluaciones) {
//        this.evaluaciones = evaluaciones;
//    }

    @Override
    public String toString() {
        return id + "," + nombres + "," + apellidos + "," + telefono + "," + email + "," + perfil;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        MiembroJurado r=(MiembroJurado) obj;
        return this.id == r.id;
    }
    
    public void safeFile(String nomFile){
        try(PrintWriter pw=new PrintWriter(new FileOutputStream(new File(nomFile)))){
            pw.println(this.toString());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<MiembroJurado> readFile(String nomFile){
        ArrayList<MiembroJurado> lista=new ArrayList<>();
        try(Scanner sc=new Scanner(new File(nomFile))){
            while(sc.hasNextLine()){
                String linea=sc.nextLine();
                String[] tokens=linea.split(",");
                MiembroJurado mV=new MiembroJurado(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3],tokens[4],tokens[5]);
                lista.add(mV);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return lista;
    }
        
    public static MiembroJurado nextMiembroJ(Scanner sc){
        System.out.println("id");
        int id=sc.nextInt();
        System.out.println("Nombres");
        String nombres=sc.next();
        System.out.println("Apellidos");
        String apellidos=sc.next();
        System.out.println("Telefono");
        String telefono=sc.next();
        System.out.println("email");
        String email=sc.next();
        System.out.println("Perfil");
        String perfil=sc.next();
        MiembroJurado r=new MiembroJurado(id,nombres,apellidos,telefono,email,perfil);
        return r;
    }
}
