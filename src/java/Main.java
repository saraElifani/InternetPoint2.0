import javax.swing.*;
import java.util.Arrays;

public class Main {
    public static Cliente[] clienti = new Cliente[10];
    public static int nClienti = 0;

    public static void main(String[] args) {

          while (true){
              menu();
          }
    }

    public static void menu() {
        String[] options = {"1. Visualizza Lista Clienti", "2. Inserisci Cliente", "3. Modifica Cliente", "4. Cancella Cliente", "5. Checkout", "6. Esci"};
        String menu = (String) JOptionPane.showInputDialog(null, "Che operazione vuoi fare??",
                "Menu", JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        System.out.println(menu);
        if (menu == null) {
            System.exit(0);
        }

        switch (menu) {
            case "1. Visualizza Lista Clienti":
                visualizzaListaClienti();
                break;
            case "2. Inserisci Cliente":
                inserisciNuovoCliente();
                break;
            case "3. Modifica Cliente":
                modificaCliente();
                break;
            case "4. Cancella Cliente":
                cancellaCliente();
                break;
            case "5. Checkout":
                eseguiCheckout();
                break;
            case "6. Esci":
                System.exit(0);
                break;
        }
    }

    public static void visualizzaListaClienti() {
        StringBuilder builder = new StringBuilder(clienti.length);
        for (int i = 0; i < clienti.length; builder.append(clienti[i++])) builder.append("\n" + i + " ");
        JOptionPane.showMessageDialog(null, builder.toString(), "Lista clienti", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void inserisciNuovoCliente() {
        String nome = JOptionPane.showInputDialog(null, "inserisci nome");
        if (nome == null) menu();
        String cognome = JOptionPane.showInputDialog(null, "inserisci cognome");
        if (cognome == null) menu();
        String oraInizio = JOptionPane.showInputDialog(null, "Inserisci l'orario di inizio in formato HH:MM");
        if (oraInizio == null) menu();
        Cliente cliente = new Cliente(nome, cognome, oraInizio);
        clienti[nClienti] = cliente;
        nClienti++;

    }

    public static void modificaCliente() {
        visualizzaListaClienti();
        String indice = JOptionPane.showInputDialog(null, "Inserisci l'indice del cliente da modificare", "", JOptionPane.INFORMATION_MESSAGE);
        if (indice == null) menu();
        String nome = JOptionPane.showInputDialog(null, "inserisci nome");
        if (nome == null) menu();
        clienti[Integer.parseInt(indice)].setNome(nome);
        String cognome = JOptionPane.showInputDialog(null, "inserisci cognome");
        if (cognome == null) menu();
        clienti[Integer.parseInt(indice)].setCognome(cognome);
    }

    public static void cancellaCliente() {
        visualizzaListaClienti();
        String index = JOptionPane.showInputDialog(null, "Inserisci l'indice del cliente da cancellare", "", JOptionPane.QUESTION_MESSAGE);
        if (index == null) menu();
        clienti[Integer.parseInt(index)] = null;
    }

    public static void eseguiCheckout() {
        visualizzaListaClienti();
        String index = JOptionPane.showInputDialog(null, "Inserisci l'indice del cliente", "", JOptionPane.QUESTION_MESSAGE);
        if (index == null) menu();
        String orarioFine = JOptionPane.showInputDialog(null, "Inserisci l'orario di fine in formato HH:MM",
                "orario di fine", JOptionPane.QUESTION_MESSAGE);
        if (orarioFine == null) menu();
        clienti[Integer.parseInt(index)].setOraFine(orarioFine);
        String oraInizioDaSplittare = clienti[Integer.parseInt(index)].getOraInizio();
        String[] parts = oraInizioDaSplittare.split(":");
        int oreInizio = Integer.parseInt(parts[0]);
        int minutiInizio = Integer.parseInt(parts[1]);
        String oraFineDaSplittare = clienti[Integer.parseInt(index)].getOraFine();
        String[] part = oraFineDaSplittare.split(":");
        int oreFine = Integer.parseInt(part[0]);
        int minutiFine = Integer.parseInt(part[1]);
        int differenzaMinuti = (60 - minutiInizio) + minutiFine;
        int differenzaOre = 0;
        if (differenzaMinuti > 0) {
            differenzaOre = (oreFine - oreInizio) - 1;
        }
        int minutiUtilizzo = (differenzaOre * 60) + differenzaMinuti;
        int quantiQuartiDora = minutiUtilizzo / 15;
        if (minutiUtilizzo % 15 != 0) {
            quantiQuartiDora += 1;
        }
        int ore = quantiQuartiDora / 4;
        int restoQuartiDora = quantiQuartiDora % 4;
        int mezzOra = restoQuartiDora / 2;
        int quartiDora = restoQuartiDora % 2;
        double tariffa = (ore + (mezzOra * 0.5) + (quartiDora * 0.3));
        JOptionPane.showMessageDialog(null, "Importo: " + tariffa, "Checkout", JOptionPane.INFORMATION_MESSAGE);
    }

}
