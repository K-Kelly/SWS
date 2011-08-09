package sws3;

import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.ImageIcon;

public class Team {
	private String name;
	private ArrayList<Player>proPlayers;
	private ArrayList<Player>farmPlayers;
	private ArrayList<Player>allPlayers;
	private ArrayList<Player>prospects;
        final private int id;

	public Team(String name,ArrayList<Player>allPlayers,int id){
		this.name=name;
		this.allPlayers=allPlayers;
		farmPlayers=new ArrayList<Player>();
		proPlayers=new ArrayList<Player>();
		prospects=new ArrayList<Player>();
                this.id=id;
	}

	/**
	 * Sorts players to their correct lists
	 */
	public void sortPlayersToLists(){
            if(proPlayers.size()>0||farmPlayers.size()>0||prospects.size()>0)
                return;
		for (Player p:allPlayers){
			if(p.getTEAM()>30&&p.getTEAM()<61)
				farmPlayers.add(p);
			else if (p.getTEAM()<31&&p.getContractYr()!=0)
				proPlayers.add(p);
			else
				prospects.add(p);
		}
	}
	/**
	 * 
	 * @return average offensive rating of pro team
	 */
	public int offenseAverage(){
		int sum=0;
		for(Player p:proPlayers){
			sum+=p.getOffense();
		}
		return sum/proPlayers.size();
	}
	/**
	 * 
	 * @return average defensive rating of pro team
	 */
	public int defenseAverage(){
		int sum=0;
		for(Player p:proPlayers){
			sum+=p.getDefense();
		}
		return sum/proPlayers.size();
	}
	/**
	 * 
	 * @return average overall rating of pro team
	 */
	public int overallAverage(){
		int sum=0;
		for(Player p:proPlayers){
			sum+=p.getOA();
		}
		return sum/proPlayers.size();
	}
	/**
	 * @return the prospects
	 */
	public ArrayList<Player> getProspects() {
		return prospects;
	}

	/**
	 * @return the proSalary
	 */
	public int getProSalary() {
		int sum=0;
		for(Player p:proPlayers){
			sum+=p.getSalary();
		}
		return sum;
	}

