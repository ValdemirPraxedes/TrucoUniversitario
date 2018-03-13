package jun.truco.model;


/**
 * 
 *
 * 
 */
public class Baralho {
	/**
	 * 	
	 */
	private Carta[] baralho = new Carta[40];
	public static final String valorDasCartas = "4567QJKA23";
	private int quantidade_de_cartas;
	
	public Baralho(){
		
		init_baralho();
		
		quantidade_de_cartas = baralho.length;
	}
	
	private void init_baralho(){
		for(Carta.Naipe n : Carta.Naipe.values()){
			for(int v = 1; v <= Carta.Valor.length;v++){
				int pos = v + n.ordinal() * Carta.Valor.length-1;
				baralho[pos] = new Carta((v-1),n);
			}
		}
	}
	
	public String toString(){
		StringBuilder strb = new StringBuilder("[");
		
		for(int x = 0; x < quantidade_de_cartas; x++ ){
			strb.append(baralho[x]);
			strb.append(", ");
		}
		strb.append("]");
		return strb.toString();
	}
	
	
	public void embaralhar() {
		for (int n = 0; n < quantidade_de_cartas; n++) {
			Carta aux = baralho[n];
			int p = (int) (Math.random() * quantidade_de_cartas);
			baralho[n] = baralho[p];
			baralho[p] = aux;
			}
		}
	
	public Carta DarCarta(){
		if(quantidade_de_cartas > 0){
			Carta c = baralho[quantidade_de_cartas-1];
			quantidade_de_cartas--;
			return c;
		}
		throw new ArrayIndexOutOfBoundsException();
	}
}
