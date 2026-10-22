import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class Contador_de_caracteres {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<String> consonantes = new ArrayList<>();

        System.out.println("dime cinco consonantes");
        String valido="bcdfghjklmnñpqrstvwxyzBCDFGHJKLMNÑPQRSTVWXYZ";
        while (consonantes.size() < 5){

            String consonante = teclado.nextLine();
            if (consonante.length() == 1 && valido.contains(consonante)){
                consonantes.add(consonante);

            }else {
                System.out.println("no es una consonante "+ consonante);
            }

        }
        System.out.println("Ahora dame un texto");
        String texto = teclado.nextLine();

        String[] texto_plano =texto.trim().split("\\s+");

        contador_total contador_total = new contador_total();

        List<Hilo> listaHilos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            char c = consonantes.get(i).charAt(0);
            Hilo Hilo = new Hilo(texto_plano, c,contador_total);
            listaHilos.add(Hilo);
            Hilo.start();
        }

            for (Hilo H : listaHilos) {
            try {
                H.join();
                System.out.println("Hilo "+H.get_consonante()+" Ha contado: "+H.get_contador());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }




        System.out.println("total: "+contador_total.getTotal());

    }








}
