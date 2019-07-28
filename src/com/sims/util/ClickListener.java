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

    public boolean deleteClick() {
        String ObjButtons[] = {"Đồng ý","Hủy"};
        int PromptResult = JOptionPane.showOptionDialog(null,"Bạn có chắc chắn muốn thực hiện không?","THÔNG BÁO",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
        if(PromptResult==JOptionPane.YES_OPTION)
        {
            return true;
        }
        return false;
    }

    public void showMessage(String message){
        JOptionPane.showMessageDialog(null, message, "THÔNG BÁO",
                JOptionPane.WARNING_MESSAGE);
    }
}
