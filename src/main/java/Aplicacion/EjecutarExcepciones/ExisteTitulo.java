package Aplicacion.EjecutarExcepciones;

import Aplicacion.Excepcion.TareaExistente;
import Aplicacion.Listas.UtilidadesParaListas;
import Aplicacion.Tareas.Tareas;

import java.util.List;

public class ExisteTitulo {

    public static void ejecutaExisteTitulo(String titulo, List<Tareas> tareas) throws TareaExistente {

        if (!UtilidadesParaListas.insertarEnLista(titulo,tareas))
            throw new TareaExistente();
    }
}
