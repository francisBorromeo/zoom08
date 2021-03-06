/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.CoopActivity;
import model.CoopActivityType;
import model.CoopApplicant;
import model.CoopMemAct;
import model.CoopMember;
import model.CoopOrgPlan;
import model.CoopOrgUnit;
import model.CoopOuAct;
import model.CoopProsAct;
import model.CoopProsCriteria;
import model.CoopProsCriteriaMain;
import model.CoopProsCriteriaSub;
import model.CoopProsLog;
import model.CoopProsRatingMain;
import model.CoopProsRatingSub;
import model.CoopProsReport;
import model.CoopProsRepver;
import model.CoopProspect;
import model.CoopRepAct;
import model.CoopReport;
import model.CoopReportCirc;
import model.CoopReportType;
import org.primefaces.context.RequestContext;
import org.primefaces.event.DateSelectEvent;
import org.primefaces.event.SelectEvent;
import service.CoopActivityFacadeREST;
import service.CoopActivityTypeFacadeREST;
import service.CoopApplicantFacadeREST;
import service.CoopMemActFacadeREST;
import service.CoopMemberFacadeREST;
import service.CoopOrgPlanFacadeREST;
import service.CoopOrgUnitFacadeREST;
import service.CoopOuActFacadeREST;
import service.CoopProsActFacadeREST;
import service.CoopProsCriteriaFacadeREST;
import service.CoopProsCriteriaMainFacadeREST;
import service.CoopProsCriteriaSubFacadeREST;
import service.CoopProsLogFacadeREST;
import service.CoopProsRatingMainFacadeREST;
import service.CoopProsRatingSubFacadeREST;
import service.CoopProsReportFacadeREST;
import service.CoopProsRepverFacadeREST;
import service.CoopProspectFacadeREST;
import service.CoopRepActFacadeREST;
import service.CoopReportCircFacadeREST;
import service.CoopReportFacadeREST;
import service.CoopReportTypeFacadeREST;

/**
 *
 * @author roland
 */
@ManagedBean(name = "effortBean")
@SessionScoped
public class EffortBean implements Serializable {

	@EJB
	private CoopActivityFacadeREST coopActivityFacadeREST;
	private CoopActivity activity;
	@EJB
	private CoopActivityTypeFacadeREST coopActivityTypeFacadeREST;
	private CoopActivityType activityType;
	@EJB
	private CoopApplicantFacadeREST coopApplicantFacadeREST;
	private CoopApplicant applicant;
	@EJB
	private CoopMemActFacadeREST coopMemActFacadeREST;
	private CoopMemAct memAct;
	@EJB
	private CoopMemberFacadeREST coopMemberFacadeREST;
	private CoopMember member;
	@EJB
	private CoopOrgPlanFacadeREST coopOrgPlanFacadeREST;
	private CoopOrgPlan orgPlan;
	@EJB
	private CoopOrgUnitFacadeREST coopOrgUnitFacadeREST;
	private CoopOrgUnit orgUnit;
	@EJB
	private CoopOuActFacadeREST coopOuActFacadeREST;
	private CoopOuAct ouAct;
	@EJB
	private CoopProsActFacadeREST coopProsActFacadeREST;
	private CoopProsAct prosAct;
	@EJB
	private CoopProsCriteriaFacadeREST coopProsCriteriaFacadeREST;
	private CoopProsCriteria prosCriteria;
	@EJB
	private CoopProsCriteriaMainFacadeREST coopProsCriteriaMainFacadeREST;
	private CoopProsCriteriaMain prosCriteriaMain;
	@EJB
	private CoopProsCriteriaSubFacadeREST coopProsCriteriaSubFacadeREST;
	private CoopProsCriteriaSub prosCriteriaSub;
	@EJB
	private CoopProsLogFacadeREST coopProsLogFacadeREST;
	private CoopProsLog prosLog;
	@EJB
	private CoopProspectFacadeREST coopProspectFacadeREST;
	private CoopProspect prospect;
	private List<CoopProspect> prospectList;
	private CoopProspect selectedProspect;
	private DataModel<CoopProspect> prospectModel;
	@EJB
	private CoopProsRatingMainFacadeREST coopProsRatingMainFacadeREST;
	private CoopProsRatingMain prosRatingMain;
	@EJB
	private CoopProsRatingSubFacadeREST coopProsRatingSubFacadeREST;
	private CoopProsRatingSub prosRatingSub;
	@EJB
	private CoopProsReportFacadeREST coopProsReportFacadeREST;
	private CoopProsReport prosReport;
	private List<CoopProsReport> prosReportList;
	private CoopProsReport selectedProsReport;
	private DataModel<CoopProsReport> prosReportModel;
	@EJB
	private CoopRepActFacadeREST coopRepActFacadeREST;
	private CoopRepAct repAct;
	@EJB
	private CoopReportFacadeREST coopReportFacadeREST;
	private CoopReport report;
	@EJB
	private CoopReportCircFacadeREST coopReportCircFacadeREST;
	private CoopReportCirc reportCirc;
	@EJB
	private CoopReportTypeFacadeREST coopReportTypeFacadeREST;
	private CoopReportType reportType;
	@EJB
	private CoopProsRepverFacadeREST coopProsRepverFacadeREST;
	private CoopProsRepver prosRepver;
	private Date dateFrom;
	private Date dateTo;
	private boolean willing;
	private boolean understanding;
	private boolean motivated;
	private boolean social;
	private boolean norating = true;
	private Integer willingnessRating;
	private Integer understandingRatingSub1;
	private Integer understandingRatingSub2;
	private Integer understandingRatingSub3;
	private Integer motivatedRating;
	private Integer socialRating;

