package com.jcs.batch.listener;

import com.jcs.batch.model.EmployeeDTO;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.item.Chunk;

import java.util.List;

public class EmpWriterListener implements ItemWriteListener<EmployeeDTO> {
    @Override
    public void beforeWrite(Chunk<? extends EmployeeDTO> items) {
        System.out.println("Before Write:"+items);
    }

    @Override
    public void afterWrite(Chunk<? extends EmployeeDTO> items) {
        System.out.println("After Write:"+items);
    }

    @Override
    public void onWriteError(Exception exception, Chunk<? extends EmployeeDTO> items) {
        System.out.println("On Write Error:"+exception + "Items::"+items);
    }
//    @Override
//    public void beforeWrite(List<? extends EmployeeDTO> items) {
//        System.out.println("Before Write:"+items);
//    }
//
//    @Override
//    public void afterWrite(List<? extends EmployeeDTO> items) {
//        System.out.println("After Write:"+items);
//    }
//
//    @Override
//    public void onWriteError(Exception exception, List<? extends EmployeeDTO> items) {
//        System.out.println("On Write Error:"+exception + "Items::"+items);
//    }
}
