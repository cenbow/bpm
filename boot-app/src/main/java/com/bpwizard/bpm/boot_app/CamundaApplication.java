package com.bpwizard.bpm.boot_app;

import java.util.List;

import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.engine.CaseService;
import org.camunda.bpm.engine.DecisionService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableProcessApplication("boot-app")
public class CamundaApplication {

	 @Autowired
	 private RuntimeService runtimeService;

	@Autowired
	ProcessEngine processEngine;

	public static void main(String... args) {
		SpringApplication.run(CamundaApplication.class, args);
	}

	@EventListener
	private void processPostDeployLoadApproval(PostDeployEvent event) {
		runtimeService.startProcessInstanceByKey("loanApproval");
	}

	@EventListener
	private void startCaseInstance(PostDeployEvent event) {
		System.out.println(">>>>>>>>>>startCaseInstance processEngine :" + processEngine);
		CaseService caseService = processEngine.getCaseService();
		System.out.println(">>>>>>>>>>case service :" + caseService);
		caseService.createCaseInstanceByKey("loan_application",
				Variables.createVariables().putValue("applicationSufficient", Variables.booleanValue(null))
						.putValue("rating", Variables.integerValue(null)));

	}

	@EventListener
	private void evaluateDecisionTable(PostDeployEvent event) {
		System.out.println(">>>>>>>>>>evaluateDecisionTable processEngine :" + processEngine);
		DecisionService decisionService = processEngine.getDecisionService();
		System.out.println(">>>>>>>>>>decisionService :" + decisionService);
		VariableMap variables = Variables.createVariables().putValue("season", "Spring").putValue("guestCount", 10)
				.putValue("guestsWithChildren", false);

		DmnDecisionTableResult dishDecisionResult = decisionService.evaluateDecisionTableByKey("dish", variables);
		String desiredDish = dishDecisionResult.getSingleEntry();

		System.out.println(">>>>>>>>>>> Desired dish: " + desiredDish);

		DmnDecisionTableResult beveragesDecisionResult = decisionService.evaluateDecisionTableByKey("beverages",
				variables);
		List<Object> beverages = beveragesDecisionResult.collectEntries("beverages");

		System.out.println(">>>>>>>>>>> Desired beverages: " + beverages);
	}
}
