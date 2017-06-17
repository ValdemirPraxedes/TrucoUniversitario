package jun.truco.model;

public class Turno {

	private Jogador[] jogadores;
	private int posicao = 0;
	
	
	public  Turno(Jogador[] j){
		this.jogadores = j;	
	}
	
	public Jogador vezJogador(){
		if(posicao < jogadores.length){
			Jogador j = jogadores[posicao];
			posicao++;
			return j;
		}
		return null;
	}
	public boolean hasnext(){
		if(posicao >= jogadores.length)return false;
		return true;
	}
	public Jogador next(){
		if(posicao >= jogadores.length)return null;
		Jogador j = jogadores[posicao];
		posicao++;
		return j;
	}
	public Jogador[] getJogador(){
		return jogadores;
	}
}
