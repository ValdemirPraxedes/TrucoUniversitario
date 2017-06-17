package jun.truco.model;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import jun.truco.model.Carta.Naipe;

public class ForcaDasCartasTest {

	@Test
	public void forçaDaCartaComUmaCarta(){
		Carta vira = new Carta(0, Naipe.Copas);
		Mesa m = new Mesa();
		Jogador j1 = new Jogador("juninho");
		Jogador j2 = new Jogador("cpu");
		Jogador j3 = new Jogador("ana");
		Jogador j4 = new Jogador("Maria");	
		 m.addJogador(j1,j2,j3,j4);
		 m.vira(vira);
		 Carta c = new Carta(1,Naipe.Copas);
		 m.ComeçarTurno();
		 m.getForcaDasCartas().CartaJogada(j1, c);
		 Assert.assertEquals(c, m.getForcaDasCartas().getMaiorCarta());
		 
	}
	
	@Test
	public void forçaDaCartaComDuasCartas(){
		Carta vira = new Carta(9, Naipe.Copas);
		Mesa m = new Mesa();
		
		Jogador j1 = new Jogador("juninho");
		Jogador j2 = new Jogador("cpu");
		Jogador j3 = new Jogador("ana");
		Jogador j4 = new Jogador("Maria");	
		 m.addJogador(j1,j2,j3,j4);
		 m.vira(vira);
		 Carta c = new Carta(1,Naipe.Ouros);
		 Carta c2 = new Carta(2,Naipe.Espadas);
		 m.ComeçarTurno();
		 m.getForcaDasCartas().CartaJogada(j1, c);
		 m.getForcaDasCartas().CartaJogada(j2, c2);
		 Assert.assertEquals(c2, m.getForcaDasCartas().getMaiorCarta());
		 
	}
	
	@Test
	public void forçaDaCartaComManilha(){
		Carta vira = new Carta(2, Naipe.Copas);
		Mesa m = new Mesa();
		
		Jogador j1 = new Jogador("juninho");
		Jogador j2 = new Jogador("cpu");
		Jogador j3 = new Jogador("ana");
		Jogador j4 = new Jogador("Maria");	
		 m.addJogador(j1,j2,j3,j4);
		 m.vira(vira);
		 Carta c = new Carta(2,Naipe.Ouros);
		 Carta c2 = new Carta(3,Naipe.Espadas);
		 Carta c3 = new Carta(1,Naipe.Ouros);
		 Carta c4 = new Carta(7,Naipe.Espadas);
		 m.ComeçarTurno();
		 m.getForcaDasCartas().CartaJogada(j1, c);
		 m.getForcaDasCartas().CartaJogada(j2, c2);
		 m.getForcaDasCartas().CartaJogada(j2, c3);
		 m.getForcaDasCartas().CartaJogada(j2, c4);
		 Assert.assertEquals(c2, m.getForcaDasCartas().getMaiorCarta());
		 
	}
	
	@Test
	public void forçaDaCartaComDuasManilha(){
		Carta vira = new Carta(2, Naipe.Copas);
		Mesa m = new Mesa();
		m.vira(vira);
		Jogador j1 = new Jogador("juninho");
		Jogador j2 = new Jogador("cpu");
		Jogador j3 = new Jogador("ana");
		Jogador j4 = new Jogador("Maria");	
		 m.addJogador(j1,j2,j3,j4);
		 
		 Carta c = new Carta(2,Naipe.Paus);
		 Carta c2 = new Carta(3,Naipe.Paus);
		 Carta c3 = new Carta(3,Naipe.Ouros);
		 Carta c4 = new Carta(7,Naipe.Espadas);
		 m.ComeçarTurno();
		 m.getForcaDasCartas().CartaJogada(j1, c);
		 m.getForcaDasCartas().CartaJogada(j2, c2);
		 m.getForcaDasCartas().CartaJogada(j2, c3);
		 m.getForcaDasCartas().CartaJogada(j2, c4);
		 Assert.assertEquals(c2, m.getForcaDasCartas().getMaiorCarta());
	}
	
