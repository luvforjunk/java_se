package swing;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

class JTableModel extends AbstractTableModel { // AbstractTableModel는 추상클래스
//	Object[][] data = {{"Nari","마루치",new Integer(1234), "옆집친구"},
//					   {"One","오윤아",new Integer(1111),"예쁜이"},
//			  		   {"tow","오윤서",new Integer(2222),"귀염둥이"},
//					   {"three","아라치",new Integer(3333),"동아리 친구"}};

	// new Integer(1234)

	// JDK 9부터는 Wrapper Class의 생성자가 사라지고 AutoBoxing
	// 기본형을 써도 Object인 객체타입으로 들어간다. 자동으로 Integer되어서 들어간다는 의미
	Object[][] data = { { "Nari", "마루치", 1234, "옆집친구" }, { "One", "오윤아", 1111, "예쁜이" }, { "two", "오윤서", 2222, "귀염둥이" },
			{ "three", "아라치", 3333, "동아리 친구" } };
	// 자동으로 new Integer역할을 하는 AutoBoxing처리를 해준다
	// JDK 9부터는 Wrapper Class의 생성자가 사라지고 AutoBoxing

	String[] name = { "아이디", "이름", "비밀번호", "구분" }; // 필드명 - Column

	// 추상메소드를 Override해서 써라
	@Override
	public int getRowCount() { // 행의 개수
		return data.length;
	}

	@Override
	public int getColumnCount() { // 열의 개수
		return name.length;
	}

	@Override
	public Object getValueAt(int r, int c) { // 행의 위치, 열의 위치.
		return data[r][c];
	}

	@Override
	public void setValueAt(Object ob, int r, int c) { // 값을 넣어주는 것
		// 행의 위치, 열의 위치
		data[r][c] = ob; // 데이터 r행 c열에 ob값을 넣어라
	}

	@Override // 추상메소드 아님
	public String getColumnName(int c) {// 필드명(제목) - {"아이디","이름","비밀번호","구분"}
		return name[c];
	}

	@Override
	public boolean isCellEditable(int r, int c) {// 더블클릭하면 편집 가능하게끔
		// return true; - 전부 수정하라
		// 조건 ? 참 : 거짓;
		return c == 0 ? false : true;
		// 나는 0번째 Column인 아이디만 고정시키고 싶고 나머지는 수정해도 상관없게 하고 싶어요
	}
}

//------------------
public class JTableEx extends JFrame {
	JTable table; // 보여주는 역할
	JTableModel model; // 값을 넣고 빼는 역할

	public JTableEx() {
		model = new JTableModel();
		table = new JTable(model); // 모델하고 연결합시다
		JScrollPane scroll = new JScrollPane(table);

		add(scroll);

		this.setBounds(900, 100, 300, 300);
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JTableEx();

	}

}
