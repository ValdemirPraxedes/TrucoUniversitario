package jun.truco.model;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TurnoTest {

	@Test
	public void TurnoComDoisJogadores() {
		Jogador j = new Jogador("juninho");
		Jogador j2 = new Jogador("L");
		Mesa m = new Mesa(j,j2);
		m.ComeçarTurno();
		Jogador[] js = {j2,j};
		int x = 0;
		while(m.getTurno().hasnext()){
			Assert.assertEquals(js[x],m.getTurno().next());
			x++;
		}
	}
	
	@Test
	public void TurnoComTresJogadores() {
		Jogador j = new Jogador("juninho");
		Jogador j2 = new Jogador("L");
		Jogador j3 = new Jogador("m");
		Mesa m = new Mesa(j,j2,j3);
		m.ComeçarTurno();
		Jogador[] js = {j2,j3,j};
		int x = 0;
		while(m.getTurno().hasnext()){
			Assert.assertEquals(js[x],m.getTurno().next());
			x++;
		}
	}
	
	@Test
	public void TurnoComQuatroJogadores() {
		Jogador j = new Jogador("juninho");
		Jogador j2 = new Jogador("L");
		Jogador j3 = new Jogador("m");
		Jogador j4 = new Jogador("m");
		Mesa m = new Mesa(j,j2,j3,j4);
		m.ComeçarTurno();
		Jogador[] js = {j2,j3,j4,j};
		int x = 0;
		while(m.getTurno().hasnext()){
			Assert.assertEquals(js[x],m.getTurno().next());
			x++;
		}
	}

}
