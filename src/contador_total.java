public class contador_total
{
    public  int total=0;
    public synchronized void incrementar(int num){
        this.total = this.total + num;

    }
    public int getTotal() {
        return this.total;
    }


}
