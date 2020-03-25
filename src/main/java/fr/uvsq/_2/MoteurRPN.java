package fr.uvsq._2;

import java.util.Stack;

public class MoteurRPN extends Interpreteur 
{
	private static Stack<Integer> p;
	
	public MoteurRPN()
	{
		super();
		p = new Stack<Integer>();
	}
	
	public static Interpreteur Init()
	{
		Interpreteur it = Interpreteur.Init();
		it.addCommande("+",()->{
			int val1 = p.pop();
			int val2 = p.pop();
			p.push(val2+val1);
		});
		it.addCommande("-",()->{
			int val1 = p.pop();
			int val2 = p.pop();
			p.push(val2-val1);
		} );
		it.addCommande("*",()->{
			int val1 = p.pop();
			int val2 = p.pop();
			p.push(val2*val1);
		});
		it.addCommande("/",()->{
			int val1 = p.pop();
			int val2 = p.pop();
			p.push(val2/val1);
		} );
		return it;
	}
	
	public void addOperande(Integer val)
	{
		p.push(val);
	}
	
	public void affiche() 
	{
		System.out.println(p);
	}
}
