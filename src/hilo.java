import java.util.ArrayList;
import java.util.List;


public class hilo extends Thread {
    String[] texto;
    Character consonante;
    int contador;
    contador_total C_contador;
    public hilo(String[] texto, Character consonante, contador_total C_contador){
        this.texto = texto;
        this.consonante = consonante;
        this.contador = 0;
        this.C_contador = C_contador;
    }

    public void run(){
       for (int i = 0; i < texto.length;i++){
            String palabra = texto[i];
            for(int e = 0; e <palabra.length(); e ++){
                if (palabra.charAt(e) == consonante){
                    this.contador++;

                }
            }
            C_contador.incrementar(this.contador);
           synchronized (System.out)
           {System.out.println("ha contado "+ this.contador + " " +consonante);}


        }

    }

    public int get_contador(){
        return this.contador;

    }





}
