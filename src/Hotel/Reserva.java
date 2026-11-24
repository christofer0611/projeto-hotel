package Hotel;


public class Reserva {

    private String nomeHospede;
    private String tipoQuarto;
    private int numeroDias;
    private double valorDiaria;

    public Reserva(String nomeHospede, String tipoQuarto,
                   int numeroDias, double valorDiaria) {

        this.setNomeHospede(nomeHospede);
        this.setTipoQuarto(tipoQuarto);
        this.setNumeroDias(numeroDias);
        this.setValorDiaria(valorDiaria);
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public void setNomeHospede(String nomeHospede) {
        if (nomeHospede == null || nomeHospede.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido!");
        }
        this.nomeHospede = nomeHospede;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        if (tipoQuarto == null || tipoQuarto.trim().isEmpty()) {
            throw new IllegalArgumentException("Tipo de quarto inválido!");
        }
        this.tipoQuarto = tipoQuarto;
    }

    public int getNumeroDias() {
        return numeroDias;
    }

    public void setNumeroDias(int numeroDias) {
        if (numeroDias < 1) {
            throw new IllegalArgumentException(
                    "O número de dias deve ser no mínimo 1!"
            );
        }
        this.numeroDias = numeroDias;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        if (valorDiaria <= 0) {
            throw new IllegalArgumentException(
                    "O valor da diária deve ser maior que zero!"
            );
        }
        this.valorDiaria = valorDiaria;
    }

    public double calcularValorTotal() {
        return this.numeroDias * this.valorDiaria;
    }

    @Override
    public String toString() {
        return "Nome do hóspede: " + this.nomeHospede +
                "\nTipo do quarto: " + this.tipoQuarto +
                "\nDias de estadia: " + this.numeroDias +
                "\nValor da diária: R$ " + this.valorDiaria +
                "\nValor total: R$ " + this.calcularValorTotal();
    }
}