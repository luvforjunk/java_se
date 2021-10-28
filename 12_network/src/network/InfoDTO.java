package network;

enum Info { // 한 줄. 한 객체.
	JOIN, EXIT, SEND
}

public class InfoDTO {
	private String nickName;
	private String message;
	private Info command;
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Info getCommand() {
		return command;
	}
	public void setCommand(Info command) {
		this.command = command;
	}
}
// 네트워크를 오고 가는 것이 문자열이 아니라 InfoDTO단위로 움직여준다.
// 이런 게 왜 필요한데요?
// 똑같은 그림이 그려져서 서버가 받아서 체크해준다
// 그림이 서버에 넘겨주는 것은 뭐뭐 ? 위치, 색깔, 이름 등등
// 이 넘겨주는 걸 객체로 묶어서 넘겨줘야 한다. 하나하나 넘겨주는 것이 아니라
