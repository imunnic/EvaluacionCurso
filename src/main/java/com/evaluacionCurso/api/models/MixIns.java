package com.evaluacionCurso.api.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.imunnic.testController.Result;
import com.imunnic.testController.Tester;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class MixIns {

  public abstract class Resultados{
    @JsonProperty("profesorId")
    private int profesorId;
    abstract Tester getTester();
    @JsonProperty("asignatura") 
    abstract Asignatura getTrial();
    @JsonProperty("puntuacion")
    abstract int getResult();
    @JsonIgnore
    abstract int getGrossResult();
    public int getProfesorId() {
      return getTester().getId();
    }

  }
  
  public interface Asignaturas{
    @JsonValue String getName();
  }
  
  public interface Alumnos {
    @JsonProperty("notas")
    Result getResults();
  }

}
