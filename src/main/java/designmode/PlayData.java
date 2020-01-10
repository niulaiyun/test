package designmode;
/**
 * @Author: Niu Lai Yun
 * @Description: 
 * @Date 2019年11月29日 下午4:45:04
 */

public class PlayData {

	private String videoName;
	private String playTime;
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getPlayTime() {
		return playTime;
	}
	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}
	@Override
	public String toString() {
		return "PlayData [videoName=" + videoName + ", playTime=" + playTime + "]";
	}
	public PlayData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PlayData(String videoName, String playTime) {
		super();
		this.videoName = videoName;
		this.playTime = playTime;
	}
	
}
