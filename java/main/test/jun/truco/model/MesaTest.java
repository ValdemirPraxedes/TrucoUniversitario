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
	
	@Test
	public void PrimeiraPartidaRodadaQuatroJogadores() {
			Jogador j = new Jogador("juninho");
			Jogador j2 = new Jogador("L");
			Jogador j3 = new Jogador("m");
			Jogador j4 = new Jogador("m");
			Mesa m = new Mesa(j,j2,j3,j4);
			
			j.receberCarta(new Carta(3,Naipe.Paus));
			j2.receberCarta(new Carta(5,Naipe.Paus));
			j3.receberCarta(new Carta(5,Naipe.Copas));
			j4.receberCarta(new Carta(1,Naipe.Paus));
			
			Carta vira = new Carta(4, Naipe.Paus);
			m.vira(vira);
			
			m.ComeçarTurno();
			
			while (m.hasRodada()) {
				while(m.getTurno().hasnext()){
					Jogador jogador = m.getTurno().next();
					m.getForcaDasCartas().CartaJogada(jogador, jogador.jogar(0));
				}
			}
			Assert.assertEquals(j2,m.getForcaDasCartas().getJogadorFez());
			
	}
	
	@Test
	public void SegundaPartidaRodadaQuatroJogadores() {
			Jogador j = new Jogador("juninho");
			Jogador j2 = new Jogador("L");
			Jogador j3 = new Jogador("m");
			Jogador j4 = new Jogador("n");
			Mesa m = new Mesa(j,j2,j3,j4);
			
			j.receberCarta(new Carta(2,Naipe.Paus));
			j2.receberCarta(new Carta(1,Naipe.Paus));
			j3.receberCarta(new Carta(1,Naipe.Copas));
			j4.receberCarta(new Carta(1,Naipe.Paus));
			
			j.receberCarta(new Carta(2,Naipe.Espadas));
			j2.receberCarta(new Carta(9,Naipe.Paus));
			j3.receberCarta(new Carta(1,Naipe.Copas));
			j4.receberCarta(new Carta(4,Naipe.Paus));
			
			Carta vira = new Carta(4, Naipe.Paus);
			m.vira(vira);
			m.setNumerosCartas(2);
			m.setRodadasPorPartidas(2);
			m.ComeçarTurno();
			int quantidadeInteração = 0;
			while (m.hasRodada()) {
				if(quantidadeInteração == 1){
					Assert.assertEquals(j.getNome(),m.getForcaDasCartas().getJogadorFez().getNome());
					Assert.assertEquals(j.getNome(),m.getTurno().getJogador()[0].getNome());
				}
				while(m.getTurno().hasnext()){
					Jogador jogador = m.getTurno().next();
				    m.getForcaDasCartas().CartaJogada(jogador, jogador.jogar(0));
				}
				m.limpaMesa();
				quantidadeInteração++;
			}
			Assert.assertEquals(quantidadeInteração,2);
			Assert.assertEquals(j.getNome(),m.getForcaDasCartas().getJogadorFez().getNome());
			
	}
	
	@Test
	public void TerceiraPartidaRodadaQuatroJogadores() {
			Jogador j = new Jogador("juninho");
			Jogador j2 = new Jogador("L");
			Jogador j3 = new Jogador("m");
			Jogador j4 = new Jogador("n");
			Mesa m = new Mesa(j,j2,j3,j4);
			
			j.receberCarta(new Carta(2,Naipe.Paus));
			j2.receberCarta(new Carta(1,Naipe.Paus));
			j3.receberCarta(new Carta(1,Naipe.Copas));
			j4.receberCarta(new Carta(1,Naipe.Paus));
			
			j.receberCarta(new Carta(2,Naipe.Espadas));
			j2.receberCarta(new Carta(9,Naipe.Paus));
			j3.receberCarta(new Carta(1,Naipe.Copas));
			j4.receberCarta(new Carta(4,Naipe.Paus));
			
			j.receberCarta(new Carta(6,Naipe.Espadas));
			j2.receberCarta(new Carta(0,Naipe.Paus));
			j3.receberCarta(new Carta(8,Naipe.Copas));
			j4.receberCarta(new Carta(7,Naipe.Paus));
			
			Carta vira = new Carta(4, Naipe.Paus);
			m.vira(vira);
			m.setNumerosCartas(3);
			m.setRodadasPorPartidas(3);
			m.ComeçarTurno();
			int quantidadeInteração = 0;
			while (m.hasRodada()) {
				if(quantidadeInteração == 1){
					Assert.assertEquals(j.getNome(),m.getForcaDasCartas().getJogadorFez().getNome());
					Assert.assertEquals(j.getNome(),m.getTurno().getJogador()[0].getNome());
				}
				else if(quantidadeInteração == 2){
					Assert.assertEquals(j.getNome(),m.getForcaDasCartas().getJogadorFez().getNome());
					Assert.assertEquals(j.getNome(),m.getTurno().getJogador()[0].getNome());
				}
				while(m.getTurno().hasnext()){
					Jogador jogador = m.getTurno().next();
				    m.getForcaDasCartas().CartaJogada(jogador, jogador.jogar(0));
				}
				m.limpaMesa();
				quantidadeInteração++;
			}
			Assert.assertEquals(quantidadeInteração,3);
			Assert.assertEquals(j2.getNome(),m.getForcaDasCartas().getJogadorFez().getNome());
			
	}
   
	
	
	
}
