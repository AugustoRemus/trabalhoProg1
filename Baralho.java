import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import javax.management.RuntimeErrorException;
import javax.swing.text.Utilities;



public class Baralho
{   
    public static void criarBaralho(ArrayList<Cartas> lista) 
    {
         for(int i =1; i<=13; i++)
            {
                Cartas carta;
                carta = new Cartas(i, 0, "de ouro");
                if(carta.naipeNome != "de ouro")
                    throw new RuntimeException("naipe criado errado");
                lista.add(carta);
            }

            for(int i =1; i<=13; i++)
            {
                Cartas carta;
                carta = new Cartas(i, 1, "de copa");
                if(carta.naipeNome != "de copa")
                    throw new RuntimeException("naipe criado errado");
                lista.add(carta);
            }

            for(int i =1; i<=13; i++)
            {
                Cartas carta;
                carta = new Cartas(i, 2, "de espada");
                if(carta.naipeNome != "de espada")
                    throw new RuntimeException("naipe criado errado");
                lista.add(carta);
            }

            for(int i =1; i<=13; i++)
            {
                Cartas carta;
                carta = new Cartas(i, 3, "de paus");
                if(carta.naipeNome != "de paus")
                    throw new RuntimeException("naipe criado errado");
                lista.add(carta);
            }
    }

    public static int pescarBlackJack(ArrayList<Cartas> lista)
    {
        if(lista.size() == 0)
            {
                throw new RuntimeException("voce nao tem um baralho ainda");
            }
        Cartas cartaBlacJack = lista.get(0);
        lista.remove(lista.get(0));
        
        int n = numeroParaNome(cartaBlacJack.numero);
        if(n ==1)
            System.out.printf("%d ", (cartaBlacJack).numero);
        System.out.printf("%s\n", (cartaBlacJack).naipeNome);
        int retorn = cartaBlacJack.numero;
        
        return(retorn);
            
        
        
    
    
        
    }
    
    
   
    public static int numeroParaNome(int numero)
    {
        
        if(numero == 11)
        {
            System.out.printf("Valéte(11) ");
            return(0);
        }

        else if (numero == 12)
        {
            System.out.printf("Rainha(12) ");
            return(0);
        }

        else if (numero == 13)
        {
            System.out.printf("Rei(13) ");
            return(0);
        }

        else
        return(1);
                    
    }


    public static void embaralhar(ArrayList<Cartas> lista){
        Collections.shuffle(lista);}
    


    public static void imprimirBaralho(ArrayList<Cartas> lista)
    {
        
        for(int i=0; i< lista.size(); i++)
        {
    
            int n = numeroParaNome(lista.get(i).numero);
            if(n ==1)
                System.out.printf("%d ", lista.get(i).numero);

            System.out.printf("%s\n", lista.get(i).naipeNome);
        } 
    }

    

public static void main(String[] args)
{
    //lista
    ArrayList<Cartas>  lista = new ArrayList();
    Jogador jogador1 = new Jogador();
    int cartasNaMao = 0;
    int cartasNoBaralho = 0;

    while(true){
            {
                
                System.out.printf("\nBem vindo, digite 1 para criar um baralho e 5 para embaralha-lo\n");
                /*//adicionando cartas
                criarBaralho(lista);
                
                //aleatorio
                embaralhar(lista);*/

            
            
                System.out.printf("insira: 1 para criar o baralho\n        2 para jogar blackjack\n        3 para pescar cartas\n        4 para imprimir o baralho\n        5 para embaralhar\n");
                
                
                //scaner
                Scanner escaner = new Scanner(System.in);
                int escolhasCertas[] = {1, 2, 3, 4, 5};
                int escolha = escaner.nextInt();
                int parar = 0;
                //System.out.printf("%d", escolha);
                for(int i = 0; i<(escolhasCertas.length);i++ )
                {
                    if(escolha == escolhasCertas[i])
                    {
                        parar = 1;
                    }
                }
                if(parar == 0)
                    throw new RuntimeException("opcao nao encontrado!");
                
                else{
                    if( escolha == 2)
                    {
                        
                        System.out.println("Black Jack!");
                        
                        int total = 0;
                        total = (pescarBlackJack(lista)) + total;
                        
                        
                        while(true)
                        {
                            
                            System.out.printf("1 para pescar outra carta, 2 para parar\ntotal: %d\n", total);
                            int esc = 0;
                            if (esc == 0)
                            {
                                esc = escaner.nextInt();
                            }
                            
                            if(esc == 1)
                            {
                                total = (pescarBlackJack(lista)) + total;
                            }
                            else if(esc== 2)
                            {
                                System.out.printf("para! \nseu placar: %d", total);
                                break;
                            }
                            else
                                throw new RuntimeException("comando invalido");
                            esc = 0;

                            if(total == 21)
                            {
                                System.out.printf("Ganhou!");
                                break;
                            }

                            else if(total> 21)
                            {
                                System.out.printf("Perdeu!\nplacar: %d\n", total);
                                break;
                            }
                        }
                    
                        

                    
                    }
                    else
                    {
                        if(escolha==3)
                        {
                            
                            System.out.printf("");
                            System.out.println("digite o numero de cartas que deseja pescar\n");
                            
                            int digitado = escaner.nextInt();
                        
                            if( digitado <= 0)
                                throw new RuntimeException("numero negativo");
                            
                            else if(digitado > lista.size())
                                throw new RuntimeException("numero maior que o baralho");
                            else  
                            {
                                System.out.println("pescando!");
                                for (int cart = 0; cart < digitado; cart++)
                                {
                                    lista.add(lista.get(0));
                                    cartasNaMao++;
                                }
                                for (int i = 0; i< cartasNaMao; i++)
                                {
                                    int n = numeroParaNome(lista.get(i).numero);
                                    if(n ==1)
                                        System.out.printf("%d ", lista.get(i).numero);

                                    System.out.printf("%s\n", lista.get(i).naipeNome);
                                }
                            }
                    }
                    else{
                        if( escolha == 4)
                        {
                            if(lista.size() == 0)
                            {
                                throw new RuntimeException("voce nao tem um baralho ainda");
                            }
                            System.out.printf("");
                            System.out.printf("numero de cartas: %d\n", lista.size());
                            imprimirBaralho(lista);
                        }
                        else{
                            if(escolha == 1)
                            {
                                System.out.printf("");
                                lista.clear();
                                criarBaralho(lista);
                                System.out.printf("baralho criado com sucesso\n");
                            }
                            else
                            {
                                if(escolha == 5)
                                {
                                    System.out.printf("");
                                    embaralhar(lista);
                                    System.out.printf("baralho embaralhado\n");
                                }
                            }                            }
                        }
                    }
                }    
            }      
        }
    } 
}


