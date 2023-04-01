public class Hash<Valor> {
    private Celda<Valor>[] contenedor;
    private int numElementos = 0;
    private float alfaMaximo = 0;
    public Hash(){
        this.contenedor = new Celda[7];
        this.alfaMaximo = 0.80f;
    }

    public Hash(int capacidad){
        this.alfaMaximo = 0.80f;
    }

    public Hash(int capacidad, float alfaMax){
        this.contenedor = new Celda[capacidad];
        this.alfaMaximo = alfaMax;
    }

    public void insertar(int clave, Valor v){
    }

    public boolean borrar(int clave){
        return true;
    }


    public Valor get(int clave){
        return null;
    }

    public boolean esVacia(){
        return true;
    }

    public float getAlfaMax() {
        return alfaMaximo;
    }

    public void setAlfaMax(float alfaMaximo) {
        this.alfaMaximo = alfaMaximo;
    }

    public int getNumElementos() {
        return numElementos;
    }

//    public void setNumElementos(int numElementos) {
//        this.numElementos = numElementos;
//    }
//
    public float factorCarga(){
        float devolucion = 0;
        return devolucion;
    }

    private boolean hayColision(int index){
        return true;
    }

    private int funcionHash(int clave, int colisiones){
        int devolucion = 0;
        return devolucion;
    }

    private int hash1(int clave){
        int devolucion = 0;
        return devolucion;
    }

    private int hash2(int clave, int colisiones){
        int devolucion = 0;
        return devolucion;
    }

    private void redimensionar(){
    }

    /**
     * Metodo que comprueba si un numero es primo o no
     * @param numero Numero a comprobar
     * @return true si es primo, false si no lo es
     */
    private boolean esPrimo(int numero){
        if (numero <= 1) {
            return false;
        }
        int i = 2;
        while (i <= Math.sqrt(numero)) {
            if (numero % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    /**
     * Funcion que devuelve el siguiente numero primo a partir de un numero dado.
     * @param numero
     * @return
     */
    private int siguientePrimo(int numero){ //todo Explorar el caso en el que numero sea 1. Dado que si numero es 1, el siguiente primo es 2. Pero quiero una tabla con 2 o 3?
        while(!esPrimo(numero)){
            numero++;
        }
        return numero;
    }

    public String toString(){
        String devolucion = "";
        return devolucion;
    }
}
