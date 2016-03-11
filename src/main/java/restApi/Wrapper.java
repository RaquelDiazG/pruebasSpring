package restApi;

public class Wrapper {

    private int numerador;

    private int denominador;

    public Wrapper() {
    }

    public Wrapper(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

	public int getNumerador() {
		return numerador;
	}

	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public int getDenominador() {
		return denominador;
	}

	public void setDenominador(int denominador) {
		this.denominador = denominador;
	}

	@Override
	public String toString() {
		return "Wrapper [numerador=" + numerador + ", denominador=" + denominador + "]";
	}

   

}
