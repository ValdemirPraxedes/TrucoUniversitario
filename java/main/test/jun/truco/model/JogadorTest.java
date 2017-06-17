package jun.truco.model;

import org.junit.Assert;
import org.junit.Test;

public class JogadorTest {

	@Test
	public void DarUmaCarta(){
		Jogador j1 = new Jogador("juninho");
		Jogador j2 = new Jogador("cpu");
		Jogador j3 = new Jogador("ana");
		Jogador j4 = new Jogador("Maria");
		
		Mesa m = new Mesa();  	
		 m.addJogador(j1,j2,j3,j4);
		 m.DarAsCartas();
		 Assert.assertEquals(1, j1.quantidadeDeCartas());
		 Assert.assertEquals(1, j2.quantidadeDeCartas());
		 Assert.assertEquals(1, j3.quantidadeDeCartas());
		 Assert.assertEquals(1, j4.quantidadeDeCartas());
	}
	
	@Test
	public void DarDuasCartas(){
		Jogador j1 = new Jogador("juninho");
		Jogador j2 = new Jogador("cpu");
		Jogador j3 = new Jogador("ana");
		Jogador j4 = new Jogador("Maria");
		
		Mesa m = new Mesa();  	
		 m.addJogador(j1,j2,j3,j4);
		 m.setNumerosCartas(2);
		 m.DarAsCartas();
		 Assert.assertEquals(2, j1.quantidadeDeCartas());
		 Assert.assertEquals(2, j2.quantidadeDeCartas());
		 Assert.assertEquals(2, j3.quantidadeDeCartas());
		 Assert.assertEquals(2, j4.quantidadeDeCartas());
	}
	
	@Test
	public void DarTresCartas(){
		Jogador j1 = new Jogador("juninho");
		Jogador j2 = new Jogador("cpu");
		Jogador j3 = new Jogador("ana");
		Jogador j4 = new Jogador("Maria");
		
		 Mesa m = new Mesa();  	
		 m.addJogador(j1,j2,j3,j4);
		 m.setNumerosCartas(3);
		 m.DarAsCartas();
		 Assert.assertEquals(3, j1.quantidadeDeCartas());
		 Assert.assertEquals(3, j2.quantidadeDeCartas());
		 Assert.assertEquals(3, j3.quantidadeDeCartas());
		 Assert.assertEquals(3, j4.quantidadeDeCartas());
	}

	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void DarMaisQueOLimiteDeCartas(){
		Jogador j1 = new Jogador("juninho");
		Jogador j2 = new Jogador("cpu");
		Jogador j3 = new Jogador("ana");
		Jogador j4 = new Jogador("Maria");
		
		Mesa m = new Mesa();  	
		 m.addJogador(j1,j2,j3,j4);
		 m.setNumerosCartas(11);
		 m.DarAsCartas();
		j1.quantidadeDeCartas();
		j2.quantidadeDeCartas();
		j3.quantidadeDeCartas();
		j4.quantidadeDeCartas();
	}
}
