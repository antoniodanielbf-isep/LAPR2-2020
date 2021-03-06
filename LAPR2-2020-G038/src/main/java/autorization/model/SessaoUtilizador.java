/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autorization.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author paulomaio
 */
public class SessaoUtilizador implements Serializable
{
    private Utilizador m_oUtilizador = null;
    
    private SessaoUtilizador()
    {
    }
    
    public SessaoUtilizador(Utilizador oUtilizador)
    {
        if (oUtilizador == null)
            throw new IllegalArgumentException("Argumento não pode ser nulo.");
        this.m_oUtilizador = oUtilizador;
    }
    
    public void doLogout()
    {
        this.m_oUtilizador = null;
    }
    
    public boolean isLoggedIn()
    {
        return this.m_oUtilizador != null;
    }
    
    public boolean isLoggedInComPapel(String strPapel)
    {
      
        if (isLoggedIn())
        {
           
            return this.m_oUtilizador.hasPapel(strPapel);
        }
        return false;
    }
    
    public String getNomeUtilizador()
        {    
        if (isLoggedIn()){
            return this.m_oUtilizador.getNome();
        }
      return "No name";
    }
    
    public String getIdUtilizador()
    {
        if (isLoggedIn()){
            this.m_oUtilizador.getId();
        }
       return "No id" ;
    }
    
    public String getEmailUtilizador()
    {
        if (isLoggedIn()){
            return this.m_oUtilizador.getEmail();
        }
        return null;
    }
    
    public List<PapelUtilizador> getPapeisUtilizador()
    {
        return this.m_oUtilizador.getPapeis();
    }
}