	/**
	 * @return the farmSalary
	 */
	public int getFarmSalary() {
		//FIXME Need to account for two way
		int sum=0;
		for(Player p:farmPlayers){
                        if (p.getTwoWay()==1)
                            sum+=(p.getSalary()*3)/10;
                        else
                            sum+=p.getSalary();
		}
		return sum;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the proPlayers
	 */
	public ArrayList<Player> getProPlayers() {
		return proPlayers;
	}

	/**
	 * @param proPlayers the proPlayers to set
	 */
	public void setProPlayers(ArrayList<Player> proPlayers) {
		this.proPlayers = proPlayers;
	}

	/**
	 * @return the farmPlayers
	 */
	public ArrayList<Player> getFarmPlayers() {
		return farmPlayers;
	}

	/**
	 * @param farmPlayers the farmPlayers to set
	 */
	public void setFarmPlayers(ArrayList<Player> farmPlayers) {
		this.farmPlayers = farmPlayers;
	}

	/**
	 * @return the allPlayers
	 */
	public ArrayList<Player> getAllPlayers() {
		return allPlayers;
	}

	/**
	 * @param allPlayers the allPlayers to set
	 */
	public void setAllPlayers(ArrayList<Player> allPlayers) {
		this.allPlayers = allPlayers;
	}
        public ImageIcon getImageIcon(String filePath){
            filePath=filePath.substring(0,filePath.indexOf("saves"));

        if (id == 1) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/ANA.jpg");
        return icon;
      } else if (id == 2) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/ATL.jpg");
        return icon;
      } else if (id == 3) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/BOS.jpg");
        return icon;
      } else if (id == 4) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/BUF.jpg");
        return icon;
      } else if (id == 5) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/CGY.jpg");
        return icon;
      } else if (id == 6) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/CAR.jpg");
        return icon;
      } else if (id == 7) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/CHI.jpg");
        return icon;
      } else if (id == 8) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/COL.jpg");
        return icon;
      } else if (id == 9) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/CBS.jpg");
        return icon;
      } else if (id == 10) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/DAL.jpg");
        return icon;
      } else if (id == 11) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/DET.jpg");
        return icon;
      } else if (id == 12) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/EDM.jpg");
        return icon;
      } else if (id == 13) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/FLA.jpg");
        return icon;
      } else if (id == 14) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/LA.jpg");
        return icon;
      } else if (id == 15) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/MIN.jpg");
        return icon;
      } else if (id == 16) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/MTL.jpg");
        return icon;
      } else if (id == 17) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/NYI.jpg");
        return icon;
      } else if (id == 18) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/NYR.jpg");
        return icon;
      } else if (id == 19) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/NAS.jpg");
        return icon;
      } else if (id == 20) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/NJ.jpg");
        return icon;
      } else if (id == 21) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/OTT.jpg");
        return icon;
      } else if (id == 22) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/PHI.jpg");
        return icon;
      } else if (id == 23) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/PHO.jpg");
        return icon;
      } else if (id == 24) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/PIT.jpg");
        return icon;
      } else if (id == 25) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/SJ.jpg");
        return icon;
      } else if (id == 26) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/STL.jpg");
        return icon;
      } else if (id == 27) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/TB.jpg");
        return icon;
      } else if (id == 28) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/TOR.jpg");
        return icon;
      } else if (id == 29) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/VAN.jpg");
        return icon;
      } else if (id == 30) {
        ImageIcon icon = new ImageIcon(filePath+"pictures/logos/WSH.jpg");
        return icon;
      } else {
        ImageIcon icon = new ImageIcon(filePath+"pictures/icons/7.jpg");
        return icon;
      }
        }
        public Object[] getLeftWing(ArrayList<Player>players){
            ArrayList<String>lw=new ArrayList<String>();
            for (Player p:players){
                if (p.getStringPosition().equals("L"))
                    lw.add(p.getFullName());
        }
            return lw.toArray();
}
        public Object[] getCenter(ArrayList<Player>players){
            ArrayList<String>c=new ArrayList<String>();
            for (Player p:players){
                if (p.getStringPosition().equals("C"))
                    c.add(p.getFullName());
        }
            return c.toArray();
}
        public Object[] getRightWing(ArrayList<Player>players){
            ArrayList<String>rw=new ArrayList<String>();
            for (Player p:players){
                if (p.getStringPosition().equals("R"))
                    rw.add(p.getFullName());
        }
            return rw.toArray();
}
        public Object[] getDefense(ArrayList<Player>players){
            ArrayList<String>d=new ArrayList<String>();
            for (Player p:players){
                if (p.getStringPosition().equals("D"))
                    d.add(p.getFullName());
        }
            return d.toArray();
}
        public Object[] getGoalie(ArrayList<Player>players){
            ArrayList<String>g=new ArrayList<String>();
            for (Player p:players){
                if (p.getStringPosition().equals("G"))
                    g.add(p.getFullName());
        }
            return g.toArray();
}
        public ArrayList<Player> getTop150(){
            int n=150;
            if (allPlayers.size()<150)
                n=allPlayers.size();

            Player[]sort=new Player[allPlayers.size()];
            for (int i=0;i<sort.length;i++){
                sort[i]=allPlayers.get(i);
            }
            for (int i=0;i<sort.length-1;i++){
                for (int j=i+1;j<sort.length;j++){
                    if (sort[j].getpOA()>sort[i].getpOA()){
                        Player temp=sort[j];
                        sort[j]=sort[i];
                        sort[i]=temp;
                    }
                }
            }
            ArrayList<Player>top=new ArrayList<Player>(n);
            int sum0=0;
            for (int i=0;i<n;i++){
                top.add(sort[i]);
                sum0+=sort[i].getpOA();
            }
            System.out.println("\nSUM0: "+sum0);
            return top;
        }
}
