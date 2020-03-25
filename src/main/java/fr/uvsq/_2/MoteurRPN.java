package fr.uvsq._2;

import java.util.Stack;

public class MoteurRPN extends Interpreteur 
{
	private static Stack<Integer> p;
	private static Stack<Stack> undo;
	static int stop;
	
	public MoteurRPN()
	{
		super();
		stop = 0;
		p = new Stack<Integer>();
		undo = new Stack<Stack>();
	}
	
	public static MoteurRPN Init()
	{
		MoteurRPN it = new MoteurRPN();
		it.addCommande("quit",()->stop = 1 );
		it.addCommande("undo",()->{
			p = undo.pop();
			affiche();
		} );
		it.addCommande("+",()->{
			int val1 = p.pop();
			int val2 = p.pop();
			undo.push((Stack<Integer>)p.clone());
			p.push(val2+val1);
			affiche();
		});
		it.addCommande("-",()->{
			int val1 = p.pop();
			int val2 = p.pop();
			undo.push((Stack<Integer>)p.clone());
			p.push(val2-val1);
			affiche();
		} );
		it.addCommande("*",()->{
			int val1 = p.pop();
			int val2 = p.pop();
			undo.push((Stack<Integer>)p.clone());
			p.push(val2*val1);
			affiche();
		});
		it.addCommande("/",()->{
			int val1 = p.pop();
			int val2 = p.pop();
			undo.push((Stack<Integer>)p.clone());
			p.push(val2/val1);
			affiche();
		} );
		return it;
	}
	
	public void addOperande(int val)
	{
		undo.push((Stack<Integer>)p.clone());
		p.push(val);
		affiche();
	}
	
	public static void affiche() 
	{
		System.out.println(p);
	}
}
