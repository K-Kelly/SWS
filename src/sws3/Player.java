package sws3;

import java.util.ArrayList;

public class Player implements Comparable{
	private static int nextID=1;//keeps track of the player id
	private int id;
	private String scoutLine8,scoutLine9,scoutLine10,line13,fName,lName,line15,line16,line18,line19;
	private int curSHO,curPLA,curSTK,curCHK,curPOS,curHIT,curSKA,curEND,PEN,curFAC,
	LEA,curSTR,POT,CON,GRD,curFGT,CLK,TEAM,POSI,country,handed,
	bYear,bDay,bMonth,salary,contractYr,draftYr,draftRd,draftTeam,rights,
	wGames,wGoals,wAssists,wGWG,
	mGames,mGoals,mAssists,mGWG,
	goals,assists,points,NTC,twoWay,options,
	pStatus,rookie,offerData,offerTeam,timeConsidering,injuryType,
	//scoutLine8,scoutLine9,scoutLine10 which are Strings
	streakG,streakP,streakGP,suspendedGames,training,weight,height,orgStatus,
	bStreakGP,bStreakGWG,bStreakAssists,bStreakPoints,bStreakGoals,
	//line13,fName,lName,line15,line16 which are Strings
	ceilFGT,ceilSHO,ceilPLA,ceilSTK,ceilCHK,ceilPOS,ceilHIT,ceilSKA,ceilEND,ceilPEN,ceilFAC,ceilLEA,ceilSTR,
	//line18,line19 which are Strings
	attitude,altPOSI,nhlRights,injProne,overallDraft;
	//end players file
	double age;
	int OA,pSHO,pPLA,pSTK,pCHK,pPOS,pHIT,pSKA,pFAC,pSTR,pFGT,pOA,
	TRO,TRD,TROA;//training offense, defense, overall
	String hand,sCountry;
	int pOFF,pDF,farmOF,farmDF,farmOA;//projected offense, projected defense
	private ArrayList<Integer> forGUI=new ArrayList<Integer>();//for gui

	public Player(int curSHO,int curPLA,int curSTK, int curCHK, int curPOS,int curHIT, int curSKA, int curEND,int PEN, int curFAC,
			int LEA, int curSTR,int POT, int CON, int GRD, int curFGT, int CLK, int TEAM,int POSI, int country, int handed,
			int bYear, int bDay, int bMonth, int salary, int contractYr, int draftYr, int draftRd, int draftTeam, int rights,
			int wGames, int wGoals, int wAssists, int wGWG, int mGames, int mGoals, int mAssists, int mGWG,
			int goals, int assists, int points, int NTC, int twoWay, int options,
			int pStatus, int rookie, int offerData, int offerTeam, int timeConsidering, int injuryType,
			String scoutLine8, String scoutLine9, String scoutLine10,
			int streakG, int streakP, int streakGP, int suspendedGames, int training, int weight, int height, int orgStatus,
			int bStreakGP, int bStreakGWG, int bStreakAssists, int bStreakPoints,int bStreakGoals,
			String line13,String fName, String lName, String line15,String line16,
			int ceilFGT, int ceilSHO, int ceilPLA, int ceilSTK, int ceilCHK, int ceilPOS, int ceilHIT, int ceilSKA, int ceilEND, int ceilPEN, int ceilFAC, int ceilLEA, int ceilSTR,
			String line18, String line19,
			int attitude, int altPOSI, int nhlRights, int injProne, int overallDraft,
			//non player file instance variables
			double age
	){ 
		id=nextID;
                nextID++;
		this.curSHO=curSHO;this.curPLA=curPLA;this.curSTK=curSTK;this.curCHK=curCHK;this.curPOS=curPOS;this.curHIT=curHIT;this.curSKA=curSKA;this.curEND=curEND;this.PEN=PEN;this.curFAC=curFAC;
		this.LEA=LEA;this.curSTR=curSTR;this.POT=POT;this.CON=CON;this.GRD=GRD;this.curFGT=curFGT;this.CLK=CLK;this.TEAM=TEAM;this.POSI=POSI;this.country=country;this.handed=handed;
		this.bYear=bYear;this.bDay=bDay;this.bMonth=bMonth;this.salary=salary;this.contractYr=contractYr;this.draftYr=draftYr;this.draftRd=draftRd;this.draftTeam=draftTeam;this.rights=rights;
		this.wGames=wGames;this.wGoals=wGoals;this.wAssists=wAssists;this.wGWG=wGWG;this.mGames=mGames;this.mGoals=mGoals;this.mAssists=mAssists;this.mGWG=mGWG;
		this.goals=goals;this.assists=assists;this.points=points;this.NTC=NTC;this.twoWay=twoWay;this.options=options;
		this.pStatus=pStatus;this.rookie=rookie;this.offerData=offerData;this.offerTeam=offerTeam;this.timeConsidering=timeConsidering;this.injuryType=injuryType;
		this.scoutLine8=scoutLine8;this.scoutLine9=scoutLine9;this.scoutLine10=scoutLine10;
		this.streakG=streakG;this.streakP=streakP;this.streakGP=streakGP;this.suspendedGames=suspendedGames;this.training=training;this.weight=weight;this.height=height;this.orgStatus=orgStatus;
		this.bStreakGP=bStreakGP;this.bStreakGWG=bStreakGWG;this.bStreakAssists=bStreakAssists;this.bStreakPoints=bStreakPoints;this.bStreakGoals=bStreakGoals;
		this.line13=line13;this.fName=fName;this.lName=lName;this.line15=line15;this.line16=line16;
		this.ceilFGT=ceilFGT;this.ceilSHO=ceilSHO;this.ceilPLA=ceilPLA;this.ceilSTK=ceilSTK;this.ceilCHK=ceilCHK;this.ceilPOS=ceilPOS;this.ceilHIT=ceilHIT;this.ceilSKA=ceilSKA;this.ceilEND=ceilEND;this.ceilPEN=ceilPEN;this.ceilFAC=ceilFAC;this.ceilLEA=ceilLEA;this.ceilSTR=ceilSTR;
		this.line18=line18;this.line19=line19;
		this.attitude=attitude;this.altPOSI=altPOSI;this.nhlRights=nhlRights;this.injProne=injProne;this.overallDraft=overallDraft;
		forGUI.add(curSHO);forGUI.add(curPLA);forGUI.add(curSTK);forGUI.add(curCHK);forGUI.add(curPOS);forGUI.add(curHIT);forGUI.add(curSKA);forGUI.add(curEND);forGUI.add(PEN);forGUI.add(curFAC);
		forGUI.add(LEA);forGUI.add(curSTR);forGUI.add(POT);forGUI.add(CON);forGUI.add(GRD);forGUI.add(curFGT);forGUI.add(CLK);forGUI.add(TEAM);forGUI.add(POSI);//want String values of country and handed
		forGUI.add(bYear);forGUI.add(bDay);forGUI.add(bMonth);forGUI.add(salary);forGUI.add(contractYr);forGUI.add(draftYr);forGUI.add(draftRd);forGUI.add(draftTeam);//not rights
		//streaks,records, and other stats with be displayed in a stats list
		forGUI.add(NTC);forGUI.add(twoWay);forGUI.add(options);//might remove options later.
		forGUI.add(pStatus);forGUI.add(offerData);forGUI.add(offerTeam);forGUI.add(timeConsidering);//want String Value of Injury Type;
		//don't want scoutLines
		//fName and lName are Strings
		forGUI.add(ceilFGT);forGUI.add(ceilSHO);forGUI.add(ceilPLA);forGUI.add(ceilSTK);forGUI.add(ceilCHK);forGUI.add(ceilPOS);forGUI.add(ceilHIT);forGUI.add(ceilSKA);forGUI.add(ceilSKA);forGUI.add(ceilEND);forGUI.add(ceilPEN);forGUI.add(ceilFAC);forGUI.add(ceilLEA);forGUI.add(ceilSTR);
		forGUI.add(attitude);forGUI.add(altPOSI);forGUI.add(nhlRights);forGUI.add(injProne);forGUI.add(overallDraft);
		//
		this.age=age;	
		OA=0;pSHO=(POT*ceilSHO)/100;pPLA=(POT*ceilPLA)/100;pSTK=(POT*ceilSTK)/100;pCHK=(POT*ceilCHK)/100;pPOS=(POT*ceilPOS)/100;pSKA=(POT*ceilSKA)/100;pFAC=(POT*ceilFAC)/100;pSTR=(POT*ceilSTR)/100;pFGT=(POT*ceilFGT)/100;pOA=0;
		pHIT=0;TRO=0;TRD=0;TROA=0;
		hand="";sCountry="";
		pOFF=-1;pDF=-1;
	}
	public int getFarmOFF() {
		int sho = this.getCurSHO(); int pla = this.getCurPLA(); int stk = this.getCurSTK();
		if ((sho >= 76) && (this.getpSHO() <= 76))
			sho = 76;
		else if (this.getpSHO() >= 76)
			sho = this.getpSHO();
		if ((pla >= 76) && (this.getpPLA() <= 76))
			pla = 76;
		else if (this.getpPLA() >= 76)
			pla = this.getpPLA();
		if ((stk >= 76) && (this.getpSTK() <= 76))
			stk = 76;
		else if (this.getpSTK() >= 76)
			stk = this.getpSTK();
		return (sho + pla + stk) / 3;
	}
	public int getFarmDF() {
		int chk = this.getCurCHK(); int pos = this.getCurPOS(); int hit = this.getCurHIT();
		if ((chk >= 76) && (this.getCurCHK() <= 76))
			chk = 76;
		else if (this.getCurCHK()  >= 76)
			chk = this.getCurCHK();
		if ((pos >= 76) && (this.getCurPOS()  <= 76))
			pos = 76;
		else if (this.getCurPOS() >= 76)
			pos = this.getCurPOS();
		if ((hit > 76) && (this.getCurHIT() <= 76))
			hit = 76;
		else if (this.getCurHIT() >= 76)
			hit = this.getCurHIT();
		return (chk + pos + hit) / 3;
	}
	public int getFarmOA() {
		int ska = this.getpSKA(); int end = this.getCurEND(); int fac = this.getCurFAC(); int lea = this.getLEA(); int str = this.getpSTR();
		if (ska > 99)
			ska = 99;
		if (end > 99)
			end = 99;
		if (fac > 76)
			fac = 76;
		if (lea > 99)
			lea = 99;
		if (str > 99)
			str = 99;
		return (getFarmOFF() + getFarmDF()) / 2;
	}
	/**
	 * Projected Defense
	 * @return
	 */
	public int getpDF() {
		return (getpCHK()+getpPOS()+this.getpHIT())/3;
	}

