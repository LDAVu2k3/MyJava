package componentsEmployee;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import dao.EmployeeDAO;
import interfaces.IEvent;
import model.ModelEmployee;


public class TableEmployee extends JTable {
	public static DefaultTableModel tableModel;
	private EmployeeDAO dao = new EmployeeDAO();
	private int index = -1;
	
	
	
	private ArrayList<ModelEmployee> datas = new ArrayList<ModelEmployee>();

	public TableEmployee(Employee employee) {
		setModel(new DefaultTableModel(new Object[][] {}, new String[] { "MÃ NV", "HỌ VÀ TÊN", "NGÀY SINH", "GIỚI TÍNH",
				"VAI TRÒ", "MẬT KHẨU", "NGÀY T GIA","GHI CHÚ"

		}));
		tableModel = (DefaultTableModel) getModel();
		setRowHeight(40);
		getTableHeader().setReorderingAllowed(false);
		getTableHeader().setFont(new Font("SanSerif", Font.PLAIN, 15));
		getTableHeader().setForeground(Color.decode("#84817a"));
		setShowGrid(false);
		setShowHorizontalLines(true);

		setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {

				Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				table.setBorder(noFocusBorder);
				com.setForeground(new Color(102, 102, 102));
				if (isSelected) {
					com.setBackground(Color.decode("#d1ccc0"));
				} else {
					com.setBackground(new Color(255, 255, 255));
				}
				return com;
			}

		});
		IEvent<ArrayList<ModelEmployee>> a = this::OnModelEmployeeChanged;
		employee.ModelEmployeeChanged.subscribe(a);
	}

	public void OnModelEmployeeChanged(Object source, ArrayList<ModelEmployee> eventArgs) {
		datas = eventArgs;
		initData();
	}
	
	public void addRow(Object[] row) {
		tableModel.addRow(row);
	}
	
	private void initData() {
		tableModel.getDataVector().removeAllElements();
		for (ModelEmployee data : datas) {
			Object[] rows = new Object[10];
			rows[0] = data.getCodeEmployee();
			rows[1] = data.getName();	
			rows[2] = data.getDate();	
			if(data.isSex()) {
				rows[3] = "Nam";
			}else {
				rows[3] = "Nữ";
			}
			rows[4] = data.getRole();
			rows[5] = data.getPassword();
			rows[6] = data.getDateOpening();
			rows[7] = data.getNote();	
			addRow(rows);
		}
		
		
		
		
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	
	public ArrayList<ModelEmployee> getDatas() {
		return datas;
	}

	public void setDatas(ArrayList<ModelEmployee> datas) {
		this.datas = datas;
	}
	
	
}