package jun.truco.model;
/**
 * Classe Humano que simula um Jogador. 
 * Classe Humano estende da Classe Jogador.
 * @author Valdemir Praxedes 
 *
 */
public class Humano extends Jogador{

	public Humano(String nome) {
		super(nome);
		
	}
	
	public Carta jogar(int posicao){
		if(posicao < 0 || posicao > mao.size())throw new ArrayIndexOutOfBoundsException();
		return mao.remove(posicao);
	}

}
