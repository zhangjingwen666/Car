
package com.zlsl.excel;
import com.zlsl.dao.impl.*;
import com.zlsl.javaBean.*;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.*;

import java.io.File;
import java.util.List;

public class CallExcel {




    public static void excelExport() throws Exception {
        File file = new File("D:\\Call.xls");
        if (!file.exists()) {//如果不存在则创建该文件
            file.getParentFile().mkdirs();
        }
        WritableWorkbook wb = Workbook.createWorkbook(file);//创建新工作簿
        WritableSheet wsheet = wb.createSheet("车辆调用信息", 0);// 创建sheet表
        //设置表头
        String[] columnNames = {"id", "调用人工号", "调用车辆id", "调用时间", "是否归还"};
        WritableFont wFontTitle = new WritableFont(WritableFont.createFont("宋体"), 14);
        WritableCellFormat fontTitle = new WritableCellFormat(wFontTitle);
        fontTitle.setBackground(Colour.SKY_BLUE);//设置单元格背景色
        for (int i = 0; i < columnNames.length; i++) {
            wsheet.addCell(new Label(i, 0, columnNames[i], fontTitle));
        }
        //字体
        WritableFont wFont = new WritableFont(WritableFont.createFont("宋体"), 14);
        WritableCellFormat font = new WritableCellFormat(wFont);
        List<Call> callList = CallImpl.selectAll();
        // 把数据写入工作部中
        for (int i = 0; i < callList.size(); i++) {
            wsheet.addCell(new Label(0, i + 1, callList.get(i).getId()+"", font));
            wsheet.addCell(new Label(1, i + 1, callList.get(i).getResponsible(), font));
            wsheet.addCell(new Label(2, i + 1, callList.get(i).getCar_id()+ "", font));
            wsheet.addCell(new Label(3, i + 1, callList.get(i).getDate_time() + "", font));
            wsheet.addCell(new Label(4, i + 1, callList.get(i).getIs_return(), font));
          
        }
        wb.write();
        wb.close();
        System.out.println("输出完成！");
    }

}


