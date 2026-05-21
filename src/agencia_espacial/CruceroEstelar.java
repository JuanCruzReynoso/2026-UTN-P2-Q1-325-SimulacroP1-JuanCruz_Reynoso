package agencia_espacial;

/**
 *
 * @author juan cruz reynoso
 */
public class CruceroEstelar extends Nave {
    private int cantidadPasajeros;
    
    public CruceroEstelar(String nombre, int capacidadTripulacion, int anioLanzamiento, int cantidadPasajeros){
        super(nombre, capacidadTripulacion, anioLanzamiento);
        this.cantidadPasajeros = cantidadPasajeros;
    }
    
    @Override
    public String toString(){
        return super.toString() + " | Tipo: Crucero Estelar | Pasajeros: " + cantidadPasajeros;
    }
}
