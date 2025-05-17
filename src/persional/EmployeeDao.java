package persional;


import java.util.List;

public interface EmployeeDao { Integer update(String sql, Object... array);
Temployee selectBySon(String sno);
List<Temployee> selectAll1();
 
void selectAll(); 
}