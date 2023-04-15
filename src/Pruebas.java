public class Pruebas {

    /**
     * Metodo main de la clase Pruebas.
     * @param args
     */
    public static void main(String[] args) {
        Pruebas pruebas = new Pruebas();
        pruebas.test1();
        pruebas.test2();
        pruebas.test3();
        pruebas.test4();
        pruebas.test5();
        pruebas.test6();
        pruebas.test7();
    }

    /**
     * Test 1: Insertar 5 elementos y comprobar que se insertan correctamente.
     * Las claves tienen varias colisiones entre si.
     *
     */
    public void test1(){
        boolean resultado = false;
        Hash<String> hash = new Hash<>(11, 0.75f);
        hash.insertar(11,"Geronimo");
        hash.insertar(13,"Angel");
        hash.insertar(15,"Borja");
        hash.insertar(22,"David");
        hash.insertar(33,"Gustavo");

        if (hash.get(11).equals("Geronimo") && hash.get(13).equals("Angel") && hash.get(15).equals("Borja") &&
                hash.get(22).equals("David") && hash.get(33).equals("Gustavo") && hash.get(1) == null &&
                hash.get(100) == null && hash.getAlfaMax() == 0.75f && hash.getNumElementos() == 5 ) {
            resultado = true;
        }

        if(resultado){
            System.out.println("Test 1: OK✅");
        }else{
            System.out.println("Test 1: FAIL❌");
        }
    }

    /**
     * Test de inserción: insertamos 5 elementos y comprobamos que se insertan correctamente, pero además agregamos un elemento nuevo el cual genera un redimensionamiento en la tabla hash.
     * El objetivo de este test es que funcione correctamente el redimensionamiento de la tabla hash y los elementos se inserten correctamente.
     *
     */
    public void test2(){
        boolean resultado = false;
        Hash<String> hash = new Hash<>(11, 0.5f);
        hash.insertar(11,"Geronimo");
        hash.insertar(13,"Angel");
        hash.insertar(15,"Borja");
        hash.insertar(22,"David");
        hash.insertar(33,"Gustavo");

        //Elemento que fuerza el redimensionamiento.
        hash.insertar(19, "Facundo");

        if (hash.get(11).equals("Geronimo") && hash.get(13).equals("Angel") && hash.get(15).equals("Borja") &&
                hash.get(22).equals("David") && hash.get(33).equals("Gustavo") && hash.get(19).equals("Facundo") && hash.get(1) == null &&
                hash.get(100) == null && hash.getAlfaMax() == 0.5f && hash.getNumElementos() == 6){
            resultado = true;
        }

        if(resultado){
            System.out.println("Test 2: OK✅");
        }else{
            System.out.println("Test 2: FAIL❌");
        }
    }

    /**
     * Test de borrado: buscamos un elemento y lo borramos, comprobamos que se borra correctamente, luego borro toodos los elementos.
     */
    public void test3(){
        boolean resultado = false;
        Hash<String> hash = new Hash<>(11, 0.75f);
        hash.insertar(11,"Geronimo");
        hash.insertar(13,"Angel");
        hash.insertar(15,"Borja");
        hash.insertar(22,"David");
        hash.insertar(33,"Gustavo");


        hash.borrar(11);
        hash.borrar(13);
        hash.borrar(15);

        if(hash.get(11) == null && hash.get(13) == null && hash.get(15) == null){
            resultado = true;
        }

        if(resultado){
            System.out.println("Test 3: OK✅");
        }else{
            System.out.println("Test 3: FAIL❌");
        }
    }

    /**
     * Test de borrado e inserción: borro un elemento y luego inserto otro en su lugar, comprobamos que se inserta correctamente.
     *
     */
    public void test4(){
        boolean resultado = false;
        Hash<String> hash = new Hash<>(11, 0.75f);
        hash.insertar(11,"Geronimo");
        hash.insertar(13,"Angel");
        hash.insertar(15,"Borja");
        hash.insertar(22,"David");
        hash.insertar(33,"Gustavo");

        hash.borrar(11);
        if(hash.get(11) == null && hash.getNumElementos() == 4){
            resultado = true;
        }

        hash.insertar(11, "Susana");

        if(hash.get(11).equals("Susana") && hash.getNumElementos() == 5){
            resultado = true;
        }

        if(resultado){
            System.out.println("Test 4: OK✅");
        }else{
            System.out.println("Test 4: FAIL❌");
        }
    }

    /**
     * Test de borrado e inserción: borro un elemento el cual sufre de colision
     * y luego inserto otro en su lugar, comprobamos que se inserta correctamente.
     *
     */
    public void test5(){
        boolean resultado = false;
        Hash<String> hash = new Hash<>(11, 0.75f);
        hash.insertar(11,"Geronimo");
        hash.insertar(13,"Angel");
        hash.insertar(15,"Borja");
        hash.insertar(22,"David");
        hash.insertar(33,"Gustavo");

        hash.borrar(22);

        hash.insertar(22, "Alejandro");

        if(hash.get(22).equals("Alejandro") && hash.getNumElementos() == 5){
            resultado = true;
        }

        if(resultado){
            System.out.println("Test 5: OK✅");
        }else{
            System.out.println("Test 5: FAIL❌");
        }
    }

    /**
     * Test de inserrcion, inserto 5 elementos y comprobar que se insertan correctamente.
     * Intentaremos insertar otro elemento el cual, tiene la misma clave que otro ya previamente insertado.
     */
    public void test6(){
        boolean resultado = false;
        Hash<String> hash = new Hash<>(11, 0.75f);
        hash.insertar(11,"Geronimo");
        hash.insertar(13,"Angel");
        hash.insertar(15,"Borja");
        hash.insertar(22,"David");
        hash.insertar(33,"Gustavo");
        hash.insertar(22, "Alejandro"); //esto no se deberia poder hacer, ya exite un elemento con la clave 22.

        if(hash.get(22).equals("David") && hash.getNumElementos() == 5){
            resultado = true;
        }

        if(resultado){
            System.out.println("Test 6: OK✅");
        }else{
            System.out.println("Test 6: FAIL❌");
        }
    }

    /**
     * Test de borrado: borro un elemento para despues pedirle que le vuelva a borrar.
     */
    public void test7(){
        boolean resultado = false;
        Hash<String> hash = new Hash<>(11, 0.75f);
        hash.insertar(11,"Geronimo");
        hash.insertar(13,"Angel");
        hash.insertar(15,"Borja");
        hash.insertar(22,"David");
        hash.insertar(33,"Gustavo");

        hash.borrar(23);
        hash.borrar(22);

        if(hash.get(22) == null){
            resultado = true;
        }

        if(resultado){
            System.out.println("Test 7: OK✅");
        }else{
            System.out.println("Test 7: FAIL❌");
        }
    }
}