package patch_1; 

public class Rule {
 
	private String name;
	private double valor;
	/**
	 * Construtor de uma rule 
	 * @param name
	 * @param valor
	 */
	public Rule(String name, double valor){
		this.name = name;
		this.valor = valor;
	}
	/**
	 * Especificar o nome da rule
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * função para especificar o valor da regra
	 * @param valor
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}
	/**
	 * funçãp para receber o nome da rule
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * Função para receber o valor da regra
	 * @return
	 */
	public double getValor() {
		return valor;
	}

	//para depois utilizar-mos para guardar as regras actuais
	@Override
	public String toString() {
		return name + " " + valor;
	}

	public String toDisplay() {
		return  name + ", valor: " + valor;
	}
}
