package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:41 PM by Hibernate Tools 3.4.0.CR1

/**
 * SampleInstrumentAssoc generated by hbm2java
 */
public class SampleInstrumentAssoc implements java.io.Serializable {

	private SampleInstrumentAssocId id;
	private StepTemplate stepTemplate;
	private Checklist checklist;
	private Container container;
	private Instrument instrument;

	public SampleInstrumentAssoc() {
	}

	public SampleInstrumentAssoc(SampleInstrumentAssocId id) {
		this.id = id;
	}

	public SampleInstrumentAssoc(SampleInstrumentAssocId id,
			StepTemplate stepTemplate, Checklist checklist,
			Container container, Instrument instrument) {
		this.id = id;
		this.stepTemplate = stepTemplate;
		this.checklist = checklist;
		this.container = container;
		this.instrument = instrument;
	}

	public SampleInstrumentAssocId getId() {
		return this.id;
	}

	public void setId(SampleInstrumentAssocId id) {
		this.id = id;
	}

	public StepTemplate getStepTemplate() {
		return this.stepTemplate;
	}

	public void setStepTemplate(StepTemplate stepTemplate) {
		this.stepTemplate = stepTemplate;
	}

	public Checklist getChecklist() {
		return this.checklist;
	}

	public void setChecklist(Checklist checklist) {
		this.checklist = checklist;
	}

	public Container getContainer() {
		return this.container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	public Instrument getInstrument() {
		return this.instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

}
