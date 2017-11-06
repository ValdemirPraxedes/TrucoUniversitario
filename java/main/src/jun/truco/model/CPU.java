package jun.truco.model;

/**
 * Classe abstrata para simular um jogador CPU.
 * Classe CPU estende da Classe Jogador.
 * @author Valdemir Praxedes
 *
 */
public abstract class CPU extends Jogador{

	public CPU(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}
	
	public abstract Carta Jogar();
	public abstract int escolherPontosPendentes(int limiteDeCartas);

}
