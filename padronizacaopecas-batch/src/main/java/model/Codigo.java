package model;

public class Codigo {
	private String codigo_original;
	private String codigo_antigo;
	private int modelo;
	public String getCodigo_original() {
		return codigo_original;
	}
	public void setCodigo_original(String codigo_original) {
		this.codigo_original = codigo_original;
	}
	public String getCodigo_antigo() {
		return codigo_antigo;
	}
	public void setCodigo_antigo(String codigo_antigo) {
		this.codigo_antigo = codigo_antigo;
	}
	public int getModelo() {
		return modelo;
	}
	public void setModelo(int modelo) {
		this.modelo = modelo;
	}
}
