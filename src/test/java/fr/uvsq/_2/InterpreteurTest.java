package fr.uvsq._2;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class InterpreteurTest 
{
	@Test
	public void testInterpreteur()
	{
		Interpreteur it = new Interpreteur();
		assertNotNull(it.commande);
	}
	
	@Test
	public void testInit()
	{
		Interpreteur it = Interpreteur.init();
		assertNotNull(it.commande);
	}
}
