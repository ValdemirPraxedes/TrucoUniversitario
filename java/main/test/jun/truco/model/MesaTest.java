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
	public void PrimeiraPartidaRodadaQuatroJogadoresEmpache() {
		Jogador j = new Humano("juninho");
		Jogador j2 = new Humano("cpu");
		Jogador j3 = new Humano("ana");
		Jogador j4 = new Humano("Maria");
			Mesa m = new Mesa(j,j2,j3,j4);
			
			j.receberCarta(new Carta(3,Naipe.Paus));
			j2.receberCarta(new Carta(3,Naipe.Paus));
			j3.receberCarta(new Carta(6,Naipe.Copas));
			j4.receberCarta(new Carta(1,Naipe.Paus));
			
			Carta vira = new Carta(4, Naipe.Paus);
			m.vira(vira);
			
			m.ComecarPartida();
			
			while (m.hasRodada()) {
				while(m.getTurno().hasnext()){
					Jogador jogador = m.getTurno().next();
					m.getForcaDasCartas().CartaJogada(jogador, ((Humano) jogador).jogar(0));
				}
			}
			Assert.assertEquals(j4.getNome(),m.getForcaDasCartas().getJogadorFez().getNome());
			
	}
	
	@Test
	public void PrimeiraPartidaRodadaQuatroJogadores() {
		Jogador j = new Humano("juninho");
		Jogador j2 = new Humano("cpu");
		Jogador j3 = new Humano("ana");
		Jogador j4 = new Humano("Maria");
			Mesa m = new Mesa(j,j2,j3,j4);
			
			j.receberCarta(new Carta(3,Naipe.Paus));
			j2.receberCarta(new Carta(5,Naipe.Paus));
			j3.receberCarta(new Carta(5,Naipe.Copas));
			j4.receberCarta(new Carta(1,Naipe.Paus));
			
			Carta vira = new Carta(4, Naipe.Paus);
			m.vira(vira);
			
			m.ComecarPartida();
			
			while (m.hasRodada()) {
				while(m.getTurno().hasnext()){
					Jogador jogador = m.getTurno().next();
					m.getForcaDasCartas().CartaJogada(jogador, ((Humano) jogador).jogar(0));
				}
			}
			Assert.assertEquals(j2,m.getForcaDasCartas().getJogadorFez());
			
	}
	
	@Test
	public void SegundaPartidaRodadaQuatroJogadoresEmpache() {
		Jogador j = new Humano("juninho");
		Jogador j2 = new Humano("cpu");
		Jogador j3 = new Humano("ana");
		Jogador j4 = new Humano("Maria");
			Mesa m = new Mesa(j,j2,j3,j4);
			
			j.receberCarta(new Carta(2,Naipe.Paus));
			j2.receberCarta(new Carta(1,Naipe.Paus));
			j3.receberCarta(new Carta(1,Naipe.Copas));
			j4.receberCarta(new Carta(1,Naipe.Paus));
			
			j.receberCarta(new Carta(2,Naipe.Espadas));
			j2.receberCarta(new Carta(9,Naipe.Paus));
			j3.receberCarta(new Carta(2,Naipe.Copas));
			j4.receberCarta(new Carta(4,Naipe.Paus));
			
			Carta vira = new Carta(4, Naipe.Paus);
			m.vira(vira);
			m.setNumerosCartas(2);
			m.setRodadasPorPartidas(2);
			m.ComecarPartida();
			int quantidadeInteracao = 0;
			while (m.hasRodada()) {
				if(quantidadeInteracao == 1){
					Assert.assertEquals(j.getNome(),m.getForcaDasCartas().getJogadorFez().getNome());
					Assert.assertEquals(j.getNome(),m.getTurno().getJogador()[0].getNome());
				}
				while(m.getTurno().hasnext()){
					Jogador jogador = m.getTurno().next();
				    m.getForcaDasCartas().CartaJogada(jogador, ((Humano) jogador).jogar(0));
				}
				m.limpaMesa();
				quantidadeInteracao++;
			}
			Assert.assertEquals(quantidadeInteracao,2);
			Assert.assertEquals(j2.getNome(),m.getForcaDasCartas().getJogadorFez().getNome());
			
	}
	
	@Test
	public void SegundaPartidaRodadaQuatroJogadores() {
		Jogador j = new Humano("juninho");
		Jogador j2 = new Humano("cpu");
		Jogador j3 = new Humano("ana");
		Jogador j4 = new Humano("Maria");
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
			m.ComecarPartida();
			int quantidadeInteracao = 0;
			while (m.hasRodada()) {
				if(quantidadeInteracao == 1){
					Assert.assertEquals(j.getNome(),m.getForcaDasCartas().getJogadorFez().getNome());
					Assert.assertEquals(j.getNome(),m.getTurno().getJogador()[0].getNome());
				}
				while(m.getTurno().hasnext()){
					Jogador jogador = m.getTurno().next();
				    m.getForcaDasCartas().CartaJogada(jogador, ((Humano) jogador).jogar(0));
				}
				m.limpaMesa();
				quantidadeInteracao++;
			}
			Assert.assertEquals(quantidadeInteracao,2);
			Assert.assertEquals(j.getNome(),m.getForcaDasCartas().getJogadorFez().getNome());
			
	}
	
	@Test
	public void TerceiraPartidaRodadaQuatroJogadores() {
		Jogador j = new Humano("juninho");
		Jogador j2 = new Humano("cpu");
		Jogador j3 = new Humano("ana");
		Jogador j4 = new Humano("Maria");
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
			m.ComecarPartida();
			int quantidadeInteracao = 0;
			while (m.hasRodada()) {
				if(quantidadeInteracao == 1){
					Assert.assertEquals(j.getNome(),m.getForcaDasCartas().getJogadorFez().getNome());
					Assert.assertEquals(j.getNome(),m.getTurno().getJogador()[0].getNome());
				}
				else if(quantidadeInteracao == 2){
					Assert.assertEquals(j.getNome(),m.getForcaDasCartas().getJogadorFez().getNome());
					Assert.assertEquals(j.getNome(),m.getTurno().getJogador()[0].getNome());
				}
				while(m.getTurno().hasnext()){
					Jogador jogador = m.getTurno().next();
				    m.getForcaDasCartas().CartaJogada(jogador, ((Humano) jogador).jogar(0));
				}
				m.limpaMesa();
				quantidadeInteracao++;
			}
			Assert.assertEquals(quantidadeInteracao,3);
			Assert.assertEquals(j2.getNome(),m.getForcaDasCartas().getJogadorFez().getNome());
			
	}
   
	@Test
	public void PontosPendentesLoop() {
		Jogador j = new Humano("juninho");
		Jogador j2 = new Humano("cpu");
		Jogador j3 = new Humano("ana");
		Jogador j4 = new Humano("Maria");
		Mesa m = new Mesa(j,j2,j3,j4);
		
		m.setNumerosCartas(8);
		int interacoes  = 0;
		for(Jogador jPontos = m.nextJogadoresVida(); jPontos != null; jPontos = m.nextJogadoresVida()){
			jPontos.setPontosPendente(2);
			if(interacoes == 8)break;
			else interacoes++;
		}
		
		
		Assert.assertEquals(8,interacoes);
	}
	
	@Test
	public void PontosPendentes() {
		Jogador j = new Humano("juninho");
		Jogador j2 = new Humano("cpu");
		Jogador j3 = new Humano("ana");
		Jogador j4 = new Humano("Maria");
		Mesa m = new Mesa(j,j2,j3,j4);
		
		m.setNumerosCartas(5);
		
		for(Jogador jPontos = m.nextJogadoresVida(); jPontos != null; jPontos = m.nextJogadoresVida()){
			jPontos.setPontosPendente(1);
			
		}
		
		
		Assert.assertEquals(j.getPontosPendente(),1);
	}


	@Test
	public void JogadoresHit() {
		
		Jogador j = new Humano("juninho");
		Jogador j2 = new Humano("cpu");
		Jogador j3 = new Humano("ana");
		Jogador j4 = new Humano("Maria");
		
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
		
		Carta vira = new Carta(0, Naipe.Paus);
		m.vira(vira);
		m.setNumerosCartas(3);
		
		Assert.assertEquals(5,j.getVidas());
		
		for(Jogador jPontos = m.nextJogadoresVida(); jPontos != null; jPontos = m.nextJogadoresVida()){
			jPontos.setPontosPendente(1);
			
		}
		m.setRodada(3);
		m.ComecarPartida();
	
		while (m.hasRodada()) {
		
			while(m.getTurno().hasnext()){
				Jogador jogador = m.getTurno().next();
			    m.getForcaDasCartas().CartaJogada(jogador, ((Humano) jogador).jogar(0));
			}
			m.limpaMesa();
		}
		
		Assert.assertEquals(4,j.getVidas());
	}
	
	@Test
	public void FimDoJogo() {
		
		Jogador j = new Humano("juninho");
		Jogador j2 = new Humano("cpu");
		Jogador j3 = new Humano("ana");
		Jogador j4 = new Humano("Maria");
		
		Mesa m = new Mesa(j,j2,j3,j4);
		
		j.receberCarta(new Carta(2,Naipe.Paus));
		j2.receberCarta(new Carta(1,Naipe.Paus));
		j3.receberCarta(new Carta(1,Naipe.Copas));
		j4.receberCarta(new Carta(1,Naipe.Espadas));
		
		j.receberCarta(new Carta(2,Naipe.Espadas));
		j2.receberCarta(new Carta(1,Naipe.Paus));
		j3.receberCarta(new Carta(1,Naipe.Copas));
		j4.receberCarta(new Carta(4,Naipe.Paus));
		
		j.receberCarta(new Carta(6,Naipe.Espadas));
		j2.receberCarta(new Carta(1,Naipe.Paus));
		j3.receberCarta(new Carta(8,Naipe.Copas));
		j4.receberCarta(new Carta(7,Naipe.Paus));
		j.setVidas(1);
		j3.setVidas(1);
		j4.setVidas(1);
		Carta vira = new Carta(0, Naipe.Paus);
		m.vira(vira);
		m.setNumerosCartas(3);
		
		
		
		for(Jogador jPontos = m.nextJogadoresVida(); jPontos != null; jPontos = m.nextJogadoresVida()){
			jPontos.setPontosPendente(1);
			
		}
		m.setRodada(3);
		m.ComecarPartida();
		do{
		while (m.hasRodada()) {
		
			while(m.getTurno().hasnext()){
				Jogador jogador = m.getTurno().next();
			    m.getForcaDasCartas().CartaJogada(jogador, ((Humano) jogador).jogar(0));
			}
			m.limpaMesa();
		}
		}while(m.fimDoJogo());
		
		Assert.assertEquals(j2,m.getGanhador());
	}
	
}
