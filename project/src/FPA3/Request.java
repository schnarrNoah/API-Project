package FPA3;

public class Request
{
	String request = null;
	String introduction = "Check Nachricht auf Phishing. " + "Das Format deiner Antwort soll so aufgebaut sein: "
			+ "Gib Wahrscheinlichkeit in %, eine kurze und präzise Einschätzung (Nicht länger als 90 Wörter), "
			+ "warum die Nachricht auf Phishing deutet oder nicht. Achte darauf, "
			+ "dass keine sonstigen Zahlen in deiner Antwort sind! Die Nachricht lautet: ";
	String message = null;

	public Request(String message)
	{
		this.message = message;
		requestTransformator(introduction, message);
	}

	public void requestTransformator(String introduction, String message)
	{
		request = introduction + message;
		request = request.replace("\n", " ");
		request = request.replace("\t", " ");
		request = request.replace("\r", " ");
	}

	@Override
	public String toString()
	{
		return request;
	}

}
