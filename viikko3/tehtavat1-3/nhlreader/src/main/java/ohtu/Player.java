
package ohtu;



public class Player {
    private String name;
    private String team;
    private int goals;
    private int assists;
    private String nationality;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    public void setTeam(String team) {
        this.team = team;
    }
    
    public String getTeam() {
        return team;
    }
    
    public void setAssists(int assists) {
        this.assists = assists;
    }
    
    public int getAssists() {
        return assists;
    }
    
    public void setGoals(int goals) {
        this.goals = goals;
    }
    
    public int getGoals() {
        return goals;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int namelength = 20 - name.length();
        sb.append(name);
        for (int i = 0; i < namelength; i++) {
            sb.append(" ");
        }
        sb.append(team);
        if (goals < 10) {
            sb.append("   ");
        }else {
            sb.append("  ");
        }
        sb.append(goals);
        sb.append(" +");
        if (assists < 10) {
            sb.append("  ");
        }else {
            sb.append(" ");
        }
        sb.append(assists);
        sb.append(" =");
        int points = goals + assists;
        if (points < 10) {
            sb.append("  ");
        }else {
            sb.append(" ");
        }
        sb.append(points);
        return sb.toString();
    }
      
}
