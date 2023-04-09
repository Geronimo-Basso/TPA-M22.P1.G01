public class Pruebas {

    public static void main(String[] args) {
        Pruebas pruebas = new Pruebas();
        pruebas.test1();
//        pruebas.test2();
    }

    public void test1(){
        //Test 1: Insertar 4 elementos y comprobar que se insertan correctamente.
        boolean resultado = false;
        Hash<String> hash = new Hash<>(11, 0.75f);
        hash.insertar(11,"Geronimo");
        hash.insertar(13,"Angel");
        hash.insertar(15,"Borja");
        hash.insertar(22,"David");
        hash.insertar(33,"Gustavo");
        System.out.println("--------------------");


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


        System.out.println(hash);

        System.out.println(hash.get(11));
        System.out.println(hash.get(13));
        System.out.println(hash.get(15));
        System.out.println(hash.get(22));
        System.out.println(hash.get(33));

        if(resultado){
            System.out.println("Test 1: OK✅");
        }else{
            System.out.println("Test 1: FAIL❌");
        }
    }

    public void test2(){
        //Test 2: Insertar 4 elementos con un 5 elemento que me haga redimensionar mi tabla.

        boolean resultado = false;
        Hash<String> hash = new Hash<>(11, 0.37f);
        hash.insertar(11,"Geronimo");
        hash.insertar(12,"Angel");
        hash.insertar(1,"Borja");
        hash.insertar(7,"Esteban");
        hash.insertar(9,"Diego");
        hash.insertar(8,"Juan");


//        if(hash.get(11).equals("Geronimo")){
//            resultado = true;
//        }else if(hash.get(12).equals("Angel")) {
//            resultado = true;
//        }else if(hash.get(1).equals("Borja")) {
//            resultado = true;
//        }
//        }else if(hash.get(7).equals("Esteban")) {
//            resultado = true;
//        }
//        if(resultado){
//            System.out.println("Test 1: OK✅");
//        }else{
//            System.out.println("Test 1: FAIL❌");
//        }

        System.out.println(hash);

    }

}