	public void setpDF(int pDF) {
		this.pDF = pDF;
	}
	/**
	 * Projected Offense
	 * @return
	 */
	public int getpOFF() {
		return (getpSHO()+getpPLA()+getpSTK())/3;
	}

	public void setpOFF(int pOFF) {
		this.pOFF = pOFF;
	}

	/**Converts country from int to String
	 * @return the sCountry   The string form of country
	 */
	public String getsCountry() {
		if (country==1) return "Canada";
		else if (country ==2) return "USA";
		else if (country==3)return "Russia";
		else if (country==4) return "Czech Republic";
		else if (country==5) return "Sweden";
		else if (country==6) return "Finland";
		else if (country==7) return "Belarussia";
		else if (country==8) return "Slovakia";
		else if (country==9) return "Norway";
		else if (country==10) return "Germany";
		else if (country==11) return "No Country";
		else if (country==12) return "Italy";
		else if (country==13) return "Austria";
		else if (country==14) return "Latvia";
		else if (country==15) return "Ukraine";
		else if (country==16) return "Slovenia";
		else if (country==17) return "Switzerland";
		else if (country==18) return "Poland";
		else if (country==19) return "France";
		else if (country==20) return "Japan";
		else return "ERROR";
	}

	/**
	 * Converts main position from int to String
	 * @return A String value of the main position
	 */
	public String getStringPosition(){
		{if (POSI == 1) 
		{ return "G"; }
		else if (POSI == 2)
		{ return  "D"; }
		else if (POSI == 3) 
		{ return "L"; }
		else if (POSI == 4) 
		{ return  "C"; }
		else if (POSI == 5)
		{ return  "R";}
		else
			return  "ERROR-MAIN POSITION NOT FOUND";}
	}
	/**Converts alternate position from int to String
	 * 
	 * @return A String value of the alternate position
	 */
	public String getStringAlternatePosition(){
		if (altPOSI==0)
			return "NO";	
		else if (altPOSI == 1) 
		{ return "G"; }
		else if (altPOSI == 2)
		{ return  "D"; }
		else if (altPOSI == 3) 
		{ return "L"; }
		else if (altPOSI == 4) 
		{ return  "C"; }
		else if (altPOSI == 5)
		{ return  "R";}
		else
			return  "ERROR-Alternate POSITION NOT FOUND";
	}


	/**
	 * Converts height from int to String
	 * @return String version of height
	 */
	public String getStringHeight() {
		if (height == 0)
			return "5-5";
		if (height== 1)
			return "5-6";
		if (height == 2)
			return "5-7";
		if (height == 3)
			return "5-8";
		if (height == 4)
			return "5-9";
		if (height == 5)
			return "5-10";
		if (height == 6)
			return "5-11";
		if (height == 7)
			return "6-0";
		if (height == 8)
			return "6-1";
		if (height == 9)
			return "6-2";
		if (height == 10)
			return "6-3";
		if (height == 11)
			return "6-4";
		if (height == 12)
			return "6-5";
		if (height == 13)
			return "6-6";
		if (height == 14)
			return "6-7";
		if (height == 15)
			return "6-8";
		if (height == 16)
			return "6-9";
		if (height == 17)
			return "6-10";
		if (height == 18)
			return "6-11";
		if (height == 19) {
			return "7-0";
		}
		return "???";
	}

