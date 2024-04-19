package br.com.kumulus.crud.controller;

import javax.inject.Named;

@Named
public class TemaBean {

	private String tema = "sunny";

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String[] getTemas() {
		return new String[] { "afterdark", "afternoon", "afterwork", "aristo",
				"black-tie", "blitzer", "bluesky", "bootstrap", "casablanca",
				"cupertino", "cruze", "dark-hive", "delta", "dot-luv",
				"eggplant", "excite-bike", "flick", "glass-x", "home",
				"hot-sneaks", "humanity", "le-frog", "midnight", "mint-choc",
				"overcast", "pepper-grinder", "redmond", "rocket", "sam",
				"smoothness", "south-street", "start", "sunny", "swanky-purse",
				"trontastic", "ui-darkness", "ui-lightness", "vader" };
	}

}