	public void init() {
		activity = new CoopActivity();
		activityType = new CoopActivityType();
		applicant = new CoopApplicant();
		memAct = new CoopMemAct();
		member = new CoopMember();
		orgPlan = new CoopOrgPlan();
		orgUnit = new CoopOrgUnit();
		ouAct = new CoopOuAct();
		prosAct = new CoopProsAct();
		prosCriteria = new CoopProsCriteria();
		prosCriteriaMain = new CoopProsCriteriaMain();
		prosCriteriaSub = new CoopProsCriteriaSub();
		prosLog = new CoopProsLog();
		prospect = new CoopProspect();
		prospectList = coopProspectFacadeREST.findAll();
		prospectModel = new ListDataModel<CoopProspect>(prospectList);
		prosRatingMain = new CoopProsRatingMain();
		prosRatingSub = new CoopProsRatingSub();
		prosReport = new CoopProsReport();
		prosRepver = new CoopProsRepver();
		repAct = new CoopRepAct();
		report = new CoopReport();
		reportCirc = new CoopReportCirc();
		reportType = new CoopReportType();
	}

	public CoopActivityType getActivityType() {
		return activityType;
	}

	public CoopApplicant getApplicant() {
		return applicant;
	}

	public CoopMember getMember() {
		return member;
	}

	public CoopOrgPlan getOrgPlan() {
		return orgPlan;
	}

	public CoopOrgUnit getOrgUnit() {
		return orgUnit;
	}

	public CoopReportType getReportType() {
		return reportType;
	}

	public CoopMemAct getMemAct() {
		return memAct;
	}

	public void setMemAct(CoopMemAct memAct) {
		this.memAct = memAct;
	}

	public CoopOuAct getOuAct() {
		return ouAct;
	}

	public void setOuAct(CoopOuAct ouAct) {
		this.ouAct = ouAct;
	}

	public CoopProsLog getProsLog() {
		return prosLog;
	}

	public void setProsLog(CoopProsLog prosLog) {
		this.prosLog = prosLog;
	}

	public CoopProsReport getProsReport() {
		return prosReport;
	}

	public void setProsReport(CoopProsReport prosReport) {
		this.prosReport = prosReport;
	}

	public List<CoopProsReport> getProsReportList() {
		prosReportList = coopProsReportFacadeREST.findAll();
		return prosReportList;
	}

	public void setProsReportList(List<CoopProsReport> prosReportList) {
		this.prosReportList = prosReportList;
	}

	public DataModel<CoopProsReport> getProsReportModel() {
			if (prosReportModel == null) {
			prosReportModel = new ListDataModel<CoopProsReport>(prosReportList);
		}
		return prosReportModel;
	}
	
	

