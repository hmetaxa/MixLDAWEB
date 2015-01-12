/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hmetaxa
 */
@Entity
@Table(name = "FP7FinalReports")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FP7FinalReports.findAll", query = "SELECT f FROM FP7FinalReports f"),
    @NamedQuery(name = "FP7FinalReports.findByProjectId", query = "SELECT f FROM FP7FinalReports f WHERE f.projectId = :projectId"),
    @NamedQuery(name = "FP7FinalReports.findByExecutiveSummary", query = "SELECT f FROM FP7FinalReports f WHERE f.executiveSummary = :executiveSummary"),
    @NamedQuery(name = "FP7FinalReports.findByContextobjectives", query = "SELECT f FROM FP7FinalReports f WHERE f.contextobjectives = :contextobjectives"),
    @NamedQuery(name = "FP7FinalReports.findByResults", query = "SELECT f FROM FP7FinalReports f WHERE f.results = :results"),
    @NamedQuery(name = "FP7FinalReports.findByPotentialImpact", query = "SELECT f FROM FP7FinalReports f WHERE f.potentialImpact = :potentialImpact"),
    @NamedQuery(name = "FP7FinalReports.findByComment", query = "SELECT f FROM FP7FinalReports f WHERE f.comment = :comment")})
public class FP7FinalReports implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 2000000000)
    @Column(name = "ProjectId")
    private String projectId;
    @Size(max = 2000000000)
    @Column(name = "ExecutiveSummary")
    private String executiveSummary;
    @Size(max = 2000000000)
    @Column(name = "Contextobjectives")
    private String contextobjectives;
    @Size(max = 2000000000)
    @Column(name = "Results")
    private String results;
    @Size(max = 2000000000)
    @Column(name = "PotentialImpact")
    private String potentialImpact;
    @Size(max = 2000000000)
    @Column(name = "Comment")
    private String comment;

    public FP7FinalReports() {
    }

    public FP7FinalReports(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getExecutiveSummary() {
        return executiveSummary;
    }

    public void setExecutiveSummary(String executiveSummary) {
        this.executiveSummary = executiveSummary;
    }

    public String getContextobjectives() {
        return contextobjectives;
    }

    public void setContextobjectives(String contextobjectives) {
        this.contextobjectives = contextobjectives;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getPotentialImpact() {
        return potentialImpact;
    }

    public void setPotentialImpact(String potentialImpact) {
        this.potentialImpact = potentialImpact;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectId != null ? projectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FP7FinalReports)) {
            return false;
        }
        FP7FinalReports other = (FP7FinalReports) object;
        if ((this.projectId == null && other.projectId != null) || (this.projectId != null && !this.projectId.equals(other.projectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.FP7FinalReports[ projectId=" + projectId + " ]";
    }
    
}
