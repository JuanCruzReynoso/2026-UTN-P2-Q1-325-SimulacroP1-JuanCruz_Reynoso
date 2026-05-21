package agencia_espacial;

/**
 *
 * @author juan cruz reynoso
 */
public class NaveExploracion extends Nave implements Explorable {
    private TipoMision tipoMision;
    
    public NaveExploracion(String nombre, int capacidadTripulacion, int anioLanzamiento, TipoMision tipoMision){
        super(nombre, capacidadTripulacion, anioLanzamiento);
        this.tipoMision = tipoMision;
    }
    
    @Override
    public void explorar(){
        System.out.println("Nave " + nombre + " iniciando mision de " + tipoMision);
    }
    
    @Override
    public String toString(){
        return super.toString() + " | Tipo: Exploracion | Mision: " + tipoMision;
    }
}
