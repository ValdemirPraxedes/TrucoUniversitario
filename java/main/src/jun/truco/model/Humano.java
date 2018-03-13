package jun.truco.model;

public class Humano extends Jogador{

	public Humano(String nome) {
		super(nome);
		
	}
	
	public Carta jogar(int posicao){
		if(posicao < 0 || posicao > mao.size())throw new ArrayIndexOutOfBoundsException();
		return mao.remove(posicao);
	}

}
