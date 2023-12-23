import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class JuegoRio {
    static ArrayList<String> rioIzq = new ArrayList<>(Arrays.asList("Caperucita", "Lobo", "Uva"));
    static ArrayList<String> rioDer = new ArrayList<>(Arrays.asList("Obser"));
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println();
        int opcion = 0;
        do {
            realizarJugada();
        }
        while (verificarJugada(rioIzq) && verificarJugada(rioDer));
    }

    private static void realizarJugada() {
        int opcion;
        System.out.println("1. MOVER CAPERUCITA");
        System.out.println("2. MOVER UVA");
        System.out.println("3. MOVER LOBO");
        System.out.println("0. SALIR");
        opcion = scanner.nextInt();
        switch (opcion) {
            case 1 -> mover("Caperucita");
            case 2 -> mover("Uva");
            case 3 -> mover("Lobo");
            case 0 -> System.exit(0);
            default -> System.out.println("Ingresa una opción válida");
        }
    }

    private static void mover(String actor) {

        if (desplegarSegundoMenu()){
            cruzarRioHaciaDerecha(actor);
        }
        cruzarRioHaciaIzquierda(actor);


    }

    private static boolean desplegarSegundoMenu() {
        int opcion;
        System.out.println("1.MOVER A LA DERECHA\n-1.MOVER A LA IZQUIERDA\n");
        opcion = scanner.nextInt();
        return opcion >= 1;
    }


    public static void cruzarRioHaciaIzquierda(String actor) {
        char actorChar = actor.charAt(0);
        if (verificarEstado(rioDer, actor)) {
            rioIzq.add(rioDer.remove(rioDer.indexOf(actor)));
            barcoMovimiento(-1,actorChar);
        } else {
            System.out.println("No se puede realizar movimiento");
        }
        //rioIzq.forEach(s-> System.out.println(s));
        verificarJugada(rioDer);
        verificarJugada(rioIzq);
    }

    public static void cruzarRioHaciaDerecha(String actor) {
        char actorChar = actor.charAt(0);
        if (verificarEstado(rioIzq, actor)) {
            rioDer.add(rioIzq.remove(rioIzq.indexOf(actor)));
            barcoMovimiento(1,actorChar);
        } else {
            System.out.println("No se puede realizar movimiento");
        }
        //rioDer.forEach(s-> System.out.println(s));
        verificarJugada(rioIzq);
        verificarJugada(rioDer);
    }

    public static boolean verificarEstado(ArrayList<String> actores, String actor) {
       return actores.contains(actor);
    }

    public static boolean verificarJugada(ArrayList<String> actores) {
        if (rioDer.contains("Caperucita")&& rioDer.contains("Uva") && rioDer.contains("Lobo")){
            System.out.println("GANASTE");
            System.exit(0);
        }
        realizarJugada();
        if (actores.contains("Caperucita") && actores.contains("Uva")) {
            return false;
        } else return !actores.contains("Lobo") || !actores.contains("Caperucita");

    }

    public static void barcoMovimiento(int desplazamiento, char actor ){

        ArrayList<String> animacionHaciaDerecha = new ArrayList<>(Arrays.asList("\\","O",String.valueOf(actor), "/", "_","_", "_","_", "_","_", "_","_"));
        ArrayList<String> animacionHaciaIzquierda = new ArrayList<>(Arrays.asList("_","_", "_","_", "_","_", "_","_","\\","O",String.valueOf(actor),"/"));
        StringBuilder rioIzquierda = new StringBuilder();
        StringBuilder animacion = new StringBuilder();
        StringBuilder rioDerecha = new StringBuilder();
        StringBuilder fullString = new StringBuilder();

        if(desplazamiento==1){
            rioIzq.forEach(e->rioIzquierda.append(e).append(" "));
            rioDer.forEach(e-> rioDerecha.append(e).append(" "));

            pausa();
            for (int i = 0 ; i<9 ; i++){

                animacionHaciaDerecha.forEach(e-> animacion.append(e).append(" "));
                animacionHaciaDerecha.remove(animacionHaciaDerecha.size()-1);
                animacionHaciaDerecha.add(0,"_");

                System.out.print(rioIzquierda);
                System.out.print(animacion);
                System.out.print(rioDerecha);
                animacion.setLength(0);

                pausa();

                System.out.print("\r");

            }
            System.out.println();
            //System.out.println(fullString.toString());
            //fullString.setLength(0);

        }else{
            rioIzq.forEach(e->rioIzquierda.append(e).append(" "));
            rioDer.forEach(e-> rioDerecha.append(e).append(" "));

            pausa();
            for (int i = 0 ; i<9 ; i++){
                animacionHaciaIzquierda.forEach(e-> animacion.append(e).append(" "));
                animacionHaciaIzquierda.remove(0);
                animacionHaciaIzquierda.add("_");

                System.out.print(rioIzquierda);
                System.out.print(animacion);
                System.out.print(rioDerecha);
                animacion.setLength(0);
                pausa();

                System.out.print("\r");

            }
            System.out.println();
            //System.out.println(fullString.toString());
            //fullString.setLength(0);

        }

    }
    private static void pausa() {
        try {
            Thread.sleep(500); // Simula un trabajo de medio segundo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





}