/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.service;

import Entities.Entitysimilarityview;
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

/**
 *
 * @author hmetaxa
 */
@Stateless
@Path("entities.entitysimilarityview")
public class EntitysimilarityviewFacadeREST extends AbstractFacade<Entitysimilarityview> {
    @PersistenceContext(unitName = "TestRestPU")
    private EntityManager em;

    public EntitysimilarityviewFacadeREST() {
        super(Entitysimilarityview.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Entitysimilarityview entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") String id, Entitysimilarityview entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Entitysimilarityview find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Entitysimilarityview> findAll() {
        return super.findAll();
    }

//    @GET
//    @Path("{from}/{to}")
//    @Produces({"application/xml", "application/json"})
//    public List<Entitysimilarityview> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//        return super.findRange(new int[]{from, to});
//    }

     @GET
    @Path("{similarity}/{experimentId}")
    @Produces({"application/xml", "application/json"})
    public List<Entitysimilarityview> findSimilar(@PathParam("similarity") double similarity, @PathParam("experimentId") String experimentId) {
//        
        List<Entitysimilarityview> grantPairs = (List<Entitysimilarityview>) em.
                 createNamedQuery("Entitysimilarityview.findSimilar")
                                      .setParameter("similarity", similarity)
                                      .setParameter("experimentId", experimentId)
                                      .getResultList();
        
//        List<GrantsSimilarity> grantPairs = (List<GrantsSimilarity>) em.createQuery(
//                "SELECT g.GrantId1,g.GrantId2,g.Similarity,g.ExperimentId,grCnts1.grantsCnt as P1,grCnts2.grantsCnt as P2,gr1.acronym as Acr1,gr2.acronym as Acr2,gr1.funding_lvl2 as F1,gr2.funding_lvl2 as F2 FROM GrantsSimilarity g "+
//		     "INNER JOIN Grant gr1 ON gr1.GrantId =  g.grantId1 "+
//		     "INNER JOIN "+
//		     "(select GrantId, count(*) as grantsCnt from GrantPerDoc "+
//                     "where "+
//                     "grantPerDoc.grantId like 'ec%' "+
//                     "group by  grantId "+
//		     "having  count(*) >4 "+
//                     ") grCnts1 on grCnts1.grantId = g.grantId1 "+
//		     "INNER JOIN Grant gr2 ON gr2.GrantId =  g.grantId2 "+
//		     "INNER JOIN "+
//		     "(select GrantId, count(*) as grantsCnt from GrantPerDoc "+
//                     "where "+
//                     "grantPerDoc.grantId like 'ec%' "+
//                     "group by  grantId "+
//		     "having  count(*) >4 "+
//                     ") grCnts2 on grCnts2.grantId = g.grantId2 "+
// "WHERE g.similarity > :similarity AND g.experimentId = :experimentId")
//                                      .setParameter("similarity", similarity)
//                                      .setParameter("experimentId", experimentId)
//                                      .getResultList();
        
          return grantPairs; 
          /*(List<GrantsSimilarity>) em.createNamedQuery("GrantsSimilarity.findSimilar")
                                      .setParameter("similarity", similarity)
                                      .setParameter("experimentId", experimentId)
                                      .getResultList();*/
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
