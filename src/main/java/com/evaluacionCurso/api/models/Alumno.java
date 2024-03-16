package com.evaluacionCurso.api.models;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.imunnic.testController.Participant;
import com.imunnic.testController.Result;

@JsonIgnoreProperties({"alias", "name", "dorsal", "id"})
@JsonPropertyOrder({"idAlumno", "nombre", "results"})
public class Alumno extends Participant{
  
  private void setIdAlumno(int id) {
    setDorsal(id);
  }
  
  private void setNombre(String nombre) {
    setName(nombre);
  }
  
  public int getIdAlumno() {
    return getId();
  }
  
  public String getNombre() {
    return getName();
  }
  
  public Alumno() {
    super();
    setResults(new ArrayList<Result>());
  }

  public Alumno(String name, String alias) {
    super(name, alias);
    setResults(new ArrayList<Result>());
  }

  public Alumno(String name, int idAlumno, String alias) {
    super(name, idAlumno, alias);
  }
  
  public Alumno(String name, String alias,int idAlumno, List<Result> results) {
    super(name, idAlumno, alias);
    setResults(results);
  }
  
  @Override
  public String toString() {
    return "Alumno: " + getName();
  }
}
