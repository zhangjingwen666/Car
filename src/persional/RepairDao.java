package persional;


import java.util.List;
    public interface RepairDao {
        Integer update(String sql, Object... array);
        Repairment2 selectBySon(String sno);
        List<Repairment2> selectAll(); }