package sws3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class League {
	private long salaryCap;
	private TreeSet<Player>playerList;
	private HashMap<String,ArrayList<Player>> teamMap;
	private ArrayList<Team>teamsList=new ArrayList<Team>(); 
	
	public League(TreeSet<Player>playerList,long salaryCap){
		this.salaryCap=salaryCap;
		this.playerList=playerList;
		teamMap=new HashMap<String,ArrayList<Player>>();	
		teamMap.put("DFT", new ArrayList<Player>());
		teamMap.put("FA",  new ArrayList<Player>());
		teamMap.put("ANA", new ArrayList<Player>());
		teamMap.put("ATL", new ArrayList<Player>());
		teamMap.put("BOS", new ArrayList<Player>());
		teamMap.put("BUF", new ArrayList<Player>());
		teamMap.put("CGY", new ArrayList<Player>());
		teamMap.put("CAR", new ArrayList<Player>());
		teamMap.put("CHI", new ArrayList<Player>());
		teamMap.put("COL", new ArrayList<Player>());
		teamMap.put("CBJ", new ArrayList<Player>());
		teamMap.put("DAL", new ArrayList<Player>());
		teamMap.put("DET", new ArrayList<Player>());
		teamMap.put("EDM", new ArrayList<Player>());
		teamMap.put("FLA", new ArrayList<Player>());
		teamMap.put("LA",  new ArrayList<Player>());
		teamMap.put("MIN", new ArrayList<Player>());
		teamMap.put("MTL", new ArrayList<Player>());
		teamMap.put("NYI", new ArrayList<Player>());
		teamMap.put("NYR", new ArrayList<Player>());
		teamMap.put("NSH", new ArrayList<Player>());
		teamMap.put("NJ",  new ArrayList<Player>());
		teamMap.put("OTT", new ArrayList<Player>());
		teamMap.put("PHI", new ArrayList<Player>());
		teamMap.put("PHO", new ArrayList<Player>());
		teamMap.put("PIT", new ArrayList<Player>());
		teamMap.put("SJ",  new ArrayList<Player>());
		teamMap.put("STL", new ArrayList<Player>());
		teamMap.put("TB",  new ArrayList<Player>());
		teamMap.put("TOR", new ArrayList<Player>());
		teamMap.put("VAN", new ArrayList<Player>());
		teamMap.put("WSH", new ArrayList<Player>());
	}
	
	public ArrayList<Team> createTeams(){
		teamsList.add(new Team("Anaheim",teamMap.get("ANA"),1));
		teamsList.add(new Team("Atlanta",teamMap.get("ATL"),2));
		teamsList.add(new Team("Boston",teamMap.get("BOS"),3));
		teamsList.add(new Team("Buffalo",teamMap.get("BUF"),4));
		teamsList.add(new Team("Calgary",teamMap.get("CGY"),5));
		teamsList.add(new Team("Carolina",teamMap.get("CAR"),6));
		teamsList.add(new Team("Chicago",teamMap.get("CHI"),7));
		teamsList.add(new Team("Colorado",teamMap.get("COL"),8));
		teamsList.add(new Team("Columbus",teamMap.get("CBJ"),9));
		teamsList.add(new Team("Dallas",teamMap.get("DAL"),10));
		teamsList.add(new Team("Detroit",teamMap.get("DET"),11));
		teamsList.add(new Team("Edmonton",teamMap.get("EDM"),12));
		teamsList.add(new Team("Florida",teamMap.get("FLA"),13));
		teamsList.add(new Team("Los Angeles",teamMap.get("LA"),14));
		teamsList.add(new Team("Minnesota",teamMap.get("MIN"),15));
		teamsList.add(new Team("Montreal",teamMap.get("MTL"),16));
		teamsList.add(new Team("New York I",teamMap.get("NYI"),17));
		teamsList.add(new Team("New York R",teamMap.get("NYR"),18));
		teamsList.add(new Team("Nashville",teamMap.get("NSH"),19));
		teamsList.add(new Team("New Jersey",teamMap.get("NJ"),20));
		teamsList.add(new Team("Ottawa",teamMap.get("OTT"),21));
		teamsList.add(new Team("Philadelphia",teamMap.get("PHI"),22));
		teamsList.add(new Team("Phoenix",teamMap.get("PHO"),23));
		teamsList.add(new Team("Pittsburgh",teamMap.get("PIT"),24));
		teamsList.add(new Team("San Jose",teamMap.get("SJ"),25));
		teamsList.add(new Team("St. Louis",teamMap.get("STL"),26));
		teamsList.add(new Team("Tampa Bay",teamMap.get("TB"),27));
		teamsList.add(new Team("Toronto",teamMap.get("TOR"),28));
		teamsList.add(new Team("Vancouver",teamMap.get("VAN"),29));
		teamsList.add(new Team("Washington",teamMap.get("WSH"),30));
		teamsList.add(new Team("Draft",teamMap.get("DFT"),99));
		teamsList.add(new Team("Free Agent",teamMap.get("FA"),98));
		return teamsList;
		
	}
	/**
	 * creates a map of teams to their players.
	 */
	public void createTeamMap(){
		for (Player p:playerList){
                    try{
			ArrayList<Player>temp=teamMap.get(p.getStringTeam());
			temp.add(p);
			teamMap.remove(p.getStringTeam());
			teamMap.put(p.getStringTeam(), temp);
                    }
                    catch(Throwable t){

                        System.out.println("ERROR FOR: "+p.getfName()+" "+p.getlName());

                    }
		}
	}


	/**
	 * @return the salaryCap
	 */
	public long getSalaryCap() {
		return salaryCap;
	}

	/**
	 * @param salaryCap the salaryCap to set
	 */
	public void setSalaryCap(long salaryCap) {
		this.salaryCap = salaryCap;
	}

	/**
	 * @return the playerList
	 */
	public TreeSet<Player> getPlayerList() {
		return playerList;
	}

	/**
	 * @param playerList the playerList to set
	 */
	public void setPlayerList(TreeSet<Player> playerList) {
		this.playerList = playerList;
	}

	/**
	 * @return the teamMap
	 */
	public HashMap<String, ArrayList<Player>> getTeamMap() {
		return teamMap;
	}

	/**
	 * @param teamMap the teamMap to set
	 */
	public void setTeamMap(HashMap<String, ArrayList<Player>> teamMap) {
		this.teamMap = teamMap;
	}
	
}
