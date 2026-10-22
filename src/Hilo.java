public class Hilo extends Thread {
     private String[] texto;
    private Character consonante;
    private int contador;
    contador_total C_contador;
    public Hilo(String[] texto, Character consonante, contador_total C_contador){
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


        }
        C_contador.incrementar(this.contador);

    }

    public int get_contador(){
        return this.contador;

    }
    public Character get_consonante(){
        return this.consonante;

    }






}
