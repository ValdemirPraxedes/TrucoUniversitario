package jun.truco.model;

import java.util.Random;

public class CPUNormal extends CPU {

	private Mesa m;
	private IAAcoes vou;
	
	public CPUNormal(String nome, Mesa m) {
		super(nome);
		this.m = m;
		vou = new IAAcoes(m,this);
	}

	@Override
	public Carta Jogar() {
		if(mao.size() == 1) return mao.remove(0);
		else{
			if(pontosPendente == 0){
				return ModoDescante();
			}else if(pontosPendente > pontos){
				return modoFazedor();
			}else{
				return ModoDescante();
			}
			
		}
	}


	
	


	
	private Carta ModoDescante(){
		if(m.getMesa()[0] != null){
			
			//Quando tem manilha na mesa
			if(vou.olharSeTemManilhaNaMesa()){
				
				int posicao = vou.posicaoDaManilhaNaMao();
				if(posicao != -1){
					if(vou.posicaoDeCartaNaMesa(mao.get(posicao)) > 0)return mao.remove(posicao);
				}else{
					return mao.remove(vou.getPosicaoDaMaiorCartaNaMao());
				}
			}
			
			//empache
			for(int x = 0; x < mao.size(); x++){
			if(vou.CartaEmpacha(mao.get(x))){
					return mao.remove(x);
				}
			}
		
			//jogarMenorCarta
			for(int x = 0; x < mao.size(); x++){
				if(vou.posicaoDeCartaNaMesa(mao.get(x)) > 0)
						return mao.remove(x);
				}
			
			return mao.remove(vou.getPosicaoDaMenorCartaNaMao());
		}else{
			return mao.remove(vou.getPosicaoDaMenorCartaNaMao());
		}
	}
	
	private Carta modoFazedor(){
		if(m.getMesa()[0] != null){
			
			//Quando tem manilha na mesa
			if(vou.olharSeTemManilhaNaMesa()){
				
				int posicao = vou.posicaoDaManilhaNaMao();
				if(posicao != -1){
					if(vou.posicaoDeCartaNaMesa(mao.get(posicao)) == 0)return mao.remove(posicao);
				}else{
					return mao.remove(vou.getPosicaoDaMenorCartaNaMao());
				}
			}
			
			for(int x = 0; x < mao.size(); x++){
				if(vou.posicaoDeCartaNaMesa(mao.get(x)) == 0)
						return mao.remove(x);
				}
			
			return mao.remove(vou.getPosicaoDaMenorCartaNaMao());
		}else{
			return mao.remove(vou.getPosicaoDaMaiorCartaNaMao());
		}
	}


	@Override
	public int escolherPontosPendentes(int limiteDeCartas) {
		
		int retorno = 0;
		if(m.getPartidas() == 0)retorno = FazerOuNaoFazer();
		else
			retorno = QuantosFazer();
		this.setPontosPendente(retorno);
		return retorno;
		
	}
	private int QuantosFazer(){
		int pontos = 0;
		double probabilidadePontos = probabilidadePontos();
		for(int x = 0; x < mao.size(); x++){
			if(Carta.Valor[mao.get(x).getValor()].equals(m.getManilha())){pontos++;continue;}
			else if((probabilidadeDaCarta(x)+probabilidadePontos)-(mao.size()*0.1) < 3.0)pontos++;
		}
		
		if(m.getTurno().getPosicao() == m.getTurno().getJogador().length)
		   if(verificarSeDarParaDizerOsPontos(pontos))return pontos;
			else
		      return (pontos == 0) ? pontos+1 : pontos-1; 
		return pontos;	
		
	}
	private double probabilidadePontos(){
	
		if(m.getTurno().getPosicao() != 0){
			return pontosTotalNaMesaNoMomento() * 0.2;
		}else return 0;
	}
	private int pontosTotalNaMesaNoMomento() {
		int retorno = 0;
		for(int x = 0; x < m.getTurno().getPosicao()-1; x++)
			retorno += m.getTurno().getJogador()[x].getPontosPendente();
		
		return retorno;
		
	}

