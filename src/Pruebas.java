public class Pruebas {

    public static void main(String[] args) {
        Pruebas pruebas = new Pruebas();
        //pruebas.test1();
        System.out.println("------------------");
        //pruebas.test2();
        System.out.println("------------------");
        pruebas.test3();
    }

    public void test1(){
        //Test 1: Insertar 5 elementos y comprobar que se insertan correctamente.
        boolean resultado = false;
        Hash<String> hash = new Hash<>(11, 0.75f);
        hash.insertar(11,"Geronimo");
        hash.insertar(13,"Angel");
        hash.insertar(15,"Borja");
        hash.insertar(22,"David");
        hash.insertar(33,"Gustavo");

        if(hash.get(11).equals("Geronimo")){
            resultado = true;
        }else if(hash.get(13).equals("Angel")) {
            resultado = true;
        }else if(hash.get(15).equals("Borja")) {
            resultado = true;
        }else if(hash.get(22).equals("David")) {
            resultado = true;
        }else if(hash.get(33).equals("Gustavo")) {
            resultado = true;
        } else if (hash.get(1) == null) {
            resultado = true;
        }else if (hash.get(100) == null) {
            resultado = true;
        }else{
            resultado = false;
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

    public void test2(){
        //Test 2: Insertar 4 elementos con un 5 elemento que me haga redimensionar mi tabla.

        boolean resultado = false;
        Hash<String> hash = new Hash<>(11, 0.5f);
        hash.insertar(11,"Geronimo");
        hash.insertar(13,"Angel");
        hash.insertar(15,"Borja");
        hash.insertar(22,"David");
        hash.insertar(33,"Gustavo");
        hash.insertar(19, "Facundo");

//        if(hash.get(11).equals("Geronimo")){
//            resultado = true;
//        }else if(hash.get(13).equals("Angel")) {
//            resultado = true;
//        }else if(hash.get(15).equals("Borja")) {
//            resultado = true;
//        }else if(hash.get(22).equals("David")) {
//            resultado = true;
//        }else if(hash.get(33).equals("Gustavo")) {
//            resultado = true;
//        } else if (hash.get(1) == null) {
//            resultado = true;
//        }else if (hash.get(100) == null) {
//            resultado = true;
//        }else{
//            resultado = false;
//        }

        if(resultado){
            System.out.println("Test 2: OK✅");
        }else{
            System.out.println("Test 2: FAIL❌");
        }

        System.out.println(hash);

    }

    public void test3() {
        //Test 3: Insertar 5 elementos y eliminar uno.
        boolean resultado = false;
        Hash<String> hash = new Hash<>(11, 0.75f);
        hash.insertar(11, "Geronimo");
        hash.insertar(13, "Angel");
        hash.insertar(15, "Borja");
        hash.insertar(22, "David");
        hash.insertar(33, "Gustavo");
        System.out.println(hash);
        hash.borrar(11);

        if(resultado){
            System.out.println("Test 3: OK✅");
        }else{
            System.out.println("Test 3: FAIL❌");
        }
        System.out.println(hash);
    }
}
