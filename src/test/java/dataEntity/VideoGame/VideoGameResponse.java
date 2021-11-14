package dataEntity.VideoGame;

public class VideoGameResponse{
	private int reviewScore;
	private String releaseDate;
	private String name;
	private String rating;
	private int id;
	private String category;

	public VideoGameResponse(int id, String name, String releaseDate, int reviewScore, String category, String rating) {
		this.id = id;
		this.name = name;
		this.releaseDate = releaseDate;
		this.reviewScore = reviewScore;
		this.category = category;
		this.rating = rating;
	}

	public void setReviewScore(int reviewScore){
		this.reviewScore = reviewScore;
	}

	public int getReviewScore(){
		return reviewScore;
	}

	public void setReleaseDate(String releaseDate){
		this.releaseDate = releaseDate;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setRating(String rating){
		this.rating = rating;
	}

	public String getRating(){
		return rating;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	@Override
	public String toString() {
		return "VideoGameResponse{" +
				"reviewScore=" + reviewScore +
				", releaseDate='" + releaseDate + '\'' +
				", name='" + name + '\'' +
				", rating='" + rating + '\'' +
				", id=" + id +
				", category='" + category + '\'' +
				'}';
	}
}
