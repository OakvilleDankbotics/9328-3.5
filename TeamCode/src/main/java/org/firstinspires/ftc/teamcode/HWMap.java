package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class HWMap {
    DcMotor leftDrive, rightDrive, clawWinch, claw;
    HWMap() {}
    void init(HardwareMap hwMap){
        leftDrive = hwMap.get(DcMotor.class,"leftDrive");
        rightDrive = hwMap.get(DcMotor.class,"rightDrive");
        clawWinch = hwMap.get(DcMotor.class,"clawWinch");
        claw = hwMap.get(DcMotor.class,"claw");
        clawWinch.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
    }
}
