package jun.truco.model;

public class IAAcoes {

	private Mesa m;
	private Jogador jogador;
	
	public IAAcoes(Mesa m, Jogador j) {
		this.m = m;
		this.jogador = j;
	}
	public boolean olharSeTemManilhaNaMesa(){
		for(int a = 0; a < m.getMesa().length && m.getMesa()[a] != null;a++){
			if(Carta.Valor[m.getMesa()[a].getValor()].equals(m.getManilha()))return true;
		}
		return false;
	}
	public int posicaoDaManilhaNaMao(){
		int posicao = getPosicaoDaMaiorCartaNaMao();
		if(Carta.Valor[jogador.getMao().get(posicao).getValor()].equals(m.getManilha()))return posicao;
		else return -1;
		
	}
	public int posicaoDeCartaNaMesa(Carta c){
		int posicao = 0;
		for(int a = 0; a < m.getMesa().length && m.getMesa()[a] != null;a++){
			Carta cMesa = compararCarta(c, m.getMesa()[a]); 
			if(c == cMesa)break;
			else if(cMesa == null)return -1;
			else posicao++;
		}
		return posicao;
	}
	
	public Carta compararCarta(Carta c1, Carta c2){
		
		if(Carta.Valor[c1.getValor()].equals(m.getManilha())){
			if(Carta.Valor[c2.getValor()].equals(m.getManilha())){
				if(c1.getNaipe().ordinal() < c2.getNaipe().ordinal()){
				   return c1;    	
				}else return c2;
			}else return c1;
		}else if(Baralho.valorDasCartas.indexOf(Carta.Valor[c1.getValor()]) > Baralho.valorDasCartas.indexOf(Carta.Valor[c2.getValor()]))return c1;
		else if(Baralho.valorDasCartas.indexOf(Carta.Valor[c1.getValor()]) == Baralho.valorDasCartas.indexOf(Carta.Valor[c2.getValor()]))return null;
		else return c2;
	}
	public int getPosicaoDaMaiorCartaNaMao(){
		int maiorValor = Baralho.valorDasCartas.indexOf(Carta.Valor[jogador.getMao().get(0).getValor()]);
		int posicao = 0;
		for(int x = 0; x < jogador.getMao().size();x++){
			if(Carta.Valor[jogador.getMao().get(x).getValor()].equals(m.getManilha())){
				if(Carta.Valor[jogador.getMao().get(posicao).getValor()].equals(m.getManilha())){
					if(jogador.getMao().get(x).getNaipe().ordinal() < jogador.getMao().get(posicao).getNaipe().ordinal())
						posicao = x;
				}else{
					
					posicao = x;
				}
				maiorValor = -1;
			}
			else if(maiorValor == -1)continue;
			else if(Baralho.valorDasCartas.indexOf(Carta.Valor[jogador.getMao().get(x).getValor()]) > maiorValor){
				maiorValor = Baralho.valorDasCartas.indexOf(Carta.Valor[jogador.getMao().get(x).getValor()]);
				posicao = x;
			}
		}
		return posicao;
	} 
	
	public boolean CartaEmpacha(Carta c){
		String mesa = "";
		
		for(int a = 0; a < m.getMesa().length && m.getMesa()[a] != null;a++)
			mesa += Carta.Valor[m.getMesa()[a].getValor()];
		
		return mesa.contains(Carta.Valor[c.getValor()]);
	}
	
	public int getPosicaoDaMenorCartaNaMao(){
		int menorValor = Baralho.valorDasCartas.indexOf(Carta.Valor[jogador.getMao().get(0).getValor()]);
		int posicao = 0;
		for(int x = 0; x < jogador.getMao().size();x++){
			if(Carta.Valor[jogador.getMao().get(x).getValor()].equals(m.getManilha())){
				if(Carta.Valor[jogador.getMao().get(posicao).getValor()].equals(m.getManilha())){
					if(jogador.getMao().get(x).getNaipe().ordinal() > jogador.getMao().get(posicao).getNaipe().ordinal())
						posicao = x;
				}else{
					
					posicao = x;
				}
				menorValor = -1;
			}
			else if(menorValor == -1)continue;
			else if(Baralho.valorDasCartas.indexOf(Carta.Valor[jogador.getMao().get(x).getValor()]) < menorValor){
				menorValor = Baralho.valorDasCartas.indexOf(Carta.Valor[jogador.getMao().get(x).getValor()]);
				posicao = x;
			}
		}
		return posicao;
	} 

}
