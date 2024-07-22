package tarea1_clases;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.JOptionPane;
/**
 *
 * @author Josue
 */
public class Transito{
    private Multa[] multas;
    private int contador;

    public Transito(){
        this.multas=new Multa[100];
        this.contador=0;
    }

    public Multa buscarMulta(int codigo){
        for(int index=0;index< contador;index++) {
            if(multas[index].getCodigo()==codigo) {
                return multas[index];
            }
        }
        return null;
    }

    public void agregarMulta(int codigo, String nombre, String tipo){
        if(contador>=multas.length){
            JOptionPane.showMessageDialog(null, "No hay espacio en el arreglo para mas multas.");
            return;
        }
        if(buscarMulta(codigo)!=null){
            JOptionPane.showMessageDialog(null, "El codigo de la multa ya existe.");
            return;
        }
        multas[contador++]=new Multa(codigo, nombre, tipo);
        JOptionPane.showMessageDialog(null, "Multa agregada exitosamente.");
    }

    public void pagarMulta(int codigo){
        Multa multa=buscarMulta(codigo);
        if (multa!=null){
            multa.pay();
        }else{
            JOptionPane.showMessageDialog(null, "No existe una multa con el codigo "+codigo);
        }
    }

    public void imprimirMultas() {
        for(int index=0;index<contador;index++){
            multas[index].print();
        }
    }

    public void imprimirEstadisticas() {
        int multasPagadas=0;
        int multasPendientes=0;
        double montoPagado=0;
        double montoPendiente=0;

        for (int index= 0;index<contador;index++){
            if(multas[index].isPagada()){
                multasPagadas++;
                montoPagado+=multas[index].getMonto();
            }else{
                multasPendientes++;
                montoPendiente+=multas[index].getMonto();
            }
        }
        JOptionPane.showMessageDialog(null, "Cantidad de Multas generadas: "+contador+"\nCantidad de Multas Pagadas: "+multasPagadas+" con su monto en Lps: "+montoPagado+"\nCantidad de Multas pendientes: "+multasPendientes+" con su monto en Lps: "+montoPendiente);
    }
}
