public class Pruebas {

    public static void main(String[] args) {
        Pruebas pruebas = new Pruebas();
        //        System.out.println("------------------");

//        pruebas.test1();
//        System.out.println("------------------");
        pruebas.test2();
//        pruebas.test3();
//        pruebas.test4();

    }

    /**
     * Test 1: Insertar 5 elementos y comprobar que se insertan correctamente.
     * Los elementos tienen varios colisiónes, buscamos observar que se insertan correctamente.
     */
    public void test1(){
        //Test 1: Insertar 5 elementos y comprobar que se insertan correctamente.
        boolean resultado = false;
        Hash<String> hash = new Hash<>(11, 0.75f);
        hash.insertar(11,"Geronimo");
        hash.insertar(13,"Angel");
        hash.insertar(15,"Borja");
        hash.insertar(22,"David");
        hash.insertar(33,"Gustavo");

        if (hash.get(11).equals("Geronimo") && hash.get(13).equals("Angel") && hash.get(15).equals("Borja") &&
                hash.get(22).equals("David") && hash.get(33).equals("Gustavo") && hash.get(1) == null &&
                hash.get(100) == null && hash.factorCarga() == 0.45454547f && hash.getAlfaMax() == 0.75f &&
                hash.getNumElementos() == 5) {
            resultado = true;
        }

/*        System.out.println(hash);
        System.out.println(hash.get(11));
        System.out.println(hash.get(13));
        System.out.println(hash.get(15));
        System.out.println(hash.get(22));
        System.out.println(hash.get(33));*/

        if(resultado){
            System.out.println("Test 1: OK✅");
        }else{
            System.out.println("Test 1: FAIL❌");
        }
    }

    /**
     * Test de inserción: insertamos 5 elementos y comprobamos que se insertan correctamente.
     * El objetivo de este test es que funcione correctamente el redimensionamiento de la tabla hash.
     */
    public void test2(){
        boolean resultado = false;
        Hash<String> hash = new Hash<>(11, 0.5f);
        hash.insertar(11,"Geronimo");
        hash.insertar(13,"Angel");
        hash.insertar(15,"Borja");
        hash.insertar(22,"David");
        hash.insertar(33,"Gustavo");


        if (hash.get(11).equals("Geronimo") && hash.get(13).equals("Angel") && hash.get(15).equals("Borja") &&
                hash.get(22).equals("David") && hash.get(33).equals("Gustavo") && hash.get(1) == null &&
                hash.get(100) == null && hash.factorCarga() == 0.45454547f && hash.getAlfaMax() == 0.5f &&
                hash.getNumElementos() == 5) {
            resultado = true;
        }

        System.out.println(hash);

        //Elemento que hace que ocurra el redimensionamiento.
        hash.insertar(19, "Facundo"); //Elemento que causa el redimensionamiento.

        if (hash.get(11).equals("Geronimo") && hash.get(13).equals("Angel") && hash.get(15).equals("Borja") &&
                hash.get(22).equals("David") && hash.get(33).equals("Gustavo") && hash.get(19).equals("Facundo") && hash.get(1) == null &&
                hash.get(100) == null && hash.factorCarga() == 0.26086956f && hash.getAlfaMax() == 0.5f &&
                hash.getNumElementos() == 6) {
            resultado = true;
        }

        System.out.println(hash);

        if(resultado){
            System.out.println("Test 2: OK✅");
        }else{
            System.out.println("Test 2: FAIL❌");
        }

    }

    /**
     * Test de borrado: buscamos un elemento y lo borramos, comprobamos que se borra correctamente.
     */
    public void test3(){
        boolean resultado = false;
        Hash<String> hash = new Hash<>(11, 0.75f);
        hash.insertar(11,"Geronimo");
        hash.insertar(13,"Angel");
        hash.insertar(15,"Borja");
        hash.insertar(22,"David");
        hash.insertar(33,"Gustavo");
        System.out.println("------------------");
        System.out.println(hash);
        System.out.println("------------------");
        hash.borrar(11);
        hash.borrar(13);
        hash.borrar(15);
        hash.borrar(22);
        hash.borrar(33);

        System.out.println(hash);

        if(hash.get(11) == null){
            resultado = true;
        }else if(hash.getNumElementos() == 4) {
            resultado = true;
        }else{
            resultado = false;
        }

        if(resultado){
            System.out.println("Test 3: OK✅");
        }else{
            System.out.println("Test 3: FAIL❌");
        }

    }

    /**
     * Test de borrado y inserción: borro un elemento y luego inserto otro en su lugar, comprobamos que se inserta correctamente.
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
        System.out.println(hash);
        if(hash.get(11) == null){
            resultado = true;
        }

        if(hash.getNumElementos() == 4) {
            resultado = true;
        }

        hash.insertar(11, "Susana");

        if(hash.get(11) != null){
            resultado = true;
        }

        if(hash.getNumElementos() == 5) {
            resultado = true;
        }
        System.out.println(hash);


        if(resultado){
            System.out.println("Test 4: OK✅");
        }else{
            System.out.println("Test 4: FAIL❌");
        }

    }


}
