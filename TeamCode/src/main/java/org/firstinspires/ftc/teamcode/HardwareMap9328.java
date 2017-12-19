package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
class HardwareMap9328 {
    DcMotor leftTread;
    DcMotor rightTread;
    DcMotor clawWinch;
    DcMotor claw;
    int clawOpenPosition = 0;
    int clawClosedPosition = 45;
    HardwareMap9328() {}
    void init(HardwareMap hwMap){
        leftTread   = hwMap.get(DcMotor.class, "LeftTread");
        rightTread  = hwMap.get(DcMotor.class, "RightTread");
        rightTread.setDirection(DcMotor.Direction.REVERSE);
        clawWinch   = hwMap.get(DcMotor.class, "Winch");
        claw        = hwMap.get(DcMotor.class, "Claw");
        leftTread.setPower(0);
        rightTread.setPower(0);
        claw.setPower(0);
        clawWinch.setPower(0);
        leftTread.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightTread.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        claw.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        clawWinch.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}