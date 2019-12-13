/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.entidad;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.entidad.Profesional;

/**
 *
 * @author PC14
 */
@Stateless
public class ProfesionalFacade extends AbstractFacade<Profesional> {

    @PersistenceContext(unitName = "BDVENGADOR")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProfesionalFacade() {
        super(Profesional.class);
    }
    
}
