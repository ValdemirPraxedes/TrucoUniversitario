package jun.truco.model;

import static org.junit.Assert.*;

import org.junit.Test;

import jun.truco.model.Carta.Naipe;
import junit.framework.Assert;

public class CPUNormalTest {

	@Test
	public void QuandoTemManilhaNaMesaTodosPrecisamFazer() {
		Mesa m = new Mesa();
		Jogador j1 = new  CPUNormal("Cpu 1", m);
		Jogador j2 = new  CPUNormal("Cpu 2", m);
		Jogador j3 = new  CPUNormal("Cpu 3", m);
		Carta vira = new Carta(0, Naipe.Copas);
		m.addJogador(j1,j2,j3);
		m.vira(vira);
		
		j1.mao.add(new Carta(1,Naipe.Paus));
		j1.mao.add(new Carta(2,Naipe.Paus));
		
		j2.mao.add(new Carta(1,Naipe.Espadas));
		j2.mao.add(new Carta(2,Naipe.Espadas));
		
		j3.mao.add(new Carta(1,Naipe.Copas));
		j3.mao.add(new Carta(2,Naipe.Copas));
		
		j1.setPontosPendente(1);
		j3.setPontosPendente(1);
		j2.setPontosPendente(1);
		
		m.setPartidas(1);
		m.setRodadasPorPartidas(2);
		m.setNumerosCartas(2);
		m.ComeçarPartida();
		int rodada = 1;
		while(m.hasRodada()){
			while(m.getTurno().hasnext()){
				CPU c = (CPU) m.getTurno().next();
				Carta carta = c.Jogar();
				m.getForcaDasCartas().CartaJogada(c, carta);
				
			}
			if(rodada == 1)Assert.assertEquals(j1,m.getForcaDasCartas().getJogadorFez());
			rodada++;
			m.limpaMesa();
		}
		
		Assert.assertEquals(j3,m.getForcaDasCartas().getJogadorFez());
	}

}
