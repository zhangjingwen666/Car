package persional;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class a {
        public static void main(String[] args) {
            // 初始化数据库连接（仅显示提示）
            System.out.println("初始化数据库连接...");

            // ---------------------- 测试部门功能 ----------------------
            System.out.println("\n=== 测试部门功能 ===");

            // 1. 添加部门
            System.out.println("\n测试添加部门：");
            JTextField[] deptFields = new JTextField[4];
            for (int i = 0; i < deptFields.length; i++) deptFields[i] = new JTextField();
            deptFields[0].setText("10011");   // ID
            deptFields[1].setText("技术部");  // 名称
            deptFields[2].setText("M001");   // 主管工号
            deptFields[3].setText("010-12345678"); // 电话

            JButton submitDeptButton = new JButton();
            AddDepartmentMonitor deptMonitor = new AddDepartmentMonitor(
                    submitDeptButton, new JButton(), deptFields
            );
            deptMonitor.actionPerformed(new ActionEvent(submitDeptButton, ActionEvent.ACTION_PERFORMED, "提交"));
            System.out.println("已尝试添加部门：技术部");

            // 验证添加结果
            Department dept = DepartmentImpl.selectBySon("10011");
            System.out.println("查询部门ID=1001: " + (dept != null ? dept.getName() : "不存在"));

            // 2. 更新部门
            System.out.println("\n测试更新部门：");
            JTextField[] updateDeptFields = new JTextField[4];
            for (int i = 0; i < updateDeptFields.length; i++) updateDeptFields[i] = new JTextField();
            updateDeptFields[0].setText("10011"); // 查询ID
            JButton queryDeptButton = new JButton();
            UpdateDepartment updateDept = new UpdateDepartment(
                    queryDeptButton, new JButton(), new JButton(), new JButton(), updateDeptFields
            );
            // 模拟查询并更新
            updateDept.actionPerformed(new ActionEvent(queryDeptButton, ActionEvent.ACTION_PERFORMED, "查询"));
            updateDeptFields[1].setText("技术研发部"); // 修改名称
            JButton updateSubmitButton = new JButton();
            updateDept.actionPerformed(new ActionEvent(updateSubmitButton, ActionEvent.ACTION_PERFORMED, "提交"));
            System.out.println("已尝试更新部门名称");

            // 验证更新结果
            Department updatedDept = DepartmentImpl.selectBySon("1001");
            System.out.println("更新后的部门名称: " + (updatedDept != null ? updatedDept.getName() : "未找到"));

            // ---------------------- 测试维修记录功能 ----------------------
            System.out.println("\n=== 测试维修记录功能 ===");

            // 1. 添加维修记录
            System.out.println("\n测试添加维修记录：");
            JTextField[] repairFields = new JTextField[7];
            for (int i = 0; i < repairFields.length; i++) repairFields[i] = new JTextField();
            repairFields[0].setText("2001");         // ID
            repairFields[1].setText("2023-10-01");   // 日期
            repairFields[2].setText("北京维修中心");   // 地址
            repairFields[3].setText("更换发动机");     // 项目
            repairFields[4].setText("5000.0");       // 费用

            JButton submitRepairButton = new JButton();
            AddRepairMonitor repairMonitor = new AddRepairMonitor(
                    submitRepairButton, new JButton(), repairFields
            );
            repairMonitor.actionPerformed(new ActionEvent(submitRepairButton, ActionEvent.ACTION_PERFORMED, "提交"));
            System.out.println("已尝试添加维修记录：更换发动机");

            // 验证添加结果
            Repairment2 repair = RepairImpl2.selectBySon("2001");
            System.out.println("查询维修ID=2001: " + (repair != null ? repair.getRepair_project() : "不存在"));

            // 2. 更新维修记录
            System.out.println("\n测试更新维修记录：");
            JTextField[] updateRepairFields = new JTextField[7];
            for (int i = 0; i < updateRepairFields.length; i++) updateRepairFields[i] = new JTextField();
            updateRepairFields[0].setText("2001"); // 查询ID
            JButton queryRepairButton = new JButton();
            UpdateRepair updateRepair = new UpdateRepair(
                    queryRepairButton, new JButton(), new JButton(), new JButton(), updateRepairFields
            );
            // 模拟查询并更新
            updateRepair.actionPerformed(new ActionEvent(queryRepairButton, ActionEvent.ACTION_PERFORMED, "查询"));
            updateRepairFields[3].setText("更换变速箱"); // 修改项目
            JButton updateRepairSubmitButton = new JButton();
            updateRepair.actionPerformed(new ActionEvent(updateRepairSubmitButton, ActionEvent.ACTION_PERFORMED, "提交"));
            System.out.println("已尝试更新维修项目");

            // 验证更新结果
            Repairment2 updatedRepair = RepairImpl2.selectBySon("2001");
            System.out.println("更新后的维修项目: " + (updatedRepair != null ? updatedRepair.getRepair_project() : "未找到"));

            // 最终提示
            System.out.println("\n=== 测试完成，请检查数据库确认数据持久化 ===");
        }






}


