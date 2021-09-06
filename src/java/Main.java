import javax.swing.*;
import java.util.Arrays;

public class Main {
    public static Cliente[] clienti = new Cliente[10];
    public static int nClienti = 0;

    public static void main(String[] args){
       do{
           menu();

       }while (true);

    }

    public static void menu(){
        String[] options = {"1. Visualizza Lista Clienti", "2. Inserisci Cliente", "3. Modifica Cliente", "4. Cancella Cliente", "5. Esci"};
        String menu = (String)JOptionPane.showInputDialog(null, "Che operazione vuoi fare??",
                "Menu", JOptionPane.QUESTION_MESSAGE,null, options, options[1]);
        System.out.println(menu);

        switch (menu){
            case "1. Visualizza Lista Clienti":
                visualizzaListaClienti();
                break;
            case "2. Inserisci Cliente":
                inserisciNuovoCliente(new Cliente(JOptionPane.showInputDialog(null, "inserisci nome"), JOptionPane.showInputDialog(null, "inserisci cognome")));
                break;
            case "3. Modifica Cliente":
                visualizzaListaClienti();
                String indice = JOptionPane.showInputDialog(null, "Inserisci l'indice del cliente da modificare",JOptionPane.QUESTION_MESSAGE);
                modificaCliente(Integer.parseInt(indice));
                break;
            case "4. Cancella Cliente":
                visualizzaListaClienti();
                String index = JOptionPane.showInputDialog(null, "Inserisci l'indice del cliente da cancellare",JOptionPane.QUESTION_MESSAGE);
                cancellaCliente(Integer.parseInt(index));
                break;
            case "5. Esci":
        }

    }

    public static void visualizzaListaClienti(){
        StringBuilder builder = new StringBuilder(clienti.length);
        for (int i=0;i<clienti.length;builder.append(clienti[i++])) builder.append("\n"+ i+ " " );
        JOptionPane.showMessageDialog(null, builder.toString(), "Lista clienti", JOptionPane.INFORMATION_MESSAGE);
    }

    public static Cliente[] inserisciNuovoCliente(Cliente cliente){
        clienti[nClienti] = cliente;
        nClienti++;
        return clienti;
    }

    public static Cliente[] modificaCliente(int i){
        clienti[i].setNome(JOptionPane.showInputDialog(null, "inserisci nome"));
        clienti[i].setCognome(JOptionPane.showInputDialog(null, "inserisci cognome"));
        return clienti;
    }

    public static void cancellaCliente(int i){
        clienti[i]= null;
    }


}
