package jun.truco.model;

public class Turno {

	private Jogador[] jogadores;
	private int posicao = 0;
	
	
	public void setTurno(Jogador[] j){
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
	
	public Jogador[] getJogador(){
		return jogadores;
	}
}