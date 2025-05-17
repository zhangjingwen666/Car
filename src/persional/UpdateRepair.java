package persional;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    /**
     *
     */
    public class UpdateRepair implements ActionListener {

        private JButton jButton1;
        private JButton jButton2;
        private JButton jButton3;
        private JTextField[] jTextFields;
        public UpdateRepair(JButton jButton1, JButton jButton2,JButton jButton3, JButton jButton4, JTextField[] jTextFields) {
            this.jButton1 = jButton1;
            this.jButton2 = jButton2;
            this.jButton3 = jButton3;

            this.jTextFields = jTextFields;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jButton1) {//点击了查询按钮
                if (jTextFields[0].getText().isEmpty()) {//判断id是否为空
                    JOptionPane.showMessageDialog(jButton1,
                            "id不能为空！！！", "消息提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Repairment2 repair = RepairImpl2.selectBySon(jTextFields[0].getText());
                if (repair != null) {
                    //存在当前修复记录，则将信息带出
                    jTextFields[1].setText(repair.getDate_time());
                    jTextFields[2].setText(repair.getRepair_address() + "");
                    jTextFields[3].setText(repair.getRepair_project()+"");
                    jTextFields[4].setText(repair.getCost()+"");
                    jTextFields[5].setText(repair.getResponsible()+"");
                    jTextFields[6].setText(repair.getCar_id()+"");

                    return;//结束
                }
                //未查询到当前id
                JOptionPane.showMessageDialog(jButton1, "未查询到当前修复记录！！!",
                        "消息提示", JOptionPane.WARNING_MESSAGE);
            } else if (e.getSource() == jButton2) {//点击了清除按钮
                jTextFields[0].setText("");
            } else if (e.getSource() == jButton3) {//点击了提交按钮
                if (jTextFields[0].getText().isEmpty()) {//判断id是否为空
                    JOptionPane.showMessageDialog(jButton1,
                            "id不能为空！！！", "消息提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Repairment2 repair = RepairImpl2.selectBySon(jTextFields[0].getText());
                if (repair != null) {
                    if (!jTextFields[1].getText().equals("")) {
                        repair.setDate_time(jTextFields[1].getText());
                    }
                    if (!jTextFields[2].getText().equals("")) {
                        repair.setRepair_address(jTextFields[2].getText());
                    }
                    if (!jTextFields[3].getText().equals("")) {
                        repair.setRepair_project(jTextFields[3].getText());
                    }
                    if (!jTextFields[4].getText().equals("")) {
                        repair.setCost(Float.parseFloat(jTextFields[4].getText()));
                    }
                    if (!jTextFields[5].getText().equals("")) {
                        repair.setResponsible(jTextFields[5].getText());
                    }
                    if (!jTextFields[6].getText().equals("")) {
                        repair.setCar_id(Integer.parseInt(jTextFields[6].getText()));
                    }

//                    String sql = "UPDATE t_repair_record SET date_time=?," +
//                            "repair_address=?,repair_project=?,cost=?,responsible=?,car_id=? where " +
//                            "id = ?";
//                    RepairImpl2.update(sql,repair.getDate_time(),repair.getRepair_address(),repair.getRepair_project(),
//                            repair.getCost(),repair.getResponsible(),repair.getCar_id(), repair.getId());
//                    CarUizjw.initSelectAllRepair();//更新右侧表格数据
                    //提示
                    JOptionPane.showMessageDialog(jButton3, "修改信息成功！！！",
                            "提示", JOptionPane.PLAIN_MESSAGE);
                }else {
                    //未查询到此人
                    JOptionPane.showMessageDialog(jButton3, "未查询到当前修复记录！！！\n修改失败！！！",
                            "消息提示", JOptionPane.WARNING_MESSAGE);
                }
            } else {//点击了清除按钮
                for (int i = 1; i < jTextFields.length; i++) {
                    jTextFields[i].setText("");
                }
            }
        }
    }



