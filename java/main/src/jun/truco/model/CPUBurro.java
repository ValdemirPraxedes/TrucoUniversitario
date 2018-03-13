package jun.truco.model;

import java.util.Random;
/**
 *  Classe concreta de CPU que simula um Jogador CPU sem técnicas de jogo.
 *  Classe CPUBurro estende da classe CPU
 * @author Valdemir Praxedes
 *
 */
public class CPUBurro extends CPU{

	public CPUBurro(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Carta Jogar() {
		// TODO Auto-generated method stub
		Carta c = null;
		
		if(mao.size() > 0){
		Random r = new Random();
		 int carta = r.nextInt(mao.size());
		 c = mao.remove(carta);
		}
		return c;
	}

	@Override
	public int escolherPontosPendentes(int limiteDeCartas) {
		// TODO Auto-generated method stub
		  Random r = new Random();
		  int pendente = r.nextInt(limiteDeCartas);
		  setPontosPendente(pendente);
		  return pendente;
	}

}