	private double probabilidadeDaCarta(int posicao){
			int valor = 0;
			if(Baralho.valorDasCartas.indexOf(Carta.Valor[mao.get(posicao).getValor()]) < Baralho.valorDasCartas.indexOf(m.getManilha()))
				valor = Baralho.valorDasCartas.indexOf(Carta.Valor[mao.get(posicao).getValor()])-1;
				else valor = Baralho.valorDasCartas.indexOf(Carta.Valor[mao.get(posicao).getValor()]);
			
			return ((40-(valor*4))/4)+(0.1*m.getJogadores().size());
		
	}
	private int FazerOuNaoFazer(){
		int pontos = 0;
		double probabilidade = 0.0;
		if(procurarManilhaNaPrimeiraPartida()){
			pontos = 0;
		}
		else{
		String maiorCarta = maiorValorNaoEmpachado(procurarCartaNaoEmpachadas());
		
		if(maiorCarta.equals(""))pontos = 1;
		else{
			int quantosFazem = 0;
			int valor = 0;
			
			if(Baralho.valorDasCartas.indexOf(maiorCarta) < Baralho.valorDasCartas.indexOf(m.getManilha()))
			valor = Baralho.valorDasCartas.indexOf(maiorCarta)-1;
			else valor = Baralho.valorDasCartas.indexOf(maiorCarta);
			
			probabilidade = (40-(valor*4))/4;
			
			if(m.getTurno().getPosicao() != 0){
				quantosFazem = olharQuantosJaFalaram();
				double peso = 2 /(m.getJogadores().size()-1);
				probabilidade += quantosFazem * peso;
			}
			}
		}
		if(probabilidade > 4.0)pontos = 1;
		if(m.getTurno().getPosicao() == m.getTurno().getJogador().length){
			if(verificarSeDarParaDizerOsPontos(pontos))return pontos;
			else return (pontos == 1) ? 0 : 1; 
		}
		return pontos;
		
	}
	private boolean verificarSeDarParaDizerOsPontos(int pontos){
		int soma = pontos;
		for(int x = 0; x < m.getTurno().getPosicao()-1; x++){
			soma += m.getTurno().getJogador()[x].getPontosPendente();
		}
		if(soma == m.getNumerosCartas())return false;
		return true;
	}
	private int olharQuantosJaFalaram(){
		int retorno = 0;
		for(int x = 0; x <= m.getTurno().getPosicao(); x++){
			if(m.getTurno().getJogador()[x].getPontosPendente() == 0)retorno++;
		}
		return retorno;
	}
	private boolean procurarManilhaNaPrimeiraPartida(){
		for(Jogador j: m.getJogadores()){
			if(j.equals(this))continue;
			if(m.getManilha().equals(Carta.Valor[j.mao.get(0).getValor()]))return true;
		}
		return false;
	}
	
	private String procurarCartaNaoEmpachadas(){
		String mapeamento = "";
		
		
		for(Jogador j: m.getJogadores()){
			if(j.equals(this))continue;
			mapeamento += Carta.Valor[j.mao.get(0).getValor()];
			
		}
		
		String valoresNaoEmpacado = "";
		if(!mapeamento.equals(""))
		  for(int x = 0; x < mapeamento.length();x++){
			  String map = mapeamento.replace(mapeamento.charAt(x), '*');
			  int qtdRepetido = 0;
			  for(int y = 0; y <map.length();y++) if(map.charAt(y) == '*')qtdRepetido++;
				
			  if(qtdRepetido == 1)valoresNaoEmpacado += mapeamento.charAt(x)+"";		
		  }
		return valoresNaoEmpacado;
			
		}
	
	 private String maiorValorNaoEmpachado(String s){
		 
		 String maior = s.equals("") ? s.indexOf(0)+"": "";
		 
	 		 for(int x = 1; x < s.length();x++)
			 if(Baralho.valorDasCartas.indexOf(s.charAt(x)) > Baralho.valorDasCartas.indexOf(maior))
				 maior = s.charAt(x)+"";
	 		 
			return maior;
	 }

}
