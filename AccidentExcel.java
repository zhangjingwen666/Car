
package com.zlsl.excel;
import java.io.File;
import java.util.List;

import com.zlsl.dao.impl.AccidentImpl;
import com.zlsl.javaBean.Accident;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class AccidentExcel {




    public static void excelExport() throws Exception {
        File file = new File("D:\\accident.xls");
        if (!file.exists()) {//如果不存在则创建该文件
            file.getParentFile().mkdirs();
        }
        WritableWorkbook wb = Workbook.createWorkbook(file);//创建新工作簿
        WritableSheet wsheet = wb.createSheet("事故记录", 0);// 创建sheet表
        //设置表头
        String[] columnNames = {"id", "发生时间", "发生地点", "事故类型","严重等级","负责人工号","车辆ID"};
        WritableFont wFontTitle = new WritableFont(WritableFont.createFont("宋体"), 14);
        WritableCellFormat fontTitle = new WritableCellFormat(wFontTitle);
        fontTitle.setBackground(Colour.SKY_BLUE);//设置单元格背景色
        for (int i = 0; i < columnNames.length; i++) {
            wsheet.addCell(new Label(i, 0, columnNames[i], fontTitle));
        }
        //字体
        WritableFont wFont = new WritableFont(WritableFont.createFont("宋体"), 14);
        WritableCellFormat font = new WritableCellFormat(wFont);
        List<Accident> accidentList =AccidentImpl.selectAll();
        // 把数据写入工作部中
        for (int i = 0; i < accidentList.size(); i++) {
            wsheet.addCell(new Label(0, i + 1, accidentList.get(i).getId()+"", font));
            wsheet.addCell(new Label(1, i + 1, accidentList.get(i).getDate_time(), font));
            wsheet.addCell(new Label(2, i + 1, accidentList.get(i).getLocation(), font));
            wsheet.addCell(new Label(3, i + 1, accidentList.get(i).getAccident_type() , font));
            wsheet.addCell(new Label(4, i + 1, accidentList.get(i).getAccident_level() + "", font));

        }
        wb.write();
        wb.close();
        System.out.println("输出完成！");
    }

}
