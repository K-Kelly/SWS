package sws3;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FileHandler {
	private File playersFile;
	private File leagueFile;
	private File statisticsFile;
	private String filePath;
	private HashMap<Integer,String> map;
	private ArrayList<Player>playerList;
	private TreeSet<Player>sortedPlayers;

	public FileHandler(File playersFile){
		this.playersFile=playersFile;
		String path=playersFile.getPath();
		path=path.substring(0,path.indexOf("players.ehm"));
		filePath=path;
		leagueFile=new File(filePath+"league.ehm");
		statisticsFile=new File(filePath+"statistics.ehm");	
		sortedPlayers=new TreeSet<Player>();
		playerList=new ArrayList<Player>();//List of all the players sorted to playerID
	}

	public void readFromPlayersFile(){
		try {
			FileReader reader = new FileReader(playersFile);
			Scanner in=new Scanner(reader);
			in.nextLine();//gets rid of the first line of the players file
			int lineNum=0;//counts the lines

			playerList=new ArrayList<Player>();
			//start Player variables 
			int curSHO=-1;int curPLA=-1; int curSTK=-1;  int curCHK=-1;  int curPOS=-1; int curHIT=-1;  int curSKA=-1;  int curEND=-1; int PEN=-1;  int curFAC=-1; 
			int LEA=0;  int curSTR=-1; int POT=-1; int CON=-1;  int GRD=-1;  int curFGT=-1;  int CLK=-1;  int TEAM=-1; int POSI=-1;  int country=-1;  int handed=-1; 
			int bYear=-1;  int bDay=-1;  int bMonth=-1;  int salary=-1;  int contractYr=-1;  int draftYr=-1;  int draftRd=-1;  int draftTeam=-1;  int rights=-1; 
			int wGames=-1;  int wGoals=-1;  int wAssists=-1;  int wGWG=-1;  int mGames=-1;  int mGoals=-1;  int mAssists=-1;  int mGWG=-1; 
			int goals=-1;  int assists=-1;  int points=-1;  int NTC=-1;  int twoWay=-1;  int options=-1; 
			int pStatus=-1;  int rookie=-1;  int offerData=-1;  int offerTeam=-1;  int timeConsidering=-1;  int injuryType=-1; 
			String scoutLine8="-1";  String scoutLine9="-1";  String scoutLine10="-1"; 
			int streakG=-1;  int streakP=-1;  int streakGP=-1;  int suspendedGames=-1;  int training=-1;  int weight=-1;  int height=-1;  int orgStatus=-1; 
			int bStreakGP=-1;  int bStreakGWG=-1;  int bStreakAssists=-1;  int bStreakPoints=-1; int bStreakGoals=-1; 
			String line13=""; String fName="";  String lName="";  String line15=""; String line16=""; 
			int ceilFGT=-1; int ceilSHO=-1;  int ceilPLA=-1;  int ceilSTK=-1;  int ceilCHK=-1;  int ceilPOS=-1;  int ceilHIT=-1;  int ceilSKA=-1;  int ceilEND=-1;  int ceilPEN=-1;  int ceilFAC=-1;  int ceilLEA=-1;  int ceilSTR=-1; 
			String line18="";  String line19=""; 
			int attitude=-1;  int altPOSI=-1;  int nhlRights=-1;  int injProne=-1;  int overallDraft=-1;
			//end Player variables

			while (in.hasNextLine()){
				lineNum++;
				String line=in.nextLine();//gets rid of leading white space;
				StringTokenizer token=new StringTokenizer(line);
				while(token.hasMoreTokens()){
					if (lineNum==1){
						curSHO=Integer.parseInt(token.nextToken());//current Shooting
						curPLA=Integer.parseInt(token.nextToken());//current Playmaking
						curSTK=Integer.parseInt(token.nextToken());//current Stickhandling
						curCHK=Integer.parseInt(token.nextToken());//current Checking
						curPOS=Integer.parseInt(token.nextToken());//current Positioning
						curHIT=Integer.parseInt(token.nextToken());//current hitting
						curSKA=Integer.parseInt(token.nextToken());//current skating
						curEND=Integer.parseInt(token.nextToken());//current endurance
						PEN=Integer.parseInt(token.nextToken());//Penalty
						curFAC=Integer.parseInt(token.nextToken());//current faceoffs
					}
					else if (lineNum==2){
						//1Leadership | 2Strength | 3Potential | 4Consistency | 5Greed | 6Fighting | 7Click | 8Team | 9Main Position | 10Country | 11Handed 
						LEA=Integer.parseInt(token.nextToken());//Leadership
						curSTR=Integer.parseInt(token.nextToken());;//current Strength
						POT=Integer.parseInt(token.nextToken());//Potential
						CON=Integer.parseInt(token.nextToken());//Consistency
						GRD=Integer.parseInt(token.nextToken());;//Greed
						curFGT=Integer.parseInt(token.nextToken());//Current Fighting
						CLK=Integer.parseInt(token.nextToken());//Click
						TEAM=Integer.parseInt(token.nextToken());//Team
						POSI=Integer.parseInt(token.nextToken());//Position
						country=Integer.parseInt(token.nextToken());//Country					
						handed=Integer.parseInt(token.nextToken());//Handedness
					}
					else if (lineNum==3){
						//1Birth Year | 2Birth Day | 3Birth Month | 4Salary | 5Contract Length | 6Draft Year | 7Draft Round | 8Drafted by | 9Rights 						
						bYear=Integer.parseInt(token.nextToken());//Birth Year
						bDay=Integer.parseInt(token.nextToken());//Birth Day
						bMonth=Integer.parseInt(token.nextToken());//Birth Month
						salary=Integer.parseInt(token.nextToken());	//Salary
						contractYr=Integer.parseInt(token.nextToken());//Contract length
						draftYr=Integer.parseInt(token.nextToken());//Draft Year
						draftRd=Integer.parseInt(token.nextToken());//Draft Month
						draftTeam=Integer.parseInt(token.nextToken());//Team drafted by
						rights=Integer.parseInt(token.nextToken());//Rights
					}
					else if (lineNum==4){
						//This Week - Games / Goals / Assist / GWG 
						wGames=Integer.parseInt(token.nextToken());//Games this week
						wGoals=Integer.parseInt(token.nextToken());//Goals this week
						wAssists=Integer.parseInt(token.nextToken());//Assists this week
						wGWG=Integer.parseInt(token.nextToken());//GWG this week						
					}
					else if (lineNum==5){
						//This Month - Games / Goals / Assist/ GWG
						mGames=Integer.parseInt(token.nextToken());//Games this month
						mGoals=Integer.parseInt(token.nextToken());//Goals this month
						mAssists=Integer.parseInt(token.nextToken());//Assists this month
						mGWG=Integer.parseInt(token.nextToken());//GWG this month
					}
					else if (lineNum==6){
						//Records - Goals / Assist / Points / No-Trade Switch / Two-Way Switch / Player-Team Option
						goals=Integer.parseInt(token.nextToken());//goals
						assists=Integer.parseInt(token.nextToken());//assists
						points =Integer.parseInt(token.nextToken());//points
						NTC=Integer.parseInt(token.nextToken()); //0 if false, 1 if true
						twoWay=Integer.parseInt(token.nextToken());//0 if false, 1 if true
						options=Integer.parseInt(token.nextToken());//Not sure						
					}
					else if (lineNum==7){
						//1Status / 2Rookie / 3Considering Offer Data / 4Team Offering / 5Amount of time spent considering offer/ 6Injury(1-10) 
						pStatus=Integer.parseInt(token.nextToken());//Player Status
						rookie=Integer.parseInt(token.nextToken());//1 means player is a rookie. 0 means player is not a rookie
						offerData=Integer.parseInt(token.nextToken());//Details about team's offer to a player
						offerTeam=Integer.parseInt(token.nextToken());//Team that submitted the offer the player is considering
						timeConsidering=Integer.parseInt(token.nextToken());//How long before the player makes his decision
						injuryType=Integer.parseInt(token.nextToken());//Type of injury the player is suffering						
					}
					else if (lineNum==8){
						scoutLine8="";
						while (token.hasMoreTokens()){
							if (scoutLine8.equals(""))
								scoutLine8=token.nextToken();
							else
								scoutLine8=scoutLine8+"  "+token.nextToken();
						}}
					else if (lineNum==9){
						scoutLine9="";
						while (token.hasMoreTokens()){
							if (scoutLine9.equals(""))
								scoutLine9=token.nextToken();
							else
								scoutLine9=scoutLine9+"  "+token.nextToken();
						}
					}
					else if (lineNum==10){
						scoutLine10="";
						while (token.hasMoreTokens()){
							if (scoutLine10.equals(""))
								scoutLine10=token.nextToken();
							else
								scoutLine10=scoutLine10+"  "+token.nextToken();
						}
					}
					else if (lineNum==11){
						//1Goal Streak | 2PoStreak | 3Total GP | 4Suspended Games | 5Training | 6Weight | 7Height | 8Status in Organization 
						streakG=Integer.parseInt(token.nextToken());//Goal Streak
						streakP=Integer.parseInt(token.nextToken());//Postreak
						streakGP=Integer.parseInt(token.nextToken());//Games Played streak
						suspendedGames=Integer.parseInt(token.nextToken());//Number of games Suspended
						training=Integer.parseInt(token.nextToken());//Training
						weight=Integer.parseInt(token.nextToken());//Weight
						height=Integer.parseInt(token.nextToken());//Height
						orgStatus=Integer.parseInt(token.nextToken());//Status in organization
					}
					else if (lineNum==12){
						//Best streak Games | Best streak GWG | Best streak Assists | Best Streak Points | Best Streak Goals 
						bStreakGP=Integer.parseInt(token.nextToken());//best streak games
						bStreakGWG=Integer.parseInt(token.nextToken());//best streak GWG
						bStreakAssists=Integer.parseInt(token.nextToken());//best streak Assists
						bStreakPoints=Integer.parseInt(token.nextToken());//best streak Points
						bStreakGoals=Integer.parseInt(token.nextToken());//best streak goals.
					}
					else if (lineNum==13){
						//a line.
						line13=token.nextToken();
					}
					else if (lineNum==14){
						fName=token.nextToken();//first name
						lName=token.nextToken();
						String lName2="";//catches names such as Martin St. Pierre that evade tokenizer
						if (token.hasMoreTokens()){
							lName2=token.nextToken();//last name		
							lName=lName+" "+lName2;
						}
					}
					else if (lineNum==15){
						line15="";//Performance						
						while (token.hasMoreTokens()){
							if (line15.equals(""))
								line15=token.nextToken();
							else
								line15=line15+"  "+token.nextToken();
						}
					}
					else if (lineNum==16){
						line16="";//Drafted?
						while (token.hasMoreTokens()){
							if (line16.equals(""))
								line16=token.nextToken();
							else
								line16=line16+" "+token.nextToken();
						}
					}
					else if (lineNum==17){
						//1Fighting | 2Shooting | 3Playmaking | 4Stickhandling | 5Checking | 6Positioning | 7Hitting | 8Skating | 9Endurance | 10Penalty | 11Faceoffs | 12Leadership | 13Strength 
						String line17=token.nextToken();
						ceilFGT=Integer.parseInt(line17.substring(0,3));//fighting
						ceilSHO=Integer.parseInt(line17.substring(3,6));//shooting
						ceilPLA=Integer.parseInt(line17.substring(6,9));//playmaking
						ceilSTK=Integer.parseInt(line17.substring(9,12));//stickhandling
						ceilCHK=Integer.parseInt(line17.substring(12,15));//checking
						ceilPOS=Integer.parseInt(line17.substring(15,18));//positioning
						ceilHIT=Integer.parseInt(line17.substring(18,21));//hitting
						ceilSKA=Integer.parseInt(line17.substring(21,24));//skating
						ceilEND=Integer.parseInt(line17.substring(24,27));//endurance
						ceilPEN=Integer.parseInt(line17.substring(27,30));//penalty  SHOULD NOT BE USED 
						ceilFAC=Integer.parseInt(line17.substring(30,33));//faceoffs
						ceilLEA=Integer.parseInt(line17.substring(33,36));//leadership  SHOULD NOT BE USED
						ceilSTR=Integer.parseInt(line17.substring(36,39));//strength
					}
					else if (lineNum==18){
						line18="";//EHM version
						while (token.hasMoreTokens()){
							if (line18.equals(""))
								line18=token.nextToken();
							else
								line18=line18+" "+token.nextToken();
						}
					}
					else if (lineNum==19){
						line19="";//EHM version
						while (token.hasMoreTokens()){
							if (line19.equals(""))
								line19=token.nextToken();
							else
								line19=line19+" "+token.nextToken();
						}
					}
					else if (lineNum==20){
						//1Attitude | 2Alternate Position | 3NHL Rights | 4Injury Prone(10-99) | 5Overall Draft 
						attitude=Integer.parseInt(token.nextToken());//Attitude
						altPOSI=Integer.parseInt(token.nextToken());//alternate Position
						nhlRights=Integer.parseInt(token.nextToken());//nhl Rights
						injProne=Integer.parseInt(token.nextToken());//injury prone
						overallDraft=Integer.parseInt(token.nextToken());//overall draft
						lineNum=0;
						//End reading from player's file for this player
						double age=calculateAge(bMonth,bDay,bYear);

						//create the player
						Player p= new Player (curSHO, curPLA, curSTK,  curCHK,  curPOS, curHIT,  curSKA,  curEND, PEN,  curFAC,
								LEA,  curSTR, POT,  CON,  GRD,  curFGT,  CLK,  TEAM, POSI,  country,  handed,
								bYear,  bDay,  bMonth,  salary,  contractYr,  draftYr,  draftRd,  draftTeam,  rights,
								wGames,  wGoals,  wAssists,  wGWG,  mGames,  mGoals,  mAssists,  mGWG,
								goals,  assists,  points,  NTC,  twoWay,  options,
								pStatus,  rookie,  offerData,  offerTeam,  timeConsidering,  injuryType,
								scoutLine8,  scoutLine9,  scoutLine10,
								streakG,  streakP,  streakGP,  suspendedGames,  training,  weight,  height,  orgStatus,
								bStreakGP,  bStreakGWG,  bStreakAssists,  bStreakPoints, bStreakGoals,
								line13, fName,  lName,  line15, line16,
								ceilFGT,  ceilSHO,  ceilPLA,  ceilSTK,  ceilCHK,  ceilPOS,  ceilHIT,  ceilSKA,  ceilEND,  ceilPEN,  ceilFAC,  ceilLEA,  ceilSTR,
								line18,  line19,
								attitude,  altPOSI,  nhlRights,  injProne,  overallDraft,
								age);
						//add to the list of players.
						playerList.add(p);
						sortedPlayers.add(p);
					}
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}
	/**
	 * @return the playerList
	 */
	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	/**
	 * @param playerList the playerList to set
	 */
	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}

	/**
	 * Calculates a player's age
	 * 
	 * @param bMonth The month of birth
	 * @param bDay The day of birth
	 * @param bYear The year of birth
	 * @return The players age in decimal form
	 */
	public double calculateAge(int bMonth,int bDay, int bYear){
		FileReader reader;
		try {			
			//Start reading from league file
			reader = new FileReader(leagueFile);
			Scanner in=new Scanner(reader);
			String line=in.nextLine();
			StringTokenizer token=new StringTokenizer(line);
			int year=Integer.parseInt(token.nextToken());
			line=in.nextLine();//line 2
			token=new StringTokenizer(line);
			int month=Integer.parseInt(token.nextToken());
			line=in.nextLine();//line 3 
			token=new StringTokenizer(line);
			int day=Integer.parseInt(token.nextToken());
			//end reading from league file
			year *= 365;
			int msum = 0;//counts the days in each month
			int i;
			for (i = month; i > 0; --i)
				if ((i == 1) || (i == 3) || (i == 5) || (i == 7) || (i == 8) || (i == 10) || (i == 12))
					msum += 31;
				else if (i == 2)
					msum += 28;
				else if ((i == 4) || (i == 6) || (i == 9) || (i == 11))
					msum += 30;
			int totald = year + msum + day; //
			year = bYear * 365;
			month = bMonth;
			day = bDay;
			msum = 0;
			for (i = month; i > 0; --i)
				if ((i == 1) || (i == 3) || (i == 5) || (i == 7) || (i == 8) || (i == 10) || (i == 12))//months that have 31 days
					msum += 31;
				else if (i == 2)//months that have 28 days
					msum += 28;
				else if ((i == 4) || (i == 6) || (i == 9) || (i == 11))//months that have 30 days
					msum += 30;
			int totalp = year + msum + day;//total possible days
			totalp = totald - totalp;			
			double age = (totalp / 365.25D);
			BigDecimal bd = new BigDecimal(age);
			bd = bd.setScale(2, 0);
			age = bd.doubleValue();
			return age;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;//indicates something went wrong.
		}

	}


	/**
	 * @return the playersFile
	 */
	public File getPlayersFile() {
		return playersFile;
	}

	/**
	 * @param playersFile the playersFile to set
	 */
	public void setPlayersFile(File playersFile) {
		this.playersFile = playersFile;
	}

	/**
	 * @return the leagueFile
	 */
	public File getLeagueFile() {
		return leagueFile;
	}

	/**
	 * @param leagueFile the leagueFile to set
	 */
	public void setLeagueFile(File leagueFile) {
		this.leagueFile = leagueFile;
	}

	/**
	 * @return the statisticsFile
	 */
	public File getStatisticsFile() {
		return statisticsFile;
	}

	/**
	 * @param statisticsFile the statisticsFile to set
	 */
	public void setStatisticsFile(File statisticsFile) {
		this.statisticsFile = statisticsFile;
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * @return the map
	 */
	public HashMap<Integer, String> getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(HashMap<Integer, String> map) {
		this.map = map;
	}

	/**
	 * @return the sortedPlayers
	 */
	public TreeSet<Player> getSortedPlayers() {
		return sortedPlayers;
	}

	/**
	 * @param sortedPlayers the sortedPlayers to set
	 */
	public void setSortedPlayers(TreeSet<Player> sortedPlayers) {
		this.sortedPlayers = sortedPlayers;
	}

	public void writePlayersFile(TreeSet<Player>playerList){
		HashSet<Player>hash=new HashSet<Player>();//sorts to playerID.
		for (Player p: playerList){
			hash.add(p);
		}
		try {
			PrintWriter out = new PrintWriter(filePath+"players.ehm");
                        System.out.println("This running?");
			out.println(" 3500");
			for(Player p: hash){
				out.println(" "+p.getCurSHO()+"  "+p.getCurPLA()+"  "+p.getCurSTK()+"  "+p.getCurCHK()+"  "+p.getCurPOS()+"  "+p.getCurHIT()+"  "+p.getCurSKA()+"  "+p.getCurEND()+"  "+p.getPEN()+"  "+p.getCurFAC()+" ");
				out.println(" "+p.getLEA()+"  "+p.getCurSTR()+"  "+p.getPOT()+"  "+p.getCON()+"  "+p.getGRD()+"  "+p.getCurFGT()+"  "+p.getCLK()+"  "+p.getTEAM()+"  "+p.getPOSI()+"  "+p.getCountry()+"  "+p.getHanded()+" ");
				out.println(" "+p.getbYear()+"  "+p.getbDay()+"  "+p.getbMonth()+"  "+p.getSalary()+"  "+p.getContractYr()+"  "+p.getDraftYr()+"  "+p.getDraftRd()+"  "+p.getDraftTeam()+"  "+p.getRights()+" ");
				out.println(" "+p.getwGames()+"  "+p.getwGoals()+"  "+p.getwAssists()+"  "+p.getwGWG()+" ");
				out.println(" "+p.getmGames()+"  "+p.getmGoals()+"  "+p.getmAssists()+"  "+p.getmGWG()+" ");
				out.println(" "+p.getGoals()+"  "+p.getAssists()+"  "+p.getPoints()+"  "+p.getNTC()+"  "+p.getTwoWay()+"  "+p.getOptions()+" ");
				out.println(" "+p.getpStatus()+"  "+p.getRookie()+"  "+p.getOfferData()+"  "+p.getOfferTeam()+"  "+p.getTimeConsidering()+"  "+p.getInjuryType()+" ");
				out.println(" "+p.getScoutLine8()+" ");
				out.println(" "+p.getScoutLine9()+" ");
				out.println(" "+p.getScoutLine10()+" ");
				out.println(" "+p.getStreakG()+"  "+p.getStreakP()+"  "+p.getStreakGP()+"  "+p.getSuspendedGames()+"  "+p.getTraining()+"  "+p.getWeight()+"  "+p.getHeight()+"  "+p.getOrgStatus()+" ");
				out.println(" "+p.getbStreakGP()+"  "+p.getbStreakGWG()+"  "+p.getbStreakAssists()+"  "+p.getbStreakPoints()+"  "+p.getbStreakGoals()+" ");
				out.println(p.getLine13());
				out.println(p.getfName()+" "+p.getlName());
				out.println(p.getLine15());
				out.println(p.getLine16());
				out.println(p.getFIG2S()+p.getSHO2S()+p.getPLA2S()+p.getSTK2S()+p.getCHK2S()+p.getPOS2S()+p.getHIT2S()+p.getSKA2S()+p.getEND2RS()+p.getPEN2S()+p.getFAC2S()+p.getLEA2S()+p.getSTR2S());
				out.println(p.getLine18());
				out.println(p.getLine19());
				out.println(" "+p.getAttitude()+"  "+p.getAltPOSI()+"  "+p.getNhlRights()+"  "+p.getInjProne()+"  "+p.getOverallDraft()+" ");
			}
			out.close();
                        JOptionPane.showMessageDialog(new JPanel(), "Changes Successfully Saved");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
        public void writeLinesFile(ArrayList<String>id,String fileName){
            try{
            PrintWriter out = new PrintWriter(filePath+fileName+".lns");
            for (String s: id){
                out.println(s);
            }
           out.close();
        }
            catch(Throwable t){
                t.printStackTrace();
            }
    }
        public void writeDraftQueue(ArrayList<String>queue,String fileName){
            try {
                PrintWriter out = new PrintWriter(filePath+fileName+".txt");
                for (String s: queue){
                    out.println(s);
                }
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
