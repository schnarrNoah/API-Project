package FPA3;

public class Main
{
	//static String responseStr = "{  \"id\": \"chatcmpl-8YUYUJnjMSq1mhsNN6A3BZ8yrnJqX\",  \"object\": \"chat.completion\",  \"created\": 1703231298,  \"model\": \"gpt-3.5-turbo-0613\",  \"choices\": [    {      \"index\": 0,      \"message\": {        \"role\": \"assistant\",        \"content\": \"Wahrscheinlichkeit: 100%\\n\\nEinschätzung: Diese E-Mail kann mit ziemlicher Sicherheit als Phishing eingestuft werden. Der beleidigende Ton und die ungewöhnliche Anrede sind typische Anzeichen dafür. Es ist wichtig, solche E-Mails zu ignorieren und keinesfalls auf sie zu antworten oder auf enthaltene Links oder Anhänge zu klicken.\"      },      \"logprobs\": null,      \"finish_reason\": \"stop\"    }  ],  \"usage\": {    \"prompt_tokens\": 58,    \"completion_tokens\": 91,    \"total_tokens\": 149  },  \"system_fingerprint\": null}";
	public static void main(String[] args)
	{
		new ControllerClass();		
		//Response r = new Response(responseStr);
	}
}