	@Test
	public void forçaDaCartaComTodasAsManilhas(){
		Carta vira = new Carta(2, Naipe.Copas);
		Mesa m = new Mesa();
		m.vira(vira);
		Jogador j1 = new Jogador("juninho");
		Jogador j2 = new Jogador("cpu");
		Jogador j3 = new Jogador("ana");
		Jogador j4 = new Jogador("Maria");	
		 m.addJogador(j1,j2,j3,j4);
		 Carta c = new Carta(3,Naipe.Copas);
		 Carta c4 = new Carta(3,Naipe.Paus);
		 Carta c3 = new Carta(3,Naipe.Ouros);
		 Carta c2 = new Carta(3,Naipe.Espadas);
		 m.ComeçarTurno();
		 m.getForcaDasCartas().CartaJogada(j1, c);
		 m.getForcaDasCartas().CartaJogada(j2, c2);
		 m.getForcaDasCartas().CartaJogada(j2, c3);
		 m.getForcaDasCartas().CartaJogada(j2, c4);
		 Assert.assertEquals(c4, m.getForcaDasCartas().getMaiorCarta());
		 
	}
	
	@Test
	public void empachado(){
		Carta vira = new Carta(4, Naipe.Copas);
		Mesa m = new Mesa();
		m.vira(vira);
		Jogador j1 = new Jogador("juninho");
		Jogador j2 = new Jogador("cpu");
		Jogador j3 = new Jogador("ana");
		Jogador j4 = new Jogador("Maria");	
		 m.addJogador(j1,j2,j3,j4);
		 Carta c = new Carta(1,Naipe.Copas);
		 Carta c2 = new Carta(1,Naipe.Espadas);
		 Carta c3 = new Carta(1,Naipe.Ouros);
		 Carta c4 = new Carta(1,Naipe.Paus);
		 m.ComeçarTurno();
		 m.getForcaDasCartas().CartaJogada(j1, c);
		 m.getForcaDasCartas().CartaJogada(j2, c2);
		 m.getForcaDasCartas().CartaJogada(j3, c3);
		 m.getForcaDasCartas().CartaJogada(j4, c4);
		 Assert.assertEquals(null, m.getForcaDasCartas().getMaiorCarta());
	}
	
	@Test
	public void forçaDaCartaJogoTipico(){
		Carta vira = new Carta(4, Naipe.Copas);
		Mesa m = new Mesa();
		m.vira(vira);
		Jogador j1 = new Jogador("juninho");
		Jogador j2 = new Jogador("cpu");
		Jogador j3 = new Jogador("ana");
		Jogador j4 = new Jogador("Maria");	
		 m.addJogador(j1,j2,j3,j4);
		 Carta c = new Carta(2,Naipe.Paus);
		 Carta c2 = new Carta(9,Naipe.Copas);
		 Carta c3 = new Carta(2,Naipe.Copas);
		 Carta c4 = new Carta(1,Naipe.Copas);
		 m.ComeçarTurno();
		 m.getForcaDasCartas().CartaJogada(j1, c);
		 m.getForcaDasCartas().CartaJogada(j2, c2);
		 m.getForcaDasCartas().CartaJogada(j3, c3);
		 m.getForcaDasCartas().CartaJogada(j4, c4);
		 Assert.assertEquals(c4, m.getForcaDasCartas().getMaiorCarta());
		 
	}
	
	@Test
	public void forçaDaCartaJogoTipicoNomeJogador(){
		Carta vira = new Carta(4, Naipe.Copas);
		Mesa m = new Mesa();
		m.vira(vira);
		Jogador j1 = new Jogador("juninho");
		Jogador j2 = new Jogador("cpu");
		Jogador j3 = new Jogador("ana");
		Jogador j4 = new Jogador("Maria");	
		 m.addJogador(j1,j2,j3,j4);
		 Carta c = new Carta(2,Naipe.Paus);
		 Carta c2 = new Carta(9,Naipe.Copas);
		 Carta c3 = new Carta(2,Naipe.Copas);
		 Carta c4 = new Carta(1,Naipe.Copas);
		 m.ComeçarTurno();
		 m.getForcaDasCartas().CartaJogada(j1, c);
		 m.getForcaDasCartas().CartaJogada(j2, c2);
		 m.getForcaDasCartas().CartaJogada(j3, c3);
		 m.getForcaDasCartas().CartaJogada(j4, c4);
		 Assert.assertEquals(j4.getNome(),m.getForcaDasCartas().getJogadorFez().getNome());
		 
	}

}
