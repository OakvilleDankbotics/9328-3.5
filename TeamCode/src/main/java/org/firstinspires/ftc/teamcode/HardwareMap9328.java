package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class HardwareMap9328 {
    public DcMotor leftTread;
    public DcMotor rightTread;
    public DcMotor clawWinch;
    public DcMotor claw;
    public int clawOpenPosition = 0;
    public int clawClosedPosition = 45;

    HardwareMap hwMapv2;
    private ElapsedTime period = new ElapsedTime();

    public HardwareMap9328() {
    }

    public void init(HardwareMap hwMap){
        hwMapv2 = hwMap;

        leftTread   = hwMapv2.get(DcMotor.class, "LeftTread");
        rightTread  = hwMapv2.get(DcMotor.class, "RightTread");
        rightTread.setDirection(DcMotor.Direction.REVERSE);
        clawWinch   = hwMapv2.get(DcMotor.class, "Winch");
        claw        = hwMapv2.get(DcMotor.class, "Claw");

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
