package com.example.beachvolleyassist;

import android.app.Application;

public class Settings extends Application {

	public static enum Team
	{
	  RED, BLUE
	}
	
	public static enum Player
	{
	  ONE, TWO
	}
	
	private String _teamBlueName    = "Team BLUE";
	private String _teamRedName     = "Team RED";
	
	private String _teamBluePlayer1 = "Player 1";
	private String _teamBluePlayer2 = "Player 2";
	
	private String _teamRedPlayer1  = "Player 1";
	private String _teamRedPlayer2  = "Player 2";
	
	private Team _firstServiceTeam;
	private Player _firstServicePlayerRed;
	private Player _firstServicePlayerBlue;
	private Team _beginningSideRight;
	private Team _beginningSideLeft;
	
	public void onCreate(){
        super.onCreate();
    }
	
	public void setTeamBlueName(String name) {
		this._teamBlueName = name;
	}
	
	public void setTeamRedName(String name) {
		this._teamRedName = name;
	}
	
	public void setTeamBluePlayer1(String name) {
		this._teamBluePlayer1 = name;
	}
	
	public void setTeamBluePlayer2(String name) {
		this._teamBluePlayer2 = name;
	}
	
	public void setTeamRedPlayer1(String name) {
		this._teamRedPlayer1 = name;
	}
	
	public void setTeamRedPlayer2(String name) {
		this._teamRedPlayer2 = name;
	}
	
	public void setFirstServiceTeam(Team team) {
		this._firstServiceTeam = team;
	}
	
	public void setFirstServicePlayerRed(Player player) {
		this._firstServicePlayerRed = player;
	}
	
	public void setFirstServicePlayerBlue(Player player) {
		this._firstServicePlayerBlue = player;
	}
	
	public void setBeginningSideLeft(Team team) {
		this._beginningSideLeft = team;
	}
	
	public void setBeginningSideRight(Team team) {
		this._beginningSideRight = team;
	}
	
	
	public String getTeamBlueName() {
		return this._teamBlueName;
	}
	
	public String getTeamRedName() {
		return this._teamRedName;
	}
	
	public String getTeamBluePlayer1() {
		return this._teamBluePlayer1;
	}
	
	public String getTeamBluePlayer2() {
		return this._teamBluePlayer2;
	}
	
	public String getTeamRedPlayer1() {
		return this._teamRedPlayer1;
	}
	
	public String getTeamRedPlayer2() {
		return this._teamRedPlayer2;
	}
	
	public Team getFirstServiceTeam() {
		return this._firstServiceTeam;
	}
	
	public Player getFirstServicePlayerRed() {
		return this._firstServicePlayerRed;
	}
	
	public Player getFirstServicePlayerBlue() {
		return this._firstServicePlayerBlue;
	}
	
	public Team getBeginningSideLeft() {
		return this._beginningSideLeft;
	}
	
	public Team getBeginningSideRight() {
		return this._beginningSideRight;
	}	
	
}

