import javax.swing.*;
import java.util.Arrays;

public class Main {
    public static Cliente[] clienti = new Cliente[10];
    public static int nClienti = 0;
    static boolean programContinue = false;

    public static void main(String[] args){

        do{
            menu();

        }while (programContinue);

    }

    public static void menu(){
        String[] options = {"1. Visualizza Lista Clienti", "2. Inserisci Cliente", "3. Modifica Cliente", "4. Cancella Cliente", "5. Checkout","6. Esci"};
        String menu = (String)JOptionPane.showInputDialog(null, "Che operazione vuoi fare??",
                "Menu", JOptionPane.QUESTION_MESSAGE,null, options, options[1]);
        System.out.println(menu);

        switch (menu){
            case "1. Visualizza Lista Clienti":
                visualizzaListaClienti();
                programContinue= true;
                break;
            case "2. Inserisci Cliente":
                inserisciNuovoCliente();
                programContinue= true;
                break;
            case "3. Modifica Cliente":
                modificaCliente();
                programContinue= true;
                break;
            case "4. Cancella Cliente":
                cancellaCliente();
                programContinue= true;
                break;
            case "5. Checkout":
                esegiuCheckout();
                programContinue= true;
                break;
            case "6. Esci":
                programContinue = false;
                break;
        }

    }

    public static void visualizzaListaClienti(){
        StringBuilder builder = new StringBuilder(clienti.length);
        for (int i=0;i<clienti.length;builder.append(clienti[i++])) builder.append("\n"+ i+ " " );
        JOptionPane.showMessageDialog(null, builder.toString(), "Lista clienti", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void inserisciNuovoCliente(){
        Cliente cliente = new Cliente(JOptionPane.showInputDialog(null, "inserisci nome"),JOptionPane.showInputDialog(null, "inserisci cognome"),JOptionPane.showInputDialog(null, "Inserisci l'orario di inizio in formato HH:MM"));
        clienti[nClienti] = cliente;
        nClienti++;

    }

    public static void modificaCliente(){
        visualizzaListaClienti();
        String indice = JOptionPane.showInputDialog(null, "Inserisci l'indice del cliente da modificare",JOptionPane.QUESTION_MESSAGE);
        clienti[Integer.parseInt(indice)].setNome(JOptionPane.showInputDialog(null, "inserisci nome"));
        clienti[Integer.parseInt(indice)].setCognome(JOptionPane.showInputDialog(null, "inserisci cognome"));

    }

    public static void cancellaCliente(){
        visualizzaListaClienti();
        String index = JOptionPane.showInputDialog(null, "Inserisci l'indice del cliente da cancellare",JOptionPane.QUESTION_MESSAGE);
        clienti[Integer.parseInt(index)]= null;
    }

    public static void esegiuCheckout(){
        visualizzaListaClienti();
        String index = JOptionPane.showInputDialog(null, "Inserisci l'indice del cliente",JOptionPane.QUESTION_MESSAGE);
        String orarioFine= JOptionPane.showInputDialog(null, "Inserisci l'orario di fine in formato HH:MM",
                "orario di fine", JOptionPane.QUESTION_MESSAGE);
        clienti[Integer.parseInt(index)].setOraFine(orarioFine);
        String oraInizioDaSplittare = clienti[Integer.parseInt(index)].getOraInizio();
        String[] parts = oraInizioDaSplittare.split(":");
        int oreInizio= Integer.parseInt(parts[0]);
        int minutiInizio = Integer.parseInt(parts[1]);
        String oraFineDaSplittare = clienti[Integer.parseInt(index)].getOraFine();
        String[] part = oraFineDaSplittare.split(":");
        int oreFine= Integer.parseInt(part[0]);
        int minutiFine = Integer.parseInt(part[1]);
        int differenzaMinuti = (60 - minutiInizio)+ minutiFine;
        int differenzaOre = 0;
        if(differenzaMinuti > 0){
            differenzaOre = (oreFine - oreInizio) - 1;
        }
        int minutiUtilizzo= (differenzaOre * 60) + differenzaMinuti;
        int quantiQuartiDora = minutiUtilizzo / 15;
        if(minutiUtilizzo%15 != 0){
            quantiQuartiDora += 1;
        }
        int ore= quantiQuartiDora / 4;
        int restoQuartiDora= quantiQuartiDora%4;
        int mezzOra = restoQuartiDora / 2;
        int quartiDora = restoQuartiDora%2;
        double tariffa =  (ore + (mezzOra * 0.5) + (quartiDora * 0.3));
        JOptionPane.showMessageDialog(null, "Importo: "+ tariffa, "Checkout", JOptionPane.INFORMATION_MESSAGE);
    }

}
