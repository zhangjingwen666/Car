package persional;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
     *
     */
    public class AddRepairMonitor implements ActionListener {

        private JButton jButton1;
        private JButton jButton2;
        private JTextField[] jTextFields;

        public AddRepairMonitor(JButton jButton1, JButton jButton2, JTextField[] jTextFields) {
            this.jButton1 = jButton1;
            this.jButton2 = jButton2;
            this.jTextFields = jTextFields;
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton1) {//点击了提交按钮
            if (jTextFields[0].getText().isEmpty()) {//判断id是否为空
                JOptionPane.showMessageDialog(jButton1,
                        "id不能为空！！！\n添加维修记录失败！！！", "消息提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Repairment2 repair= RepairImpl2.selectBySon(jTextFields[0].getText());
            if(repair != null){
                JOptionPane.showMessageDialog(jButton1,
                        "维修id重复！\n添加维修记录失败！", "警告",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
//            Temployee temployee= EmployeeImpl.selectBySon(jTextFields[5].getText());
//            if(temployee == null){
//                JOptionPane.showMessageDialog(jButton1,
//                        "该员工不存在！\n添加维修记录失败！", "警告",
//                        JOptionPane.WARNING_MESSAGE);
//                return;
//            }
//
//            Car car = CarImpl.selectBySon(jTextFields[6].getText());
//            if(car == null){
//                JOptionPane.showMessageDialog(jButton1,
//                        "车辆不存在！\n添加维修记录失败！", "警告",
//                        JOptionPane.WARNING_MESSAGE);
//                return;
//            }
//            //实例化对象
            repair = new Repairment2(Integer.parseInt(jTextFields[0].getText()),jTextFields[1].getText(),
                    jTextFields[2].getText(),jTextFields[3].getText(), Float.parseFloat(jTextFields[4].getText()),
                    jTextFields[5].getText(),Integer.parseInt(jTextFields[6].getText()));
            String sql = "INSERT INTO t_repair_record(id,date_time,repair_address," +
                    "repair_project,cost,responsible,car_id) VALUES (?,?,?,?,?,?,?)";
            RepairImpl2.update(sql, repair.getId(),repair.getDate_time(),repair.getRepair_address(),repair.getRepair_project(),
                    repair.getCost(),repair.getResponsible(),repair.getCar_id());
//            CarUi.initSelectAllRepair();//更新右侧表格数据
            JOptionPane.showMessageDialog(jButton1, "添加维修记录成功！！！", "提示", JOptionPane.PLAIN_MESSAGE);
        } else {//点击了清除按钮
            for (JTextField jTextField : jTextFields) {
                jTextField.setText("");
            }
        }
    }
}


