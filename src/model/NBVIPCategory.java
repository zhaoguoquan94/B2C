package model;
import model.*;
public class NBVIPCategory {
	public NBVIPCategory(){}
	private int  ID;
	private String levelName;
	private int leastScore;
	private double scorePercentage;
	/**
	 * @return the levelName
	 */
	public String getLevelName() {
		return levelName;
	}
	public NBVIPCategory(int iD, String levelName, int leastScore,
			double scorePercentage) {
		super();
		ID = iD;
		this.levelName = levelName;
		this.leastScore = leastScore;
		this.scorePercentage = scorePercentage;
	}
	/**
	 * @param levelName the levelName to set
	 */
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	/**
	 * @return the leastScore
	 */
	public int getLeastScore() {
		return leastScore;
	}
	/**
	 * @param leastScore the leastScore to set
	 */
	public void setLeastScore(int leastScore) {
		this.leastScore = leastScore;
	}
	/**
	 * @return the scorePercentage
	 */
	public double getScorePercentage() {
		return scorePercentage;
	}
	/**
	 * @param scorePercentage the scorePercentage to set
	 */
	public void setScorePercentage(double scorePercentage) {
		this.scorePercentage = scorePercentage;
	}




}