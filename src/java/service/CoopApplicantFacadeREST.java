/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.CoopApplicant;

/**
 *
 * @author mis
 */
@Stateless
@Path("model.coopapplicant")
public class CoopApplicantFacadeREST extends AbstractFacade<CoopApplicant> {
	@PersistenceContext(unitName = "zoom08PU")
	private EntityManager em;

	public CoopApplicantFacadeREST() {
		super(CoopApplicant.class);
	}

	@POST
    @Override
    @Consumes({"application/xml", "application/json"})
	public void create(CoopApplicant entity) {
		super.create(entity);
	}

	@PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
	public void edit(@PathParam("id") Integer id, CoopApplicant entity) {
		super.edit(entity);
	}

	@DELETE
    @Path("{id}")
	public void remove(@PathParam("id") Integer id) {
		super.remove(super.find(id));
	}

	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
	public CoopApplicant find(@PathParam("id") Integer id) {
		return super.find(id);
	}

	@GET
    @Override
    @Produces({"application/xml", "application/json"})
	public List<CoopApplicant> findAll() {
		return super.findAll();
	}

	@GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
	public List<CoopApplicant> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
		return super.findRange(new int[]{from, to});
	}

	@GET
    @Path("count")
    @Produces("text/plain")
	public String countREST() {
		return String.valueOf(super.count());
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
}
