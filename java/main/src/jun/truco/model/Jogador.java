package jun.truco.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.NumberOfDocuments;

public class Jogador {
	private String nome;
	private List<Carta> mao = new ArrayList<Carta>();
	
	public Jogador(String nome){
		this.setNome(nome);
	}
	public Carta[] listagem(){
		return (Carta[]) mao.toArray();
	}
	
	public void receberCarta(Carta c){
		mao.add(c);
	}
	public int quantidadeDeCartas(){
		return mao.size();
	}
	public Carta jogar(int posicao){
		if(posicao < 0 || posicao > mao.size())throw new ArrayIndexOutOfBoundsException();
		return mao.remove(posicao);
	}
	
	public void embaralhar(Baralho b){
		b.embaralhar();
	}
	public void DarAsCartas(Baralho b, Jogador jogador,int quantidade){
		for(int x = 0; x < quantidade; x++){
			jogador.receberCarta(b.DarCarta());
		}
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
