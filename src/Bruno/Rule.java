package Bruno; 

public class Rule {
 
	private String name;
	private double valor;
	
	public Rule(String name, double valor){
		this.name = name;
		this.valor = valor;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getName() {
		return name;
	}

	public double getValor() {
		return valor;
	}

	//para depois utilizar-mos para guardar as regras actuais
	@Override
	public String toString() {
		return name + " " + valor;
	}

	public String toDysplay() {
		return  name + ", valor: " + valor;
	}
}
