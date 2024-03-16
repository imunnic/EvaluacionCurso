package com.evaluacionCurso.api.models;

import java.time.LocalDate;
import java.util.List;
import com.imunnic.testController.Participant;
import com.imunnic.testController.Test;
import com.imunnic.testController.Tester;
import com.imunnic.testController.Trial;

public class Curso extends Test{
  private LocalDate fechaFin;
  
  public void setNombre(String nombre) {
    setName(nombre);
  }
  
  public String getNombre() {
    return getName();
  }
  
  public List<Trial> getAsignaturas(){
    return getTrials();
  }
  
  public void addAsignatura(Asignatura asignatura) {
    getTrials().add(asignatura);
  }
  
  public List<Participant> getAlumnos() {
    return getParticipants();
  }
  
  public void addProfesor(Profesor profesor) {
    getTesters().add(profesor);
  }
  
  public List<Tester> getProfesores() {
    return getTesters();
  }
  
  public void addAlumno(Alumno alumno) {
    getParticipants().add(alumno);
  }
  
  public void setDescripcion(String descripcion) {
    setDescription(descripcion);
  }
  
  public String getDescripcion() {
    return getDescription();
  }
  
  public void setFechaInicio(LocalDate fehcaInicio) {
    setDate(fehcaInicio);
  }
  
  public LocalDate getFechaInicio() {
    return getDate();
  }
  
  public LocalDate getFechaFin() {
    return fechaFin;
  }
  
  public void setFechaFin(LocalDate fechaFin) {
    this.fechaFin = fechaFin;
  }
  
  public Curso() {
    super();
  }
  
  public Curso(Integer id, String nombre, String descripcion, LocalDate fechaInicio,
      LocalDate fechaFin, List<Participant> alumnos, List<Tester> profesores,
      List<Trial> asignaturas) {
    super(id, nombre, descripcion, fechaInicio, alumnos, profesores, asignaturas);
    setFechaFin(fechaFin);
  }
  
  public void mostrarClasificacion() {
    getAlumnos().forEach(a -> {
      System.out.println(a + " Puntuación: " + getMark(a));
    });
  }
  
  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return getNombre() + ":\n" + getDescripcion() + "\nFecha de inicio: " + getFechaInicio() +
        "\nFecha de fin: " + getFechaFin();
  }
}
