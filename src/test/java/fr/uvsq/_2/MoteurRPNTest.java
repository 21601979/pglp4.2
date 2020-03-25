package fr.uvsq._2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Stack;

import org.junit.Test;

public class MoteurRPNTest 
{
	@Test
	public void InitTest()
	{
		MoteurRPN it = MoteurRPN.init();
		assertNotNull(it.commande);
	}
	
	@Test
	public void addOperrandeTest()
	{
		MoteurRPN it = MoteurRPN.init();
		it.addOperande(1);
		Stack<Integer> test = new Stack<Integer>();
		test.push(1);
		assertEquals(test.toString(),MoteurRPN.ToString());
	}
	
	@Test
	public void addTest()
	{
		MoteurRPN it = MoteurRPN.init();
		it.addOperande(1);
		it.addOperande(1);
		it.executeCommande("+");
		Stack<Integer> test = new Stack<Integer>();
		test.push(2);
		assertEquals(test.toString(),MoteurRPN.ToString());
	}
	
	@Test
	public void suppTest()
	{
		MoteurRPN it = MoteurRPN.init();
		it.addOperande(1);
		it.addOperande(1);
		it.executeCommande("-");
		Stack<Integer> test = new Stack<Integer>();
		test.push(0);
		assertEquals(test.toString(),MoteurRPN.ToString());
	}
	
	@Test
	public void multTest()
	{
		MoteurRPN it = MoteurRPN.init();
		it.addOperande(1);
		it.addOperande(1);
		it.executeCommande("*");
		Stack<Integer> test = new Stack<Integer>();
		test.push(1);
		assertEquals(test.toString(),MoteurRPN.ToString());
	}
	
	@Test
	public void divTest()
	{
		MoteurRPN it = MoteurRPN.init();
		it.addOperande(1);
		it.addOperande(1);
		it.executeCommande("/");
		Stack<Integer> test = new Stack<Integer>();
		test.push(1);
		assertEquals(test.toString(),MoteurRPN.ToString());
	}
	
	@Test
	public void undoTest()
	{
		MoteurRPN it = MoteurRPN.init();
		it.addOperande(1);
		it.addOperande(1);
		it.executeCommande("undo");
		Stack<Integer> test = new Stack<Integer>();
		test.push(1);
		assertEquals(test.toString(),MoteurRPN.ToString());
	}
}
