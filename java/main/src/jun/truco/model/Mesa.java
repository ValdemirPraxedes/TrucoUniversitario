package jun.truco.model;

import java.util.ArrayList;
import java.util.List;

public class Mesa {

	private Carta maiorCarta;
	private int manilha;
	private Carta[] mesa;
	private int numerosCartas = 1;
	private List<Jogador> jogadores = new ArrayList<Jogador>();
	private Turno turno = new Turno();
	private int rodadeJogador = 0;

	
	public void addJogador(Jogador... j){
		for(Jogador jogador : j)
		jogadores.add(jogador);
	}
	
	public int NumerosJogadores(){
		return jogadores.size();
	}
	
	public void DarAsCartas(){
		
		factoryTurno(rodadeJogador);
		Baralho b = new Baralho();
		jogadores.get(rodadeJogador).embaralhar(b);
		for(Jogador j : turno.getJogador())
		jogadores.get(rodadeJogador).DarAsCartas(b, j, numerosCartas);
	
	}
	
	public int getNumerosCartas() {
		return numerosCartas;
	}
	
	public void vira(Carta c){
		int valor = c.getValor();
		if(valor < 0 || valor > 9)throw new ArrayIndexOutOfBoundsException();
		
		if(valor == 9)valor = 0;
		else
			valor++;
		
		manilha = valor;
	}
	public String getManilha(){
		return Carta.Valor[manilha];
	}
	public void setNumerosCartas(int numerosCartas) {
		this.numerosCartas = numerosCartas;
	}

	private void factoryTurno(int posicao){
		Jogador[] j = new Jogador[jogadores.size()];
		int x = posicao+1;
		int index = 0;
		while( x != posicao){
			if(x >= jogadores.size()){
				x = 0;
				j[index] = jogadores.get(x);
				index++;
				continue;
			}
			j[index] = jogadores.get(x);
			x++; index++;
		}
		turno.setTurno(j);
	}
}
