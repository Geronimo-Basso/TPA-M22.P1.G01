import java.util.Objects;

/**
 * Clase Celda
 * @param <Valor>  Valor es un tipo genérico, por lo que puede ser cualquier tipo de dato.
 */
public class Celda<Valor> {

    /**
     * Clave de la celda
     */
    private int clave = 0;

    /**
     * Valor es un tipo genérico, por lo que puede ser cualquier tipo de dato.
     * @param <Valor>
     */
    private Valor valor;

    /**
     * El estado puede tomar tres valores:
     *-1: La celda estaba ocupada y ha sido borrada.
     * 0: La celda está vacía
     * 1: La celda está ocupada
     */
    private int estado = 0;

    /**
     * Constructor vacio de la clase Celda
     */
    public Celda(){
    }

    /**
     * Constructor de la clase Celda
     * @param clave Clave de la celda
     * @param valor Valor de la celda
     */
    public Celda(int clave, Valor valor){
        this.clave = clave;
        this.valor = valor;
        this.estado = 0;
    }

    /**
     * Metodo setEstado de la clase Celda, se usa para cambiar el estado de la celda.
     * @param estado Estado de la celda.
     * @return true si se ha cambiado el estado, false si no se ha cambiado.
     */
    public boolean setEstado(int estado) {
        boolean devolucion = false;
        if(estado == -1 || estado == 0 || estado == 1){
            this.estado = estado;
            devolucion = true;
        }
        return devolucion;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public void setValor(Valor valor) {
        this.valor = valor;
    }

    public int getEstado() {
        return estado;
    }

    public int getClave() {
        return clave;
    }

    public Valor getValor() {
        return valor;
    }

    /**
     * Metodo equals de la clase Celda, se usa para comparar dos celdas y saber si son iguales.
     * @param o Objeto a comparar
     * @return true si son iguales, false si no lo son.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Celda<?> celda = (Celda<?>) o;

        if (clave != celda.clave) return false;
        if (estado != celda.estado) return false;
        return Objects.equals(valor, celda.valor);
    }

}