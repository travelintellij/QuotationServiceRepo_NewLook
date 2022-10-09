package com.travelintellij.quotation.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TIConstants {

	public static String DEAL_SEARCH_CONF="based_on_conf";
	public static String DEAL_SEARCH_CLIENT="based_on_client";
	public static String DEAL_SEARCH_QUERY="based_on_query";
	public static int UDN_DFT_STATUS_PENDING =0;
	
	public static String MY_COMPANY_NAME = "UdanChoo";
	
	public static String DEAL_OBJECT_STATUS_TYPE = "DEAL_OBJ";
	
	///////////////////////////////////////////////////
	public static String WORKLOAD_FLT_CODE = "FLT";
	public static String WORKLOAD_HTL_CODE  = "HTL";
	public static String WORKLOAD_INS_CODE  = "INS";
	public static String WORKLOAD_LDP_CODE  = "LDP";
	public static String WORKLOAD_OTH_CODE  = "OTH";
	public static String WORKLOAD_STS_CODE  = "STS";
	public static String WORKLOAD_TRN_CODE  = "TRN";
	public static String WORKLOAD_VSA_CODE  = "VSA";
	public static String WORKLOAD_CRS_CODE  = "CRS";

	///////////////////////////////////////////////////////
	public static String WORKLOAD_FLT_OBJ = "FLT_WL";
	public static String WORKLOAD_HTL_OBJ = "HTL_WL";
	public static String WORKLOAD_INS_OBJ = "INS_WL";
	public static String WORKLOAD_LDP_OBJ = "LDP_WL";
	public static String WORKLOAD_OTH_OBJ = "OTH_WL";
	public static String WORKLOAD_STS_OBJ = "STS_WL";
	public static String WORKLOAD_TRN_OBJ = "TRN_WL";
	public static String WORKLOAD_VSA_OBJ = "VSA_WL";
	///////////////////////////////////////////////////////
	
	
	//please make a note that key is service and value is workload type.
	 static final Map<String, String> WORKLOAD_SERVICE_MAP = new HashMap<String, String>(){
	        {
	            put(WORKLOAD_FLT_OBJ,WORKLOAD_FLT_CODE);
	            put(WORKLOAD_HTL_OBJ,WORKLOAD_HTL_CODE);
	            put(WORKLOAD_INS_OBJ,WORKLOAD_INS_CODE);
	            put(WORKLOAD_LDP_OBJ,WORKLOAD_LDP_CODE);
	            put(WORKLOAD_OTH_OBJ,WORKLOAD_OTH_CODE);
	            put(WORKLOAD_STS_OBJ,WORKLOAD_STS_CODE);
	            put(WORKLOAD_TRN_OBJ,WORKLOAD_TRN_CODE);
	            put(WORKLOAD_VSA_OBJ,WORKLOAD_VSA_CODE);
	        }
	    };
	
	
	
	//////////////Following block of constants are related to Flight Service line object only //////////////////
	public static String WORKLOAD_FLT_SL_OBJ = "FLT_SL";
	public static String WORKLOAD_HTL_SL_OBJ = "HTL_SL";
	public static String WORKLOAD_INS_SL_OBJ = "INS_SL";
	public static String WORKLOAD_LDP_SL_OBJ = "LDP_SL";
	public static String WORKLOAD_OTH_SL_OBJ = "OTH_SL";
	public static String WORKLOAD_STS_SL_OBJ = "STS_SL";
	public static String WORKLOAD_TRN_SL_OBJ = "TRN_SL";
	public static String WORKLOAD_VSA_SL_OBJ = "VSA_SL";
	
	public static String WORKLOAD_LEAD_OBJ = "LEAD_WL";
	public static String WORKLOAD_INCENTIVE_OBJ = "INCENTIVE_OBJ";
	public static int INCENTIVE_FRESH_CREATED_STATUS=222;
	public static int INCENTIVE_ANY_STATUS=0;
	
	///////////////// FOR FRESH DEAL OBJ STATUS /////////////////////////
	public static int DEAL_FRESH_CREATED_STATUS=25;
	public static int DEAL_OBJECT_CLOSED_STATUS = 34;
	public static int DEAL_FRESH_CREATED_FLT_WL_STATUS=130;
	public static int DEAL_FRESH_CREATED_HTL_WL_STATUS=139;
	public static int DEAL_FRESH_CREATED_INS_WL_STATUS=148;
	public static int DEAL_FRESH_CREATED_LDP_WL_STATUS=157;
	public static int DEAL_FRESH_CREATED_OTH_WL_STATUS=166;
	public static int DEAL_FRESH_CREATED_STS_WL_STATUS=175;
	public static int DEAL_FRESH_CREATED_TRN_WL_STATUS=184;
	public static int DEAL_FRESH_CREATED_VSA_WL_STATUS=193;
	
	public static int DEAL_FRESH_CREATED_LEAD_WL_STATUS=202;
	public static int LEAD_WL_STATUS_THRESHOLD_OPEN=204;
	public static int VIEW_ALL_LEADS_WL_STATUS=200;
	public static int VIEW_ALL_OPEN_LEADS_WL_STATUS=200;
	public static int VIEW_ALL_CLOSED_LEADS_WL_STATUS=100;
	
	
	public static int B2B_PARTNER_SELF_REFERENCE = 1;
	///////////////////////////////////////////////////////////////////
	
	public static String VISA_DOC_CUSTODY_CLIENT = "client";
	public static String VISA_DOC_CUSTODY_UDN = "udanchoo";
	public static String VISA_DOC_CUSTODY_SUPP = "supplier";
	public static String VISA_DOC_CUSTODY_OTH = "other";
	///////////////////////////////////////////////////////////////////
	
	public static String UDN_FLT_SRV_SUPP_NAME = "Flight";
	public static String UDN_HTL_SRV_SUPP_NAME = "Hotel";
	public static String UDN_INS_SRV_SUPP_NAME = "Insurance";
	public static String UDN_LDP_SRV_SUPP_NAME = "Land-Package";
	public static String UDN_OTH_SRV_SUPP_NAME = "Others";
	public static String UDN_STS_SRV_SUPP_NAME = "Sight-Seeing";
	public static String UDN_TRN_SRV_SUPP_NAME = "Transfers";
	public static String UDN_VSA_SRV_SUPP_NAME = "Visa";
	
	
	public static List UDN_SRV_SUPP_NAME_LIST = new ArrayList<String>() {{
		   add(UDN_FLT_SRV_SUPP_NAME);
		   add(UDN_HTL_SRV_SUPP_NAME);
		   add(UDN_INS_SRV_SUPP_NAME);
		   add(UDN_LDP_SRV_SUPP_NAME);
		   add(UDN_OTH_SRV_SUPP_NAME);
		   add(UDN_STS_SRV_SUPP_NAME);
		   add(UDN_TRN_SRV_SUPP_NAME);
		   add(UDN_VSA_SRV_SUPP_NAME);
		}}; 
	
	///////////////////////////////////////////////////////////////////
	
	public static List MEAL_PLANS_LIST = new ArrayList<String>() {{
		   add("CPAI");
		   add("MAPI");
		   add("APAI");
		   add("EPAI");
		}};
		
	static final Map<Integer, String> MEAL_PLANS_MAP = new HashMap<Integer, String>(){
			{
				put(1,"CPAI");
				put(2,"MAPI");
				put(3,"APAI");
				put(4,"EPAI");
			}
		}; 
	
			
	public static List INSURANCE_PROVIDERS= new ArrayList<String>() {{
			   add("ICICI-PRUD");
			   add("BHARTI-AXA");
			   add("TATA-AIG");
			   add("RELIANCE");
			   add("HDFC-ERGO");
			   add("BAJAJ-ALLIANZ");
			   add("ROYAL-SUNDARAM");
	}};
	
	public static List CURRENCY_LIST= new ArrayList<String>() {{
		   add("USD");
		   add("INR");
		   add("EUR");
		   add("SIN");
		   add("RBL");
		   add("CUD");
		   add("DNR");
	}};
	
	public static Map<Integer, String> INSURANCE_PROVIDERS_MAP= new HashMap<Integer,String>() {{
			put(1,"ICICI-PRUD");
			put(2,"BHARTI-AXA");
			put(3,"TATA-AIG");
			put(4,"RELIANCE");
			put(5,"HDFC-ERGO");
			put(6,"BAJAJ-ALLIANZ");
			put(7,"ROYAL-SUNDARAM");
	}};

	public static Map<Integer, String> CRUISE_STATE_ROOM_TYPE_MAP= new HashMap<Integer,String>() {{
		put(1,"STANDARD-ROOM");
		put(2,"OCEAN-VIEW");
		put(3,"BALCONY-ROOM");
		put(4,"INTERIOR-ROOM");
		put(5,"SUITE");
		put(6,"VERANDAH-ROOM");
	}};
	
	public static Map<Integer, String> CRUISE_PROVIDER_NAMES_MAP= new HashMap<Integer,String>() {{
		put(1,"OPENED-GOOD-CRUISE");
		put(2,"Royal-Caribbean");
		put(3,"Norwegian-Cruise-Line.");
		put(4,"MSC-Cruises");
		put(5,"Celebrity-Cruises");
		put(6,"Holland-America-Line");
	}};
	
	public static List LDP_TYPE= new ArrayList<String>() {{
		add("Group");
		add("FIT");
		add("MICE");
		add("Pilgrimage");
		add("Adventure");
		add("Wild-Life");
		add("Wellness Tourism");
		add("Medical Tourism");
	}};
	
	public static List TRN_TYPE= new ArrayList<String>() {{
		add("SIC");
		add("PVT");
		
	}};
	
	public static List TRANSFER_POINT= new ArrayList<String>() {{
		add("Airport");
		add("Accommodation");
		add("Port");
		add("Station");
	}};
	
	public static Map<Integer, String> TRANSFER_POINT_MAP= new HashMap<Integer,String>() {{
		put(1,"Airport");
		put(2,"Accommodation");
		put(3,"Port");
		put(4,"Station");
	}};

	public static Map<Integer, String> TRANSFER_TYPE_MODE= new HashMap<Integer,String>() {{
		put(1,"Private");
		put(2,"Shared");
		put(3,"Luxury");
		put(4,"Economical");
	}};
	
	
	 static final Map<Integer, String> VISA_PROFILE = new HashMap<Integer, String>(){
	        {
	            put(1,"Salaried");
	            put(2,"HouseWife");
	            put(3,"Business");
	            put(4,"Student");
	            put(5,"Retired");
	            put(6,"Sponsored");
	            put(7,"General");
	        }
	    };
	
	    
	 static final Map<String, String> EMP_TYPE = new HashMap<String, String>(){
		 {
	            put("Regular","Regular");
	            put("Contractual","Contractual");
	           
		 }
	 };
	    
	 static final Map<String, String> EMP_SHIFT = new HashMap<String, String>(){
	 	{
	 		put("Day1"," Day (Shift 1)");
	 		put("Night1","Night (Shift 2)");
	    	           
	    }
	 };   
	 
	 static final Map<String, String> MARITAL_STATUS = new HashMap<String, String>(){
		 	{
		 		put("Single","Single");
		 		put("Married","Married");
		 		put("Divorced","Divorced");
		 		put("Other","Other");
		    	           
		    }
		 }; 
	
	static final Map<String, String> GENDER = new HashMap<String, String>(){
		{
			put("Male","Male");
			put("Female","Female");
		}
	}; 
	
	static final Map<Boolean, String> ACTIVE= new HashMap<Boolean, String>(){
		{
			put(true,"True");
			put(false,"False");
		}
	}; 	
	
	public static int ROLE_ID_PRIV_ADMIN=1;
	public static int ROLE_ID_PRIV_USER=2;
	    /*public static List VISA_PROFILE = new ArrayList<String>() {{
		add("Salaried");
		add("HouseWife");
		add("Business");
		add("Student");
		add("Retired");
		add("Sponsored");
		add("General");
	}};*/

	    
	/*public static List VISA_TYPE = new ArrayList<String>() {{
		add("eVisa");
		add("Standard");
		add("PremiumVisa");
		
	}};
	*/


    static final Map<Integer, String> VISA_TYPE = new HashMap<Integer, String>(){
        {
            put(1,"eVisa");
            put(2,"Standard");
            put(3,"PremiumVisa");
        }
    };


/*	
    
	public static List VISA_PURPOSE = new ArrayList<String>() {{
		add("Tourist");
		add("Business");
		add("Student");
		add("Family");
		add("Employment");
	}};
	*/
	static final Map<Integer, String> VISA_PURPOSE = new HashMap<Integer, String>(){
        {
            put(1,"Tourist");
            put(2,"Business");
            put(3,"Student");
            put(4,"Family");
            put(5,"Employment");
            put(6,"Medical");
        }
    };

	
	public static String UDN_DEFAULT_VSA_DOC_STATUS_PENDING ="pending-client";
	public static List VISA_DOC_SL_STATUS = new ArrayList<String>() {{
		add("pending-client");
		add("pending-us");
		add("received");
		add("verified");
		add("accepted");
		add("collection-pending");
		add("collected");
		add("delivered-back");
		add("rejected");
	}};
	
	public static List VISA_DOC_CUSTODY = new ArrayList<String>() {{
		add("client");
		add("travel-governor");
		add("supplier");
		add("embassy");
		add("Do-Not-Exist");
		add("other");
	}};
	
	public static List FLT_TICKET_TYPE_LIST = new ArrayList<String>() {{
		add("Economy");
		add("PremiumEconomy");
		add("FirstClass");
		add("Business");
		add("other");
	}};
	

	public static int DEFAULT_PAGE_SIZE = 10;
	
	/*********************************************************************************/
	
	public String FRESH_DEAL_CONF_TEMPLATE_NAME = "Deal-Confirmation.ftl";
	
	/*********************************************************************************/

	public static List TASK_PRIORITY= new ArrayList<String>() {{
		add("Low");
		add("Medium");
		add("High");
	}};
	
	/****************************************Task Status********************************/
	public static List TASK_STATUS= new ArrayList<String>() {{
		add("Open");
		add("Closed");
	}};
	public static String TASK_OPEN_STATUS="Open";
	public static String TASK_CLOSED_STATUS="Closed";
	/*********************************************************************************/

	/*********************************************************************************/

	public static List TICKET_PRIORITY= new ArrayList<String>() {{
		add("Low");
		add("Medium");
		add("High");
	}};
	
	/****************************************Task Status********************************/
	public static List TICKET_STATUS= new ArrayList<String>() {{
		add("Open");
		add("Closed");
	}};
	public static String TICKET_OPEN_STATUS="Open";
	public static String TICKET_CLOSED_STATUS="Closed";
	/*********************************************************************************/

	
	public static List LEAD_STATUS= new ArrayList<String>() {{
		add("Open");
		add("Closed-Won");
		add("Closed-Lost");
	}};
	

	public static String LEAD_NEW ="0";
	public static String LEAD_WON_COST ="1";
	public static String LEAD_WON_SERVICE="2";
	public static String LEAD_WON_COST_SERVICE="3";
	public static String LEAD_WON_REFERENCE="4";
	public static String LEAD_WON_SALES_SKILLS="5";
	public static String LEAD_WON_ALL_REASONS="6";
	public static String LEAD_WON_OTHERS="7";
	public static String LEAD_LOST_COST="11";
	public static String LEAD_LOST_SALES_SKILLS="12";
	public static String LEAD_LOST_ALL_REASONS="13";
	public static String LEAD_LOST_OTHERS="14";
	

	
	// Following variables are declared for 
	static final Map<String, Integer> LEAD_CLOSE_REASON = new HashMap<String, Integer>(){
	
	        {
	            put(LEAD_NEW,0);
	            put(LEAD_WON_COST,1);
	            put(LEAD_WON_SERVICE,2);
	            put(LEAD_WON_COST_SERVICE,3);
	            put(LEAD_WON_REFERENCE,4);
	            put(LEAD_WON_SALES_SKILLS,5);
	            put(LEAD_WON_ALL_REASONS,6);
	            put(LEAD_WON_OTHERS,7);
	            put(LEAD_LOST_COST,11);
	            put(LEAD_LOST_SALES_SKILLS,12);
	            put(LEAD_LOST_ALL_REASONS,13);
	            put(LEAD_LOST_OTHERS,14);
	        }
	    };
	
	public static String JWT_SECRET_KEY ="bhagwaansabkibhalikarengesabkamaalikekjaishriramtravelgovernorhitho";
	
	
	/***************************** API RELATED CONSTANTS **************************************/
	static final Map<Integer,String> JPURNEY_TYPE = new HashMap<Integer,String>(){
        {
            put(1,"One Way");
            put(2,"Return");
            put(3,"Multi Stop");
            put(4,"Advance Search");
            put(5,"Special Return");
        }
	};
	static final Map<Integer,String> CABIN_CLASS = new HashMap<Integer,String>(){
        {
            put(1,"Economy");
            put(2,"PremiumEconomy");
            put(3,"Business");
            put(4,"PremiumBusiness");
            put(5,"First");
          //Cabin class (1 for All, 2 for Economy, 3 for PremiumEconomy, 4 for Business, 5 for PremiumBusiness, 6 for First)
        }
	};

	/*****************************************************************************************/
	 static final Map<Integer, String> SUPPLIER_RATING_MAP = new HashMap<Integer, String>(){
	        {
	            put(1,"1 Star");
	            put(2,"2 Star");
	            put(3,"3 Star");
	            put(4,"4 Star");
	            put(5,"5 Star");
	        }
	    };

	static final Map<Boolean, String> SUPPLIER_NEGOTIATES= new HashMap<Boolean, String>(){
			{
				put(false,"False");
				put(true,"True");
			}
	}; 	

	//Destination special city codes
	public static final int DESTINATION_ALL_CITIES = 50000;
	public static final String DEFAULT_DESTINATION_INDIA_CTRY_CODE="IND";
	public static final String DEFAULT_DESTINATION_INDIA_CTRY_NAME="India";
	public static final String DESTINATION_ALL_CTRY_CODE="ALL";
	
	// Following variables are declared for 
	static final Map<String, Integer> QUOTATION_STATUS = new HashMap<String, Integer>(){
		{
	        put("QUOTATION_WIP",0);
	        put("QUOTATION_WON_CLOSED",1);
	        put("QUOTATION_REJECTED_CLOSED",2);
	    }
	};
	
	/**************** Reminder Service *******************************/
	public final static String QUERY_REMINDER_MESSAGE = "QUERY_REMINDER_MESSAGE";
	public final static String QUERY_REGISTRATION_MSG = "QUERY_REGISTRATION_MSG";
	
	/****************************************************************/
	
}
