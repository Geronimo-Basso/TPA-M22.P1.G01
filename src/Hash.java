/**
 * Clase que implementa una tabla hash con direccionamiento abierto.
 * @param <Valor> Valor es un tipo genérico, por lo que puede ser cualquier tipo de dato.
 */
public class Hash<Valor> {
    private Celda<Valor>[] contenedor;
    private int numElementos = 0;
    private float alfaMaximo = 0;

    /**
     * Constructor de la clase Hash.
     * Si no es especificamos el factor de carga máximo, se toma por defecto el 0.80f.
     * Si no especificamos la capacidad, se toma por defecto el 7.
     */
    public Hash(){
        this.contenedor = new Celda[7];
        this.alfaMaximo = 0.80f;
    }

    /**
     * Constructor de la clase Hash. Si no es especificamos el factor de carga máximo, se toma por defecto el 0.80f.
     * @param capacidad Tamaño de la tabla hash
     */
    public Hash(int capacidad){
        this.alfaMaximo = 0.80f;
    }

    /**
     * Constructor de la clase Hash
     * @param capacidad Tamaño de la tabla hash
     * @param alfaMax Factor de carga máximo
     */
    public Hash(int capacidad, float alfaMax){
        this.contenedor = new Celda[capacidad];
        this.alfaMaximo = alfaMax;
    }

    public void insertar(int clave, Valor v){
        float alpaAFuturo = (float) numElementos / contenedor.length;
        if( alpaAFuturo>= alfaMaximo){ //camino redimensionar la hash table.
            redimensionar();
            int colisiones = 0;
            int indice = funcionHash(clave, colisiones);
            while(hayColision(indice)){
                colisiones++;
                indice = funcionHash(clave, colisiones);
            }
            contenedor[indice] = new Celda(clave, v);
            numElementos++;
        }else{
            int colisiones = 0;
            int indice = funcionHash(clave, colisiones);
            while(hayColision(indice)){
                colisiones++;
                indice = funcionHash(clave, colisiones);
            }
            contenedor[indice] = new Celda(clave, v);
            numElementos++;
        }

    }

    public boolean borrar(int clave){
        return true;
    }


    /**
     * Devuelve null si el dato asociado a la clave indicada no está en la tabla.
     * @param clave
     * @return
     */
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

    public float factorCarga(){
        float devolucion = 0;
        return devolucion;
    }

    private boolean hayColision(int index){
        boolean devolucion = false;
        if(contenedor[index] != null){
            devolucion = true;
        }
        return devolucion;
    }

    private int funcionHash(int clave, int colisiones){
        int devolucion = 0;
        devolucion = (hash1(clave) + hash2(clave, colisiones));
        if(devolucion >= contenedor.length){
            devolucion = devolucion % contenedor.length;
        }
        return devolucion;
    }

    private int hash1(int clave){
        int devolucion = 0;
        devolucion = clave % contenedor.length;
        return devolucion;
    }

    private int hash2(int clave, int colisiones){
        int devolucion = 0;
        devolucion = (colisiones * (7 - (clave % 7)));
        return devolucion;
    }

    private void redimensionar(){
        int nuevaCapacidad = siguientePrimo(contenedor.length * 2);
        Celda<Valor>[] nuevoContenedor = new Celda[nuevaCapacidad];
        for (int i = 0; i < contenedor.length; i++) {
            if(contenedor[i] != null){
                int colisiones = 0;
                int indice = funcionHash(contenedor[i].getClave(), colisiones);
                while(hayColision(indice)){
                    colisiones++;
                    indice = funcionHash(contenedor[i].getClave(), colisiones);
                }
                nuevoContenedor[indice] = new Celda(contenedor[i].getClave(), contenedor[i].getValor());

            }
        }
        //Asigno el nuevo contenedor a la tabla hash.
        contenedor = nuevoContenedor;
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

    /**
     * Metodo que devuelve el numero de elementos de la tabla hash.
     *
     * Si la celda no es null, es decir, si hay un elemento en esa posicion, se imprime la clave.
     * Es necesario chequearlo dado que si fuera null estoy haciendo un getClave() a un objeto null, lo cual da error.
     * @return
     */
    public String toString(){
        String devolucion = "Tabla Hash con " + numElementos + " elementos y con un alfaMaximo de: "  + alfaMaximo  + "."+ "\n" + "los elementos dentro de esta tabla hash son: " + "\n";
        for (int i = 0; i < contenedor.length; i++) {
            if(contenedor[i] != null){
                devolucion += "Indice: " + i  + "    |" + " Estado: " +  contenedor[i].getEstado() + "           " + "Clave: " + contenedor[i].getClave() + "       " + "Valor: " +  contenedor[i].getValor() + "\n";
            }else{
                devolucion += "Indice: " + i  + "    |" + " Estado: " + "null       " + " " + "Clave: " +  "null     " + "Valor: " +  "null" + "\n";
            }
        }
        return devolucion;
    }
}
