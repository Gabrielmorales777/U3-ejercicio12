public class Main {

    public static void main(String[] args) {


        CajaFuerte caja1 = new CajaFuerte("1234");

        System.out.println("=== Caja 1: estado inicial ===");
        System.out.println(caja1.obtenerEstado());

        System.out.println("\n=== Dos errores y luego un acierto (la racha se reinicia) ===");
        caja1.abrir("0000");
        caja1.abrir("1111");
        caja1.abrir("1234");
        System.out.println(caja1.obtenerEstado());
        caja1.cerrar();

        System.out.println("\n=== Cambio de combinación ===");
        caja1.cambiarCombinacion("9999", "5678");
        caja1.cambiarCombinacion("1234", "12");
        caja1.cambiarCombinacion("1234", "1234");
        caja1.cambiarCombinacion("1234", "5678");

        System.out.println("\n=== Verificación tras el cambio ===");
        caja1.abrir("1234");
        caja1.abrir("5678");
        System.out.println(caja1.obtenerEstado());


        CajaFuerte caja2 = new CajaFuerte("4321");

        System.out.println("\n=== Caja 2: tres errores consecutivos ===");
        caja2.abrir("0000");
        caja2.abrir("1111");
        caja2.abrir("2222");
        System.out.println(caja2.obtenerEstado());

        System.out.println("\n=== Caja 2: intentos con la caja bloqueada ===");
        caja2.abrir("4321");
        caja2.cambiarCombinacion("4321", "8765");
        System.out.println(caja2.obtenerEstado());


    }
}