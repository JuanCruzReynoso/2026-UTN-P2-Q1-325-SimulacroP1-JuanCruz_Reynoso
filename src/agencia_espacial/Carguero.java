
package agencia_espacial;

/**
 *
 * @author juan cruz reynoso
 */
public class Carguero extends Nave implements Explorable{
    private int capacidadCarga;
    
    public Carguero(String nombre, int capacidadTripulacion, int anioLanzamiento, int capacidadCarga){
        super(nombre, capacidadTripulacion, anioLanzamiento);
        this.capacidadCarga = capacidadCarga;
    }
    
    @Override
    public void explorar(){
        System.out.println("Carguero " + nombre + " iniciando ruta de abastecimiento con " + capacidadCarga + " toneladas.");
    }
    
    @Override
    public String toString(){
        return super.toString() + " | Tipo: Carguero | Capacidad Carga: " + capacidadCarga;
    }
}
