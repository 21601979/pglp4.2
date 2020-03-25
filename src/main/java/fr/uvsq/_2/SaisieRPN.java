package fr.uvsq._2;

import java.util.Scanner;

public class SaisieRPN 
{
	private Scanner scan;
	private MoteurRPN mot;
	
	public SaisieRPN()
	{
		scan = new Scanner(System.in);
		mot = MoteurRPN.Init();
		System.out.print(mot.commande);
		while(MoteurRPN.stop != 1)
		{System.out.println("ok");
			if(scan.hasNextInt())
			{
				mot.addOperande(scan.nextInt());
			}
			else
			{
				mot.executeCommande(scan.next());
			}
		}
		System.out.println("end");
	}
}