
package com.zlsl.excel;
import com.zlsl.dao.impl.*;
import com.zlsl.javaBean.*;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.*;

import java.io.File;
import java.util.List;

import com.zlsl.dao.impl.DepartmentImpl;
import com.zlsl.javaBean.Departmentldy;

public class DepartmentExcel {




    public static void excelExport() throws Exception {
        File file = new File("D:\\department.xls");
        if (!file.exists()) {//如果不存在则创建该文件
            file.getParentFile().mkdirs();
        }
        WritableWorkbook wb = Workbook.createWorkbook(file);//创建新工作簿
        WritableSheet wsheet = wb.createSheet("部门信息", 0);// 创建sheet表
        //设置表头
        String[] columnNames = {"id", "部门名称", "主管人工号", "部门电话"};
        WritableFont wFontTitle = new WritableFont(WritableFont.createFont("宋体"), 14);
        WritableCellFormat fontTitle = new WritableCellFormat(wFontTitle);
        fontTitle.setBackground(Colour.SKY_BLUE);//设置单元格背景色
        for (int i = 0; i < columnNames.length; i++) {
            wsheet.addCell(new Label(i, 0, columnNames[i], fontTitle));
        }
        //字体
        WritableFont wFont = new WritableFont(WritableFont.createFont("宋体"), 14);
        WritableCellFormat font = new WritableCellFormat(wFont);
        List<Department> departmentList =DepartmentImpl.selectAll();
        // 把数据写入工作部中
        for (int i = 0; i < departmentList.size(); i++) {
            wsheet.addCell(new Label(0, i + 1, departmentList.get(i).getId()+"", font));
            wsheet.addCell(new Label(1, i + 1, departmentList.get(i).getName(), font));
            wsheet.addCell(new Label(2, i + 1, departmentList.get(i).getManager_num(), font));
            wsheet.addCell(new Label(3, i + 1, departmentList.get(i).getTelephone() + "", font));
        }
        wb.write();
        wb.close();
        System.out.println("输出完成！");
    }

}
