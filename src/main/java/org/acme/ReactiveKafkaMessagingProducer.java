//package org.acme;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.enterprise.context.ApplicationScoped;
//import jakarta.inject.Inject;
//import org.apache.kafka.common.errors.TimeoutException;
//import org.eclipse.microprofile.reactive.messaging.Channel;
//import org.eclipse.microprofile.reactive.messaging.Emitter;
//import org.jboss.logging.Logger;
//
//import java.util.List;
//import java.util.Map;
//
//@ApplicationScoped
//public class ReactiveKafkaMessagingProducer {
//
//    @Inject
//    Logger logger;
//
//    @Inject
//    @Channel("movies")
//    Emitter<String> publish;
//
//    private List<Movie> movies = List.of(
//            new Movie("1", "One Piece", "Eichiro oda", "anime"),
//            new Movie("2", "Naruto", "Masashi Kisimoto", "anime"),
//            new Movie("3", "Naruto", "Masashi Kisimoto", "anime"),
//            new Movie("4", "Naruto", "Masashi Kisimoto", "anime"),
//            new Movie("5", "Naruto", "Masashi Kisimoto", "anime"),
//            new Movie("6", "Naruto", "Masashi Kisimoto", "anime"),
//            new Movie("7", "Naruto", "Masashi Kisimoto", "anime"),
//            new Movie("8", "Naruto", "Masashi Kisimoto", "anime"),
//            new Movie("9", "Naruto", "Masashi Kisimoto", "anime"),
//            new Movie("10", "Naruto", "Masashi Kisimoto", "anime"),
//            new Movie("11", "Naruto", "Masashi Kisimoto", "anime"),
//            new Movie("12", "Naruto", "Masashi Kisimoto", "anime"),
//            new Movie("13", "Naruto", "Masashi Kisimoto", "anime"),
//            new Movie("14", "Naruto", "Masashi Kisimoto", "anime"),
//            new Movie("15", "Naruto", "Masashi Kisimoto", "anime"),
//            new Movie("16", "Naruto", "Masashi Kisimoto", "anime")
//
//    );
//
//    public void movies(){
//        logger.info("STARTED");
//
//        movies.forEach(movie -> {
//
//            String json = "{\n" +
//                    "\t\"transactionId\": \"1cd17a34-24aa-4e96-93ba-498f41317df6\",\n" +
//                    "\t\"formula\": [\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"code\": \"GET_AGE_NEAREST\",\n" +
//                    "\t\t\t\"formula\": \"RND;0;if(DYD;(dateOfBirth:effectiveDate)/365 >= 0.5,DY;(dateOfBirth:effectiveDate)+1,DY;(dateOfBirth:effectiveDate))\"\n" +
//                    "\t\t},\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"code\": \"GET_BACK_SERVICE_WORK_PERIOD_MONTH\",\n" +
//                    "\t\t\t\"formula\": \"RND;0;DYM;(dateOfWork:effectiveDate)\"\n" +
//                    "\t\t},\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"code\": \"GET_BACK_SERVICE_WORK_PERIOD_YEAR\",\n" +
//                    "\t\t\t\"formula\": \"RND;0;DY;(dateOfWork:effectiveDate)\"\n" +
//                    "\t\t},\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"code\": \"GET_BS_ADMINISTRATION_FEE\",\n" +
//                    "\t\t\t\"formula\": \"RND;0;backServicePremium*administrationFee/100\"\n" +
//                    "\t\t},\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"code\": \"GET_BS_PREMIUM\",\n" +
//                    "\t\t\t\"formula\": \"RND;0;backServicePremium\"\n" +
//                    "\t\t},\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"code\": \"GET_COMING_SERVICE_PREMIUM\",\n" +
//                    "\t\t\t\"formula\": \"RND;0;IFS(premiumMethod=PERCENTAGE,wages*premiumMethodValue/100,comingServicePremium)\"\n" +
//                    "\t\t},\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"code\": \"GET_COMING_SERVICE_WORK_PERIOD_MONTH\",\n" +
//                    "\t\t\t\"formula\": \"if(GET_TOTAL_WORK_PERIOD_MONTH < GET_BACK_SERVICE_WORK_PERIOD_MONTH, ((12 + GET_TOTAL_WORK_PERIOD_MONTH) - GET_BACK_SERVICE_WORK_PERIOD_MONTH), (GET_TOTAL_WORK_PERIOD_MONTH - GET_BACK_SERVICE_WORK_PERIOD_MONTH))\"\n" +
//                    "\t\t},\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"code\": \"GET_COMING_SERVICE_WORK_PERIOD_YEAR\",\n" +
//                    "\t\t\t\"formula\": \"if(GET_TOTAL_WORK_PERIOD_MONTH < GET_BACK_SERVICE_WORK_PERIOD_MONTH, DY;(dateOfWork:effectiveDate) - 1, DY;(dateOfWork:effectiveDate))\"\n" +
//                    "\t\t},\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"code\": \"mainBenefit\",\n" +
//                    "\t\t\t\"formula\": [\n" +
//                    "\t\t\t\t{\n" +
//                    "\t\t\t\t\t\"code\": \"GET_COST_OF_INSURANCED\",\n" +
//                    "\t\t\t\t\t\"formula\": \"RND;0;(GET_PREMI_PROTECTION+GET_PREMI_EMPERSEN+GET_PREMI_EMPERMILL)\"\n" +
//                    "\t\t\t\t},\n" +
//                    "\t\t\t\t{\n" +
//                    "\t\t\t\t\t\"code\": \"func.getRateEBP\",\n" +
//                    "\t\t\t\t\t\"formula\": \"getTarifStd(rateCode,'ANNUALLY','*','1','0','0','0','0','0',GET_AGE_NEAREST,'*','*')\"\n" +
//                    "\t\t\t\t},\n" +
//                    "\t\t\t\t{\n" +
//                    "\t\t\t\t\t\"code\": \"GET_PREMI_EMPERMILL\",\n" +
//                    "\t\t\t\t\t\"formula\": \"RND;0;((GET_BENEFIT_VALUE*emPermill)/1000)/12\"\n" +
//                    "\t\t\t\t},\n" +
//                    "\t\t\t\t{\n" +
//                    "\t\t\t\t\t\"code\": \"GET_BENEFIT_VALUE\",\n" +
//                    "\t\t\t\t\t\"formula\": \"RND;0;IFS(benefitMethod=VALUE,benefitValue,wages*func.getFactorEBP)\"\n" +
//                    "\t\t\t\t},\n" +
//                    "\t\t\t\t{\n" +
//                    "\t\t\t\t\t\"code\": \"GET_PREMI_PROTECTION\",\n" +
//                    "\t\t\t\t\t\"formula\": \"RND;0;((GET_BENEFIT_VALUE*func.getRateEBP)/1000)/12\"\n" +
//                    "\t\t\t\t},\n" +
//                    "\t\t\t\t{\n" +
//                    "\t\t\t\t\t\"code\": \"func.getFactorEBP\",\n" +
//                    "\t\t\t\t\t\"formula\": \"getTarifStd(benefitMethod,'*', '*',GET_BACK_SERVICE_WORK_PERIOD_YEAR,'0','0','0','0','0','0','*','*')\"\n" +
//                    "\t\t\t\t},\n" +
//                    "\t\t\t\t{\n" +
//                    "\t\t\t\t\t\"code\": \"GET_PREMI_EMPERSEN\",\n" +
//                    "\t\t\t\t\t\"formula\": \"RND;0;(GET_PREMI_PROTECTION*emPersen)/100\"\n" +
//                    "\t\t\t\t},\n" +
//                    "\t\t\t\t{\n" +
//                    "\t\t\t\t\t\"code\": \"GET_EXTRA_PREMIUM\",\n" +
//                    "\t\t\t\t\t\"formula\": \"RND;0;(GET_PREMI_EMPERSEN+GET_PREMI_EMPERMILL)\"\n" +
//                    "\t\t\t\t}\n" +
//                    "\t\t\t]\n" +
//                    "\t\t},\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"code\": \"additionalMainBenefit\",\n" +
//                    "\t\t\t\"formula\": [\n" +
//                    "\t\t\t\t{\n" +
//                    "\t\t\t\t\t\"code\": \"GET_COST_OF_INSURANCED\",\n" +
//                    "\t\t\t\t\t\"formula\": \"RND;0;(GET_PREMI_PROTECTION+GET_PREMI_EMPERSEN+GET_PREMI_EMPERMILL)\"\n" +
//                    "\t\t\t\t},\n" +
//                    "\t\t\t\t{\n" +
//                    "\t\t\t\t\t\"code\": \"func.getRateEBP\",\n" +
//                    "\t\t\t\t\t\"formula\": \"getTarifStd(rateCode,'ANNUALLY','*','1','0','0','0','0','0',GET_AGE_NEAREST,'*','*')\"\n" +
//                    "\t\t\t\t},\n" +
//                    "\t\t\t\t{\n" +
//                    "\t\t\t\t\t\"code\": \"GET_PREMI_EMPERMILL\",\n" +
//                    "\t\t\t\t\t\"formula\": \"RND;0;((GET_BENEFIT_VALUE*emPermill)/1000)/12\"\n" +
//                    "\t\t\t\t},\n" +
//                    "\t\t\t\t{\n" +
//                    "\t\t\t\t\t\"code\": \"GET_BENEFIT_VALUE\",\n" +
//                    "\t\t\t\t\t\"formula\": \"RND;0;IFS(benefitMethod=VALUE,benefitValue,wages*func.getFactorEBP)\"\n" +
//                    "\t\t\t\t},\n" +
//                    "\t\t\t\t{\n" +
//                    "\t\t\t\t\t\"code\": \"GET_PREMI_PROTECTION\",\n" +
//                    "\t\t\t\t\t\"formula\": \"RND;0;((GET_BENEFIT_VALUE*func.getRateEBP)/1000)/12\"\n" +
//                    "\t\t\t\t},\n" +
//                    "\t\t\t\t{\n" +
//                    "\t\t\t\t\t\"code\": \"func.getFactorEBP\",\n" +
//                    "\t\t\t\t\t\"formula\": \"getTarifStd(benefitMethod,'*', '*',GET_BACK_SERVICE_WORK_PERIOD_YEAR,'0','0','0','0','0','0','*','*')\"\n" +
//                    "\t\t\t\t},\n" +
//                    "\t\t\t\t{\n" +
//                    "\t\t\t\t\t\"code\": \"GET_PREMI_EMPERSEN\",\n" +
//                    "\t\t\t\t\t\"formula\": \"RND;0;(GET_PREMI_PROTECTION*emPersen)/100\"\n" +
//                    "\t\t\t\t},\n" +
//                    "\t\t\t\t{\n" +
//                    "\t\t\t\t\t\"code\": \"GET_EXTRA_PREMIUM\",\n" +
//                    "\t\t\t\t\t\"formula\": \"RND;0;(GET_PREMI_EMPERSEN+GET_PREMI_EMPERMILL)\"\n" +
//                    "\t\t\t\t}\n" +
//                    "\t\t\t]\n" +
//                    "\t\t},\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"code\": \"GET_CS_ADMINISTRATION_FEE\",\n" +
//                    "\t\t\t\"formula\": \"RND;0;GET_MAIN_PREMIUM*administrationFee/100\"\n" +
//                    "\t\t},\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"code\": \"GET_INSURANCED_END_DATE\",\n" +
//                    "\t\t\t\"formula\": \"IFS(insurancedPeriodMethod=RETIRED_AGE,GET_INSURANCE_END_DATE_RA,GET_INSURANCE_END_DATE_TERM)\"\n" +
//                    "\t\t},\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"code\": \"GET_INSURANCE_END_DATE_RA\",\n" +
//                    "\t\t\t\"formula\": \"ADD_DAY;(ADD_YEAR;(dateOfBirth:insurancedPeriodValueYear): -1)\"\n" +
//                    "\t\t},\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"code\": \"GET_INSURANCE_END_DATE_TERM\",\n" +
//                    "\t\t\t\"formula\": \"ADD_DAY;(ADD_MONTH;(ADD_YEAR;(insuranceStartDate:insurancedPeriodValueYear):insurancedPeriodValueMonth):-1)\"\n" +
//                    "\t\t},\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"code\": \"GET_INSURANCE_PERIOD\",\n" +
//                    "\t\t\t\"formula\": \"IFS(insurancedPeriodMethod=RETIRED_AGE,GET_INSURANCE_PERIOD_RA,GET_INSURANCE_PERIOD_TERM)\"\n" +
//                    "\t\t},\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"code\": \"GET_INSURANCE_PERIOD_DAY\",\n" +
//                    "\t\t\t\"formula\": \"RND;0;DMD;(effectiveDate:GET_INSURANCED_END_DATE)\"\n" +
//                    "\t\t},\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"code\": \"GET_INSURANCE_PERIOD_MONTH\",\n" +
//                    "\t\t\t\"formula\": \"RND;0;DYM;(effectiveDate:GET_INSURANCED_END_DATE)\"\n" +
//                    "\t\t},\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"code\": \"GET_INSURANCE_PERIOD_RA\",\n" +
//                    "\t\t\t\"formula\": \"DY;(insuranceStartDate:ADD_DAY;(GET_INSURANCE_END_DATE_RA:1)) + DYM;(insuranceStartDate:ADD_DAY;(GET_INSURANCE_END_DATE_RA:1))/12\"\n" +
//                    "\t\t},\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"code\": \"GET_INSURANCE_PERIOD_TERM\",\n" +
//                    "\t\t\t\"formula\": \"IFS(insurancedPeriodMethod=TERM,insurancedPeriodValueYear + insurancedPeriodValueMonth/12,0)\"\n" +
//                    "\t\t},\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"code\": \"GET_INSURANCE_PERIOD_YEAR\",\n" +
//                    "\t\t\t\"formula\": \"RND;0;DY;(effectiveDate:GET_INSURANCED_END_DATE)\"\n" +
//                    "\t\t},\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"code\": \"GET_MAIN_PREMIUM\",\n" +
//                    "\t\t\t\"formula\": \"RND;0;IFS(premiumPeriodicMethod=PERCENTAGE,(GET_COMING_SERVICE_PREMIUM * (1+(premiumPeriodicMethodValue/100))^(DY;(insuranceStartDate:effectiveDate))),(GET_COMING_SERVICE_PREMIUM+(premiumPeriodicMethodValue*(DY;(insuranceStartDate:effectiveDate)))))\"\n" +
//                    "\t\t},\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"code\": \"GET_RETIRED_SALARY\",\n" +
//                    "\t\t\t\"formula\": \"RND;0;IFS(salaryAdjusment=0,wages,wages*(1+(salaryAdjusment/100))^(GET_COMING_SERVICE_WORK_PERIOD_YEAR+(GET_COMING_SERVICE_WORK_PERIOD_MONTH/12)))\"\n" +
//                    "\t\t},\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"code\": \"GET_TOTAL_WORK_PERIOD_MONTH\",\n" +
//                    "\t\t\t\"formula\": \"RND;0;DYM;(dateOfWork:effectiveDate)\"\n" +
//                    "\t\t},\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"code\": \"GET_TOTAL_WORK_PERIOD_YEAR\",\n" +
//                    "\t\t\t\"formula\": \"RND;0;DY;(dateOfWork:effectiveDate)\"\n" +
//                    "\t\t}\n" +
//                    "\t],\n" +
//                    "\t\"objFormula\": [\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"personCif\": \"16b9d032-2e9a-4d0a-818a-9feb03465686\",\n" +
//                    "\t\t\t\"insuranceStartDate\": \"2023-05-30\",\n" +
//                    "\t\t\t\"dateOfBirth\": \"1995-10-20\",\n" +
//                    "\t\t\t\"dateOfWork\": \"2014-06-10\",\n" +
//                    "\t\t\t\"effectiveDate\": \"2023-05-30\",\n" +
//                    "\t\t\t\"insurancedPeriodMethod\": \"RETIRED_AGE\",\n" +
//                    "\t\t\t\"insurancedPeriodValueYear\": \"60\",\n" +
//                    "\t\t\t\"insurancedPeriodValueMonth\": \"0\",\n" +
//                    "\t\t\t\"administrationFee\": \"2\",\n" +
//                    "\t\t\t\"salaryAdjusment\": \"0\",\n" +
//                    "\t\t\t\"wages\": \"20000000\",\n" +
//                    "\t\t\t\"paymentFrequency\": \"MONTHLY\",\n" +
//                    "\t\t\t\"premiumMethod\": \"PERCENTAGE\",\n" +
//                    "\t\t\t\"premiumMethodValue\": \"5\",\n" +
//                    "\t\t\t\"premiumPeriodicMethod\": \"PERCENTAGE\",\n" +
//                    "\t\t\t\"premiumPeriodicMethodValue\": \"5\",\n" +
//                    "\t\t\t\"backServicePremium\": \"50000000\",\n" +
//                    "\t\t\t\"comingServicePremium\": \"0\",\n" +
//                    "\t\t\t\"maritalStatus\": \"MARRIED\",\n" +
//                    "\t\t\t\"sex\": \"MALE\",\n" +
//                    "\t\t\t\"mainBenefit\": [\n" +
//                    "\t\t\t\t{\n" +
//                    "\t\t\t\t\t\"code\": \"DEATH_ACCIDENT\",\n" +
//                    "\t\t\t\t\t\"rateCode\": \"DA003010123\",\n" +
//                    "\t\t\t\t\t\"benefitMethod\": \"UUCK\",\n" +
//                    "\t\t\t\t\t\"benefitValue\": \"0\",\n" +
//                    "\t\t\t\t\t\"emPersen\": \"0\",\n" +
//                    "\t\t\t\t\t\"emPermill\": \"0\"\n" +
//                    "\t\t\t\t}\n" +
//                    "\t\t\t],\n" +
//                    "\t\t\t\"additionalMainBenefit\": [\n" +
//                    "\t\t\t\t{\n" +
//                    "\t\t\t\t\t\"code\": \"NATURAL_DEATH\",\n" +
//                    "\t\t\t\t\t\"rateCode\": \"ND003010123\",\n" +
//                    "\t\t\t\t\t\"benefitMethod\": \"UUK13_EXP\",\n" +
//                    "\t\t\t\t\t\"benefitValue\": \"0\",\n" +
//                    "\t\t\t\t\t\"emPersen\": \"0\",\n" +
//                    "\t\t\t\t\t\"emPermill\": \"0\"\n" +
//                    "\t\t\t\t},\n" +
//                    "\t\t\t\t{\n" +
//                    "\t\t\t\t\t\"code\": \"TOTAL_DISABILITY\",\n" +
//                    "\t\t\t\t\t\"rateCode\": \"TD003010123\",\n" +
//                    "\t\t\t\t\t\"benefitMethod\": \"UUK13_TPD\",\n" +
//                    "\t\t\t\t\t\"benefitValue\": \"0\",\n" +
//                    "\t\t\t\t\t\"emPersen\": \"0\",\n" +
//                    "\t\t\t\t\t\"emPermill\": \"0\"\n" +
//                    "\t\t\t\t}\n" +
//                    "\t\t\t],\n" +
//                    "\t\t\t\"riderBenefit\": []\n" +
//                    "\t\t},\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"personCif\": \"c9523e5a-28ff-4358-b548-61717afefa04\",\n" +
//                    "\t\t\t\"insuranceStartDate\": \"2023-05-30\",\n" +
//                    "\t\t\t\"dateOfBirth\": \"1995-10-20\",\n" +
//                    "\t\t\t\"dateOfWork\": \"2014-06-10\",\n" +
//                    "\t\t\t\"effectiveDate\": \"2023-05-30\",\n" +
//                    "\t\t\t\"insurancedPeriodMethod\": \"RETIRED_AGE\",\n" +
//                    "\t\t\t\"insurancedPeriodValueYear\": \"60\",\n" +
//                    "\t\t\t\"insurancedPeriodValueMonth\": \"0\",\n" +
//                    "\t\t\t\"administrationFee\": \"2\",\n" +
//                    "\t\t\t\"salaryAdjusment\": \"0\",\n" +
//                    "\t\t\t\"wages\": \"20000000\",\n" +
//                    "\t\t\t\"paymentFrequency\": \"MONTHLY\",\n" +
//                    "\t\t\t\"premiumMethod\": \"PERCENTAGE\",\n" +
//                    "\t\t\t\"premiumMethodValue\": \"5\",\n" +
//                    "\t\t\t\"premiumPeriodicMethod\": \"PERCENTAGE\",\n" +
//                    "\t\t\t\"premiumPeriodicMethodValue\": \"5\",\n" +
//                    "\t\t\t\"backServicePremium\": \"50000000\",\n" +
//                    "\t\t\t\"comingServicePremium\": \"0\",\n" +
//                    "\t\t\t\"maritalStatus\": \"MARRIED\",\n" +
//                    "\t\t\t\"sex\": \"MALE\",\n" +
//                    "\t\t\t\"mainBenefit\": [\n" +
//                    "\t\t\t\t{\n" +
//                    "\t\t\t\t\t\"code\": \"DEATH_ACCIDENT\",\n" +
//                    "\t\t\t\t\t\"rateCode\": \"DA003010123\",\n" +
//                    "\t\t\t\t\t\"benefitMethod\": \"UUCK\",\n" +
//                    "\t\t\t\t\t\"benefitValue\": \"0\",\n" +
//                    "\t\t\t\t\t\"emPersen\": \"0\",\n" +
//                    "\t\t\t\t\t\"emPermill\": \"0\"\n" +
//                    "\t\t\t\t}\n" +
//                    "\t\t\t],\n" +
//                    "\t\t\t\"additionalMainBenefit\": [\n" +
//                    "\t\t\t\t{\n" +
//                    "\t\t\t\t\t\"code\": \"NATURAL_DEATH\",\n" +
//                    "\t\t\t\t\t\"rateCode\": \"ND003010123\",\n" +
//                    "\t\t\t\t\t\"benefitMethod\": \"UUK13_EXP\",\n" +
//                    "\t\t\t\t\t\"benefitValue\": \"0\",\n" +
//                    "\t\t\t\t\t\"emPersen\": \"0\",\n" +
//                    "\t\t\t\t\t\"emPermill\": \"0\"\n" +
//                    "\t\t\t\t},\n" +
//                    "\t\t\t\t{\n" +
//                    "\t\t\t\t\t\"code\": \"TOTAL_DISABILITY\",\n" +
//                    "\t\t\t\t\t\"rateCode\": \"TD003010123\",\n" +
//                    "\t\t\t\t\t\"benefitMethod\": \"UUK13_TPD\",\n" +
//                    "\t\t\t\t\t\"benefitValue\": \"0\",\n" +
//                    "\t\t\t\t\t\"emPersen\": \"0\",\n" +
//                    "\t\t\t\t\t\"emPermill\": \"0\"\n" +
//                    "\t\t\t\t}\n" +
//                    "\t\t\t],\n" +
//                    "\t\t\t\"riderBenefit\": []\n" +
//                    "\t\t},\n" +
//                    "\t\t{\n" +
//                    "\t\t\t\"personCif\": \"625ef4f6-2adb-4bdc-b40b-0b6ce007dc1f\",\n" +
//                    "\t\t\t\"insuranceStartDate\": \"2023-05-30\",\n" +
//                    "\t\t\t\"dateOfBirth\": \"1990-10-20\",\n" +
//                    "\t\t\t\"dateOfWork\": \"2014-06-10\",\n" +
//                    "\t\t\t\"effectiveDate\": \"2023-05-30\",\n" +
//                    "\t\t\t\"insurancedPeriodMethod\": \"RETIRED_AGE\",\n" +
//                    "\t\t\t\"insurancedPeriodValueYear\": \"60\",\n" +
//                    "\t\t\t\"insurancedPeriodValueMonth\": \"0\",\n" +
//                    "\t\t\t\"administrationFee\": \"2\",\n" +
//                    "\t\t\t\"salaryAdjusment\": \"0\",\n" +
//                    "\t\t\t\"wages\": \"20000000\",\n" +
//                    "\t\t\t\"paymentFrequency\": \"MONTHLY\",\n" +
//                    "\t\t\t\"premiumMethod\": \"PERCENTAGE\",\n" +
//                    "\t\t\t\"premiumMethodValue\": \"5\",\n" +
//                    "\t\t\t\"premiumPeriodicMethod\": \"PERCENTAGE\",\n" +
//                    "\t\t\t\"premiumPeriodicMethodValue\": \"5\",\n" +
//                    "\t\t\t\"backServicePremium\": \"50000000\",\n" +
//                    "\t\t\t\"comingServicePremium\": \"0\",\n" +
//                    "\t\t\t\"maritalStatus\": \"MARRIED\",\n" +
//                    "\t\t\t\"sex\": \"MALE\",\n" +
//                    "\t\t\t\"mainBenefit\": [\n" +
//                    "\t\t\t\t{\n" +
//                    "\t\t\t\t\t\"code\": \"DEATH_ACCIDENT\",\n" +
//                    "\t\t\t\t\t\"rateCode\": \"DA003010123\",\n" +
//                    "\t\t\t\t\t\"benefitMethod\": \"UUCK\",\n" +
//                    "\t\t\t\t\t\"benefitValue\": \"0\",\n" +
//                    "\t\t\t\t\t\"emPersen\": \"0\",\n" +
//                    "\t\t\t\t\t\"emPermill\": \"0\"\n" +
//                    "\t\t\t\t}\n" +
//                    "\t\t\t],\n" +
//                    "\t\t\t\"additionalMainBenefit\": [\n" +
//                    "\t\t\t\t{\n" +
//                    "\t\t\t\t\t\"code\": \"NATURAL_DEATH\",\n" +
//                    "\t\t\t\t\t\"rateCode\": \"ND003010123\",\n" +
//                    "\t\t\t\t\t\"benefitMethod\": \"UUK13_EXP\",\n" +
//                    "\t\t\t\t\t\"benefitValue\": \"0\",\n" +
//                    "\t\t\t\t\t\"emPersen\": \"0\",\n" +
//                    "\t\t\t\t\t\"emPermill\": \"0\"\n" +
//                    "\t\t\t\t},\n" +
//                    "\t\t\t\t{\n" +
//                    "\t\t\t\t\t\"code\": \"TOTAL_DISABILITY\",\n" +
//                    "\t\t\t\t\t\"rateCode\": \"TD003010123\",\n" +
//                    "\t\t\t\t\t\"benefitMethod\": \"UUK13_TPD\",\n" +
//                    "\t\t\t\t\t\"benefitValue\": \"0\",\n" +
//                    "\t\t\t\t\t\"emPersen\": \"0\",\n" +
//                    "\t\t\t\t\t\"emPermill\": \"0\"\n" +
//                    "\t\t\t\t}\n" +
//                    "\t\t\t],\n" +
//                    "\t\t\t\"riderBenefit\": []\n" +
//                    "\t\t}\n" +
//                    "\t],\n" +
//                    "\t\"organization\": {\n" +
//                    "\t\t\"organizationCif\": \"\",\n" +
//                    "\t\t\"groupOrganizationCif\": \"0\",\n" +
//                    "\t\t\"proposalNumber\": \"12345678\",\n" +
//                    "\t\t\"version\": \"\",\n" +
//                    "\t\t\"transactionCode\": \"SUBMISSION\"\n" +
//                    "\t}\n" +
//                    "}";
//
//            ObjectMapper objectMapper = new ObjectMapper();
//            try {
//                Map<String, Object> map = objectMapper.readValue(json, Map.class);
//                publish.send(objectMapper.writeValueAsString(map))
//                        .whenCompleteAsync((recordMetaData, throwable) -> {
//                            if(throwable != null){
//                                if (throwable instanceof TimeoutException) {
//                                    logger.errorv("Error timeout kafka {0} ", throwable.getMessage());
//                                } else {
//                                    logger.errorv("Error another kafka {0} ", throwable.getMessage());
//                                }
//                            }else{
//                                logger.infov("success send kafka {0} ", recordMetaData);
//                                logger.infov("SUCCESSsssssss {0} ", movie.id);
//                            }
//                        });
//            } catch (JsonProcessingException e) {
//                throw new RuntimeException(e);
//            }
//        });
//    }
//
//
//
//}
