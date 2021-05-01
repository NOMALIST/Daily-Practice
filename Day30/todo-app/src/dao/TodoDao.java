package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import utils.StringUtils;
import vo.Todo;

public class TodoDao {

	private List<Todo> db = new ArrayList<Todo>();

	/**
	 * 새 Todo을 db에 추가한다.
	 * @param todo 새 Todo
	 */
	public void insertTodo(Todo todo) {
		db.add(todo);
	}

	/**
	 * 모든 Todo 정보를 반환한다.
	 * @return Todo 리스트
	 */
	public List<Todo> getTodos() {
		return db;
	}

	/**
	 * 지정한 Todo 번호의 Todo 정보를 반환한다.
	 * @param no 일정번호
	 * @return Todo정보
	 */
	public Todo getTodoByNo(int no) {
		Todo finedTodo = null;
		for(Todo todo : db) {
			if(todo.getNo() == no) {
				finedTodo = todo;
				break;
			}
		}
		return finedTodo;
	}

	/**
	 * todos.csv에 기록된 Todo정보를 읽어서 db에 저장한다.
	 */
	public void loadData() {
		try{
			FileReader fr = new FileReader("src/todos.csv");
			BufferedReader reader = new BufferedReader(fr);

			String input;
			while((input = reader.readLine()) != null) {
				String[] items = input.split(",");

				Todo todo = new Todo();
				
				todo.setNo(StringUtils.stringToInt(items[0]));
				todo.setTitle(items[1]);
				todo.setWriter(items[2]);
				todo.setDay(StringUtils.stringToDate(items[3]));
				todo.setStatus(items[4]);
				todo.setText(items[5]);
				Date createDate = StringUtils.stringToDate(items[6]);
				Date completeDate = StringUtils.stringToDate(items[7]);
				Date deleteDate = StringUtils.stringToDate(items[8]);
				todo.setCreatedDate(createDate);
				todo.setCompletedDate(completeDate);
				todo.setDeletedDate(deleteDate);
				
				db.add(todo);
				
			}
			reader.close();
			fr.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * db에 저장된 Todo 정보를 totos.csv 파일에 저장한다.
	 */
	public void saveData() {

		try(PrintWriter writer = new PrintWriter("src/todos.csv")) {

			for(Todo todo: db) {
				StringBuilder sb = new StringBuilder();
				sb.append(String.valueOf(todo.getNo()) + ",")
				.append(todo.getTitle() + ",")
				.append(todo.getWriter() + ",")
				.append(StringUtils.dateToString(todo.getDay()) + ",")
				.append(todo.getStatus() + ",")
				.append(todo.getText() + ",")
				.append(StringUtils.dateToString(todo.getCreatedDate()) + ",")
				.append(StringUtils.dateToString(todo.getCompletedDate()) + ",")
				.append(StringUtils.dateToString(todo.getDeletedDate()));

				String text = sb.toString();

				writer.println(text);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
