package agencia_espacial;

import java.util.Objects;

/**
 *
 * @author juan cruz reynoso
 */
public abstract class Nave implements Comparable<Nave>{
    protected String nombre;
    protected int capacidadTripulacion;
    protected int anioLanzamiento;
    
    public Nave(String nombre, int capacidadTripulacion, int anioLanzamiento){
        this.nombre = nombre;
        this.capacidadTripulacion = capacidadTripulacion;
        this.anioLanzamiento = anioLanzamiento;
    }
    
    public String getNombre(){ return nombre; }
    public int getCapacidadTripulacion(){ return capacidadTripulacion; }
    public int getAnioLanzamiento() { return anioLanzamiento; }
    
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (this == null || getClass() != obj.getClass()) return false;
        Nave nave = (Nave) obj;
        return anioLanzamiento == nave.anioLanzamiento && Objects.equals(nombre, nave.nombre);
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(nombre, anioLanzamiento);
    }
    
    @Override
    public int compareTo(Nave otraNave){
        // Orden alfabetico por nombre
        return this.nombre.compareToIgnoreCase(otraNave.getNombre());
    }
    
    @Override
    public String toString(){
        return String.format("Nave: %s | Tripulacion: %d | Año: %d", nombre, capacidadTripulacion, anioLanzamiento);
    }
}