	public CoopRepAct getRepAct() {
		return repAct;
	}

	public void setRepAct(CoopRepAct repAct) {
		this.repAct = repAct;
	}

	public CoopReportCirc getReportCirc() {
		return reportCirc;
	}

	public void setReportCirc(CoopReportCirc reportCirc) {
		this.reportCirc = reportCirc;
	}

	public CoopProsRepver getProsRepver() {
		return prosRepver;
	}

	public void setProsRepver(CoopProsRepver prosRepver) {
		this.prosRepver = prosRepver;
	}

	public void effortBeanClear() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("effortBean", null);
	}

	public EffortBean() {
	}

	public DataModel<CoopProspect> getProspectModel() {
		if (prospectModel == null) {
			prospectModel = new ListDataModel<>(prospectList);
		}
		return prospectModel;
	}

	public CoopProspect getProspect() {
		return prospect;
	}

	public void saveDtl() {
		report.setReportDtl("effReport");
	}

	public List<CoopProspect> getProspectList() {
		prospectList = coopProspectFacadeREST.findAll();
		return prospectList;
	}

	public void setProspectList(List<CoopProspect> prospectList) {
		this.prospectList = prospectList;
	}

	public void setSelectedProspect(CoopProspect selectedProspect) {
		this.selectedProspect = selectedProspect;
	}

	public CoopProspect getSelectedProspect() {
		if (selectedProspect == null) {
			selectedProspect = new CoopProspect();
		}
		return selectedProspect;
	}

	public void onRowSelect(SelectEvent event) {
	}

	public CoopActivity getActivity() {
		if (activity == null) {
			activity = new CoopActivity();
		}
		return activity;
	}

	public void setActivity(CoopActivity activity) {
		this.activity = activity;
	}

	public CoopReport getReport() {
		if (report == null) {
			report = new CoopReport();
		}
		return report;
	}

	public void setReport(CoopReport report) {
		this.report = report;
	}

	public CoopProsRatingMain getProsRatingMain() {
		if (prosRatingMain == null) {
			prosRatingMain = new CoopProsRatingMain();
		}
		return prosRatingMain;
	}

	public void setProsRatingMain(CoopProsRatingMain prosRatingMain) {
		this.prosRatingMain = prosRatingMain;
	}

	public CoopProsRatingSub getProsRatingSub() {
		if (prosRatingSub == null) {
			prosRatingSub = new CoopProsRatingSub();
		}
		return prosRatingSub;
	}

	public void setProsRatingSub(CoopProsRatingSub prosRatingSub) {
		this.prosRatingSub = prosRatingSub;
	}

	public CoopProsAct getProsAct() {
		if (prosAct == null) {
			prosAct = new CoopProsAct();
		}
		return prosAct;
	}

	public void setProsAct(CoopProsAct prosAct) {
		this.prosAct = prosAct;
	}

	public CoopProsCriteria getProsCriteria() {
		return prosCriteria;
	}

	public CoopProsCriteriaMain getProsCriteriaMain() {
		return prosCriteriaMain;
	}

	public void handleDateSelect(SelectEvent event) {
		Date date = (Date) event.getObject();
	}

	public CoopProsCriteriaSub getProsCriteriaSub() {
		return prosCriteriaSub;
	}

	public String saveEffort() {
		coopActivityFacadeREST.edit(activity);
		activity = new CoopActivity();
		coopMemActFacadeREST.edit(memAct);
		memAct = new CoopMemAct();
		coopOuActFacadeREST.edit(ouAct);
		ouAct = new CoopOuAct();
		coopProsActFacadeREST.edit(prosAct);
		prosAct = new CoopProsAct();
		coopProsLogFacadeREST.edit(prosLog);
		prosLog = new CoopProsLog();
		coopProsRatingMainFacadeREST.edit(prosRatingMain);
		prosRatingMain = new CoopProsRatingMain();
		coopProsRatingSubFacadeREST.edit(prosRatingSub);
		prosRatingSub = new CoopProsRatingSub();
		coopRepActFacadeREST.edit(repAct);
		repAct = new CoopRepAct();
		coopProsReportFacadeREST.edit(prosReport);
		prosReport = new CoopProsReport();
		coopProsRepverFacadeREST.edit(prosRepver);
		prosRepver = new CoopProsRepver();
		coopReportFacadeREST.edit(report);
		report = new CoopReport();
		coopReportCircFacadeREST.edit(reportCirc);
		reportCirc = new CoopReportCirc();
		coopReportTypeFacadeREST.edit(reportType);
		reportType = new CoopReportType();
		activity.setActDateTo(dateTo);
		return "mainEffort";
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dayFrom) {
		this.dateFrom = dayFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dayTo) {
		this.dateTo = dayTo;
	}

	public void dateChangeFrom(SelectEvent e) {
		this.dateFrom = (Date) e.getObject();
		activity.setActDateFrom(dateFrom);
	}

	public void dateChangeTo(SelectEvent e) {
		this.dateTo = (Date) e.getObject();
		activity.setActDateTo(dateTo);
	}

	public boolean isWilling() {
		return willing;
	}

	public void setWilling(boolean willing) {
		if ((this.willing == true) && (this.understanding == false) && (this.motivated == false) && (this.social == false)) {
			this.willing = false;
			norating = true;
		} else {
			this.willingnessRating = 1;
			norating = false;
			this.willing = willing;
		}
	}

	public boolean isUnderstanding() {
		return understanding;
	}

	public void setUnderstanding(boolean understanding) {
		if ((this.willing == false) && (this.understanding == true) && (this.motivated == false) && (this.social == false)) {
			this.understanding = false;
			norating = true;
		} else {
			this.understandingRatingSub1 = 1;
			this.understandingRatingSub2 = 1;
			this.understandingRatingSub3 = 1;
			norating = false;
			this.understanding = understanding;
		}
	}

	public boolean isMotivated() {
		return motivated;
	}

	public void setMotivated(boolean motivated) {
		if ((this.willing == false) && (this.understanding == false) && (this.motivated == true) && (this.social == false)) {
			this.motivated = false;
			norating = true;
		} else {
			this.motivatedRating = 1;
			norating = false;
			this.motivated = motivated;
		}
	}

	public boolean isSocial() {
		return social;
	}

	public void setSocial(boolean social) {
		if ((this.willing == false) && (this.understanding == false) && (this.motivated == false) && (this.social == true)) {
			this.social = false;
			norating = true;
		} else {
			this.socialRating = 1;
			norating = false;
			this.social = social;
		}
	}

	public boolean isNorating() {
		return norating;
	}

	public void setNorating(boolean norating) {
		if ((willing == false) && (understanding == false) && (motivated == false) && (social == false)) {
			this.norating = true;
		} else {
			willing = false;
			understanding = false;
			motivated = false;
			social = false;
			this.norating = norating;
		}
	}

	public Integer getWillingnessRating() {
		return willingnessRating;
	}

	public void setWillingnessRating(Integer willingnessRating) {
		this.willingnessRating = willingnessRating;
	}

	public Integer getUnderstandingRatingSub1() {
		return understandingRatingSub1;
	}

	public void setUnderstandingRatingSub1(Integer understandingRatingSub1) {
		this.understandingRatingSub1 = understandingRatingSub1;
	}

	public Integer getUnderstandingRatingSub2() {
		return understandingRatingSub2;
	}

	public void setUnderstandingRatingSub2(Integer understandingRatingSub2) {
		this.understandingRatingSub2 = understandingRatingSub2;
	}

	public Integer getUnderstandingRatingSub3() {
		return understandingRatingSub3;
	}

	public void setUnderstandingRatingSub3(Integer understandingRatingSub3) {
		this.understandingRatingSub3 = understandingRatingSub3;
	}

	public Integer getMotivatedRating() {
		return motivatedRating;
	}

	public void setMotivatedRating(Integer motivatedRating) {
		this.motivatedRating = motivatedRating;
	}

	public Integer getSocialRating() {
		return socialRating;
	}

	public void setSocialRating(Integer socialRating) {
		this.socialRating = socialRating;
	}

	public String reset() {
		RequestContext.getCurrentInstance().reset("addEffForm");
		return "mainEffort";
	}
}
