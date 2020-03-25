package fr.uvsq._2;

import java.util.Scanner;

/**
 * @author Tanguy
 *class qui permet la saisie des commande par les utilisateurs .
 */
public class SaisieRPN {
    /**
     * scaner qui permet la lescture des entrèes terminales .
     */
    private Scanner scan;
    /**
     * moteurRPN qui permet le calcul.
     */
    private MoteurRPN mot;

    /**
     * constructeur de saisieRPN.
     */
    public SaisieRPN() {
        scan = new Scanner(System.in);
        mot = MoteurRPN.init();
        System.out.print(mot.commande);
        while (MoteurRPN.getStop() != 1) {
            if (scan.hasNextInt()) {
                mot.addOperande(scan.nextInt());
                } else {
                    mot.executeCommande(scan.next());
                    }
            }
        System.out.println("end");
        }
}
