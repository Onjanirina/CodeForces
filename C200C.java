import java.io.*;
import java.util.*;

/**
 * */
public class C200C {

	public static List<Team> listTeams=Collections.synchronizedList(new ArrayList<Team>(4));
	public static Team BERLAND=null;
	public static TeamComparator teamComparator=null;
	
	public class Team{
		public String name;
		public Map<String,Integer> selfScores=Collections.synchronizedMap(new HashMap<String,Integer>());
		public Map<String,Integer> oppScores=Collections.synchronizedMap(new HashMap<String,Integer>());
		
		public Integer points=0;
		public Integer goalDiff=0;
		public Integer goalFor=0;
		
		public Team(String name){
			this.name=name;
		}
	}
	public Team newTeam(String name){
		return new Team(name);
	}
	
	public static Team getTeam(String name){
		Iterator<Team> iter=listTeams.iterator();
		while(iter.hasNext()){
			Team team=iter.next();
			if(team.name.equals(name))
				return team;
		}
		return null;
	}
	
	public static int getBerlandRanking(){
		Iterator<Team> iter=listTeams.iterator();
		while(iter.hasNext()){
			Team team=iter.next();
			team.points=team.goalDiff=team.goalFor=0;
			Iterator<String> iterOpp=team.selfScores.keySet().iterator();
			while(iterOpp.hasNext()){
				String oppName=iterOpp.next();				
				int selfScore=team.selfScores.get(oppName);
				int oppScore=team.oppScores.get(oppName);
				team.points+=(selfScore>oppScore)?3:(selfScore==oppScore)?1:0;
				team.goalDiff+=(selfScore-oppScore);
				team.goalFor+=selfScore;
				}}
		Collections.sort(listTeams,teamComparator);
		return listTeams.indexOf(BERLAND);
	}
	
	public class TeamComparator implements Comparator<Team>{

		@Override
		public int compare(Team team1, Team team2) {
			if(team1.points.equals(team2.points)){
				if(team1.goalDiff.equals(team2.goalDiff)){
					if(team1.goalFor.equals(team2.goalFor))
						return team2.name.compareTo(team1.name);
					return team1.goalFor.compareTo(team2.goalFor);
				}
				return team1.goalDiff.compareTo(team2.goalDiff);
			}
			return team1.points.compareTo(team2.points);
		}}
	public TeamComparator newTeamComparator(){
		return new TeamComparator(); }
	
	/**
	 * @param args
	 */
	public static void main(String[] args){		
	    try {	
	    	
	    	BufferedReader reader =new BufferedReader( new InputStreamReader( System.in)); // STDIN
	    	
	    	// Teams
	    	Solution solution=new Solution();	    	
	    	listTeams.add(solution.newTeam("BERLAND"));
	    	BERLAND=getTeam("BERLAND");
	    	teamComparator=solution.newTeamComparator();
	    	
	    	//
	    	for(int i=0;i!=5;i++){
	    		String[] result=reader.readLine().trim().split(" ",3);
	    		// Team1
	    		String name1=result[0].trim();
	    		Team team1=getTeam(name1);
	    		if(team1==null){
	    			listTeams.add(solution.newTeam(name1));
	    			team1=getTeam(name1);
	    		}
	    		// Team2
	    		String name2=result[1].trim();	    		
	    		Team team2=getTeam(name2);
	    		if(team2==null){
	    			listTeams.add(solution.newTeam(name2));
	    			team2=getTeam(name2);	    			
	    		}
	    		String[] score=result[2].trim().split(":",2);
	    		Integer score1=Integer.valueOf(score[0].trim());
	    		Integer score2=Integer.valueOf(score[1].trim());
	    		team1.selfScores.put(team2.name,score1);
	    		team1.oppScores.put(team2.name,score2);
	    		team2.selfScores.put(team1.name,score2);
	    		team2.oppScores.put(team1.name,score1);
	    	}
	    	
	    	String oppName="";
	    	Iterator<Team> iterTeam=listTeams.iterator();
	    	while(iterTeam.hasNext()&&(oppName=="")){
	    		Team team=iterTeam.next();
	    		if((team.oppScores.size()==2)&&(team.name!="BERLAND"))
	    			oppName=team.name; }
	    	
	    	// 
	    	boolean bPossible=false;
	    	for(int diff=1;diff<=30;diff++){
	    		for(int opp=0;opp<=30;opp++){
	    			int selfScore=diff+opp;
	    			Team oppTeam=getTeam(oppName);
	    			oppTeam.selfScores.put(BERLAND.name,opp);
	    			oppTeam.oppScores.put(BERLAND.name,selfScore);
	    			BERLAND.selfScores.put(oppName,selfScore);
	    			BERLAND.oppScores.put(oppName,opp);
	    			if(getBerlandRanking()>=2){
	    				System.out.println(selfScore+":"+opp);
	    				bPossible=true;
	    				break;
	    			}
	    		}
	    		if(bPossible)
	    			break;
	    	}
	    	if(!bPossible)
	    		System.out.println("IMPOSSIBLE");
	    	
		    }catch(Exception e){
		    	e.printStackTrace(System.err);
		}
	}
}
