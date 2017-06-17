package jun.truco.model;

import java.util.ArrayList;
import java.util.List;

public class Mesa {

	private int manilha;
	private Carta[] mesa;
	private Jogador[] MapeamentoJogadores;
	private int numerosCartas = 1;
	private List<Jogador> jogadores = new ArrayList<Jogador>();
	private Turno turno = new Turno();
	private int rodadeJogador = 0;
	private int JogadorComMaiorCartaNaMesa = -1;
	private String valoresEmpachado = "";

	
	public void addJogador(Jogador... j){
		for(Jogador jogador : j)
		jogadores.add(jogador);
		
		mesa = new Carta[jogadores.size()];
		MapeamentoJogadores = new Jogador[jogadores.size()];
	}
	
	
	public int NumerosJogadores(){
		return jogadores.size();
	}
	public Jogador getJogadorFez(){
		if(JogadorComMaiorCartaNaMesa == -1){
			if(getMaiorCarta() == null)return null;
		}
		Jogador j = MapeamentoJogadores[JogadorComMaiorCartaNaMesa];
		JogadorComMaiorCartaNaMesa = -1;
		return j;
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
	public Carta getMaiorCarta(){
		Carta c = null;
		for(int x = 0; x < mesa.length && mesa[x] != null;x++){
			Boolean repetido = false;
			for(char valor : valoresEmpachado.toCharArray())
			{
			if(Carta.Valor[mesa[x].getValor()].equals(valor+"")){
				repetido = true;
				break;
				}
			}
			if(repetido)continue;
			JogadorComMaiorCartaNaMesa = x;
			return mesa[x];
			
		}
		return c;
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
	public void CartaJogada(Jogador j,Carta c){
		
		if(mesa[0] == null){
		   mesa[0] = c;
		   MapeamentoJogadores[0] = j;
		}
		else{
			if(c.getValor() == manilha){
				boolean ManilhaNaMesa = false;
				int quantidadeManilhas = 0;
				for(int x = 0; x < mesa.length && mesa[x] != null;x++){
					if(mesa[x].getValor() == c.getValor())
						{
						     ManilhaNaMesa = true;
							if(c.getNaipe().ordinal() < mesa[x].getNaipe().ordinal()){
								percorrerMesa(x, j, c);	
								return;
							}
							else{
								quantidadeManilhas++;
							}
						}
				}
				if(!ManilhaNaMesa){
					percorrerMesa(0, j, c);
				}else{
					percorrerMesa(quantidadeManilhas, j, c);
				}
			}
			else{
				
				for(int x = 0; x < mesa.length && mesa[x] != null;x++){
					if(mesa[x].getValor() != manilha){
						if(Baralho.valorDasCartas.indexOf(Carta.Valor[c.getValor()]) > Baralho.valorDasCartas.indexOf(Carta.Valor[mesa[x].getValor()])){
							percorrerMesa(x, j, c);
							return;
						}
						else if(Baralho.valorDasCartas.indexOf(Carta.Valor[c.getValor()]) == Baralho.valorDasCartas.indexOf(Carta.Valor[mesa[x].getValor()])){
							percorrerMesa(x, j, c);
							valoresEmpachado += Carta.Valor[c.getValor()];
							return;
						}
						else if(x == mesa.length-1){
							mesa[x] = c;
							MapeamentoJogadores[x] = j;
							return;
						}
						else {
							if(mesa[x+1] == null){
								mesa[x+1] = c;
								MapeamentoJogadores[x+1] = j;
								break;
							}
						}
					}
				}
			}
		}
	}
	
	private void percorrerMesa(int posicao, Jogador j, Carta c){
		Carta aux = mesa[posicao];
		Jogador jAux = j;
		for(int x = posicao; x  < mesa.length-1 && mesa[x] != null;x++){
			Carta aux2 = mesa[x+1];
			mesa[x+1] = aux;
			aux = aux2; 
			
			Jogador jAux2 = MapeamentoJogadores[x+1];
			MapeamentoJogadores[x+1] = jAux;
			jAux = jAux2;
		}
		mesa[posicao] = c;
		MapeamentoJogadores[posicao] = j;
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
