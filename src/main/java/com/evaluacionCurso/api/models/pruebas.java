package com.evaluacionCurso.api.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.time.LocalDate;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.imunnic.testController.Result;
import com.imunnic.testController.Tester;

public class pruebas {

  public static void main(String[] args) {

    // Creo un curso
    Curso dim46 = new Curso();
    dim46.setNombre("DIM LXVI");
    dim46.setDescripcion("XLVI Curso para la obtención del Diploma de informática militar");
    dim46.setFechaInicio(LocalDate.of(2023, 9, 4));
    dim46.setFechaFin(LocalDate.of(2024, 7, 12));
    System.out.println(dim46);
    // Agrego asignaturas al curso
    System.out.println("-----------------------------");
    dim46.addAsignatura(Asignatura.ARQUITECTURA_COMPUTADORES);
    dim46.addAsignatura(Asignatura.INGENIERIA_SOFTWARE);
    dim46.addAsignatura(Asignatura.INTRODUCCION_BBDD);
    dim46.addAsignatura(Asignatura.INTRODUCCION_PROGRAMACION);
    dim46.addAsignatura(Asignatura.REDES_COMUNICACIONES);
    dim46.getAsignaturas().forEach(System.out::println);
    System.out.println("-----------------------------");
    // Voy a deserializar y serializar(obtener la información de algún lado). Creo el mapper
    // con esto pretendo añadir los alumnos al curso y ver como serían los datos
    // impresos por pantalla

    ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT)
        .enable(Feature.ALLOW_UNQUOTED_FIELD_NAMES);
    mapper.addMixIn(Result.class, MixIns.Resultados.class);
//    mapper.addMixIn(Alumno.class, MixIns.Alumnos.class);
    mapper.addMixIn(Asignatura.class, MixIns.Asignaturas.class);


    // leo los alumnos del Json
    try (BufferedReader buffer =
        new BufferedReader(new FileReader(new File("./src/main/resources/alumnos.json")))) {
      buffer.lines().forEach(l -> {
        try {
          Alumno alumno = mapper.readValue(l, Alumno.class);
          dim46.addAlumno(alumno);
        } catch (JsonMappingException e) {
          e.printStackTrace();
        } catch (JsonProcessingException e) {
          e.printStackTrace();
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
    // compruebo la salida
    dim46.getAlumnos().forEach(System.out::println);
    System.out.println("-------------");
    // serializo los participantes
    dim46.getAlumnos().stream().map(p -> {
      String json = "N/D";
      try {
        json = mapper.writeValueAsString(p);
      } catch (Exception e) {
        e.printStackTrace();
      }
      return json;
    })// Compruebo la salida
        .forEach(System.out::println);
    System.out.println("-------------");
    // agrego los profesores al curso desde el Json
    try (BufferedReader buffer =
        new BufferedReader(new FileReader(new File("./src/main/resources/profesores.json")))) {
      buffer.lines().forEach(l -> {
        try {
          Profesor profesor = mapper.readValue(l, Profesor.class);
          dim46.getTesters().add(profesor);
        } catch (JsonMappingException e) {
          e.printStackTrace();
        } catch (JsonProcessingException e) {
          e.printStackTrace();
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
    // compruebo la salida
    dim46.getProfesores().forEach(System.out::println);
    System.out.println("-------------");
    // los profesores asigna notas de sus asignaturas al alumno
    Result result1 =
        dim46.getProfesores().get(0).certifyResult(Asignatura.ARQUITECTURA_COMPUTADORES, 7);
    dim46.getTesters().get(0).asignResult(dim46.getParticipants().get(0), result1);
    result1 = dim46.getProfesores().get(1).certifyResult(Asignatura.REDES_COMUNICACIONES, 5);
    dim46.getTesters().get(0).asignResult(dim46.getParticipants().get(0), result1);
    result1 = dim46.getProfesores().get(2).certifyResult(Asignatura.INGENIERIA_SOFTWARE, 8);
    dim46.getTesters().get(0).asignResult(dim46.getParticipants().get(0), result1);
    result1 = dim46.getProfesores().get(3).certifyResult(Asignatura.INTRODUCCION_BBDD, 6);
    dim46.getTesters().get(0).asignResult(dim46.getParticipants().get(0), result1);
    result1 = dim46.getProfesores().get(4).certifyResult(Asignatura.INTRODUCCION_PROGRAMACION, 5);
    dim46.getTesters().get(0).asignResult(dim46.getParticipants().get(0), result1);

    // comprobamos que se obtiene resultado para un participante
    System.out.println("-------------");
    System.out.println("El resultado para el primer alumno es:");
    System.out.println(dim46.getMark(dim46.getParticipants().get(0)));
    System.out.println("-------------");
    // cargamos el segundo alumno
    Result result2 =
        dim46.getProfesores().get(0).certifyResult(Asignatura.ARQUITECTURA_COMPUTADORES, 9);
    dim46.getTesters().get(0).asignResult(dim46.getParticipants().get(1), result2);
    result2 = dim46.getProfesores().get(1).certifyResult(Asignatura.REDES_COMUNICACIONES, 8);
    dim46.getTesters().get(0).asignResult(dim46.getParticipants().get(1), result2);
    result2 = dim46.getProfesores().get(2).certifyResult(Asignatura.INGENIERIA_SOFTWARE, 9);
    dim46.getTesters().get(0).asignResult(dim46.getParticipants().get(1), result2);
    result2 = dim46.getProfesores().get(3).certifyResult(Asignatura.INTRODUCCION_BBDD, 9);
    dim46.getTesters().get(0).asignResult(dim46.getParticipants().get(1), result2);
    result2 = dim46.getProfesores().get(4).certifyResult(Asignatura.INTRODUCCION_PROGRAMACION, 10);
    dim46.getTesters().get(0).asignResult(dim46.getParticipants().get(1), result2);
    // ordenamos los alumnos y mostramos por pantalla para ver el resultado
    // primero
    dim46.sort();
    dim46.mostrarClasificacion();
    System.out.println("--------------------");
    // Vamos a ver los datos al serializar un participante
    try {
      System.out.println(mapper.writeValueAsString(dim46.getAlumnos().get(0)));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    System.out.println("--------------------");
    Result result3=dim46.getProfesores().get(2).certifyResult(Asignatura.ARQUITECTURA_COMPUTADORES, 9);
    try {
      System.out.println(mapper.writeValueAsString(result3));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
//    System.out.println(dim46.getAlumnos().get(0).getResults().get(2).getTester().getId());

  }
}
