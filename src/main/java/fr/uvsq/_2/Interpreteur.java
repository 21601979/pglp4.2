package fr.uvsq._2;

import java.util.HashMap;
import java.util.Map;

public class Interpreteur
{
	protected final Map<String,Commande> commande;
	
	protected Interpreteur()
	{
		this.commande = new HashMap<String, Commande>();
	}
	
	public void addCommande(String name, Commande c)
	{
		this.commande.put(name, c);
	}
	
	public void executeCommande(String name)
	{
		if(this.commande.containsKey(name))
		{
			this.commande.get(name).aply();
		}
	}
	
	public static Interpreteur Init()
	{
		Interpreteur it = new Interpreteur();
		it.addCommande("quit",()->System.out.println("stop") );
		it.addCommande("undo",()->System.out.println("undo") );
		return it;
	}
}
