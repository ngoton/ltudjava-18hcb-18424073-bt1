package com.sims.util;

import javax.swing.*;

public class ClickListener {
    public void exitClick() {
        String ObjButtons[] = {"Đồng ý","Hủy"};
        int PromptResult = JOptionPane.showOptionDialog(null,"Bạn có chắc chắn muốn thoát chương trình không?","QUẢN LÝ SINH VIÊN",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
        if(PromptResult==JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }
}
