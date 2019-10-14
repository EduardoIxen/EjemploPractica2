/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Estructuras;

/**
 *
 * @author Denis
 */
public class ObjetoNivel {
    private Object nivel;
    private Object distancia_maxima;
    private Object distancia_pantalla; 
    private Object velocidad_corriente; 
    private Object tiempo_nivel;
    private Object tiempo_sumergir;
    private Object puntos_seleccion; 
    private Object puntos_sel_sumergir;

    public ObjetoNivel() {
    }

    public ObjetoNivel(Object nivel, Object distancia_maxima, Object distancia_pantalla, Object velocidad_corriente, Object tiempo_nivel, Object tiempo_sumergir, Object puntos_seleccion, Object puntos_sel_sumergir) {
        this.nivel = nivel;
        this.distancia_maxima = distancia_maxima;
        this.distancia_pantalla = distancia_pantalla;
        this.velocidad_corriente = velocidad_corriente;
        this.tiempo_nivel = tiempo_nivel;
        this.tiempo_sumergir = tiempo_sumergir;
        this.puntos_seleccion = puntos_seleccion;
        this.puntos_sel_sumergir = puntos_sel_sumergir;
    }

    public Object getNivel() {
        return nivel;
    }

    public void setNivel(Object nivel) {
        this.nivel = nivel;
    }

    public Object getDistancia_maxima() {
        return distancia_maxima;
    }

    public void setDistancia_maxima(Object distancia_maxima) {
        this.distancia_maxima = distancia_maxima;
    }

    public Object getDistancia_pantalla() {
        return distancia_pantalla;
    }

    public void setDistancia_pantalla(Object distancia_pantalla) {
        this.distancia_pantalla = distancia_pantalla;
    }

    public Object getVelocidad_corriente() {
        return velocidad_corriente;
    }

    public void setVelocidad_corriente(Object velocidad_corriente) {
        this.velocidad_corriente = velocidad_corriente;
    }

    public Object getTiempo_nivel() {
        return tiempo_nivel;
    }

    public void setTiempo_nivel(Object tiempo_nivel) {
        this.tiempo_nivel = tiempo_nivel;
    }

    public Object getTiempo_sumergir() {
        return tiempo_sumergir;
    }

    public void setTiempo_sumergir(Object tiempo_sumergir) {
        this.tiempo_sumergir = tiempo_sumergir;
    }

    public Object getPuntos_seleccion() {
        return puntos_seleccion;
    }

    public void setPuntos_seleccion(Object puntos_seleccion) {
        this.puntos_seleccion = puntos_seleccion;
    }

    public Object getPuntos_sel_sumergir() {
        return puntos_sel_sumergir;
    }

    public void setPuntos_sel_sumergir(Object puntos_sel_sumergir) {
        this.puntos_sel_sumergir = puntos_sel_sumergir;
    }

    @Override
    public String toString() {
        return "ObjetoNivel{" + "nivel=" + nivel + ", distancia_maxima=" + distancia_maxima + ", distancia_pantalla=" + distancia_pantalla + ", velocidad_corriente=" + velocidad_corriente + ", tiempo_nivel=" + tiempo_nivel + ", tiempo_sumergir=" + tiempo_sumergir + ", puntos_seleccion=" + puntos_seleccion + ", puntos_sel_sumergir=" + puntos_sel_sumergir + '}';
    }

    
}
