package com.jcs.batch.config;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jcs.batch.model.EmployeeDTO;
import com.jcs.batch.repository.EmployeeRepo;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.util.List;

@Component
public class ReportDownloadTasklet  implements Tasklet {
    
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        List<EmployeeDTO> all = employeeRepo.findAll();
        // Generate report using iText
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("report.pdf"));
        document.open();

        // Add report content using iText methods (headers, tables, etc.)
        Paragraph title = new Paragraph("Report Data");
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        PdfPTable table = new PdfPTable(8);
        table.addCell ("empId");
        table.addCell ("firstName");
        table.addCell ("lastName");
        table.addCell ("email");
        table.addCell ("phoneNo");
        table.addCell ("hireDate");
        table.addCell ("jobId");
        table.addCell ("salary");
        for (EmployeeDTO dto : all) {
            table.addCell(dto.getEmpId());
            table.addCell(dto.getFirstName());
            table.addCell(dto.getLastName());
            table.addCell(dto.getEmail());
            table.addCell(dto.getPhoneNo());
            table.addCell(dto.getHireDate());
            table.addCell(dto.getJobId());
            table.addCell(dto.getSalary());
        }
        document.add(table);

        document.close();

        return RepeatStatus.FINISHED;
    }
}
