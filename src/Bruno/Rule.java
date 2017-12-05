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
	
}
