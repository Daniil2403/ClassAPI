import com.google.gson.annotations.SerializedName;

public class WordsErrors {
	@SerializedName("word")
	private String words;

	public String getWords() {
		return this.words;
	}
}