package jun.truco.model;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TurnoTest {

	@Test
	public void TurnoComDoisJogadores() {
		Jogador j = new Humano("juninho");
		Jogador j2 = new Humano("L");
		Mesa m = new Mesa(j,j2);
		m.ComecarPartida();
		Jogador[] js = {j2,j};
		int x = 0;
		while(m.getTurno().hasnext()){
			Assert.assertEquals(js[x],m.getTurno().next());
			x++;
		}
	}
	
	@Test
	public void TurnoComTresJogadores() {
		Jogador j = new Humano("juninho");
		Jogador j2 = new Humano("L");
		Jogador j3 = new Humano("m");
		Mesa m = new Mesa(j,j2,j3);
		m.ComecarPartida();
		Jogador[] js = {j2,j3,j};
		int x = 0;
		while(m.getTurno().hasnext()){
			Assert.assertEquals(js[x],m.getTurno().next());
			x++;
		}
	}
	
	@Test
	public void TurnoComQuatroJogadores() {
		Jogador j = new Humano("juninho");
		Jogador j2 = new Humano("L");
		Jogador j3 = new Humano("m");
		Jogador j4 = new Humano("m");
		Mesa m = new Mesa(j,j2,j3,j4);
		m.ComecarPartida();
		Jogador[] js = {j2,j3,j4,j};
		int x = 0;
		while(m.getTurno().hasnext()){
			Assert.assertEquals(js[x],m.getTurno().next());
			x++;
		}
	}

}
