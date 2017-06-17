package jun.truco.model;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import jun.truco.model.Carta.Naipe;

public class MesaTest {

	@Test
	public void TirarKmanilha() {
		Carta c = new Carta(9, Naipe.Copas);
		Mesa m = new Mesa();
		m.vira(c);
		
		Assert.assertEquals(Carta.Valor[0], m.getManilha());
	}
	
	@Test
	public void TiraASKmanilha() {
		Carta c = new Carta(0, Naipe.Copas);
		Mesa m = new Mesa();
		m.vira(c);
		
		Assert.assertEquals(Carta.Valor[1], m.getManilha());
	}

}
