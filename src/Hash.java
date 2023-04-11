import java.util.Arrays;

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

    /**
     * Funcion del TAD Hash que permoite insertar un elemento en la tabla hash.
     * @param clave Clave del elemento a insertar.
     * @param v Valor del elemento a insertar.
     */
    public void insertar(int clave, Valor v){
        float alfaAFuturo =  ((float)( numElementos + 1 ) /  (float )contenedor.length);
        boolean yaExiste = false;
        //Si la tabla hash no está vacía, comprobamos que el valor no exista.
        if(numElementos >= 0){
            for (int i = 0; i < contenedor.length; i++) {
                if(contenedor[i] != null){
                    if(contenedor[i].getClave() == clave && contenedor[i].getEstado() == 1){
                        yaExiste = true;
                        System.out.println("El valor ya existe en la tabla hash.");
                    }
                }
            }
        }
        if(!yaExiste){
            if( alfaAFuturo >= alfaMaximo) { //camino redimensionar la hash table.
                redimensionar();
            }
            int colisiones = 0;
            int indice = funcionHash(clave, colisiones);
            while(hayColision(indice)){
                colisiones++;
                indice = funcionHash(clave, colisiones);
            }
            Celda<Valor> celda = new Celda(clave, v);
            celda.setEstado(1);
            contenedor[indice] = celda;
            numElementos++;
        }
    }

    /**
     * Funcion del TAD Hash que permite borrar en la tabla hash.
     * @return true si se ha borrado el elemento, false si no se ha borrado.
     */
    public boolean borrar(int clave){
        boolean devolucion = false;
        if(esVacia()){
            System.out.println("La tabla hash está vacía.");
            return devolucion;
        }

        int colisiones = 0;
        int indice = funcionHash(clave, colisiones);

        while(hayColision(indice) ){
            if(contenedor[indice].getClave() == clave ){
                contenedor[indice].setEstado(-1);
                numElementos--;
                devolucion = true;
            }
            colisiones++;
            indice = funcionHash(clave, colisiones);
        }
        return devolucion;
    }

    /**
     * Devuelve null si el dato asociado a la clave indicada no está en la tabla.
     * @param clave
     * @return
     */
    public Valor get(int clave){
        Valor devolucion = null;

        if(esVacia()){
            System.out.println("La tabla hash está vacía.");
            return devolucion;
        }

        int colisiones = 0;
        int indice = funcionHash(clave, colisiones);

        while(hayColision(indice)){
            if(contenedor[indice].getClave() == clave){
                devolucion = contenedor[indice].getValor();
            }
            colisiones++;
            indice = funcionHash(clave, colisiones);
        }

        return devolucion;
    }

    public boolean esVacia(){
        boolean devolucion = false;
        if(numElementos == 0){
            devolucion = true;
        }
        return devolucion;
    }

    public float getAlfaMax() {
        return alfaMaximo;
    }

    public void setAlfaMax(float alfaMaximo) {
        if(alfaMaximo < 0 || alfaMaximo > 1){
            System.out.println("El factor de carga máximo debe estar entre 0 y 1.");
        }else if(alfaMaximo < factorCarga()){
            System.out.println("El factor de carga no puede ser menor que el actual.");
        }else{
            this.alfaMaximo = alfaMaximo;
        }
    }

    public int getNumElementos() {
        return numElementos;
    }

    public float factorCarga(){
        float devolucion = 0;
        devolucion = (float) (numElementos / contenedor.length);
        return devolucion;
    }

    private boolean hayColision(int index){
        boolean devolucion = false;
        if(!esVacia()){
            try{
                if(contenedor[index].getEstado() == 1){
                    devolucion = true;
                }
            }catch (NullPointerException e){
                devolucion = false;
            }
        }
        return devolucion;
    }

    private int funcionHash(int clave, int colisiones){
        int devolucion = 0;
        devolucion = (hash1(clave) + hash2(clave, colisiones));

        if(devolucion > contenedor.length){
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

        Celda<Valor>[] contenedorProvisional = new Celda[contenedor.length];

        contenedorProvisional = Arrays.copyOf(contenedor, contenedor.length);

        contenedor = new Celda[nuevaCapacidad];

        for (int i = 0; i < contenedorProvisional.length; i++) {
            if(contenedorProvisional[i] != null){
                int colisiones = 0;
                int indice = funcionHash(contenedorProvisional[i].getClave(), colisiones);
                while(hayColision(indice)){
                    indice = funcionHash(contenedorProvisional[i].getClave(), colisiones);
                    colisiones++;
                }
                Celda<Valor> celda = new Celda(contenedorProvisional[i].getClave(), contenedorProvisional[i].getValor());
                celda.setEstado(1);
                contenedor[indice] = celda;
            }
        }

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
//        String devolucion = "Tabla Hash con " + numElementos + " elementos y con un alfaMaximo de: "  + alfaMaximo  + "."+ "\n" + "los elementos dentro de esta tabla hash son: " + "\n";
        String devolucion = "";
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
