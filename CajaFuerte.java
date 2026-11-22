public class CajaFuerte {


    private static final int MAX_INTENTOS_FALLIDOS = 3;
    private static final int LARGO_MINIMO_COMBINACION = 4;


    private String combinacion;
    private boolean bloqueada;
    private int intentosFallidos;
    private boolean abierta;

    public CajaFuerte(String combinacionInicial) {
        if (!esCombinacionValida(combinacionInicial)) {
            throw new IllegalArgumentException(
                    "La combinación debe tener al menos " + LARGO_MINIMO_COMBINACION + " caracteres.");
        }
        this.combinacion = combinacionInicial;
        this.bloqueada = false;
        this.intentosFallidos = 0;
        this.abierta = false;
    }


    public boolean estaBloqueada() {
        return bloqueada;
    }

    public boolean estaAbierta() {
        return abierta;
    }

    public int getIntentosFallidos() {
        return intentosFallidos;
    }




    public boolean abrir(String intentoClave) {
        if (!autenticar(intentoClave)) {
            return false;
        }
        abierta = true;
        System.out.println("Clave correcta: la caja fuerte se ABRIÓ.");
        return true;
    }

    public void cerrar() {
        abierta = false;
        System.out.println("La caja fuerte se CERRÓ.");
    }


    public boolean cambiarCombinacion(String claveActual, String nuevaCombinacion) {
        if (!autenticar(claveActual)) {
            System.out.println("Cambio de combinación rechazado.");
            return false;
        }
        if (!esCombinacionValida(nuevaCombinacion)) {
            System.out.println("Cambio de combinación rechazado: la nueva combinación debe tener al menos "
                    + LARGO_MINIMO_COMBINACION + " caracteres.");
            return false;
        }
        if (combinacion.equals(nuevaCombinacion)) {
            System.out.println("Cambio de combinación rechazado: la nueva combinación debe ser distinta de la actual.");
            return false;
        }
        combinacion = nuevaCombinacion;
        System.out.println("Combinación actualizada correctamente.");
        return true;
    }


    private boolean autenticar(String intento) {
        if (bloqueada) {
            System.out.println("Caja BLOQUEADA: no se aceptan más intentos.");
            return false;
        }
        if (combinacion.equals(intento)) {
            intentosFallidos = 0;
            return true;
        }
        intentosFallidos++;
        if (intentosFallidos >= MAX_INTENTOS_FALLIDOS) {
            bloqueada = true;
            System.out.println("Clave incorrecta. Se alcanzaron " + MAX_INTENTOS_FALLIDOS
                    + " errores consecutivos: la caja fuerte quedó BLOQUEADA.");
        } else {
            System.out.println("Clave incorrecta. Intentos restantes: "
                    + (MAX_INTENTOS_FALLIDOS - intentosFallidos) + ".");
        }
        return false;
    }

    private boolean esCombinacionValida(String clave) {
        return clave != null && clave.length() >= LARGO_MINIMO_COMBINACION;
    }


    public String obtenerEstado() {
        return "Caja fuerte | " + (abierta ? "ABIERTA" : "CERRADA")
                + " | " + (bloqueada ? "BLOQUEADA" : "Operativa")
                + " | Intentos fallidos: " + intentosFallidos + "/" + MAX_INTENTOS_FALLIDOS;
    }
}