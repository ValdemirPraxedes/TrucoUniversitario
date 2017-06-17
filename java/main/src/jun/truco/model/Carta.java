package jun.truco.model;


public class Carta {

	public static enum Naipe {Paus, Copas, Espadas, Ouros};
	public static String Valor[] = {"A","2","3","4","5","6","7","Q","J","K"};
	private int valor;

	private Naipe naipe;
	
	
	public Carta(int valor, Naipe naipe){
		setValor(valor);
		setNaipe(naipe);
	}
	/**
	 * @return the valor
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(int valor) {
		if(valor < 0 || valor > 10){
			throw new ArrayIndexOutOfBoundsException();
		}
		this.valor = valor;
	}

	/**
	 * @return the naipe
	 */
	public Naipe getNaipe() {
		return naipe;
	}

	/**
	 * @param naipe the naipe to set
	 */
	protected void setNaipe(Naipe naipe) {
		this.naipe = naipe;
	}
	
	public String toString(){
		return Valor[valor-1] + " de " + naipe;
	}
	

}
