package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * GeneInterprDefinition generated by hbm2java
 */
public class GeneInterprDefinition implements java.io.Serializable {

	private BigDecimal geneInterprDefinitionId;
	private String geneInterpretation;
	private Set<GeneResult> geneResults = new HashSet<GeneResult>(0);
	private Set<PhenotypeAutocallRule> phenotypeAutocallRules = new HashSet<PhenotypeAutocallRule>(
			0);
	private Set<GeneInterpretation> geneInterpretations = new HashSet<GeneInterpretation>(
			0);

	public GeneInterprDefinition() {
	}

	public GeneInterprDefinition(BigDecimal geneInterprDefinitionId) {
		this.geneInterprDefinitionId = geneInterprDefinitionId;
	}

	public GeneInterprDefinition(BigDecimal geneInterprDefinitionId,
			String geneInterpretation, Set<GeneResult> geneResults,
			Set<PhenotypeAutocallRule> phenotypeAutocallRules,
			Set<GeneInterpretation> geneInterpretations) {
		this.geneInterprDefinitionId = geneInterprDefinitionId;
		this.geneInterpretation = geneInterpretation;
		this.geneResults = geneResults;
		this.phenotypeAutocallRules = phenotypeAutocallRules;
		this.geneInterpretations = geneInterpretations;
	}

	public BigDecimal getGeneInterprDefinitionId() {
		return this.geneInterprDefinitionId;
	}

	public void setGeneInterprDefinitionId(BigDecimal geneInterprDefinitionId) {
		this.geneInterprDefinitionId = geneInterprDefinitionId;
	}

	public String getGeneInterpretation() {
		return this.geneInterpretation;
	}

	public void setGeneInterpretation(String geneInterpretation) {
		this.geneInterpretation = geneInterpretation;
	}

	public Set<GeneResult> getGeneResults() {
		return this.geneResults;
	}

	public void setGeneResults(Set<GeneResult> geneResults) {
		this.geneResults = geneResults;
	}

	public Set<PhenotypeAutocallRule> getPhenotypeAutocallRules() {
		return this.phenotypeAutocallRules;
	}

	public void setPhenotypeAutocallRules(
			Set<PhenotypeAutocallRule> phenotypeAutocallRules) {
		this.phenotypeAutocallRules = phenotypeAutocallRules;
	}

	public Set<GeneInterpretation> getGeneInterpretations() {
		return this.geneInterpretations;
	}

	public void setGeneInterpretations(
			Set<GeneInterpretation> geneInterpretations) {
		this.geneInterpretations = geneInterpretations;
	}

}
