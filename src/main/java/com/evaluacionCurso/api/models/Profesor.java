package com.evaluacionCurso.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.imunnic.testController.Tester;

@JsonIgnoreProperties({"alias", "name", "testerId", "id"})
@JsonPropertyOrder({"idProfesor", "nombre"})
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
    setIdProfesor(idProfesor);
  }
  
  @Override
  public String toString() {
    return "Profesor: " + getNombre() + " Id: " + getTesterId();
  }
}
