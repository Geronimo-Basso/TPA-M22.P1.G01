public class Pruebas {

    public static void main(String[] args) {
        Pruebas pruebas = new Pruebas();
        pruebas.test1();
        pruebas.test2();
    }

    public void test1(){
        //Test 1: Insertar 4 elementos y comprobar que se insertan correctamente.

        boolean resultado = false;
        Hash<String> hash1 = new Hash<>(11, 0.75f);
        hash1.insertar(11,"Geronimo");
        hash1.insertar(12,"Angel");
        hash1.insertar(1,"Borja");
        hash1.insertar(7,"Esteban");
//        if(hash1.get(11).equals("Geronimo")){
//            resultado = true;
//        }else if(hash1.get(12).equals("Angel")) {
//            resultado = true;
//        }else if(hash1.get(1).equals("Borja")) {
//            resultado = true;
//        }
//        }else if(hash1.get(7).equals("Esteban")) {
//            resultado = true;
//        }
//        if(resultado){
//            System.out.println("Test 1: OK✅");
//        }else{
//            System.out.println("Test 1: FAIL❌");
//        }

        System.out.println(hash1);
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


//        if(hash1.get(11).equals("Geronimo")){
//            resultado = true;
//        }else if(hash1.get(12).equals("Angel")) {
//            resultado = true;
//        }else if(hash1.get(1).equals("Borja")) {
//            resultado = true;
//        }
//        }else if(hash1.get(7).equals("Esteban")) {
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
