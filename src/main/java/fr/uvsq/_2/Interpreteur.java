package fr.uvsq._2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tanguy
 * class interpreteur
 */
public class Interpreteur {
    /**
     * map qui contient le noms des commande et leurs fonctions.
     */
    protected final Map<String, Commande> commande;

    /**
     * constructeur de la class interpreteur.
     */
    protected Interpreteur() {
        this.commande = new HashMap<String, Commande>();
    }

    /**
     * @param name
     * nom de la commande.
     * @param c
     * fonction lié a la commande.
     */
    public void addCommande(final String name, final Commande c) {
        this.commande.put(name, c);
    }

    /**
     * fonction qui exécute des fonctions en fonction du contenu d'un string.
     * @param name
     * nom de la fonction a executer.
     */
    public void executeCommande(final String name) {
        if (this.commande.containsKey(name)) {
            this.commande.get(name).aply();
            }
        }
    /**
     * fonction qui initialise l'interpréteur.
     * @return retourne un interpréteur avec les les commande stop et undo.
     */
    public static Interpreteur init() {
        Interpreteur it = new Interpreteur();
        it.addCommande("quit", () -> System.out.println("stop"));
        it.addCommande("undo", () -> System.out.println("undo"));
        return it;
        }
}
