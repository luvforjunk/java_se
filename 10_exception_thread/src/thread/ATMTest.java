package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InaccessibleObjectException;
import java.text.DecimalFormat;

public class ATMTest implements Runnable {
	// Runnable이란 interface를 가졌다는 건 ATMTest가 Thread하고 싶다는 것
	private long depositeMoney = 100000; // 잔액
	private long balance; // 찾고자 하는 금액

	public static void main(String[] args) {
		ATMTest atm = new ATMTest();
		Thread mom = new Thread(atm, "엄마"); // 스레드 생성 - 아래 setName 대신 이름을 적어놓으면 된다
		Thread son = new Thread(atm, "아들"); // 스레드 생성

//		mom.setName("엄마"); // 스레드에 이름 명시
//		son.setName("아들");
		mom.start(); // 스레드 시작
		son.start(); // 스레드 시작
	}

	@Override
	public synchronized void run() {
		System.out.println("안녕하세요 " + Thread.currentThread().getName() + "님"); // 현재 실행중인 스레드 찍어라

		// Thread[엄마,5,main]
		// Thread[아들,5,main]
		// 안녕하세요 엄마님 ------ getName을 통해 이름만 꺼내올 때의 결과값
		// 안녕하세요 아들님

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("찾고자 하는 금액 입력 : ");
		// balance = Integer.parseInt(br.readLine()); ---error
		// balance는 long타입인데, 8바이트가 4바이트인 Integer.parseInt로 바뀌면 안되니,
		try {
			balance = Long.parseLong(br.readLine()); // Override 구역에선 throw 절대 안됨
		} catch (IOException e) { // IO가 NumberFormat Exception도 잡아버림
			e.printStackTrace();
		}

		// 잔액 계산
		if (depositeMoney > balance) {
			depositeMoney -= balance;
			System.out.println("잔액은 " + depositeMoney + "입니다");
		} else if (depositeMoney < balance) {
			System.out.println("잔액이 부족합니다.");
		} else if (depositeMoney % 10000 != 0) {
			System.out.println("만원 단위로 입력하세요");

		}
	}
}

// 엄마와 아들이 동시에 들어오면 찾고자 하는 금액 입력 : 찾고자 하는 금액 입력 : 
// 0.1초라도 먼저 들어오는 사람이 들어오게끔
// 겹치지 않게 synchronized를 걸어준다. 그 결과, 안녕하세요 엄마님 찾고자 하는 금액 입력 : 
