package jun.truco.model;

public class ForcaDasCartas {
	
	

	private Carta[] mesa;
	private String valoresEmpachado = "";
	private Jogador[] MapeamentoJogadores;
	private int manilha;
	
	private Jogador JogadorComMaiorCartaNaMesa;
	private Carta MaiorCarta;
	
	public ForcaDasCartas(Carta[] mesa,int manilha) {
		this.mesa = mesa;
		this.manilha = manilha;
		MapeamentoJogadores = new Jogador[mesa.length];
	}
	public void setMesa(Carta[] mesa){
		this.mesa = mesa;
	}
	public Jogador getJogadorFez(){
		return JogadorComMaiorCartaNaMesa;
	}
	public Carta getMaiorCarta(){
		return MaiorCarta;
	}
	private boolean DeterminarMaiorCarta(){
		;
		for(int x = 0; x < mesa.length && mesa[x] != null;x++){
			Boolean repetido = false;
			for(char valor : valoresEmpachado.toCharArray())
			{
			if(Carta.Valor[mesa[x].getValor()].equals(valor+"")){
				repetido = true;
				break;
				}
			}
			if(repetido)continue;
			JogadorComMaiorCartaNaMesa = MapeamentoJogadores[x];
			MaiorCarta = mesa[x];
			return true;
		}
		return false;
	}
	
	private void percorrerMesa(int posicao, Jogador j, Carta c){
		Carta aux = mesa[posicao];
		Jogador jAux = j;
		for(int x = posicao; x  < mesa.length-1 && mesa[x] != null;x++){
			Carta aux2 = mesa[x+1];
			mesa[x+1] = aux;
			aux = aux2; 
			
			Jogador jAux2 = MapeamentoJogadores[x+1];
			MapeamentoJogadores[x+1] = jAux;
			jAux = jAux2;
		}
		mesa[posicao] = c;
		MapeamentoJogadores[posicao] = j;
	}
	private boolean seForManilha(Carta c){
		if(c.getValor() == manilha)return true;
		else return false;
	}
	public void clear(){
		MapeamentoJogadores = new Jogador[mesa.length];
		valoresEmpachado = "";
	}
	private void TratamentoManilha(Jogador j,Carta c){
		
			int quantidadeManilhas = 0;
			for(int x = 0; x < mesa.length && mesa[x] != null;x++){
				if(mesa[x].getValor() == c.getValor())
					{
					   if(c.getNaipe().ordinal() < mesa[x].getNaipe().ordinal()){
							percorrerMesa(x, j, c);	
							return;
						}
						else quantidadeManilhas++;	
					}
			}
			percorrerMesa(quantidadeManilhas, j, c);
			
		
	}
	private boolean compareCartas(int x, Jogador j,Carta c){
		if(Baralho.valorDasCartas.indexOf(Carta.Valor[c.getValor()]) > Baralho.valorDasCartas.indexOf(Carta.Valor[mesa[x].getValor()])){
			percorrerMesa(x, j, c);
			return true;
		}
		else if(Baralho.valorDasCartas.indexOf(Carta.Valor[c.getValor()]) == Baralho.valorDasCartas.indexOf(Carta.Valor[mesa[x].getValor()])){
			percorrerMesa(x, j, c);
			valoresEmpachado += Carta.Valor[c.getValor()];
			return true;
			
		}
		else if(x == mesa.length-1){
			mesa[x] = c;
			MapeamentoJogadores[x] = j;
			return true;
			
		}
		else {
			if(mesa[x+1] == null){
				mesa[x+1] = c;
				MapeamentoJogadores[x+1] = j;
				return true;
			}
		}
		return false;
	}
	
	public void CartaJogada(Jogador j,Carta c){
		
		if(mesa[0] == null){
		   mesa[0] = c;
		   MapeamentoJogadores[0] = j;
		}
		else{
			if(seForManilha(c))TratamentoManilha(j, c);
			
			else for(int x = 0; x < mesa.length && mesa[x] != null;x++)
					if(mesa[x].getValor() != manilha)
						if(compareCartas(x, j, c))break;
			
		}
		DeterminarMaiorCarta();
	}
	
}
