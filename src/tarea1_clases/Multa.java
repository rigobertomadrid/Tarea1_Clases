/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1_clases;
import javax.swing.JOptionPane;

/**
 *
 * @author Josue
 */
public class Multa{
    private int codigo;
    private String nombreInfractor;
    private String tipo;
    private double monto;
    private boolean pagada;

    public static final double TIPO_GRAVE=1000.0;
    public static final double TIPO_MEDIO=500.0;
    public static final double TIPO_LEVE=100.0;

    public Multa(int codigo, String nombreInfractor, String tipo){
        this.codigo=codigo;
        this.nombreInfractor=nombreInfractor;
        setTipo(tipo);
        this.pagada=false;
    }
    public int getCodigo(){
        return codigo;
    }
    public double getMonto(){
        return monto;
    }
    public boolean isPagada(){
        return pagada;
    }
    private void setTipo(String tipo){
        if(tipo.equalsIgnoreCase("GRAVE")){
            this.tipo="GRAVE";
            this.monto=TIPO_GRAVE;
        }else if(tipo.equalsIgnoreCase("MEDIO")){
            this.tipo="MEDIO";
            this.monto=TIPO_MEDIO;
        }else{
            this.tipo="LEVE";
            this.monto=TIPO_LEVE;
        }
    }
    public void print(){
        String estado=pagada ? "Pagada por un monto de Lps "+monto: "Multa pendiente";
        JOptionPane.showMessageDialog(null, "Código: "+codigo+", Infractor: "+nombreInfractor+", Tipo: "+tipo+", Monto: "+monto+", Estado: "+estado);
    }

    public void pay(){
        this.pagada = true;
        JOptionPane.showMessageDialog(null, "Multa con Código " +codigo+ " fue pagada por un monto de Lps. "+monto);
    }
}