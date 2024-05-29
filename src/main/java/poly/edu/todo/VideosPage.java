package poly.edu.todo;

import java.util.ArrayList;
import java.util.List;

import edu.poly.model.Video;
import eu.poly.dao.VideoDao;

public class VideosPage {
	private List<Video> videos = new ArrayList<Video>();
	private VideoDao dao = new VideoDao();
	
	public List<Video> getVideos(){
		videos = dao.findAll();
		return videos;
	}
}
