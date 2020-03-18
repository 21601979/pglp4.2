package fr.uvsq._2;

import java.util.Stack;

public class MoteurRPN extends Interpreteur 
{
	private Stack<Integer> p;
	
	public MoteurRPN()
	{
		super();
		p = new Stack<Integer>();
	}
	
	public void addOperande(Integer val)
	{
		p.push(val);
	}
	
	public void opération(char op)
	{
		if(p.size()>=2)
		{
			if(op == '+')
			{
				int val1 = p.pop();
				int val2 = p.pop();
				p.push(val2+val1);
			}
			else if(op == '-')
			{
				int val1 = p.pop();
				int val2 = p.pop();
				p.push(val2-val1);
			}
			else if(op == '*')
			{
				int val1 = p.pop();
				int val2 = p.pop();
				p.push(val2*val1);
			}
			else if(op == '/')
			{
				int val1 = p.pop();
				int val2 = p.pop();
				p.push(val2/val1);
			}
			else
			{
				System.out.println("l'opérateur n'éxiste pas");
			}
		}
	}
	
	public void affiche() 
	{
		System.out.println(p);
	}
}
