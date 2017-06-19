package jun.truco.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.NumberOfDocuments;

public class Jogador {
	private String nome;
	private int vidas = 5;
	private int pontos;
	private int pontosPendente;
	public List<Carta> getMao() {
		return mao;
	}
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
	/**
	 * @return the pontos
	 */
	public int getPontos() {
		return pontos;
	}
	/**
	 * @param pontos the pontos to set
	 */
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	/**
	 * @return the vidas
	 */
	public int getVidas() {
		return vidas;
	}
	/**
	 * @param vidas the vidas to set
	 */
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	/**
	 * @return the pontosPendente
	 */
	public int getPontosPendente() {
		return pontosPendente;
	}
	/**
	 * @param pontosPendente the pontosPendente to set
	 */
	public void setPontosPendente(int pontosPendente) {
		this.pontosPendente = pontosPendente;
	}

	
}