	public String playerType(){
		String p1=getStringPosition();
		String type="";
		if(p1.equalsIgnoreCase("G"))
			return type="Goalie";
		else if(p1.equalsIgnoreCase("D")){
			switch(POT%10){
			case 0: type="Goon"; break;
			case 1: type="FDefensive-D"; break;
			case 2: type="FDefensive-D"; break;
			case 3: type="FDefensive-D"; break;
			case 4: type="FDefensive-D"; break;
			case 5: type="FDefensive-D"; break;
			case 6: type="Defensive-D"; break;
			case 7: type="Physical-D"; break;
			case 8: type="Offensive-D"; break;
			case 9: type="Character"; break;
			default: type="ERROR"; break;
			}
			return type;
		}
		else if(p1.equalsIgnoreCase("R")){
			switch(POT%10){
			case 0: type="Goon"; break;
			case 1: type="Sniper"; break;
			case 2: type="Playmaker"; break;
			case 3: type="All-around"; break;
			case 4: type="Power"; break;
			case 5: type="Two-way";break;
			case 6: type="fAll-around"; break;
			case 7: type="fAll-around"; break;
			case 8: type="fAll-around"; break;
			case 9: type="Character"; break;
			default: type="ERROR"; break;
			}
			return type;
		}
		else if(p1.equalsIgnoreCase("C")){
			switch(POT%10){
			case 0: type="Goon"; break;
			case 1: type="Sniper"; break;
			case 2: type="Playmaker"; break;
			case 3: type="All-around"; break;
			case 4: type="Power"; break;
			case 5: type="Two-way";break;
			case 6: type="fAll-around"; break;
			case 7: type="fAll-around"; break;
			case 8: type="fAll-around"; break;
			case 9: type="Character"; break;
			default: type="ERROR"; break;
			}
			return type;
		}
		else if(p1.equalsIgnoreCase("L")){
			switch(POT%10){
			case 0: type="Goon"; break;
			case 1: type="Sniper"; break;
			case 2: type="Playmaker"; break;
			case 3: type="All-around"; break;
			case 4: type="Power"; break;
			case 5: type="Two-way";break;
			case 6: type="fAll-around"; break;
			case 7: type="fAll-around"; break;
			case 8: type="fAll-around"; break;
			case 9: type="Character"; break;
			default: type="ERROR"; break;
			}
			return type;
		}
		else
			return type="error";
	}
	public String playerType2(){
		String p1=getStringPosition();
		String p2= getStringAlternatePosition();
		String type="";
		if((p1.equalsIgnoreCase("C")&& (p2.equalsIgnoreCase("L")||p2.equalsIgnoreCase("R")))){
			return type="S";
		}
		else if((p1.equalsIgnoreCase("L")&& (p2.equalsIgnoreCase("C")||p2.equalsIgnoreCase("R")))){
			return type="S";
		}
		else if((p1.equalsIgnoreCase("R")&& (p2.equalsIgnoreCase("L")||p2.equalsIgnoreCase("C")))){
			return type="S";
		}
		else if(p1.equalsIgnoreCase("G"))
			return type="Goalie";
		else if(p1.equalsIgnoreCase("D")){
			switch(POT%10){
			case 0: type="Goon"; break;
			case 1: type="FDefensive-D"; break;
			case 2: type="FDefensive-D"; break;
			case 3: type="FDefensive-D"; break;
			case 4: type="FDefensive-D"; break;
			case 5: type="FDefensive-D"; break;
			case 6: type="Defensive-D"; break;
			case 7: type="Physical-D"; break;
			case 8: type="Offensive-D"; break;
			case 9: type="Character"; break;
			default: type="ERROR"; break;
			}
			return type;
		}
		else if(((p1.equalsIgnoreCase("R")||p1.equalsIgnoreCase("C"))||p1.equalsIgnoreCase("L"))){
			switch(POT%10){
			case 0: type="Goon"; break;
			case 1: type="Sniper"; break;
			case 2: type="Playmaker"; break;
			case 3: type="All-around"; break;
			case 4: type="Power"; break;
			case 5: type="Two-way";break;
			case 6: type="fAll-around"; break;
			case 7: type="fAll-around"; break;
			case 8: type="fAll-around"; break;
			case 9: type="Character"; break;
			default: type="ERROR"; break;
			}
			return type;
		}
		else if(p1.equalsIgnoreCase("NO"))
			return type="S";
		else
			return type="error";
	}
	public String getDraftTeamString(){
		if (draftTeam== 99)
			return "DFT";
		if (draftTeam== 98)
			return "FA";
		if (draftTeam== 1)
			return "ANA";
		if (draftTeam== 2)
			return "ATL";
		if (draftTeam== 3)
			return "BOS";
		if (draftTeam== 4)
			return "BUF";
		if (draftTeam== 5)
			return "CGY";
		if (draftTeam== 6)
			return "CAR";
		if (draftTeam== 7)
			return "CHI";
		if (draftTeam== 8)
			return "COL";
		if (draftTeam== 9)
			return "CBS";
		if (draftTeam== 10)
			return "DAL";
		if (draftTeam== 11)
			return "DET";
		if (draftTeam== 12)
			return "EDM";
		if (draftTeam== 13)
			return "FLA";
		if (draftTeam== 14)
			return "LA";
		if (draftTeam== 15)
			return "MIN";
		if (draftTeam== 16)
			return "MTL";
		if (draftTeam== 17)
			return "NYI";
		if (draftTeam== 18)
			return "NYR";
		if (draftTeam== 19)
			return "NSH";
		if (draftTeam== 20)
			return "NJ";
		if (draftTeam== 21)
			return "OTT";
		if (draftTeam== 22)
			return "PHI";
		if (draftTeam== 23)
			return "PHO";
		if (draftTeam== 24)
			return "PIT";
		if (draftTeam== 25)
			return "SJ";
		if (draftTeam== 26)
			return "STL";
		if (draftTeam== 27)
			return "TB";
		if (draftTeam== 28)
			return "TOR";
		if (draftTeam== 29)
			return "VAN";
		if (draftTeam== 30)
			return "WSH";
		if (draftTeam== 0)
			return "Not Drafted";

		return "TEAM NOT FOUND";
	}

	/**
	 * @param sCountry the sCountry to set
	 */

	/**
	 * @return the oA
	 */
	public int getOA() {
		this.OA=(((curSHO+curPLA+curSTK)/3)+((curPOS+curCHK+curHIT)/3))/2;
		return OA;
	}
	public int getOffense(){
		return ((curSHO+curPLA+curSTK)/3);
	}
	public int getDefense(){
		return ((curPOS+curCHK+curHIT)/3);
	}

	public ArrayList<Player> getClosePlayerMatches(ArrayList<Player>allPlayers){
		ArrayList<Player>matches=new ArrayList<Player>();
		for(Player p:allPlayers){
			if (p.getPOT()==this.getPOT()&&p.getCON()==this.getCON()&&!(this.getFullName().equalsIgnoreCase(p.getFullName())))
				matches.add(p); 
			// if(Math.abs(p.getpSHO()-pSHO)<4&&Math.abs(p.getpPLA()-pPLA)<4&&Math.abs(p.getpSTK()-pSTK)<4&&Math.abs(p.getpCHK()-pCHK)<4&&Math.abs(p.getpPOS()-pPOS)<4&&Math.abs(p.getpHIT()-pHIT)<4)
			//	 matches.add(p);
		}
		return matches;
	}

	/**
	 * @return the hand
	 */
	public String getHand() {
		if (handed==0)
			hand="R";
		else if (handed==1)
			hand="L";
		else
			hand="ERROR";
		return hand;
	}

	/**
	 * @param hand the hand to set
	 */
	public void setHand(String hand) {
		this.hand = hand;
	}

	/**Calculates projected total
	 * @return the pOA
	 */
	public int getpOA() {
		return pSHO+pPLA+pSTK+pPOS+pCHK+getpHIT();
	}

	/**Calculates training offense.
	 * @return the tRO
	 */
	public int getTRO() {
		int sho = pSHO; int pla = pPLA; int stk = pSTK;
		if (sho > 99)
			sho = 99;
		if (pla > 99)
			pla = 99;
		if (stk > 99)
			stk = 99;
		if((stk>(POT+10))&& POT<80){
			TRO=(sho+pla+POT)/3;
			return (sho+pla+POT)/3; //new
		}
		if (stk <= POT && POT<83) {
			TRO=(sho + pla + POT) / 3;
			return (sho + pla + POT) / 3;
		}
		else if(stk<=POT){
			TRO=(sho+pla+83)/3;
			return (sho+pla+83)/3;
		}
		TRO=(sho + pla + stk) / 3;
		return (sho + pla + stk) / 3;

	}

	/**Calculates training defense
	 * @return the tRD
	 */
	public int getTRD() {
		int pos = pPOS; int chk = pCHK; int hit = getpHIT();
		if (pos > 99)
			pos = 99;
		if (chk > 99)
			chk = 99;
		if (hit > 99)
			hit = 99;

		if((pos>(POT+10)&& POT<80))
			pos = POT;
		if(((chk>(POT+10))&& POT<80))
			chk= POT;

		if ((pos < POT) && (chk < POT)){
			if(POT<83){
				TRD=(POT + POT + hit) / 3;
				return (POT + POT + hit) / 3;}
			else{
				TRD=(83+83+hit)/3;
				return (83+83+hit)/3;}
		}
		if ((pos < POT) && (chk >= POT)){
			if(POT<83){
				TRD=(POT + chk + hit) / 3;
				return (POT + chk + hit) / 3;}
			else{
				TRD=(83+chk+hit)/3;
				return(83+chk+hit)/3;}
		}
		if ((pos >= POT) && (chk < POT)) {
			if(POT<83){
				TRD=(pos + POT + hit) / 3;
				return (pos + POT + hit) / 3;}
			else{
				TRD=(pos+83+hit)/3;
				return (pos+83+hit)/3;}
		}
		TRD=(pos + chk + hit) / 3;
		return (pos + chk + hit) / 3;
	}

	/**Calculates overall training
	 * @return the tROA
	 */
	public int getTROA() {
		return (TRD+TRO)/2;
	}

	/**
	 * @return the age
	 */
	public double getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(double age) {
		this.age = age;
	}

	/**
	 * @return the pSHO
	 */
	public int getpSHO() {
		if (pSHO>99)
			return 99;		
		return pSHO;
	}

