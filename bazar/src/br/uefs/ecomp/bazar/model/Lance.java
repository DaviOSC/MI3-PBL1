package br.uefs.ecomp.bazar.model;

public class Lance
{
    private double valor;
    private Usuario participante;
    
    public Lance(Usuario lParticipante, double lValor)
    {
        this.valor = lValor;
        this.participante = lParticipante;
    }
    
    public double getValor()
    {
        return valor;
    }
    
    public Usuario getParticipante()
    {
        return participante;
    }
            
}
