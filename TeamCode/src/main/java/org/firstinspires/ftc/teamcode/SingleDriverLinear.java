package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="9328: Linear Single Driver", group="9328")
public class SingleDriverLinear extends LinearOpMode {
    private HardwareMap9328 hwMap = new HardwareMap9328();
    private int clawOpenPosition = new HardwareMap9328().clawOpenPosition;
    private int clawClosedPosition = new HardwareMap9328().clawClosedPosition;
    private double leftStick, rightStick;
    private boolean clawState = false;
    @Override
    public void runOpMode() {

        hwMap.init(hardwareMap);
        waitForStart();

        hwMap.claw.setTargetPosition(45);
        while (opModeIsActive()) {

            leftStick   = gamepad1.left_stick_y;
            rightStick  = gamepad1.right_stick_y;

            hwMap.leftTread.setPower(leftStick);
            hwMap.rightTread.setPower(rightStick);

            if (gamepad1.dpad_up) {
                hwMap.clawWinch.setPower(0.75);
            } else if (gamepad1.dpad_down) {
                hwMap.clawWinch.setPower(-0.75);
            } else if (gamepad1.a & !clawState) {
                hwMap.claw.setTargetPosition(clawOpenPosition);
                clawState = true;
            } else if (gamepad1.a & clawState) {
                hwMap.claw.setTargetPosition(clawClosedPosition);
                clawState = false;
            } else {
                hwMap.clawWinch.setPower(0);
            }
        }
    }
}