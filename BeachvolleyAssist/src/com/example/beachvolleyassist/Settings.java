package com.example.beachvolleyassist;

import android.app.Application;

public class Settings extends Application {

	private String _teamBlueName    = "Team BLUE";
	private String _teamRedName     = "Team RED";
	
	private String _teamBluePlayer1 = "Player 1";
	private String _teamBluePlayer2 = "Player 2";
	
	private String _teamRedPlayer1  = "Player 1";
	private String _teamRedPlayer2  = "Player 2";
	
	private boolean _service_red = false;
	private boolean _return_red = false;
	private boolean _leftside_red = false;
	private boolean _rightside_red = false;
	
	private boolean _service_player1_red = false;
	private boolean _service_player2_red = false;
	
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
	
	public void setServiceRed(boolean service) {
		this._service_red = service;
	}
	
	public void setReturnRed(boolean return_) {
		this._return_red = return_;
	}
	
	public void setLeftSideRed(boolean leftside) {
		this._leftside_red = leftside;
	}
	
	public void setRightSideRed(boolean rightside) {
		this._rightside_red = rightside;
	}
	
	public void setServicePlayer1_red(boolean service_1) {
		this._service_player1_red = service_1;
	}
	
	public void setServicePlayer2_red(boolean service_2) {
		this._service_player2_red = service_2;
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
	
	public boolean getServiceRed() {
		return this._service_red;
	}
	
	public boolean getReturnRed() {
		return this._return_red;
	}
	
	public boolean getLeftSideRed() {
		return this._leftside_red;
	}
	
	public boolean getRightSideRed() {
		return this._rightside_red;
	}
	
	public boolean getServicePlayer1_red() {
		return this._service_player1_red;
	}
	
	public boolean getServicePlayer2_red() {
		return this._service_player2_red;
	}
	
}