	/**
	 * @param pSHO the pSHO to set
	 */
	public void setpSHO(int pSHO) {
		this.pSHO = pSHO;
	}

	/**
	 * @return the pPLA
	 */
	public int getpPLA() {
		if (pPLA>99)
			return 99;	
		return pPLA;
	}

	/**
	 * @param pPLA the pPLA to set
	 */
	public void setpPLA(int pPLA) {
		this.pPLA = pPLA;
	}

	/**
	 * @return the pSTK
	 */
	public int getpSTK() {
		if (pSTK>99)
			return 99;	
		return pSTK;
	}

	/**
	 * @param pSTK the pSTK to set
	 */
	public void setpSTK(int pSTK) {
		
		this.pSTK = pSTK;
	}

	/**
	 * @return the pCHK
	 */
	public int getpCHK() {
		if (pCHK>99)
			return 99;	
		return pCHK;
	}

	/**
	 * @param pCHK the pCHK to set
	 */
	public void setpCHK(int pCHK) {
		this.pCHK = pCHK;
	}

	/**
	 * @return the pPOS
	 */
	public int getpPOS() {
		if (pPOS>99)
			return 99;	
		return pPOS;
	}

	/**
	 * @param pPOS the pPOS to set
	 */
	public void setpPOS(int pPOS) {
		this.pPOS = pPOS;
	}

	/**
	 * @return the pHIT
	 */
	public int getpHIT() {
		if ((height <= 2) && (getCeilHIT() > 40))
			return 40 * POT / 100;
		if ((height <= 6) && (getCeilHIT() > 70))
			return 70 * POT / 100;
		if ((height <= 8) && (getCeilHIT() > 90))
			return 90 * POT / 100;
		if (height> 9) {
			return getCeilHIT() * POT / 100;
		}
                int temp= getCeilHIT() * POT / 100;
                if (temp>99)
                    return 99;
		return temp;
	}

	/**
	 * @param pHIT the pHIT to set
	 */
	public void setpHIT(int pHIT) {
		this.pHIT = pHIT;
	}

	/**
	 * @return the pSKA
	 */
	public int getpSKA() {
		if (pSKA>99)
			return 99;	
		return pSKA;
	}

	/**
	 * @param pSKA the pSKA to set
	 */
	public void setpSKA(int pSKA) {
		this.pSKA = pSKA;
	}

	/**
	 * @return the pFAC
	 */
	public int getpFAC() {
		if (pFAC>99)
			return 99;	
		return pFAC;
	}

	/**
	 * @param pFAC the pFAC to set
	 */
	public void setpFAC(int pFAC) {
		this.pFAC = pFAC;
	}

	/**
	 * @return the pSTR
	 */
	public int getpSTR() {
		if (pSTR>99)
			return 99;	
		return pSTR;
	}

	/**
	 * @param pSTR the pSTR to set
	 */
	public void setpSTR(int pSTR) {
		this.pSTR = pSTR;
	}

	/**
	 * @return the pFGT
	 */
	public int getpFGT() {
		if (pFGT>99)
			return 99;	
		return pFGT;
	}

