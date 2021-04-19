package Aplicacion.Excepcion;

public class PersonaExistente extends Exception{

    public PersonaExistente(){
        super("La persona existe ya");
    }
}
