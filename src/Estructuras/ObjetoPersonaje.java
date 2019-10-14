package Estructuras;

/**
 *
 * @author Denis
 */
public class ObjetoPersonaje {
    private Object NombrePersonaje;
    private Object RutaPersonaje;

    public ObjetoPersonaje() {
    }

    public ObjetoPersonaje(Object NombrePersonaje, Object RutaPersonaje) {
        this.NombrePersonaje = NombrePersonaje;
        this.RutaPersonaje = RutaPersonaje;
    }

    public Object getNombrePersonaje() {
        return NombrePersonaje;
    }

    public void setNombrePersonaje(Object NombrePersonaje) {
        this.NombrePersonaje = NombrePersonaje;
    }

    public Object getRutaPersonaje() {
        return RutaPersonaje;
    }

    public void setRutaPersonaje(Object RutaPersonaje) {
        this.RutaPersonaje = RutaPersonaje;
    }

    @Override
    public String toString() {
        return "ObjetoPersonaje{" + "NombrePersonaje=" + NombrePersonaje + ", RutaPersonaje=" + RutaPersonaje + '}';
    }

    
}
