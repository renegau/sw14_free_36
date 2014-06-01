package com.example.beachvolleyassist;

import android.app.Application;

public class Settings extends Application {

	private String _teamBlueName    = "Team BLUE";
	private String _teamRedName     = "Team RED";
	
	private String _teamBluePlayer1 = "Player 1";
	private String _teamBluePlayer2 = "Player 2";
	
	private String _teamRedPlayer1  = "Player 1";
	private String _teamRedPlayer2  = "Player 2";
	
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
	
}

