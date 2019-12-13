/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.entidad;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.entidad.DetalleServicio;

/**
 *
 * @author PC14
 */
@Stateless
public class DetalleServicioFacade extends AbstractFacade<DetalleServicio> {

    @PersistenceContext(unitName = "BDVENGADOR")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleServicioFacade() {
        super(DetalleServicio.class);
    }
    
}
