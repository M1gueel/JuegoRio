import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class JuegoRio {
    static ArrayList<String> rioIzquierda = new ArrayList<>(Arrays.asList("Caperucita", "Lobo", "Uva"));
    static ArrayList<String> rioDerecha = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static boolean salir = false;
    static boolean booleanRioIzquierda = true;
    static boolean booleanRioDerecha = true;

    public static void main(String[] args) {
        System.out.println("Rio izquierda");
        rioIzquierda.forEach(e -> System.out.printf(e + " "));
        System.out.println("\nRio derecha");
        rioDerecha.forEach(e -> System.out.printf(e + " "));
        do {
            realizarJugada();
        }
        while (booleanRioIzquierda && booleanRioDerecha);
    }

    private static void realizarJugada() {
        System.out.println("\n1. MOVER CAPERUCITA\n2. MOVER UVA\n3. MOVER LOBO\n0. SALIR");
        switch (scanner.nextInt()) {
            case 1 -> mover("Caperucita");
            case 2 -> mover("Uva");
            case 3 -> mover("Lobo");
            case 0 -> {
                salir = true;
                try {
                    Thread.sleep(1000); // Ajusta el tiempo según la lógica del juego
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
            default -> System.out.println("Ingresa una opción válida");
        }
    }

    private static void mover(String actor) {
        if (desplegarSegundoMenu()) {
            cruzarRioHaciaDerecha(actor);
            return;
        }
        cruzarRioHaciaIzquierda(actor);
    }

    private static boolean desplegarSegundoMenu() {
        System.out.println("1.MOVER A LA DERECHA\n-1.MOVER A LA IZQUIERDA\n");
        return scanner.nextInt() >= 1;
    }

    public static void cruzarRioHaciaIzquierda(String actor) {
        if (verificarEstado(rioDerecha, actor)) {
            rioIzquierda.add(rioDerecha.remove(rioDerecha.indexOf(actor)));
            barcoMovimiento(-1, actor.charAt(0));
        } else {
            System.out.println("No se puede realizar movimiento");
        }
        booleanRioDerecha = verificarJugada(rioDerecha);
    }

    public static void cruzarRioHaciaDerecha(String actor) {
        booleanRioDerecha = verificarJugada(rioDerecha);
        if (booleanRioDerecha) {
            if (verificarEstado(rioIzquierda, actor)) {
                rioDerecha.add(rioIzquierda.remove(rioIzquierda.indexOf(actor)));
                barcoMovimiento(1, actor.charAt(0));
            } else {
                System.out.println("No se puede realizar movimiento");
            }
            booleanRioIzquierda = verificarJugada(rioIzquierda);
        }
    }

    public static boolean verificarEstado(ArrayList<String> actores, String actor) {
        return actores.contains(actor);
    }

    public static boolean verificarJugada(ArrayList<String> actores) {
        if (actores.contains("Caperucita") && actores.contains("Uva") && actores.size() == 2) {
            System.out.println("La Caperucita se ha comido las uvas, has perdido!");
            return false;
        } else if (actores.contains("Caperucita") && actores.contains("Lobo") && actores.size() == 2) {
            System.out.println("El lobo se ha comido a Caperucita, has perdido!");
            return false;

        }
        return true;
    }

    public static void barcoMovimiento(int desplazamiento, char actor) {
        ArrayList<String> animacionHaciaDerecha = new ArrayList<>(Arrays.asList("\\", "O", String.valueOf(actor), "/", "_", "_", "_", "_", "_", "_", "_", "_"));
        ArrayList<String> animacionHaciaIzquierda = new ArrayList<>(Arrays.asList("_", "_", "_", "_", "_", "_", "_", "_", "\\", "O", String.valueOf(actor), "/"));
        StringBuilder rioIzquierda = new StringBuilder();
        StringBuilder animacion = new StringBuilder();
        StringBuilder rioDerecha = new StringBuilder();
        if (desplazamiento == 1) {
            JuegoRio.rioIzquierda.forEach(e -> rioIzquierda.append(e).append(" "));
            JuegoRio.rioDerecha.forEach(e -> rioDerecha.append(e).append(" "));
            pausa();
            for (int i = 0; i < 9; i++) {
                animacionHaciaDerecha.forEach(e -> animacion.append(e).append(" "));
                animacionHaciaDerecha.remove(animacionHaciaDerecha.size() - 1);
                animacionHaciaDerecha.add(0, "_");
                System.out.print(rioIzquierda + " " + animacion + " " + rioDerecha);
                animacion.setLength(0);
                pausa();
                System.out.print("\r");
            }
            System.out.println();
        } else {
            JuegoRio.rioIzquierda.forEach(e -> rioIzquierda.append(e).append(" "));
            JuegoRio.rioDerecha.forEach(e -> rioDerecha.append(e).append(" "));
            pausa();
            for (int i = 0; i < 9; i++) {
                animacionHaciaIzquierda.forEach(e -> animacion.append(e).append(" "));
                animacionHaciaIzquierda.remove(0);
                animacionHaciaIzquierda.add("_");
                System.out.print(rioIzquierda + " " + animacion + " " + rioDerecha);
                animacion.setLength(0);
                pausa();
                System.out.print("\r");
            }
            System.out.println();
        }
    }

    private static void pausa() {
        try {
            Thread.sleep(250); // Simula un trabajo de medio segundo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}