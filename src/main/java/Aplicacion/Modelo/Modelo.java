package Aplicacion.Modelo;

import Aplicacion.EjecutarMétodos.ListadoPersonasNoResponsablesTareas;
import Aplicacion.Excepcion.PersonaNoAñadida;
import Aplicacion.Listas.UtilidadesParaListas;
import Aplicacion.Persona.Personas;
import Aplicacion.Proyecto.Proyecto;
import Aplicacion.Vista.Vista;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Modelo {
    Proyecto proyecto;
    Vista vista;

    public void setVista(Vista vista){
        this.vista = vista;
    }
    public void setProyecto(Proyecto proyecto){
        this.proyecto = proyecto;
    }


    public Proyecto getProyecto() {
        return proyecto;
    }
    public List<Personas> getListarPersonas(){
        return proyecto.listarPersonas();
    }

    public void insertarPersona(Personas persona) throws PersonaNoAñadida {
        proyecto.altaPersona(persona);
        vista.actualizar();

    }

    public StringBuilder textoPersonas(List<Personas> datosSinTratar){

        StringBuilder datosTratados = new StringBuilder();
        List<String> datosPersonas;
        Iterator<Personas> iterator = datosSinTratar.iterator();

        if(datosSinTratar.isEmpty())
            datosTratados.append("No hay personas registradas\n");
        else {
            datosTratados.append("Dni\tNombre\tCorreo electrónico\n");
            while (iterator.hasNext()){
                Personas persona = iterator.next();
                datosPersonas = persona.getInfoPersonas();
                datosTratados.append(datosPersonas.get(0)).append("\t").append(datosPersonas.get(1)).append("\t").append(datosPersonas.get(2)).append("\n");
            }
        }
        return datosTratados;
    }

    public void guardarFichero(File fichero) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
        oos.writeObject(proyecto);
        oos.close();
    }

    public void abrirFichero(File fichero) throws IOException, ClassNotFoundException {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
            proyecto = (Proyecto) ois.readObject();
            ois.close();
    }

    public List<Personas> listarPersonasNoResponsables() {
        List<Personas> personasNoResponsables = new LinkedList<>();
        personasNoResponsables = UtilidadesParaListas.elementosConListaVacia(proyecto.listarPersonas());
        return personasNoResponsables;
    }
}
