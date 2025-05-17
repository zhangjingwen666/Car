
package com.zlsl.excel;

import com.zlsl.dao.impl.RepairImpl;
import com.zlsl.javaBean.*;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.*;

import java.io.File;
import java.util.List;

/**
 *
 */
public class RepairExcel {

    public static void excelExport() throws Exception {
        File file = new File("D:\\repair.xls");
        if (!file.exists()) {//如果不存在则创建该文件
            file.getParentFile().mkdirs();
        }
        WritableWorkbook wb = Workbook.createWorkbook(file);//创建新工作簿
        WritableSheet wsheet = wb.createSheet("维修信息", 0);// 创建sheet表
        //设置表头
        String[] columnNames = {"id", "时间", "维修地址", "维修项目", "费用", "负责人工号","车辆ID"};
        WritableFont wFontTitle = new WritableFont(WritableFont.createFont("宋体"), 14);
        WritableCellFormat fontTitle = new WritableCellFormat(wFontTitle);
        fontTitle.setBackground(Colour.SKY_BLUE);//设置单元格背景色
        for (int i = 0; i < columnNames.length; i++) {
            wsheet.addCell(new Label(i, 0, columnNames[i], fontTitle));
        }
        //字体
        WritableFont wFont = new WritableFont(WritableFont.createFont("宋体"), 14);
        WritableCellFormat font = new WritableCellFormat(wFont);
        List<Repair> repairList = RepairImpl.selectAll();
        // 把数据写入工作部中
        for (int i = 0; i < repairList.size(); i++) {
            wsheet.addCell(new Label(0, i + 1, repairList.get(i).getId() +"", font));
            wsheet.addCell(new Label(1, i + 1, repairList.get(i).getDate_time(), font));
            wsheet.addCell(new Label(2, i + 1, repairList.get(i).getRepair_address(), font));
            wsheet.addCell(new Label(3, i + 1, repairList.get(i).getRepair_project() + "", font));
            wsheet.addCell(new Label(4, i + 1, repairList.get(i).getCost() +"",font));
            wsheet.addCell(new Label(5, i + 1, repairList.get(i).getResponsible(), font));
            wsheet.addCell(new Label(6, i + 1, repairList.get(i).getCar_id()+"", font));
        }
        wb.write();
        wb.close();
        System.out.println("输出完成！");
    }

}

