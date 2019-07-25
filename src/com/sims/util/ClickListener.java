package com.sims.util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String ObjButtons[] = {"Đồng ý","Hủy"};
        int PromptResult = JOptionPane.showOptionDialog(null,"Bạn có chắc chắn muốn thoát chương trình không?","QUẢN LÝ SINH VIÊN",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
        if(PromptResult==JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }
}
