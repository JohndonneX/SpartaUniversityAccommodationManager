package com.sparta.panda.uos_manager.common.utilities;

import com.sparta.panda.uos_manager.common.entities.Admin;
import com.sparta.panda.uos_manager.common.entities.Resident;
import com.sparta.panda.uos_manager.common.repositories.ResidentNoticeRepository;
import com.sparta.panda.uos_manager.common.repositories.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CurrentUser {


    // used for testing only
    public static Resident resident = new Resident();
    public static Admin admin = new Admin();

    static {
        resident.setResidentId(2);
        resident.setRole("mod"); // mod status
        admin.setAdminId(1);
    }


    public static Resident getResident() {
        return resident;
    }

    public static void setResident(Resident resident) {
        CurrentUser.resident = resident;
    }

    public static Admin getAdmin() {
        return admin;
    }

    public static void setAdmin(Admin admin) {
        CurrentUser.admin = admin;
    }


}
