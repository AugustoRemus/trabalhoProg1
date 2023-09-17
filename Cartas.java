public class Cartas 
{
    int numero;
    int naipe;
    String naipeNome;

    public Cartas(int numero, int naipe)
    {
        this.numero = numero;
        this.naipe = naipe;
        
    }

    public Cartas(int numero, int naipe, String naipeNome)
    {
        this.numero = numero;
        this.naipe = naipe;
        this.naipeNome = naipeNome;
        
    }    
}
