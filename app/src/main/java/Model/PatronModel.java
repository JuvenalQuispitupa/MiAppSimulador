package Model;

/**
 * Created by root on 01/10/17.
 */

public class PatronModel {

    private Integer id;
    private String tipo;
    private Integer secuencia;
    private Integer valor;

    public static final String TABLE_NAME="patron";
    public static final String ID_FIELD="id";
    public static final String TIPO_FIELD="tipo";
    public static final String SECUENCIA_FIELD="secuencia";
    public static final String VALOR_FIELD="valor";

    public PatronModel(Integer id, String tipo, Integer secuencia, Integer valor) {
        this.id = id;
        this.tipo = tipo;
        this.secuencia = secuencia;
        this.valor = valor;
    }
    public PatronModel() {

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "PatronModel{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", secuencia=" + secuencia +
                ", valor=" + valor +
                '}';
    }
}
