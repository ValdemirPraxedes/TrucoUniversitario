package jun.truco.model;

public abstract class CPU extends Jogador{

	public CPU(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}
	
	public abstract Carta Jogar();
	public abstract int escolherPontosPendentes(int limiteDeCartas);

}
