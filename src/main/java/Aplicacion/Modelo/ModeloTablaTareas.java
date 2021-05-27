package Aplicacion.Modelo;

import Aplicacion.Persona.Personas;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;
import java.util.List;

public class ModeloTablaTareas extends AbstractTableModel {

    final List<String> cabeceras = Arrays.asList("Dni","Nombre","Correo electonico");
    List<Personas> datos;

    public ModeloTablaTareas(final List<Personas> datos){
        this.datos = datos;
    }

    public ModeloTablaTareas setDatos(final List<Personas> datos){
        this.datos = datos;
        return this;
    }





    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return cabeceras.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) return datos.get(rowIndex).getClave();
        if (columnIndex == 1) return datos.get(rowIndex).getNombre();
        if (columnIndex == 2) return datos.get(rowIndex).getCorreo();
        else return "";
    }

    public String getColumnName(int column){
        return cabeceras.get(column);
    }
}