	/**
	 * @param pFGT the pFGT to set
	 */
	public void setpFGT(int pFGT) {
		this.pFGT = pFGT;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/**
	 * @return the nextID
	 */
	public static int getNextID() {
		return nextID;
	}

	/**
	 * @param nextID the nextID to set
	 */
	public static void setNextID(int nextID) {
		Player.nextID = nextID;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the scoutLine8
	 */
	public String getScoutLine8() {
		return scoutLine8;
	}

	/**
	 * @param scoutLine8 the scoutLine8 to set
	 */
	public void setScoutLine8(String scoutLine8) {
		this.scoutLine8 = scoutLine8;
	}

	/**
	 * @return the scoutLine9
	 */
	public String getScoutLine9() {
		return scoutLine9;
	}

	/**
	 * @param scoutLine9 the scoutLine9 to set
	 */
	public void setScoutLine9(String scoutLine9) {
		this.scoutLine9 = scoutLine9;
	}

	/**
	 * @return the scoutLine10
	 */
	public String getScoutLine10() {
		return scoutLine10;
	}

	/**
	 * @param scoutLine10 the scoutLine10 to set
	 */
	public void setScoutLine10(String scoutLine10) {
		this.scoutLine10 = scoutLine10;
	}

	/**
	 * @return the line13
	 */
	public String getLine13() {
		return line13;
	}

	/**
	 * @param line13 the line13 to set
	 */
	public void setLine13(String line13) {
		this.line13 = line13;
	}

	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}

	/**
	 * @return the line15
	 */
	public String getLine15() {
		return line15;
	}

	/**
	 * @param line15 the line15 to set
	 */
	public void setLine15(String line15) {
		this.line15 = line15;
	}

	/**
	 * @return the line16
	 */
	public String getLine16() {
		return line16;
	}

	/**
	 * @param line16 the line16 to set
	 */
	public void setLine16(String line16) {
		this.line16 = line16;
	}

	/**
	 * @return the line18
	 */
	public String getLine18() {
		return line18;
	}

	/**
	 * @param line18 the line18 to set
	 */
	public void setLine18(String line18) {
		this.line18 = line18;
	}

	/**
	 * @return the line19
	 */
	public String getLine19() {
		return line19;
	}

	/**
	 * @param line19 the line19 to set
	 */
	public void setLine19(String line19) {
		this.line19 = line19;
	}

	/**
	 * @return the curSHO
	 */
	public int getCurSHO() {
		return curSHO;
	}

	/**
	 * @param curSHO the curSHO to set
	 */
	public void setCurSHO(int curSHO) {
		this.curSHO = curSHO;
	}

	/**
	 * @return the curPLA
	 */
	public int getCurPLA() {
		return curPLA;
	}

	/**
	 * @param curPLA the curPLA to set
	 */
	public void setCurPLA(int curPLA) {
		this.curPLA = curPLA;
	}

	/**
	 * @return the curSTK
	 */
	public int getCurSTK() {
		return curSTK;
	}

	/**
	 * @param curSTK the curSTK to set
	 */
	public void setCurSTK(int curSTK) {
		this.curSTK = curSTK;
	}

	/**
	 * @return the curCHK
	 */
	public int getCurCHK() {
		return curCHK;
	}

	/**
	 * @param curCHK the curCHK to set
	 */
	public void setCurCHK(int curCHK) {
		this.curCHK = curCHK;
	}

	/**
	 * @return the curPOS
	 */
	public int getCurPOS() {
		return curPOS;
	}

	/**
	 * @param curPOS the curPOS to set
	 */
	public void setCurPOS(int curPOS) {
		this.curPOS = curPOS;
	}

	/**
	 * @return the curHIT
	 */
	public int getCurHIT() {
		return curHIT;
	}

	/**
	 * @param curHIT the curHIT to set
	 */
	public void setCurHIT(int curHIT) {
		this.curHIT = curHIT;
	}

	/**
	 * @return the curSKA
	 */
	public int getCurSKA() {
		return curSKA;
	}

	/**
	 * @param curSKA the curSKA to set
	 */
	public void setCurSKA(int curSKA) {
		this.curSKA = curSKA;
	}

	/**
	 * @return the curEND
	 */
	public int getCurEND() {
		return curEND;
	}

	/**
	 * @param curEND the curEND to set
	 */
	public void setCurEND(int curEND) {
		this.curEND = curEND;
	}

	/**
	 * @return the pEN
	 */
	public int getPEN() {
		return PEN;
	}

	/**
	 * @param pEN the pEN to set
	 */
	public void setPEN(int pEN) {
		PEN = pEN;
	}

	/**
	 * @return the curFAC
	 */
	public int getCurFAC() {
		return curFAC;
	}

	/**
	 * @param curFAC the curFAC to set
	 */
	public void setCurFAC(int curFAC) {
		this.curFAC = curFAC;
	}

	/**
	 * @return the lEA
	 */
	public int getLEA() {
		return LEA;
	}

	/**
	 * @param lEA the lEA to set
	 */
	public void setLEA(int lEA) {
		LEA = lEA;
	}

	/**
	 * @return the curSTR
	 */
	public int getCurSTR() {
		return curSTR;
	}

	/**
	 * @param curSTR the curSTR to set
	 */
	public void setCurSTR(int curSTR) {
		this.curSTR = curSTR;
	}

	/**
	 * @return the pOT
	 */
	public int getPOT() {
		return POT;
	}

	/**
	 * @param pOT the pOT to set
	 */
	public void setPOT(int pOT) {
		POT = pOT;
	}

	/**
	 * @return the cON
	 */
	public int getCON() {
		return CON;
	}

	/**
	 * @param cON the cON to set
	 */
	public void setCON(int cON) {
		CON = cON;
	}

	/**
	 * @return the gRD
	 */
	public int getGRD() {
		return GRD;
	}

	/**
	 * @param gRD the gRD to set
	 */
	public void setGRD(int gRD) {
		GRD = gRD;
	}

	/**
	 * @return the curFGT
	 */
	public int getCurFGT() {
		return curFGT;
	}

	/**
	 * @param curFGT the curFGT to set
	 */
	public void setCurFGT(int curFGT) {
		this.curFGT = curFGT;
	}

	/**
	 * @return the cLK
	 */
	public int getCLK() {
		return CLK;
	}

	/**
	 * @param cLK the cLK to set
	 */
	public void setCLK(int cLK) {
		CLK = cLK;
	}

	/**
	 * @return the tEAM
	 */
	public int getTEAM() {
		return TEAM;
	}

	/**
	 * @param tEAM the tEAM to set
	 */
	public void setTEAM(int tEAM) {
		TEAM = tEAM;
	}

	/**
	 * @return the pOSI
	 */
	public int getPOSI() {
		return POSI;
	}

	/**
	 * @param pOSI the pOSI to set
	 */
	public void setPOSI(int pOSI) {
		POSI = pOSI;
	}

	/**
	 * @return the country
	 */
	public int getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(int country) {
		this.country = country;
	}

	/**
	 * @return the handed
	 */
	public int getHanded() {
		return handed;
	}

	/**
	 * @param handed the handed to set
	 */
	public void setHanded(int handed) {
		this.handed = handed;
	}

	/**
	 * @return the bYear
	 */
	public int getbYear() {
		return bYear;
	}

	/**
	 * @param bYear the bYear to set
	 */
	public void setbYear(int bYear) {
		this.bYear = bYear;
	}

	/**
	 * @return the bDay
	 */
	public int getbDay() {
		return bDay;
	}

	/**
	 * @param bDay the bDay to set
	 */
	public void setbDay(int bDay) {
		this.bDay = bDay;
	}

	/**
	 * @return the bMonth
	 */
	public int getbMonth() {
		return bMonth;
	}

	/**
	 * @param bMonth the bMonth to set
	 */
	public void setbMonth(int bMonth) {
		this.bMonth = bMonth;
	}

	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

	/**
	 * @return the contractYr
	 */
	public int getContractYr() {
		return contractYr;
	}

	/**
	 * @param contractYr the contractYr to set
	 */
	public void setContractYr(int contractYr) {
		this.contractYr = contractYr;
	}

	/**
	 * @return the draftYr
	 */
	public int getDraftYr() {
		return draftYr;
	}

	/**
	 * @param draftYr the draftYr to set
	 */
	public void setDraftYr(int draftYr) {
		this.draftYr = draftYr;
	}

	/**
	 * @return the draftRd
	 */
	public int getDraftRd() {
		return draftRd;
	}

	/**
	 * @param draftRd the draftRd to set
	 */
	public void setDraftRd(int draftRd) {
		this.draftRd = draftRd;
	}

	/**
	 * @return the draftTeam
	 */
	public int getDraftTeam() {
		return draftTeam;
	}

	/**
	 * @param draftTeam the draftTeam to set
	 */
	public void setDraftTeam(int draftTeam) {
		this.draftTeam = draftTeam;
	}

	/**
	 * @return the rights
	 */
	public int getRights() {
		return rights;
	}

	/**
	 * @param rights the rights to set
	 */
	public void setRights(int rights) {
		this.rights = rights;
	}

	/**
	 * @return the wGames
	 */
	public int getwGames() {
		return wGames;
	}

	/**
	 * @param wGames the wGames to set
	 */
	public void setwGames(int wGames) {
		this.wGames = wGames;
	}

	/**
	 * @return the wGoals
	 */
	public int getwGoals() {
		return wGoals;
	}

	/**
	 * @param wGoals the wGoals to set
	 */
	public void setwGoals(int wGoals) {
		this.wGoals = wGoals;
	}

	/**
	 * @return the wAssists
	 */
	public int getwAssists() {
		return wAssists;
	}

	/**
	 * @param wAssists the wAssists to set
	 */
	public void setwAssists(int wAssists) {
		this.wAssists = wAssists;
	}

	/**
	 * @return the wGWG
	 */
	public int getwGWG() {
		return wGWG;
	}

	/**
	 * @param wGWG the wGWG to set
	 */
	public void setwGWG(int wGWG) {
		this.wGWG = wGWG;
	}

	/**
	 * @return the mGames
	 */
	public int getmGames() {
		return mGames;
	}

	/**
	 * @param mGames the mGames to set
	 */
	public void setmGames(int mGames) {
		this.mGames = mGames;
	}

	/**
	 * @return the mGoals
	 */
	public int getmGoals() {
		return mGoals;
	}

	/**
	 * @param mGoals the mGoals to set
	 */
	public void setmGoals(int mGoals) {
		this.mGoals = mGoals;
	}

	/**
	 * @return the mAssists
	 */
	public int getmAssists() {
		return mAssists;
	}

	/**
	 * @param mAssists the mAssists to set
	 */
	public void setmAssists(int mAssists) {
		this.mAssists = mAssists;
	}

	/**
	 * @return the mGWG
	 */
	public int getmGWG() {
		return mGWG;
	}

	/**
	 * @param mGWG the mGWG to set
	 */
	public void setmGWG(int mGWG) {
		this.mGWG = mGWG;
	}

	/**
	 * @return the goals
	 */
	public int getGoals() {
		return goals;
	}

	/**
	 * @param goals the goals to set
	 */
	public void setGoals(int goals) {
		this.goals = goals;
	}

	/**
	 * @return the assists
	 */
	public int getAssists() {
		return assists;
	}

	/**
	 * @param assists the assists to set
	 */
	public void setAssists(int assists) {
		this.assists = assists;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * @return the nTC
	 */
	public int getNTC() {
		return NTC;
	}

	/**
	 * @param nTC the nTC to set
	 */
	public void setNTC(int nTC) {
		NTC = nTC;
	}

	/**
	 * @return the twoWay
	 */
	public int getTwoWay() {
		return twoWay;
	}

	/**
	 * @param twoWay the twoWay to set
	 */
	public void setTwoWay(int twoWay) {
		this.twoWay = twoWay;
	}

	/**
	 * @return the options
	 */
	public int getOptions() {
		return options;
	}

	/**
	 * @param options the options to set
	 */
	public void setOptions(int options) {
		this.options = options;
	}

	/**
	 * @return the pStatus
	 */
	public int getpStatus() {
		return pStatus;
	}

	/**
	 * @param pStatus the pStatus to set
	 */
	public void setpStatus(int pStatus) {
		this.pStatus = pStatus;
	}

	/**
	 * @return the rookie
	 */
	public int getRookie() {
		return rookie;
	}

	/**
	 * @param rookie the rookie to set
	 */
	public void setRookie(int rookie) {
		this.rookie = rookie;
	}

	/**
	 * @return the offerData
	 */
	public int getOfferData() {
		return offerData;
	}

	/**
	 * @param offerData the offerData to set
	 */
	public void setOfferData(int offerData) {
		this.offerData = offerData;
	}

	/**
	 * @return the offerTeam
	 */
	public int getOfferTeam() {
		return offerTeam;
	}

	/**
	 * @param offerTeam the offerTeam to set
	 */
	public void setOfferTeam(int offerTeam) {
		this.offerTeam = offerTeam;
	}

	/**
	 * @return the timeConsidering
	 */
	public int getTimeConsidering() {
		return timeConsidering;
	}

	/**
	 * @param timeConsidering the timeConsidering to set
	 */
	public void setTimeConsidering(int timeConsidering) {
		this.timeConsidering = timeConsidering;
	}

	/**
	 * @return the injuryType
	 */
	public int getInjuryType() {
		return injuryType;
	}

	/**
	 * @param injuryType the injuryType to set
	 */
	public void setInjuryType(int injuryType) {
		this.injuryType = injuryType;
	}

	/**
	 * @return the streakG
	 */
	public int getStreakG() {
		return streakG;
	}

	/**
	 * @param streakG the streakG to set
	 */
	public void setStreakG(int streakG) {
		this.streakG = streakG;
	}

	/**
	 * @return the streakP
	 */
	public int getStreakP() {
		return streakP;
	}

	/**
	 * @param streakP the streakP to set
	 */
	public void setStreakP(int streakP) {
		this.streakP = streakP;
	}

	/**
	 * @return the streakGP
	 */
	public int getStreakGP() {
		return streakGP;
	}

	/**
	 * @param streakGP the streakGP to set
	 */
	public void setStreakGP(int streakGP) {
		this.streakGP = streakGP;
	}

	/**
	 * @return the suspendedGames
	 */
	public int getSuspendedGames() {
		return suspendedGames;
	}

	/**
	 * @param suspendedGames the suspendedGames to set
	 */
	public void setSuspendedGames(int suspendedGames) {
		this.suspendedGames = suspendedGames;
	}

	/**
	 * @return the training
	 */
	public int getTraining() {
		return training;
	}

	/**
	 * @param training the training to set
	 */
	public void setTraining(int training) {
		this.training = training;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the orgStatus
	 */
	public int getOrgStatus() {
		return orgStatus;
	}

	/**
	 * @param orgStatus the orgStatus to set
	 */
	public void setOrgStatus(int orgStatus) {
		this.orgStatus = orgStatus;
	}

	/**
	 * @return the bStreakGP
	 */
	public int getbStreakGP() {
		return bStreakGP;
	}

	/**
	 * @param bStreakGP the bStreakGP to set
	 */
	public void setbStreakGP(int bStreakGP) {
		this.bStreakGP = bStreakGP;
	}

	/**
	 * @return the bStreakGWG
	 */
	public int getbStreakGWG() {
		return bStreakGWG;
	}

	/**
	 * @param bStreakGWG the bStreakGWG to set
	 */
	public void setbStreakGWG(int bStreakGWG) {
		this.bStreakGWG = bStreakGWG;
	}

	/**
	 * @return the bStreakAssists
	 */
	public int getbStreakAssists() {
		return bStreakAssists;
	}

	/**
	 * @param bStreakAssists the bStreakAssists to set
	 */
	public void setbStreakAssists(int bStreakAssists) {
		this.bStreakAssists = bStreakAssists;
	}

	/**
	 * @return the bStreakPoints
	 */
	public int getbStreakPoints() {
		return bStreakPoints;
	}

	/**
	 * @param bStreakPoints the bStreakPoints to set
	 */
	public void setbStreakPoints(int bStreakPoints) {
		this.bStreakPoints = bStreakPoints;
	}

	/**
	 * @return the bStreakGoals
	 */
	public int getbStreakGoals() {
		return bStreakGoals;
	}

	/**
	 * @param bStreakGoals the bStreakGoals to set
	 */
	public void setbStreakGoals(int bStreakGoals) {
		this.bStreakGoals = bStreakGoals;
	}

	/**
	 * @return the ceilFGT
	 */
	public int getCeilFGT() {
		return ceilFGT;
	}

	/**
	 * @param ceilFGT the ceilFGT to set
	 */
	public void setCeilFGT(int ceilFGT) {
		this.ceilFGT = ceilFGT;
	}

	/**
	 * @return the ceilSHO
	 */
	public int getCeilSHO() {
		return ceilSHO;
	}

	/**
	 * @param ceilSHO the ceilSHO to set
	 */
	public void setCeilSHO(int ceilSHO) {
		this.ceilSHO = ceilSHO;
	}

	/**
	 * @return the ceilPLA
	 */
	public int getCeilPLA() {
		return ceilPLA;
	}

	/**
	 * @param ceilPLA the ceilPLA to set
	 */
	public void setCeilPLA(int ceilPLA) {
		this.ceilPLA = ceilPLA;
	}

	/**
	 * @return the ceilSTK
	 */
	public int getCeilSTK() {
		return ceilSTK;
	}

	/**
	 * @param ceilSTK the ceilSTK to set
	 */
	public void setCeilSTK(int ceilSTK) {
		this.ceilSTK = ceilSTK;
	}

	/**
	 * @return the ceilCHK
	 */
	public int getCeilCHK() {
		return ceilCHK;
	}

	/**
	 * @param ceilCHK the ceilCHK to set
	 */
	public void setCeilCHK(int ceilCHK) {
		this.ceilCHK = ceilCHK;
	}

	/**
	 * @return the ceilPOS
	 */
	public int getCeilPOS() {
		return ceilPOS;
	}

	/**
	 * @param ceilPOS the ceilPOS to set
	 */
	public void setCeilPOS(int ceilPOS) {
		this.ceilPOS = ceilPOS;
	}

	/**
	 * @return the ceilHIT
	 */
	public int getCeilHIT() {
		if ((height <= 2)  && (ceilHIT > 40))
			return 40;
		if ((height <= 6) && (ceilHIT > 70))
			return 70;
		if ((height <= 8) && (ceilHIT > 90))
			return 90;
		if (height > 9) 
			return ceilHIT;
		return ceilHIT;
	}

	/**
	 * @param ceilHIT the ceilHIT to set
	 */
	public void setCeilHIT(int ceilHIT) {
		this.ceilHIT = ceilHIT;
	}

	/**
	 * @return the ceilSKA
	 */
	public int getCeilSKA() {
		return ceilSKA;
	}

	/**
	 * @param ceilSKA the ceilSKA to set
	 */
	public void setCeilSKA(int ceilSKA) {
		this.ceilSKA = ceilSKA;
	}

	/**
	 * @return the ceilEND
	 */
	public int getCeilEND() {
		return ceilEND;
	}

	/**
	 * @param ceilEND the ceilEND to set
	 */
	public void setCeilEND(int ceilEND) {
		this.ceilEND = ceilEND;
	}

	/**
	 * @return the ceilPEN
	 */
	public int getCeilPEN() {
		return ceilPEN;
	}

	/**
	 * @param ceilPEN the ceilPEN to set
	 */
	public void setCeilPEN(int ceilPEN) {
		this.ceilPEN = ceilPEN;
	}

	/**
	 * @return the ceilFAC
	 */
	public int getCeilFAC() {
		return ceilFAC;
	}

	/**
	 * @param ceilFAC the ceilFAC to set
	 */
	public void setCeilFAC(int ceilFAC) {
		this.ceilFAC = ceilFAC;
	}

	/**
	 * @return the ceilLEA
	 */
	public int getCeilLEA() {
		return ceilLEA;
	}

	/**
	 * @param ceilLEA the ceilLEA to set
	 */
	public void setCeilLEA(int ceilLEA) {
		this.ceilLEA = ceilLEA;
	}

	/**
	 * @return the ceilSTR
	 */
	public int getCeilSTR() {
		return ceilSTR;
	}

	/**
	 * @param ceilSTR the ceilSTR to set
	 */
	public void setCeilSTR(int ceilSTR) {
		this.ceilSTR = ceilSTR;
	}

	/**
	 * @return the attitude
	 */
	public int getAttitude() {
		return attitude;
	}

	/**
	 * @param attitude the attitude to set
	 */
	public void setAttitude(int attitude) {
		this.attitude = attitude;
	}

	/**
	 * @return the altPOSI
	 */
	public int getAltPOSI() {
		return altPOSI;
	}

	/**
	 * @param altPOSI the altPOSI to set
	 */
	public void setAltPOSI(int altPOSI) {
		this.altPOSI = altPOSI;
	}

	/**
	 * @return the nhlRights
	 */
	public int getNhlRights() {
		return nhlRights;
	}

	/**
	 * @param nhlRights the nhlRights to set
	 */
	public void setNhlRights(int nhlRights) {
		this.nhlRights = nhlRights;
	}

	/**
	 * @return the injProne
	 */
	public int getInjProne() {
		return injProne;
	}

	/**
	 * @param injProne the injProne to set
	 */
	public void setInjProne(int injProne) {
		this.injProne = injProne;
	}

	/**
	 * @return the overallDraft
	 */
	public int getOverallDraft() {
		return overallDraft;
	}

	/**If overallDraft=102
	 * position in round 3 would be 12th
	 * 
	 * @return The Overall position in the Round Drafted
	 */
	public int getDraftPositionInRound(){
		return overallDraft%30;
	}

	/**
	 * @param overallDraft the overallDraft to set
	 */
	public void setOverallDraft(int overallDraft) {
		this.overallDraft = overallDraft;
	}

	/**
	 * @return the forGUI
	 */
	public ArrayList<Integer> getForGUI() {
		return forGUI;
	}

	/**
	 * @param forGUI the forGUI to set
	 */
	public void setForGUI(ArrayList<Integer> forGUI) {
		this.forGUI = forGUI;
	}

	/**
	 * 
	 * @param team The String value of the team
	 * @return the int value corresponding to the String value
	 */

	public int getIntTeamFromString(String team){
		if (team.equalsIgnoreCase("DFT"))
			return 99;
		if (team.equalsIgnoreCase("FA")||team.equalsIgnoreCase("UFA"))
			return 98;
		if (team.equalsIgnoreCase("ANA"))
			return 1;
		if (team.equalsIgnoreCase("ATL"))
			return 2;
		if (team.equalsIgnoreCase("BOS"))
			return 3;
		if (team.equalsIgnoreCase("BUF"))
			return 4;
		if (team.equalsIgnoreCase("CGY"))
			return 5;
		if (team.equalsIgnoreCase("CAR"))
			return 6;
		if (team.equalsIgnoreCase("CHI"))
			return 7;
		if (team.equalsIgnoreCase("COL"))
			return 8;
		if (team.equalsIgnoreCase("CBS")||team.equalsIgnoreCase("CBJ"))
			return 9;
		if (team.equalsIgnoreCase("DAL"))
			return 10;
		if (team.equalsIgnoreCase("DET"))
			return 11;
		if (team.equalsIgnoreCase("EDM"))
			return 12;
		if (team.equalsIgnoreCase("FLA"))
			return 13;
		if (team.equalsIgnoreCase("LA"))
			return 14;
		if (team.equalsIgnoreCase("MIN"))
			return 15;
		if (team.equalsIgnoreCase("MON")||team.equalsIgnoreCase("MTL"))
			return 16;
		if (team.equalsIgnoreCase("NYI"))
			return 17;
		if (team.equalsIgnoreCase("NYR"))
			return 18;
		if (team.equalsIgnoreCase("NSH")||team.equalsIgnoreCase("NSH"))
			return 19;
		if (team.equalsIgnoreCase("NJ"))
			return 20;
		if (team.equalsIgnoreCase("OTT"))
			return 21;
		if (team.equalsIgnoreCase("PHI"))
			return 22;
		if (team.equalsIgnoreCase("PHO"))
			return 23;
		if (team.equalsIgnoreCase("PIT"))
			return 24;
		if (team.equalsIgnoreCase("SJ"))
			return 25;
		if (team.equalsIgnoreCase("STL"))
			return 26;
		if (team.equalsIgnoreCase("TB"))
			return 27;
		if (team.equalsIgnoreCase("TOR"))
			return 28;
		if (team.equalsIgnoreCase("VAN"))
			return 29;
		if (team.equalsIgnoreCase("WSH")||team.equalsIgnoreCase("WAS")) {
			return 30;
		}
		return -1;//indicates an error has occurred
	}
	/**
	 * Method for displaying the Player's team in letters
	 * @return the String value of rights
	 */
	public String getStringTeam() {
		if (rights == 99)
			return "DFT";//Draft
		if (rights == 98)
			return "FA";//Free Agency
		if (rights == 1)
			return "ANA";
		if (rights == 2)
			return "ATL";
		if (rights == 3)
			return "BOS";
		if (rights == 4)
			return "BUF";
		if (rights == 5)
			return "CGY";
		if (rights == 6)
			return "CAR";
		if (rights == 7)
			return "CHI";
		if (rights == 8)
			return "COL";
		if (rights == 9)
			return "CBJ";
		if (rights == 10)
			return "DAL";
		if (rights == 11)
			return "DET";
		if (rights == 12)
			return "EDM";
		if (rights == 13)
			return "FLA";
		if (rights == 14)
			return "LA";
		if (rights == 15)
			return "MIN";
		if (rights == 16)
			return "MTL";
		if (rights == 17)
			return "NYI";
		if (rights == 18)
			return "NYR";
		if (rights == 19)
			return "NSH";
		if (rights == 20)
			return "NJ";
		if (rights == 21)
			return "OTT";
		if (rights == 22)
			return "PHI";
		if (rights == 23)
			return "PHO";
		if (rights == 24)
			return "PIT";
		if (rights == 25)
			return "SJ";
		if (rights == 26)
			return "STL";
		if (rights == 27)
			return "TB";
		if (rights == 28)
			return "TOR";
		if (rights == 29)
			return "VAN";
		if (rights == 30) {
			return "WSH";
		}
		return "rights NOT FOUND";
	}
	public String getStringFromNum(int num){
		if (num == 99)
			return "DFT";//Draft
		if (num == 98)
			return "FA";//Free Agency
		if (num == 1)
			return "ANA";
		if (num == 2)
			return "ATL";
		if (num == 3)
			return "BOS";
		if (num == 4)
			return "BUF";
		if (num == 5)
			return "CGY";
		if (num == 6)
			return "CAR";
		if (num == 7)
			return "CHI";
		if (num == 8)
			return "COL";
		if (num == 9)
			return "CBJ";
		if (num == 10)
			return "DAL";
		if (num == 11)
			return "DET";
		if (num == 12)
			return "EDM";
		if (num == 13)
			return "FLA";
		if (num == 14)
			return "LA";
		if (num == 15)
			return "MIN";
		if (num == 16)
			return "MTL";
		if (num == 17)
			return "NYI";
		if (num == 18)
			return "NYR";
		if (num == 19)
			return "NSH";
		if (num == 20)
			return "NJ";
		if (num == 21)
			return "OTT";
		if (num == 22)
			return "PHI";
		if (num == 23)
			return "PHO";
		if (num == 24)
			return "PIT";
		if (num == 25)
			return "SJ";
		if (num == 26)
			return "STL";
		if (num == 27)
			return "TB";
		if (num == 28)
			return "TOR";
		if (num == 29)
			return "VAN";
		if (num == 30) {
			return "WSH";
		}
		return "rights NOT FOUND";

	}
	public String getFIG2S(){
		String temp=""+ceilFGT;
		if(temp.length()==2)
			return "0"+temp;
		else
			return temp;
	}
	public String getSHO2S(){
		String temp=""+ceilSHO;
		if(temp.length()==2)
			return "0"+temp;
		else
			return temp;}
	public String getPLA2S(){
		String temp=""+ceilPLA;
		if(temp.length()==2)
			return "0"+temp;
		else
			return temp;}
	public String getSTK2S(){
		String temp=""+ceilSTK;
		if(temp.length()==2)
			return "0"+temp;
		else
			return temp;}
	public String getCHK2S(){
		String temp=""+ceilCHK;
		if(temp.length()==2)
			return "0"+temp;
		else
			return temp;}
	public String getPOS2S(){
		String temp=""+ceilPOS;
		if(temp.length()==2)
			return "0"+temp;
		else
			return temp;}
	public String getHIT2S(){
		String temp=""+this.getCeilHIT();
		if(temp.length()==2)
			return "0"+temp;
		else
			return temp;}
	public String getSKA2S(){
		String temp=""+ceilSKA;
		if(temp.length()==2)
			return "0"+temp;
		else
			return temp;}
	public String getEND2RS(){
		String temp=""+ceilEND;
		if(temp.length()==2)
			return "0"+temp;
		else
			return temp;}
	public String getPEN2S(){
		String temp=""+ceilPEN;
		if(temp.length()==2)
			return "0"+temp;
		else
			return temp;}
	public String getFAC2S(){
		String temp=""+ceilFAC;
		if(temp.length()==2)
			return "0"+temp;
		else
			return temp;}
	public String getLEA2S(){
		String temp=""+ceilLEA;
		if(temp.length()==2)
			return "0"+temp;
		else
			return temp;}
	public String getSTR2S(){
		String temp=""+ceilSTR;
		if(temp.length()==2)
			return "0"+temp;
		else
			return temp;}
	/**
	 * Get the Full name of the player
	 * @return FirstName LastName
	 */
	public String getFullName(){
		return this.getfName()+" "+this.getlName();
	}

	public ArrayList<String> getAllInfoList(){
		ArrayList<String>list=new ArrayList<String>();
		list.add(""+this.getwGames());
		list.add(""+this.getwGoals());
		list.add(""+this.getwAssists());
		list.add(""+this.getwGWG());
		list.add(""+this.getmGames());
		list.add(""+this.getmGoals());
		list.add(""+this.getmAssists());
		list.add(""+this.getmGWG());
		list.add(""+this.getGoals());
		list.add(""+this.getAssists());
		list.add(""+this.getPoints());
		list.add(""+this.getStreakG());
		list.add(""+this.getStreakP());
		list.add(""+this.getStreakGP());
		list.add(""+this.getbStreakGP());
		list.add(""+this.getbStreakGWG());
		list.add(""+this.getbStreakAssists());
		list.add(""+this.getbStreakPoints());
		list.add(""+this.getbStreakGoals());

		for (String s:this.getSkillsList())
			list.add(s);

		return list;
	}
	/**
	 * Used as a helper method for ArrayList containing JFormattedTextFields in gui
	 * @return
	 */
	public ArrayList<String> getSkillsList(){
		ArrayList<String>skills=new ArrayList<String>();
		skills.add(""+this.getStringPosition());
		skills.add(""+this.getStringAlternatePosition());
		skills.add(""+this.getStringFromNum(this.getRights()));
		skills.add(""+this.getDraftYr());
		skills.add(""+this.getDraftRd());
		skills.add(""+this.getDraftPositionInRound());
		skills.add(""+this.getStringFromNum(this.getDraftTeam()));
		skills.add(""+this.getContractYr());
		skills.add(""+this.getSalary());
		skills.add(""+this.getStringHeight());
		skills.add(""+this.getWeight());
		skills.add(""+this.getAge());
		skills.add(""+this.getTwoWay());
		skills.add(""+this.getsCountry());
		skills.add(""+this.getHand());
		skills.add(""+this.getCLK());
		skills.add(""+this.getCurSHO());
		skills.add(""+this.getCurPLA());
		skills.add(""+this.getCurSTK());
		skills.add(""+this.getCurCHK());
		skills.add(""+this.getCurPOS());
		skills.add(""+this.getCurHIT());
		skills.add(""+this.getCurSKA());
		skills.add(""+this.getCurEND());
		skills.add(""+this.getPEN());
		skills.add(""+this.getCurFAC());
		skills.add(""+this.getLEA());
		skills.add(""+this.getCurFGT());
		skills.add(""+this.getCurSTR());
		skills.add(""+this.getPOT());
		skills.add(""+this.getCON());
		skills.add(""+this.getGRD());
		skills.add(""+this.getInjProne());
		skills.add(""+this.getOffense());
		skills.add(""+this.getDefense());
		skills.add(""+this.getOA());
		skills.add(""+this.getOfferData());
		// skills.add(""+this.getOfferTeam());
		skills.add(""+this.getTimeConsidering());
		skills.add(""+this.getCeilSHO());
		skills.add(""+this.getCeilPLA());
		skills.add(""+this.getCeilSTK());
		skills.add(""+this.getCeilCHK());
		skills.add(""+this.getCeilPOS());
		skills.add(""+this.getCeilHIT());
		skills.add(""+this.getCeilSKA());
		skills.add(""+this.getCeilEND());
		skills.add(""+this.getCeilPEN());
		skills.add(""+this.getCeilFAC());
		skills.add(""+this.getCeilLEA());
		skills.add(""+this.getCeilFGT());
		skills.add(""+this.getCeilSTR());
		skills.add(""+this.getpSHO());
		skills.add(""+this.getpPLA());
		skills.add(""+this.getpSTK());
		skills.add(""+this.getpCHK());
		skills.add(""+this.getpPOS());
		skills.add(""+this.getpHIT());
		skills.add(""+this.getpSKA());
		skills.add(""+this.getCurEND());
		skills.add(""+this.getPEN());
		skills.add(""+this.getpFAC());
		skills.add(""+this.getLEA());
		skills.add(""+this.getpFGT());
		skills.add(""+this.getpSTR());
		skills.add(""+this.getpOFF());
		skills.add(""+this.getpDF());
		skills.add(""+this.getpOA());
		skills.add(""+this.getTRO());
		skills.add(""+this.getTRD());
		skills.add(""+this.getTROA());
		skills.add(""+this.getFarmOFF());
		skills.add(""+this.getFarmDF());
		skills.add(""+this.getFarmOA());
		skills.add(""+this.getpStatus());
		return skills;
	}
	public ArrayList<Integer> comparePlayers(Player other){
		ArrayList<Integer>dif=new ArrayList<Integer>();
		dif.add(this.getCurSHO()-other.getCurSHO());
		dif.add(this.getCurPLA()-other.getCurPLA());
		dif.add(this.getCurSTK()-other.getCurSTK());
		dif.add(this.getCurCHK()-other.getCurCHK());
		dif.add(this.getCurPOS()-other.getCurPOS());
		dif.add(this.getCurHIT()-other.getCurHIT());
		dif.add(this.getCurSKA()-other.getCurSKA());
		dif.add(this.getCurFAC()-other.getCurFAC());
		dif.add(this.getCurSTR()-other.getCurSTR());
		dif.add(this.getCurFGT()-other.getCurFGT());
                dif.add(this.getpSHO()-other.getpSHO());
                dif.add(this.getpPLA()-other.getpPLA());
                dif.add(this.getpSTK()-other.getpSTK());
                dif.add(this.getpCHK()-other.getpCHK());
                dif.add(this.getpPOS()-other.getpPOS());
                dif.add(this.getpHIT()-other.getpHIT());
                dif.add(this.getpSKA()-other.getpSKA());
                dif.add(this.getpFAC()-other.getpFAC());
                dif.add(this.getpSTR()-other.getpSTR());
                dif.add(this.getpFGT()-other.getpFGT());
                
                dif.add(this.getOffense()-other.getOffense());
                dif.add(this.getDefense()-other.getDefense());
                dif.add(this.getOA()-other.getOA());
                dif.add(this.getpOFF()-other.getpOFF());
                dif.add(this.getpDF()-other.getpDF());
                dif.add(this.getpOA()-other.getpOA());
                dif.add(this.getTRO()-other.getTRO());
                dif.add(this.getTRD()-other.getTRD());
                dif.add(this.getTROA()-other.getTROA());
                dif.add(this.getFarmOFF()-other.getFarmOFF());
                dif.add(this.getFarmDF()-other.getFarmDF());
                dif.add(this.getFarmOA()-other.getFarmOA());

                dif.add(this.getPEN()-other.getPEN());
                dif.add(this.getCurEND()-other.getCurEND());
                dif.add(this.getPOT()-other.getPOT());
                dif.add(this.getCON()-other.getCON());
                dif.add(this.getGRD()-other.getGRD());
                dif.add(this.getInjProne()-other.getInjProne());
                dif.add(this.getLEA()-other.getLEA());

                dif.add(this.getSalary()-other.getSalary());
                dif.add(this.getContractYr()-other.getContractYr());

                return dif;
	}



	@Override
	public int compareTo(Object other) {
		Player temp=(Player)other;
		if(this.lName.compareToIgnoreCase(temp.getlName())==0){
			if (this.fName.compareToIgnoreCase(temp.getfName())==0)
				return -1;
			return this.fName.compareToIgnoreCase(temp.getfName());
		}
		return this.lName.compareToIgnoreCase(temp.getlName());
	}
}
