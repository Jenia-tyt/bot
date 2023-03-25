package com.jeniatyt.bot.service.draw.impl;

import com.jeniatyt.bot.model.dto.CompanyMessageDto;
import com.jeniatyt.bot.service.draw.iface.DrawService;
import lombok.extern.slf4j.Slf4j;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Service
public class DrawServiceImpl implements DrawService {
    @Value("${chart.width:640}")
    private int width;
    @Value("${chart.height:480}")
    private int height;
    
    @Override
    public InputFile draw(CompanyMessageDto dto) throws IOException {
        JFreeChart lineChartObject = ChartFactory.createLineChart(
            dto.getCompany().getName(),
            String.format("ВРЕМЯ, %s", dto.getStep().getDistance()),
            "СТОИМОСТЬ, рубль",
            createDataSet(dto.getCost()),
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );
    
        File lineChart = null;
        try {
            lineChart = File.createTempFile("Char", "Char");
            ChartUtils.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
        } catch (IOException e) {
            log.error("Ошибка при отрисовки график", e);
            throw new IOException("Ошибка при отрисовки график", e);
        }
        return new InputFile(lineChart);
    }
    
    private DefaultCategoryDataset createDataSet(double[] points) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for (int i = points.length - 1; i >= 0; i--) {
            dataset.addValue(points[i], "", String.valueOf(i));
        }
        
        return dataset;
    }
}
