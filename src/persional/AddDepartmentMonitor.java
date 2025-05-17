package persional;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
     *
     */
    public class AddDepartmentMonitor implements ActionListener
{

        private JButton jButton1;
        private JButton jButton2;
        private JRadioButton jRadioButton1;
        private JTextField[] jTextFields;

        public AddDepartmentMonitor(JButton jButton1, JButton jButton2, JTextField[] jTextFields) {
            this.jButton1 = jButton1;
            this.jButton2 = jButton2;
            this.jTextFields = jTextFields;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jButton1) {//点击了提交按钮
                if (jTextFields[0].getText().isEmpty()) {//判断id是否为空
                    JOptionPane.showMessageDialog(jButton1,
                            "id不能为空！！！\n添加部门失败！！！", "消息提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Department department = DepartmentImpl.selectBySon(jTextFields[0].getText());
                if(department != null){
                    JOptionPane.showMessageDialog(jButton1,
                            "部门重复！\n添加部门失败！", "警告",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                //实例化department对象
                department = new Department(Integer.parseInt(jTextFields[0].getText()), jTextFields[1].getText(),
                        jTextFields[2].getText(), jTextFields[3].getText());
                String sql = "INSERT INTO t_department(id,name,manager_num," +
                        "telephone) VALUES (?,?,?,?)";
                DepartmentImpl.update(sql, department.getId(),department.getName(),department.getManager_num(),department.getTelephone());

                JOptionPane.showMessageDialog(jButton1, "添加部门成功！！！", "提示", JOptionPane.PLAIN_MESSAGE);
            } else {//点击了清除按钮
                for (JTextField jTextField : jTextFields) {
                    jTextField.setText("");
                }
            }
        }
}

