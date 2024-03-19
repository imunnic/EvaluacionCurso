package com.evaluacionCurso.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.imunnic.testController.Tester;
@JsonIgnoreProperties({"alias", "name", "testerid"})
public class Profesor extends Tester {
  
  private void setIdProfesor(int id) {
   setTesterId(id);
  }
  
  public int getIdProfesor() {
    return getId();
  }
  
  private void setNombre(String nombre) {
    setName(nombre);
  }

  public String getNombre() {
    return getName();
  }

  public Profesor() {
    super();
  }
  
  public Profesor(String nombre, String alias) {
    super(nombre, alias);
  }

  public Profesor(String nombre, String alias,int idProfesor) {
    super(nombre, alias);
    setTesterId(idProfesor);
  }
  
  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return "Profesor: " + getNombre() + " Id: " + getTesterId();
  }
}
