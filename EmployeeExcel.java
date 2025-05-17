
package com.zlsl.excel;

import com.zlsl.dao.impl.EmployeeImpll;
import com.zlsl.javaBean.*;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.*;

import java.io.File;
import java.util.List;


public class EmployeeExcel {

    public static void excelExport() throws Exception {
        File file = new File("D:\\employee.xls");
        if (!file.exists()) {//如果不存在则创建该文件
            file.getParentFile().mkdirs();
        }
        WritableWorkbook wb = Workbook.createWorkbook(file);//创建新工作簿
        WritableSheet wsheet = wb.createSheet("员工信息", 0);// 创建sheet表
        //设置表头
        String[] columnNames = {"id", "员工姓名", "身份证号", "电话号码", "职位", "工龄","部门id"};
        WritableFont wFontTitle = new WritableFont(WritableFont.createFont("宋体"), 14);
        WritableCellFormat fontTitle = new WritableCellFormat(wFontTitle);
        fontTitle.setBackground(Colour.SKY_BLUE);//设置单元格背景色
        for (int i = 0; i < columnNames.length; i++) {
            wsheet.addCell(new Label(i, 0, columnNames[i], fontTitle));
        }
        //字体
        WritableFont wFont = new WritableFont(WritableFont.createFont("宋体"), 14);
        WritableCellFormat font = new WritableCellFormat(wFont);
        List<Temployee> employeeList = EmployeeImpll.selectAll();
        // 把数据写入工作部中
        for (int i = 0; i < employeeList.size(); i++) {
            wsheet.addCell(new Label(0, i + 1, employeeList.get(i).getNumber(), font));
            wsheet.addCell(new Label(1, i + 1, employeeList.get(i).getName(), font));
            wsheet.addCell(new Label(2, i + 1, employeeList.get(i).getIDCard(), font));
            wsheet.addCell(new Label(3, i + 1, employeeList.get(i).getPhone() + "", font));
            wsheet.addCell(new Label(4, i + 1, employeeList.get(i).getPosition(), font));
            wsheet.addCell(new Label(5, i + 1, employeeList.get(i).getSeniority(), font));
            wsheet.addCell(new Label(6, i + 1, employeeList.get(i).getDep_id()+"", font));
        }
        wb.write();
        wb.close();
        System.out.println("输出完成！");
    }

}

