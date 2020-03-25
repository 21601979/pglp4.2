package fr.uvsq._2;

import java.util.Stack;
/**
 * @author Tanguy
 *class moteur .
 */
public class MoteurRPN extends Interpreteur {
    /**
     * pile qui contient les opérande.
     */
    private static Stack<Integer> p;
    /**
     * pile qui contient toute les étapes qui se sont déroulées.
     */
    private static Stack<Stack> undo;
	/**
	 * variable qui termine le programme si elle a une valeur de 1.
	 */
	private static int stop;

    /**
     * constructeur de MoteurRPN.
     */
	public MoteurRPN() {
	    super();
	    stop = 0;
	    p = new Stack<Integer>();
	    undo = new Stack<Stack>();
	    }
    /**
     * méthode qui initialise l'objet moteurRPN.
     * @return retour d'un moteurRPN initialisé.
     */
    public static MoteurRPN init() {
        MoteurRPN it = new MoteurRPN();
        it.addCommande("quit", () -> stop = 1);
        it.addCommande("undo", () -> {
            p = undo.pop();
            affiche();
		    });
        it.addCommande("+", () -> {
            int val1 = p.pop();
            int val2 = p.pop();
            undo.push((Stack<Integer>) p.clone());
            p.push(val2 + val1);
            affiche();
            });
        it.addCommande("-", () -> {
            int val1 = p.pop();
            int val2 = p.pop();
            undo.push((Stack<Integer>) p.clone());
            p.push(val2 - val1);
            affiche();
            });
		it.addCommande("*", () -> {
		    int val1 = p.pop();
		    int val2 = p.pop();
		    undo.push((Stack<Integer>) p.clone());
		    p.push(val2 * val1);
		    affiche();
		    });
	    it.addCommande("/", () -> {
	        int val1 = p.pop();
	        int val2 = p.pop();
	        undo.push((Stack<Integer>) p.clone());
	        p.push(val2 / val1);
		    affiche();
		    });
	    return it;
	    }

    /**
     * fonction qui ajoute une opérande dans la pile p.
     * @param val opérande a ajouter.
     */
    public void addOperande(final int val) {
        undo.push((Stack<Integer>) p.clone());
        p.push(val);
        affiche();
        }
    /**
     * methode qui renvoi la pile p sous forme de liste.
     * @return String représentant la pile p.
     */
    public static String ToString() {
        return p.toString();
        }
    /**
     * methode qui affiche la pile p dans le terminal.
     */
    public static void affiche() {
        System.out.println(MoteurRPN.ToString());
        }
    /**
     * methode qui permet de récupérer la variable stop.
     * @return variable stop.
     */
    public static int getStop() {
        return stop;
    }
}
