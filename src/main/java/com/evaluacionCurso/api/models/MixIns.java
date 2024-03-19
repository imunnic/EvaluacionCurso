package com.evaluacionCurso.api.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.imunnic.testController.Tester;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class MixIns {

  public interface Resultados{
    @JsonIgnore
    Tester getTester();
    @JsonProperty("asignatura") 
    Asignatura getTrial();
    @JsonProperty("puntuacion")
    int getResult();
    @JsonIgnore
    int getGrossResult();
    @JsonProperty("profesorId")
    public default int getProfesorId() {
      return getTester().getId();
    }

  }
  
  public interface Asignaturas{
    @JsonValue String getName();
  }

}
